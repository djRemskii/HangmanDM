/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmandm;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djRemskii
 */
public class GameLogic {
    public static String[] wordList = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
    public static String currentWord;
    public static String[] currentWordReverse;
    public static int incorrectGuesses = 0;
    public static int currentScore = 100;
    public static boolean gameOverFlag = false;
    public static boolean winFlag = false;
    
    
    //Returns a random word from wordList
    private static String randomWord(){
        int upperbound = wordList.length;
        int randomInt = new Random().nextInt(upperbound);
        return wordList[randomInt];
    }
    
    //Returns boolean value if currentWord contains the letter (must be a String) and increments incorrectGuesses.
    public static boolean isCorrect(String s){
        if (currentWord.contains(s)){
            for (int i=0; i<currentWord.length(); i++){
                if (currentWord.indexOf(s)==i){
                    currentWord = currentWord.replaceFirst(s, " ");
                    currentWordReverse[i] = s;
                    System.out.println(currentWord);
                    for(int j=0; j<currentWordReverse.length; j++){
                        System.out.print(currentWordReverse[j]);
                    }
                    System.out.println();
                }
            }
            currentWord = currentWord.replaceAll(s, "");
            if (currentWord.replaceAll(" ", "").isEmpty()){
                winFlag = true;
                System.out.println("game won");
                
                GamePanel.letterReset();
                
                HighScorePanel.scoreCheck(currentScore);
                HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "high scores");
            }
            return true;
        } else {
            incorrectGuesses++;
            currentScore -= 10;
            //GamePanel.hangmanSprite.setIcon(new javax.swing.ImageIcon(("/hangmanSprites/HangmanSprite_1.png")));
            if (incorrectGuesses > 5){
                gameOverFlag = true;
                System.out.println("game lost");
                
                GamePanel.letterReset();
                
                HangmanDM.cardLayout.show(HangmanDM.frame.getContentPane(), "high scores");
            }
            return false;
        }
    }
    
    
    
    //Reserts the incorrectGuesses Counter
    private static void reset(){
        incorrectGuesses = 0;
        currentScore = 100;
        gameOverFlag = false;
        winFlag = false;
        currentWord = randomWord();
        currentWordReverse = new String[currentWord.length()];
        
        GamePanel.letterReset();
        GamePanel.letterCheck();
        
        for (int i=0; i<currentWordReverse.length; i++){
            currentWordReverse[i] = " ";
        }
        
        GamePanel.buttonReset(); //resets all letter buttons to enabled
        
        System.out.println("Game has been reset");
    }
    

    
    public static void main(){
        System.out.println("GameLogic.java is running");
        reset();
        System.out.println(currentWord);
        
    }
}
