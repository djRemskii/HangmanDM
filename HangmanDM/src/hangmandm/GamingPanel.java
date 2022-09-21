/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import static hangmandm.HangmanDM.frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

// timer imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import javax.swing.JLabel;
import javax.swing.Timer;


/**
 *//// Samuel and Daniel
 //* @author saray
//*/
public class GamingPanel extends javax.swing.JPanel {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now(); 
    
     
    public GamingPanel() 
    {   
        setBorder(null);
        HangmanDM.cardLayout.invalidateLayout(HangmanDM.frame.getContentPane());
        Timer t = new Timer(1000, updateClockAction);
        t.start();
        Random random_method = new Random();
        randomVessel = random_method.nextInt(LIST.length);
        word = LIST[randomVessel];//LIST[randomVessel];
        
        
        
        initComponents();
        
        
        
                
        
        
        System.out.println(word);
        spacer(word);
        corr = 0;
        lives = 6;
        lifeCheck(lives);
        score = 100;
        frame.getContentPane().add(new end(this.getScore()),"end");     
    }
    //getter for the score
    public static int getScore()
    {
        return score; 
    } 
    private void endGame()
    {
        
            HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "high scores");
        
    }
    private void lifeCheck(int life)
    {   
        System.out.println(life);
        switch (life) {
            case 6 -> { frame.getContentPane().add(new end(this.getScore()),"end");
            revalidate();
            repaint();
            //customDrawingHangingPost1 = new hangmandm.CustomDrawingHangingPost(life);
            }
            //checks life and changes hangman symbol
            case 5 -> { frame.getContentPane().add(new end(this.getScore()),"end");
            revalidate();
            repaint();
            //customDrawingHangingPost1 = new hangmandm.CustomDrawingHangingPost(life);
            }
            case 4 -> { frame.getContentPane().add(new end(this.getScore()),"end");
            revalidate();
            repaint();
            //customDrawingHangingPost1 = new hangmandm.CustomDrawingHangingPost(life);
            }
            case 3 -> { frame.getContentPane().add(new end(this.getScore()),"end");
            revalidate();
            repaint();
            //customDrawingHangingPost1 = new hangmandm.CustomDrawingHangingPost(life);
            }
            case 2 -> { frame.getContentPane().add(new end(this.getScore()),"end");
            revalidate();
            repaint();
            //customDrawingHangingPost1 = new hangmandm.CustomDrawingHangingPost(life);
            }
            case 1 -> { frame.getContentPane().add(new end(this.getScore()),"end");
            revalidate();
            repaint();
            //customDrawingHangingPost1 = new hangmandm.CustomDrawingHangingPost(life);
            }
            case 0 -> {
                  frame.getContentPane().add(new end(this.getScore()),"end");
                  revalidate();
                  repaint();
                  //customDrawingHangingPost1 = new hangmandm.CustomDrawingHangingPost(lives);
                System.out.println("You looooooooooooooooose");
                /*
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("src\\Hangman7.png")));
                HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "high scores");
                */
            }
            default -> {
            }    
        }
        //customDrawingHangingPost2.revalidate();
        //customDrawingHangingPost2.repaint();
    }
    
    @Override
    public Dimension getPreferredSize() { 
        return new Dimension(600,400); 
    } 
 
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        g.setColor(Color.BLACK);
        g.drawLine(0, 99, 99, 99);
        g.drawLine(49, 99, 49, 0);
        g.drawLine(49, 0, 70, 0);
        g.drawLine(70, 0, 70, 30);
        switch (lives) {
            case 6 -> { 
                break;
            }
            case 5 ->             {
               g.drawOval(65, 30, 10, 10); //head
               revalidate();
               repaint();
               break;
            }
                
            case 4 ->             {
               g.drawOval(65, 30, 10, 10); //head
               g.drawLine(70, 40, 70, 70); //torso
               revalidate();
               repaint();
               break;
            }
                
            case 3 ->             {
                g.drawOval(65, 30, 10, 10); //head
                g.drawLine(70, 40, 70, 70); //torso
                g.drawLine(70, 55, 60, 65); //left arm
                revalidate();
                repaint();
                break;
            }
                
            case 2 ->             {
                g.drawOval(65, 30, 10, 10); //head
                g.drawLine(70, 40, 70, 70); //torso
                g.drawLine(70, 55, 60, 65); //left arm
                g.drawLine(70, 55, 80, 65); //right arm
                revalidate();
                repaint();
                break;
            }
                
            case 1 ->             {
                g.drawOval(65, 30, 10, 10); //head
                g.drawLine(70, 40, 70, 70); //torso
                g.drawLine(70, 55, 60, 65); //left arm
                g.drawLine(70, 55, 80, 65); //right arm
                g.drawLine(70, 70, 55, 85); //left leg
                revalidate();
                repaint();
                break;
            }
                
            case 0 ->             {
                g.drawOval(65, 30, 10, 10); //head
                g.drawLine(70, 40, 70, 70); //torso
                g.drawLine(70, 55, 60, 65); //left arm
                g.drawLine(70, 55, 80, 65); //right arm
                g.drawLine(70, 70, 55, 85); //left leg
                g.drawLine(70, 70, 85, 85); //right leg
                revalidate();
                repaint();
                break;
            }
                
        }
    }
    
        private void correct()
        {
        if( corr == word.length())
            {
                frame.getContentPane().add(new end(this.getScore()),"end");
                lives = 6;
                score = 100;
                corr = 0;
                jLabel10.setText("?");
                jLabel11.setText("?");
                jLabel12.setText("?");
                jLabel13.setText("?");
                jLabel14.setText("?");
                jLabel15.setText("?");
                jLabel16.setText("?");
                jLabel17.setText("?");
                jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png")));
                jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png")));
                jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png")));
                jButton2.setEnabled(true);
                jButton3.setEnabled(true);
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
                jButton6.setEnabled(true);
                jButton7.setEnabled(true);
                jButton8.setEnabled(true);
                jButton9.setEnabled(true);
                jButton10.setEnabled(true);
                jButton11.setEnabled(true);
                jButton12.setEnabled(true);
                jButton13.setEnabled(true);
                jButton14.setEnabled(true);
                jButton15.setEnabled(true);
                jButton16.setEnabled(true);
                jButton17.setEnabled(true);
                jButton18.setEnabled(true);
                jButton19.setEnabled(true);
                jButton20.setEnabled(true);
                jButton21.setEnabled(true);
                jButton22.setEnabled(true);
                jButton23.setEnabled(true);
                jButton24.setEnabled(true);
                jButton25.setEnabled(true);
                jButton26.setEnabled(true);
                jButton27.setEnabled(true);
                Random random_method = new Random();
                randomVessel = random_method.nextInt(LIST.length);
                word = LIST[randomVessel];
                spacer(word);
                HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "end");
            }
        }
     private void spacer(String prob)
    {   
        switch (prob) {
             case "nurse" -> {
                 jLabel15.setText("");
                 jLabel16.setText("");
                 jLabel17.setText("");
                jLabel15.setIcon(null);
                 jLabel16.setIcon(null);
                 jLabel17.setIcon(null);
               //find way to get rid of the images
             }
             default -> {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        skipButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setMaximumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        skipButton.setText("Skip");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        jLabel18.setText("jLabel18");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skipButton)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(skipButton)))
        );

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png"))); // NOI18N
        jLabel10.setText("?");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png"))); // NOI18N
        jLabel11.setText("?");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png"))); // NOI18N
        jLabel12.setText("?");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png"))); // NOI18N
        jLabel13.setText("?");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png"))); // NOI18N
        jLabel14.setText("?");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png"))); // NOI18N
        jLabel15.setText("?");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png"))); // NOI18N
        jLabel16.setText("?");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line.png"))); // NOI18N
        jLabel17.setText("?");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel17.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel10))
                .addGap(152, 152, 152))
        );

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton5.setText("A");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton5.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton5.setRequestFocusEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton15.setText("N");
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton15.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton15.setRequestFocusEnabled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton2.setText("B");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton2.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton2.setRequestFocusEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton3.setText("C");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton3.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton3.setRequestFocusEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton4.setText("D");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton4.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton4.setRequestFocusEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton6.setText("E");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton6.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton6.setRequestFocusEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton7.setText("F");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton7.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton7.setRequestFocusEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton8.setText("G");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton8.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton8.setRequestFocusEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton9.setText("H");
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton9.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton9.setRequestFocusEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton10.setText("I");
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton10.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton10.setRequestFocusEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton11.setText("J");
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton11.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton11.setRequestFocusEnabled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton12.setText("K");
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton12.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton12.setRequestFocusEnabled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton13.setText("L");
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton13.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton13.setRequestFocusEnabled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton14.setText("M");
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton14.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton14.setRequestFocusEnabled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton16.setText("O");
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton16.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton16.setRequestFocusEnabled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton23.setText("P");
        jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton23.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton23.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton23.setRequestFocusEnabled(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton17.setText("Q");
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton17.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton17.setRequestFocusEnabled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton18.setText("R");
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton18.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton18.setRequestFocusEnabled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton19.setText("S");
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton19.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton19.setRequestFocusEnabled(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton20.setText("T");
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton20.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton20.setRequestFocusEnabled(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton21.setText("U");
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton21.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton21.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton21.setRequestFocusEnabled(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton22.setText("V");
        jButton22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton22.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton22.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton22.setRequestFocusEnabled(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton24.setText("W");
        jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton24.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton24.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton24.setRequestFocusEnabled(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton25.setText("X");
        jButton25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton25.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton25.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton25.setRequestFocusEnabled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton26.setText("Y");
        jButton26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton26.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton26.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton26.setRequestFocusEnabled(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton27.setText("Z");
        jButton27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton27.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton27.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton27.setRequestFocusEnabled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        if( lives == 0)
        {
            HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "high scores");
        }
         else
        {
            score = 0;
            lives = 0;
            frame.getContentPane().add(new end(this.getScore()),"end");
            HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "high scores");
        }
    }//GEN-LAST:event_skipButtonActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        //OOOOOOOOOOOOOOOOOOO
        jButton16.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        switch (word) {
            case "nurse" -> {
                jLabel10.setText("N");
                jButton15.setEnabled(false);
                corr++;
                correct();
            }
            case "climbing" -> {
                jLabel16.setText("n");
                jButton15.setEnabled(false);
                corr++;
                correct();
            }
            default -> {
                jButton15.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0)
                {
                    skipButtonActionPerformed(evt);
                }
            }
            //NNNNNNNNNNNNNNNNNNNNN
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        switch (word) {
            case "cemetery" -> {
                jLabel12.setText("m");
                jButton14.setEnabled(false);
                corr++;
                correct();
            }
            case "climbing" -> {
                jLabel13.setText("m");
                jButton14.setEnabled(false);
                corr++;
                correct();
            }
            case "pharmacy" -> {
                jLabel14.setText("m");
                jButton14.setEnabled(false);
                corr++;
                correct();
            }
            default -> {
                jButton14.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0)
                {
                    skipButtonActionPerformed(evt);
                }
            }
            //MMMMMMMMMMMMMMMMMMMMMMM
        }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (word.equals("climbing"))
        {
            jLabel11.setText("l");
            jButton13.setEnabled(false);
            corr++;
            correct();
        }
        else
        {
            jButton13.setEnabled(false);
            score = score - 10;
            lives = lives - 1;
            lifeCheck(lives);
            System.out.println("Wrong, please try again" + lives + " more lives left.");
            if( lives == 0)
            {
                skipButtonActionPerformed(evt);
            }
        }

        //LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        //KKKKKKKKKKKKKKKKKKKKK
        jButton12.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        //JJJJJJJJJJJJJJJJJJJ
        jButton11.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (word.equals("climbing"))
        {
            jLabel12.setText("i");
            jLabel15.setText("i");
            jButton10.setEnabled(false);
            corr++;
            correct();
            corr++;
            correct();

        }
        else
        {
            jButton10.setEnabled(false);
            score = score - 10;
            lives = lives - 1;
            lifeCheck(lives);
            System.out.println("Wrong, please try again" + lives + " more lives left.");
            if( lives == 0)
            {
                skipButtonActionPerformed(evt);
            }
        }

        //IIIIIIIIIIIIIIIIIII

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (word.equals("pharmacy"))
        {
            jLabel11.setText("h");
            jButton11.setEnabled(false);
            corr++;
            correct();
        }
        else
        {
            jButton9.setEnabled(false);
            score = score - 10;
            lives = lives - 1;
            lifeCheck(lives);
            System.out.println("Wrong, please try again" + lives + " more lives left.");
            if( lives == 0)
            {
                skipButtonActionPerformed(evt);
            }
        }

        //HHHHHHHHHHHHHHHHHHHHHHHHH
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (word.equals("climbing"))
        {
            jLabel17.setText("g");
            jButton8.setEnabled(false);
            corr++;
            correct();
        }
        else
        {
            jButton8.setEnabled(false);
            lives = lives - 1;
            score = score - 10;

            System.out.println("Wrong, please try again" + lives + "more lives left.");
            if( lives == 0)
            {
                skipButtonActionPerformed(evt);
            }
        }

        //GGGGGGGGGGGGGGGG

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //FFFFFFFFFFFFFFFFFFFFFF
        jButton7.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0 )
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        switch (word) {
            case "cemetery" -> {
                jLabel11.setText("e");
                jLabel13.setText("e");
                jLabel15.setText("e");
                jButton6.setEnabled(false);
                corr++;
                correct();
                corr++;
                correct();
                corr++;
                correct();

            }
            case "nurse" -> {
                jLabel14.setText("e");
                jButton6.setEnabled(false);
                corr++;
                correct();

            }
            default -> {
                jButton6.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0 )
                {
                    skipButtonActionPerformed(evt);
                }
            }
            //EEEEEEEEEEEEEEEEEE
        }
        //show it on label

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        switch (word) {
            case "abstract" -> {
                jLabel15.setText("a");
                jLabel10.setText("A");
                jButton5.setEnabled(false);
                corr++;
                correct();
                corr++;
                correct();
            }
            case "pharmacy" -> {
                jLabel12.setText("a");
                jLabel15.setText("a");
                jButton5.setEnabled(false);
                corr++;
                correct();
                corr++;
                correct();

            }
            default -> {
                jButton5.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0 )
                {
                    skipButtonActionPerformed(evt);
                }
            }
            //AAAAAAAAA
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //DDDDDDDD
        jButton4.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        switch (word) {
            case "cemetery" -> {

                jLabel10.setText("C");
                jButton3.setEnabled(false);
                corr++;
                correct();
            }
            case "climbing" -> {
                jLabel10.setText("C");
                jButton3.setEnabled(false);
                corr++;
                correct();
            }
            case "abstract" -> {
                jLabel16.setText("c");
                jButton3.setEnabled(false);
                corr++;
                correct();
            }
            case "pharmacy" -> {
                jLabel16.setText("c");
                jButton3.setEnabled(false);
                corr++;
                correct();
            }
            default -> {
                jButton3.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0)
                {
                    skipButtonActionPerformed(evt);
                }
            }

        }
        //show it on label

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        switch (word) {
            case "abstract" -> {
                jLabel11.setText("b");
                jButton2.setEnabled(false);
                corr++;
                correct();
            }
            case "climbing" -> {
                jLabel14.setText("b");
                jButton2.setEnabled(false);
                corr++;
                correct();
            }
            default -> {
                jButton2.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
            }
            //BBBBBBBBBBBBBBB

        }

        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        //ZZZZZZZZZZZZZZZZZZZZZZZ
        jButton27.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        switch (word) {
            case "pharmacy" -> {
                jLabel17.setText("y");
                jButton26.setEnabled(false);
                corr++;
                correct();
            }
            case "cemetery" -> {
                jLabel17.setText("y");
                jButton26.setEnabled(false);
                corr++;
                correct();
            }
            default -> {
                jButton26.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0)
                {
                    skipButtonActionPerformed(evt);
                }
            }
            //YYYYYYYYYYYYYYYYYYYYYY
        }

    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        jButton25.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        jButton24.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if (word.equals("pharmacy"))
        {
            jLabel10.setText("P");
            jButton23.setEnabled(false);
            corr++;
            correct();
        }
        else
        {
            jButton23.setEnabled(false);
            score = score - 10;
            lives = lives - 1;
            lifeCheck(lives);
            System.out.println("Wrong, please try again" + lives + " more lives left.");
            if( lives == 0)
            {
                skipButtonActionPerformed(evt);
            }
        }

        //PPPPPPPPPPPPPPPPPPPPPP

    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed

        jButton22.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }

        //VVVVVVVVVVVVVVVVVV

    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if (word.equals("nurse"))
        {
            jLabel11.setText("u");
            jButton21.setEnabled(false);
            corr++;
            correct();
        }
        else
        {
            jButton21.setEnabled(false);
            score = score - 10;
            lives = lives - 1;
            lifeCheck(lives);
            System.out.println("Wrong, please try again" + lives + " more lives left.");
            if( lives == 0)
            {
                skipButtonActionPerformed(evt);
            }
        }

        //UUUUUUUUUUUUUUUUUUUUUUUU

    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        switch (word) {
            case "abstract" -> {
                jLabel17.setText("t");
                jLabel13.setText("t");
                jButton20.setEnabled(false);
                corr++;
                correct();
                corr++;
                correct();

            }
            case "cemetery" -> {
                jLabel14.setText("t");
                jButton20.setEnabled(false);
                corr++;
                correct();
            }
            default -> {
                jButton20.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0)
                {
                    skipButtonActionPerformed(evt);
                }
            }
            //TTTTTTTTTTTTTTTTTTTTT
        }

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        switch (word) {
            case "abstract" -> {
                jLabel12.setText("s");
                jButton19.setEnabled(false);
                corr++;
                correct();
            }
            case "nurse" -> {
                jLabel13.setText("s");
                jButton19.setEnabled(false);
                corr++;
                correct();
            }
            default -> {
                jButton19.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0)
                {
                    skipButtonActionPerformed(evt);
                }
            }
            //SSSSSSSSSSSSSSSSSSS
        }

    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        switch (word) {
            case "nurse" -> {
                jLabel12.setText("r");
                jButton18.setEnabled(false);
                corr++;
                correct();
            }
            case "cemetery" -> {
                jLabel16.setText("r");
                jButton18.setEnabled(false);
                corr++;
                correct();
            }
            case "abstract" -> {
                jLabel14.setText("r");
                jButton18.setEnabled(false);
                corr++;
                correct();
            }
            case "pharmacy" -> {
                jLabel13.setText("r");
                jButton18.setEnabled(false);
                corr++;
                correct();
            }
            default -> {
                jButton18.setEnabled(false);
                score = score - 10;
                lives = lives - 1;
                lifeCheck(lives);
                System.out.println("Wrong, please try again" + lives + " more lives left.");
                if( lives == 0)
                {
                    skipButtonActionPerformed(evt);
                }
            }
            //RRRRRRRRRRRRRRRRRRRRRRRRR
        }

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        //QQQQQQQQQQQQQQQQQ
        jButton17.setEnabled(false);
        score = score - 10;
        lives = lives - 1;
        lifeCheck(lives);
        System.out.println("Wrong, please try again" + lives + " more lives left.");
        if( lives == 0)
        {
            skipButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton17ActionPerformed
    
    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a JLabel
            now = LocalDateTime.now();
            jLabel18.setText(dtf.format(now)); 
        }
    };
    
    private int lives;
    private static int score;
    private int corr;
    private int randomVessel;
    private String word;
    private final String [] LIST = {"abstract","cemetery","nurse","pharmacy","climbing"};
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton skipButton;
    // End of variables declaration//GEN-END:variables
}
