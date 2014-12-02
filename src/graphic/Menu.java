package graphic;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import menuListener.PluginListener;
import plugins.Plugin;

public abstract class Menu extends JMenu implements Observer{
	
	private static final long serialVersionUID = 1149561262431378505L;
	TextArea text;
	
	public Menu(TextArea text,String label) {
		super(label);
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
			item.addActionListener(new PluginListener(getInstanceOfMenu(), pl));
			add(item);
		}		
	}
	public abstract Menu getInstanceOfMenu();
	public abstract String getContentToDisplay(TextArea text,Plugin plug);
	
	public void modifyDisplay(Plugin plug) {
		text.setText(getContentToDisplay(text,plug));
	}
	
}
