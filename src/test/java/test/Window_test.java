package test;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pages.Windows;

public class Window_test extends BaseClass{
	@Test
	public void perform()
	{
		Windows win = new Windows(driver);
		win.perform();
	}

}
