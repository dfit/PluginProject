package graphic;

import java.awt.TextArea;


import plugins.Plugin;


public class HelpMenu extends Menu{

	private static final long serialVersionUID = 3657408344928724805L;

	public HelpMenu(TextArea text) {
		super(text, "Help");
	}
	
	@Override
	public Menu getInstanceOfMenu() {
		return this;
	}
	@Override
	public String getContentToDisplay(TextArea text,Plugin plug) {
		return plug.helpMessage();
	}


}
