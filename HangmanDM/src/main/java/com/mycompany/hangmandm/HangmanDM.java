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

/**
 *
 * @author djRemskii
 */
public class HangmanDM{
    
    
    JPanel mainPanel;
    public static JFrame frame;
    public static CardLayout cardLayout;
    
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
        
        //sets the panel on top
        cardLayout.show(frame.getContentPane(), "start");
        
        //paints the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HangmanDM.class.getName()).log(Level.SEVERE, null, ex);
        }
        cardLayout.show(frame.getContentPane(), "menu");
    }
    
    public static void main(String[]args){
        new HangmanDM();
    }
}
