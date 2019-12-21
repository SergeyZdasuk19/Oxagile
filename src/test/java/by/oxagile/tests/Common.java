package by.oxagile.tests;

import by.oxagile.driver.DriverSingleton;
import by.oxagile.pages.MainPage;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

@Log4j
public abstract class Common {
    @BeforeClass()
    public void setUp() {
        DriverSingleton.getDriver().get("http://todomvc.com/examples/vanillajs/");
    }

    @AfterClass()
    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    @AfterMethod()
    public void clearAllRecords() {
        MainPage.load()
                .selectAll()
                .completeAllRecord()
                .clearCompletedRecords();
        log.info("=====================================================");
    }
}
