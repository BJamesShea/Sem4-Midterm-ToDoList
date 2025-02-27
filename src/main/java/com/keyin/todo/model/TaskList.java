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
}
