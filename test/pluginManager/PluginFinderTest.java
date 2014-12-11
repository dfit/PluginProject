package pluginManager;

import static org.junit.Assert.*;

import graphic.Menu;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PluginFinderTest {

	PluginFinder pluginFinder;
	
	@Before
	public void setUp() throws Exception {
		File dir = new File("test");
		ArrayList <Menu> menus = new ArrayList <Menu>();
		pluginFinder = new PluginFinder(dir, menus);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
