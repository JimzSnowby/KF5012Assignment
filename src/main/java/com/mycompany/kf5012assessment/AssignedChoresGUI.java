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
    private ChoresDatabase db = new ChoresDatabase();
    /*
     * Creates new form AssignedChoresGUI
     */
    public AssignedChoresGUI() {
        createDummyData();
        try{
            db.selectChores();
            
        }catch(Exception e){
            System.out.print("Error has occurred: " + e);
        }
        initComponents();
        displayTableData(dummyList);
        
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
        totalChoresLabel = new javax.swing.JLabel();
        totalChores = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("This weeks chores");
        setResizable(false);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Title.setText("This weeks chores");

        daySelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        daySelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daySelectorActionPerformed(evt);
            }
        });

        choreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Chore", "Description", "Complete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
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
            choreTable.getColumnModel().getColumn(2).setResizable(false);
        }

        daySelectorLabel.setText("Day of the week:");

        cancelButton.setText("cancel");

        acceptButton.setText("accept");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        weekScoreLabel.setText("This weeks score:");

        totalScoreLabel.setText("Total score:");

        weekScore.setText("0");

        totalScore.setText("0");

        totalChoresLabel.setText("Total chores:");

        totalChores.setText("0");

        menuFile.setText("File");
        menuBar.add(menuFile);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Title)
                                    .addGap(18, 18, 18)
                                    .addComponent(totalChoresLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(totalChores))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(daySelectorLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(daySelector, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(totalScoreLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(totalScore))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(weekScoreLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(weekScore))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title)
                    .addComponent(weekScoreLabel)
                    .addComponent(weekScore)
                    .addComponent(totalChoresLabel)
                    .addComponent(totalChores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daySelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daySelectorLabel)
                    .addComponent(totalScoreLabel)
                    .addComponent(totalScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
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
       updateDisplayTableData(selection);
    }//GEN-LAST:event_daySelectorActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        System.out.println("Accept Pressed");
        submitData();
    }//GEN-LAST:event_acceptButtonActionPerformed

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
    private javax.swing.JLabel totalChoresLabel;
    private javax.swing.JLabel totalScore;
    private javax.swing.JLabel totalScoreLabel;
    private javax.swing.JLabel weekScore;
    private javax.swing.JLabel weekScoreLabel;
    // End of variables declaration//GEN-END:variables
    
    public void displayTableData(AssignedChoresList tableData){
        // Empty the existing data
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);
        
        List<Chore> list = tableData.getAssignedChoresList();
        int selection = daySelector.getSelectedIndex();
        
        switch (selection){
            case 0:
                list = dummyList.getMon();
                break;
            case 1:
                list = dummyList.getTues();
                break;
            case 2:
                list = dummyList.getWed();
                break;
            case 3:
                list = dummyList.getThur();
                break;
            case 4:
                list = dummyList.getFri();
                break;
            case 5:
                list = dummyList.getSat();
                break;
            case 6:
                list = dummyList.getSun();
                break;
            default:
                list = dummyList.getAssignedChoresList();
                break;
        }
        
        for(int i = 0; i < list.size(); i++){
            tableModel.addRow(new Object[]{list.get(i).getChoreName(), list.get(i).isComplete()});
        }
    }
    
    public void updateDisplayTableData(int selection){
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);
        List<Chore> list = dummyList.getAssignedChoresList();

        switch (selection){
            case 0:
                list = dummyList.getMon();
                break;
            case 1:
                list = dummyList.getTues();
                break;
            case 2:
                list = dummyList.getWed();
                break;
            case 3:
                list = dummyList.getThur();
                break;
            case 4:
                list = dummyList.getFri();
                break;
            case 5:
                list = dummyList.getSat();
                break;
            case 6:
                list = dummyList.getSun();
                break;
            default:
                list = dummyList.getAssignedChoresList();
                break;
        }
        
        for(int i = 0; i < list.size(); i++){
            tableModel.addRow(new Object[]{list.get(i).getChoreName(), list.get(i).isComplete()});
        }
        
    }
    
    public void submitData(){
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        boolean checkBox;
        for(int i  = 0; i < dummyList.getAssignedChoresList().size(); i++){
            try {
                checkBox = (boolean) tableModel.getValueAt(i, 2);
                if (checkBox) {
                    System.out.println("Checked");
                }
            }catch(Exception e){
                System.out.println("Nothing is checked");
            }
            
        }
        
    }
    
    public void createDummyData(){
        Chore cleaning = new Chore();
        cleaning.setChoreID(1);
        cleaning.setChoreName("Cleaning");
        
        cleaning.setFrequency(3);
        cleaning.setChoreEstimateTime(30);
        cleaning.setChorePoint(10);
        cleaning.setDay(2);
        this.dummyList = new AssignedChoresList();
        dummyList.addToChoreList(cleaning);
        
        
       
       // AssignedChoresGUI acGUI = new AssignedChoresGUI();
        //displayTableData(dummyList);
        
    }
    
    
}

