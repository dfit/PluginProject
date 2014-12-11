package menuListener;

import graphic.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plugins.Plugin;

/**
 * 
 * @author David Fitoussi & Simon Decottignies
 *
 */
public class PluginListener implements ActionListener {
	Plugin plug;
	Menu m;

	public PluginListener(Menu m, Plugin plug) {
		this.plug = plug;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		m.modifyDisplay(plug);
	}

}
