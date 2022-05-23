package org.codewithfibbee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.codewithfibbee.FileUtil.writeToFile;

public class Main {
    static List<String> list = new ArrayList<>();

    static TodoList todoList = new TodoList(list);


    public static void main( String[] args ) {
        System.out.println( "=== The Todo CLI ===" );
        runProgram();
    }


    public static void runProgram() {

        Scanner scanner = new Scanner(System.in);

        label:
        while (true) {

            System.out.print("./todo-cli $ ");
            String command = scanner.next();

            switch (command) {
                case "-add": {
                    String item = scanner.nextLine();
                    todoList.addItemToList(item);
                    break;
                }
                case "-list":
                    todoList.todo.forEach(System.out::println);
                    break;
                case "-completed": {
                    String item = scanner.nextLine();
                    String[] chr = item.split("=");
                    String num = chr[1];
                    todoList.markAsCompleted(num);
                    break;
                }
                case "-end":
                    writeToFile(todoList.getTodo());
                    break label;

                case "-del": {
                    String numOfItem = scanner.next();
                    String[] chr = numOfItem.split("=");
                    String numOfItemOnList = chr[1];
                    String itemToRemove = null;
                    for (String todo : list) {
                        if (todo.contains(numOfItemOnList)) {
                            itemToRemove = todo;
                        }
                    }
                    todoList.removeItem(itemToRemove);
                    break;
                }
                default:
                    System.out.println("Invalid entry!");
                    break;
            }
        }

    }


}
