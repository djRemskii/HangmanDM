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
    
    private int life;
    public CustomDrawingHangingPost(int lives){
        setBorder(null);
        life = lives;
        
    }
    
    @Override
    public Dimension getPreferredSize() { 
        return new Dimension(120,120); 
    } 
 
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        g.setColor(Color.BLACK);
        g.drawLine(0, 99, 99, 99);
        g.drawLine(49, 99, 49, 0);
        g.drawLine(49, 0, 70, 0);
        g.drawLine(70, 0, 70, 30);
        switch (life) {
            case 6 -> { 
                break;
            }
            case 5 ->             {
               g.drawOval(65, 30, 10, 10); //head
               revalidate();
               repaint();
               break;
            }
                
            case 4 ->             {
               g.drawOval(65, 30, 10, 10); //head
               g.drawLine(70, 40, 70, 70); //torso
               revalidate();
               repaint();
               break;
            }
                
            case 3 ->             {
                g.drawOval(65, 30, 10, 10); //head
                g.drawLine(70, 40, 70, 70); //torso
                g.drawLine(70, 55, 60, 65); //left arm
                revalidate();
                repaint();
                break;
            }
                
            case 2 ->             {
                g.drawOval(65, 30, 10, 10); //head
                g.drawLine(70, 40, 70, 70); //torso
                g.drawLine(70, 55, 60, 65); //left arm
                g.drawLine(70, 55, 80, 65); //right arm
                revalidate();
                repaint();
                break;
            }
                
            case 1 ->             {
                g.drawOval(65, 30, 10, 10); //head
                g.drawLine(70, 40, 70, 70); //torso
                g.drawLine(70, 55, 60, 65); //left arm
                g.drawLine(70, 55, 80, 65); //right arm
                g.drawLine(70, 70, 55, 85); //left leg
                revalidate();
                repaint();
                break;
            }
                
            case 0 ->             {
                g.drawOval(65, 30, 10, 10); //head
                g.drawLine(70, 40, 70, 70); //torso
                g.drawLine(70, 55, 60, 65); //left arm
                g.drawLine(70, 55, 80, 65); //right arm
                g.drawLine(70, 70, 55, 85); //left leg
                g.drawLine(70, 70, 85, 85); //right leg
                revalidate();
                repaint();
                break;
            }
                
        }
    }   
    
}
