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

    public List<Chore> getAssignedChoresList() {
        return assignedChoresList;
    }

    public void setAssignedChoresList(List<Chore> assignedChoresList) {
        this.assignedChoresList = assignedChoresList;
    }
    
    public void addToChoreList(Chore chore){
        assignedChoresList.add(chore);
        switch (chore.getDay()) {
            case 1:
                chore.setDay(1);
                break;
            case 2:
                chore.setDay(2);
                break;
            case 3:
                chore.setDay(3);
                break;
            case 4:
                chore.setDay(4);
                break;
            case 5:
                chore.setDay(5);
                break;
            case 6:
                chore.setDay(6);
                break;
            case 7:
                chore.setDay(7);
                break;
            case 8:
                chore.setDay(8);
                break;
            default:
                throw new IndexOutOfBoundsException("case must be between 1-8");
        }
    }
    
    public void removeFromChoreList(Chore chore){
        assignedChoresList.remove(chore);
        
    }
    
}
