/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

/**
 *
 * @author James
 */
public class ChoresAssigned {
    private int choresAssignedID;
    private int choreID;
    private int userID;
    private int daysOfWeekID;
    private int choreComplete;
    private float choreCompletionTime;

    public ChoresAssigned(int choresAssignedID, int choreID, int userID, int daysOfWeekID, int choreComplete, float choreCompletionTime) {
        this.choresAssignedID = choresAssignedID;
        this.choreID = choreID;
        this.userID = userID;
        this.daysOfWeekID = daysOfWeekID;
        this.choreComplete = choreComplete;
        this.choreCompletionTime = choreCompletionTime;
    }

    public int getChoresAssignedID() {
        return choresAssignedID;
    }

    public void setChoresAssignedID(int choresAssignedID) {
        this.choresAssignedID = choresAssignedID;
    }

    public int getChoreID() {
        return choreID;
    }

    public void setChoreID(int choreID) {
        this.choreID = choreID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDaysOfWeekID() {
        return daysOfWeekID;
    }

    public void setDaysOfWeekID(int daysOfWeekID) {
        this.daysOfWeekID = daysOfWeekID;
    }

    public int getChoreComplete() {
        return choreComplete;
    }

    public void setChoreComplete(int choreComplete) {
        this.choreComplete = choreComplete;
    }

    public float getChoreCompletionTime() {
        return choreCompletionTime;
    }

    public void setChoreCompletionTime(float choreCompletionTime) {
        this.choreCompletionTime = choreCompletionTime;
    }

}
