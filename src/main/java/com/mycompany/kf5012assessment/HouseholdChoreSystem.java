/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.kf5012assessment;

import static com.mycompany.kf5012assessment.AssigningChoresAlgo.calculation;
import java.util.ArrayList;

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

        ArrayList<Chore> list = new ArrayList();
//        Chore c1 = new Chore("Clean dishes", 20, 10, 1);
//        c1.setChoreDay(1);
//        list.add(c1);
//        Chore c2 = new Chore("clean floor", 30, 25, 1);
//        c2.setChoreDay(2);
//        list.add(c2);
//        Chore c3 = new Chore("walk the dog", 40, 30, 1);
//        c3.setChoreDay(4);
//        list.add(c3);
//        Chore c4 = new Chore("clean carpet", 22, 10, 1);
//        c4.setChoreDay(8);
//        list.add(c4);
//        Chore c5 = new Chore("wash clothes", 29, 32, 1);
//        c5.setChoreDay(5);
//        list.add(c5);
//        Chore c6 = new Chore("clean bathroom", 44, 27, 1);
//        c6.setChoreDay(7);
//        list.add(c6);
//        Chore c7 = new Chore("Clean room", 10, 15, 1);
//        c7.setChoreDay(1);
//        list.add(c7);
//        Chore c8 = new Chore("Clean kitchen", 10, 15, 1);
//        c8.setChoreDay(1);
//        list.add(c8);

        AssigningChoresAlgo.calculation(list);

        for (Chore c : list) {
            System.out.println(c.getChoreName() + " assign to " + c.getChoreAssignTo() + " user one " + c.getEstimateTimeUserOne() + " user Two " + c.getEstimateTimeUserTwo());
        }

        //     DBConnection db = new DBConnection();
        //    String filename = "kf5012db.db";
        //  if (!db.Connect(filename)){
        //   System.out.println("Didn't connect.");
        //   }
        //   else {
        //      System.out.println("connect.");
        //  }
        //James version:
        /*    AssigningChoresAlgo test = new AssigningChoresAlgo();
        test.calculation();

        //GUIOfCommonChores msGUI = new GUIOfCommonChores();
	//msGUI.setVisible(true);
         
        
        //Nihal version: 
        //assigningChoreAlgorithmtest testing = new assigningChoreAlgorithmtest();
        //testing.calculation();

      

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
