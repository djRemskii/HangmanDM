/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmandm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author danie
 */
public class CustomDrawingWordLines extends JPanel {
    
    
    
    public CustomDrawingWordLines()
    {       setBorder(null);
            
    }
    
    @Override
    public Dimension getPreferredSize() {
      return new Dimension(400,25);  
    } 
 
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);        
 
        g.setColor(Color.BLACK);
        for(int i = 0; i < 5; i++)
            {
                g.drawLine((10 + 50*(i)), 25, (40 + 50*(i)), 12);
            }
        
    }
    
    
    
}
