package by.oxagile.locator;

public interface MainPageLoc {
    String header = "header[class='header'] h1";
    String liAllRecords = "ul[class='todo-list'] li";
    String liCompletedRecords = "ul[class='todo-list'] li[class='completed']";

    String inputTodo = "input[class='new-todo']";
    String labelAllRecords = "ul[class='todo-list'] li label";
    String emptyCheckbox = "li[class=''] input[type='checkbox']";
    String amountActiveRecords = "span[class='todo-count'] strong";
    String buttonCompleted = "a[href$='completed']";
    String buttonAll = "ul[class='filters'] li a";
    String buttonDestroy = "button[class='destroy']";
    String buttonActive = "a[href$='active']";
    String buttonClearRecords = "button[class='clear-completed']";
    String completeAllRecords = "section[class='main'] label";
}
