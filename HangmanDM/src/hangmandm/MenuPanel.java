/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import javax.swing.JFrame;

/***************************************************************  
*  file: MenuPanel.java 
*  author: D. Menkir  
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Program 1.0  
*  date last modified: 9/17/2022 
*  
*  purpose: This panel is the menu of our program. It holds the Play,
*  High Score, and Credits buttons. It also has a picture in it.
*  
****************************************************************/  
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */
    public MenuPanel() {
        initComponents();
        
    }

    // method: initComponents  
    // purpose: initializes variables.  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 400));

        jButton3.setText("PLAY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("HIGH SCORES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("CREDITS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/squidward dabbing.png"))); // NOI18N

        jButton4.setText("ColorGame");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addContainerGap(378, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // method: jButton3ActionPerformed  
    // purpose: ActionPerformed method to navigate to the hangman game.
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        HangmanDM.cardLayout.invalidateLayout(HangmanDM.frame.getContentPane());
        
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "game");

    }//GEN-LAST:event_jButton3ActionPerformed

    // method: jButton2ActionPerformed  
    // purpose: ActionPerformed method to navigate to the high scores.
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "high scores");
    }//GEN-LAST:event_jButton2ActionPerformed

    // method: jButton2ActionPerformed  
    // purpose: ActionPerformed method to navigate to the credits.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Sends user to credits page
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "credits");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HangmanDM.cardLayout.invalidateLayout(HangmanDM.frame.getContentPane());
        
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "color game");
    }//GEN-LAST:event_jButton4ActionPerformed

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
