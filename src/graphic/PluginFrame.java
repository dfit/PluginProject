package graphic;
import java.awt.TextArea;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import pluginManager.PluginFinder;

public class PluginFrame extends JFrame {

	private static final long serialVersionUID = -1475586549623619649L;
	TextArea textArea;
	JMenuBar menuBar;
	JFrame frame;
	PluginFinder pf;
	ArrayList<Menu> menus;

	public PluginFrame() {
		super("Plugin project");
		textArea = new TextArea("",5, 40,TextArea.SCROLLBARS_BOTH);
		menuBar = new JMenuBar();
		
		initializeObserver();
		
		pf = new PluginFinder(new File("bin/plugins"), menus);
		
		menuBar.add(new JMenu("File"));
		
		menuBar.add(menus.get(0));
		
		menuBar.add(menus.get(1));
		
		setJMenuBar(menuBar);
		
		add(textArea);
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void initializeObserver() {
		menus = new ArrayList<Menu>();
		menus.add(new ToolsMenu(textArea));
		menus.add(new HelpMenu(textArea));
	}
}
