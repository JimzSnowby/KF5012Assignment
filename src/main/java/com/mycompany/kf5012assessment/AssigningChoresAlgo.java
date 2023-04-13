/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w21023500
 */
// For Task 7 Group work
public class AssigningChoresAlgo {

    private ArrayList<Chore> choresArrayList;
    private ArrayList<Chore> choresArrayListTwo;

    //private choresArrayList = dummyList;
    public AssigningChoresAlgo() {

        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            choresArrayList = choresDB.selectEstimateTimeUserOne();
            choresArrayListTwo = choresDB.selectEstimateTimeUserTwo();

        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
        calculation();

    }

    private float userOneTotal = 0;
    private float userTwoTotal = 0;
    // private float userTwoTotal = 0;

    public float calculation() {

        if (choresArrayList.size() == choresArrayListTwo.size()) {

            for (int i = 0; i < choresArrayList.size(); i++) {
                userOneTotal = userOneTotal + choresArrayList.get(i).getEstimateTimeUserOne();
                userTwoTotal = userTwoTotal + choresArrayListTwo.get(i).getEstimateTimeUserTwo();

                System.out.println(userOneTotal);
                System.out.println(userTwoTotal);
            }

            for (int i = 0; i < choresArrayList.size(); i++) {
                choresArrayList.get(i).setEstimateTimeUserOne(choresArrayList.get(i).getEstimateTimeUserOne() / userOneTotal);
                System.out.println(choresArrayList.get(i).getEstimateTimeUserOne());

                choresArrayListTwo.get(i).setEstimateTimeUserTwo(choresArrayListTwo.get(i).getEstimateTimeUserTwo() / userTwoTotal);
                System.out.println(choresArrayListTwo.get(i).getEstimateTimeUserTwo());
            }

        }

        float User1Load = 0;     // variables for this weeks chore 
        float User2Load = 0; //// variables for this weeks chore 
        float User1LoadCarriedOver = 0; //// variables for last weeks imbalance 
        float User2LoadCarriedOver = 0;//variables for last weeks imbalance

        int i = 0;
        while (choresArrayList.size() > 0) {
            if (User1Load < User2Load) {
                Collections.sort(choresArrayList, new Comparator<Chore>() {
                    @Override
                    public int compare(Chore c1, Chore c2) {
                        return Double.compare(c1.getEstimateTimeUserOne(), c2.getEstimateTimeUserTwo());
                    }
                });

            }
        }

        return userOneTotal;

    }

    /*    Collection.sort(choresArrayList,new comparator<Chore>) {
                @Override
                public int compare ( choresArrayList. Chore c2){
                    return Double.compare(c2,);
                }
            }*/
    public void main(String[] args) {
        calculation();

        for (int i = 0; i < choresArrayList.size(); i++) {
            //user1Total += user1Total + choresArrayList.get(i);
            //user2Total += user2Total + choresArrayList.get(i);
            System.out.println(choresArrayList.get(i));
        }

        // for(Chore li : ChoreList.getChoreList){
        //}
        /*ChoresDatabase db = new ChoresDatabase();
        try {
            db.selectChores();
        } catch (SQLException ex) {
            Logger.getLogger(AssigningChoresAlgo.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //NormaliseTotalTime();
    }

    /*  public void NormaliseTotalTime() {
        ArrayList<Chore> total = new ArrayList();
        user1.getAssignedChoresList();
        for(int i = 0; i < user1.getAssignedChoresList().size(); i++){
            System.out.println("Loop" + i);
        }

    }  */
}
