package hangmandm;


import java.awt.Graphics;


/**
 *
 * @author kevin
 */
public class Paddle {
    static double y, y2;
    int player, x;
    public Paddle(int player){
        y = 200;
        y2= 200;
        if(player == 1)
            x = 20;
        else
            x = 545;
    }
    public void draw(Graphics g){
        g.fillRect(x,(int)y, 20, 80);
    }
    public static void moveUp(){
        y -= 20;

    }
    public static void moveDown(){
        y += 20;
    }
    public static void moveUp2(){
        y2 -= 20;

    }
    public static void moveDown2(){
        y2 += 20;
    }
    public int getY(){
        return (int)y;
    }
    
    
}
