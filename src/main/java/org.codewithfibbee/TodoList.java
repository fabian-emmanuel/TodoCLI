package org.codewithfibbee;

import lombok.Data;

import java.util.List;

@Data
public class TodoList {
    List<String> todo;
    int listCounter  = 1;


    public TodoList(List<String> todo) {
        this.todo = todo;
    }

    public void addItemToList(String item) {
        String numberedItem = "(" + listCounter + ") " + item;
        todo.add(numberedItem);
        listCounter++;
    }

    public void removeItem( String item) {
        todo.remove(item);
    }

    public void markAsCompleted(String numToMark) {
        String toMarkAsCompleted = null;

        for (String s : this.todo) {
            if(s.contains(numToMark)) {
                toMarkAsCompleted = s;
            }
        }
        var positionOfToDoOnList = Integer.parseInt(numToMark) - 1;
        var markedTodo = this.markWithAsterisk(toMarkAsCompleted);
        this.todo.set(positionOfToDoOnList, markedTodo);

    }

    private String markWithAsterisk(String item) {
        return "*" + item;
    }
}
