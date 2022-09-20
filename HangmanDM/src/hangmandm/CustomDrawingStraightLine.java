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
public class CustomDrawingStraightLine extends JPanel {
    
    private int go;
    private int end;
    private int pos;
    private boolean verticalOrHorizontal;
    public CustomDrawingStraightLine(int xpos, int ystart, int ystop, boolean voh){
        setBorder(BorderFactory.createLineBorder(Color.black));
        pos = xpos;
        go = ystart;
        end = ystop;
        verticalOrHorizontal = voh;
    }
    
    @Override
    public Dimension getPreferredSize() { 
        return new Dimension(250,200); 
    } 
 
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        g.setColor(Color.BLACK);
        if(verticalOrHorizontal == true)
        {
            g.drawLine(pos, go, pos, end);
        }
        else
            g.drawLine(go, pos, end, pos);
        
    }   
    
}
