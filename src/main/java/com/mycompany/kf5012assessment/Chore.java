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
    private int choreFrequencyID;
    //sprivate String choreDesc;   // for more details e.g shopping list
    private int frequency;  // number of times in a week
    private int choreEstimateTime;  // for user to input their time estimate
    private int day;    // int that correlates to day of the week 1-7
    private boolean complete = false; // true if the user has completed the task
    private boolean selectedForThisWeek =true;

    public boolean isSelectedForThisWeek() {
        return selectedForThisWeek;
    }

    public void setSelectedForThisWeek(boolean selectedForThisWeek) {
        this.selectedForThisWeek = selectedForThisWeek;
    }
    public int getChoreFrequencyID() {
        return choreFrequencyID;
    }

    public void setChoreFrequencyID(int choreFrequencyID) {
        this.choreFrequencyID = choreFrequencyID;
    }

    
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
    
    /*
    public String getChoreDesc() {
        return choreDesc;
    }

    public void setChoreDesc(String choreDesc) {
        this.choreDesc = choreDesc;
    }
    s*/

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getChoreEstimateTime() {
        return choreEstimateTime;
    }

    public void setChoreEstimateTime(int choreEstimateTime) {
        this.choreEstimateTime = choreEstimateTime;
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
