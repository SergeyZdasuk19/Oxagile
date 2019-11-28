package by.oxagile.tests;

import by.oxagile.driver.DriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class Common {
    @BeforeClass()
    public void setUp() {
        DriverSingleton.getDriver().get("http://todomvc.com/examples/vanillajs/");
    }

    @AfterClass()
    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

}
