package by.oxagile.tests;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "C1AddRecords")
    public static Object[][] getSomeRecords() {
        List<String> listGoals = new ArrayList<>();
        listGoals.add("Autotest1");
        listGoals.add("Autotest2");
        listGoals.add("Autotest3");
        listGoals.add("Autotest4");
        listGoals.add("Autotest5");
        return new Object[][]{{
                listGoals
        }};
    }

    @DataProvider(name = "C2DeleteRecord")
    public static Object[][] getSomeRecordForDelete() {
        List<String> listGoals = new ArrayList<>();
        listGoals.add("Autotest1");
        listGoals.add("Autotest2");
        int index = 0;
        return new Object[][]{{
                listGoals,
                index
        }};
    }
}
