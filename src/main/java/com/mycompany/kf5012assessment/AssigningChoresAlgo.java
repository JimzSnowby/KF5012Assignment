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

    private ArrayList<Chore> choresArrayListUserOne;
    private ArrayList<Chore> choresArrayListUserTwo;
    //private User userOne;
    //private User userTwo;

    //private choresArrayList = dummyList;
    public AssigningChoresAlgo() {

        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            choresArrayListUserOne = choresDB.selectEstimateTimeUserOne();
            choresArrayListUserTwo = choresDB.selectEstimateTimeUserTwo();

        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }

        //   calculation();
    }

    public boolean unassignedChore(ArrayList<Chore> choreList) {
        for (Chore c : choreList) {
            if (c.getChoreAssignTo() == 0) {
                return true;
            }
        }
        return false;
    }

    // private float userTwoTotal = 0;
    public static void calculation(ArrayList<Chore> fullChoreList) {

        ArrayList<Chore> choreList = new ArrayList<Chore>();
        for (Chore c : fullChoreList) {
            if (c.isSelectedForThisWeek()) {
                choreList.add(c);

            }

        }

        fullChoreList.clear();

        //      AssignedChoresList user1ChoresAssigned = new AssignedChoresList();
        //     AssignedChoresList user2ChoresAssigned = new AssignedChoresList();
        float userOneTotal = 0;
        float userTwoTotal = 0;

        for (Chore c : choreList) {
            userOneTotal = userOneTotal + c.getEstimateTimeUserOne();
            userTwoTotal = userTwoTotal + c.getEstimateTimeUserTwo();

        }

        for (Chore c : choreList) {
            c.setEstimateTimeUserOne(c.getEstimateTimeUserOne() / userOneTotal);
            c.setEstimateTimeUserTwo(c.getEstimateTimeUserTwo() / userTwoTotal);

        }

        float User1Load = 0;     // variables for this weeks chore 
        float User2Load = 0; //// variables for this weeks chore 
        float User1LoadCarriedOver = 0; //// variables for last weeks imbalance 
        float User2LoadCarriedOver = 0;//variables for last weeks imbalance
        int numUnassignChores = 0;
        for (Chore c : choreList) {

        }

        int unassignedChores = choreList.size();

        while (unassignedChores > 0) {

            if (User1Load < User2Load) {
                // Sorting the list and coparing the estimate times
                Collections.sort(choreList, new Comparator<Chore>() {
                    @Override
                    public int compare(Chore c1, Chore c2) {
                        return Double.compare(c2.getEstimateTimeUserOne(), c1.getEstimateTimeUserOne());
                    }
                });

                Chore chosenChore = null;

                for (Chore c : choreList) {
                    if (c.getEstimateTimeUserOne() < c.getEstimateTimeUserTwo() && c.getChoreAssignTo() == 0) {
                        chosenChore = c;
                        break;
                    }
                }

                if (chosenChore == null) {
                    for (Chore c : choreList) {
                        if (c.getChoreAssignTo() == 0) {
                            chosenChore = c;
                            break;
                        }
                    }
                }
                
                //  user1ChoresAssigned.addToChoreList(chosenChore);
                User1Load = User1Load + chosenChore.getEstimateTimeUserOne();
                chosenChore.assignTo(1);
                unassignedChores--;

            } else {
                // Sorting the list and coparing the estimate times
                Collections.sort(choreList, new Comparator<Chore>() {
                    @Override
                    public int compare(Chore c1, Chore c2) {
                        return Double.compare(c2.getEstimateTimeUserTwo(), c1.getEstimateTimeUserTwo());
                    }
                });

                Chore chosenChore = null;

                for (Chore c : choreList) {
                    if (c.getEstimateTimeUserTwo() < c.getEstimateTimeUserOne() && c.getChoreAssignTo() == 0) {
                        chosenChore = c;
                        break;
                    }
                }

                if (chosenChore == null) {
                    for (Chore c : choreList) {
                        if (c.getChoreAssignTo() == 0) {
                            chosenChore = c;
                            break;
                        }
                    }
                }

                //       user2ChoresAssigned.addToChoreList(chosenChore);
                User2Load = User2Load + chosenChore.getEstimateTimeUserTwo();
                unassignedChores--;
                chosenChore.assignTo(2);
            }

            /*  int i = 0;
            while (fullList.size() > 0) {

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
            }else {
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
        fullChoreList.clear();
        for (Chore c : choreList) {

            fullChoreList.add(c);

        }
//Testing the assigning chores
/*public void main(String[] args) {

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
