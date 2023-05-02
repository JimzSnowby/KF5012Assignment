/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author james
 */
public class AssignedChoresGUI extends javax.swing.JFrame {
    private AssignedChoresList dummyList;
    private ArrayList<User> usersList = new ArrayList(); // List of system users
    private ArrayList<Chore> allChores = new ArrayList(); // list of all chores
    private ArrayList<Chore> user1List = new ArrayList(); // list of chores assigned to user1
    private ArrayList<Chore> user2List = new ArrayList(); // list of chores assigned to user2
    private String choreCount;
    private int currentUser;
    private ChoresDatabase choresDB = new ChoresDatabase();

    /*
     * Creates new form AssignedChoresGUI
     */
    public AssignedChoresGUI() {
        try {
            usersList = choresDB.selectUsers();
            allChores = choresDB.selectChores();
            for (Chore c : allChores){
                if(c.getChoreAssignTo() == 1){
                    user1List.add(c);
                }
                else if (c.getChoreAssignTo() == 2){
                    user2List.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
        initComponents(); // Initializes GUI elements, PUT ALL METHODS AFTER THIS
        
        choreCount = Integer.toString(user1List.size());
        
        totalChores.setText(choreCount);
        int selection = daySelector.getSelectedIndex();
        for (User u : usersList){
                if (u.isUserActive() == 1){
                    currentUser = u.getUserID();
                    updateDisplayTableDataUser1(selection);
                    System.out.println(currentUser);
                    break;
                } else if (u.isUserActive() == 2){
                    currentUser = u.getUserID();
                    updateDisplayTableDataUser2(selection);
                    break;
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

        Title = new javax.swing.JLabel();
        daySelector = new javax.swing.JComboBox<>();
        tableContainer = new javax.swing.JScrollPane();
        choreTable = new javax.swing.JTable();
        daySelectorLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        weekScoreLabel = new javax.swing.JLabel();
        totalScoreLabel = new javax.swing.JLabel();
        weekScore = new javax.swing.JLabel();
        totalScore = new javax.swing.JLabel();
        totalChores = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("This weeks chores");
        setResizable(false);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Title.setText("Chores Left:");

        daySelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Any day" }));
        daySelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daySelectorActionPerformed(evt);
            }
        });

        choreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Chore", "Complete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
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
        choreTable.getTableHeader().setReorderingAllowed(false);
        tableContainer.setViewportView(choreTable);
        if (choreTable.getColumnModel().getColumnCount() > 0) {
            choreTable.getColumnModel().getColumn(0).setResizable(false);
            choreTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            choreTable.getColumnModel().getColumn(1).setResizable(false);
        }

        daySelectorLabel.setText("Day of the week:");

        cancelButton.setText("cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("accept");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        weekScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        weekScoreLabel.setText("This weeks score:");

        totalScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalScoreLabel.setText("Total score:");

        weekScore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        weekScore.setText("0");

        totalScore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalScore.setText("0");

        totalChores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalChores.setText("0");

        menuFile.setText("File");
        menuBar.add(menuFile);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalScoreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(daySelectorLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(daySelector, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(totalScore))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(weekScoreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(weekScore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalChores)
                                .addGap(45, 45, 45))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weekScoreLabel)
                    .addComponent(weekScore)
                    .addComponent(Title)
                    .addComponent(totalChores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalScoreLabel)
                    .addComponent(totalScore))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daySelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daySelectorLabel))
                .addGap(21, 21, 21)
                .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(acceptButton))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daySelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daySelectorActionPerformed
       int selection = daySelector.getSelectedIndex();
       for (User u : usersList){
                if (u.isUserActive() == 1){
                    updateDisplayTableDataUser1(selection);
                    
                } else if (u.isUserActive() == 2){
                    updateDisplayTableDataUser2(selection);
                    
                }
        }
       
    }//GEN-LAST:event_daySelectorActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        System.out.println("Accept Pressed");
        System.out.println("Current user: " + currentUser);
        submitData();
        if (currentUser == 1){
            updateDisplayTableDataUser1(daySelector.getSelectedIndex());
            choreCount = Integer.toString(user1List.size());

        } else if (currentUser == 2){
            updateDisplayTableDataUser2(daySelector.getSelectedIndex());
            choreCount = Integer.toString(user2List.size());

        }
        
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed

