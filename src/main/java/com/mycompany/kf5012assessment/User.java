/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.util.ArrayList;

/**
 *
 * @author w21023500
 */

// This is the actual user
public class User {
    private int id; // PK for DB
    private String userName;
    private String password;
    private int weekScore;
    private int totalScore;
    private int activeUser; // is this the current active user
    private AssignedChoresList listOfChores;    // This is the list of chores that have been assigned to the user

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
