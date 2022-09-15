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
public class CustomDrawing extends JPanel {
    private BufferedImage pic;
    
    public CustomDrawing(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        pic = null;
    }
    
    @Override
    public Dimension getPreferredSize() { 
        return new Dimension(250,200); 
    } 
 
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        try{ 
            pic = ImageIO.read(new File("src\\squidward dabbing.png")); 
            }
        catch(IOException e){} 
        g.drawImage(pic,50,50, 100, 100, this); 
    }   
    
}
