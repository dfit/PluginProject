import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Observable;


public class PluginFinder extends Observable implements ActionListener{
	protected File[] files;
	protected File dir;
	protected TimerPlugin timer;
	
	public PluginFinder(File dir, ToolsMenu tools) {
		this.dir = dir;
		files = classFiles();
		timer = new TimerPlugin(this);
		this.addObserver(tools);
		notifyObservers(files);
		setChanged();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("la");
		checkChange();
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
	public void rearrange(File[] files) {
		Comparator<File> comp = new FileComparator();
		Arrays.sort(files,comp);
	}
	public boolean checkChange() {
		if(Arrays.deepEquals(files, classFiles())) {
			System.out.println("ici");
			return false;
		}
		else {
			files = classFiles();
			notifyObservers(files);
			setChanged();
			return true;
		}
	}
	public File[] classFiles() {
		FilenameFilter filter = new PluginFilter();
		return this.dir.listFiles(filter);
	}

}
