package com.keyin.todo.model;

public class User {
    private String name;
    private TaskList tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new TaskList();
    }

    public String getName() {
        return name;
    }

    public TaskList getTaskList() {
        return tasks;
    }


    public void viewTasks() {
        tasks.viewTasks();
    }


    public boolean completeTask(String description) {
        return tasks.completeTask(description);
    }

    public void removeTask(String description) {
        tasks.removeTask(description);
    }
}
