package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pages.BasicAuth;

public class BasicAuth_test extends BaseClass{
	@Test
	public void check() throws AWTException, InterruptedException
	{
		BasicAuth ba = new BasicAuth(driver);
		ba.perform();
	}
}
