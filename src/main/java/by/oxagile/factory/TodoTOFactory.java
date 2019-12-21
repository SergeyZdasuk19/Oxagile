package by.oxagile.factory;

import by.oxagile.entity.TodoTO;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TodoTOFactory {
    public static List<TodoTO> build(List<WebElement> webElementList) {
        List<TodoTO> todoTOS = new ArrayList<>();
        webElementList
                .stream()
                .filter(n -> n.getAttribute("class").contains("completed"))
                .forEach(n -> todoTOS.add(new TodoTO(true, n.getText())));
        webElementList
                .stream()
                .filter(n -> !n.getAttribute("class").contains("completed"))
                .forEach(n -> todoTOS.add(new TodoTO(n.getText())));
        return todoTOS;
    }

}
