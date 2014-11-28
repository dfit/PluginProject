import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;


public class PluginFinder implements ActionListener{
	protected File[] files;
	protected File dir;
	
	public PluginFinder(File dir) {
		this.dir = dir;
		files = classFiles();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	public int nbChange(File[] files) {
		File[] tmpFiles = classFiles();
		int sizeTmp = files.length, cpt =0;
		for(int i=0;i<sizeTmp; i++) {
			for(int j=0;j<tmpFiles.length;j++) {
				if(files[i] == tmpFiles[j]){
					cpt++;
				}
			}
		}
		return Math.abs((sizeTmp-cpt));
	}
	public File[] classFiles() {
		FilenameFilter filter = new PluginFilter();
		return this.dir.listFiles(filter);
	}

}
