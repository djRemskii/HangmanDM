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
    
    //method: PongScreen
    //purpose: is the constructor of this class. initializes variables
    public Paddle(int player){
        y = 100;
        y2 = 100;
        if(player == 1)
            x = 6;
        else
            x = 290;
    }
    
    //method: resetPaddle
    //purpose: resets Paddle position
    public static void resetPaddle(){
        
        y = 100;
        y2 = 100;
    }
    
    //method: draw
    //purpose: draws the first paddle
    public void draw(Graphics g){
        g.fillRect(x,(int)y, 20, 80);
    }
    
    //method: draw2
    //purpose: draws the 2nd paddle
    public void draw2(Graphics g){
        g.fillRect(x,(int)y2, 20, 80);
    }
    
    //method: moveUp
    //purpose: moves the first paddle up
    public static void moveUp(){
        y -= 20;
        if(y > 220)
            y = 220;
        if(y < 2)
            y = 2;
    }
    
    //method: moveDown
    //purpose: moves the first paddle down
    public static void moveDown(){
        y += 20;
        if(y > 220)
            y = 220;
        if(y < 2)
            y = 2;
    }
    
    //method: moveUp2
    //purpose: moves the 2nd paddle up
    public static void moveUp2(){
        y2 -= 20;
        if(y2 > 220)
            y2 = 220;
        if(y2 < 2)
            y2 = 2;

    }
    
    //method: moveDown2
    //purpose: moves the 2nd paddle down
    public static void moveDown2(){
        y2 += 20;
        if(y2 > 220)
            y2 = 220;
        if(y2 < 2)
            y2 = 2;
    }
    
    //method: getY
    //purpose: returns the y location of the first paddle
    public int getY(){
        return (int)y;
    }
    
    //method: getY2
    //purpose: returns the y location of the 2nd paddle
    public int getY2(){
        return (int)y2;
    }
    
    
}
