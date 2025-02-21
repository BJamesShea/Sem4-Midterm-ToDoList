package com.keyin.todo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {

    private String name;
    private List<Task> tasks;

    public User(String name){
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public List<Task>getTasks(){
        return tasks;
    }

    public void addTask(String description){
        tasks.add(new Task(description));
    }

    public boolean completeTask(String description){
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description) && !task.getIsCompleted()) {
                task.markAsCompleted();
                return true;
            }
        }
        return false;
    }

    public void viewTasks(){
        if (tasks.isEmpty()) {
            System.out.println("No tasks left! Great job!");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }


    public void removeTask(String taskDescription){
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();

            if (task.getDescription().equalsIgnoreCase(taskDescription)) {
                iterator.remove();
                return;
            }

        }
    }
}
