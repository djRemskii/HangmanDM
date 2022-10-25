/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import static hangmandm.GamePanel.letterReset;
import java.awt.CardLayout;
import javax.swing.SwingUtilities; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.BorderFactory; 
import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;
/***************************************************************  
*  file: PongPanel.java 
*  author: J. Ong,  
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Program 1.3  
*  date last modified: 10/24/2022 
*  
*  purpose: Creates the overall Pong game panel, handles point logic.
*  
****************************************************************/ 
public class PongPanel extends javax.swing.JPanel {

    
    
    private int gameO;
    
    /**
     * Creates new form PongPanel
     */
    public PongPanel() {
        Timer t = new Timer(1000, updateClockAction);
        t.start();
        
        initComponents();
       
        gameO = 0;
        
        
        endButton.setVisible(false);
        endButton.setEnabled(false);
        jLabel1.setOpaque(false);
        jLabel1.setBounds(0, 0, 1, 1);
        leftWinLabel.setVisible(false);
        rightWinLabel.setVisible(false);
        
        AbstractAction pongStart = new AbstractAction("startGame"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                if(!(pongScreen1.getLeftScore() >= 100) && !(pongScreen1.getRightScore() >= 100))
                {
                    pongScreen1.setStartFlag(true);
                    gameO++;
                }
                else
                {
                    pongScreen1.setStartFlag(false);
                }
                
            }
        };
        AbstractAction credits = new AbstractAction("goToCredits"){
        
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("it worked");
            CardLayout cards = new CardLayout();
            jDialog1.setLayout(cards);
            jDialog1.add(new CreditsPanelNoMenu(), "credits");
            cards.show(jDialog1.getContentPane(), "credits");
            jDialog1.setModal(true);
            jDialog1.pack();
            jDialog1.setLocationRelativeTo(null);
            jDialog1.setVisible(true);
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "goToCredits");
        jLabel1.getActionMap().put("goToCredits", credits);
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "startGame");
        jLabel1.getActionMap().put("startGame", pongStart);    
    
                AbstractAction moveUp = new AbstractAction("moveUp"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                if(pongScreen1.getStartFlag())
                {
                    PongScreen.p1.moveUp();
                }
                
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "moveUp");
        jLabel1.getActionMap().put("moveUp", moveUp); 
        
                AbstractAction moveDown = new AbstractAction("moveDown"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                if(pongScreen1.getStartFlag())
                {
                    PongScreen.p1.moveDown();
                }
                
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        jLabel1.getActionMap().put("moveDown", moveDown); 
        
        AbstractAction moveDown2 = new AbstractAction("moveDown2"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                if(pongScreen1.getStartFlag())
                {
                    PongScreen.p2.moveDown2();
                }
                
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "moveDown2");
        jLabel1.getActionMap().put("moveDown2", moveDown2); 
        
        AbstractAction moveUp2 = new AbstractAction("moveUp2"){
                
             @Override
            public void actionPerformed(ActionEvent e){
                if(pongScreen1.getStartFlag())
                {
                    PongScreen.p2.moveUp2();
                }
                
            }
        };
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "moveUp2");
        jLabel1.getActionMap().put("moveUp2", moveUp2); 
        AbstractAction esc = new AbstractAction("escape"){
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }};
        
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        jLabel1.getActionMap().put("escape", esc);
    }
    
        
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");  
    private LocalDateTime now = LocalDateTime.now();
    
    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a JLabel
            now = LocalDateTime.now();
            jLabel2.setText(dtf.format(now)); 
            
            
            
            
        }
    };

  
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        leftScoreDisplay.setText(pongScreen1.getLeftScore()+"");
        rightScoreDisplay.setText(""+pongScreen1.getRightScore());
        
        if(pongScreen1.getLeftScore() == 100)
        {
            leftWinLabel.setVisible(true);
            endButton.setVisible(true);
            endButton.setEnabled(true);
        }
        if(pongScreen1.getRightScore() == 100)
        {
            rightWinLabel.setVisible(true);
            endButton.setVisible(true);
            endButton.setEnabled(true);
        }
            
        repaint();
        
    }

    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        leftScoreDisplay = new javax.swing.JLabel();
        rightScoreDisplay = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        leftWinLabel = new javax.swing.JLabel();
        rightWinLabel = new javax.swing.JLabel();
        pongScreen1 = new hangmandm.PongScreen();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        leftScoreDisplay.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        leftScoreDisplay.setText(0 + "");

        rightScoreDisplay.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        rightScoreDisplay.setText(0 + "");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftScoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftWinLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(quitButton)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pongScreen1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(endButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rightScoreDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rightWinLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(leftWinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(leftScoreDisplay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(rightWinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rightScoreDisplay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addComponent(pongScreen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );

        leftScoreDisplay.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed


        
        rightScoreDisplay.setText(0 + "");
        leftScoreDisplay.setText(0 + "");
        leftWinLabel.setVisible(false);
        rightWinLabel.setVisible(false);
        
        gameO = 0;
        pongScreen1.resetGame();

        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "menu");
    }//GEN-LAST:event_quitButtonActionPerformed


   

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
         
        rightScoreDisplay.setText(0 + "");
        leftScoreDisplay.setText(0 + "");
        leftWinLabel.setVisible(false);
        rightWinLabel.setVisible(false);
        gameO = 0;
        pongScreen1.resetGame();

        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "menu");
    }//GEN-LAST:event_endButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endButton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel leftScoreDisplay;
    private javax.swing.JLabel leftWinLabel;
    private hangmandm.PongScreen pongScreen1;
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel rightScoreDisplay;
    private javax.swing.JLabel rightWinLabel;
    // End of variables declaration//GEN-END:variables
}
