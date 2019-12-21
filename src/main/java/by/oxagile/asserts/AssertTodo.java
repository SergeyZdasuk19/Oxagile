package by.oxagile.asserts;

import by.oxagile.entity.TodoTO;
import by.oxagile.factory.TodoTOFactory;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static by.oxagile.locator.MainPageLoc.*;
import static by.oxagile.services.FinderEl.$findEls;
import static by.oxagile.services.WaitEl.$visibility;

@Log4j
public class AssertTodo implements MainPageAssert {

    @Override
    public AssertTodo assertAllRecords(List<TodoTO> actual) {
        List<TodoTO> expected = TodoTOFactory.build($findEls(liAllRecords));
        Assert.assertEquals(expected, actual, "List actual all records is not equal list expected all records");
        log.info("Lists of all records equal");
        return this;
    }

    @Override
    public AssertTodo assertActiveAmountRecords(List<TodoTO> records) {
        List<TodoTO> actual = records.stream().filter(n -> n.isStatusCompleted() == false).collect(Collectors.toList());
        int expected = Integer.parseInt($visibility(amountActiveRecords).getText());
        Assert.assertEquals(expected, actual.size(),
                "List size active records is not equal number of active records");
        log.info("Lists of active records equal");
        return this;
    }

    @Override
    public AssertTodo assertCompletedRecords(List<TodoTO> records) {
        List<TodoTO> actual = records.stream().filter(n -> n.isStatusCompleted() == true).collect(Collectors.toList());
        List<TodoTO> expected = TodoTOFactory.build($findEls(liCompletedRecords));
        Assert.assertEquals(actual, expected,
                "List actual completed records is not equal list expected completed records");
        log.info("Lists of completed records equal");
        return this;
    }

    @Override
    public AssertTodo assertAllRecordsAfterDelete(List<TodoTO> actual) {
        List<TodoTO> expected = TodoTOFactory.build($findEls(liAllRecords));
        Assert.assertNotEquals(actual, expected,
                "List actual all records equals list expected records after delete active record");
        log.info("Lists of all records not equal after delete ");
        return this;
    }

    @Override
    public AssertTodo assertAllRecordsAfterEdit(List<TodoTO> actual) {
        List<TodoTO> expected = TodoTOFactory.build($findEls(liAllRecords));
        Assert.assertEquals(actual, expected,
                "List actual all records not equals list expected records after edit active record");
        log.info("Lists of all records equal after edit ");
        return this;
    }
}
