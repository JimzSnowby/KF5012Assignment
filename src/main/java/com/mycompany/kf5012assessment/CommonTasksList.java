/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author w21010679
 */
//Nihal 
// CommonTasksList class represents the list of common weekly tasks
public class CommonTasksList {

    private List<CommonTasks> tasks; // list of tasks

    // constructor to initialize the list
    public CommonTasksList() {
        tasks = new ArrayList<>();
    }

    // method to add a task to the list
    public void addTask(CommonTasks task) {
        tasks.add(task);
    }

    // method to remove a task from the list
    public void removeTask(CommonTasks task) {
        tasks.remove(task);
    }

    // method to modify a task in the list
    public void modifyTask(CommonTasks task, String newName, int newEstimatedTime) {
        task.setName(newName);
        task.setEstimatedTime(newEstimatedTime);
    }
    

}
