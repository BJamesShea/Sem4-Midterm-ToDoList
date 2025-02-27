package com.keyin.todo.model;

public class TaskList {
    private TaskNode head;

    private class TaskNode{
        Task task;
        TaskNode next;

        TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public TaskList(){
        this.head = null;
    }

    public void addTask(String description){
        Task newTask = new Task(description);
        TaskNode newNode = new TaskNode(newTask);

        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean completeTask(String description) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getDescription().equalsIgnoreCase(description) && !current.task.getIsCompleted()) {
                current.task.markAsCompleted();
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeTask(String description) {
        if (head == null) return; // No tasks to remove

        // If the first task is the one to be removed
        if (head.task.getDescription().equalsIgnoreCase(description)) {
            head = head.next;
            return;
        }

        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.getDescription().equalsIgnoreCase(description)) {
                current.next = current.next.next; // Remove the task
                return;
            }
            current = current.next;
        }
    }

    public void viewTasks() {
        if (head == null) {
            System.out.println("No tasks left! Great job!");
            return;
        }

        TaskNode current = head;
        System.out.println("Your Tasks:");
        while (current != null) {
            System.out.println("- " + current.task);
            current = current.next;
        }
    }


}
