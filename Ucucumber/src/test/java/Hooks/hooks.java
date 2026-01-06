package Hooks;

import java.sql.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utiles.DriverFactory;

public class hooks {
	@Before
	public void setup()
	{
		DriverFactory.getbrowser();
	}
	@After
	public void teardown()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DriverFactory.closebrowser();
	}
}
