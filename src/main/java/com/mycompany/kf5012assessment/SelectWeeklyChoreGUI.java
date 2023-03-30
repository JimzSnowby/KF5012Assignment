/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author w21023500
 */
public class SelectWeeklyChoreGUI extends javax.swing.JFrame {

    /**
     * Creates new form SelectWeeklyChoreGUI
     */
    // Define a private ArrayList of Strings to store the chores
   
private ArrayList<Chore> dummyList;
private ArrayList<Chore> choresArrayList;

public SelectWeeklyChoreGUI() {
    // initialize a new instance of ChoresDatabase and create a list of chores by calling its selectChores() method
    ChoresDatabase choresDB = new ChoresDatabase();
    ArrayList<Chore> choresArrayList = new ArrayList();
    try {
        choresArrayList = choresDB.selectChores();
    } catch (Exception e) {
        System.out.println("Error occured in extracting data");
    }
    
    // store the list in the dummyList field and call the initComponents() method to initialize the GUI
    dummyList = choresArrayList;
    initComponents();
    
    // call updateTableData() to populate the table with data
    updateTableData();
}


public void AddNewChore(String name, int frequency, int estimateTime) {
    // create a new Chore object and set its properties
    Chore newChore = new Chore();
    ChoresDatabase choresDBAdding = new ChoresDatabase();
    newChore.setChoreName(name);
    newChore.setFrequency(frequency);
    newChore.setFrequency(estimateTime);

    // add the new chore to the database and call updateChoreTable() to update the table with the new data
    choresDBAdding.addChore(newChore);
    updateChoreTable();
}

public void updateChoreTable() {
    // check if the table exists and has a DefaultTableModel
    if (choreTable != null && choreTable.getModel() instanceof DefaultTableModel) {
        // if so, clear the table and add each chore in the list to a new row
        DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
        tableModel.setRowCount(0);
        for (int i = 0; i < choresArrayList.size(); i++) {
            tableModel.addRow(new Object[]{choresArrayList.get(i).getChoreName()});
        }
    } else {
        // if the table or table model is null, display an error message
        JOptionPane.showMessageDialog(this, "Error: The chore table or table model is null.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void updateTableData() {
    // create a new DefaultTableModel and set its data using the dummyList
    DefaultTableModel model = new DefaultTableModel(new Object[]{"Task", "Today"}, 0);
    for (Chore chore : dummyList) {
        model.addRow(new Object[]{chore.getChoreName(), false});
    }
    // set the choreTable model to the new DefaultTableModel
    choreTable.setModel(model);
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
        choreScrollPane.setViewportView(choreTable);

        chooseDayChore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
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


    private void chooseDayChoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDayChoreActionPerformed
        // TODO add your handling code here:
        Object selected = chooseDayChore.getSelectedItem();
        System.out.println("Event happened");
        updateDisplayTableData(selected);
    }//GEN-LAST:event_chooseDayChoreActionPerformed

    private void addChoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChoreButtonActionPerformed
        try {
            CreateNewChoreGUI nc = new CreateNewChoreGUI(this, true);
            nc.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_addChoreButtonActionPerformed

    private void submitChoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitChoreButtonActionPerformed
   DefaultTableModel choreTableModel = (DefaultTableModel) choreTable.getModel();

    // Get the selected rows
    int[] selectedRows = choreTable.getSelectedRows();

    if (selectedRows.length == 0) {
        JOptionPane.showMessageDialog(null, "You haven't selected any task.");
    } else {

       // Iterate through the selected rows
for (int i = 0; i < selectedRows.length; i++) {
    // Get the data from the selected row
    Object[] rowData = new Object[choreTableModel.getColumnCount()];
    for (int j = 0; j < choreTableModel.getColumnCount(); j++) {
        rowData[j] = choreTableModel.getValueAt(selectedRows[i], j);
    }
    // Create a new Chore object using the rowData and add it to the choresArrayList
    Chore chore = new Chore();
    chore.setChoreName((String) rowData[0]);
    chore.setComplete((Boolean) rowData[1]);
    choresArrayList.add(chore);
}

        // Create an instance of the EstimateTimeInputGUI and pass the selectedData ArrayList
      EstimateTimeInputGUI estimateTimeInputGUI = new EstimateTimeInputGUI(choresArrayList);
      estimateTimeInputGUI.setVisible(true);

    }
 // TODO add your handling code here:
    }//GEN-LAST:event_submitChoreButtonActionPerformed
   public void displayTableData(ChoreList tableData) {
    // Empty the existing data
    DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
    tableModel.setRowCount(0);

    // Get the list of chores from the passed ChoreList object
    List<Chore> list = tableData.getChoreList();
    // Get the selected day of the week from the drop-down menu
    Object selected = chooseDayChore.getSelectedItem();

    // If Monday is selected, update the list to the Monday list
    if (selected.toString().equals("Monday")) {
        list = tableData.getMon();
    }
    // If Tuesday is selected, update the list to the Tuesday list
    if (selected.toString().equals("Tuesday")) {
        list = tableData.getTues();
    }

    // Iterate through the list and add each chore's data to the table
    for (int i = 0; i < list.size(); i++) {
        tableModel.addRow(new Object[]{list.get(i).getChoreName(), list.get(i).isComplete()});
    }
}

public void updateDisplayTableData(Object selected) {
    // Empty the existing data
    DefaultTableModel tableModel = (DefaultTableModel) choreTable.getModel();
    tableModel.setRowCount(0);

    // Create a dummy ChoreList object to get the list of chores
    ChoreList dummyList = new ChoreList();
    List<Chore> list = dummyList.getChoreList();
    
    // If Monday is selected, update the list to the Monday list
    if (selected.toString().equals("Monday")) {
        list = dummyList.getMon();
    }
    // If Tuesday is selected, update the list to the Tuesday list
    if (selected.toString().equals("Tuesday")) {
        list = dummyList.getTues();
    }

    // Iterate through the list and add each chore's data to the table
    for (int i = 0; i < list.size(); i++) {
        tableModel.addRow(new Object[]{list.get(i).getChoreName(), list.get(i).isComplete()});
    }
}

    

    public void createDummyData() {
    Chore cleaning = new Chore();
    cleaning.setChoreID(1);
    cleaning.setChoreName("Cleaning");
    cleaning.setFrequency(3);
    cleaning.setDay(2);
    cleaning.setChoreEstimateTime(30);
    
    
    Chore cooking = new Chore();
    cooking.setChoreID(2);
    cooking.setChoreName("Cooking");
    cooking.setFrequency(2);
    cooking.setDay(5);
    cooking.setChoreEstimateTime(60);
    
    
    Chore laundry = new Chore();
    laundry.setChoreID(3);
    laundry.setChoreName("Laundry");
    laundry.setFrequency(1);
    laundry.setDay(3);
    laundry.setChoreEstimateTime(45);
    
    
    ChoreList dummyList = new ChoreList();
    dummyList.addToChoreList(cleaning);
    dummyList.addToChoreList(cooking);
    dummyList.addToChoreList(laundry);
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
