package hangmandm;


import java.awt.Graphics;


/**
 *
 * @author kevin
 */
public class Paddle {
    static double y,y2;
    int player, x;
    public Paddle(int player){
        y = 200;
        y2 = 200;
        if(player == 1)
            x = 20;
        else
            x = 545;
    }
    public void draw(Graphics g){
        g.fillRect(x,(int)y, 20, 80);
    }
    public void draw2(Graphics g){
        g.fillRect(x,(int)y2, 20, 80);
    }
    public static void moveUp(){
        y -= 20;
        if(y > 280)
            y = 280;
        if(y < 5)
            y = 5;
    }
    public static void moveDown(){
        y += 20;
        if(y > 280)
            y = 280;
        if(y < 5)
            y = 5;
    }
        public static void moveUp2(){
        y2 -= 20;
        if(y2 > 280)
            y2 = 280;
        if(y2 < 5)
            y2 = 5;

    }
    public static void moveDown2(){
        y2 += 20;
        if(y2 > 280)
            y2 = 280;
        if(y2 < 5)
            y2 = 5;
    }
    public int getY(){
        return (int)y;
    }
    public int getY2(){
        return (int)y2;
    }
    
    
}
