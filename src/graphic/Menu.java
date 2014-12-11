package graphic;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import menuListener.PluginListener;
import plugins.Plugin;

/**
 * 
 * @author David Fitoussi & Simon Decottignies
 *
 */
public abstract class Menu extends JMenu implements Observer {

	private static final long serialVersionUID = 1149561262431378505L;
	TextArea text;

	public Menu(TextArea text, String label) {
		super(label);
		this.text = text;
	}

	/**
	 * Update the current menu bar by adding or suppressing the plugin from the
	 * menu
	 */
	@Override
	public void update(Observable plug, Object plugins) {
		JMenuItem item;
		removeAll();
		@SuppressWarnings("unchecked")
		ArrayList<Plugin> plugList = (ArrayList<Plugin>) plugins;
		for (Plugin pl : plugList) {
			item = new JMenuItem(pl.getLabel());
			item.addActionListener(new PluginListener(getInstanceOfMenu(), pl));
			add(item);
		}
	}

	/**
	 * 
	 * @return an instance of the sub menu
	 */
	public abstract Menu getInstanceOfMenu();

	/**
	 * 
	 * @param text
	 *            the area zone where the text is displayed
	 * @param plug
	 *            the plugin selected to be used
	 * @return the new string to be displayed in the area text
	 */
	public abstract String getContentToDisplay(TextArea text, Plugin plug);

	/**
	 * Modify the text contains by the area text
	 * 
	 * @param plug
	 *            the plugin selected to be used
	 */
	public void modifyDisplay(Plugin plug) {
		text.setText(getContentToDisplay(text, plug));
	}

}
