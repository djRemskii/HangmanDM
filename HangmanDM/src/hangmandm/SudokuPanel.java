/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

/**
 *
 * @author djRemskii
 * I'm doing this all in one night cause i cant sleep.
 */
public class SudokuPanel extends javax.swing.JPanel {

    private static final int[][] solutionBoard = new int[9][9];
    private static int[][] currentBoard = new int[9][9];
    private static int[] focusedBox = new int[2];
    private static JTextField[][] boxes = new JTextField[9][9]; 
    private static int score;
    
    
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
        
        currentBoard[0] = new int[]{ 8,0,0,4,0,6,0,0,7 };
        currentBoard[1] = new int[]{ 0,0,0,0,0,0,4,0,0 };
        currentBoard[2] = new int[]{ 0,1,0,0,0,0,6,5,0 };
        currentBoard[3] = new int[]{ 5,0,9,0,3,0,7,8,0 };
        currentBoard[4] = new int[]{ 0,0,0,0,7,0,0,0,0 };
        currentBoard[5] = new int[]{ 0,4,8,0,2,0,1,0,3 };
        currentBoard[6] = new int[]{ 0,5,2,0,0,0,0,9,0 };
        currentBoard[7] = new int[]{ 0,0,1,0,0,0,0,0,0 };
        currentBoard[8] = new int[]{ 3,0,0,9,0,2,0,0,5 };
        
        focusedBox[0] = 100;
        focusedBox[1] = 100;
        
        score = 540;
        
        initComponents();
        
        num1.setToolTipText("Choose 1");
        num2.setToolTipText("Choose 2"); 
        num3.setToolTipText("Choose 3");
        num4.setToolTipText("Choose 4"); 
        num5.setToolTipText("Choose 5"); 
        num6.setToolTipText("Choose 6"); 
        num7.setToolTipText("Choose 7"); 
        num8.setToolTipText("Choose 8"); 
        num9.setToolTipText("Choose 9"); 
        scoreCheckButton.setToolTipText("Check Score");
       
        boxTT();
        
        
        
        
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
       
