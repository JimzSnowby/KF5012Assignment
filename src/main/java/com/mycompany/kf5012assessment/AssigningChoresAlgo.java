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
    private User user1;
    private User user2;

    public AssignedChoresList user1ChoresAssigned;
    public AssignedChoresList user2ChoresAssigned;

    public ArrayList<Chore> fullList;

    //private choresArrayList = dummyList;
    public AssigningChoresAlgo() {

        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            choresArrayList = choresDB.selectEstimateTimeUserOne();
            choresArrayListTwo = choresDB.selectEstimateTimeUserTwo();
            fullList = choresDB.selectEstimateTimes();

        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }

        System.out.println("U2: " + user2ChoresAssigned);
        //   calculation();

    }

    // private float userTwoTotal = 0;
    public static void calculation(ArrayList<Chore> choreList) {
        int v = 1;
        float userOneTotal = 0;
        float userTwoTotal = 0;
        for (Chore c : choreList) {
            c.assignTo(v);
            v = 3 - v;
        }
        for (Chore c : choreList) {
            userOneTotal = userOneTotal + c.getEstimateTimeUserOne();
            userTwoTotal = userTwoTotal + c.getEstimateTimeUserTwo();

        }

        for (Chore c : choreList) {
            c.setEstimateTimeUserOne(c.getEstimateTimeUserOne()/userOneTotal);
            c.setEstimateTimeUserTwo(c.getEstimateTimeUserTwo()/userTwoTotal);

        }

 /*for (int i = 0; i < fullList.size(); i++) {
            userOneTotal = userOneTotal + fullList.get(i).getEstimateTimeUserOne();
            userTwoTotal = userTwoTotal + fullList.get(i).getEstimateTimeUserTwo();
        }

        for (int i = 0; i < fullList.size(); i++) {
            //choresArrayList.get(i).setEstimateTimeUserOne(choresArrayList.get(i).getEstimateTimeUserOne() / userOneTotal);
            //choresArrayListTwo.get(i).setEstimateTimeUserTwo(choresArrayListTwo.get(i).getEstimateTimeUserTwo() / userTwoTotal);
            fullList.get(i).setEstimateTimeUserOne(fullList.get(i).getEstimateTimeUserOne() / userOneTotal);
            fullList.get(i).setEstimateTimeUserTwo(fullList.get(i).getEstimateTimeUserTwo() / userTwoTotal);

        }

        float User1Load = 0;     // variables for this weeks chore 
        float User2Load = 1; //// variables for this weeks chore 
        float User1LoadCarriedOver = 0; //// variables for last weeks imbalance 
        float User2LoadCarriedOver = 0;//variables for last weeks imbalance

        int i = 0;
        while (fullList.size() > 0) {
            if (User1Load < User2Load) {
                Collections.sort(fullList, new Comparator<Chore>() {
                    @Override
                    public int compare(Chore c1, Chore c2) {
                        System.out.println("Stufff: " + c1.getEstimateTimeUserOne() + " and " + c2.getEstimateTimeUserTwo());

                        return Double.compare(c1.getEstimateTimeUserOne(), c2.getEstimateTimeUserTwo());
                    }
                });

                Chore chosenChore = null;
                for (Chore c : fullList) {
                    if (fullList.indexOf(c.getEstimateTimeUserOne()) < fullList.indexOf(c.getEstimateTimeUserTwo())) {
                        chosenChore = c;
                        break;
                    }
                }
                if (chosenChore == null) {
                    chosenChore = fullList.get(i);
                }

                System.out.println("Chosen chore:" + chosenChore.getChoreName());

                //user1ChoresAssigned.add(chosenChore);
                user1ChoresAssigned.addToChoreList(chosenChore);
                User1Load += chosenChore.getEstimateTimeUserOne();
                i++;
            } else {
                Collections.sort(fullList, new Comparator<Chore>() {
                    @Override
                    public int compare(Chore c1, Chore c2) {
                        return Double.compare(c1.getEstimateTimeUserOne(), c2.getEstimateTimeUserTwo());
                    }
                });

                Chore chosenChore = null;
                for (Chore c : fullList) {
                    if (fullList.indexOf(c.getEstimateTimeUserTwo()) < fullList.indexOf(c.getEstimateTimeUserOne())) {
                        chosenChore = c;
                        break;
                    }
                }
                if (chosenChore == null) {
                    chosenChore = fullList.get(i);
                }

                // user2ChoresAssigned.add(chosenChore);
                user2ChoresAssigned.addToChoreList(chosenChore);
                User2Load += chosenChore.getEstimateTimeUserTwo();
                i++;
            }
            System.out.println(user1ChoresAssigned);
            System.out.println(user2ChoresAssigned);
            break;
        }

        return userOneTotal;

    }

    /*    Collection.sort(choresArrayList,new comparator<Chore>) {
                @Override
                public int compare ( choresArrayList. Chore c2){
                    return Double.compare(c2,);
                }
            }*/

    }

    //Testing the assigning chores
    public void main(String[] args) {

        //System.out.println(choresArrayList.size());
        //System.out.println(choresArrayListTwo.size());

        /*for (int i = 0; i < choresArrayList.size(); i++) {
            //user1Total += user1Total + choresArrayList.get(i);
            //user2Total += user2Total + choresArrayList.get(i);
            System.out.println(choresArrayList.get(i));
        }*/
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
