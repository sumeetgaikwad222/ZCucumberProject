package practice_package;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import practiceproject.TestListeners;
@Listeners(TestListeners.class)
public class Script_Class extends Base_Class {
	@Test
	public void run() throws IOException, InterruptedException {
		Base_Class BC = new Base_Class();
		BC.setup();
		Page_Class PC = new Page_Class(driver);
		PC.name(firstname);
		PC.email(email);
		PC.curraddress(currentaddress);
		PC.peradd(permanantaddress);
		Thread.sleep(3000);
		BC.close();
	}

}
