import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left behind by nextInt()

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
        System.out.println("Thank you for using the ToDoList!");
        scanner.close();
    }

    private static void addTask() {
        System.out.println("Enter the task:");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks in the list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.println("Enter the number of the task to remove:");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline left behind by nextInt()

            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                String removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Task \"" + removedTask + "\" removed successfully.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
