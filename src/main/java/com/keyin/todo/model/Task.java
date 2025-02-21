package com.keyin.todo.model;

public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() { // apparently booleans shouldn't be getIsCompleted. -B.S Feb 21
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return description + " - " + (isCompleted ? "Completed" : "Pending");
    }
}
