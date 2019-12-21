package by.oxagile.tests;

import by.oxagile.asserts.AssertTodo;
import by.oxagile.entity.TodoTO;
import by.oxagile.pages.MainPage;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest extends Common {

    @Test(
            description = "Проверить данные на точность посл добавления записи, " +
                    "соответствует ли число активных todo с числом items left",
            dataProvider = "C1",
            dataProviderClass = DataProviders.class)
    public void addSomeRecords(List<TodoTO> actual) {
        MainPage.load()
                .addRecords(actual)
                .selectActive();
        new AssertTodo()
                .assertAllRecords(actual)
                .assertActiveAmountRecords(actual);
    }

    @Test(
            description = "Проверить данные на точность после выполнения первой записи, " +
                    "соответствует ли число активных todo с числом items left",
            dataProvider = "C2",
            dataProviderClass = DataProviders.class)
    public void markFirstRecordWithStatusAllRecords(List<TodoTO> actual) {
        MainPage.load()
                .addRecords(actual)
                .selectAll()
                .completeFirstRecord();
        new AssertTodo()
                .assertAllRecords(actual)
                .assertActiveAmountRecords(actual);
    }

    @Test(
            description = "Проверить выполненные записи на точность",
            dataProvider = "C2",
            dataProviderClass = DataProviders.class)
    public void markFirstRecordWithStatusCompletedRecords(List<TodoTO> records) {
        MainPage.load()
                .addRecords(records)
                .selectAll()
                .completeFirstRecord()
                .selectCompleted();
        new AssertTodo().assertCompletedRecords(records);


    }

    @Test(
            description = "удаленение первой активной записи, проверить записи на точность после удаления",
            dataProvider = "C1",
            dataProviderClass = DataProviders.class
    )
    public void deleteFirstActiveRecord(List<TodoTO> records) {
        MainPage.load()
                .addRecords(records)
                .selectActive()
                .deleteFirstRecord();
        new AssertTodo().assertAllRecordsAfterDelete(records);
    }

    @Test(
            description = "удаленение первой выполненной записи, проверить записи на точность после удаления",
            dataProvider = "C2",
            dataProviderClass = DataProviders.class
    )
    public void deleteFirstCompletedRecord(List<TodoTO> records) {
        MainPage.load()
                .addRecords(records)
                .completeFirstRecord()
                .selectCompleted()
                .deleteFirstRecord()
                .selectAll();
        new AssertTodo().assertAllRecordsAfterDelete(records);
    }

    @Test(
            description = "редактирирование первой активной записи,проверить записи на точность после удаления",
            dataProvider = "C3",
            dataProviderClass = DataProviders.class
    )
    public void editFirstActiveRecord(List<TodoTO> oldRecords,
                                      List<TodoTO> newRecords) {
        MainPage.load()
                .addRecords(oldRecords)
                .editFirstRecord(newRecords);
        new AssertTodo().assertAllRecordsAfterEdit(newRecords);
    }

    @Test(
            description = "редактирирование первой выполненной записи,проверить записи на точность после удаления",
            dataProvider = "C4",
            dataProviderClass = DataProviders.class
    )
    public void editFirstCompletedRecord(List<TodoTO> oldRecords,
                                         List<TodoTO> newRecords) {
        MainPage.load()
                .addRecords(oldRecords)
                .completeFirstRecord()
                .selectAll()
                .editFirstRecord(newRecords);
        new AssertTodo().assertAllRecordsAfterEdit(newRecords);
    }
}
