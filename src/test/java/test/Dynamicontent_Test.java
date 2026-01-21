package test;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pages.Dynamicontent;

public class Dynamicontent_Test extends BaseClass{

	@Test
	public void perform()
	{
		Dynamicontent dy = new Dynamicontent(driver);
		dy.perform();
	}
}
