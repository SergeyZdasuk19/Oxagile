package by.oxagile.tests;

import by.oxagile.entity.TodoTO;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataProviders {

    @DataProvider(name = "C1")
    public static Object[][] addActiveRecords() {
        return new Object[][]{{
                Arrays.asList(
                        new TodoTO("AutoTestOne"),
                        new TodoTO("AutoTestTwo"),
                        new TodoTO("AutoTestThree"),
                        new TodoTO("AutoTestFour"))
        }};
    }

    @DataProvider(name = "C2")
    public static Object[][] addActiveAndCompletedRecords() {
        return new Object[][]{{
                Arrays.asList(
                        new TodoTO(true, "AutoTestOne"),
                        new TodoTO("AutoTestTwo"),
                        new TodoTO("AutoTestThree"),
                        new TodoTO("AutoTestFour"))
        }};
    }

    @DataProvider(name = "C3")
    public static Object[][] editActiveRecord() {
        return new Object[][]{{
                Arrays.asList(
                        new TodoTO("AutoTestOne"),
                        new TodoTO("AutoTestTwo"),
                        new TodoTO("AutoTestThree"),
                        new TodoTO("AutoTestFour")),
                Arrays.asList(
                        new TodoTO("NewAutoOne"),
                        new TodoTO("AutoTestTwo"),
                        new TodoTO("AutoTestThree"),
                        new TodoTO("AutoTestFour"))
        }};
    }

    @DataProvider(name = "C4")
    public static Object[][] editCompletedRecord() {
        return new Object[][]{{
                Arrays.asList(
                        new TodoTO(true, "AutoTestOne"),
                        new TodoTO("AutoTestTwo"),
                        new TodoTO("AutoTestThree"),
                        new TodoTO("AutoTestFour")),
                Arrays.asList(
                        new TodoTO(true, "NewAutoOne"),
                        new TodoTO("AutoTestTwo"),
                        new TodoTO("AutoTestThree"),
                        new TodoTO("AutoTestFour"))
        }};
    }
}
