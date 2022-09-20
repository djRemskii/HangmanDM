/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmandm;

import javax.swing.JPanel;

/**
 *
 * @author danie
 */
public class CustomDrawingWordLines extends JPanel {
    
    private final String thing;
    public CustomDrawingWordLines(String word)
    {       
            thing = word;
            for(int i = 1; i < thing.length(); i++)
            {
                new CustomDrawingStraightLine(75*i,200,125*i,false);
            }
        
    }
    
    
}
