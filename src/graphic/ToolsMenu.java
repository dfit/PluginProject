package graphic;
import java.awt.TextArea;

import javax.swing.JTextField;

import plugins.Plugin;

/**
 * 
 * @author David Fitoussi & Simon Decottignies
 *
 */
public class ToolsMenu extends Menu{

	private static final long serialVersionUID = -5024517551358910299L;
	JTextField text;
	public ToolsMenu(TextArea text) {
		super(text, "Tools");
	}

	@Override
	public Menu getInstanceOfMenu() {
		return this;
	}
	
	@Override
	public String getContentToDisplay(TextArea text, Plugin plug) {
		return plug.transform(text.getText());
	}


}
