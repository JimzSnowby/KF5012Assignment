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
// Nihal Kejman 
// This is a list of users
public class UserList {
    private List<User> userList = new ArrayList(); //This is the list of all the users

    public UserList() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
