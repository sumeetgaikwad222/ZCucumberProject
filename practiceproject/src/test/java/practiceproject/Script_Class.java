package practiceproject;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class Script_Class extends BaseTest {

    @Test
    public void run() throws Exception {
        setup();
        Location_Class LC = new Location_Class(driver);
        LC.registration(firstname, lastname, username, password);
        teardown();
    }
}