this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AssignedChoresGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignedChoresGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignedChoresGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignedChoresGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignedChoresGUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable choreTable;
    private javax.swing.JComboBox<String> daySelector;
    private javax.swing.JLabel daySelectorLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JScrollPane tableContainer;
    private javax.swing.JLabel totalChores;
    private javax.swing.JLabel totalScore;
    private javax.swing.JLabel totalScoreLabel;
    private javax.swing.JLabel weekScore;
    private javax.swing.JLabel weekScoreLabel;
    // End of variables declaration//GEN-END:variables
    
    public void updateDisplayTableDataUser1(int selection){
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);
        
        ArrayList<Chore> list = new ArrayList(); // Temp list to update the table
        
        switch (selection){
            case 0:
                for (Chore c : user1List){
                    if (c.getChoreDay() == 1){
                        list.add(c);
                    }
                }
                System.out.println("Monday");
                break;
            case 1:
                for (Chore c : user1List){
                    if (c.getChoreDay() == 2){
                        list.add(c);
                    }
                }
                System.out.println("Tuesday");
                break;
            case 2:
                for (Chore c : user1List){
                    if (c.getChoreDay() == 3){
                        list.add(c);
                    }
                }
                System.out.println("Wednesday");
                break;
            case 3:
                for (Chore c : user1List){
                    if (c.getChoreDay() == 4){
                        list.add(c);
                    }
                }
                System.out.println("Thursday");
                break;
            case 4:
                for (Chore c : user1List){
                    if (c.getChoreDay() == 5){
                        list.add(c);
                    }
                }
                System.out.println("Friday");
                break;
            case 5:
                for (Chore c : user1List){
                    if (c.getChoreDay() == 6){
                        list.add(c);
                    }
                }
                System.out.println("Saturday");
                break;
            case 6:
                for (Chore c : user1List){
                    if (c.getChoreDay() == 7){
                        list.add(c);
                    }
                }
                System.out.println("Sunday");
                break;
            case 7:
                for (Chore c : user1List){
                    if (c.getChoreDay() == 8){
                        list.add(c);
                    }
                }
                System.out.println("Any day");
                break;
            default:
                for (Chore c : user1List){
                    list.add(c);
                }
                System.out.println("Default case");
                break;
        }
        
        for(int i = 0; i < list.size(); i++){
            tableModel.addRow(new Object[]{list.get(i).getChoreName(), list.get(i).isChoreComplete()});
            
        }
        
    }
    
    public void updateDisplayTableDataUser2(int selection){
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);
        
        ArrayList<Chore> list = new ArrayList(); // Temp list to update the table
        
        switch (selection){
            case 0:
                for (Chore c : user2List){
                    if (c.getChoreDay() == 1){
                        list.add(c);
                    }
                }
                System.out.println("Monday");
                break;
            case 1:
                for (Chore c : user2List){
                    if (c.getChoreDay() == 2){
                        list.add(c);
                    }
                }
                System.out.println("Tuesday");
                break;
            case 2:
                for (Chore c : user2List){
                    if (c.getChoreDay() == 3){
                        list.add(c);
                    }
                }
                System.out.println("Wednesday");
                break;
            case 3:
                for (Chore c : user2List){
                    if (c.getChoreDay() == 4){
                        list.add(c);
                    }
                }
                System.out.println("Thursday");
                break;
            case 4:
                for (Chore c : user2List){
                    if (c.getChoreDay() == 5){
                        list.add(c);
                    }
                }
                System.out.println("Friday");
                break;
            case 5:
                for (Chore c : user2List){
                    if (c.getChoreDay() == 6){
                        list.add(c);
                    }
                }
                System.out.println("Saturday");
                break;
            case 6:
                for (Chore c : user2List){
                    if (c.getChoreDay() == 7){
                        list.add(c);
                    }
                }
                System.out.println("Sunday");
                break;
            case 7:
                for (Chore c : user2List){
                    if (c.getChoreDay() == 78){
                        list.add(c);
                    }
                }
                System.out.println("Sunday");
                break;
            default:
                for (Chore c : user2List){
                    list.add(c);
                }
                System.out.println("Default case");
                break;
        }
        
        for(int i = 0; i < list.size(); i++){
            tableModel.addRow(new Object[]{list.get(i).getChoreName(), list.get(i).isChoreComplete()});
        }
        
    }
    
    public void submitData(){
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        boolean checkBox; 
        
        // Iterates over the list to see which chores have their completed box ticked
        /*for(int i  = 0; i < dummyList.getAssignedChoresList().size(); i++){
            try {
                checkBox = (boolean) tableModel.getValueAt(i, 2);
                if (checkBox) {
                    System.out.println("Checked");
                }else{
                    System.out.println("Not Checked");
                }
            }catch(Exception e){
                
            }
        }*/
        if (currentUser == 1) {
            for (int i = 0; i < user1List.size(); i++) {
                try {
                    checkBox = (boolean) tableModel.getValueAt(i, 1);
                    System.out.println(checkBox);
                    if (checkBox) {
                        if (user1List.get(i).getChoreFrequencyID() == 2) {
                            choresDB.deleteChore(user1List.get(i).getChoreName());
                        }
                        user1List.remove(i); // Remove from temp list
                    } else {
                        System.out.println("Not checked");
                    }
                } catch (Exception e) {
                    System.out.println("Submit Error: " + e);
                }
            }
        }
        if (currentUser == 2) {
            for (int i = 0; i < user2List.size(); i++) {
                try {
                    checkBox = (boolean) tableModel.getValueAt(i, 1);
                    if (checkBox) {
                        
                        if (user2List.get(i).getChoreFrequencyID() == 2) {
                            choresDB.deleteChore(user2List.get(i).getChoreName());
                            System.out.println("Submit Success");
                        }
                        user2List.remove(i); // Remove from temp list
                        choreCount = Integer.toString(user2List.size());
                    }
                } catch (Exception e) {
                    System.out.println("Submit Error: " + e);
                }
            }
        }

        
    }
    
    public int awardPoints(){
        
        int difficulty = 1;
        // Algorithm if faster than estimate
            // (EstimateTime - ActualTime) * choreDifficulty(Based on time, < 15 min is easy = 1, < 30 min is med =  1.5, > 30 is hard  = 2)
        // Algorithm if slower than estimate, has a 5-10 minute leeway on lateness
            // ((ActualTime - EstimateTime) * difficulty) * 0.5
        
        return 1;
    }    
    
}

