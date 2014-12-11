package pluginManager;
import graphic.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import plugins.Plugin;

/**
 * 
 * @author David Fitoussi & Simon Decottignies
 * 
 * Used to find the plugins in the specific directory
 *
 */
public class PluginFinder extends Observable implements ActionListener {
	protected File[] files;
	protected File dir;
	protected TimerPlugin timer;

	public PluginFinder(File dir, ArrayList<Menu> menus) {
		this.dir = dir;
		files = classFiles();
		timer = new TimerPlugin(this);
		addAllObserver(menus);
	}
	public void addAllObserver(ArrayList<Menu> menus) {
		for(Menu m : menus) this.addObserver(m);
		setChanged();
		notifyObservers(convert());
	}
	
	/**
	 * Perform a check of the current list of files to see if there is a change with the folder file of plugin
	 * every X seconds
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (checkChange()) {
			setChanged();
			notifyObservers(convert());
		}
	}

	/**
	 * Used to convert all the plugins files into a list of plugins instanciate
	 * @return arrayList<Plugin>
	 */
	@SuppressWarnings("unchecked")
	protected ArrayList<Plugin> convert() {
		ArrayList<Plugin> plugins = new ArrayList<Plugin>();
		Class<Plugin> plugin;
		ClassLoader loader = new PluginLoader();
		for (int i = 0; i < files.length; i++) {
			try {
				plugin = (Class<Plugin>) loader.loadClass("plugins."
						+ files[i].getName().split("\\.")[0]);
				plugins.add(plugin.newInstance());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {

			}
		}
		return plugins;
	}

	/**
	 * Check if there is a change in the file list
	 * @return true if there is a change, false otherwise
	 */
	public boolean checkChange() {
		if (Arrays.deepEquals(files, classFiles())) {
			return false;
		} else {
			files = classFiles();
			return true;
		}
	}
	/**
	 * Use a plugin filter to return a list of plugin in their files forms
	 * @return a tab of validated plugin files
	 */
	public File[] classFiles() {
		FilenameFilter filter = new PluginFilter();
		File[] tmp = dir.listFiles(filter);
		if( tmp == null) {
			return new File[0];
		}
		return tmp;
	}

}
