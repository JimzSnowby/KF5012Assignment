/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

/**
 *
 * @author w21023500
 */

//james 
//This is the class for the chores themselves e.g cleaning
public class Chore {
    private int choreID;    // PK for DB
    private String choreName;
    private String choreDesc;   // for more details e.g shopping list
    private int frequency;  // number of times in a week
    private int choreEstimateTime;  // for user to input their time estimate
    private int chorePoint;    // The amount of points completing this chore will reward
    private int day;    // int that correlates to day of the week 1-7
    private boolean complete = false; // true if the user has completed the task

    public int getChoreID() {
        return choreID;
    }

    public void setChoreID(int choreID) {
        this.choreID = choreID;
    }

    public String getChoreName() {
        return choreName;
    }

    public void setChoreName(String choreName) {
        this.choreName = choreName;
    }

    public String getChoreDesc() {
        return choreDesc;
    }

    public void setChoreDesc(String choreDesc) {
        this.choreDesc = choreDesc;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getEstimateTime() {
        return choreEstimateTime;
    }

    public void setEstimateTime(int estimateTime) {
        this.choreEstimateTime = estimateTime;
    }

    public int getChorePoint() {
        return chorePoint;
    }

    public void setChorePoint(int chorePoint) {
        this.chorePoint = chorePoint;
    }

    public int getDay() {
        return day;
    }
    
    public void setDay(int day){
        this.day = day;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    
}