        jLabel2.setOpaque(false);
        jLabel2.setBounds(0, 0, 1, 1);
        
        
        jLabel2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "goToCredits");
        jLabel2.getActionMap().put("goToCredits", credits);
        
        jLabel2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        jLabel2.getActionMap().put("escape", esc);
        
        boxAssigner();
        
    }
    
    private void boxTT()
    {
        //first row
        box0_0.setToolTipText("Can't enter here");
        box0_1.setToolTipText("Enter here");
        box0_2.setToolTipText("Enter here");
        box0_3.setToolTipText("Can't enter here");
        box0_4.setToolTipText("Enter here");
        box0_5.setToolTipText("Can't enter here");
        box0_6.setToolTipText("Enter here");
        box0_7.setToolTipText("Enter here");
        box0_8.setToolTipText("Can't enter here");
      
        box1_0.setToolTipText("Enter here");
        box1_1.setToolTipText("Enter here");
        box1_2.setToolTipText("Enter here");
        box1_3.setToolTipText("Enter here");
        box1_4.setToolTipText("Enter here");
        box1_5.setToolTipText("Enter here");
        box1_6.setToolTipText("Can't enter here");
        box1_7.setToolTipText("Enter here");
        box1_8.setToolTipText("Enter here");
       
        box2_0.setToolTipText("Enter here");
        box2_1.setToolTipText("Can't enter here");
        box2_2.setToolTipText("Enter here");
        box2_3.setToolTipText("Enter here");
        box2_4.setToolTipText("Enter here");
        box2_5.setToolTipText("Enter here");
        box2_6.setToolTipText("Can't enter here");
        box2_7.setToolTipText("Can't enter here");
        box2_8.setToolTipText("Enter here");
        
        //Second row
        box3_0.setToolTipText("Can't enter here");
        box3_1.setToolTipText("Enter here");
        box3_2.setToolTipText("Can't enter here");
        box3_3.setToolTipText("Enter here");
        box3_4.setToolTipText("Can't enter here");
        box3_5.setToolTipText("Enter here");
        box3_6.setToolTipText("Can't enter here");
        box3_7.setToolTipText("Can't enter here");
        box3_8.setToolTipText("Enter here");
      
        box4_0.setToolTipText("Enter here");
        box4_1.setToolTipText("Enter here");
        box4_2.setToolTipText("Enter here");
        box4_3.setToolTipText("Enter here");
        box4_4.setToolTipText("Can't enter here");
        box4_5.setToolTipText("Enter here");
        box4_6.setToolTipText("Enter here");
        box4_7.setToolTipText("Enter here");
        box4_8.setToolTipText("Enter here");
       
        box5_0.setToolTipText("Enter here");
        box5_1.setToolTipText("Can't enter here");
        box5_2.setToolTipText("Can't enter here");
        box5_3.setToolTipText("Enter here");
        box5_4.setToolTipText("Can't enter here");
        box5_5.setToolTipText("Enter here");
        box5_6.setToolTipText("Can't enter here");
        box5_7.setToolTipText("Enter here");
        box5_8.setToolTipText("Can't enter here");
        
        //third row
        box6_0.setToolTipText("Enter here");
        box6_1.setToolTipText("Can't enter here");
        box6_2.setToolTipText("Can't enter here");
        box6_3.setToolTipText("Enter here");
        box6_4.setToolTipText("Enter here");
        box6_5.setToolTipText("Enter here");
        box6_6.setToolTipText("Enter here");
        box6_7.setToolTipText("Can't enter here");
        box6_8.setToolTipText("Enter here");
      
        box7_0.setToolTipText("Enter here");
        box7_1.setToolTipText("Enter here");
        box7_2.setToolTipText("Can't enter here");
        box7_3.setToolTipText("Enter here");
        box7_4.setToolTipText("Enter here");
        box7_5.setToolTipText("Enter here");
        box7_6.setToolTipText("Enter here");
        box7_7.setToolTipText("Enter here");
        box7_8.setToolTipText("Enter here");
       
        box8_0.setToolTipText("Can't enter here");
        box8_1.setToolTipText("Enter here");
        box8_2.setToolTipText("Enter here");
        box8_3.setToolTipText("Can't enter here");
        box8_4.setToolTipText("Enter here");
        box8_5.setToolTipText("Can't enter here");
        box8_6.setToolTipText("Enter here");
        box8_7.setToolTipText("Enter here");
        box8_8.setToolTipText("Can't enter here");
    }
    
    private static void reset(){
        currentBoard[0] = new int[]{ 8,0,0,4,0,6,0,0,7 };
        currentBoard[1] = new int[]{ 0,0,0,0,0,0,4,0,0 };
        currentBoard[2] = new int[]{ 0,1,0,0,0,0,6,5,0 };
        currentBoard[3] = new int[]{ 5,0,9,0,3,0,7,8,0 };
        currentBoard[4] = new int[]{ 0,0,0,0,7,0,0,0,0 };
        currentBoard[5] = new int[]{ 0,4,8,0,2,0,1,0,3 };
        currentBoard[6] = new int[]{ 0,5,2,0,0,0,0,9,0 };
        currentBoard[7] = new int[]{ 0,0,1,0,0,0,0,0,0 };
        currentBoard[8] = new int[]{ 3,0,0,9,0,2,0,0,5 };
        box0_1.setText("");
        box0_2.setText("");
        box0_4.setText("");
        box0_6.setText("");
        box0_7.setText("");
        box1_0.setText("");
        box1_1.setText("");
        box1_2.setText("");
        box1_4.setText("");
        box1_5.setText("");
        box1_7.setText("");
        box1_8.setText("");
        box2_0.setText("");
        box2_2.setText("");
        box2_3.setText("");
        box2_4.setText("");
        box2_5.setText("");
        box2_8.setText("");
        box3_1.setText("");
        box3_3.setText("");
        box3_5.setText("");
        box3_8.setText("");
        box4_0.setText("");
        box4_1.setText("");
        box4_2.setText("");
        box4_3.setText("");
        box4_5.setText("");
        box4_6.setText("");
        box4_7.setText("");
        box4_8.setText("");
        box5_0.setText("");
        box5_3.setText("");
        box5_5.setText("");
        box6_0.setText("");
        box6_3.setText("");
        box6_4.setText("");
        box6_5.setText("");
        box6_6.setText("");
        box6_8.setText("");
        box7_2.setText("");
        box7_0.setText("");
        box7_1.setText("");
        box7_3.setText("");
        box7_4.setText("");
        box7_5.setText("");
        box7_6.setText("");
        box7_7.setText("");
        box7_8.setText("");
        box8_1.setText("");
        box8_2.setText("");
        box8_4.setText("");
        box8_6.setText("");
        box8_7.setText("");
        score = 540;
        scoreDisplay.setText("Score: " + score);
    }
    
    private static void boxAssigner(){
        boxes[0][0] = box0_0;
        boxes[0][1] = box0_1;
        boxes[0][2] = box0_2;
        boxes[0][3] = box0_3;
        boxes[0][4] = box0_4;
        boxes[0][5] = box0_5;
        boxes[0][6] = box0_6;
        boxes[0][7] = box0_7;
        boxes[0][8] = box0_8;
        
        boxes[1][0] = box1_0;
        boxes[1][1] = box1_1;
        boxes[1][2] = box1_2;
        boxes[1][3] = box1_3;
        boxes[1][4] = box1_4;
        boxes[1][5] = box1_5;
        boxes[1][6] = box1_6;
        boxes[1][7] = box1_7;
        boxes[1][8] = box1_8;
        
        boxes[2][0] = box2_0;
        boxes[2][1] = box2_1;
        boxes[2][2] = box2_2;
        boxes[2][3] = box2_3;
        boxes[2][4] = box2_4;
        boxes[2][5] = box2_5;
        boxes[2][6] = box2_6;
        boxes[2][7] = box2_7;
        boxes[2][8] = box2_8;
        
        boxes[3][0] = box3_0;
        boxes[3][1] = box3_1;
        boxes[3][2] = box3_2;
        boxes[3][3] = box3_3;
        boxes[3][4] = box3_4;
        boxes[3][5] = box3_5;
        boxes[3][6] = box3_6;
        boxes[3][7] = box3_7;
        boxes[3][8] = box3_8;
        
        boxes[4][0] = box4_0;
        boxes[4][1] = box4_1;
        boxes[4][2] = box4_2;
        boxes[4][3] = box4_3;
        boxes[4][4] = box4_4;
        boxes[4][5] = box4_5;
        boxes[4][6] = box4_6;
        boxes[4][7] = box4_7;
        boxes[4][8] = box4_8;
        
        boxes[5][0] = box5_0;
        boxes[5][1] = box5_1;
        boxes[5][2] = box5_2;
        boxes[5][3] = box5_3;
        boxes[5][4] = box5_4;
        boxes[5][5] = box5_5;
        boxes[5][6] = box5_6;
        boxes[5][7] = box5_7;
        boxes[5][8] = box5_8;
        
        boxes[6][0] = box6_0;
        boxes[6][1] = box6_1;
        boxes[6][2] = box6_2;
        boxes[6][3] = box6_3;
        boxes[6][4] = box6_4;
        boxes[6][5] = box6_5;
        boxes[6][6] = box6_6;
        boxes[6][7] = box6_7;
        boxes[6][8] = box6_8;
        
        boxes[7][0] = box7_0;
        boxes[7][1] = box7_1;
        boxes[7][2] = box7_2;
        boxes[7][3] = box7_3;
        boxes[7][4] = box7_4;
        boxes[7][5] = box7_5;
        boxes[7][6] = box7_6;
        boxes[7][7] = box7_7;
        boxes[7][8] = box7_8;
        
        boxes[8][0] = box8_0;
        boxes[8][1] = box8_1;
        boxes[8][2] = box8_2;
        boxes[8][3] = box8_3;
        boxes[8][4] = box8_4;
        boxes[8][5] = box8_5;
        boxes[8][6] = box8_6;
        boxes[8][7] = box8_7;
        boxes[8][8] = box8_8;
    }
    
    private static void checkScore(){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    if(solutionBoard[i][j] != currentBoard[i][j]){
                        score -= 10;
                }
            }
        }
        System.out.println(score);
        scoreDisplay.setText("Score: " + score);
        try {
            HighScorePanel.scoreCheck(getScoreSudoku());
        } 
        catch (IOException ex) {
            Logger.getLogger(SudokuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            HighScorePanel.savedData();
        } 
        catch (IOException ex) {
            Logger.getLogger(SudokuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        HangmanDM.frame.add(new end(getScoreSudoku()),"endPanel");
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "endPanel");
        
        reset();
        
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
        box0_1 = new javax.swing.JTextField();
        box0_2 = new javax.swing.JTextField();
        box0_3 = new javax.swing.JTextField();
        box0_4 = new javax.swing.JTextField();
        box0_5 = new javax.swing.JTextField();
        box0_6 = new javax.swing.JTextField();
        box0_7 = new javax.swing.JTextField();
        box0_8 = new javax.swing.JTextField();
        box1_0 = new javax.swing.JTextField();
        box1_1 = new javax.swing.JTextField();
        box1_2 = new javax.swing.JTextField();
        box1_3 = new javax.swing.JTextField();
        box1_4 = new javax.swing.JTextField();
        box1_5 = new javax.swing.JTextField();
        box1_6 = new javax.swing.JTextField();
        box1_7 = new javax.swing.JTextField();
        box1_8 = new javax.swing.JTextField();
        box2_0 = new javax.swing.JTextField();
        box2_1 = new javax.swing.JTextField();
        box2_2 = new javax.swing.JTextField();
        box2_3 = new javax.swing.JTextField();
        box2_4 = new javax.swing.JTextField();
        box2_5 = new javax.swing.JTextField();
        box2_6 = new javax.swing.JTextField();
        box2_7 = new javax.swing.JTextField();
        box2_8 = new javax.swing.JTextField();
        box3_0 = new javax.swing.JTextField();
        box3_1 = new javax.swing.JTextField();
        box3_2 = new javax.swing.JTextField();
        box3_3 = new javax.swing.JTextField();
        box3_4 = new javax.swing.JTextField();
        box3_5 = new javax.swing.JTextField();
        box3_6 = new javax.swing.JTextField();
        box3_7 = new javax.swing.JTextField();
        box3_8 = new javax.swing.JTextField();
        box4_0 = new javax.swing.JTextField();
        box4_1 = new javax.swing.JTextField();
        box4_2 = new javax.swing.JTextField();
        box4_3 = new javax.swing.JTextField();
        box4_4 = new javax.swing.JTextField();
        box4_5 = new javax.swing.JTextField();
        box4_6 = new javax.swing.JTextField();
        box4_7 = new javax.swing.JTextField();
        box4_8 = new javax.swing.JTextField();
        box5_0 = new javax.swing.JTextField();
        box5_1 = new javax.swing.JTextField();
        box5_2 = new javax.swing.JTextField();
        box5_3 = new javax.swing.JTextField();
        box5_4 = new javax.swing.JTextField();
        box5_5 = new javax.swing.JTextField();
        box5_6 = new javax.swing.JTextField();
        box5_7 = new javax.swing.JTextField();
        box5_8 = new javax.swing.JTextField();
        box6_0 = new javax.swing.JTextField();
        box6_1 = new javax.swing.JTextField();
        box6_2 = new javax.swing.JTextField();
        box6_3 = new javax.swing.JTextField();
        box6_4 = new javax.swing.JTextField();
        box6_5 = new javax.swing.JTextField();
        box6_6 = new javax.swing.JTextField();
        box6_7 = new javax.swing.JTextField();
        box6_8 = new javax.swing.JTextField();
        box7_0 = new javax.swing.JTextField();
        box7_1 = new javax.swing.JTextField();
        box7_2 = new javax.swing.JTextField();
        box7_3 = new javax.swing.JTextField();
        box7_4 = new javax.swing.JTextField();
        box7_5 = new javax.swing.JTextField();
        box7_6 = new javax.swing.JTextField();
        box7_7 = new javax.swing.JTextField();
        box7_8 = new javax.swing.JTextField();
        box8_0 = new javax.swing.JTextField();
        box8_1 = new javax.swing.JTextField();
        box8_2 = new javax.swing.JTextField();
        box8_3 = new javax.swing.JTextField();
        box8_4 = new javax.swing.JTextField();
        box8_5 = new javax.swing.JTextField();
        box8_6 = new javax.swing.JTextField();
        box8_7 = new javax.swing.JTextField();
        box8_8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        scoreCheckButton = new javax.swing.JButton();
        scoreDisplay = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 51, 51));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        num1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num1.setForeground(new java.awt.Color(255, 51, 51));
        num1.setText("1");
        num1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num1ActionPerformed(evt);
            }
        });
        add(num1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 166, -1, -1));

        num2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num2.setForeground(new java.awt.Color(255, 51, 51));
        num2.setText("2");
        num2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num2ActionPerformed(evt);
            }
        });
        add(num2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 166, -1, -1));

        num3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num3.setForeground(new java.awt.Color(255, 51, 51));
        num3.setText("3");
        num3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num3ActionPerformed(evt);
            }
        });
        add(num3, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 166, -1, -1));

        num4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num4.setForeground(new java.awt.Color(255, 51, 51));
        num4.setText("4");
        num4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num4ActionPerformed(evt);
            }
        });
        add(num4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 194, -1, -1));

        num5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num5.setForeground(new java.awt.Color(255, 51, 51));
        num5.setText("5");
        num5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num5ActionPerformed(evt);
            }
        });
        add(num5, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 194, -1, -1));

        num6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num6.setForeground(new java.awt.Color(255, 51, 51));
        num6.setText("6");
        num6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num6ActionPerformed(evt);
            }
        });
        add(num6, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 194, -1, -1));

        num7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num7.setForeground(new java.awt.Color(255, 51, 51));
        num7.setText("7");
        num7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num7ActionPerformed(evt);
            }
        });
        add(num7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 222, -1, -1));

        num8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num8.setForeground(new java.awt.Color(255, 51, 51));
        num8.setText("8");
        num8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num8ActionPerformed(evt);
            }
        });
        add(num8, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 222, -1, -1));

        num9.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        num9.setForeground(new java.awt.Color(255, 51, 51));
        num9.setText("9");
        num9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num9ActionPerformed(evt);
            }
        });
        add(num9, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 222, -1, -1));

        box0_0.setEditable(false);
        box0_0.setBackground(new java.awt.Color(255, 255, 255));
        box0_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_0.setText("8");
        box0_0.setActionCommand("<Not Set>");
        box0_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_0.setFocusable(false);
        box0_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_0FocusLost(evt);
            }
        });
        add(box0_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 111, -1, -1));

        box0_1.setEditable(false);
        box0_1.setBackground(new java.awt.Color(255, 255, 255));
        box0_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_1.setForeground(new java.awt.Color(255, 51, 51));
        box0_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_1.setActionCommand("<Not Set>");
        box0_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_1FocusLost(evt);
            }
        });
        box0_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box0_1ActionPerformed(evt);
            }
        });
        add(box0_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 111, -1, -1));

        box0_2.setEditable(false);
        box0_2.setBackground(new java.awt.Color(255, 255, 255));
        box0_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_2.setForeground(new java.awt.Color(255, 51, 51));
        box0_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_2.setActionCommand("<Not Set>");
        box0_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_2FocusLost(evt);
            }
        });
        box0_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box0_2ActionPerformed(evt);
            }
        });
        add(box0_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 111, -1, -1));

        box0_3.setEditable(false);
        box0_3.setBackground(new java.awt.Color(255, 255, 255));
        box0_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_3.setText("4");
        box0_3.setActionCommand("<Not Set>");
        box0_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_3.setFocusable(false);
        box0_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_3FocusLost(evt);
            }
        });
        box0_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box0_3ActionPerformed(evt);
            }
        });
        add(box0_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 111, -1, -1));

        box0_4.setEditable(false);
        box0_4.setBackground(new java.awt.Color(255, 255, 255));
        box0_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_4.setForeground(new java.awt.Color(255, 51, 51));
        box0_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_4.setActionCommand("<Not Set>");
        box0_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_4FocusLost(evt);
            }
        });
        add(box0_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 111, -1, -1));

        box0_5.setEditable(false);
        box0_5.setBackground(new java.awt.Color(255, 255, 255));
        box0_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_5.setText("6");
        box0_5.setActionCommand("<Not Set>");
        box0_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_5.setFocusable(false);
        box0_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_5FocusLost(evt);
            }
        });
        box0_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box0_5ActionPerformed(evt);
            }
        });
        add(box0_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 111, -1, -1));

        box0_6.setEditable(false);
        box0_6.setBackground(new java.awt.Color(255, 255, 255));
        box0_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_6.setForeground(new java.awt.Color(255, 51, 51));
        box0_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_6.setActionCommand("<Not Set>");
        box0_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_6FocusLost(evt);
            }
        });
        add(box0_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 111, -1, -1));

        box0_7.setEditable(false);
        box0_7.setBackground(new java.awt.Color(255, 255, 255));
        box0_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_7.setForeground(new java.awt.Color(255, 51, 51));
        box0_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_7.setActionCommand("<Not Set>");
        box0_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_7FocusLost(evt);
            }
        });
        add(box0_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 111, -1, -1));

        box0_8.setEditable(false);
        box0_8.setBackground(new java.awt.Color(255, 255, 255));
        box0_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box0_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box0_8.setText("7");
        box0_8.setActionCommand("<Not Set>");
        box0_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box0_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box0_8.setFocusable(false);
        box0_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box0_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box0_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box0_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box0_8FocusLost(evt);
            }
        });
        box0_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box0_8ActionPerformed(evt);
            }
        });
        add(box0_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 111, -1, -1));

        box1_0.setEditable(false);
        box1_0.setBackground(new java.awt.Color(255, 255, 255));
        box1_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_0.setForeground(new java.awt.Color(255, 51, 51));
        box1_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_0.setActionCommand("<Not Set>");
        box1_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_0FocusLost(evt);
            }
        });
        add(box1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 136, -1, -1));

        box1_1.setEditable(false);
        box1_1.setBackground(new java.awt.Color(255, 255, 255));
        box1_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_1.setForeground(new java.awt.Color(255, 51, 51));
        box1_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_1.setActionCommand("<Not Set>");
        box1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_1FocusLost(evt);
            }
        });
        box1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1_1ActionPerformed(evt);
            }
        });
        add(box1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 136, -1, -1));

        box1_2.setEditable(false);
        box1_2.setBackground(new java.awt.Color(255, 255, 255));
        box1_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_2.setForeground(new java.awt.Color(255, 51, 51));
        box1_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_2.setActionCommand("<Not Set>");
        box1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_2FocusLost(evt);
            }
        });
        box1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1_2ActionPerformed(evt);
            }
        });
        add(box1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 136, -1, -1));

        box1_3.setEditable(false);
        box1_3.setBackground(new java.awt.Color(255, 255, 255));
        box1_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_3.setForeground(new java.awt.Color(255, 51, 51));
        box1_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_3.setActionCommand("<Not Set>");
        box1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_3FocusLost(evt);
            }
        });
        add(box1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 136, -1, -1));

        box1_4.setEditable(false);
        box1_4.setBackground(new java.awt.Color(255, 255, 255));
        box1_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_4.setForeground(new java.awt.Color(255, 51, 51));
        box1_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_4.setActionCommand("<Not Set>");
        box1_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_4FocusLost(evt);
            }
        });
        add(box1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 136, -1, -1));

        box1_5.setEditable(false);
        box1_5.setBackground(new java.awt.Color(255, 255, 255));
        box1_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_5.setForeground(new java.awt.Color(255, 51, 51));
        box1_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_5.setActionCommand("<Not Set>");
        box1_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_5FocusLost(evt);
            }
        });
        add(box1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 136, -1, -1));

        box1_6.setEditable(false);
        box1_6.setBackground(new java.awt.Color(255, 255, 255));
        box1_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_6.setText("4");
        box1_6.setActionCommand("<Not Set>");
        box1_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_6.setFocusable(false);
        box1_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_6FocusLost(evt);
            }
        });
        add(box1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 136, -1, -1));

        box1_7.setEditable(false);
        box1_7.setBackground(new java.awt.Color(255, 255, 255));
        box1_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_7.setForeground(new java.awt.Color(255, 51, 51));
        box1_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_7.setActionCommand("<Not Set>");
        box1_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_7FocusLost(evt);
            }
        });
        add(box1_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 136, -1, -1));

        box1_8.setEditable(false);
        box1_8.setBackground(new java.awt.Color(255, 255, 255));
        box1_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box1_8.setForeground(new java.awt.Color(255, 51, 51));
        box1_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box1_8.setActionCommand("<Not Set>");
        box1_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box1_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box1_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box1_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box1_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box1_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box1_8FocusLost(evt);
            }
        });
        add(box1_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 136, -1, -1));

        box2_0.setEditable(false);
        box2_0.setBackground(new java.awt.Color(255, 255, 255));
        box2_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_0.setForeground(new java.awt.Color(255, 51, 51));
        box2_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_0.setActionCommand("<Not Set>");
        box2_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_0FocusLost(evt);
            }
        });
        add(box2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 161, -1, -1));

        box2_1.setEditable(false);
        box2_1.setBackground(new java.awt.Color(255, 255, 255));
        box2_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_1.setText("1");
        box2_1.setActionCommand("<Not Set>");
        box2_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_1.setFocusable(false);
        box2_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_1FocusLost(evt);
            }
        });
        add(box2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 161, -1, -1));

        box2_2.setEditable(false);
        box2_2.setBackground(new java.awt.Color(255, 255, 255));
        box2_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_2.setForeground(new java.awt.Color(255, 51, 51));
        box2_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_2.setActionCommand("<Not Set>");
        box2_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_2FocusLost(evt);
            }
        });
        add(box2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 161, -1, -1));

        box2_3.setEditable(false);
        box2_3.setBackground(new java.awt.Color(255, 255, 255));
        box2_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_3.setForeground(new java.awt.Color(255, 51, 51));
        box2_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_3.setActionCommand("<Not Set>");
        box2_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_3FocusLost(evt);
            }
        });
        add(box2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 161, -1, -1));

        box2_4.setEditable(false);
        box2_4.setBackground(new java.awt.Color(255, 255, 255));
        box2_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_4.setForeground(new java.awt.Color(255, 51, 51));
        box2_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_4.setActionCommand("<Not Set>");
        box2_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_4FocusLost(evt);
            }
        });
        add(box2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 161, -1, -1));

        box2_5.setEditable(false);
        box2_5.setBackground(new java.awt.Color(255, 255, 255));
        box2_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_5.setForeground(new java.awt.Color(255, 51, 51));
        box2_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_5.setActionCommand("<Not Set>");
        box2_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_5FocusLost(evt);
            }
        });
        add(box2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 161, -1, -1));

        box2_6.setEditable(false);
        box2_6.setBackground(new java.awt.Color(255, 255, 255));
        box2_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_6.setText("6");
        box2_6.setActionCommand("<Not Set>");
        box2_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_6.setFocusable(false);
        box2_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_6FocusLost(evt);
            }
        });
        add(box2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 161, -1, -1));

        box2_7.setEditable(false);
        box2_7.setBackground(new java.awt.Color(255, 255, 255));
        box2_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_7.setText("5");
        box2_7.setActionCommand("<Not Set>");
        box2_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_7.setFocusable(false);
        box2_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_7FocusLost(evt);
            }
        });
        add(box2_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 161, -1, -1));

        box2_8.setEditable(false);
        box2_8.setBackground(new java.awt.Color(255, 255, 255));
        box2_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box2_8.setForeground(new java.awt.Color(255, 51, 51));
        box2_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box2_8.setActionCommand("<Not Set>");
        box2_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box2_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box2_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box2_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box2_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box2_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box2_8FocusLost(evt);
            }
        });
        add(box2_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 161, -1, -1));

        box3_0.setEditable(false);
        box3_0.setBackground(new java.awt.Color(255, 255, 255));
        box3_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_0.setText("5");
        box3_0.setActionCommand("<Not Set>");
        box3_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_0.setFocusable(false);
        box3_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_0FocusLost(evt);
            }
        });
        add(box3_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 193, -1, -1));

        box3_1.setEditable(false);
        box3_1.setBackground(new java.awt.Color(255, 255, 255));
        box3_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_1.setForeground(new java.awt.Color(255, 51, 51));
        box3_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_1.setActionCommand("<Not Set>");
        box3_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_1FocusLost(evt);
            }
        });
        add(box3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 193, -1, -1));

        box3_2.setEditable(false);
        box3_2.setBackground(new java.awt.Color(255, 255, 255));
        box3_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_2.setText("9");
        box3_2.setActionCommand("<Not Set>");
        box3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_2.setFocusable(false);
        box3_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_2FocusLost(evt);
            }
        });
        add(box3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 193, -1, -1));

        box3_3.setEditable(false);
        box3_3.setBackground(new java.awt.Color(255, 255, 255));
        box3_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_3.setForeground(new java.awt.Color(255, 51, 51));
        box3_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_3.setActionCommand("<Not Set>");
        box3_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_3FocusLost(evt);
            }
        });
        add(box3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 193, -1, -1));

        box3_4.setEditable(false);
        box3_4.setBackground(new java.awt.Color(255, 255, 255));
        box3_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_4.setText("3");
        box3_4.setActionCommand("<Not Set>");
        box3_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_4.setFocusable(false);
        box3_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_4FocusLost(evt);
            }
        });
        add(box3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 193, -1, -1));

        box3_5.setEditable(false);
        box3_5.setBackground(new java.awt.Color(255, 255, 255));
        box3_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_5.setForeground(new java.awt.Color(255, 51, 51));
        box3_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_5.setActionCommand("<Not Set>");
        box3_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_5FocusLost(evt);
            }
        });
        add(box3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 193, -1, -1));

        box3_6.setEditable(false);
        box3_6.setBackground(new java.awt.Color(255, 255, 255));
        box3_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_6.setText("7");
        box3_6.setActionCommand("<Not Set>");
        box3_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_6.setFocusable(false);
        box3_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_6FocusLost(evt);
            }
        });
        add(box3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 193, -1, -1));

        box3_7.setEditable(false);
        box3_7.setBackground(new java.awt.Color(255, 255, 255));
        box3_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_7.setText("8");
        box3_7.setActionCommand("<Not Set>");
        box3_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_7.setFocusable(false);
        box3_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_7FocusLost(evt);
            }
        });
        add(box3_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 193, -1, -1));

        box3_8.setEditable(false);
        box3_8.setBackground(new java.awt.Color(255, 255, 255));
        box3_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box3_8.setForeground(new java.awt.Color(255, 51, 51));
        box3_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box3_8.setActionCommand("<Not Set>");
        box3_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box3_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box3_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box3_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box3_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box3_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box3_8FocusLost(evt);
            }
        });
        add(box3_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 193, -1, -1));

        box4_0.setEditable(false);
        box4_0.setBackground(new java.awt.Color(255, 255, 255));
        box4_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_0.setForeground(new java.awt.Color(255, 51, 51));
        box4_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_0.setActionCommand("<Not Set>");
        box4_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_0FocusLost(evt);
            }
        });
        add(box4_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 218, -1, -1));

        box4_1.setEditable(false);
        box4_1.setBackground(new java.awt.Color(255, 255, 255));
        box4_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_1.setForeground(new java.awt.Color(255, 51, 51));
        box4_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_1.setActionCommand("<Not Set>");
        box4_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_1FocusLost(evt);
            }
        });
        add(box4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 218, -1, -1));

        box4_2.setEditable(false);
        box4_2.setBackground(new java.awt.Color(255, 255, 255));
        box4_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_2.setForeground(new java.awt.Color(255, 51, 51));
        box4_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_2.setActionCommand("<Not Set>");
        box4_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_2FocusLost(evt);
            }
        });
        add(box4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 218, -1, -1));

        box4_3.setEditable(false);
        box4_3.setBackground(new java.awt.Color(255, 255, 255));
        box4_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_3.setForeground(new java.awt.Color(255, 51, 51));
        box4_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_3.setActionCommand("<Not Set>");
        box4_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_3FocusLost(evt);
            }
        });
        add(box4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 218, -1, -1));

        box4_4.setEditable(false);
        box4_4.setBackground(new java.awt.Color(255, 255, 255));
        box4_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_4.setText("7");
        box4_4.setActionCommand("<Not Set>");
        box4_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_4.setFocusable(false);
        box4_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_4FocusLost(evt);
            }
        });
        add(box4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 218, -1, -1));

        box4_5.setEditable(false);
        box4_5.setBackground(new java.awt.Color(255, 255, 255));
        box4_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_5.setForeground(new java.awt.Color(255, 51, 51));
        box4_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_5.setActionCommand("<Not Set>");
        box4_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_5FocusLost(evt);
            }
        });
        add(box4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 218, -1, -1));

        box4_6.setEditable(false);
        box4_6.setBackground(new java.awt.Color(255, 255, 255));
        box4_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_6.setForeground(new java.awt.Color(255, 51, 51));
        box4_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_6.setActionCommand("<Not Set>");
        box4_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_6FocusLost(evt);
            }
        });
        add(box4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 218, -1, -1));

        box4_7.setEditable(false);
        box4_7.setBackground(new java.awt.Color(255, 255, 255));
        box4_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_7.setForeground(new java.awt.Color(255, 51, 51));
        box4_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_7.setActionCommand("<Not Set>");
        box4_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_7FocusLost(evt);
            }
        });
        box4_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box4_7ActionPerformed(evt);
            }
        });
        add(box4_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 218, -1, -1));

        box4_8.setEditable(false);
        box4_8.setBackground(new java.awt.Color(255, 255, 255));
        box4_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box4_8.setForeground(new java.awt.Color(255, 51, 51));
        box4_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box4_8.setActionCommand("<Not Set>");
        box4_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box4_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box4_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box4_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box4_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box4_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box4_8FocusLost(evt);
            }
        });
        add(box4_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 218, -1, -1));

        box5_0.setEditable(false);
        box5_0.setBackground(new java.awt.Color(255, 255, 255));
        box5_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_0.setForeground(new java.awt.Color(255, 51, 51));
        box5_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_0.setActionCommand("<Not Set>");
        box5_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_0FocusLost(evt);
            }
        });
        add(box5_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 243, -1, -1));

        box5_1.setEditable(false);
        box5_1.setBackground(new java.awt.Color(255, 255, 255));
        box5_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_1.setText("4");
        box5_1.setActionCommand("<Not Set>");
        box5_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_1.setFocusable(false);
        box5_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_1FocusLost(evt);
            }
        });
        add(box5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 243, -1, -1));

        box5_2.setEditable(false);
        box5_2.setBackground(new java.awt.Color(255, 255, 255));
        box5_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_2.setText("8");
        box5_2.setActionCommand("<Not Set>");
        box5_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_2.setFocusable(false);
        box5_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_2FocusLost(evt);
            }
        });
        add(box5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 243, -1, -1));

        box5_3.setEditable(false);
        box5_3.setBackground(new java.awt.Color(255, 255, 255));
        box5_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_3.setForeground(new java.awt.Color(255, 51, 51));
        box5_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_3.setActionCommand("<Not Set>");
        box5_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_3FocusLost(evt);
            }
        });
        add(box5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 243, -1, -1));

        box5_4.setEditable(false);
        box5_4.setBackground(new java.awt.Color(255, 255, 255));
        box5_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_4.setText("2");
        box5_4.setActionCommand("<Not Set>");
        box5_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_4.setFocusable(false);
        box5_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_4FocusLost(evt);
            }
        });
        add(box5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 243, -1, -1));

        box5_5.setEditable(false);
        box5_5.setBackground(new java.awt.Color(255, 255, 255));
        box5_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_5.setForeground(new java.awt.Color(255, 51, 51));
        box5_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_5.setActionCommand("<Not Set>");
        box5_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_5FocusLost(evt);
            }
        });
        add(box5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 243, -1, -1));

        box5_6.setEditable(false);
        box5_6.setBackground(new java.awt.Color(255, 255, 255));
        box5_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_6.setText("1");
        box5_6.setActionCommand("<Not Set>");
        box5_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_6.setFocusable(false);
        box5_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_6FocusLost(evt);
            }
        });
        add(box5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 243, -1, -1));

        box5_7.setEditable(false);
        box5_7.setBackground(new java.awt.Color(255, 255, 255));
        box5_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_7.setForeground(new java.awt.Color(255, 51, 51));
        box5_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_7.setActionCommand("<Not Set>");
        box5_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_7FocusLost(evt);
            }
        });
        add(box5_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 243, -1, -1));

        box5_8.setEditable(false);
        box5_8.setBackground(new java.awt.Color(255, 255, 255));
        box5_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box5_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box5_8.setText("3");
        box5_8.setActionCommand("<Not Set>");
        box5_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box5_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box5_8.setFocusable(false);
        box5_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box5_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box5_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box5_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box5_8FocusLost(evt);
            }
        });
        add(box5_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 243, -1, -1));

        box6_0.setEditable(false);
        box6_0.setBackground(new java.awt.Color(255, 255, 255));
        box6_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_0.setForeground(new java.awt.Color(255, 51, 51));
        box6_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_0.setActionCommand("<Not Set>");
        box6_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_0FocusLost(evt);
            }
        });
        add(box6_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 275, -1, -1));

        box6_1.setEditable(false);
        box6_1.setBackground(new java.awt.Color(255, 255, 255));
        box6_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_1.setText("5");
        box6_1.setActionCommand("<Not Set>");
        box6_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_1.setFocusable(false);
        box6_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_1FocusLost(evt);
            }
        });
        add(box6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 275, -1, -1));

        box6_2.setEditable(false);
        box6_2.setBackground(new java.awt.Color(255, 255, 255));
        box6_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_2.setText("2");
        box6_2.setActionCommand("<Not Set>");
        box6_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_2.setFocusable(false);
        box6_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_2FocusLost(evt);
            }
        });
        add(box6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 275, -1, -1));

        box6_3.setEditable(false);
        box6_3.setBackground(new java.awt.Color(255, 255, 255));
        box6_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_3.setForeground(new java.awt.Color(255, 51, 51));
        box6_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_3.setActionCommand("<Not Set>");
        box6_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_3FocusLost(evt);
            }
        });
        add(box6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 275, -1, -1));

        box6_4.setEditable(false);
        box6_4.setBackground(new java.awt.Color(255, 255, 255));
        box6_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_4.setForeground(new java.awt.Color(255, 51, 51));
        box6_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_4.setActionCommand("<Not Set>");
        box6_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_4FocusLost(evt);
            }
        });
        add(box6_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 275, -1, -1));

        box6_5.setEditable(false);
        box6_5.setBackground(new java.awt.Color(255, 255, 255));
        box6_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_5.setForeground(new java.awt.Color(255, 51, 51));
        box6_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_5.setActionCommand("<Not Set>");
        box6_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_5FocusLost(evt);
            }
        });
        add(box6_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 275, -1, -1));

        box6_6.setEditable(false);
        box6_6.setBackground(new java.awt.Color(255, 255, 255));
        box6_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_6.setForeground(new java.awt.Color(255, 51, 51));
        box6_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_6.setActionCommand("<Not Set>");
        box6_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_6FocusLost(evt);
            }
        });
        add(box6_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 275, -1, -1));

        box6_7.setEditable(false);
        box6_7.setBackground(new java.awt.Color(255, 255, 255));
        box6_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_7.setText("9");
        box6_7.setActionCommand("<Not Set>");
        box6_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_7.setFocusable(false);
        box6_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_7FocusLost(evt);
            }
        });
        add(box6_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 275, -1, -1));

        box6_8.setEditable(false);
        box6_8.setBackground(new java.awt.Color(255, 255, 255));
        box6_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box6_8.setForeground(new java.awt.Color(255, 51, 51));
        box6_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box6_8.setActionCommand("<Not Set>");
        box6_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box6_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box6_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box6_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box6_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box6_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box6_8FocusLost(evt);
            }
        });
        add(box6_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 275, -1, -1));

        box7_0.setEditable(false);
        box7_0.setBackground(new java.awt.Color(255, 255, 255));
        box7_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_0.setForeground(new java.awt.Color(255, 51, 51));
        box7_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_0.setActionCommand("<Not Set>");
        box7_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_0FocusLost(evt);
            }
        });
        add(box7_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 300, -1, -1));

        box7_1.setEditable(false);
        box7_1.setBackground(new java.awt.Color(255, 255, 255));
        box7_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_1.setForeground(new java.awt.Color(255, 51, 51));
        box7_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_1.setActionCommand("<Not Set>");
        box7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_1FocusLost(evt);
            }
        });
        add(box7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 300, -1, -1));

        box7_2.setEditable(false);
        box7_2.setBackground(new java.awt.Color(255, 255, 255));
        box7_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_2.setText("1");
        box7_2.setActionCommand("<Not Set>");
        box7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_2.setFocusable(false);
        box7_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_2FocusLost(evt);
            }
        });
        add(box7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 300, -1, -1));

        box7_3.setEditable(false);
        box7_3.setBackground(new java.awt.Color(255, 255, 255));
        box7_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_3.setForeground(new java.awt.Color(255, 51, 51));
        box7_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_3.setActionCommand("<Not Set>");
        box7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_3FocusLost(evt);
            }
        });
        add(box7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 300, -1, -1));

        box7_4.setEditable(false);
        box7_4.setBackground(new java.awt.Color(255, 255, 255));
        box7_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_4.setForeground(new java.awt.Color(255, 51, 51));
        box7_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_4.setActionCommand("<Not Set>");
        box7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_4FocusLost(evt);
            }
        });
        add(box7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 300, -1, -1));

        box7_5.setEditable(false);
        box7_5.setBackground(new java.awt.Color(255, 255, 255));
        box7_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_5.setForeground(new java.awt.Color(255, 51, 51));
        box7_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_5.setActionCommand("<Not Set>");
        box7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_5FocusLost(evt);
            }
        });
        add(box7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 300, -1, -1));

        box7_6.setEditable(false);
        box7_6.setBackground(new java.awt.Color(255, 255, 255));
        box7_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_6.setForeground(new java.awt.Color(255, 51, 51));
        box7_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_6.setActionCommand("<Not Set>");
        box7_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_6FocusLost(evt);
            }
        });
        add(box7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 300, -1, -1));

        box7_7.setEditable(false);
        box7_7.setBackground(new java.awt.Color(255, 255, 255));
        box7_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_7.setForeground(new java.awt.Color(255, 51, 51));
        box7_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_7.setActionCommand("<Not Set>");
        box7_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_7FocusLost(evt);
            }
        });
        add(box7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 300, -1, -1));

        box7_8.setEditable(false);
        box7_8.setBackground(new java.awt.Color(255, 255, 255));
        box7_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box7_8.setForeground(new java.awt.Color(255, 51, 51));
        box7_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box7_8.setActionCommand("<Not Set>");
        box7_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box7_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box7_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box7_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box7_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box7_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box7_8FocusLost(evt);
            }
        });
        add(box7_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 300, -1, -1));

        box8_0.setEditable(false);
        box8_0.setBackground(new java.awt.Color(255, 255, 255));
        box8_0.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_0.setText("3");
        box8_0.setActionCommand("<Not Set>");
        box8_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_0.setFocusable(false);
        box8_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_0.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_0FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_0FocusLost(evt);
            }
        });
        add(box8_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 325, -1, -1));

        box8_1.setEditable(false);
        box8_1.setBackground(new java.awt.Color(255, 255, 255));
        box8_1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_1.setForeground(new java.awt.Color(255, 51, 51));
        box8_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_1.setActionCommand("<Not Set>");
        box8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_1.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_1FocusLost(evt);
            }
        });
        add(box8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 325, -1, -1));

        box8_2.setEditable(false);
        box8_2.setBackground(new java.awt.Color(255, 255, 255));
        box8_2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_2.setForeground(new java.awt.Color(255, 51, 51));
        box8_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_2.setActionCommand("<Not Set>");
        box8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_2.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_2FocusLost(evt);
            }
        });
        add(box8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 325, -1, -1));

        box8_3.setEditable(false);
        box8_3.setBackground(new java.awt.Color(255, 255, 255));
        box8_3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_3.setText("9");
        box8_3.setActionCommand("<Not Set>");
        box8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_3.setFocusable(false);
        box8_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_3.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_3FocusLost(evt);
            }
        });
        add(box8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 325, -1, -1));

        box8_4.setEditable(false);
        box8_4.setBackground(new java.awt.Color(255, 255, 255));
        box8_4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_4.setForeground(new java.awt.Color(255, 51, 51));
        box8_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_4.setActionCommand("<Not Set>");
        box8_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_4.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_4FocusLost(evt);
            }
        });
        add(box8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 325, -1, -1));

        box8_5.setEditable(false);
        box8_5.setBackground(new java.awt.Color(255, 255, 255));
        box8_5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_5.setText("2");
        box8_5.setActionCommand("<Not Set>");
        box8_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_5.setFocusable(false);
        box8_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_5.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_5FocusLost(evt);
            }
        });
        add(box8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 325, -1, -1));

        box8_6.setEditable(false);
        box8_6.setBackground(new java.awt.Color(255, 255, 255));
        box8_6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_6.setForeground(new java.awt.Color(255, 51, 51));
        box8_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_6.setActionCommand("<Not Set>");
        box8_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_6.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_6FocusLost(evt);
            }
        });
        add(box8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 325, -1, -1));

        box8_7.setEditable(false);
        box8_7.setBackground(new java.awt.Color(255, 255, 255));
        box8_7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_7.setForeground(new java.awt.Color(255, 51, 51));
        box8_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_7.setActionCommand("<Not Set>");
        box8_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_7.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_7FocusLost(evt);
            }
        });
        add(box8_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 325, -1, -1));

        box8_8.setEditable(false);
        box8_8.setBackground(new java.awt.Color(255, 255, 255));
        box8_8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        box8_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box8_8.setText("5");
        box8_8.setActionCommand("<Not Set>");
        box8_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        box8_8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        box8_8.setFocusable(false);
        box8_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        box8_8.setPreferredSize(new java.awt.Dimension(25, 25));
        box8_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                box8_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                box8_8FocusLost(evt);
            }
        });
        add(box8_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 325, -1, -1));

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        jLabel1.setText("SUDOKU");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        scoreCheckButton.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        scoreCheckButton.setText("CHECK SCORE");
        scoreCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreCheckButtonActionPerformed(evt);
            }
        });
        add(scoreCheckButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 169, -1, -1));

        scoreDisplay.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        scoreDisplay.setText("Score: " + score);
        add(scoreDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 197, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 186, 239, 7));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator4.setPreferredSize(new java.awt.Dimension(7, 50));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 111, -1, 75));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator5.setPreferredSize(new java.awt.Dimension(7, 50));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 111, -1, 75));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator6.setPreferredSize(new java.awt.Dimension(7, 50));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 275, -1, 75));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 268, 239, 7));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator7.setPreferredSize(new java.awt.Dimension(7, 50));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 193, -1, 75));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator8.setPreferredSize(new java.awt.Dimension(7, 50));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 193, -1, 75));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator9.setPreferredSize(new java.awt.Dimension(7, 50));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 275, -1, 75));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    
    private static boolean setBox (int i){
        int row = focusedBox[0];
        int column = focusedBox[1];
        if (row < 9 && column < 9){
            currentBoard[row][column] = i;
            System.out.println(currentBoard[row][column]);
            return true;
        } else {
            System.out.println("No box selected");
            code = code + i;
            codeCheck();
            return false;
        }
        
    }
        private static int getScoreSudoku(){
        int finalScore = score + ColorGamePanel.score;
        return finalScore;
    }
    
    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK,2);
    Border redBorder = BorderFactory.createLineBorder(Color.RED,3);
    
    private void num1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num1ActionPerformed
        if(setBox(1)){
            boxes[focusedBox[0]][focusedBox[1]].setText("1");
        }
    }//GEN-LAST:event_num1ActionPerformed

    private void num2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num2ActionPerformed
        if(setBox(2)){
            boxes[focusedBox[0]][focusedBox[1]].setText("2");
        }
    }//GEN-LAST:event_num2ActionPerformed

    private void num3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num3ActionPerformed
        if(setBox(3)){
            boxes[focusedBox[0]][focusedBox[1]].setText("3");
        }
    }//GEN-LAST:event_num3ActionPerformed

    private void num4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num4ActionPerformed
        if(setBox(4)){
            boxes[focusedBox[0]][focusedBox[1]].setText("4");
        }
    }//GEN-LAST:event_num4ActionPerformed

    private void num5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num5ActionPerformed
        if(setBox(5)){
            boxes[focusedBox[0]][focusedBox[1]].setText("5");
        }
    }//GEN-LAST:event_num5ActionPerformed

    private void num6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num6ActionPerformed
        if(setBox(6)){
            boxes[focusedBox[0]][focusedBox[1]].setText("6");
        }
    }//GEN-LAST:event_num6ActionPerformed

    private void num7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num7ActionPerformed
        if(setBox(7)){
            boxes[focusedBox[0]][focusedBox[1]].setText("7");
        }
    }//GEN-LAST:event_num7ActionPerformed

    private void num8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num8ActionPerformed
        if(setBox(8)){
            boxes[focusedBox[0]][focusedBox[1]].setText("8");
        }
    }//GEN-LAST:event_num8ActionPerformed

    private void num9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num9ActionPerformed
        if(setBox(9)){
            boxes[focusedBox[0]][focusedBox[1]].setText("9");
        }
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

    private void box0_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_1FocusGained
        box0_1.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_1FocusGained

    private void box0_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_1FocusLost
        box0_1.setBorder(blackBorder);
    }//GEN-LAST:event_box0_1FocusLost

    private void box0_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_2FocusGained
        box0_2.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_2FocusGained

    private void box0_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_2FocusLost
        box0_2.setBorder(blackBorder);
    }//GEN-LAST:event_box0_2FocusLost

    private void box0_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_3FocusGained
        box0_3.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_3FocusGained

    private void box0_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_3FocusLost
        box0_3.setBorder(blackBorder);
    }//GEN-LAST:event_box0_3FocusLost

    private void box0_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_4FocusGained
        box0_4.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_4FocusGained

    private void box0_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_4FocusLost
        box0_4.setBorder(blackBorder);
    }//GEN-LAST:event_box0_4FocusLost

    private void box0_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_5FocusGained
        box0_5.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_5FocusGained

    private void box0_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_5FocusLost
        box0_5.setBorder(blackBorder);
    }//GEN-LAST:event_box0_5FocusLost

    private void box0_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_6FocusGained
        box0_6.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_6FocusGained

    private void box0_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_6FocusLost
        box0_6.setBorder(blackBorder);
    }//GEN-LAST:event_box0_6FocusLost

    private void box0_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_7FocusGained
        box0_7.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_7FocusGained

    private void box0_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_7FocusLost
        box0_7.setBorder(blackBorder);
    }//GEN-LAST:event_box0_7FocusLost

    private void box0_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_8FocusGained
        box0_8.setBorder(redBorder);
        focusedBox[0] = 0;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box0_8FocusGained

    private void box0_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box0_8FocusLost
        box0_8.setBorder(blackBorder);
    }//GEN-LAST:event_box0_8FocusLost

    private void box1_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_0FocusGained
        box1_0.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_0FocusGained

    private void box1_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_0FocusLost
        box1_0.setBorder(blackBorder);
    }//GEN-LAST:event_box1_0FocusLost

    private void box1_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_1FocusGained
        box1_1.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_1FocusGained

    private void box1_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_1FocusLost
        box1_1.setBorder(blackBorder);
    }//GEN-LAST:event_box1_1FocusLost

    private void box1_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_2FocusGained
        box1_2.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_2FocusGained

    private void box1_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_2FocusLost
        box1_2.setBorder(blackBorder);
    }//GEN-LAST:event_box1_2FocusLost

    private void box1_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_3FocusGained
        box1_3.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_3FocusGained

    private void box1_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_3FocusLost
        box1_3.setBorder(blackBorder);
    }//GEN-LAST:event_box1_3FocusLost

    private void box1_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_4FocusGained
        box1_4.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_4FocusGained

    private void box1_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_4FocusLost
        box1_4.setBorder(blackBorder);
    }//GEN-LAST:event_box1_4FocusLost

    private void box1_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_5FocusGained
        box1_5.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_5FocusGained

    private void box1_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_5FocusLost
        box1_5.setBorder(blackBorder);
    }//GEN-LAST:event_box1_5FocusLost

    private void box1_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_6FocusGained
        box1_6.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_6FocusGained

    private void box1_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_6FocusLost
        box1_6.setBorder(blackBorder);
    }//GEN-LAST:event_box1_6FocusLost

    private void box1_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_7FocusGained
        box1_7.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_7FocusGained

    private void box1_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_7FocusLost
        box1_7.setBorder(blackBorder);
    }//GEN-LAST:event_box1_7FocusLost

    private void box1_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_8FocusGained
        box1_8.setBorder(redBorder);
        focusedBox[0] = 1;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box1_8FocusGained

    private void box1_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box1_8FocusLost
        box1_8.setBorder(blackBorder);
    }//GEN-LAST:event_box1_8FocusLost

    private void box2_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_0FocusGained
        box2_0.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_0FocusGained

    private void box2_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_0FocusLost
        box2_0.setBorder(blackBorder);
    }//GEN-LAST:event_box2_0FocusLost

    private void box2_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_1FocusGained
        box2_1.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_1FocusGained

    private void box2_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_1FocusLost
        box2_1.setBorder(blackBorder);
    }//GEN-LAST:event_box2_1FocusLost

    private void box2_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_2FocusGained
        box2_2.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_2FocusGained

    private void box2_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_2FocusLost
        box2_2.setBorder(blackBorder);
    }//GEN-LAST:event_box2_2FocusLost

    private void box2_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_3FocusGained
        box2_3.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_3FocusGained

    private void box2_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_3FocusLost
        box2_3.setBorder(blackBorder);
    }//GEN-LAST:event_box2_3FocusLost

    private void box2_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_4FocusGained
        box2_4.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_4FocusGained

    private void box2_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_4FocusLost
        box2_4.setBorder(blackBorder);
    }//GEN-LAST:event_box2_4FocusLost

    private void box2_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_5FocusGained
        box2_5.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_5FocusGained

    private void box2_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_5FocusLost
        box2_5.setBorder(blackBorder);
    }//GEN-LAST:event_box2_5FocusLost

    private void box2_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_6FocusGained
        box2_6.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_6FocusGained

    private void box2_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_6FocusLost
        box2_6.setBorder(blackBorder);
    }//GEN-LAST:event_box2_6FocusLost

    private void box2_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_7FocusGained
        box2_7.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_7FocusGained

    private void box2_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_7FocusLost
        box2_7.setBorder(blackBorder);
    }//GEN-LAST:event_box2_7FocusLost

    private void box2_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_8FocusGained
        box2_8.setBorder(redBorder);
        focusedBox[0] = 2;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box2_8FocusGained

    private void box2_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box2_8FocusLost
        box2_8.setBorder(blackBorder);
    }//GEN-LAST:event_box2_8FocusLost

    private void box3_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_0FocusGained
        box3_0.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_0FocusGained

    private void box3_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_0FocusLost
        box3_0.setBorder(blackBorder);
    }//GEN-LAST:event_box3_0FocusLost

    private void box3_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_1FocusGained
        box3_1.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_1FocusGained

    private void box3_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_1FocusLost
        box3_1.setBorder(blackBorder);
    }//GEN-LAST:event_box3_1FocusLost

    private void box3_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_2FocusGained
        box3_2.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_2FocusGained

    private void box3_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_2FocusLost
        box3_2.setBorder(blackBorder);
    }//GEN-LAST:event_box3_2FocusLost

    private void box3_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_3FocusGained
        box3_3.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_3FocusGained

    private void box3_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_3FocusLost
        box3_3.setBorder(blackBorder);
    }//GEN-LAST:event_box3_3FocusLost

    private void box3_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_4FocusGained
        box3_4.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_4FocusGained

    private void box3_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_4FocusLost
        box3_4.setBorder(blackBorder);
    }//GEN-LAST:event_box3_4FocusLost

    private void box3_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_5FocusGained
        box3_5.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_5FocusGained

    private void box3_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_5FocusLost
        box3_5.setBorder(blackBorder);
    }//GEN-LAST:event_box3_5FocusLost

    private void box3_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_6FocusGained
        box3_6.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_6FocusGained

    private void box3_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_6FocusLost
        box3_6.setBorder(blackBorder);
    }//GEN-LAST:event_box3_6FocusLost

    private void box3_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_7FocusGained
        box3_7.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_7FocusGained

    private void box3_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_7FocusLost
        box3_7.setBorder(blackBorder);
    }//GEN-LAST:event_box3_7FocusLost

    private void box3_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_8FocusGained
        box3_8.setBorder(redBorder);
        focusedBox[0] = 3;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box3_8FocusGained

    private void box3_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box3_8FocusLost
        box3_8.setBorder(blackBorder);
    }//GEN-LAST:event_box3_8FocusLost

    //IF YOU SEE THIS, IGNORE IT.
    private static String code = "";
    private static void codeCheck(){
        if (code.matches("7952")){
            box1_1.setText("D");
            box1_2.setText("i");
            box1_3.setText("c");
            box1_4.setText("k");
            box1_5.setText(",");
            
            box3_1.setText("B");
            box3_2.setText("a");
            box3_3.setText("l");
            box3_4.setText("l");
            box3_5.setText("s");
            box3_6.setText(",");
            
            box4_4.setText("e");
            box4_5.setText("v");
            box4_6.setText("e");
            box4_7.setText("n");
            box4_8.setText(".");
            
            score = 540 + 42069;
        }
    }
    //IF YOU SEE THIS, IGNORE IT.
    
    private void box4_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_0FocusGained
        box4_0.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_0FocusGained

    private void box4_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_0FocusLost
        box4_0.setBorder(blackBorder);
    }//GEN-LAST:event_box4_0FocusLost

    private void box4_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_1FocusGained
        box4_1.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_1FocusGained

    private void box4_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_1FocusLost
        box4_1.setBorder(blackBorder);
    }//GEN-LAST:event_box4_1FocusLost

    private void box4_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_2FocusGained
        box4_2.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_2FocusGained

    private void box4_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_2FocusLost
        box4_2.setBorder(blackBorder);
    }//GEN-LAST:event_box4_2FocusLost

    private void box4_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_3FocusGained
        box4_3.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_3FocusGained

    private void box4_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_3FocusLost
        box4_3.setBorder(blackBorder);
    }//GEN-LAST:event_box4_3FocusLost

    private void box4_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_4FocusGained
        box4_4.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_4FocusGained

    private void box4_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_4FocusLost
        box4_4.setBorder(blackBorder);
    }//GEN-LAST:event_box4_4FocusLost

    private void box4_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_5FocusGained
        box4_5.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_5FocusGained

    private void box4_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_5FocusLost
        box4_5.setBorder(blackBorder);
    }//GEN-LAST:event_box4_5FocusLost

    private void box4_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_6FocusGained
        box4_6.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_6FocusGained

    private void box4_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_6FocusLost
        box4_6.setBorder(blackBorder);
    }//GEN-LAST:event_box4_6FocusLost

    private void box4_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_7FocusGained
        box4_7.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_7FocusGained

    private void box4_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_7FocusLost
        box4_7.setBorder(blackBorder);
    }//GEN-LAST:event_box4_7FocusLost

    private void box4_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_8FocusGained
        box4_8.setBorder(redBorder);
        focusedBox[0] = 4;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box4_8FocusGained

    private void box4_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box4_8FocusLost
        box4_8.setBorder(blackBorder);
    }//GEN-LAST:event_box4_8FocusLost

    private void box5_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_0FocusGained
        box5_0.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_0FocusGained

    private void box5_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_0FocusLost
        box5_0.setBorder(blackBorder);
    }//GEN-LAST:event_box5_0FocusLost

    private void box5_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_1FocusGained
        box5_1.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_1FocusGained

    private void box5_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_1FocusLost
        box5_1.setBorder(blackBorder);
    }//GEN-LAST:event_box5_1FocusLost

    private void box5_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_2FocusGained
        box5_2.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_2FocusGained

    private void box5_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_2FocusLost
        box5_2.setBorder(blackBorder);
    }//GEN-LAST:event_box5_2FocusLost

    private void box5_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_3FocusGained
        box5_3.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_3FocusGained

    private void box5_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_3FocusLost
        box5_3.setBorder(blackBorder);
    }//GEN-LAST:event_box5_3FocusLost

    private void box5_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_4FocusGained
        box5_4.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_4FocusGained

    private void box5_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_4FocusLost
        box5_4.setBorder(blackBorder);
    }//GEN-LAST:event_box5_4FocusLost

    private void box5_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_5FocusGained
        box5_5.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_5FocusGained

    private void box5_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_5FocusLost
        box5_5.setBorder(blackBorder);
    }//GEN-LAST:event_box5_5FocusLost

    private void box5_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_6FocusGained
        box5_6.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_6FocusGained

    private void box5_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_6FocusLost
        box5_6.setBorder(blackBorder);
    }//GEN-LAST:event_box5_6FocusLost

    private void box5_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_7FocusGained
        box5_7.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_7FocusGained

    private void box5_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_7FocusLost
        box5_7.setBorder(blackBorder);
    }//GEN-LAST:event_box5_7FocusLost

    private void box5_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_8FocusGained
        box5_8.setBorder(redBorder);
        focusedBox[0] = 5;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box5_8FocusGained

    private void box5_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box5_8FocusLost
        box5_8.setBorder(blackBorder);
    }//GEN-LAST:event_box5_8FocusLost

    private void box6_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_0FocusGained
        box6_0.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_0FocusGained

    private void box6_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_0FocusLost
        box6_0.setBorder(blackBorder);
    }//GEN-LAST:event_box6_0FocusLost

    private void box6_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_1FocusGained
        box6_1.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_1FocusGained

    private void box6_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_1FocusLost
        box6_1.setBorder(blackBorder);
    }//GEN-LAST:event_box6_1FocusLost

    private void box6_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_2FocusGained
        box6_2.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_2FocusGained

    private void box6_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_2FocusLost
        box6_2.setBorder(blackBorder);
    }//GEN-LAST:event_box6_2FocusLost

    private void box6_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_3FocusGained
        box6_3.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_3FocusGained

    private void box6_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_3FocusLost
        box6_3.setBorder(blackBorder);
    }//GEN-LAST:event_box6_3FocusLost

    private void box6_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_4FocusGained
        box6_4.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_4FocusGained

    private void box6_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_4FocusLost
        box6_4.setBorder(blackBorder);
    }//GEN-LAST:event_box6_4FocusLost

    private void box6_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_5FocusGained
        box6_5.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_5FocusGained

    private void box6_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_5FocusLost
        box6_5.setBorder(blackBorder);
    }//GEN-LAST:event_box6_5FocusLost

    private void box6_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_6FocusGained
        box6_6.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_6FocusGained

    private void box6_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_6FocusLost
        box6_6.setBorder(blackBorder);
    }//GEN-LAST:event_box6_6FocusLost

    private void box6_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_7FocusGained
        box6_7.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_7FocusGained

    private void box6_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_7FocusLost
        box6_7.setBorder(blackBorder);
    }//GEN-LAST:event_box6_7FocusLost

    private void box6_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_8FocusGained
        box6_8.setBorder(redBorder);
        focusedBox[0] = 6;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box6_8FocusGained

    private void box6_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box6_8FocusLost
        box6_8.setBorder(blackBorder);
    }//GEN-LAST:event_box6_8FocusLost

    private void box7_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_0FocusGained
        box7_0.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_0FocusGained

    private void box7_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_0FocusLost
        box7_0.setBorder(blackBorder);
    }//GEN-LAST:event_box7_0FocusLost

    private void box7_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_1FocusGained
        box7_1.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_1FocusGained

    private void box7_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_1FocusLost
        box7_1.setBorder(blackBorder);
    }//GEN-LAST:event_box7_1FocusLost

    private void box7_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_2FocusGained
        box7_2.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_2FocusGained

    private void box7_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_2FocusLost
        box7_2.setBorder(blackBorder);
    }//GEN-LAST:event_box7_2FocusLost

    private void box7_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_3FocusGained
        box7_3.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_3FocusGained

    private void box7_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_3FocusLost
        box7_3.setBorder(blackBorder);
    }//GEN-LAST:event_box7_3FocusLost

    private void box7_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_4FocusGained
        box7_4.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_4FocusGained

    private void box7_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_4FocusLost
        box7_4.setBorder(blackBorder);
    }//GEN-LAST:event_box7_4FocusLost

    private void box7_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_5FocusGained
        box7_5.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_5FocusGained

    private void box7_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_5FocusLost
        box7_5.setBorder(blackBorder);
    }//GEN-LAST:event_box7_5FocusLost

    private void box7_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_6FocusGained
        box7_6.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_6FocusGained

    private void box7_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_6FocusLost
        box7_6.setBorder(blackBorder);
    }//GEN-LAST:event_box7_6FocusLost

    private void box7_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_7FocusGained
        box7_7.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_7FocusGained

    private void box7_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_7FocusLost
        box7_7.setBorder(blackBorder);
    }//GEN-LAST:event_box7_7FocusLost

    private void box7_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_8FocusGained
        box7_8.setBorder(redBorder);
        focusedBox[0] = 7;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box7_8FocusGained

    private void box7_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box7_8FocusLost
        box7_8.setBorder(blackBorder);
    }//GEN-LAST:event_box7_8FocusLost

    private void box8_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_0FocusGained
        box8_0.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 0;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_0FocusGained

    private void box8_0FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_0FocusLost
        box8_0.setBorder(blackBorder);
    }//GEN-LAST:event_box8_0FocusLost

    private void box8_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_1FocusGained
        box8_1.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 1;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_1FocusGained

    private void box8_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_1FocusLost
        box8_1.setBorder(blackBorder);
    }//GEN-LAST:event_box8_1FocusLost

    private void box8_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_2FocusGained
        box8_2.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 2;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_2FocusGained

    private void box8_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_2FocusLost
        box8_2.setBorder(blackBorder);
    }//GEN-LAST:event_box8_2FocusLost

    private void box8_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_3FocusGained
        box8_3.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 3;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_3FocusGained

    private void box8_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_3FocusLost
        box8_3.setBorder(blackBorder);
    }//GEN-LAST:event_box8_3FocusLost

    private void box8_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_4FocusGained
        box8_4.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 4;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_4FocusGained

    private void box8_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_4FocusLost
        box8_4.setBorder(blackBorder);
    }//GEN-LAST:event_box8_4FocusLost

    private void box8_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_5FocusGained
        box8_5.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 5;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_5FocusGained

    private void box8_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_5FocusLost
        box8_5.setBorder(blackBorder);
    }//GEN-LAST:event_box8_5FocusLost

    private void box8_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_6FocusGained
        box8_6.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 6;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_6FocusGained

    private void box8_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_6FocusLost
        box8_6.setBorder(blackBorder);
    }//GEN-LAST:event_box8_6FocusLost

    private void box8_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_7FocusGained
        box8_7.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 7;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_7FocusGained

    private void box8_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_7FocusLost
        box8_7.setBorder(blackBorder);
    }//GEN-LAST:event_box8_7FocusLost

    private void box8_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_8FocusGained
        box8_8.setBorder(redBorder);
        focusedBox[0] = 8;
        focusedBox[1] = 8;
        System.out.println(focusedBox[0] + " " + focusedBox[1]);
    }//GEN-LAST:event_box8_8FocusGained

    private void box8_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_box8_8FocusLost
        box8_8.setBorder(blackBorder);
    }//GEN-LAST:event_box8_8FocusLost

    private void scoreCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreCheckButtonActionPerformed
        checkScore();
    }//GEN-LAST:event_scoreCheckButtonActionPerformed

    private void box0_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box0_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box0_2ActionPerformed

    private void box0_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box0_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box0_1ActionPerformed

    private void box1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box1_2ActionPerformed

    private void box1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box1_1ActionPerformed

    private void box0_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box0_8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box0_8ActionPerformed

    private void box4_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box4_7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box4_7ActionPerformed

    private void box0_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box0_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box0_3ActionPerformed

    private void box0_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box0_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box0_5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField box0_0;
    private static javax.swing.JTextField box0_1;
    private static javax.swing.JTextField box0_2;
    private static javax.swing.JTextField box0_3;
    private static javax.swing.JTextField box0_4;
    private static javax.swing.JTextField box0_5;
    private static javax.swing.JTextField box0_6;
    private static javax.swing.JTextField box0_7;
    private static javax.swing.JTextField box0_8;
    private static javax.swing.JTextField box1_0;
    private static javax.swing.JTextField box1_1;
    private static javax.swing.JTextField box1_2;
    private static javax.swing.JTextField box1_3;
    private static javax.swing.JTextField box1_4;
    private static javax.swing.JTextField box1_5;
    private static javax.swing.JTextField box1_6;
    private static javax.swing.JTextField box1_7;
    private static javax.swing.JTextField box1_8;
    private static javax.swing.JTextField box2_0;
    private static javax.swing.JTextField box2_1;
    private static javax.swing.JTextField box2_2;
    private static javax.swing.JTextField box2_3;
    private static javax.swing.JTextField box2_4;
    private static javax.swing.JTextField box2_5;
    private static javax.swing.JTextField box2_6;
    private static javax.swing.JTextField box2_7;
    private static javax.swing.JTextField box2_8;
    private static javax.swing.JTextField box3_0;
    private static javax.swing.JTextField box3_1;
    private static javax.swing.JTextField box3_2;
    private static javax.swing.JTextField box3_3;
    private static javax.swing.JTextField box3_4;
    private static javax.swing.JTextField box3_5;
    private static javax.swing.JTextField box3_6;
    private static javax.swing.JTextField box3_7;
    private static javax.swing.JTextField box3_8;
    private static javax.swing.JTextField box4_0;
    private static javax.swing.JTextField box4_1;
    private static javax.swing.JTextField box4_2;
    private static javax.swing.JTextField box4_3;
    private static javax.swing.JTextField box4_4;
    private static javax.swing.JTextField box4_5;
    private static javax.swing.JTextField box4_6;
    private static javax.swing.JTextField box4_7;
    private static javax.swing.JTextField box4_8;
    private static javax.swing.JTextField box5_0;
    private static javax.swing.JTextField box5_1;
    private static javax.swing.JTextField box5_2;
    private static javax.swing.JTextField box5_3;
    private static javax.swing.JTextField box5_4;
    private static javax.swing.JTextField box5_5;
    private static javax.swing.JTextField box5_6;
    private static javax.swing.JTextField box5_7;
    private static javax.swing.JTextField box5_8;
    private static javax.swing.JTextField box6_0;
    private static javax.swing.JTextField box6_1;
    private static javax.swing.JTextField box6_2;
    private static javax.swing.JTextField box6_3;
    private static javax.swing.JTextField box6_4;
    private static javax.swing.JTextField box6_5;
    private static javax.swing.JTextField box6_6;
    private static javax.swing.JTextField box6_7;
    private static javax.swing.JTextField box6_8;
    private static javax.swing.JTextField box7_0;
    private static javax.swing.JTextField box7_1;
    private static javax.swing.JTextField box7_2;
    private static javax.swing.JTextField box7_3;
    private static javax.swing.JTextField box7_4;
    private static javax.swing.JTextField box7_5;
    private static javax.swing.JTextField box7_6;
    private static javax.swing.JTextField box7_7;
    private static javax.swing.JTextField box7_8;
    private static javax.swing.JTextField box8_0;
    private static javax.swing.JTextField box8_1;
    private static javax.swing.JTextField box8_2;
    private static javax.swing.JTextField box8_3;
    private static javax.swing.JTextField box8_4;
    private static javax.swing.JTextField box8_5;
    private static javax.swing.JTextField box8_6;
    private static javax.swing.JTextField box8_7;
    private static javax.swing.JTextField box8_8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton num1;
    private javax.swing.JButton num2;
    private javax.swing.JButton num3;
    private javax.swing.JButton num4;
    private javax.swing.JButton num5;
    private javax.swing.JButton num6;
    private javax.swing.JButton num7;
    private javax.swing.JButton num8;
    private javax.swing.JButton num9;
    private javax.swing.JButton scoreCheckButton;
    private static javax.swing.JLabel scoreDisplay;
    // End of variables declaration//GEN-END:variables
}
