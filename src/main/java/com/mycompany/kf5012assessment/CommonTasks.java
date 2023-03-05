/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

/**
 *
 * @author w21010679
 */
// NIhal Kejman 
public class CommonTasks {

    private String name; // task name
    private String description; // task description
    private int estimatedTime; // estimated time to complete task
    private String priority; // priority of the task 

    // constructor to initialize the attributes
    public CommonTasks(String name, String description, int estimatedTime, String priority) {
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.priority = priority;
    }

    // getters and setters for the attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

 
}