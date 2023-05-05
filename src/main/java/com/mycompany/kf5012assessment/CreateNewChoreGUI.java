/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.kf5012assessment;

import static com.mycompany.kf5012assessment.ChoresDatabase.choresArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author w21023500
 */
public class CreateNewChoreGUI extends javax.swing.JDialog {

    ArrayList<Chore> choress;

    /**
     * Creates new form CreateNewChoreGUI
     */
    private SelectWeeklyChoreGUI mainWindow;

    /**
     * Creates new form NewTaskChore
     *
     * @param parent
     */
    public CreateNewChoreGUI(SelectWeeklyChoreGUI parent, boolean modal) {
        super(parent, modal);
        this.mainWindow = parent;
        initComponents();
        ButtonGroup bg = new ButtonGroup();
        bg.add(oneOffChoreType);
        bg.add(weeklyChoreType);
        weeklyChoreType.setSelected(true);

    }

    public SelectWeeklyChoreGUI getMainWindow() {
        return mainWindow;
    }

    public boolean[] getTickedRows(JTable table) {
        try {
            int rowCount = table.getRowCount();
            boolean[] tickedRows = new boolean[rowCount];

            // Loop through each row and check if it has been ticked
            for (int i = 0; i < rowCount; i++) {
                Boolean value = (Boolean) table.getValueAt(i, 0);
                tickedRows[i] = value != null && value;
            }

            return tickedRows;
        } catch (Exception e) {
            // Log the error
            System.out.println("Error: " + e.getMessage());
            return new boolean[0];
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

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        weeklyChoreType = new javax.swing.JRadioButton();
        oneOffChoreType = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        submitNewChoreButton = new javax.swing.JButton();
        cancelNewChoreButton = new javax.swing.JButton();
        daySelect = new javax.swing.JComboBox<>();
        choreNameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Chore Name:");

        jLabel2.setText("Chore Type:");

        buttonGroup.add(weeklyChoreType);
        weeklyChoreType.setText("Weekly");
        weeklyChoreType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyChoreTypeActionPerformed(evt);
            }
        });

        buttonGroup.add(oneOffChoreType);
        oneOffChoreType.setText("One-off ");
        oneOffChoreType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneOffChoreTypeActionPerformed(evt);
            }
        });

        jLabel3.setText("Select the fequency of the chore");

        submitNewChoreButton.setText("Submit");
        submitNewChoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitNewChoreButtonActionPerformed(evt);
            }
        });

        cancelNewChoreButton.setText("Cancel");
        cancelNewChoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNewChoreButtonActionPerformed(evt);
            }
        });

        daySelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AnyDay ", "Monday ", "Tuesday ", "Wednesday ", "Thursday ", "Friday ", "Saturday ", "Sunday " }));

        choreNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choreNameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelNewChoreButton)
                .addGap(29, 29, 29)
                .addComponent(submitNewChoreButton)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(weeklyChoreType)
                            .addGap(26, 26, 26)
                            .addComponent(oneOffChoreType))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(choreNameTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addComponent(daySelect, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(choreNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(weeklyChoreType)
                    .addComponent(oneOffChoreType))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(daySelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(189, 189, 189)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitNewChoreButton)
                    .addComponent(cancelNewChoreButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void oneOffChoreTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneOffChoreTypeActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_oneOffChoreTypeActionPerformed

    private void weeklyChoreTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyChoreTypeActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_weeklyChoreTypeActionPerformed

    private void submitNewChoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitNewChoreButtonActionPerformed
        if (choreNameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in a chore!");
            return;
        }

        Chore chore = new Chore();
        chore.setChoreName(choreNameTextField.getText());
        chore.setChoreDay(daySelect.getSelectedIndex() - 1);
        chore.setChoreFrequencyID(weeklyChoreType.isSelected() ? 1 : 2);
        ChoresDatabase db = new ChoresDatabase();
        try {
            db.addChore(chore, chore.getChoreFrequencyID(), 0, 0);
            mainWindow.getData();
            mainWindow.displayTableData();
            mainWindow.recordTableChanges();
            choresArrayList.add(chore);
            mainWindow.resetFrame(); // Call resetFrame() to close and reopen the frame
        } catch (SQLException E) {
            System.err.println(E.getMessage());
            E.printStackTrace();
            System.out.println("Exception occurred");
        }

    }//GEN-LAST:event_submitNewChoreButtonActionPerformed

    private void cancelNewChoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNewChoreButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel creating a new task?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); //gets rid of the screen  
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cancelNewChoreButtonActionPerformed

    private void choreNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choreNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choreNameTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(CreateNewChoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewChoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewChoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewChoreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //  java.awt.EventQueue.invokeLater(new Runnable() {
        //    @Override
        // public void run() {
        //     new CreateNewChoreGUI().setVisible(true);
        //  }
        //     });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton cancelNewChoreButton;
    private javax.swing.JTextField choreNameTextField;
    private javax.swing.JComboBox<String> daySelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton oneOffChoreType;
    private javax.swing.JButton submitNewChoreButton;
    private javax.swing.JRadioButton weeklyChoreType;
    // End of variables declaration//GEN-END:variables
}
