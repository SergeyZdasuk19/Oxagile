package by.oxagile.services;

import by.oxagile.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FinderEl {
    public static List<WebElement> $findEls(String by) {
        return DriverSingleton.getDriver().findElements(By.cssSelector(by));
    }

}
