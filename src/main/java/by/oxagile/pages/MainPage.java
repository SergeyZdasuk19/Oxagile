package by.oxagile.pages;

import by.oxagile.driver.DriverSingleton;
import by.oxagile.entity.TodoTO;
import by.oxagile.exception.RecordException;
import by.oxagile.locator.MainPageLoc;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

import static by.oxagile.services.FinderEl.$findEls;
import static by.oxagile.services.WaitEl.*;

@Log4j
public class MainPage implements MainPageLoc {

    private MainPage() {

    }

    public static MainPage load() {
        Assert.assertEquals($visibility(header).getText(), "todos");
        log.info("Go to main page http://todomvc.com/examples/vanillajs/ ");
        return new MainPage();
    }

    public MainPage addRecord(TodoTO record) {
        Assert.assertTrue($visibility(inputTodo).isEnabled(), "input for add is not displayed");
        $visibility(inputTodo).sendKeys(record.getTodo());
        $visibility(inputTodo).sendKeys(Keys.ENTER);
        log.info("Add some record " + record.getTodo());
        return this;
    }

    public MainPage addRecords(List<TodoTO> recordsList) {
        recordsList.stream().forEach(n -> addRecord(n));
        return this;
    }

    public MainPage completeFirstRecord() {
        WebElement element = Objects.requireNonNull(
                $findEls(emptyCheckbox)
                        .stream()
                        .findFirst()
                        .orElseThrow(() -> new RecordException("Not found first record for complete")));
        element.click();
        log.info("First record " + element.getText() + " was completed");
        return this;
    }

    public MainPage completeAllRecord() {
        Assert.assertTrue($visibility(completeAllRecords).isEnabled(),
                "label for complete all record is not displayed");
        $visibility(completeAllRecords).click();
        log.info("All records were completed");
        return this;
    }

    public MainPage selectActive() {
        Assert.assertTrue($visibility(buttonActive).isEnabled(),
                "button active is not displayed");
        $visibility(buttonActive).click();
        Assert.assertTrue($selectButton(buttonActive),
                "button active is not selected");
        Assert.assertEquals($visibility(buttonActive).getAttribute("class"), "selected");
        log.info("Button Active is selected");
        return this;
    }

    public MainPage selectCompleted() {
        Assert.assertTrue($visibility(buttonCompleted).isEnabled(),
                "button completed is not displayed");
        $visibility(buttonCompleted).click();
        Assert.assertTrue($selectButton(buttonCompleted),
                "button completed is not selected");
        Assert.assertEquals($visibility(buttonCompleted).getAttribute("class"), "selected");
        return this;
    }

    public MainPage selectAll() {
        Assert.assertTrue($visibility(buttonAll).isEnabled(), "button all in not displayed");
        $visibility(buttonAll).click();
        Assert.assertTrue($selectButton(buttonAll),
                "button completed is not selected");
        log.info("Button All is selected");
        return this;
    }

    public MainPage deleteFirstRecord() {
        new Actions(DriverSingleton.getDriver())
                .moveToElement(
                        Objects.requireNonNull($findEls(liAllRecords)
                                .stream()
                                .findFirst()
                                .orElseThrow(() -> new RecordException("Not found first record for delete"))))
                .perform();
        $visibility(buttonDestroy).click();
        log.info("Delete first record");
        return this;
    }

    public MainPage editFirstRecord(List<TodoTO> newRecords) {
        new Actions(DriverSingleton.getDriver())
                .moveToElement(
                        Objects.requireNonNull($findEls(liAllRecords)
                                .stream()
                                .findFirst()
                                .orElseThrow(() -> new RecordException("Not found first record for edit"))))
                .doubleClick()
                .doubleClick()
                .sendKeys(
                        newRecords
                                .stream()
                                .findFirst()
                                .orElseThrow(() -> new RecordException("Not found first record for edit"))
                                .getTodo())
                .sendKeys(Keys.ENTER)
                .perform();
        log.info("Edit first record");
        return this;
    }

    public MainPage clearCompletedRecords() {
        Assert.assertTrue($visibility(buttonClearRecords).isEnabled(),
                "button is not displayed");
        $visibility(buttonClearRecords).click();
        log.info("Button Clear completed is selected");
        return this;
    }
}
