/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author w21023500
 */
public class EstimateTimeInputGUI extends javax.swing.JFrame {

    private ArrayList<Chore> choresArrayList;
    private ChoresDatabase db = new ChoresDatabase();
    private UserList users = new UserList();

    private ChoresDatabase choresDB = new ChoresDatabase();
    private boolean hasSubmitUser1 = false;
    private boolean hasSubmitUser2 = false;

    /**
     * Creates new form EstimateTimeInputGUI
     */
    private int currectUser;

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) estimateTimeTable.getModel();
        model.setRowCount(0);
        ChoresDatabase choresDB = new ChoresDatabase();
        choresArrayList = new ArrayList();
        try {
            choresArrayList = choresDB.selectedThisWeekChores();
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }

        for (Chore chore : choresArrayList) {
            model.addRow(new Object[]{
                chore.getChoreName(),
                (currectUser == 1) ? chore.getEstimateTimeUserOne() : chore.getEstimateTimeUserTwo()
            });
        }
    }

    public EstimateTimeInputGUI(int selectedUsers) {
        currectUser = selectedUsers;
        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            choresArrayList = choresDB.selectedThisWeekChores();
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
        //testing 
        //choresArrayList.get(3).setSelectedForThisWeek(true);
        //  choresArrayList.get(5).setSelectedForThisWeek(true);
        //   choresArrayList.get(1).setSelectedForThisWeek(true);

        for (int i = 0; i < users.getUserList().size(); i++) {
            System.out.println(users.getUserList().get(i).getUserID());
            // estimateTimeTable.add(Chore)
        }

        initComponents();
        updateTable();
        if (selectedUsers == 1) {

            nameLabelb.setText("Bob");

        } else {
            if (selectedUsers == 2) {
                nameLabelb.setText("Alice");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        estimateTimeTable = new javax.swing.JTable();
        nameLabelb = new javax.swing.JLabel();
        submitEstimeTime = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        viewAssignedChoresButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menueButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        estimateTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Chore", "Estimate Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        estimateTimeTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                estimateTimeTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(estimateTimeTable);

        nameLabelb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabelb.setText("Select User:");

        submitEstimeTime.setText("Submit");
        submitEstimeTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEstimeTimeActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        viewAssignedChoresButton.setText("View Assigned Chores");
        viewAssignedChoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAssignedChoresButtonActionPerformed(evt);
            }
        });

        menueButton.setText("Home");
        menueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menueButtonActionPerformed(evt);
            }
        });
        jMenuBar1.add(menueButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(nameLabelb, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewAssignedChoresButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitEstimeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabelb)
                    .addComponent(viewAssignedChoresButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(submitEstimeTime, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        nameLabelb.getAccessibleContext().setAccessibleName("ERROR");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitEstimeTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEstimeTimeActionPerformed
        DefaultTableModel model = (DefaultTableModel) estimateTimeTable.getModel();
        int numRows = model.getRowCount();
        boolean hasError = false;

        // Loop through the rows in the table
        for (int i = 0; i < numRows; i++) {
            Chore chore = choresArrayList.get(i);
            // Get the estimated time value from the table
            String estTimeStr = model.getValueAt(i, 1).toString().trim();

            // Validate the estimated time value
            if (!estTimeStr.matches("^\\d*$") ) {
                JOptionPane.showMessageDialog(this, "Please enter a valid estimated time value!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                hasError = true;
                break;
            } else {
            }

            int estimatedTime = Integer.parseInt(estTimeStr);

            if (estimatedTime < 5 || estimatedTime > 120) {
                JOptionPane.showMessageDialog(this, "Estimated time must be between 5 and 120 minutes.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                hasError = true;
                break; // it will exit the method if theinput is invalid
            }

            // Set the estimated time value for the chore
            if (currectUser == 1) {
                chore.setEstimateTimeUserOne(estimatedTime);
            } else if (currectUser == 2) {
                chore.setEstimateTimeUserTwo(estimatedTime);
            }
            System.out.println("Estimated time for " + currectUser + ": " + estimatedTime);

            // Insert the estimated time value into the database
            ChoresDatabase choresDB = new ChoresDatabase();
            ChoresDatabase.newchore = chore;
            try {
                //if its bob than we will use updateEstimateTimeUserOne method from the database 
                if (currectUser == 1) {
                    choresDB.updateEstimateTimeUserOne();
                } else if (currectUser == 2) {

                    hasSubmitUser1 = true;
                } else if (currectUser == 2) {
                    choresDB.updateEstimateTimeUserTwo();
                    hasSubmitUser2 = true;
                }

                if (hasSubmitUser1 && hasSubmitUser2) {
                    try {
                        AssigningChoresAlgo algo = new AssigningChoresAlgo();
                    } catch (SQLException e) {
                        System.out.println("Error occurred in extracting data");
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        }

        // If there is no error occurred, it will than show a pop-up message with the user's chores and estimated times
        if (!hasError) {
            String message = "Your selected chores for this week with your estimate time:\n";
            for (Chore chore : choresArrayList) {
                if (currectUser == 1 && chore.getEstimateTimeUserOne() > 0) {
                    message += "\n- " + chore.getChoreName() + ": " + chore.getEstimateTimeUserOne() + " minutes";
                } else if (currectUser == 2 && chore.getEstimateTimeUserTwo() > 0) {
                    message += "\n- " + chore.getChoreName() + ": " + chore.getEstimateTimeUserTwo() + " minutes";
                }
            }
            JOptionPane.showMessageDialog(this, message, "Selected Chores", JOptionPane.INFORMATION_MESSAGE);
            // Clear the table and update it with the new estimated time values
            model.setRowCount(0);
            updateTable();
            this.dispose();
        }
    }//GEN-LAST:event_submitEstimeTimeActionPerformed


    /*
    private void changeUserForEstimateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserForEstimateTimeActionPerformed
 
    }//GEN-LAST:event_changeUserForEstimateTimeActionPerformed
*/

    private void menueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menueButtonActionPerformed

        HomePageGUI homeGUI = new HomePageGUI();
        homeGUI.setVisible(true);
    }//GEN-LAST:event_menueButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed

        // Show a confirmation dialog to make sure the user really wants to cancel
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);

        // If the user confirms that they want to cancel, close the window
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void viewAssignedChoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAssignedChoresButtonActionPerformed
        AssignedChoresGUI assignedChoresButton = new AssignedChoresGUI();
        assignedChoresButton.setVisible(true);
    }//GEN-LAST:event_viewAssignedChoresButtonActionPerformed

    // This method is called when a key is pressed on the estimateTimeTable

    private void estimateTimeTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estimateTimeTableKeyPressed

        int keyCode = evt.getKeyCode();
        int selectedRow = estimateTimeTable.getSelectedRow();
        int selectedColumn = estimateTimeTable.getSelectedColumn();

        if (keyCode == KeyEvent.VK_TAB) {
            if (selectedColumn < estimateTimeTable.getColumnCount() - 1) {
                estimateTimeTable.setColumnSelectionInterval(selectedColumn + 1, selectedColumn + 1);
            } else if (selectedRow < estimateTimeTable.getRowCount() - 1) {
                estimateTimeTable.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
                estimateTimeTable.setColumnSelectionInterval(0, 0);
            }
            evt.consume();
        }
    }//GEN-LAST:event_estimateTimeTableKeyPressed

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
            java.util.logging.Logger.getLogger(EstimateTimeInputGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstimateTimeInputGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstimateTimeInputGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstimateTimeInputGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //EstimateTimeInputGUI gui = new EstimateTimeInputGUI();
        // gui.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable estimateTimeTable;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menueButton;
    private javax.swing.JLabel nameLabelb;
    private javax.swing.JButton submitEstimeTime;
    private javax.swing.JButton viewAssignedChoresButton;
    // End of variables declaration//GEN-END:variables
}
