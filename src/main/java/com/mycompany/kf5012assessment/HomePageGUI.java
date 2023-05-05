/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.kf5012assessment;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author w21023500
 */
public class HomePageGUI extends javax.swing.JFrame {
    private ChoresDatabase choresDB = new ChoresDatabase(); // Connect to DB
    private ArrayList<User> users;
    private User user1;
    private User user2;
    private LocalDate date = LocalDate.now();
    private ChoreCompletionPoints completionPoints = new ChoreCompletionPoints();
    
    /**
     * Creates new form StartScreenGUI
     */
    public HomePageGUI() {
        try{
            users = choresDB.selectUsers();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        user1 = users.get(0);
        user2 = users.get(1);
        
        initComponents();
        
        if(date.getDayOfWeek().equals(DayOfWeek.MONDAY)){
            completionPoints.totalCalculation(user1);
            completionPoints.totalCalculation(user2);
        }
        
        bobWeekScore.setText(Integer.toString(user1.getUserWeekScore()));
        bobTotalScore.setText(Integer.toString(user1.getUserTotalScore()));
        aliceWeekScore.setText(Integer.toString(user2.getUserWeekScore()));
        aliceTotalScore.setText(Integer.toString(user2.getUserTotalScore()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectChoresButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bobScoreLabel = new javax.swing.JLabel();
        bobWeekLabel = new javax.swing.JLabel();
        aliceScoreLabel = new javax.swing.JLabel();
        aliceWeekLabel = new javax.swing.JLabel();
        aliceTotalLabel = new javax.swing.JLabel();
        bobTotalLabel = new javax.swing.JLabel();
        bobWeekScore = new javax.swing.JLabel();
        aliceWeekScore = new javax.swing.JLabel();
        bobTotalScore = new javax.swing.JLabel();
        aliceTotalScore = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectChoresButton.setText("Select Chores");
        selectChoresButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectChoresButtonMouseEntered(evt);
            }
        });
        selectChoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectChoresButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Bob Profile");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Alice Profile");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Welcome");

        bobScoreLabel.setText("Bob's Score:");

        bobWeekLabel.setText("Week:");

        aliceScoreLabel.setText("Alice's Score:");

        aliceWeekLabel.setText("Week:");

        aliceTotalLabel.setText("Total:");

        bobTotalLabel.setText("Total:");

        bobWeekScore.setText("0");

        aliceWeekScore.setText("0");

        bobTotalScore.setText("0");

        aliceTotalScore.setText("0");

        jMenuBar1.setRequestFocusEnabled(false);

        jMenu1.setText("Home");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bobScoreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aliceScoreLabel))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectChoresButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bobWeekLabel)
                    .addComponent(bobTotalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bobWeekScore)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(bobTotalScore)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(aliceTotalLabel)
                    .addComponent(aliceWeekLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aliceWeekScore)
                    .addComponent(aliceTotalScore))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(selectChoresButton)
                .addGap(39, 39, 39)
                .addComponent(jButton2)
                .addGap(44, 44, 44)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bobScoreLabel)
                    .addComponent(aliceScoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bobWeekLabel)
                    .addComponent(aliceWeekLabel)
                    .addComponent(aliceWeekScore)
                    .addComponent(bobWeekScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aliceTotalLabel)
                    .addComponent(bobTotalLabel)
                    .addComponent(bobTotalScore)
                    .addComponent(aliceTotalScore))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        EstimateTimeInputGUI etgi = new EstimateTimeInputGUI(1);
        etgi.pack(); // resize the window to fit its components
        etgi.setLocationRelativeTo(this); // center the window relative to this GUI
        etgi.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EstimateTimeInputGUI etgi = new EstimateTimeInputGUI(2);
        etgi.pack(); // resize the window to fit its components
        etgi.setLocationRelativeTo(this); // center the window relative to this GUI
        etgi.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void selectChoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectChoresButtonActionPerformed
   selectChoresButton.setComponentPopupMenu(null);

        selectChoresButton.setToolTipText("Click me!");

        SelectWeeklyChoreGUI selectWeeklyChoreGUI = new SelectWeeklyChoreGUI();
        selectWeeklyChoreGUI.pack(); // pack the dialog
        selectWeeklyChoreGUI.setLocationRelativeTo(this); // set the location relative to this component
        selectWeeklyChoreGUI.setVisible(true);
        // hide the current GUI
        this.setVisible(false);
    }//GEN-LAST:event_selectChoresButtonActionPerformed

    private void selectChoresButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectChoresButtonMouseEntered
        //guids the user 
            selectChoresButton.setToolTipText("Click to select weekly chores");     


    }//GEN-LAST:event_selectChoresButtonMouseEntered

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
            java.util.logging.Logger.getLogger(HomePageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePageGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aliceScoreLabel;
    private javax.swing.JLabel aliceTotalLabel;
    private javax.swing.JLabel aliceTotalScore;
    private javax.swing.JLabel aliceWeekLabel;
    private javax.swing.JLabel aliceWeekScore;
    private javax.swing.JLabel bobScoreLabel;
    private javax.swing.JLabel bobTotalLabel;
    private javax.swing.JLabel bobTotalScore;
    private javax.swing.JLabel bobWeekLabel;
    private javax.swing.JLabel bobWeekScore;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton selectChoresButton;
    // End of variables declaration//GEN-END:variables
}
