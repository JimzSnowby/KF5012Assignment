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
    private int userOneTotal =0;
    private int userTwoTotal =0;
    //private choresArrayList = dummyList;
    public AssigningChoresAlgo() {

        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            choresArrayList = choresDB.selectChores();
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
        calculation();
    }
      
    
    public void calculation() {
    
        for(int i = 0; i < choresArrayList.size(); i++){
            userOneTotal = userOneTotal + choresArrayList.get(i +1).getEstimateTimeUserOne();
            System.out.println(userOneTotal);
        }
}

    public void main(String[] args) {
        
    }

  
}
