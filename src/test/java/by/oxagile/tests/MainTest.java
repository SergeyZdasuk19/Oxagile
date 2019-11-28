package by.oxagile.tests;

import by.oxagile.pages.MainPage;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest extends Common {

    @Test(
            description = "Добавить записи",
            dataProvider = "C1AddRecords",
            dataProviderClass = DataProviders.class)
    public void addSomeRecords(List<String> records) {
        new MainPage()
                .addRecords(records)
                .assertAmountRecords(records);
    }

    @Test(
            description = "Показать активные записи",
            dataProvider = "C2DeleteRecord",
            dataProviderClass = DataProviders.class)
    public void showActiveRecords(List<String> records,
                                  int index) {
        new MainPage()
                .addRecords(records)
                .selectAll()
                .completeRecord(index)
                .selectActive()
                .assertActiveAmountRecords();
    }

    @Test(
            description = "Показать выполненные записи",
            dataProvider = "C2DeleteRecord",
            dataProviderClass = DataProviders.class)
    public void showCompletedRecords(List<String> records,
                                     int index) {
        MainPage mainPage = new MainPage();
        mainPage
                .addRecords(records)
                .selectAll();
        int amount = mainPage.getAmountAllRecords();
        mainPage
                .completeRecord(index)
                .selectCompleted()
                .assertCompletedAmountRecords(amount);
    }

    @Test(
            description = "Удаление записи",
            dataProvider = "C2DeleteRecord",
            dataProviderClass = DataProviders.class
    )
    public void deleteOneRecord(List<String> records,
                                int index) {
        MainPage mainPage = new MainPage();
        mainPage
                .addRecords(records)
                .selectAll();
        int amount = mainPage.getAmountAllRecords();
        mainPage
                .deleteRecord(index)
                .assertAmountRecordsAfterDeleteOneRecord(amount);
    }

    @Test(
            description = "Удаление выполненных записей",
            dataProvider = "C2DeleteRecord",
            dataProviderClass = DataProviders.class
    )
    public void deleteСompletedRecord(List<String> records,
                                      int index) {
        MainPage mainPage = new MainPage();
        mainPage
                .addRecords(records)
                .selectAll();
        mainPage
                .completeRecord(index)
                .selectCompleted()
                .clearCompletedRecords()
                .assertAmountRecordsAfterClear();
    }
}
