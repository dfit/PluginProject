package pluginManager;
import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {
	private final String PACKAGE_NAME = "plugins";
	Class<Plugin> plugin;
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

	protected boolean checkConstructor(Class<Plugin> plugin) {
		for (int i = 0; i < plugin.getConstructors().length; i++) {
			if (plugin.getConstructors()[i].getParameterCount() == 0) {
				return true;
			}
		}
		return false;
	}

	protected boolean checkInterface(Class<Plugin> plugin) {
		return Plugin.class.isAssignableFrom(plugin);
	}

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
