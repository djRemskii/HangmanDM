/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


/**
 * *************************************************************
 * file: GamePanel.java authors: S. Araya, D. Menkir, J Ong 
 * class: CS 2450 – User Interface Design and Programming 
 *
 * assignment: program 1 date last modified: 9/28/2022
 *
 * purpose: This panel hosts the hangman game visuals. Logic is handled in GameLogic.java.
 *
 ***************************************************************
 */
public class GamePanel extends javax.swing.JPanel {
    
    //method: GamePanel
    //purpose: is the constructor of this class. initializes variables
    public GamePanel() {
        Timer t = new Timer(1000, updateClockAction);
        t.start();
            
        initComponents();
        
        images[0] = image0;
        images[1] = image1;
        images[2] = image2;
        images[3] = image3;
        images[4] = image4;
        images[5] = image5;
        images[6] = image6;
        
        lettersLong[0] = letter1;
        lettersLong[1] = letter2;
        lettersLong[2] = letter3;
        lettersLong[3] = letter4;
        lettersLong[4] = letter5;
        lettersLong[5] = letter6;
        lettersLong[6] = letter7;
        lettersLong[7] = letter8;
        lettersLong[8] = letter9;
        lettersLong[9] = letter10;
        
        spriteReset();
        letterReset();
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
    }
    
    //CODE TO SWITCH IMAGES
    ImageIcon[] images = new ImageIcon[7];
    
    ImageIcon image0 = new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/HangmanSprite_0.png"));
    ImageIcon image1 = new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/HangmanSprite_1.png"));
    ImageIcon image2 = new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/HangmanSprite_2.png"));
    ImageIcon image3 = new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/HangmanSprite_3.png"));
    ImageIcon image4 = new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/HangmanSprite_4.png"));
    ImageIcon image5 = new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/HangmanSprite_5.png"));
    ImageIcon image6 = new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/HangmanSprite_0.png"));
    
    
    //method: spriteCheck
    //purpose: changes the hanged man to match the number of incorrect guesses
    private void spriteCheck(){
        spriteReset();
        System.out.println("nextSprite() called");
        int i = 0;
        while (i!=GameLogic.incorrectGuesses){
            i++;
        }
        
        hangmanSprite.setIcon(images[i]);
    }

    //method: spriteReset
    //purpose: resets the hanged man
    public void spriteReset(){
        hangmanSprite.setIcon(images[0]);
    }
    //IMAGE SWITCH CODE END
    
    
    //CODE TO SWITCH LETTERS
    private static JLabel[] lettersLong = new JLabel[10];
    
    //method: letterCheck
    //purpose: sets the text of the label to its correct letter, depending on the word
    public static void letterCheck(){
        JLabel[] letters = new JLabel[GameLogic.currentWord.length()];
        for (int i=0; i<GameLogic.currentWordReverse.length; i++){
            lettersLong[i].setText(GameLogic.currentWordReverse[i]);
            lettersLong[i].setVisible(true);
        }
        //letter1.setText(GameLogic.currentWordReverse[0]);
    }
    
    //method: letterReset
    //purpose: resets the correct letters to be invisible
    public static void letterReset(){
        for (int i=0; i<10; i++){
            lettersLong[i].setText(" ");
            lettersLong[i].setVisible(false);
        }
    }
    //LETTER SWITCH CODE END
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        skipButton = new javax.swing.JButton();
        buttonA = new javax.swing.JButton();
        buttonB = new javax.swing.JButton();
        buttonC = new javax.swing.JButton();
        buttonD = new javax.swing.JButton();
        buttonE = new javax.swing.JButton();
        buttonF = new javax.swing.JButton();
        buttonG = new javax.swing.JButton();
        buttonH = new javax.swing.JButton();
        buttonI = new javax.swing.JButton();
        buttonJ = new javax.swing.JButton();
        buttonK = new javax.swing.JButton();
        buttonL = new javax.swing.JButton();
        buttonM = new javax.swing.JButton();
        buttonN = new javax.swing.JButton();
        buttonO = new javax.swing.JButton();
        buttonP = new javax.swing.JButton();
        buttonQ = new javax.swing.JButton();
        buttonR = new javax.swing.JButton();
        buttonS = new javax.swing.JButton();
        buttonT = new javax.swing.JButton();
        buttonU = new javax.swing.JButton();
        buttonV = new javax.swing.JButton();
        buttonW = new javax.swing.JButton();
        buttonX = new javax.swing.JButton();
        buttonY = new javax.swing.JButton();
        buttonZ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        hangmanSprite = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        letter1 = new javax.swing.JLabel();
        letter2 = new javax.swing.JLabel();
        letter3 = new javax.swing.JLabel();
        letter4 = new javax.swing.JLabel();
        letter5 = new javax.swing.JLabel();
        letter6 = new javax.swing.JLabel();
        letter7 = new javax.swing.JLabel();
        letter8 = new javax.swing.JLabel();
        letter9 = new javax.swing.JLabel();
        letter10 = new javax.swing.JLabel();
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

