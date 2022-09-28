/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;
import static hangmandm.HangmanDM.frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import javax.swing.JLabel;
import javax.swing.Timer;
import java.util.Random;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author saray
 */
public class ColorGamePanel extends javax.swing.JPanel {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now(); 
    
    
    public ColorGamePanel(int points) {
        
        score = points;
        setBorder(null);
        Timer t = new Timer(1000, updateClockAction);
        t.start();
        initComponents();
        locations = new Point[]{jButton1.getLocation(), jButton2.getLocation(), jButton3.getLocation(), jButton4.getLocation(), jButton5.getLocation()};
        randomize.add(0);
        randomize.add(1);
        randomize.add(2);
        randomize.add(3);
        randomize.add(4);
        repeat();
        
        
   
        
    }
    private void repeat()
    {
        Random random_method = new Random();
        Random random_method2 = new Random();
        
        randomVessel = random_method.nextInt(colorList.length);
        randomVessel2 = random_method2.nextInt(colorList.length);
        
        java.util.Collections.shuffle(randomize);
        colorL = colorList[randomVessel];
        color = colorList[randomVessel2];
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
    
    private void correct(){
     score = score + 100;
     System.out.println(score);
     round++;
     rounds();
     repeat();
    }
    
    private void rounds()
    {
        if (round == 5)
        {
            frame.add(new end(getScore()),"endColor");

            resetGame();

            //resetGame();
            System.out.println("game ends");

            HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "endColor");
        }          
    }
    
    private void resetGame()
    {
        round = 1;
        
    }
    
    public static int getScore()
    {
        return score; 
    } 
    
    private void labelColor()
    {
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
    
     private void colorColor()
    {
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
        jButton1.setBounds(300, 180, 40, 50);
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel1.setText("jLabel1");

        jLabel2.setText("Color");
        jLabel2.setLocation(280, 160);
        add(jLabel2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RedButton.png"))); // NOI18N
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jButton1)))
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
                        .addContainerGap(63, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if( color.equals("Red"))
        {
            correct();
        }
        else
        {
            round++;


            rounds();
            repeat();

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          if( color.equals("Purple"))
        {
            correct();
        }
        else
        {
            round++;
            rounds();
            repeat();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if( color.equals("Yellow"))
        {
            correct();
        }
        else
        {
            round++;
            rounds();
            repeat();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          if( color.equals("Blue"))
        {
            correct();
        }
        else
        {
            round++;
            rounds();
            repeat();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if( color.equals("Green"))
        {
            correct();
        }
        else
        {
            round++;
            rounds();
            repeat();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
 
   
   

    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a JLabel
            now = LocalDateTime.now();
            jLabel1.setText(dtf.format(now)); 
        }
    };



    private int randomVessel;
    private int randomVessel2;
    private int randomVessel3;
    private int randomVessel4;
    private static int score;
    private String colorL;
    private String color;
    private int round;
    private final String [] colorList = {"Red","Yellow","Green","Blue","Purple"};
    private final Point [] locations;
    private final ArrayList<Integer> randomize = new ArrayList<Integer>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
