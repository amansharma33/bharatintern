import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoApp {

    // Task class to hold task details
    static class Task {
        String description;
        boolean isCompleted;

        Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[X] " : "[ ] ") + description;
        }
    }

    // List to hold tasks
    private static final List<Task> TASKS = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("\nTodo List App");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter command number: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    addTask(scanner);
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    markTaskAsComplete(scanner);
                    break;
                case "4":
                    deleteTask(scanner);
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (!command.equals("5"));

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        TASKS.add(new Task(description));
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (TASKS.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < TASKS.size(); i++) {
                System.out.println((i + 1) + ". " + TASKS.get(i));
            }
        }
    }

    private static void markTaskAsComplete(Scanner scanner) {
        viewTasks();
        if (!TASKS.isEmpty()) {
            System.out.print("Enter task number to mark as complete: ");
            int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;
            if (taskNumber >= 0 && taskNumber < TASKS.size()) {
                TASKS.get(taskNumber).isCompleted = true;
                System.out.println("Task marked as complete.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    private static void deleteTask(Scanner scanner) {
        viewTasks();
        if (!TASKS.isEmpty()) {
            System.out.print("Enter task number to delete: ");
            int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;
            if (taskNumber >= 0 && taskNumber < TASKS.size()) {
                TASKS.remove(taskNumber);
                System.out.println("Task deleted.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
