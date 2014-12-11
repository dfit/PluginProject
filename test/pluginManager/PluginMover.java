package pluginManager;

import java.io.File;

public class PluginMover {
	static void move(File source, File dest) {

		java.io.FileInputStream sourceFile = null;
		java.io.FileOutputStream destinationFile = null;
		try {
			dest.createNewFile();
			sourceFile = new java.io.FileInputStream(source);
			destinationFile = new java.io.FileOutputStream(dest);
			byte buffer[] = new byte[512 * 1024];
			int nbLecture;
			while ((nbLecture = sourceFile.read(buffer)) != -1) {
				destinationFile.write(buffer, 0, nbLecture);
			}
			sourceFile.close();
			destinationFile.close();
		} catch (java.io.FileNotFoundException f) {
		} catch (java.io.IOException e) {
		}
	}
}