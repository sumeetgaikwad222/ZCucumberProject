package test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pages.Keypresses;

public class Keypress_test extends BaseClass{
	@Test
	public void perfor() throws AWTException, IOException
	{
		Keypresses ky = new Keypresses(driver);
		ky.write();
	}

}
