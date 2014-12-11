package graphic;

import java.awt.TextArea;
import java.util.Observable;

import javax.swing.JMenuItem;

import plugins.Plugin;

/**
 * 
 * @author David Fitoussi & Simon Decottignies
 *
 */
public class FileMenu extends Menu {

	private static final long serialVersionUID = 4226549349485785692L;
	JMenuItem item;

	public FileMenu(TextArea text) {
		super(text, "File");
		removeAll();
		item = new JMenuItem("exemple 1");
		add(item);
		item = new JMenuItem("exemple 2");
		add(item);
	}

	@Override
	public Menu getInstanceOfMenu() {
		return this;
	}

	@Override
	public String getContentToDisplay(TextArea text, Plugin plug) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Observable plug, Object plugins) {

	}

}
