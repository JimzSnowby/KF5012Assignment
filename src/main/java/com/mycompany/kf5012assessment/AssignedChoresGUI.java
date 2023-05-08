/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.util.*;
import javax.swing.table.*;
import java.time.*;

/**
 *
 * @author james
 */
public class AssignedChoresGUI extends javax.swing.JFrame {

    private ChoresDatabase choresDB = new ChoresDatabase(); // Connect to DB
    private ArrayList<User> usersList = new ArrayList(); // list of system users
    private ArrayList<User> usersIDs = new ArrayList(); // list of system users
    private ArrayList<Chore> allChores = new ArrayList(); // list of all chores
    private ArrayList<Chore> user1List = new ArrayList(); // list of chores assigned to user1
    private ArrayList<Chore> user2List = new ArrayList(); // list of chores assigned to user2
    private ArrayList<Chore> user1Completed = new ArrayList(); // List of completed chores for U1
    private ArrayList<Chore> user2Completed = new ArrayList(); // AT END SEND LIST TO DB WITH 
    private String choreCount; // Number of Chores left
    private int currentUser; // gets the ID of the current user
    private User user;
    private LocalDate date = LocalDate.now(); // Get system date
    private ChoreCompletionPoints completionPoints = new ChoreCompletionPoints();

    private String highLightedChore;
    private ArrayList<ChoresAssigned> assignedChoreList = new ArrayList();

