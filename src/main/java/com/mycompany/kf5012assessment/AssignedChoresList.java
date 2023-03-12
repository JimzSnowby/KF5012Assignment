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
    private List<Chore> mon = new ArrayList();
    private List<Chore> tues = new ArrayList();
    private List<Chore> wed = new ArrayList();
    private List<Chore> thur = new ArrayList();
    private List<Chore> fri = new ArrayList();
    private List<Chore> sat = new ArrayList();
    private List<Chore> sun = new ArrayList();

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
                mon.add(chore);
                break;
            case 2:
                tues.add(chore);
                break;
            case 3:
                wed.add(chore);
                break;
            case 4:
                thur.add(chore);
                break;
            case 5:
                fri.add(chore);
                break;
            case 6:
                sat.add(chore);
                break;
            case 7:
                sun.add(chore);
                break;
            default:
                throw new IndexOutOfBoundsException("case must be between 1-7");
        }
    }
    
    public void removeFromChoreList(Chore chore){
        assignedChoresList.remove(chore);
        switch (chore.getDay()) {
            case 1:
                mon.remove(chore);
                break;
            case 2:
                tues.remove(chore);
                break;
            case 3:
                wed.remove(chore);
                break;
            case 4:
                thur.remove(chore);
                break;
            case 5:
                fri.remove(chore);
                break;
            case 6:
                sat.remove(chore);
                break;
            case 7:
                sun.remove(chore);
                break;
            default:
                throw new IndexOutOfBoundsException("case must be between 1-7");
        }
    }

    public List<Chore> getMon() {
        return mon;
    }

    public void setMon(List<Chore> mon) {
        this.mon = mon;
    }

    public List<Chore> getTues() {
        return tues;
    }

    public void setTues(List<Chore> tues) {
        this.tues = tues;
    }

    public List<Chore> getWed() {
        return wed;
    }

    public void setWed(List<Chore> wed) {
        this.wed = wed;
    }

    public List<Chore> getThur() {
        return thur;
    }

    public void setThur(List<Chore> thur) {
        this.thur = thur;
    }

    public List<Chore> getFri() {
        return fri;
    }

    public void setFri(List<Chore> fri) {
        this.fri = fri;
    }

    public List<Chore> getSat() {
        return sat;
    }

    public void setSat(List<Chore> sat) {
        this.sat = sat;
    }

    public List<Chore> getSun() {
        return sun;
    }

    public void setSun(List<Chore> sun) {
        this.sun = sun;
    }
}
