import javax.swing.Timer;


public class TimerPlugin {
	PluginFinder plug;
	public TimerPlugin(PluginFinder plug) {
		// 1000 = delay
		new Timer(1000, plug).start();
		
	}
}
