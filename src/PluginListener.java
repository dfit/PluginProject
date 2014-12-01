import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plugins.Plugin;


public class PluginListener implements ActionListener{
	Plugin plug;
	ToolsMenu tm;
	public PluginListener(ToolsMenu tm,Plugin plug) {
		this.plug = plug;
		this.tm = tm;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		tm.modifyDisplay(plug);
	}

}
