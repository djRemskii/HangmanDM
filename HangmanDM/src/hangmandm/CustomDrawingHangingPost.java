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
        setBorder(null);
        
    }
    
    @Override
    public Dimension getPreferredSize() { 
        return new Dimension(100,100); 
    } 
 
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        g.setColor(Color.BLACK);
        g.drawLine(0, 99, 99, 99);
        g.drawLine(49, 99, 49, 0);
        g.drawLine(49, 0, 99, 0);
        g.drawLine(99, 0, 99, 30);
        
    }   
    
}
