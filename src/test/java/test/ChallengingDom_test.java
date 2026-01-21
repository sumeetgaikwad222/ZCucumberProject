package test;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pages.Challenging_dom;

public class ChallengingDom_test extends BaseClass{
	@Test
	public void check()
	{
		Challenging_dom ch = new Challenging_dom(driver);
		ch.perform();
	}
}
