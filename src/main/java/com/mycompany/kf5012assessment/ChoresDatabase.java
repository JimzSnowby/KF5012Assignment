/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author majabosy
 */
public class ChoresDatabase {

    private DBConnection database;

    public ChoresDatabase() {
        database = new DBConnection();
        database.Connect("/Users/majabosy/NetBeansProjects/kf5012assessment/src/main/java/com/mycompany/kf5012assessment/kf5012db.db");
    }

    /**
     *
     * Functions to be included here
     *
     */
    private int choreID;
    private String choreName;
    private String choreEstimateTime;
    private int chorePoint;

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

    public String getChoreEstimateTime() {
        return choreEstimateTime;
    }

    public void setChoreEstimateTime(String choreEstimateTime) {
        this.choreEstimateTime = choreEstimateTime;
    }

    public int getChorePoint() {
        return chorePoint;
    }

    public void setChorePoint(int chorePoint) {
        this.chorePoint = chorePoint;
    }

    public ArrayList<ChoresDatabase> choresList() throws SQLException {

        String sqlString = "SELECT choreID, choreName, choreEstimateTime, chorePoint FROM chores;";

        ResultSet choreList = database.RunSQLQuery(sqlString);
        ArrayList<ChoresDatabase> chores = new ArrayList<ChoresDatabase>();

        try {
            while (choreList.next()) {
                ChoresDatabase newChore = new ChoresDatabase();
                newChore.setChoreID(choreList.getInt(1));
                newChore.setChoreName(choreList.getString(2));
                newChore.setChoreEstimateTime(choreList.getString(3));
                newChore.setChorePoint(choreList.getInt(4));

                chores.add(newChore);

            }
        } catch (SQLException e) {
            System.out.println("Failed to process query in choresList()");
            System.out.println("SQL attempted: " + sqlString);
            System.out.println("Error: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }

        return chores;

    }

}
