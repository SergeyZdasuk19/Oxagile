package by.oxagile.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class DriverSingleton {
    private static WebDriver driver;
    private static final String WEB_DRIVER = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_PATH = "src/main/resources/chromedriver.exe";

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}
