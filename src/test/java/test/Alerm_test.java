package test;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pages.JavaScriptAlerts;

public class Alerm_test extends BaseClass{
	@Test
	public void check()
	{
		JavaScriptAlerts jsa = new JavaScriptAlerts(driver);
		jsa.perform();
	}

}
