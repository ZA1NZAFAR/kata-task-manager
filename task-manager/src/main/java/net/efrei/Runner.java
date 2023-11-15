package net.efrei;

import org.javatuples.Pair;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);

        TaskManager taskManager = new TaskManager();

        do {
            taskManager.printStack();
            System.out.println("Enter a command: ");
            input = scanner.nextLine();

            Pair<Character, String> parsedInput = taskManager.parse(input);

            switch (parsedInput.getValue0()) {
                case '+':
                    taskManager.add(parsedInput.getValue1());
                    break;
                case '-':
                    try {
                        taskManager.delete(Integer.parseInt(parsedInput.getValue1()));
                    } catch (Exception e) {
                        System.out.println("Element not found");
                    }
                    break;
                case 'x':
                    try {
                        taskManager.setStatusDone(Integer.parseInt(parsedInput.getValue1()));
                    } catch (Exception e) {
                        System.out.println("Element not found");
                    }
                    break;
                case 'o':
                    try {
                        taskManager.setStatusToDo(Integer.parseInt(parsedInput.getValue1()));
                    } catch (Exception e) {
                        System.out.println("Element not found");
                    }
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Unknown command");
            }
        } while (!input.equals("q"));
    }

}
