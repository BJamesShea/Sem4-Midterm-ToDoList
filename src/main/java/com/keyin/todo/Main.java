package com.keyin.todo;

import com.keyin.todo.model.User;
import com.keyin.todo.model.ToDoListManager;

import java.util.*;

public class Main {


       private Scanner scanner;
       private ToDoListManager toDoListManager;

       public Main(Scanner scanner){
           this.scanner = scanner;
           this.toDoListManager = new ToDoListManager();
       }

       public void run(){
           while(true){
               System.out.println("\nWelcome to Brandon's ToDo List Manager!");
               System.out.println("-----------------------------------------");
               System.out.println("WELCOME: ADMIN");
               System.out.println("-----------------------------------------");
               System.out.println("1. Add a User!");
               System.out.println("2. Remove a User!");
               System.out.println("3. Find a User!");
               System.out.println("4. View all Users!");
               System.out.println("5. Select a user and manager their tasks!");
               System.out.println("6. Exit program");
               System.out.println("Enter your choice: ");
               int choice = scanner.nextInt();
               scanner.nextLine();

               if (choice == 6){
                   System.out.println("\nThanks for using my app! Goodbye!");
                   break;
               }

               userCliChoice(choice);
           }
       }

       private void userCliChoice(int choice){
           switch (choice){

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


           }
       }

       private void addUser(){
           System.out.println("Enter the name of the new user: ");
           String name = scanner.nextLine();
           User newUser = new User(name);
           toDoListManager.addUser(newUser);
           System.out.println("User " + name + " has been added successfully.");

       }

       private void removeUser(){
           System.out.println("Enter the name of the user to remove: ");
           String name = scanner.nextLine();
           toDoListManager.removeUser(name);
           System.out.println("User " + name + " has been removed successfully.");
       }

       private void findUser(){
        System.out.println("Search for user: ");
        String name = scanner.nextLine();

        User foundUser = toDoListManager.findUserByName(name);

        if(foundUser != null){
            System.out.println("User " + name + " found.");
        } else {
            System.out.println("User " + name + " not found.");
        }
    }

        private void viewAllUsers(){
            toDoListManager.displayAllUsers();
            System.out.println("Finding all users...");



        }

        private void selectUser(){
            System.out.println("Enter the name of the user to manage their tasks: ");
            String name = scanner.nextLine();

            User selectedUser = toDoListManager.findUserByName(name);

            if (selectedUser != null){
                System.out.println("User " + name + " selected!");
                manageUserTasks(selectedUser);
            } else {
                System.out.println("User not found.");
            }
        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main app = new Main(scanner);
        app.run();
    }

}