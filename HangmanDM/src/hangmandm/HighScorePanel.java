/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/***************************************************************  
*  file: HighScoresPanel.java 
*  author: Kevin Hoang, Jeremy Ong  
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Program 1.1  
*  date last modified: 9/28/2022 
*  
*  purpose: This panel shows the highscores.
*  
****************************************************************/ 
public class HighScorePanel extends javax.swing.JPanel {

    public static int newScore = 0;
    public static int[] highScores = new int[5];
    public static String[] names = new String[5];
    static boolean hs = false;
    static String name = "";
    
    private static javax.swing.JLabel[] scoreLables = new javax.swing.JLabel[5];
    private static javax.swing.JLabel[] nameLabels = new javax.swing.JLabel[5];
    
        /**
     * Creates new form HighScorePanel
     */
    public HighScorePanel() {
        main();
        initComponents();
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
    }
   
    //method:savedData
    //purpose: to save the high score data
    public static void savedData() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("savedscores.txt")));
        for(int i = 0; i < highScores.length; i++){
            writer.write(highScores[i] + "\r\n");
        }
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File("savednames.txt")));
        for(int k = 0; k < highScores.length; k++){
            writer2.write(names[k] + "\r\n");
        }
        writer.close();
        writer2.close();
    }
    
    //method:loadSaveData
    //purpose: to load up the saved high scores everytime the game runs.
    public static void loadSavedData() throws FileNotFoundException, IOException{
        
        BufferedReader br = new BufferedReader(new FileReader("savedscores.txt"));
        for(int i = 0; i < 5; i++){
         highScores[i] = Integer.parseInt(Files.readAllLines(Paths.get("savedscores.txt")).get(i));
        }
        BufferedReader br2 = new BufferedReader(new FileReader("savednames.txt"));
        for(int i = 0, k = 0; i < 5; i++, k++){
         names[k] = Files.readAllLines(Paths.get("savednames.txt")).get(i);
        }
        
        highScore1.setText(highScores[0] + "");
        highScore2.setText(highScores[1] + "");
        highScore3.setText(highScores[2] + "");
        highScore4.setText(highScores[3] + "");
        highScore5.setText(highScores[4] + "");
        
        nameLabel1.setText(names[0]);
        nameLabel2.setText(names[1]);
        nameLabel3.setText(names[2]);
        nameLabel4.setText(names[3]);
        nameLabel5.setText(names[4]);
        

        
    }
        //method:writeFile
        //purpose: Writes on scores file
    public static void writeFile(String a) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("scores.txt"),true));
        writer.write(a + "\r\n");
        writer.close();
    }
        //method:getScore
        //purpose: Retrieves the last score on the file to compare
    public static int getScore() throws FileNotFoundException, IOException{
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream("scores.txt"));
        BufferedReader br = new BufferedReader(streamReader);
        String lLine = "";
        String empty = "";
        while(br.ready()){
            lLine = br.readLine();
            if(!(lLine.equals(empty)))
                newScore = Integer.parseInt(lLine);
        }
        return newScore;
    }
        //method:optionPane()
        //purpose: Gives the user a message when they get a highscore.
    public static void optionPane(){
        JFrame frame = new JFrame();
        name = JOptionPane.showInputDialog(frame, "You set a new high score. Input your initials");
}
        //method:scoreCheck()
        //purpose: checks the newest score to see if it's a highscore
    public static void scoreCheck(int s) throws IOException{
        
        //I have no idea why this code only works when placed right here, but for the love of god dont move it.
        scoreLables[0] = highScore1;
        scoreLables[1] = highScore2;
        scoreLables[2] = highScore3;
        scoreLables[3] = highScore4;
        scoreLables[4] = highScore5;
        //end rant
        
        nameLabels[0] = nameLabel1;
        nameLabels[1] = nameLabel2;
        nameLabels[2] = nameLabel3;
        nameLabels[3] = nameLabel4;
        nameLabels[4] = nameLabel5;
        
        
        if (s>0){
            boolean change = false;
            for (int i=0; i<highScores.length; i++){
                if (!change){
                    if (s>highScores[i]){
                        for (int j=highScores.length-1; j>i; j--){
                            highScores[j] = highScores[j-1];
                            names[j] = names[j-1];
                            scoreLables[j].setText(highScores[j] + "");
                            nameLabels[j].setText(names[j] + "");
                        }
                        highScores[i] = s;
                        scoreLables[i].setText(highScores[i] + "");
                        hs = true;
                        if(hs = true)
                            writeFile(ColorGamePanel.getScore() + "");
                            optionPane();
                        names[i] = name.substring(0, 3);
                        nameLabels[i].setText(names[i].substring(0,3) + "");
                        hs = false;
                        change = true;
                    }
                }
            }
        }
        for (int k=0; k<highScores.length; k++){
            System.out.println(highScores[k]);
        }
    }
        //method: main
        //purpose: initializes some variables
        public static void main(){
        for(int i=0; i<highScores.length; i++){
            highScores[i]=0;
        }
        for(int k = 0; k<names.length; k++){
            names[k] = "AAA";
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
        highScore1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        nameLabel2 = new javax.swing.JLabel();
        nameLabel3 = new javax.swing.JLabel();
        nameLabel4 = new javax.swing.JLabel();
        nameLabel5 = new javax.swing.JLabel();
        highScore2 = new javax.swing.JLabel();
        highScore3 = new javax.swing.JLabel();
        highScore4 = new javax.swing.JLabel();
        highScore5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        jLabel1.setText("HIGH SCORES");

        highScore1.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        highScore1.setText(highScores[0] + "");

        nameLabel1.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        nameLabel1.setText("AAA");
        nameLabel1.setToolTipText("");

        nameLabel2.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        nameLabel2.setText("AAA");

        nameLabel3.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        nameLabel3.setText("AAA");

        nameLabel4.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        nameLabel4.setText("AAA");

        nameLabel5.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        nameLabel5.setText("AAA");

        highScore2.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        highScore2.setText("0");

        highScore3.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        highScore3.setText("0");

        highScore4.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        highScore4.setText("0");

        highScore5.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        highScore5.setText("0");

        jButton2.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton2)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(highScore5)
                                    .addComponent(highScore4)
                                    .addComponent(highScore3)
                                    .addComponent(highScore2)
                                    .addComponent(highScore1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(highScore1)
                    .addComponent(nameLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel2)
                    .addComponent(highScore2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel3)
                    .addComponent(highScore3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel4)
                    .addComponent(highScore4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel5)
                    .addComponent(highScore5))
                .addGap(90, 90, 90)
                .addComponent(jButton2)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "menu");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel highScore1;
    private static javax.swing.JLabel highScore2;
    private static javax.swing.JLabel highScore3;
    private static javax.swing.JLabel highScore4;
    private static javax.swing.JLabel highScore5;
    private static javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel nameLabel1;
    private static javax.swing.JLabel nameLabel2;
    private static javax.swing.JLabel nameLabel3;
    private static javax.swing.JLabel nameLabel4;
    private static javax.swing.JLabel nameLabel5;
    // End of variables declaration//GEN-END:variables


    
}