        setPreferredSize(new java.awt.Dimension(600, 400));

        skipButton.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        skipButton.setText("SKIP");
        skipButton.setToolTipText("SKIP");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        buttonA.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonA.setText("A");
        buttonA.setToolTipText("A");
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });

        buttonB.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonB.setText("B");
        buttonB.setToolTipText("B");
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });

        buttonC.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonC.setText("C");
        buttonC.setToolTipText("C");
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });

        buttonD.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonD.setText("D");
        buttonD.setToolTipText("D");
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });

        buttonE.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonE.setText("E");
        buttonE.setToolTipText("E");
        buttonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEActionPerformed(evt);
            }
        });

        buttonF.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonF.setText("F");
        buttonF.setToolTipText("F");
        buttonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFActionPerformed(evt);
            }
        });

        buttonG.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonG.setText("G");
        buttonG.setToolTipText("G");
        buttonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGActionPerformed(evt);
            }
        });

        buttonH.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonH.setText("H");
        buttonH.setToolTipText("H");
        buttonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHActionPerformed(evt);
            }
        });

        buttonI.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonI.setText("I");
        buttonI.setToolTipText("I");
        buttonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIActionPerformed(evt);
            }
        });

        buttonJ.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonJ.setText("J");
        buttonJ.setToolTipText("J");
        buttonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJActionPerformed(evt);
            }
        });

        buttonK.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonK.setText("K");
        buttonK.setToolTipText("K");
        buttonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKActionPerformed(evt);
            }
        });

        buttonL.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonL.setText("L");
        buttonL.setToolTipText("L");
        buttonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLActionPerformed(evt);
            }
        });

        buttonM.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonM.setText("M");
        buttonM.setToolTipText("M");
        buttonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMActionPerformed(evt);
            }
        });

        buttonN.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonN.setText("N");
        buttonN.setToolTipText("N");
        buttonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNActionPerformed(evt);
            }
        });

        buttonO.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonO.setText("O");
        buttonO.setToolTipText("O");
        buttonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOActionPerformed(evt);
            }
        });

        buttonP.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonP.setText("P");
        buttonP.setToolTipText("P");
        buttonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPActionPerformed(evt);
            }
        });

        buttonQ.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonQ.setText("Q");
        buttonQ.setToolTipText("Q");
        buttonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQActionPerformed(evt);
            }
        });

        buttonR.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonR.setText("R");
        buttonR.setToolTipText("R");
        buttonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRActionPerformed(evt);
            }
        });

        buttonS.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonS.setText("S");
        buttonS.setToolTipText("S");
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSActionPerformed(evt);
            }
        });

        buttonT.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonT.setText("T");
        buttonT.setToolTipText("T");
        buttonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTActionPerformed(evt);
            }
        });

        buttonU.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonU.setText("U");
        buttonU.setToolTipText("U");
        buttonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUActionPerformed(evt);
            }
        });

        buttonV.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonV.setText("V");
        buttonV.setToolTipText("V");
        buttonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVActionPerformed(evt);
            }
        });

        buttonW.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonW.setText("W");
        buttonW.setToolTipText("W");
        buttonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWActionPerformed(evt);
            }
        });

        buttonX.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonX.setText("X");
        buttonX.setToolTipText("X");
        buttonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXActionPerformed(evt);
            }
        });

        buttonY.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonY.setText("Y");
        buttonY.setToolTipText("Y");
        buttonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYActionPerformed(evt);
            }
        });

        buttonZ.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        buttonZ.setText("Z");
        buttonZ.setToolTipText("Z");
        buttonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel1.setText(dtf.format(now));

        hangmanSprite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/HangmanSprite_0.png"))); // NOI18N

        letter1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter1.setText("?");
        letter1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter2.setText("?");
        letter2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter3.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter3.setText("?");
        letter3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter4.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter4.setText("?");
        letter4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter5.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter5.setText("?");
        letter5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter6.setText("?");
        letter6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter7.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter7.setText("?");
        letter7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter8.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter8.setText("?");
        letter8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter9.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter9.setText("?");
        letter9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        letter10.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        letter10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letter10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmanSprites/Line.png"))); // NOI18N
        letter10.setText("?");
        letter10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        letter10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        letter10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(letter1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letter10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(letter1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(letter3)
                        .addComponent(letter2)
                        .addComponent(letter4)
                        .addComponent(letter5)
                        .addComponent(letter6)
                        .addComponent(letter7)
                        .addComponent(letter8)
                        .addComponent(letter9)
                        .addComponent(letter10)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonZ))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonQ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonR))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonI)))
                .addContainerGap(305, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hangmanSprite)
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(skipButton))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(skipButton))
                    .addComponent(hangmanSprite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonA)
                    .addComponent(buttonB)
                    .addComponent(buttonC)
                    .addComponent(buttonD)
                    .addComponent(buttonE)
                    .addComponent(buttonF)
                    .addComponent(buttonG)
                    .addComponent(buttonH)
                    .addComponent(buttonI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonN)
                    .addComponent(buttonO)
                    .addComponent(buttonP)
                    .addComponent(buttonQ)
                    .addComponent(buttonJ)
                    .addComponent(buttonK)
                    .addComponent(buttonL)
                    .addComponent(buttonM)
                    .addComponent(buttonR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonS)
                    .addComponent(buttonT)
                    .addComponent(buttonU)
                    .addComponent(buttonV)
                    .addComponent(buttonW)
                    .addComponent(buttonX)
                    .addComponent(buttonY)
                    .addComponent(buttonZ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    //method: skipButtonActionPerformed
    //purpose: skips the hangman Game
    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        // TODO add your handling code here:
        spriteReset();
        letterReset();
        HangmanDM.frame.add(new ColorGamePanel(0),"color game");
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "color game");
        //HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "credits");
    }//GEN-LAST:event_skipButtonActionPerformed

    //CLOCK FUNCTIONALITY
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");  
    private LocalDateTime now = LocalDateTime.now();
    
    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a JLabel
            now = LocalDateTime.now();
            jLabel1.setText(dtf.format(now)); 
            //spriteCheck();
            //letterCheck();
            if(GameLogic.winFlag || GameLogic.gameOverFlag){
                spriteReset();
                letterReset();
            }
        }
    };
    //CLOCK FUNTIONALITY END
    
    
    
    
    //LETTER BUTTONS
    //method: button_ActionPerformed
    //purpose: runs isCorrect(letter pressed) from GameLogic.java, then updates either the hanged man via spriteCheck() or
    // updates the empty spaces via letterCheck()
    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("a"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonA.setEnabled(false);
    }//GEN-LAST:event_buttonAActionPerformed

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("b"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonB.setEnabled(false);
    }//GEN-LAST:event_buttonBActionPerformed

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("c"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonC.setEnabled(false);
    }//GEN-LAST:event_buttonCActionPerformed

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("d"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonD.setEnabled(false);
    }//GEN-LAST:event_buttonDActionPerformed

    private void buttonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("e"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonE.setEnabled(false);
    }//GEN-LAST:event_buttonEActionPerformed

    private void buttonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("f"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonF.setEnabled(false);
    }//GEN-LAST:event_buttonFActionPerformed

    private void buttonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("g"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonG.setEnabled(false);
    }//GEN-LAST:event_buttonGActionPerformed

    private void buttonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("h"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonH.setEnabled(false);
    }//GEN-LAST:event_buttonHActionPerformed

    private void buttonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("i"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonI.setEnabled(false);
    }//GEN-LAST:event_buttonIActionPerformed

    private void buttonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("j"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonJ.setEnabled(false);
    }//GEN-LAST:event_buttonJActionPerformed

    private void buttonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("k"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonK.setEnabled(false);
    }//GEN-LAST:event_buttonKActionPerformed

    private void buttonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("l"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonL.setEnabled(false);
    }//GEN-LAST:event_buttonLActionPerformed

    private void buttonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("m"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonM.setEnabled(false);
    }//GEN-LAST:event_buttonMActionPerformed

    private void buttonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("n"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonN.setEnabled(false);
    }//GEN-LAST:event_buttonNActionPerformed

    private void buttonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("o"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonO.setEnabled(false);
    }//GEN-LAST:event_buttonOActionPerformed

    private void buttonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("p"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonP.setEnabled(false);
    }//GEN-LAST:event_buttonPActionPerformed

    private void buttonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("q"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonQ.setEnabled(false);
    }//GEN-LAST:event_buttonQActionPerformed

    private void buttonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("r"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonR.setEnabled(false);
    }//GEN-LAST:event_buttonRActionPerformed

    private void buttonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("s"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonS.setEnabled(false);
    }//GEN-LAST:event_buttonSActionPerformed

    private void buttonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("t"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonT.setEnabled(false);
    }//GEN-LAST:event_buttonTActionPerformed

    private void buttonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("u"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonU.setEnabled(false);
    }//GEN-LAST:event_buttonUActionPerformed

    private void buttonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("v"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonV.setEnabled(false);
    }//GEN-LAST:event_buttonVActionPerformed

    private void buttonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("w"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonW.setEnabled(false);
    }//GEN-LAST:event_buttonWActionPerformed

    private void buttonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("x"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonX.setEnabled(false);
    }//GEN-LAST:event_buttonXActionPerformed

    private void buttonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("y"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonY.setEnabled(false);
    }//GEN-LAST:event_buttonYActionPerformed

    private void buttonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZActionPerformed
        try {
            // TODO add your handling code here:
            System.out.println(GameLogic.isCorrect("z"));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        spriteCheck();
        letterCheck();
        buttonZ.setEnabled(false);
    }//GEN-LAST:event_buttonZActionPerformed

    //method: buttonReset
    //purpose: enables the buttons
    public static void buttonReset(){
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        buttonE.setEnabled(true);
        buttonF.setEnabled(true);
        buttonG.setEnabled(true);
        buttonH.setEnabled(true);
        buttonI.setEnabled(true);
        buttonJ.setEnabled(true);
        buttonK.setEnabled(true);
        buttonL.setEnabled(true);
        buttonM.setEnabled(true);
        buttonN.setEnabled(true);
        buttonO.setEnabled(true);
        buttonP.setEnabled(true);
        buttonQ.setEnabled(true);
        buttonR.setEnabled(true);
        buttonS.setEnabled(true);
        buttonT.setEnabled(true);
        buttonU.setEnabled(true);
        buttonV.setEnabled(true);
        buttonW.setEnabled(true);
        buttonX.setEnabled(true);
        buttonY.setEnabled(true);
        buttonZ.setEnabled(true);
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton buttonA;
    private static javax.swing.JButton buttonB;
    private static javax.swing.JButton buttonC;
    private static javax.swing.JButton buttonD;
    private static javax.swing.JButton buttonE;
    private static javax.swing.JButton buttonF;
    private static javax.swing.JButton buttonG;
    private static javax.swing.JButton buttonH;
    private static javax.swing.JButton buttonI;
    private static javax.swing.JButton buttonJ;
    private static javax.swing.JButton buttonK;
    private static javax.swing.JButton buttonL;
    private static javax.swing.JButton buttonM;
    private static javax.swing.JButton buttonN;
    private static javax.swing.JButton buttonO;
    private static javax.swing.JButton buttonP;
    private static javax.swing.JButton buttonQ;
    private static javax.swing.JButton buttonR;
    private static javax.swing.JButton buttonS;
    private static javax.swing.JButton buttonT;
    private static javax.swing.JButton buttonU;
    private static javax.swing.JButton buttonV;
    private static javax.swing.JButton buttonW;
    private static javax.swing.JButton buttonX;
    private static javax.swing.JButton buttonY;
    private static javax.swing.JButton buttonZ;
    public static javax.swing.JLabel hangmanSprite;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JLabel letter1;
    private static javax.swing.JLabel letter10;
    private static javax.swing.JLabel letter2;
    private static javax.swing.JLabel letter3;
    private static javax.swing.JLabel letter4;
    private static javax.swing.JLabel letter5;
    private static javax.swing.JLabel letter6;
    private static javax.swing.JLabel letter7;
    private static javax.swing.JLabel letter8;
    private static javax.swing.JLabel letter9;
    private javax.swing.JButton skipButton;
    // End of variables declaration//GEN-END:variables
}
