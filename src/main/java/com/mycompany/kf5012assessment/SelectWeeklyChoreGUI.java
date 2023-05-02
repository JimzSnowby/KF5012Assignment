/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author w21023500
 */
public class SelectWeeklyChoreGUI extends javax.swing.JFrame {

    /**
     * Creates new form SelectWeeklyChoreGUI
     */
    // Define a private ArrayList of Strings to store the chores
    private ArrayList<Chore> choresArrayList;

    public SelectWeeklyChoreGUI() {
        // initialize a new instance of ChoresDatabase and create a list of chores by calling its selectChores() method
        ChoresDatabase choresDB = new ChoresDatabase();
        choresArrayList = new ArrayList();
        try {
            choresArrayList = choresDB.selectChores();
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
        //forces chore 2 to be tuesday
        //choresArrayList.get(2).setDay(2);

        choresArrayList.get(1);
          choresArrayList.get(2);


        initComponents();

        // call updateTableData() to populate the table with data
        updateTableForSelectedDay(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choreScrollPane = new javax.swing.JScrollPane();
        choreTable = new javax.swing.JTable();
        chooseDayChore = new javax.swing.JComboBox<>();
        chooseChoreLabel = new javax.swing.JLabel();
        submitChoreButton = new javax.swing.JButton();
        addChoreButton = new javax.swing.JButton();
        menueBarOne = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        choreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Task", "Today"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        choreTable.setFocusTraversalPolicyProvider(true);
        choreScrollPane.setViewportView(choreTable);

        chooseDayChore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any day", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        chooseDayChore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDayChoreActionPerformed(evt);
            }
        });

        chooseChoreLabel.setText("Choose day of chores ");

        submitChoreButton.setText("Submit");
        submitChoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitChoreButtonActionPerformed(evt);
            }
        });

        addChoreButton.setText("Add Chore");
        addChoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChoreButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("Home");
        menueBarOne.add(jMenu1);

        setJMenuBar(menueBarOne);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choreScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooseChoreLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooseDayChore, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addChoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitChoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseChoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseDayChore, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addChoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(choreScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(submitChoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addChore(String choreName, String choreType, List<String> days) {
        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            Chore newChore = new Chore();
            //    choresDB.addChore(newChore);
            choresArrayList.add(newChore);
            JOptionPane.showMessageDialog(null, "New chore added successfully");
        } catch (Exception e) {
            System.out.println("Error occured in inserting data");
            JOptionPane.showMessageDialog(null, "Error occured in adding chore");
        }

        updateTableForSelectedDay(chooseDayChore.getSelectedIndex() - 1);
    }

    private void chooseDayChoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDayChoreActionPerformed
        // TODO add your handling code here:
        // Object selected = chooseDayChore.getSelectedItem();
        int dayNumber = chooseDayChore.getSelectedIndex();
        System.out.println("Event happened");
        updateTableForSelectedDay(dayNumber);
    }//GEN-LAST:event_chooseDayChoreActionPerformed

    private void addChoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChoreButtonActionPerformed
        CreateNewChoreGUI addChoreGUI = new CreateNewChoreGUI(this, true);
        addChoreGUI.setVisible(true);
        addChoreGUI.pack();
        addChoreGUI.setLocationRelativeTo(null);
        addChoreGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_addChoreButtonActionPerformed

    private void submitChoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitChoreButtonActionPerformed
                                                 
        // iterate over the choresArrayList and update the database with the selected day
    ChoresDatabase choresDB = new ChoresDatabase();
    for (int i = 0; i < choresArrayList.size(); i++) {
        Chore chore = choresArrayList.get(i);
        int day = chore.getChoreDay();
        int newDay = chooseDayChore.getSelectedIndex() - 1;
        if (day != newDay) {
            chore.setChoreDay(newDay);
           
            // Update chore's selection status
            if (newDay != -1) {
                try {
                    choresDB.updateToSelected();
                } catch (SQLException ex) {
                    Logger.getLogger(SelectWeeklyChoreGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                try {
                    choresDB.updateToUnselected();
                } catch (SQLException ex) {
                    Logger.getLogger(SelectWeeklyChoreGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } // handle exception
        }
    }

    // update the table to reflect the changes
    updateTableForSelectedDay(chooseDayChore.getSelectedIndex() - 1);

    this.dispose();

    }//GEN-LAST:event_submitChoreButtonActionPerformed
    private void addNewChore(String task, int day) {
        // Create a new instance of Chore with the given task and day
        Chore newChore = new Chore();
        newChore.setChoreName(task);
        newChore.setChoreDay(day);

        // Add the new chore to the list of chores in memory
        choresArrayList.add(newChore);

        // Add the new chore to the database
        ChoresDatabase choresDB = new ChoresDatabase();
        try {
            //  choresDB.insertChore(newChore);
        } catch (Exception e) {
            System.out.println("Error occurred while inserting chore to database");
        }

        // Update the table to show the new chore
        updateTableForSelectedDay(0);
    }

    public void displayTableData(ChoreList tableData) {
        // Empty the existing data
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);

    }
//takes the data from thable an writes the data back to the arraylist 

    public void recordTableChanges() {
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {  // Loop through the rows

            String choreName = (String) tableModel.getValueAt(i, 0);
            for (Chore nc : choresArrayList) {

                if (nc.getChoreName() == choreName) {
                    nc.setSelectedForThisWeek((boolean) tableModel.getValueAt(i, 1));
                }

            }

        }

    }
// selected day fuction 

    public void updateTableForSelectedDay(int dayNumberselected) {
        recordTableChanges();
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);

        // Iterate through the list and add each chore's data to the table
        for (int i = 0; i < choresArrayList.size(); i++) {
            if (choresArrayList.get(i).getChoreDay() == dayNumberselected) {
                tableModel.addRow(new Object[]{choresArrayList.get(i).getChoreName(), choresArrayList.get(i).isSelectedForThisWeek()});

            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectWeeklyChoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectWeeklyChoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectWeeklyChoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectWeeklyChoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectWeeklyChoreGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addChoreButton;
    private javax.swing.JLabel chooseChoreLabel;
    private javax.swing.JComboBox<String> chooseDayChore;
    private javax.swing.JScrollPane choreScrollPane;
    private javax.swing.JTable choreTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menueBarOne;
    private javax.swing.JButton submitChoreButton;
    // End of variables declaration//GEN-END:variables

}
