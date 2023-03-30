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
public class AssigningChoresAlgo{
    
    private ArrayList<EstimateTimeInputGUI> user1EstimatedTimes;
    private ArrayList<EstimateTimeInputGUI> user2EstimatedTimes;
    private ArrayList<SelectWeeklyChoreGUI> choresArrayList;
    //private choresArrayList = dummyList;
    public void main(String[] args) {
        
        int user1Total = 0;
        int user2Total = 0;
        
        
        for(int i = 0; i<choresArrayList.size();i++){
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

    public AssigningChoresAlgo() {
    }
   
  /*  public void NormaliseTotalTime() {
        ArrayList<Chore> total = new ArrayList();
        user1.getAssignedChoresList();
        for(int i = 0; i < user1.getAssignedChoresList().size(); i++){
            System.out.println("Loop" + i);
        }

    }  */  
    
        public void createDummyData(){
        Chore cleaning = new Chore();
        cleaning.setChoreID(1);
        cleaning.setChoreName("Cleaning");
        cleaning.setFrequency(3);
        cleaning.setChoreEstimateTime(30);
        cleaning.setDay(2);
        this.dummyList = new AssignedChoresList();
        dummyList.addToChoreList(cleaning);
        }
}
