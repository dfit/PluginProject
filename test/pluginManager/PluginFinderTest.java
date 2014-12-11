package pluginManager;

import static org.junit.Assert.*;
import graphic.HelpMenu;
import graphic.Menu;

import java.awt.TextArea;
import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import plugins.Plugin;

public class PluginFinderTest {

	PluginFinder pluginFinder;
	ArrayList <Menu> menus;
	
	@Before
	public void setUp() throws Exception {
		File dir = new File("bin/plugins");
		menus = new ArrayList <Menu>();
		menus.add(new HelpMenu(new TextArea()));
		pluginFinder = new PluginFinder(dir, menus);
	}

	@Test
	public void testAddObservers() {
		assertEquals(1, pluginFinder.countObservers());
		pluginFinder.deleteObservers();
		assertEquals(0, pluginFinder.countObservers());
		pluginFinder.addAllObserver(menus);
		assertEquals(1, pluginFinder.countObservers());
	}
	@Test
	public void testConvert() {
		ArrayList<Plugin> plugins;
		plugins=pluginFinder.convert();
		assertTrue(plugins.size()>0);
	}
	@Test
	public void testCheckChange() {
		assertFalse(pluginFinder.checkChange());
		pluginFinder.files=null;
		assertTrue(pluginFinder.checkChange());
	}
	@Test
	public void testClassFilesGoodDir() {
		assertTrue(pluginFinder.convert().size()>0);
	}
	@Test
	public void testClassFileBadDir() {
		pluginFinder = new PluginFinder(new File("bin/testFalse"), menus);
		assertTrue(pluginFinder.convert().size()==0);
	}
	@Test
	public void testRefreshingDuringLaunch() throws InterruptedException {
		int tmp = pluginFinder.files.length;
		assertTrue(tmp>0);
		PluginMover.move(new File("bin/plugins/ToLowerCase.class"), new File("bin/plugins/testMove/ToLowerCase.class"));
		new File("bin/plugins/ToLowerCase.class").delete();
		Thread.sleep(3000);
		assertTrue(tmp != pluginFinder.files.length);
		PluginMover.move(new File("bin/plugins/testMove/ToLowerCase.class"), new File("bin/plugins/ToLowerCase.class"));
		new File("bin/plugins/testMove/ToLowerCase.class").delete();
	}
}
