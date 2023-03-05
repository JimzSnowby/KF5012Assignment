/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mavenproject1.mavenproject2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author majabosy
 */
public class ChoresDatabase {

    private DBConnection database;

    public ChoresDatabase() {
        database = new DBConnection();
        database.Connect("/Users/majabosy/NetBeansProjects/kf5012/src/main/java/mavenproject1/mavenproject2/kf5012db.db");
    }

    /**
     *
     * Functions to be included here
     *
     */
   

}
