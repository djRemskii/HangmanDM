/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author TheGe
 */
public class SudokuPanel extends javax.swing.JPanel {

    private static final int[][] solution = new int[9][];
    
    /**
     * Creates new form SudokuPanel
     */
    public SudokuPanel() {
        solution[0] = new int[]{ 8,3,5,4,1,6,9,2,7 };
        solution[1] = new int[]{ 2,9,6,8,5,7,4,3,1 };
        solution[2] = new int[]{ 4,1,7,2,9,3,6,5,8 };
        solution[3] = new int[]{ 5,6,9,1,3,4,7,8,2 };
        solution[4] = new int[]{ 1,2,3,6,7,8,5,4,9 };
        solution[5] = new int[]{ 7,4,8,5,2,9,1,6,3 };
        solution[6] = new int[]{ 6,5,2,7,8,1,3,9,4 };
        solution[7] = new int[]{ 9,8,1,3,4,5,2,7,6 };
        solution[8] = new int[]{ 3,7,4,9,6,2,8,1,5 };
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

        box0_0 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 400));

        box0_0.setEditable(false);
        box0_0.setBackground(new java.awt.Color(255, 255, 255));
        box0_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_0.setText("6");
        box0_0.setActionCommand("<Not Set>");
        box0_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_0FocusLost(evt);
            }
        });
        box0_0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                box0_0MousePressed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(box0_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(331, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(box0_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        box0_0.setText("2");
    }//GEN-LAST:event_jButton1ActionPerformed

    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
    Border redBorder = BorderFactory.createLineBorder(Color.RED,3);
    
    private void box0_0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_box0_0MousePressed
        // TODO add your handling code here:
        //box0_0.setBorder(redBorder);
    }//GEN-LAST:event_box0_0MousePressed

    private void box0_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_0FocusGained
        // TODO add your handling code here:
        box0_0.setBorder(redBorder);
    }//GEN-LAST:event_box0_0FocusGained

    private void box0_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_0FocusLost
        // TODO add your handling code here:
        box0_0.setBorder(blackBorder);
    }//GEN-LAST:event_box0_0FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField box0_0;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
