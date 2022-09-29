/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hangmandm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    private static int[] highScores = new int[5];
    private static String[] names = new String[5];
    static boolean hs = false;
    static String name = "";
    
    private static javax.swing.JLabel[] scoreLables = new javax.swing.JLabel[5];
    private static javax.swing.JLabel[] nameLabels = new javax.swing.JLabel[5];
    
    private static void main(){
        for(int i=0; i<highScores.length; i++){
            highScores[i]=0;
        }
        for(int k = 0; k<names.length; k++){
            names[k] = "AAA";
        }
    }
    
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
    
    public static void loadSavedData(){
        
    }
    
        //Writes on scores file
    public static void writeFile(String a) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("scores.txt"),true));
        writer.write(a + "\r\n");
        writer.close();
    }
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
    
    public static void optionPane(){
        JFrame frame = new JFrame();
        name = JOptionPane.showInputDialog(frame, "You set a new high score. Input your initials");
}
    
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
    
    /**
     * Creates new form HighScorePanel
     */
    public HighScorePanel() {
        main();
        initComponents();
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
                            .addComponent(highScore1))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel nameLabel1;
    private static javax.swing.JLabel nameLabel2;
    private static javax.swing.JLabel nameLabel3;
    private static javax.swing.JLabel nameLabel4;
    private static javax.swing.JLabel nameLabel5;
    // End of variables declaration//GEN-END:variables


    
}
