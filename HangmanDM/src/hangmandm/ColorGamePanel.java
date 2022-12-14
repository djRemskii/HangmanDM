/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;
import static hangmandm.HangmanDM.frame;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import javax.swing.JLabel;
import javax.swing.Timer;
import java.util.Random;
import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
/***************************************************************  
*  file: ColorGamePanel.java 
*  authors: J. Ong, D Menkir, S. Araya, Kevin Hoang
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Program 1.1  
*  date last modified: 10/15/2022 
*  
*  purpose: Displays the colors game.
*  
****************************************************************/ 
public class ColorGamePanel extends javax.swing.JPanel {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    private int randomVessel;
    private int randomVessel2;
    public static int score;
    private String colorL;
    private String color;
    private int round;
    private final String [] COLOR_LIST = {"Red","Yellow","Green","Blue","Purple"};
    private final Point [] locations;
    private final ArrayList<Integer> randomize = new ArrayList<Integer>();
    
    //method: ColorGamePanel
    //purpose: is the constructor of this class. initializes variables
    public ColorGamePanel(int points) {
        
        score = points;
        setBorder(null);
        Timer t = new Timer(1000, updateClockAction);
        t.start();
        initComponents();
        boxTT();
        locations = new Point[]{jButton1.getLocation(), jButton2.getLocation(), jButton3.getLocation(), jButton4.getLocation(), jButton5.getLocation()};
        randomize.add(0);
        randomize.add(1);
        randomize.add(2);
        randomize.add(3);
        randomize.add(4);
        repeat();
        AbstractAction esc = new AbstractAction("escape"){
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
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
       
        jLabel3.setOpaque(false);
        jLabel3.setBounds(0, 0, 1, 1);
        
        
        jLabel3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "goToCredits");
        jLabel3.getActionMap().put("goToCredits", credits);
        jLabel3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        jLabel3.getActionMap().put("escape", esc);
    }
    //Method boxTT
    //Purpose: Adds tool tips
    private void boxTT()
    {
        //first row
        jButton1.setToolTipText("Red");
        jButton2.setToolTipText("Purple");
        jButton3.setToolTipText("Yellow");
        jButton4.setToolTipText("Blue");
        jButton5.setToolTipText("Green");
    }
      
        
    //method: repeat
    //purpose: randomizes button location, word color, and word text
    private void repeat()
    {
        Random random_Method = new Random();
        Random random_Method2 = new Random();
        
        randomVessel = random_Method.nextInt(COLOR_LIST.length);
        randomVessel2 = random_Method2.nextInt(COLOR_LIST.length);
        
        java.util.Collections.shuffle(randomize);
        colorL = COLOR_LIST[randomVessel];
        color = COLOR_LIST[randomVessel2];
        Point x1 = locations[randomize.get(0)];
        
        Point x2 = locations[randomize.get(1)];
        
        Point x3 = locations[randomize.get(2)];
        
        Point x4 = locations[randomize.get(3)];
        
        Point x5 = locations[randomize.get(4)];
        
        labelColor();
        colorColor();
        
        
        
        jButton1.setBounds(x1.x, x1.y, 106, 106);
        jButton2.setBounds(x2.x, x2.y, 106, 106);
        jButton3.setBounds(x3.x, x3.y, 106, 106);
        jButton4.setBounds(x4.x, x4.y, 106, 106);
        jButton5.setBounds(x5.x, x5.y, 106, 106);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jButton5);
        
        
    }
    
    
    //method: correct
    //purpose: after the correct button is pressed, the score is increased by 100, the rounds increase, and rounds() and repeat() are called
    private void correct() throws IOException{
     score = score + 100;
     System.out.println(score);
     round++;
     rounds();
     repeat();
    }
    
    //method: rounds
    //purpose: checks to see if 5 rounds have past
    private void rounds() throws IOException
    {
        if (round >= 5)
        {
            frame.add(new SudokuPanel(getScore()), "sudoku");
            System.out.println(getScore());
            resetGame();

            //resetGame();
            System.out.println("game ends");
            HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "sudoku");
        }          
    }
    
    //method: resetGame
    //purpose: resets the color game
    private void resetGame()
    {
        round = 1;
        
    }
    
    //method: getScore
    //purpose: returns score
    public static int getScore()
    {
        return score; 
    } 
    
    //method: labelColor
    //purpose: changes the text of the word when called
    private void labelColor(){
        switch (colorL) {
            case "Red" -> {
               jLabel2.setText("Red");
            }
            case "Yellow" -> {
               jLabel2.setText("Yellow");
            }
            case "Green" -> {
               jLabel2.setText("Green");
            }
             case "Blue" -> {
               jLabel2.setText("Blue");
            }
             case "Purple" -> {
               jLabel2.setText("Purple");
            }
            default -> {
              System.out.println("error");
            }
        }
    }
    
    //method: colorColor
    //purpose: changes the color of the word when called
    private void colorColor(){
        switch (color) {
            case "Red" -> {
               jLabel2.setForeground(Color.RED);
            }
            case "Yellow" -> {
               jLabel2.setForeground(Color.YELLOW);
            }
            case "Green" -> {
               jLabel2.setForeground(Color.GREEN);
            }
             case "Blue" -> {
               jLabel2.setForeground(Color.BLUE);
            }
             case "Purple" -> {
               jLabel2.setForeground(new java.awt.Color(153, 0, 255));
            }
            default -> {
              System.out.println("error");
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

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel2.setText("Color");
        jLabel2.setLocation(280, 160);
        add(jLabel2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RedButton.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(30, 30, 106, 106);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PurpleButton.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(70, 200, 106, 106);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/YellowButton.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(200, 220, 106, 106);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BlueButton.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(370, 200, 106, 106);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GreenButton.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton1.setBounds(420, 70, 106, 106);

        jLabel4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton2)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(117, 117, 117))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(93, 93, 93))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(347, 347, 347)
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    //methods: jButton_ActionPerformed
    //purpose: Actions performed when the colored buttons are pushed. If the correct button is pushed, correct() is called, 
    //else no points are given, the round counter increases, and rounds() is called.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if( color.equals("Red"))
        {
             try {
                 correct();
             } catch (IOException ex) {
                 Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else
        {
            round++;


             try {
                 rounds();
             } catch (IOException ex) {
                 Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
             }
            repeat();

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          if( color.equals("Purple"))
        {
              try {
                  correct();
              } catch (IOException ex) {
                  Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        else
        {
            round++;
              try {
                  rounds();
              } catch (IOException ex) {
                  Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
              }
            repeat();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if( color.equals("Yellow"))
        {
            try {
                correct();
            } catch (IOException ex) {
                Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            round++;
            try {
                rounds();
            } catch (IOException ex) {
                Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            repeat();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          if( color.equals("Blue"))
        {
              try {
                  correct();
              } catch (IOException ex) {
                  Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        else
        {
            round++;
              try {
                  rounds();
              } catch (IOException ex) {
                  Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
              }
            repeat();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if( color.equals("Green"))
        {
             try {
                 correct();
             } catch (IOException ex) {
                 Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else
        {
            round++;
             try {
                 rounds();
             } catch (IOException ex) {
                 Logger.getLogger(ColorGamePanel.class.getName()).log(Level.SEVERE, null, ex);
             }
            repeat();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
 
   
   

    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a JLabel
            now = LocalDateTime.now();
            jLabel1.setText(dtf.format(now));
            jLabel4.setText("Score: " + score);
        }
    };



    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
