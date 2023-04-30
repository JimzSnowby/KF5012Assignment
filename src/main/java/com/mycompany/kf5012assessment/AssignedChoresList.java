/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.util.*;

/**
 *
 * @author w21023500
 */
// Group work, This is the list of chores that a user has been assigned
public class AssignedChoresList {
    private List<Chore> assignedChoresList = new ArrayList();

    //Constructor
    public AssignedChoresList() {
    }

    
    public List<Chore> getAssignedChoresList() {
        return assignedChoresList;
    }

    public void setAssignedChoresList(List<Chore> assignedChoresList) {
        this.assignedChoresList = assignedChoresList;
    }
    
    public void addToChoreList(Chore chore){
        assignedChoresList.add(chore);
        switch (chore.getChoreDay()) {
            case 1:
                chore.setChoreDay(1);
                break;
            case 2:
                chore.setChoreDay(2);
                break;
            case 3:
                chore.setChoreDay(3);
                break;
            case 4:
                chore.setChoreDay(4);
                break;
            case 5:
                chore.setChoreDay(5);
                break;
            case 6:
                chore.setChoreDay(6);
                break;
            case 7:
                chore.setChoreDay(7);
                break;
            case 8:
                chore.setChoreDay(8);
                break;
            default:
                throw new IndexOutOfBoundsException("case must be between 1-8");
        }
    }
    
    public void removeFromChoreList(Chore chore){
        assignedChoresList.remove(chore);
        
    }
    
}
