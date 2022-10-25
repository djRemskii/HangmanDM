package hangmandm;


import java.awt.Graphics;


/***************************************************************  
*  file: GameLogic.java 
*  author: Kevin 
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Program 1.3  
*  date last modified: 10/24/2022 
*  
*  purpose: Class for the creation of Paddle objects, used for the Pong game.
*  
****************************************************************/ 
public class Paddle {
    static double y,y2;
    int player, x;
    public Paddle(int player){
        y = 100;
        y2 = 100;
        if(player == 1)
            x = 6;
        else
            x = 290;
    }
    
    public static void resetPaddle(){
        
        y = 100;
        y2 = 100;
    }
    public void draw(Graphics g){
        g.fillRect(x,(int)y, 20, 80);
    }
    public void draw2(Graphics g){
        g.fillRect(x,(int)y2, 20, 80);
    }
    public static void moveUp(){
        y -= 20;
        if(y > 220)
            y = 220;
        if(y < 2)
            y = 2;
    }
    public static void moveDown(){
        y += 20;
        if(y > 220)
            y = 220;
        if(y < 2)
            y = 2;
    }
        public static void moveUp2(){
        y2 -= 20;
        if(y2 > 220)
            y2 = 220;
        if(y2 < 2)
            y2 = 2;

    }
    public static void moveDown2(){
        y2 += 20;
        if(y2 > 220)
            y2 = 220;
        if(y2 < 2)
            y2 = 2;
    }
    public int getY(){
        return (int)y;
    }
    public int getY2(){
        return (int)y2;
    }
    
    
}
