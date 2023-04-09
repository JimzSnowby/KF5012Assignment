/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.util.ArrayList;

/**
 *
 * @author nihal
 */
public class assigningChoreAlgorithmtest {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Chore> choresArrayList;
    int user1Total = 0;
    int user2Total = 0;

    public assigningChoreAlgorithmtest() {

        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            choresArrayList = choresDB.selectChores();
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
        calculation();
    }

    public int calculation() {
        for (Chore nextChore : choresArrayList) {
            user1Total += nextChore.getEstimateTimeUserOne();
            user2Total += nextChore.getEstimateTimeUserTwo();
              System.out.println(user1Total);

        }

        for (Chore nextChore : choresArrayList) {
            nextChore.setEstimateTimeUserOne(nextChore.getEstimateTimeUserOne() / user1Total);
            nextChore.setEstimateTimeUserOne(nextChore.getEstimateTimeUserOne() / user2Total);
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