    /*
     * Creates new form AssignedChoresGUI
     */
    public AssignedChoresGUI() {
        try {
            usersList = choresDB.selectUsers();
            allChores = choresDB.selectChores();
            //allChores = choresDB.selectChoresAssigned(); //Get table of assigned chores
            
            //assignedChoreList = choresDB.selectChoresAssigned();
            
            for(Chore c : allChores){
                if (c.getChoreAssignTo() == 1 && !c.isChoreComplete()){
                    user1List.add(c);
                } else if (c.getChoreAssignTo() == 2 && !c.isChoreComplete()){
                    user2List.add(c);
                }
            }
            
           /* for(ChoresAssigned chore : assignedChoreList){
                if(chore.getUserID() == 1 && !chore.getChoreComplete()){
                    user1List.add(chore);
                }
            }*/
        
            /*for (Chore c : allChores) { // GET CHORES FOR COMPLETION
                for (User u : usersList){
                    if (u.getUserID() == 1 && !c.isChoreComplete()){
                        user1List.add(c);
                    } else if (u.getUserID() == 2 && !c.isChoreComplete()){
                        user2List.add(c);
                    }
                    
                    
                }
                if (c.getChoreAssignTo() == 1 && !c.isChoreComplete()) {
                    user1List.add(c);
                } else if (c.getChoreAssignTo() == 2 && !c.isChoreComplete()) {
                    user2List.add(c);
                }
            }*/
            
        } catch (Exception e) {
            System.out.println("Error occured in extracting data");
        }
        
        try {
            for (Chore c : allChores) { // GET COMPLETE CHORE HISTORY
                if (c.getChoreAssignTo() == 1 && c.isChoreComplete()) {
                    user1Completed.add(c);
                } else if (c.getChoreAssignTo() == 2 && c.isChoreComplete()) {
                    user2Completed.add(c);
                }
            }
        } catch (Exception e){
            System.out.println("HISTORY ERROR: " + e);
        }
        initComponents(); // Initializes GUI elements, PUT ALL METHODS AFTER THIS

        dialogSubmit.pack();
        dialogSubmit.setLocationRelativeTo(this);

        int selection = daySelector.getSelectedIndex();
        for (User u : usersList) {
            if (u.isUserActive() == 1) {
                currentUser = u.getUserID();
                user = u;
                updateDisplayTableDataUser1(selection);
                weekScore.setText(Integer.toString(u.getUserWeekScore()));
                totalScore.setText(Integer.toString(u.getUserTotalScore()));
                System.out.println(currentUser);
                choreCount = Integer.toString(user1List.size()); // Get list size as a string
                break;
            } else if (u.isUserActive() == 2) {
                currentUser = u.getUserID();
                user = u;
                updateDisplayTableDataUser2(selection);
                weekScore.setText(Integer.toString(u.getUserWeekScore()));
                totalScore.setText(Integer.toString(u.getUserTotalScore()));
                choreCount = Integer.toString(user2List.size()); // Get list size as a string
                break;
            }
        }

        totalChores.setText(choreCount); // change the total chores text
        endOfWeekAlert();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogSubmit = new javax.swing.JDialog();
        successLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        endOfWeekAlert = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        alertTable = new javax.swing.JTable();
        alertLabel = new javax.swing.JLabel();
        alertOk = new javax.swing.JButton();
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
        selectedChoreLabel = new javax.swing.JLabel();
        selectedChore = new javax.swing.JLabel();
        completionTimeLabel = new javax.swing.JLabel();
        completionTimeInput = new javax.swing.JFormattedTextField();
        viewHistoryButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();

        dialogSubmit.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogSubmit.setTitle("Success");
        dialogSubmit.setAlwaysOnTop(true);
        dialogSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dialogSubmit.setMinimumSize(new java.awt.Dimension(400, 160));
        dialogSubmit.setResizable(false);
        dialogSubmit.setType(java.awt.Window.Type.POPUP);

        successLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        successLabel.setText("Completed chores submitted successfully");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogSubmitLayout = new javax.swing.GroupLayout(dialogSubmit.getContentPane());
        dialogSubmit.getContentPane().setLayout(dialogSubmitLayout);
        dialogSubmitLayout.setHorizontalGroup(
            dialogSubmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogSubmitLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(dialogSubmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogSubmitLayout.createSequentialGroup()
                        .addComponent(successLabel)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogSubmitLayout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
        );
        dialogSubmitLayout.setVerticalGroup(
            dialogSubmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogSubmitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(successLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        endOfWeekAlert.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        endOfWeekAlert.setTitle("ALERT");
        endOfWeekAlert.setAlwaysOnTop(true);
        endOfWeekAlert.setResizable(false);
        endOfWeekAlert.setType(java.awt.Window.Type.POPUP);

        alertTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Chore"
            }
        ));
        jScrollPane1.setViewportView(alertTable);

        alertLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alertLabel.setForeground(new java.awt.Color(250, 0, 0));
        alertLabel.setText("ALERT: OUTSTANDING TASKS");

        alertOk.setText("OK");
        alertOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alertOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout endOfWeekAlertLayout = new javax.swing.GroupLayout(endOfWeekAlert.getContentPane());
        endOfWeekAlert.getContentPane().setLayout(endOfWeekAlertLayout);
        endOfWeekAlertLayout.setHorizontalGroup(
            endOfWeekAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(endOfWeekAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, endOfWeekAlertLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(alertOk)
                .addGap(153, 153, 153))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, endOfWeekAlertLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alertLabel)
                .addGap(61, 61, 61))
        );
        endOfWeekAlertLayout.setVerticalGroup(
            endOfWeekAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(endOfWeekAlertLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(alertLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alertOk)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("This weeks chores");
        setResizable(false);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Title.setText("Chores Remaining:");

        daySelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Any day" }));
        daySelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daySelectorActionPerformed(evt);
            }
        });

        choreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Chore"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        choreTable.getTableHeader().setReorderingAllowed(false);
        choreTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choreTableMouseClicked(evt);
            }
        });
        tableContainer.setViewportView(choreTable);
        if (choreTable.getColumnModel().getColumnCount() > 0) {
            choreTable.getColumnModel().getColumn(0).setResizable(false);
            choreTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        daySelectorLabel.setText("Day of the week:");

        cancelButton.setText("cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("submit");
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

        selectedChoreLabel.setText("Selected Chore:");

        selectedChore.setText("N/A");
        selectedChore.setAutoscrolls(true);
        selectedChore.setFocusable(false);

        completionTimeLabel.setText("Completion Time:");

        completionTimeInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        completionTimeInput.setActionCommand("<Not Set>");
        completionTimeInput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        completionTimeInput.setFocusable(false);
        completionTimeInput.setMinimumSize(new java.awt.Dimension(80, 22));
        completionTimeInput.setPreferredSize(new java.awt.Dimension(80, 22));
        completionTimeInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                completionTimeInputKeyTyped(evt);
            }
        });

        viewHistoryButton.setText("View History");
        viewHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHistoryButtonActionPerformed(evt);
            }
        });

        menuFile.setText("File");
        menuBar.add(menuFile);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalScoreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalScore))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(weekScoreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(weekScore))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(daySelectorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(daySelector, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectedChore)
                            .addComponent(completionTimeLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(completionTimeInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(acceptButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(viewHistoryButton)
                                .addComponent(selectedChoreLabel))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalChores)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weekScoreLabel)
                    .addComponent(weekScore)
                    .addComponent(viewHistoryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalScoreLabel)
                    .addComponent(totalScore))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(daySelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(daySelectorLabel))
                        .addGap(18, 18, 18)
                        .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(selectedChoreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedChore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(completionTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(completionTimeInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(acceptButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Title)
                        .addComponent(totalChores))
                    .addComponent(cancelButton))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daySelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daySelectorActionPerformed
        int selection = daySelector.getSelectedIndex();
        for (User u : usersList) {
            if (u.isUserActive() == 1) {
                updateDisplayTableDataUser1(selection);
            } else if (u.isUserActive() == 2) {
                updateDisplayTableDataUser2(selection);
            }
        }
    }//GEN-LAST:event_daySelectorActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        System.out.println("Current user: " + currentUser);
        if (highLightedChore == null) {
            System.out.println("No chore selected");
            // CREATE AN ERROR IF NULL

        } else {
            submitData();
            if (currentUser == 1) {
                updateDisplayTableDataUser1(daySelector.getSelectedIndex());
                updateChoreCount(1);
            }
            if (currentUser == 2) {
                updateDisplayTableDataUser2(daySelector.getSelectedIndex());
                updateChoreCount(2);
            }
            weekScore.setText(Integer.toString(user.getUserWeekScore()));
            totalScore.setText(Integer.toString(user.getUserTotalScore()));
            dialogSubmit.setVisible(true);
        }

    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dialogSubmit.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void alertOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alertOkActionPerformed
        endOfWeekAlert.dispose();
    }//GEN-LAST:event_alertOkActionPerformed

    private void choreTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choreTableMouseClicked

        int row = choreTable.rowAtPoint(evt.getPoint());
        int col = choreTable.columnAtPoint(evt.getPoint());
        Object cell;
        if (row >= 0 && col >= 0) {
            cell = choreTable.getValueAt(row, col);
            highLightedChore = cell.toString();
            selectedChore.setText(cell.toString());
            completionTimeInput.setFocusable(true);
            completionTimeInput.requestFocus();
        }

    }//GEN-LAST:event_choreTableMouseClicked

    private void completionTimeInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_completionTimeInputKeyTyped
        // If a key other than a number is typed, block it
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_completionTimeInputKeyTyped

    private void viewHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHistoryButtonActionPerformed
        CompletedChoreHistoryGUI choreCompleteGUI = new CompletedChoreHistoryGUI();
        choreCompleteGUI.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_viewHistoryButtonActionPerformed

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
    private javax.swing.JLabel alertLabel;
    private javax.swing.JButton alertOk;
    private javax.swing.JTable alertTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable choreTable;
    private javax.swing.JFormattedTextField completionTimeInput;
    private javax.swing.JLabel completionTimeLabel;
    private javax.swing.JComboBox<String> daySelector;
    private javax.swing.JLabel daySelectorLabel;
    private javax.swing.JDialog dialogSubmit;
    private javax.swing.JDialog endOfWeekAlert;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel selectedChore;
    private javax.swing.JLabel selectedChoreLabel;
    private javax.swing.JLabel successLabel;
    private javax.swing.JScrollPane tableContainer;
    private javax.swing.JLabel totalChores;
    private javax.swing.JLabel totalScore;
    private javax.swing.JLabel totalScoreLabel;
    private javax.swing.JButton viewHistoryButton;
    private javax.swing.JLabel weekScore;
    private javax.swing.JLabel weekScoreLabel;
    // End of variables declaration//GEN-END:variables

    public void updateDisplayTableDataUser1(int selection) {
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);
        ArrayList<Chore> tableList = new ArrayList(); // Temp list to update the table
        switch (selection) {
            case 0:
                for (Chore c : user1List) {
                    if (c.getChoreDay() == 1 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Monday");
                break;
            case 1:
                for (Chore c : user1List) {
                    if (c.getChoreDay() == 2 && !c.isChoreComplete()) {
                        tableList.add(c);
                        System.out.println(c.getChoreName());
                    }
                }
                System.out.println("Tuesday");
                break;
            case 2:
                for (Chore c : user1List) {
                    if (c.getChoreDay() == 3 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Wednesday");
                break;
            case 3:
                for (Chore c : user1List) {
                    if (c.getChoreDay() == 4 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Thursday");
                break;
            case 4:
                for (Chore c : user1List) {
                    if (c.getChoreDay() == 5 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Friday");
                break;
            case 5:
                for (Chore c : user1List) {
                    if (c.getChoreDay() == 6 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Saturday");
                break;
            case 6:
                for (Chore c : user1List) {
                    if (c.getChoreDay() == 7 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Sunday");
                break;
            case 7:
                for (Chore c : user1List) {
                    if (c.getChoreDay() == 8 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Any day");
                break;
            default:
                for (Chore c : user1List) {
                    tableList.add(c);
                }
                System.out.println("Default case");
                break;
        }

        for (int i = 0; i < tableList.size(); i++) {
            tableModel.addRow(new Object[]{tableList.get(i).getChoreName(), tableList.get(i).isChoreComplete()});
        }

    }

    public void updateDisplayTableDataUser2(int selection) {
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);
        ArrayList<Chore> tableList = new ArrayList(); // Temp list to update the table

        switch (selection) {
            case 0:
                for (Chore c : user2List) {
                    if (c.getChoreDay() == 1 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Monday");
                break;
            case 1:
                for (Chore c : user2List) {
                    if (c.getChoreDay() == 2 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Tuesday");
                break;
            case 2:
                for (Chore c : user2List) {
                    if (c.getChoreDay() == 3 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Wednesday");
                break;
            case 3:
                for (Chore c : user2List) {
                    if (c.getChoreDay() == 4 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Thursday");
                break;
            case 4:
                for (Chore c : user2List) {
                    if (c.getChoreDay() == 5 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Friday");
                break;
            case 5:
                for (Chore c : user2List) {
                    if (c.getChoreDay() == 6 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Saturday");
                break;
            case 6:
                for (Chore c : user2List) {
                    if (c.getChoreDay() == 7 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Sunday");
                break;
            case 7:
                for (Chore c : user2List) {
                    if (c.getChoreDay() == 8 && !c.isChoreComplete()) {
                        tableList.add(c);
                    }
                }
                System.out.println("Sunday");
                break;
            default:
                for (Chore c : user2List) {
                    tableList.add(c);
                }
                System.out.println("Default case");
                break;
        }

        for (int i = 0; i < tableList.size(); i++) {
            tableModel.addRow(new Object[]{tableList.get(i).getChoreName(), tableList.get(i).isChoreComplete()});
        }

    }

    public void updateChoreCount(int currentUser) {
        if (currentUser == 1) {
            choreCount = Integer.toString(user1List.size());
        }
        if (currentUser == 2) {
            choreCount = Integer.toString(user2List.size());
        }
        totalChores.setText(choreCount);
    }

    public void submitData() {
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();

        // Iterates over the list to see which chores have their completed box ticked
        if (currentUser == 1) {
            try {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < user1List.size(); j++) {
                        if (user1List.get(j).getChoreName().equals(highLightedChore)) {
                            user1List.get(j).setCompletionTime(Float.parseFloat(completionTimeInput.getText())); // Sets local vars
                            user1List.get(j).setChoreComplete(true);
                            highLightedChore = null;
                            System.out.println("INPUT TIME: " + user1List.get(j).getCompletionTime() + "COMPLETE: " + user1List.get(j).isChoreComplete());
                            choresDB.updateChoresComplete(user1List.get(j).getChoreID(), user1List.get(j).getCompletionTime());
                            user1Completed.add(user1List.get(j)); // Add the chore to list of completed chores
                            awardPoints(j);
                            user1List.remove(j); // Remove from the list

                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Submit Error: " + e);
            }
        }

        if (currentUser == 2) {
            try {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < user2List.size(); j++) {
                        if (user2List.get(j).getChoreName().equals(highLightedChore)) {
                            user2List.get(j).setCompletionTime(Float.parseFloat(completionTimeInput.getText())); // Sets local vars
                            user2List.get(j).setChoreComplete(true);
                            highLightedChore = null;
                            System.out.println("INPUT TIME: " + user2List.get(j).getCompletionTime() + "COMPLETE: " + user2List.get(j).isChoreComplete());
                            choresDB.updateChoresComplete(user2List.get(j).getChoreID(), user1List.get(j).getCompletionTime());
                            user2Completed.add(user2List.get(j)); // Add the chore to list of completed chores
                            awardPoints(j);
                            user2List.remove(j); // Remove from the list

                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Submit Error: " + e);
            }
        }

    }

    public void endOfWeekAlert() {
        DefaultTableModel tableModel = (DefaultTableModel) alertTable.getModel();
        tableModel.setRowCount(0);

        if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            if (currentUser == 1) {
                for (Chore c : user1List) {
                    tableModel.addRow(new Object[]{c.getChoreName()});
                }
            }
            if (currentUser == 2) {
                for (Chore c : user2List) {
                    tableModel.addRow(new Object[]{c.getChoreName()});
                }
            }
            endOfWeekAlert.pack();
            endOfWeekAlert.setLocationRelativeTo(AssignedChoresGUI.this);
            endOfWeekAlert.setVisible(true);
        }
    }

    public void awardPoints(int chore) {
        int points = 0;
        if (user.getUserID() == 1) {
            points = completionPoints.pointCalculation(user1List.get(chore), currentUser);
        }
        if (user.getUserID() == 2) {
            points = completionPoints.pointCalculation(user2List.get(chore), currentUser);
        }
        int currentPoints = user.getUserWeekScore();
        int totalPoints = user.getUserTotalScore();

        user.setUserWeekScore(currentPoints + points);
        points = points + currentPoints;
        totalPoints = totalPoints + points;
        System.out.println("USER: " + user.getUserID());
        try {
            choresDB.updateUserWeekScore(points, user.getUserID());
            choresDB.updateUserTotalScore(totalPoints, user.getUserID());
            System.out.println("Week: " + user.getUserWeekScore() + "Total: " + user.getUserTotalScore());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
