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

    //private choresArrayList = dummyList;
    public AssigningChoresAlgo() {

        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            choresArrayList = choresDB.selectChores();
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
    }
      
    private int userOneTotal =0;
    private int userTwoTotal =0;
    
    public void calculation() {
    
        for(Chore chore:choresArrayList){
            userOneTotal= userOneTotal + choresArrayList.get(chore.
            
                    
        }
}

    public void main(String[] args) {



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
