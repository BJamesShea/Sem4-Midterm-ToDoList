package com.keyin.todo.model;

import java.util.ArrayList;
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

}
