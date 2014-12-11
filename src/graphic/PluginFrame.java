package graphic;

import java.awt.TextArea;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import pluginManager.PluginFinder;

public class PluginFrame extends JFrame {

	private static final long serialVersionUID = -1475586549623619649L;
	TextArea textArea;
	JMenuBar menuBar;
	JFrame frame;
	PluginFinder pf;
	ArrayList<Menu> menus;

	public PluginFrame(String path) {
		super("Plugin project");
		initializeFrame(path);
	}

	public void initializeFrame(String path) {
		initializeItem(path);
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initializeItem(String path) {
		textArea = new TextArea("", 5, 40, TextArea.SCROLLBARS_BOTH);
		menuBar = new JMenuBar();

		initializeObserver();

		pf = new PluginFinder(new File(path), menus);

		menuBar.add(new FileMenu(textArea));

		menuBar.add(menus.get(0));

		menuBar.add(menus.get(1));

		setJMenuBar(menuBar);

		add(textArea);
	}

	public void initializeObserver() {
		menus = new ArrayList<Menu>();
		menus.add(new ToolsMenu(textArea));
		menus.add(new HelpMenu(textArea));
	}
}
