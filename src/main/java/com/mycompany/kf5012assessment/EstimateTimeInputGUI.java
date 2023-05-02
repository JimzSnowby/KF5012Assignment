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
    ArrayList<Integer> userOneEstimatedTimes = new ArrayList<Integer>();
    ArrayList<Integer> userTwoEstimatedTimes = new ArrayList<Integer>();

    /**
     * Creates new form EstimateTimeInputGUI
     */
    private int currectUser;

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) estimateTimeTable.getModel();
        model.setRowCount(0);
        for (int i = 0; i < choresArrayList.size(); i++) {
            Chore c = choresArrayList.get(i);
            if (c.isSelectedForThisWeek()) {
                model.addRow(new Object[]{c.getChoreName(), c.getEstimateTimeUserOne()});
            }
        }
    }

    public EstimateTimeInputGUI(int selectedUsers) {
        currectUser = selectedUsers;
        ChoresDatabase choresDB = new ChoresDatabase();

        try {
            choresArrayList = choresDB.selectChores();
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
        //testing 
        choresArrayList.get(3).setSelectedForThisWeek(true);
        choresArrayList.get(5).setSelectedForThisWeek(true);
        choresArrayList.get(1).setSelectedForThisWeek(true);

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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

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
        jScrollPane1.setViewportView(estimateTimeTable);

        nameLabelb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabelb.setText("Select User:");

        submitEstimeTime.setText("Submit");
        submitEstimeTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEstimeTimeActionPerformed(evt);
            }
        });

        jMenu1.setText("Home");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(nameLabelb, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(nameLabelb)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(submitEstimeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        nameLabelb.getAccessibleContext().setAccessibleName("ERROR");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitEstimeTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEstimeTimeActionPerformed

// Get the selected user from the dropdown menu
//String selectedUser = (String) changeUserForEstimateTime.getSelectedItem();
// Loop over each row in the estimateTimeTable
        for (int i = 0; i < estimateTimeTable.getRowCount(); i++) {
            // Get the name of the chore from the first column
            String choreName = (String) estimateTimeTable.getValueAt(i, 0);

            // Get the estimated time for the chore from the second column
            int estimatedTime = (int) estimateTimeTable.getValueAt(i, 1);

// Show a success message to the user
            JOptionPane.showMessageDialog(this, "Your estimates have been recorded.", "Success", JOptionPane.INFORMATION_MESSAGE);

// Close this GUI
            this.dispose();
    }//GEN-LAST:event_submitEstimeTimeActionPerformed
       }

       /*
    private void changeUserForEstimateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserForEstimateTimeActionPerformed
 
    }//GEN-LAST:event_changeUserForEstimateTimeActionPerformed
*/

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

        HomePageGUI homeGUI = new HomePageGUI();
        homeGUI.setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

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
    private javax.swing.JTable estimateTimeTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabelb;
    private javax.swing.JButton submitEstimeTime;
    // End of variables declaration//GEN-END:variables
}
