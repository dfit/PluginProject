package pluginManager;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class PluginFilterTest {
	
	PluginLoader pluginLoader;
	File dir;
	PluginFilter pluginFilter;
	String falseFileName, trueFileName, noExtensionFileName, extensionFileName, wrongPackageFilename, noEmptyConstructor;
	

	@Before
	public void setUp() throws Exception {
		pluginLoader = new PluginLoader();
		dir = new File("bin/plugins");
		pluginFilter = new PluginFilter();
		falseFileName = "falseFileName.class";
		trueFileName = "ToUpperCase.class";
		noExtensionFileName = "noExtensionFileName";
		extensionFileName = "ADotClassName.class";
		wrongPackageFilename = "TestPluginPackage.class";
		noEmptyConstructor = "TestNoEmptyConstructor.class";
	}

	@Test
	public void getPluginClassWithExistingFileTest() throws ClassNotFoundException {
		Class<?> classLoad = pluginLoader.loadClass("plugins.ToUpperCase");
		assertEquals(classLoad, pluginFilter.getClassFromFilename(trueFileName));
	}
	
	@Test
	public void checkEmptyConstructor() throws ClassNotFoundException {
		pluginFilter.getClassFromFilename(trueFileName);
		assertTrue(pluginFilter.checkConstructor());
	}
	
	@Test
	public void checkNoEmptyConstructor() {
		pluginFilter.getClassFromFilename(trueFileName);
	}

	@Test
	public void acceptWithAnExistingPluginTest() {
		assertTrue(pluginFilter.accept(dir, trueFileName));
	}

	@Test
	public void acceptWithANonDotClassFileNameTest() {
		assertFalse(pluginFilter.accept(dir, noExtensionFileName));
	}

	@Test
	public void acceptWithAPluginWrongPackageTest() {
		assertFalse(pluginFilter.accept(dir, wrongPackageFilename));
	}

	@Test
	public void acceptAFalseFile(){
		assertFalse(pluginFilter.accept(dir, falseFileName));
	}
}


