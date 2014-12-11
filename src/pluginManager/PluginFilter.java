package pluginManager;
import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

/**
 * 
 * @author David Fitoussi & Simon Decottignies
 * 
 * Used to filter all the plugins contains in a specific folder
 *
 */
public class PluginFilter implements FilenameFilter {
	private final String PACKAGE_NAME = "plugins";
	Class<Plugin> plugin;
	
	/**
	 * Load the plugin named by filename, only if that plugin exists
	 * 
	 * @param filename name of the plugin
	 * @return plugin class
	 */
	@SuppressWarnings("unchecked")
	protected Class<Plugin> getClassFromFilename(String filename) {
		ClassLoader loader = new PluginLoader();
		try {
			plugin = (Class<Plugin>) loader.loadClass("plugins."
					+ filename.split("\\.")[0]);
		} catch (ClassNotFoundException e) {

		}
		return plugin;
	}

	/**
	 * Check if the plugin has an empty constructor
	 * @param plugin
	 * @return return true if the plugin contains an empty constructor, false otherwise
	 */
	protected boolean checkConstructor(Class<Plugin> plugin) {
		for (int i = 0; i < plugin.getConstructors().length; i++) {
			if (plugin.getConstructors()[i].getParameterCount() == 0) {
				return true;
			}
		}
		return false;
	}

    /**
     * Check if the plugin implements plugin interface	
     * 
     * @param plugin
     * @return
     */
	protected boolean checkInterface(Class<Plugin> plugin) {
		return Plugin.class.isAssignableFrom(plugin);
	}

	/**
	 * Return true if the file is a acceptable plugin or false if it isn't
	 */
	@Override
	public boolean accept(File path, String filename) {
		plugin = getClassFromFilename(filename);
		if (plugin != null && this.checkInterface(plugin)
				&& plugin.getPackage().getName().equals(PACKAGE_NAME)
				&& this.checkConstructor(plugin))
			return true;
		return false;
	}

}
