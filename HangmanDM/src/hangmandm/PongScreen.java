/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/***************************************************************  
*  file: PongScreen.java 
*  author:  D.Menkir, J. Ong, Kevin, S. Araya
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Program 1.3  
*  date last modified: 10/24/2022 
*  
*  purpose: Contains the ball and paddles for the pong game.
*  
****************************************************************/ 
public class PongScreen extends javax.swing.JPanel {

    private int x;
    private int y;
    private final int border;
    private boolean yDirection; //true is up, false is down
    private boolean xDirection; // true is right, false is left
    private boolean startFlag;
    private int leftScore;
    private int rightScore;
    public static Paddle p1;
    public static Paddle p2;
    
    
    //method: PongScreen
    //purpose: is the constructor of this class. initializes variables
    public PongScreen() {
        initComponents();
        x = 150;
        y = 150;
        border = 15;
        yDirection = true;
        xDirection = true;
        startFlag = false;
        
        
        leftScore = 0;
        rightScore = 0;
        
        p1 = new Paddle(1);
        p2 = new Paddle(2);
        
        
        
    }
    
    //method: paint
    //purpose: paints the pong game in a 150 x 150 pixel panel
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        p1.draw(g);
        p2.draw2(g);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g.fillOval(x, y, border, border);
        if(startFlag)
        {
            moveBall();
            
            if(x>=getWidth()-1-border){
                System.out.println("HIT RIGHT");
                sideHit(1);
            }
            if (x <=1){
                System.out.println("HIT LEFT");
                sideHit(0);
            }
            checkPaddleCollision(p1,p2);
        }
        else
            resetBall();

        repaint();
        try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(PongPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    //method: getStartFlag
    //purpose: returns start flag
    boolean getStartFlag()
    {
        return startFlag;
    }
    
    //method: setStartFlag
    //purpose: sets startFlag to start
    void setStartFlag(boolean start)
    {
        startFlag = start;
    }
    
    //method: moveBall
    //purpose: moves the ball in a random direction
    private void moveBall()
    {
        
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
        if(x <=0 || xDirection)
        {
            x = x+1;
            xDirection = true;
        }
        
    
    }

    //method: resetBall
    //purpose: resets the ball to its original position and helps with ball direction randomization
    private void resetBall(){

        xDirection = !xDirection;
        yDirection = !yDirection;
        startFlag = false;
        x = 150;
        y = 150;
        p1.resetPaddle();
        p2.resetPaddle();
    }
    
    //method: resetGame
    //purpose: resets Pong game
    void resetGame(){
        resetBall();
        rightScore = 0; 
        leftScore = 0;
        
        
    }
    
    //method: sideHit
    //purpose: determines which side was hit
    private void sideHit(int side){
        startFlag = false;
        if (side == 0){ //BALL HIT LEFT SIDE
            rightScore += 10;
            
            
        } else if (side == 1){ //BALL HIT RIGHT SIDE
            leftScore += 10;
            
            
        }
        resetBall();
        System.out.println("Left Score: " + leftScore);
        System.out.println("Right Score: " + rightScore);
    }
    
    
    //method: getLeftScore
    //purpose: returns left side's score
    int getLeftScore()
    {
        return leftScore;
    }
    
    //method: getRightScore
    //purpose: returns right side's score
     int getRightScore()
    {
        return rightScore;
    }
        
    //method: checkPaddleCollision
    //purpose: checks to see if the ball hit the paddle
    public void checkPaddleCollision(Paddle p1, Paddle p2){
        if(x <= 20){
            if(y >= p1.getY() && y <= p1.getY() + 80){
                xDirection = true;
            }
        }
        else if(x >= 280){
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

        setMaximumSize(new java.awt.Dimension(300, 300));
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
