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
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
/**
 *
 * @author danie
 */
public class PongPanel extends javax.swing.JPanel{

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
    Paddle p1;
    Paddle p2;
    
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
        endButton.setVisible(false);
        endButton.setEnabled(false);
        jLabel1.setOpaque(false);
        jLabel1.setBounds(0, 0, 1, 1);
        leftWinLabel.setVisible(false);
        rightWinLabel.setVisible(false);
        p1 = new Paddle(1);
        p2 = new Paddle(2);
        if(gameO = true){
        AbstractAction pongStart = new AbstractAction("startGame"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                startFlag = true;
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "startGame");
        jLabel1.getActionMap().put("startGame", pongStart);
        
        AbstractAction moveUp = new AbstractAction("moveUp"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                p1.moveUp();
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "moveUp");
        jLabel1.getActionMap().put("moveUp", moveUp); 
        
                AbstractAction moveDown = new AbstractAction("moveDown"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                p1.moveDown();
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        jLabel1.getActionMap().put("moveDown", moveDown); 
        
        AbstractAction moveDown2 = new AbstractAction("moveDown2"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                p2.moveDown2();
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "moveDown2");
        jLabel1.getActionMap().put("moveDown2", moveDown2); 
        
        AbstractAction moveUp2 = new AbstractAction("moveUp2"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                p2.moveUp2();
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "moveUp2");
        jLabel1.getActionMap().put("moveUp2", moveUp2); 
    }
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        p1.draw(g);
        p2.draw2(g);
        
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
        checkPaddleCollision(p1,p2);
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

  

    private void resetBall(){

        xDirection = !xDirection;
        yDirection = !yDirection;
        startFlag = false;
        x = 300;
        y = 200;
    }
    
    private void resetGame(){
        resetBall();
        rightScore = 0; 
        leftScore = 0;
        rightScoreDisplay.setText(rightScore + "");
        leftScoreDisplay.setText(leftScore + "");
        leftWinLabel.setVisible(false);
        rightWinLabel.setVisible(false);
        gameO = true; //sets gameO to true for the next game
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
        resetBall();
        System.out.println("Left Score: " + leftScore);
        System.out.println("Right Score: " + rightScore);
    }
    
    private void gameWon(int side){
        if (side == 0){
            System.out.println("LEFT SIDE WINS");

            leftWinLabel.setVisible(true);
            endButton.setVisible(true);
            endButton.setEnabled(true);
            gameO = false;
            //gameO = false; //sets gameO to false which prevents the use of a space bar to play
            
        } else if (side == 1){
            System.out.println("RIGHT SIDE WINS");
            rightWinLabel.setVisible(true);
            endButton.setVisible(true);
            endButton.setEnabled(true);
            gameO = false;
          //  gameO = false; //sets gameO to false which prevents the use of the spacebar to play the game

            rightWinLabel.setVisible(true);
            endButton.setVisible(true);
            endButton.setEnabled(true);
            
            gameO = false; //sets gameO to false which prevents the use of a space bar to play
            
        } else if (side == 1){
            System.out.println("RIGHT SIDE WINS");
            leftWinLabel.setVisible(true);
            endButton.setVisible(true);
            endButton.setEnabled(true);
            
            gameO = false; //sets gameO to false which prevents the use of the spacebar to play the game

            
        }
    }
    public void checkPaddleCollision(Paddle p1, Paddle p2){
        if(x <= 40){
            if(y >= p1.getY() && y <= p1.getY() + 80){
                xDirection = true;
            }
        }
        else if(x >= 525){
            if(y >= p2.getY2() && y <= p2.getY2() + 80){
                xDirection = false;
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

        jLabel1 = new javax.swing.JLabel();
        leftScoreDisplay = new javax.swing.JLabel();
        rightScoreDisplay = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        leftWinLabel = new javax.swing.JLabel();
        rightWinLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));

        leftScoreDisplay.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        leftScoreDisplay.setText(leftScore + "");

        rightScoreDisplay.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        rightScoreDisplay.setText(rightScore + "");

        quitButton.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        endButton.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        endButton.setText("End");
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        leftWinLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        leftWinLabel.setText("Left Wins!!!!!!!");

        rightWinLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        rightWinLabel.setText("Right Wins!!!!!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftScoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(rightScoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftWinLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rightWinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitButton)
                .addGap(18, 18, 18)
                .addComponent(endButton)
                .addGap(244, 244, 244))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rightWinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leftWinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftScoreDisplay)
                    .addComponent(rightScoreDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endButton)
                    .addComponent(quitButton))
                .addContainerGap())
        );

        leftScoreDisplay.getAccessibleContext().setAccessibleName("leftScoreDisplay");
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed


        rightScore = rightScore*0; 
        leftScore = leftScore*0;
        x = 300;
        y = 200;
        ballStop = false;
        rightScoreDisplay.setText(rightScore + "");
        leftScoreDisplay.setText(leftScore + "");
        leftWinLabel.setVisible(false);
        rightWinLabel.setVisible(false);
        gameO = true; //sets gameO to true for the next game

        resetGame();

        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "menu");
    }//GEN-LAST:event_quitButtonActionPerformed


   

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
          rightScore = 0; 
        leftScore = 0;
        x = 300;
        y = 200;
        ballStop = false;
        rightScoreDisplay.setText(rightScore + "");
        leftScoreDisplay.setText(leftScore + "");
        leftWinLabel.setVisible(false);
        rightWinLabel.setVisible(false);
        gameO = true; //sets gameO to true for the next game
        resetGame();

        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "menu");
    }//GEN-LAST:event_endButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel leftScoreDisplay;
    private javax.swing.JLabel leftWinLabel;
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel rightScoreDisplay;
    private javax.swing.JLabel rightWinLabel;
    // End of variables declaration//GEN-END:variables

}
