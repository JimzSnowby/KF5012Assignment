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
    static Chore newchore = new Chore();
    static ArrayList<Chore> choresArrayList = new ArrayList<Chore>();

    //Chore newChore;
    public ChoresDatabase() {
        database = new DBConnection();

        //James:
      //  database.Connect("C:\\Users\\james\\Documents\\Year 2\\Semester2\\Software Engineering\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        
        //Maja:
        //database.Connect("/Users/majabosy/Documents/KF5012Assignment/src/main/java/com/mycompany/kf5012assessment/kf5012db.db");
    
        //Nihal:
        database.Connect("C:\\Users\\nihal\\Documents\\software\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
    
        //Yoyo:
        ///database.Connect("/Users/yoyosiu/Documents/GitHub/KF5012Assignment/src/main/java/com/mycompany/kf5012assessment/kf5012db.db");
    }   

    /**
     *
     * Functions below
     *
     */
    //Select all chores
    public ArrayList<Chore> selectChores() throws SQLException {

        String sqlSelectChores = "SELECT choreID, choreName, choreFrequencyID  FROM chores;";

        ResultSet choreList = database.RunSQLQuery(sqlSelectChores);
        ArrayList<Chore> chores = new ArrayList<Chore>();

        try {
            while (choreList.next()) {
                Chore newChore = new Chore();
                newChore.setChoreID(choreList.getInt(1));
                newChore.setChoreName(choreList.getString(2));
                newChore.setChoreFrequencyID(choreList.getInt(3));
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

    public ArrayList<Chore> selectEstimateTimeUserOne() throws SQLException {

        String sqlSelectChores = "SELECT choreEstimateTime, choreID  FROM estimateTime WHERE userID = 1;";

        ResultSet choreList = database.RunSQLQuery(sqlSelectChores);
        ArrayList<Chore> chores = new ArrayList<Chore>();

        try {
            while (choreList.next()) {
                Chore newChore = new Chore();
                newChore.setEstimateTimeUserOne(choreList.getFloat(1));
                newChore.setChoreID(choreList.getInt(2));
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
    
     public ArrayList<Chore> selectEstimateTimeUserTwo() throws SQLException {

        String sqlSelectChores = "SELECT choreEstimateTime, choreID  FROM estimateTime WHERE userID = 2;";

        ResultSet choreList = database.RunSQLQuery(sqlSelectChores);
        ArrayList<Chore> chores = new ArrayList<Chore>();

        try {
            while (choreList.next()) {
                Chore newChore = new Chore();
                newChore.setEstimateTimeUserTwo(choreList.getFloat(1));
                newChore.setChoreID(choreList.getInt(2));
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

    //Update estimate time for user 1
    public void updateEstimateTimeUserOne() throws SQLException {
        String sqlUpdateEstimateTime1 = "UPDATE estimateTime SET choreEstimateTime = '" + newchore.getEstimateTimeUserOne() + "' "
                + "WHERE userID = 1 ;";

        boolean success = database.RunSQL(sqlUpdateEstimateTime1);

        if (!success) {
            System.out.println("Failed to process query" + sqlUpdateEstimateTime1);
        }
    }

    //Update estimate time for user 2
    public void updateEstimateTimeUserTwo() throws SQLException {
        String sqlUpdateEstimateTime2 = "UPDATE estimateTime SET choreEstimateTime = '" + newchore.getEstimateTimeUserTwo() + "' "
                + "WHERE userID = 2 ;";

        boolean success = database.RunSQL(sqlUpdateEstimateTime2);

        if (!success) {
            System.out.println("Failed to process query" + sqlUpdateEstimateTime2);
        }
    }

    //Select weekly chores
    public ArrayList<Chore> selectChoresFrequencyWeekly() throws SQLException {

        String sqlSelectChores = "SELECT choreID, choreName "
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

        String sqlSelectChores = "SELECT choreID, choreName "
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

        String sqlSelectUsers = "SELECT userID, userName, userPassword, userActive, userWeekScore, userTotalScore FROM users;";

        ResultSet userList = database.RunSQLQuery(sqlSelectUsers);
        ArrayList<User> users = new ArrayList<User>();

        try {
            while (userList.next()) {
                User newUser = new User();
                newUser.setId(userList.getInt(1));
                newUser.setUserName(userList.getString(2));
                newUser.setPassword(userList.getString(3));
                newUser.setActiveUser(userList.getInt(4));
                newUser.setWeekScore(userList.getInt(5));
                newUser.setTotalScore(userList.getInt(6));

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
    public void addChore(Chore newChore) {

        String rs = ("select max(choreID) from chores;");
        database.RunSQLQuery(rs);
        int max = Integer.parseInt(rs) + 1;
        int placeholder = 1;
        int placeholder2 = 1;

        String sqlAddChore = "INSERT INTO chores (choreID, choreName, choreFrequencyID, daysOfWeekID) VALUES("
                + max + ", "
                + newChore.getChoreName() + ", "
                + placeholder + ", '"
                + newchore.getDay() + ", '"
                + " '); ";

        boolean success;
        success = database.RunSQL(sqlAddChore);

        if (!success) {
            System.out.println("Failed to process query" + sqlAddChore);
        }

    }

    //Add a new user
    public static void addUser(User newUser) {

        String rs = ("select max(userID) from users");
        database.RunSQLQuery(rs);
        int max = Integer.parseInt(rs) + 1;

        int placeholder = 0;
        int placeholder2 = 0;
        int placeholder3 = 0;

        String sqlAddChoreL = "INSERT INTO users (userID, userName, userPassword, userActive, userWeekScore, userTotalScore) VALUES("
                + max + ", "
                + newUser.getUserName() + ", "
                + newUser.getPassword() + ", "
                + placeholder + ", '"
                + placeholder2 + ", '"
                + placeholder3 + ", '"
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

    //Ask about the arraylist
    public static void main(String[] args) {
        //String update = "UPDATE chores SET choreName = ?, choreFrequencyID = ?, daysOfWeekID WHERE choreID = ? ";

        for (int i = 0; i < choresArrayList.size(); i++) {
            System.out.println(i);
        }
    }

    /*
    Please don't delete, testing mission purposes
    
    //Testing the adding
    public static void main(String[] args){
        ChoresDatabase x = new ChoresDatabase();
        Chore c  =  new Chore();
        
        c.setChoreID(21);
        c.setName()
                
                
        x.ad
    
    //Testing the update
    public static void main(String[] args) throws SQLException {
        ChoresDatabase x = new ChoresDatabase();
        Chore c  =  new Chore();
        
        newchore.setEstimateTimeUserTwo(666);

        //c.setEstimateTimeUserTwo(667);
        x.updateEstimateTimeUserTwo();

    }
    }*/
}
