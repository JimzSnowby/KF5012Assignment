/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.kf5012assessment;

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
 // Declare two ArrayLists to store estimated chore times for each user
ArrayList<Integer> user1EstimatedTimes = new ArrayList<Integer>();
ArrayList<Integer> user2EstimatedTimes = new ArrayList<Integer>();

    /**
     * Creates new form EstimateTimeInputGUI
     */


    public EstimateTimeInputGUI(ArrayList<Chore>choresArrayList) {
        this.choresArrayList = choresArrayList;
        for (int i = 0; i < users.getUserList().size(); i++) {
            System.out.println(users.getUserList().get(i).getId());
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changeUserForEstimateTime = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        estimateTimeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        submitEstimeTime = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        changeUserForEstimateTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User 1", "User 2" }));
        changeUserForEstimateTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUserForEstimateTimeActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(estimateTimeTable);

        jLabel1.setText("Select User:");

        submitEstimeTime.setText("Submit");
        submitEstimeTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEstimeTimeActionPerformed(evt);
            }
        });

        jMenu1.setText("Home");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitEstimeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(changeUserForEstimateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeUserForEstimateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(submitEstimeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitEstimeTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEstimeTimeActionPerformed


// Get the selected user from the dropdown menu
String selectedUser = (String) changeUserForEstimateTime.getSelectedItem();

// Loop over each row in the estimateTimeTable
for (int i = 0; i < estimateTimeTable.getRowCount(); i++) {
    // Get the name of the chore from the first column
    String choreName = (String) estimateTimeTable.getValueAt(i, 0);

    // Get the estimated time for the chore from the second column
    int estimatedTime = (int) estimateTimeTable.getValueAt(i, 1);

    // Store the estimated time in the corresponding ArrayList
    if (selectedUser.equals("user1")) {
        user1EstimatedTimes.add(estimatedTime);
    } else if (selectedUser.equals("user2")) {
        user2EstimatedTimes.add(estimatedTime);
    }
}

// Print the estimated times for each user for debugging purposes
if (selectedUser.equals("user1")) {
    System.out.println("User 1's estimated times: " + user1EstimatedTimes);
} else if (selectedUser.equals("user2")) {
    System.out.println("User 2's estimated times: " + user2EstimatedTimes);
}

// Show a success message to the user
JOptionPane.showMessageDialog(this, "Your estimates have been recorded.", "Success", JOptionPane.INFORMATION_MESSAGE);

// Close this GUI
this.dispose();
    }//GEN-LAST:event_submitEstimeTimeActionPerformed

    private void changeUserForEstimateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserForEstimateTimeActionPerformed
    // Get the selected user from the dropdown menu
String selectedUser = (String) changeUserForEstimateTime.getSelectedItem();

// Clear the existing values in the estimateTimeTable
DefaultTableModel model = (DefaultTableModel) estimateTimeTable.getModel();
model.setRowCount(0);

// Populate the table with the corresponding user's chore estimate times
if (selectedUser.equals("user1")) {
    for (Integer estimatedTime : user1EstimatedTimes) {
        model.addRow(new Object[]{"", estimatedTime});
    }
} else if (selectedUser.equals("user2")) {
    for (Integer estimatedTime : user2EstimatedTimes) {
        model.addRow(new Object[]{"", estimatedTime});
    }
}

    
    }//GEN-LAST:event_changeUserForEstimateTimeActionPerformed

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

   ArrayList<Chore> choresArrayList = new ArrayList<>();
    EstimateTimeInputGUI gui = new EstimateTimeInputGUI(choresArrayList);
    gui.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> changeUserForEstimateTime;
    private javax.swing.JTable estimateTimeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitEstimeTime;
    // End of variables declaration//GEN-END:variables
}
