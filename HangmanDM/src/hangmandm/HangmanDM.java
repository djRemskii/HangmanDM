/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmandm;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.*;

/***************************************************************  
*  file: HangmanDM.java 
*  author: J. Ong 
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Program 1.0  
*  date last modified: 9/18/2022 
*  
*  purpose: This is the main class/java file that controls the switching of all the other panels.
*           This class contains the JFrame that holds the other panels in a CardLayout format.
*           It also controls the switching from StartPanel.java to MenuPanel.java after 3 seconds.
*  
****************************************************************/ 
public class HangmanDM{
    
    
    JPanel mainPanel;
    public static JFrame frame;
    public static CardLayout cardLayout;
    
    
    // constructor: HangmanDM
    // purpose: Creates the frame and adds the panels as cards in cardLayout.
    public HangmanDM(){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        //creates the frame
        frame = new JFrame("HangmanDM");
        frame.setPreferredSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //creates the card layout
        cardLayout = new CardLayout();
        frame.setLayout(cardLayout);
        
        //add any panels here 
        frame.add(new StartPanel(), "start");
        frame.add(new MenuPanel(), "menu");
        frame.add(new CreditsPanel(), "credits");
        frame.add(new HighScoresPanel(), "high scores");
        frame.add(new ClockTestPanel(), "clock test");
        
        //sets the panel on top
        cardLayout.show(frame.getContentPane(), "start");
        
        //paints the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        // method: n/a, this is part of constructor HangmanDM() 
        // purpose: The below code controls the automatic switching from StartPanel.java to MenuPanel.java when run.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HangmanDM.class.getName()).log(Level.SEVERE, null, ex);
        }
        cardLayout.show(frame.getContentPane(), "menu");
    }
    
    
    // method: main  
    // purpose: creates a new HangmanDM object, essentially starting the program.
    public static void main(String[]args){
        new HangmanDM();
    }
}
