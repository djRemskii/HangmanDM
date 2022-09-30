/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author TheGe
 */
public class SudokuPanel extends javax.swing.JPanel {

    private static final int[][] solutionBoard = new int[9][9];
    private static int[][] currentBoard = new int[9][9];
    private static int[] focusedBox = new int[2];
    private static JTextField[][] boxes = new JTextField[9][9]; 
    
    /**
     * Creates new form SudokuPanel
     */
    public SudokuPanel() {
        solutionBoard[0] = new int[]{ 8,3,5,4,1,6,9,2,7 };
        solutionBoard[1] = new int[]{ 2,9,6,8,5,7,4,3,1 };
        solutionBoard[2] = new int[]{ 4,1,7,2,9,3,6,5,8 };
        solutionBoard[3] = new int[]{ 5,6,9,1,3,4,7,8,2 };
        solutionBoard[4] = new int[]{ 1,2,3,6,7,8,5,4,9 };
        solutionBoard[5] = new int[]{ 7,4,8,5,2,9,1,6,3 };
        solutionBoard[6] = new int[]{ 6,5,2,7,8,1,3,9,4 };
        solutionBoard[7] = new int[]{ 9,8,1,3,4,5,2,7,6 };
        solutionBoard[8] = new int[]{ 3,7,4,9,6,2,8,1,5 };
        
        focusedBox[0] = 100;
        focusedBox[1] = 100;
        
        initComponents();
        
        boxAssigner();
    }
    
    private static void boxAssigner(){
        boxes[0][0] = box0_0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        num1 = new javax.swing.JButton();
        num2 = new javax.swing.JButton();
        num3 = new javax.swing.JButton();
        num4 = new javax.swing.JButton();
        num5 = new javax.swing.JButton();
        num6 = new javax.swing.JButton();
        num7 = new javax.swing.JButton();
        num8 = new javax.swing.JButton();
        num9 = new javax.swing.JButton();
        box0_0 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(600, 400));

        num1.setText("1");
        num1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num1ActionPerformed(evt);
            }
        });

        num2.setText("2");
        num2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num2ActionPerformed(evt);
            }
        });

        num3.setText("3");
        num3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num3ActionPerformed(evt);
            }
        });

        num4.setText("4");
        num4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num4ActionPerformed(evt);
            }
        });

        num5.setText("5");
        num5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num5ActionPerformed(evt);
            }
        });

        num6.setText("6");
        num6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num6ActionPerformed(evt);
            }
        });

        num7.setText("7");
        num7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num7ActionPerformed(evt);
            }
        });

        num8.setText("8");
        num8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num8ActionPerformed(evt);
            }
        });

        num9.setText("9");
        num9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num9ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(num1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(num2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(num4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(num5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(num6)
                                    .addComponent(num3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(num7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(box0_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(394, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num1)
                    .addComponent(num2)
                    .addComponent(num3))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num4)
                    .addComponent(num5)
                    .addComponent(num6))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num7)
                    .addComponent(num8)
                    .addComponent(num9))
                .addGap(17, 17, 17)
                .addComponent(box0_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private static void setBox (int i){
        int row = focusedBox[0];
        int column = focusedBox[1];
        if (row < 9 && column < 9){
            currentBoard[row][column] = i;
            System.out.println(currentBoard[row][column]);
        } else {
            System.out.println("No box selected");
        }
    }
    
    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
    Border redBorder = BorderFactory.createLineBorder(Color.RED,3);
    
    private void num1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num1ActionPerformed
        setBox(1);
        boxes[focusedBox[0]][focusedBox[1]].setText("1");
    }//GEN-LAST:event_num1ActionPerformed

    private void num2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num2ActionPerformed
        setBox(2);
        boxes[focusedBox[0]][focusedBox[1]].setText("2");
    }//GEN-LAST:event_num2ActionPerformed

    private void num3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num3ActionPerformed
        setBox(3);
        boxes[focusedBox[0]][focusedBox[1]].setText("3");
    }//GEN-LAST:event_num3ActionPerformed

    private void num4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num4ActionPerformed
        setBox(4);
        boxes[focusedBox[0]][focusedBox[1]].setText("4");
    }//GEN-LAST:event_num4ActionPerformed

    private void num5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num5ActionPerformed
        setBox(5);
        boxes[focusedBox[0]][focusedBox[1]].setText("5");
    }//GEN-LAST:event_num5ActionPerformed

    private void num6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num6ActionPerformed
        setBox(6);
        boxes[focusedBox[0]][focusedBox[1]].setText("6");
    }//GEN-LAST:event_num6ActionPerformed

    private void num7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num7ActionPerformed
        setBox(7);
        boxes[focusedBox[0]][focusedBox[1]].setText("7");
    }//GEN-LAST:event_num7ActionPerformed

    private void num8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num8ActionPerformed
        setBox(8);
        boxes[focusedBox[0]][focusedBox[1]].setText("8");
    }//GEN-LAST:event_num8ActionPerformed

    private void num9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num9ActionPerformed
        setBox(9);
        boxes[focusedBox[0]][focusedBox[1]].setText("9");
    }//GEN-LAST:event_num9ActionPerformed

    private void box0_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_0FocusGained
        box0_0.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_0FocusGained

    private void box0_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_0FocusLost
        box0_0.setBorder(blackBorder);
    }//GEN-LAST:event_box0_0FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField box0_0;
    private javax.swing.JButton num1;
    private javax.swing.JButton num2;
    private javax.swing.JButton num3;
    private javax.swing.JButton num4;
    private javax.swing.JButton num5;
    private javax.swing.JButton num6;
    private javax.swing.JButton num7;
    private javax.swing.JButton num8;
    private javax.swing.JButton num9;
    // End of variables declaration//GEN-END:variables
}
