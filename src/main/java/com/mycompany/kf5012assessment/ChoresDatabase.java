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
        database.Connect("G:/University work/Year 2/Semester2/SE practice/KF5012Assignment/src/main/java/com/mycompany/kf5012assessment/kf5012db.db");
      //  database.Connect("D:\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //Maja:
        //database.Connect("/Users/majabosy/Documents/KF5012Assignment/src/main/java/com/mycompany/kf5012assessment/kf5012db.db");
        //Nihal:
        //database.Connect("C:\\Users\\nihal\\Documents\\newGroupWork\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //database.Connect("C:\\Users\\nihal\\Documents\\software\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //  database.Connect("D:\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //database.Connect("D:\\test\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //database.Connect("D:\\KF5012Assignment\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //  database.Connect("D:\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //database.Connect("D:\\test\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //database.Connect("D:\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
        //Yoyo:
     //    database.Connect("/Users/yoyosiu/Documents/GitHub/KF5012Assignment/src/main/java/com/mycompany/kf5012assessment/kf5012db.db");
        //database.Connect("D:\\CLONE\\KF5012Assignment\\src\\main\\java\\com\\mycompany\\kf5012assessment\\kf5012db.db");
    }

    /**
     *
     * Functions
     *
     */
    //Select all chores
    public ArrayList<Chore> selectChores() throws SQLException {

        String sqlSelectChores = "SELECT choreID, choreName, choreFrequencyID, assignedTo, daysOfWeekID  FROM chores;";

        ResultSet choreList = database.RunSQLQuery(sqlSelectChores);
        ArrayList<Chore> chores = new ArrayList<Chore>();

        try {
            while (choreList.next()) {
                Chore newChore = new Chore();
                newChore.setChoreID(choreList.getInt(1));
                newChore.setChoreName(choreList.getString(2));
                newChore.setChoreFrequencyID(choreList.getInt(3));
                newChore.assignTo(choreList.getInt(4));
                newChore.setChoreDay(choreList.getInt(5));
                chores.add(newChore);

                System.out.println("Chore ID: " + newChore.getChoreID() + " Chore name: " + newChore.getChoreName());
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

    //Assign a chore
    public void assignChore(String choreName, int assignedTo) throws SQLException {
        String sqlUpdateChore = "UPDATE chores SET assignedTo = '" + assignedTo + "' "
                + "WHERE choreName = '" + choreName + "' ;";

        boolean success = database.RunSQL(sqlUpdateChore);

        if (!success) {
            System.out.println("Failed to process query" + sqlUpdateChore);
        }
    }

    //Delete a chore
    public void deleteChore(String choreName, int assignedTo) throws SQLException {
        String sqlDeleteChore = "DELETE FROM chores WHERE choreName = '" + choreName + "';";

        boolean success = database.RunSQL(sqlDeleteChore);

        if (!success) {
            System.out.println("Failed to process query" + sqlDeleteChore);
        }
    }

    //Select estimate times for user 1
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

    //Select estimate times for user 2
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

        String sqlSelectChores = "SELECT choreID, choreName, choreFrequency "
                + "FROM chores "
                + "INNER JOIN choreFrequency ON choreFrequency.choreFrequencyID = chores.choreFrequencyID "
                + "WHERE choreFrequency = 'Weekly';";

        ResultSet choreList = database.RunSQLQuery(sqlSelectChores);
        ArrayList<Chore> chores = new ArrayList<Chore>();

        try {
            while (choreList.next()) {
                Chore newChore = new Chore();
                newChore.setChoreID(choreList.getInt(1));
                newChore.setChoreName(choreList.getString(2));
                newChore.setChoreFrequency(choreList.getString(3));
                chores.add(newChore);

                System.out.println("Chore ID: " + newChore.getChoreID() + " Frequency: "
                        + newChore.getChoreFrequency() + " Chore name: " + newChore.getChoreName());

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
                + "WHERE choreFrequency = 'One-off';";

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

    //isSelected = 1 is selected
    //isSelected = 0 is not selected
    //Select all selected chores
    public ArrayList<Chore> sqlSelectedChores() throws SQLException {

        String sqlSelectedChores = "SELECT choreID, choreName FROM chores WHERE isSelected = 1;";

        ResultSet choreList = database.RunSQLQuery(sqlSelectedChores);
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
            System.out.println("SQL attempted: " + sqlSelectedChores);
            System.out.println("Error: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
        return chores;
    }

    //Update chore to be selected
    public void updateToSelected() throws SQLException {
        String updateToSelected = "UPDATE chores SET isSelected = 1 "
                + "WHERE choreID = '" + newchore.getChoreID() + "' ;";

        boolean success = database.RunSQL(updateToSelected);

        if (!success) {
            System.out.println("Failed to process query" + updateToSelected);
        }
    }

    //Update chore to be unselected
    public void updateToUnselected() throws SQLException {
        String updateToUnselected = "UPDATE chores SET isSelected = 0 "
                + "WHERE choreID = '" + newchore.getChoreID() + "' ;";

        boolean success = database.RunSQL(updateToUnselected);

        if (!success) {
            System.out.println("Failed to process query" + updateToUnselected);
        }
    }

    //Select all users
    public ArrayList<User> selectUsers() throws SQLException {

        String sqlSelectUsers = "SELECT userID, userActive, userWeekScore, userTotalScore FROM users;";

        ResultSet userList = database.RunSQLQuery(sqlSelectUsers);
        ArrayList<User> users = new ArrayList<User>();

        try {
            while (userList.next()) {
                User newUser = new User();
                newUser.setUserID(userList.getInt(1));
                newUser.setUserActive(userList.getInt(2));
                newUser.setUserWeekScore(userList.getInt(3));
                newUser.setUserTotalScore(userList.getInt(4));

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
    public void addChore(Chore newChore, int choreFrequencyID, int assignedTo) {

        String rs = ("select max(choreID) from chores;");
        database.RunSQLQuery(rs);
        int max = Integer.parseInt(rs) + 1;

        String sqlAddChore = "INSERT INTO chores (choreID, choreName, choreFrequencyID, daysOfWeekID, assignedTo) VALUES("
                + max + ", "
                + newChore.getChoreName() + ", "
                + choreFrequencyID + ", '"
                + newchore.getChoreDay() + ", '"
                + assignedTo + ", '"
                + " '); ";

        boolean success;
        success = database.RunSQL(sqlAddChore);

        if (!success) {
            System.out.println("Failed to process query" + sqlAddChore);
        }

    }

    //Add a new user
    public static void addUser(User newUser, int userActive, int weekScore, int totalScore) {

        String rs = ("select max(userID) from users");
        database.RunSQLQuery(rs);
        int max = Integer.parseInt(rs) + 1;

        int placeholder = 0;
        int placeholder2 = 0;
        int placeholder3 = 0;

        String sqlAddChoreL = "INSERT INTO users (userID, userActive, userWeekScore, userTotalScore) VALUES("
                + max + ", "
                + userActive + ", '"
                + weekScore + ", '"
                + totalScore + ", '"
                + " '); ";

        boolean success;
        success = database.RunSQL(sqlAddChoreL);

        if (!success) {
            System.out.println("Failed to process query" + sqlAddChoreL);
        }

    }

    //Delete an user
    public void deleteUser(int userID) {
        String sqlDeleteUser = "DELETE FROM users WHERE userID = '" + userID + "';";

        boolean success = database.RunSQL(sqlDeleteUser);

        if (success) {
            System.out.println("User " + userID + " was successfully deleted");
        }

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

        if (success) {
            System.out.println("Chores table was successfully deleted");
        }

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
    Please don't delete, testing mission purposes

    //Ask about the arraylist
    public static void main(String[] args) {
        //String update = "UPDATE chores SET choreName = ?, choreFrequencyID = ?, daysOfWeekID WHERE choreID = ? ";

        for (int i = 0; i < choresArrayList.size(); i++) {
            System.out.println(i);
        }
    }
    //Testing the update
    public static void main(String[] args) throws SQLException {
        ChoresDatabase x = new ChoresDatabase();
        Chore c = new Chore();

        newchore.setEstimateTimeUserOne(66);
        newchore.setEstimateTimeUserTwo(11);

        x.updateEstimateTimeUserTwo();
        x.updateEstimateTimeUserOne();
    } 
    public static void main(String[] args) {
        ChoresDatabase x = new ChoresDatabase();
        Chore c = new Chore();

        c.setChoreID(21);
        c.setChoreName("Testing");
        c.setChoreFrequencyID(1);
        c.setChoreDay(1);
        c.assignTo(1);
                
        x.addChore(newchore);
    }
    //Test of the delete chores table
    public static void main(String[] args) {
        ChoresDatabase x = new ChoresDatabase();
        x.dropChoresTable();

    }
    //Test of the select chores table
    public static void main(String[] args) throws SQLException {
        ChoresDatabase x = new ChoresDatabase();
        x.selectChores();
    }
    //Test of user 1 deletion
    public static void main(String[] args) throws SQLException {
        ChoresDatabase x = new ChoresDatabase();
        int userID = 1;
        x.deleteUser(userID);
    }
    public static void main(String[] args) throws SQLException {
        ChoresDatabase x = new ChoresDatabase();
        x.selectChoresFrequencyWeekly();
    }
     */
}
