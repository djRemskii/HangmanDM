/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmandm;

import javax.swing.SwingUtilities; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.BorderFactory; 
import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Graphics;
import java.awt.*; 
import java.awt.image.*; 
import java.io.*; 
import javax.imageio.*; 
import javax.swing.*;

/**
 *
 * @author danie
 */
public class CustomDrawingHangingPost extends JPanel {
    
    public CustomDrawingHangingPost(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        
    }
    
    @Override
    public Dimension getPreferredSize() { 
        return new Dimension(250,200); 
    } 
 
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        g.setColor(Color.BLACK);
        g.drawLine(100, 250, 500, 250);
        g.drawLine(300, 250, 300, 350);
        g.drawLine(300, 350, 400, 350);
        g.drawLine(400, 350, 400, 250);
        
    }   
    
}
