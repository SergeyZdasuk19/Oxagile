package by.oxagile.pages;

import by.oxagile.driver.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static by.oxagile.services.WaitEl.$findEls;
import static by.oxagile.services.WaitEl.$visibility;

public class MainPage {
    private static final String inputTodos = "input[class='new-todo']";
    private static final String liAllRecords = "ul[class='todo-list'] li";
    private static final String liCompletedRecords = "ul[class='todo-list'] li[class='completed']";
    private static final String emptyCheckbox = "li[class=''] input[class='toggle']";
    private static final String buttonCompleted = "a[href$='completed']";
    private static final String buttonActive = "a[href$='active']";
    private static final String amountRecordsSection = "span[class='todo-count'] strong";
    private static final String buttonAll = "ul[class='filters'] li a";
    private static final String buttonnDestroy = "button[class='destroy']";
    private static final String buttonClearRecords = "button[class='clear-completed']";

    public MainPage addRecord(String record) {
        $visibility(inputTodos).sendKeys(record);
        $visibility(inputTodos).sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage addRecords(List<String> recordsList) {
        recordsList.stream().forEach(n -> addRecord(n));
        return this;
    }

    public MainPage completeRecord(int index) {
        $findEls(emptyCheckbox).get(index).click();
        return this;
    }

    public MainPage selectActive() {
        $visibility(buttonActive).click();
        return this;
    }

    public MainPage selectCompleted() {
        $visibility(buttonCompleted).click();
        return this;
    }

    public MainPage selectAll() {
        $visibility(buttonAll).click();
        return this;
    }

    public int getAmountAllRecords() {
        return $findEls(liAllRecords).size();
    }

    public MainPage deleteRecord(int index) {
        new Actions(DriverSingleton.getDriver())
                .moveToElement($findEls(liAllRecords).get(index))
                .perform();
        $visibility(buttonnDestroy).click();
        return this;
    }

    public MainPage clearCompletedRecords() {
        $visibility(buttonClearRecords).click();
        return this;
    }

    public MainPage assertAmountRecords(List<String> recordsList) {
        Assert.assertEquals($findEls(liAllRecords).size(), recordsList.size());
        return this;
    }

    public MainPage assertActiveAmountRecords() {
        Assert.assertEquals($findEls(liAllRecords).size(), getAmountAllRecords());
        return this;
    }

    public MainPage assertCompletedAmountRecords(int amountRecord) {
        Assert.assertEquals(amountRecord - Integer.parseInt($visibility(amountRecordsSection).getText()),
                $findEls(liCompletedRecords).size());
        return this;
    }

    public MainPage assertAmountRecordsAfterDeleteOneRecord(int amountRecord) {
        Assert.assertEquals(amountRecord - 1, Integer.parseInt($visibility(amountRecordsSection).getText()));
        return this;
    }

    public MainPage assertAmountRecordsAfterClear() {
        Assert.assertEquals($findEls(liCompletedRecords).size(), 0);
        return this;
    }
}
