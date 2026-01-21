package test;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pages.UploadFile;

public class Upload_test extends BaseClass{
	@Test
	public void perform()
	{
		UploadFile up = new UploadFile(driver);
		up.perform();
	}
}
