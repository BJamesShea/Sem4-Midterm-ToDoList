package com.keyin.todo;

import com.keyin.todo.model.User;
import com.keyin.todo.model.ToDoListManager;
import java.util.*;

public class Main {

    private Scanner scanner;
    private ToDoListManager toDoListManager;

    public Main(Scanner scanner) {
        this.scanner = scanner;
        this.toDoListManager = new ToDoListManager();
    }

    public void run() {
        System.out.println("\nWelcome to Brandon's ToDo List Manager!");
        System.out.println("-----------------------------------------");
        System.out.println("           WELCOME: ADMIN");
        System.out.println("-----------------------------------------");

        while (true) {
            displayMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 6) {
                System.out.println("\nThanks for using my app! Goodbye!");
                return;
            }

            userCliChoice(choice);
        }
    }

    private void displayMainMenu() {
        System.out.println("\nMAIN MENU:");
        System.out.println("----------");
        System.out.println("1. Add a User:");
        System.out.println("2. Remove a User:");
        System.out.println("3. Find a User:");
        System.out.println("4. View all Users:");
        System.out.println("5. Select a user and manage their tasks:");
        System.out.println("6. Exit program");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    private void userCliChoice(int choice) {
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                removeUser();
                break;
            case 3:
                findUser();
                break;
            case 4:
                viewAllUsers();
                break;
            case 5:
                selectUser();
                break;
            default:
                System.out.println("Invalid choice! Please enter a number between 1 and 6.");
        }
    }

    private void addUser() {
        System.out.println("Enter the name of the new user: ");
        String name = scanner.nextLine();
        User newUser = new User(name.toLowerCase());
        toDoListManager.addUser(newUser);
        System.out.println("User " + name + " has been added successfully.");
    }

    private void removeUser() {
        System.out.println("Enter the name of the user to remove: ");
        String name = scanner.nextLine();
        toDoListManager.removeUser(name);
        System.out.println("User " + name + " has been removed successfully.");
    }

    private void findUser() {
        System.out.println("Search for user: ");
        String name = scanner.nextLine();

        User foundUser = toDoListManager.findUserByName(name);

        if (foundUser != null) {
            System.out.println("User " + name + " found.");
        } else {
            System.out.println("User " + name + " not found.");
        }
    }

    private void viewAllUsers() {
        toDoListManager.displayAllUsers();
    }

    private void selectUser() {
        System.out.println("Enter the name of the user to manage their tasks: ");
        String name = scanner.nextLine();

        User selectedUser = toDoListManager.findUserByName(name);

        if (selectedUser != null) {
            System.out.println("User " + name + " selected!");
            manageUserTasks(selectedUser);
        } else {
            System.out.println("User not found.");
        }
    }

    private void manageUserTasks(User user) {
        while (true) {
            System.out.println("\nManaging tasks for: " + user.getName());
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int taskChoice = scanner.nextInt();
            scanner.nextLine();

            if (taskChoice == 5) {
                System.out.println("Returning to main menu...");
                break;
            }

            handleTaskChoice(taskChoice, user);
        }
    }

    private void handleTaskChoice(int choice, User user) {
        switch (choice) {
            case 1:
                System.out.println("Enter task description:");
                String description = scanner.nextLine();
                user.addTask(description);
                System.out.println("Task added successfully!");
                break;
            case 2:
                System.out.println("Enter task to mark as completed:");
                String completedTask = scanner.nextLine();
                boolean success = user.completeTask(completedTask);
                if (success) {
                    System.out.println("Task marked as completed!");
                } else {
                    System.out.println("Task not found or already completed.");
                }
                break;
            case 3:
                System.out.println("Current tasks for " + user.getName() + ":");
                user.viewTasks();
                break;
            case 4:
                System.out.println("Enter task to delete: ");
                String taskToDelete = scanner.nextLine();
                user.removeTask(taskToDelete);
                System.out.println("Task deleted successfully!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main app = new Main(scanner);
        app.run();
    }
}
