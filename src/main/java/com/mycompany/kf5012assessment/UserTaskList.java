/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author w21010679
 */

//Nihal 
// UserTaskList class represents the list of tasks that each user needs to complete
public class UserTaskList {
    private List<UserTask> tasks; // list of tasks

    // constructor to initialize the list
    public UserTaskList() {
        tasks = new ArrayList<>();
    }

    // method to add a task to the list
    public void addTask(UserTask task) {
        tasks.add(task);
    }

      // method to remove a task from the list
    public void removeTask(UserTask task) {
        tasks.remove(task);
    }
}