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
public class CDWordLine extends JPanel {
    
    public CDWordLine()
    {
        setBorder(null);
    }
    
    @Override
    public Dimension getPreferredSize() {
      return new Dimension(50, 10);  
    }
    
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        g.setColor(Color.BLACK);
        g.drawLine(0, 5, 49, 5);
            
        
    }
}
