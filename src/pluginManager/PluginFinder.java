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
	
	@Override
	public void actionPerformed(ActionEvent action) {
		if (checkChange()) {
			setChanged();
			notifyObservers(convert());
		}
	}

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

	public boolean checkChange() {
		if (Arrays.deepEquals(files, classFiles())) {
			return false;
		} else {
			files = classFiles();
			return true;
		}
	}

	public File[] classFiles() {
		FilenameFilter filter = new PluginFilter();
		return dir.listFiles(filter);
	}

}
