/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

/**
 *
 * @author w21023500
 */
public class ChoreCompletionPoints {
    private Chore chore;
    private User user;
    private int points;
    private ChoresDatabase choreDB;

    public int pointCalculation(Chore chore, int activeUser){
        float estimate = 0;
        float actualTime = 0;
        float time = 0;
        float difficulty = 1;
        if(activeUser == 1){
            estimate = chore.getEstimateTimeUserOne();
            actualTime = chore.getCompletionTime();
            if (estimate >= 60){
                difficulty = 2;
            }
            if (estimate < 60 && estimate >= 30){
                difficulty = 1.5f;
            }
            if (estimate < 30 && estimate >= 0){
                difficulty = 1;
            } else {
                System.out.println("ERROR: Invalid estimate");
            }
            
            if(actualTime < estimate){
                time = (estimate - actualTime) * difficulty; // SCENARIO (50 - 30) * 1.5 =  30
            } else{
                time = (((actualTime - estimate) * -1) * difficulty) * 0.5f; // SCENARIO (((30 - 50) * -1) * 1.5) * 0.5 = 15
                System.out.println(time);
            }
            points = Math.round(time);
            
        }
        if(activeUser == 2){
            estimate = chore.getEstimateTimeUserTwo();
            actualTime = chore.getCompletionTime();
            if (estimate >= 60){
                difficulty = 2;
            }
            if (estimate < 60 && estimate >= 30){
                difficulty = 1.5f;
            }
            if (estimate < 30 && estimate >= 0){
                difficulty = 1;
            } else {
                System.out.println("ERROR: Invalid estimate");
            }
            
            if(actualTime < estimate){
                time = (estimate - actualTime) * difficulty; // SCENARIO (50 - 30) * 1.5 =  30
            } else{
                time = (((actualTime - estimate) * -1) * difficulty) * 0.5f; // SCENARIO (((30 - 50) * -1) * 1.5) * 0.5 = 15
                System.out.println("Wat: "+time);
            }
            points = Math.round(time); // Round points to whole number
        }
        
        return points;
    }
    
    // Set the users total at end of week
    public void totalCalculation(User user){ // Set the users total at end of week
       int total = user.getUserTotalScore();
       int weekScore = user.getUserWeekScore();
       
       total = total + weekScore;
       
       user.setUserTotalScore(total);
    }
}

