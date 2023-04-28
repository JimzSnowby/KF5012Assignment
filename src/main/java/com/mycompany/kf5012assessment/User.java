/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;


/**
 *
 * @author w21023500
 */

// This is the actual user
public class User {
    private int id; // PK for DB 
    private int activeUser; // is this the current active user
    private AssignedChoresList listOfChores;    // This is the list of chores that have been assigned to the user
    private int totalScore; // Grand total score
    private int weekScore;  // Score for this week

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int isActiveUser() {
        return activeUser;
    }

    public void setActiveUser(int activeUser) {
        this.activeUser = activeUser;
    }

    public AssignedChoresList getListOfChores() {
        return listOfChores;
    }

    public void setListOfChores(AssignedChoresList listOfChores) {
        this.listOfChores = listOfChores;
    }

    public int getWeekScore() {
        return weekScore;
    }

    public void setWeekScore(int weekScore) {
        this.weekScore = weekScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
