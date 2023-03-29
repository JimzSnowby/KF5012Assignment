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

    private static DBConnection database;

    //Chore newChore;
    public ChoresDatabase() {
        database = new DBConnection();
        database.Connect("C:\\Users\\nihal\\OneDrive - Northumbria University - Production Azure AD\\Documents\\YEAR 2\\Semester 2\\software engineer\\Group Work\\new new push\\kf5012db.db");

    }

    /**
     *
     * Functions below
     *
     */
    //Select all chores
    public ArrayList<Chore> selectChores() throws SQLException {

        String sqlSelectChores = "SELECT choreID, choreName, choreEstimateTime, chorePoint FROM chores;";

        ResultSet choreList = database.RunSQLQuery(sqlSelectChores);
        ArrayList<Chore> chores = new ArrayList<Chore>();

        try {
            while (choreList.next()) {
                Chore newChore = new Chore();
                newChore.setChoreID(choreList.getInt(1));
                newChore.setChoreName(choreList.getString(2));
                newChore.setChoreEstimateTime(choreList.getInt(3));
                newChore.setChorePoint(choreList.getInt(4));

                chores.add(newChore);

            }
        } catch (SQLException e) {
            System.out.println("Failed to process query in selectChores()");
            System.out.println("SQL attempted: " + sqlSelectChores);
            System.out.println("Error: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
        return chores;
    }

    //Select weekly chores
    public ArrayList<Chore> selectChoresFrequencyWeekly() throws SQLException {

        String sqlSelectChores = "SELECT choreID, choreName, choreEstimateTime, chorePoint "
                + "FROM chores "
                + "INNER JOIN choreFrequency ON choreFrequency.choreFrequencyID = chores.choreFrequencyID "
                + "WHERE choreFrequency = 1;";

        ResultSet choreList = database.RunSQLQuery(sqlSelectChores);
        ArrayList<Chore> chores = new ArrayList<Chore>();

        try {
            while (choreList.next()) {
                Chore newChore = new Chore();
                newChore.setChoreID(choreList.getInt(1));
                newChore.setChoreName(choreList.getString(2));
                newChore.setChoreEstimateTime(choreList.getInt(3));
                newChore.setChorePoint(choreList.getInt(4));

                chores.add(newChore);

            }
        } catch (SQLException e) {
            System.out.println("Failed to process query in selectChores()");
            System.out.println("SQL attempted: " + sqlSelectChores);
            System.out.println("Error: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
        return chores;
    }

    //Select one-off chores 
    public ArrayList<Chore> selectChoresFrequencyOneOff() throws SQLException {

        String sqlSelectChores = "SELECT choreID, choreName, choreEstimateTime, chorePoint "
                + "FROM chores "
                + "INNER JOIN choreFrequency ON choreFrequency.choreFrequencyID = chores.choreFrequencyID "
                + "WHERE choreFrequency = 2;";

        ResultSet choreList = database.RunSQLQuery(sqlSelectChores);
        ArrayList<Chore> chores = new ArrayList<Chore>();

        try {
            while (choreList.next()) {
                Chore newChore = new Chore();
                newChore.setChoreID(choreList.getInt(1));
                newChore.setChoreName(choreList.getString(2));
                newChore.setChoreEstimateTime(choreList.getInt(3));
                newChore.setChorePoint(choreList.getInt(4));

                chores.add(newChore);

            }
        } catch (SQLException e) {
            System.out.println("Failed to process query in selectChores()");
            System.out.println("SQL attempted: " + sqlSelectChores);
            System.out.println("Error: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
        return chores;
    }

    //Select all users
    public ArrayList<User> selectUsers() throws SQLException {

        String sqlSelectUsers = "SELECT userID, userName, userPassword, userActive FROM users;";

        ResultSet userList = database.RunSQLQuery(sqlSelectUsers);
        ArrayList<User> users = new ArrayList<User>();

        try {
            while (userList.next()) {
                User newUser = new User();
                newUser.setId(userList.getInt(1));
                newUser.setUserName(userList.getString(2));
                newUser.setPassword(userList.getString(3));
                newUser.setActiveUser(userList.getInt(4));

                users.add(newUser);

            }
        } catch (SQLException e) {
            System.out.println("Failed to process query in selectUsers()");
            System.out.println("SQL attempted: " + sqlSelectUsers);
            System.out.println("Error: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    //Add a new chore
    public static void addChore(Chore newChore) {

        String rs = ("select max(choreID) from chores;");
        database.RunSQLQuery(rs);
        int max = Integer.parseInt(rs) + 1;
        int placeholder = 1;

        String sqlAddChoreL = "INSERT INTO chores (choreID, choreName, choreFrequencyID, choreEstimateTime) VALUES("
                + max + ", "
                + newChore.getChoreName() + ", "
                + placeholder + ", "
                + newChore.getChoreEstimateTime() + ", '"
                + " '); ";

        boolean success;
        success = database.RunSQL(sqlAddChoreL);

        if (!success) {
            System.out.println("Failed to process query" + sqlAddChoreL);
        }

    }

    //Add a new user
    public static void addUser(User newUser) {

        String rs = ("select max(userID) from users");
        database.RunSQLQuery(rs);
        int max = Integer.parseInt(rs) + 1;

        int placeholder = 0;

        String sqlAddChoreL = "INSERT INTO users (userID, userName, userPassword, userActive) VALUES("
                + max + ", "
                + newUser.getUserName() + ", "
                + newUser.getPassword() + ", "
                + placeholder + ", '"
                + " '); ";

        boolean success;
        success = database.RunSQL(sqlAddChoreL);

        if (!success) {
            System.out.println("Failed to process query" + sqlAddChoreL);
        }

    }

    //Delete an user
    public void deleteUser(String userName) {
        String sqlDeleteUser = "DELETE FROM users WHERE userName = '" + userName + "';";

        boolean success = database.RunSQL(sqlDeleteUser);

        if (!success) {
            System.out.println("Failed to process query" + sqlDeleteUser);
        }

    }

    //Delete a chore
    public void deleteChore(String choreName) {
        String sqlDeleteChore = "DELETE FROM chores WHERE choreName = '" + choreName + "';";

        boolean success = database.RunSQL(sqlDeleteChore);

        if (!success) {
            System.out.println("Failed to process query" + sqlDeleteChore);
        }

    }

    //Delete chores table
    public void dropChoresTable() {
        String sqlDropChores = "DROP TABLE chores";

        boolean success = database.RunSQL(sqlDropChores);

        if (!success) {
            System.out.println("Failed to process query" + sqlDropChores);
        }

    }

    //Delete users table
    public void dropUsersTable() {
        String sqlDropUsers = "DROP TABLE users";

        boolean success = database.RunSQL(sqlDropUsers);

        if (!success) {
            System.out.println("Failed to process query" + sqlDropUsers);
        }

    }
    /*
    pls dont delete, testing purposes
    public static void main(String[] args){
        ChoresDatabase x = new ChoresDatabase();
        Chore c  =  new Chore();
        
        c.setChoreID(21);
        c.setName()
                
                
        x.ad
    }*/

}
