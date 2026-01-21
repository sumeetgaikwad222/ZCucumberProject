package test;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pages.Frames;

public class Frames_test extends BaseClass{
	@Test
	public void perform()
	{
		Frames fr = new Frames(driver);
		fr.nested();
	}
}
