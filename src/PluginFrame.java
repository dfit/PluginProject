import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

public class PluginFrame extends JFrame {

	private static final long serialVersionUID = -1475586549623619649L;
	ToolsMenu tm;
	JTextField tf;
	JMenuBar menuBar;
	JFrame frame;
	PluginFinder pf;

	public PluginFrame() {
		super("Plugin project");
		tf = new JTextField();
		menuBar = new JMenuBar();
		tm = new ToolsMenu(tf);
		pf = new PluginFinder(new File("bin/plugins"), tm);
		menuBar.add(new JMenu("File"));
		menuBar.add(tm);
		menuBar.add(new JMenu("Help"));
		setJMenuBar(menuBar);
		add(tf);
		this.setSize(300, 200);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
