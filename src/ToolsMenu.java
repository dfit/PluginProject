import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import plugins.Plugin;


public class ToolsMenu extends JMenu implements Observer{

	private static final long serialVersionUID = -5024517551358910299L;
	JTextField text;
	@SuppressWarnings("deprecation")
	public ToolsMenu(JTextField text) {
		this.setLabel("Tools");
		this.text=text;
	}
	@Override
	public void update(Observable plug, Object plugins) {
		JMenuItem item;
		removeAll();
		@SuppressWarnings("unchecked")
		ArrayList<Plugin> plugList = (ArrayList<Plugin>) plugins;
		for(Plugin pl : plugList) {
			item = new JMenuItem(pl.getLabel());

			item.addActionListener(new PluginListener(this,pl));
			add(item);
		}
		
	}

	public void modifyDisplay(Plugin plug) {
		text.setText(plug.transform(text.getText()));
	}

}
