/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmandm;


import static hangmandm.GamePanel.hangmanSprite;
import static hangmandm.HangmanDM.frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/***************************************************************  
*  file: GameLogic.java 
*  author: J. Ong 
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Program 1.1  
*  date last modified: 10/15/2022 
*  
*  purpose: Contains the logic handling for the hangman game, visuals shown by panel GamePanel.java
*  
****************************************************************/ 
public class GameLogic {
    public static String[] WORD_LIST = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
    public static String currentWord;
    public static String[] currentWordReverse;
    public static int incorrectGuesses = 0;
    public static int currentScore = 100;
    public static boolean gameOverFlag = false;
    public static boolean winFlag = false;
    
    
    
    //method: randomWord
    //purpose: returns a random word from WORD_LIST
    private static String randomWord(){
        int upperbound = WORD_LIST.length;
        int randomInt = new Random().nextInt(upperbound);
        return WORD_LIST[randomInt];
    }
    
   
    //method: isCorrect
    //purpose: returns true if the argument has a letter that is within the guessing word,
    // otherwise subtracts 10 points and returns false. If there are no more blank  
    // spaces in the guessing word, transition to colors game. If the user loses, 
    // transition to colors game
    public static boolean isCorrect(String s) throws IOException{
        if (currentWord.contains(s)){
            for (int i=0; i<currentWord.length(); i++){
                if (currentWord.indexOf(s)==i){
                    currentWord = currentWord.replaceFirst(s, " ");
                    currentWordReverse[i] = s;
                    System.out.println(currentWord);
                    for(int j=0; j<currentWordReverse.length; j++){
                        System.out.print(currentWordReverse[j]);
                    System.out.println();
                    }
                }
            }
            currentWord = currentWord.replaceAll(s, "");
            if (currentWord.replaceAll(" ", "").isEmpty()){
                winFlag = true;
                System.out.println("game won");
                
                GamePanel.letterReset();
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                frame.add(new ColorGamePanel(currentScore), "color game");
                
                HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "color game");
            }
            GamePanel.incorrectText.setVisible(false);
            return true;
        } else {
            incorrectGuesses++;
            currentScore -= 10;
            
            
            //JFrame wrong = new JFrame();
            //JOptionPane.showMessageDialog(wrong, "Wrong Letter, Try Again.", "Wrong Letter.", JOptionPane.INFORMATION_MESSAGE);
            
            GamePanel.incorrectText.setVisible(true);
            
            if (incorrectGuesses > 5){
                gameOverFlag = true;
                System.out.println("game lost");
                
                GamePanel.letterReset();
               
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                frame.add(new ColorGamePanel(currentScore), "color game");
                
                HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "color game");
            }
            return false;
        }
    }
    
    
    
    //Reserts the incorrectGuesses Counter
    //method: reset
    //purpose: resets the game
    private static void reset(){
        incorrectGuesses = 0;
        currentScore = 100;
        gameOverFlag = false;
        winFlag = false;
        currentWord = randomWord();
        currentWordReverse = new String[currentWord.length()];
        
        GamePanel.incorrectText.setVisible(false);
        
        GamePanel.letterReset();
        GamePanel.letterCheck();
        
        for (int i=0; i<currentWordReverse.length; i++){
            currentWordReverse[i] = " ";
        }
        
        GamePanel.buttonReset(); //resets all letter buttons to enabled
        
        System.out.println("Game has been reset");
    }
    

    //method: main
    //purpose: gives information on what is happening while running the code
    public static void main(){
        System.out.println("GameLogic.java is running");
        reset();
        System.out.println(currentWord);
        
    }
}
