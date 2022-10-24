package hangmandm;


import java.awt.Graphics;


/**
 *
 * @author kevin
 */
public class Paddle {
    double y, yVel;
    boolean upAccel, downAccel;
    int player, x;
    public Paddle(int player){
        upAccel = false; downAccel = false;
        y = 200; yVel = 0;
        if(player == 1)
            x = 20;
        else
            x = 545;
    }
    public void draw(Graphics g){
        g.fillRect(x,(int)y, 20, 80);
    }
    public void move(){
        if(upAccel){
            yVel -= 2;  
        }
        else if(downAccel){
            yVel += 2;  
        }
        else if(!upAccel && !downAccel){
            yVel *= .94;
        }
        y += yVel;
    }
    public void setUpAccel(boolean input){
        upAccel = input;
    }
    public void setDownAccel(boolean input){
        downAccel = input;
    }
    public int getY(){
        return (int)y;
    }
    
    
}
