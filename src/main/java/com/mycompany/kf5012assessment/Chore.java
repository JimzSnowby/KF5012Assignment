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
    private int choreFrequency;  // number of times in a week
    private int choreDay;    // int that correlates to day of the week 1-8
    private boolean choreComplete = false; // true if the user has completed the task
    private boolean selectedForThisWeek;
    private int choreAssignTo;

    private float estimateTimeUserOne;
    private float estimateTimeUserTwo;
    //private float estimateTime;

    /* public float getEstimateTime() {
       return estimateTime;
    }

      public void setEstimateTime(float estimateTime) {
        this.estimateTime = estimateTime;
    }*/
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
    public int getChoreFrequency() {
        return choreFrequency;
    }

    public void setChoreFrequency(int frequency) {
        this.choreFrequency = frequency;
    }

    public int getChoreDay() {
        return choreDay;
    }

    public void setChoreDay(int day) {
        this.choreDay = day;
    }

    public boolean isChoreComplete() {
        return choreComplete;
    }

    public void setChoreComplete(boolean complete) {
        this.choreComplete = complete;
    }

    public void assignTo(int v) {
        choreAssignTo = v;
    }

    public int getChoreAssignTo() {
        return choreAssignTo;
    }

    public Chore() {
        choreName = "not set";
        estimateTimeUserOne = 0;
        estimateTimeUserTwo = 0;
        choreAssignTo = 0;
        selectedForThisWeek = false;

    }

    public Chore(String name, float estimateOne, float estimateTwo, boolean selected) {
        choreName = name;
        estimateTimeUserOne = estimateOne;
        estimateTimeUserTwo = estimateTwo;
        choreAssignTo = 0;
        selectedForThisWeek = selected;
    }

}
