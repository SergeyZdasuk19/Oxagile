package by.oxagile.asserts;

import by.oxagile.entity.TodoTO;

import java.util.List;

public interface MainPageAssert {
    AssertTodo assertAllRecords(List<TodoTO> actual);

    AssertTodo assertActiveAmountRecords(List<TodoTO> actual);

    AssertTodo assertCompletedRecords(List<TodoTO> actual);

    AssertTodo assertAllRecordsAfterDelete(List<TodoTO> actual);

    AssertTodo assertAllRecordsAfterEdit(List<TodoTO> actual);
}
