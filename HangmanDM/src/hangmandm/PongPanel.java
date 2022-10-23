/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import javax.swing.SwingUtilities; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.BorderFactory; 
import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
/**
 *
 * @author danie
 */
public class PongPanel extends javax.swing.JPanel {

    private int x;
    private int y;
    private final int border;
    private boolean yDirection; //true is up, false is down
    private boolean xDirection; // true is right, false is left
    private boolean startFlag;
    private int leftScore;
    private int rightScore;
    private boolean gameO;
    private boolean ballStop;
    /**
     * Creates new form PongPanel
     */
    public PongPanel() {
        initComponents();
        x = 300;
        y = 200;
        border = 25;
        yDirection = true;
        xDirection = true;
        startFlag = false;
        gameO = true;
        ballStop = false;
        leftScore = 0;
        rightScore = 0;
        jButton2.setVisible(false);
        jButton2.setEnabled(false);
        jLabel1.setOpaque(false);
        jLabel1.setBounds(0, 0, 1, 1);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        if(gameO = true){
        AbstractAction pongStart = new AbstractAction("startGame"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                startFlag = true;
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "startGame");
        jLabel1.getActionMap().put("startGame", pongStart);    
    }
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        g.fillOval(x, y, border, border);
        if(startFlag)
        {
            moveBall(ballStop);
            
            if(x>=getWidth()-border-5){
                System.out.println("HIT RIGHT");
                sideHit(1);
            }
            if (x <=25-border){
                System.out.println("HIT LEFT");
                sideHit(0);
            }
        }
        
        repaint();
        try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(PongPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void moveBall(boolean ballStop)
    {
        if(ballStop = true){  //attempt to make the ball stop moving when then the game is won.
        if(xDirection)
        {
            x = x+1;
        }
        
        if(yDirection)
        {
            y = y+1;
        }
        
        
        if (y>=getHeight()-border-1 || !yDirection)
        {
            y = y-1;
            yDirection = false;
        }
        if(y <=23-border || yDirection)
        {
            y = y+1;
            yDirection = true;
        }
        
        if(x>=getWidth()-border-1 || !xDirection)
        {
            x = x-1;
            xDirection = false;
        }
        if(x <=21-border || xDirection)
        {
            x = x+1;
            xDirection = true;
        }
        }
        else
        {
            x = 300;
            y = 200;
        
        }
    
    }
    
    private void sideHit(int side){
        if (side == 0 && gameO == true){ //BALL HIT LEFT SIDE
            rightScore += 10;
            rightScoreDisplay.setText(rightScore + "");
            if (rightScore >= 10){
                gameWon(1);
            }
        } else if (side == 1 && gameO == true){ //BALL HIT RIGHT SIDE
            leftScore += 10;
            leftScoreDisplay.setText(leftScore + "");
            if (leftScore >= 10){
                gameWon(0);
            }
        }
        xDirection = !xDirection;
        yDirection = !yDirection;
        startFlag = false;
        x = 300;
        y = 200;
        System.out.println("Left Score: " + leftScore);
        System.out.println("Right Score: " + rightScore);
    }
    
    private void gameWon(int side){
        if (side == 0){
            System.out.println("LEFT SIDE WINS");
            jLabel3.setVisible(true);
            jButton2.setVisible(true);
            jButton2.setEnabled(true);
            gameO = false;
            //gameO = false; //sets gameO to false which prevents the use of a space bar to play
            
        } else if (side == 1){
            System.out.println("RIGHT SIDE WINS");
            jLabel2.setVisible(true);
            jButton2.setVisible(true);
            jButton2.setEnabled(true);
            gameO = false;
          //  gameO = false; //sets gameO to false which prevents the use of the spacebar to play the game
            
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

        jLabel1 = new javax.swing.JLabel();
        leftScoreDisplay = new javax.swing.JLabel();
        rightScoreDisplay = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));

        leftScoreDisplay.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        leftScoreDisplay.setText(leftScore + "");

        rightScoreDisplay.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        rightScoreDisplay.setText(rightScore + "");

        jButton1.setText("Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("End");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Left Wins!!!!!!!");

        jLabel3.setText("Right Wins!!!!!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(leftScoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(rightScoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftScoreDisplay)
                    .addComponent(rightScoreDisplay))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        leftScoreDisplay.getAccessibleContext().setAccessibleName("leftScoreDisplay");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        rightScore = rightScore*0; 
        leftScore = leftScore*0;
        x = 300;
        y = 200;
        ballStop = false;
        rightScoreDisplay.setText(rightScore + "");
        leftScoreDisplay.setText(leftScore + "");
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        gameO = true; //sets gameO to true for the next game
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "menu");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        rightScore = 0; 
        leftScore = 0;
        x = 300;
        y = 200;
        ballStop = false;
        rightScoreDisplay.setText(rightScore + "");
        leftScoreDisplay.setText(leftScore + "");
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        gameO = true; //sets gameO to true for the next game
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "menu");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel leftScoreDisplay;
    private javax.swing.JLabel rightScoreDisplay;
    // End of variables declaration//GEN-END:variables
}
