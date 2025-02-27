package com.keyin.todo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ToDoListManager {
    private List<User> users;

    public ToDoListManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (findUserByName(user.getName()) != null){
            System.out.println("Name already exists in database.");
            return;
        }
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User findUserByName(String name){
        for (User user : users){
            if (user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public void removeUser(String name){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();

            if (user.getName().equalsIgnoreCase(name)){
                iterator.remove();
                return;
            }
        }

    }


    public void displayAllUsers(){
        if (users.isEmpty()){
            System.out.println("No users found!");

            return;
        }

        System.out.println("Current Users:");
        for (User user : users){
            System.out.println("- " + user.getName());
        }
    }

}
