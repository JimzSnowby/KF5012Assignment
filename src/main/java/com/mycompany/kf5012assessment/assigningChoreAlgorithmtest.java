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
    private int userOneTotal =0;
    private int userTwoTotal =0;
    
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
    
        for(int i = 0; i < choresArrayList.size(); i++){
            userOneTotal = userOneTotal + choresArrayList.get(i +1).getEstimateTimeUserOne();
          
        }
          System.out.println("hi"+userOneTotal+choresArrayList.size());
          System.out.println("heelo");
         return 0;
}
    public static void main(String[] args) {
        // TODO code application logic here
          System.out.println("heelo");

    }
    
}
