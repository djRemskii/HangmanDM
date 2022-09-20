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
public class CustomDrawingDiagonalLine extends JPanel {
    
    private int xGo;
    private int xEnd;
    private int yGo;
    private int yEnd;
    public CustomDrawingDiagonalLine(int xStart, int xStop, int yStart, int yStop){
        setBorder(BorderFactory.createLineBorder(Color.black));
        xGo = xStart;
        xEnd = xStop;
        yGo = yStart;
        yEnd = yStop;
    }
    
    @Override
    public Dimension getPreferredSize() { 
        return new Dimension(250,200); 
    } 
 
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        g.setColor(Color.BLACK);
        g.drawLine(xGo, yGo, xEnd, yEnd);
    }
    
}
