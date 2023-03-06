/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.kf5012assessment;

/**
 *
 * @author w21023500
 */

// Main Class for running the system
public class HouseholdChoreSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DBConnection db = new DBConnection();
        
        String filename = "kf5012db.db";
        
        if (!db.Connect(filename)){
            System.out.println("Didn't connect.");
        }
        else {
            System.out.println("connect.");
        }
        // TODO code application logic here
   //  some dummy data for CommonTasks
       /* CommonTasks task1 = new CommonTasks("Task 1", "Description 1", 2, "High");
        CommonTasks task2 = new CommonTasks("Task 2", "Description 2", 1, "Low");
        CommonTasks task3 = new CommonTasks("Task 3", "Description 3", 3, "Medium");
        
        // Create a CommonTasksList object
        CommonTasksList taskList = new CommonTasksList();

        // Add the tasks to the list
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        // Print the current tasks in the list
        System.out.println("Current tasks in the list:");
        for (CommonTasks task : taskList.getName()) {
            System.out.println(task.getName() + " (" + task.getPriority() + ") - " + task.getEstimatedTime() + " hours");
        }

        // Modify one of the tasks in the list
        taskList.modifyTask(task1, "Task 1 (modified)", "Description 1 (modified)", 3, "Low");

        // Remove one of the tasks from the list
        taskList.removeTask(task2);

        // Print the tasks in the list after modification and removal
        System.out.println("\nTasks in the list after modification and removal:");
        for (CommonTasks task : taskList.getTasks()) {
            System.out.println(task.getName() + " (" + task.getPriority() + ") - " + task.getEstimatedTime() + " hours");
        }
*/
    }

    
}
