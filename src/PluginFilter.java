import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;


public class PluginFilter implements FilenameFilter{
	Class<Plugin> plugins;
	@SuppressWarnings("unchecked")
	private Class<Plugin> getClassFromFilename(String filename) {
		ClassLoader loader = new PluginLoader();
		try {
			System.out.println(filename);
			plugins = (Class<Plugin>) loader.loadClass("plugins." + filename.split("\\.")[0]);
		} catch (ClassNotFoundException e) {

		}
		return plugins;
	}
	@Override
	public boolean accept(File path, String filename) {
		plugins = getClassFromFilename(filename);
		if(plugins != null) {
			System.out.println("lol");
			return true;
		} else {
			System.out.println("lol");
			return false;
		}
	}

}
