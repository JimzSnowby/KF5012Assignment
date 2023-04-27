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
    private int choreFrequencyID; // If == 0 is a one-off, if == 1 is permanent
    //sprivate String choreDesc;   // for more details e.g shopping list
    private int frequency;  // number of times in a week
    private int day;    // int that correlates to day of the week 1-8
    private boolean complete = false; // true if the user has completed the task
    private boolean selectedForThisWeek = true;
    private int assignto;

    private float estimateTimeUserOne;
    private float estimateTimeUserTwo;
    private float estimateTime;

    public float getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(float estimateTime) {
        this.estimateTime = estimateTime;
    }

    public float getEstimateTimeUserOne() {
        return estimateTimeUserOne;
    }

    public void setEstimateTimeUserOne(float estimateTimeUserOne) {
        this.estimateTimeUserOne = estimateTimeUserOne;
    }

    public float getEstimateTimeUserTwo() {
        return estimateTimeUserTwo;
    }

    public void setEstimateTimeUserTwo(float estimateTimeUserTwo) {
        this.estimateTimeUserTwo = estimateTimeUserTwo;
    }

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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void assignTo(int v){
        assignto= v;
    }
    
    public int getassignTo(){
        return assignto;
    }
    public Chore() {
        choreName = "not set";
        estimateTimeUserOne = 0;
        estimateTimeUserTwo = 0;
        assignto = 0;
        selectedForThisWeek = false;

    }
    
    public Chore(String name, float estimateOne, float estimateTwo, boolean selected){
        choreName = name;
        estimateTimeUserOne = estimateOne;
        estimateTimeUserTwo = estimateTwo;
        assignto = 0;
        selectedForThisWeek = selected;
    }
    
    
}
