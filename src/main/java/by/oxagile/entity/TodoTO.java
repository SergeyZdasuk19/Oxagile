package by.oxagile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoTO {
    private boolean statusCompleted;
    private String todo;

    public TodoTO(String todo) {
        this.todo = todo;
        this.statusCompleted = false;
    }
}
