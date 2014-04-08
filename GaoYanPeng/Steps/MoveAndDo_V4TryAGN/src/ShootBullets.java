import java.awt.*;
import java.awt.event.*;

public class ShootBullets implements Runnable {
    
    int x, y, xDirection;
    int bx, by;
    boolean readyToFire, shot = false;
    
    java.awt.Rectangle bullet;
    public ShootBullets(){
//        x = MovingKeys.x;
//        y = MovingKeys.y;
        //System.out.println(x + " " + y );
    }
    
    public void draw(Graphics g){
        if (shot == true){
            g.setColor(Color.BLACK);
            g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
        }
    }
    
    
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_SPACE){
            if (bullet == null)
                readyToFire =  true;
            if (readyToFire = true && shot == false){
                by = MovingKeys.y;
                bx = MovingKeys.x;
                System.out.println(bx + " " + by );
                bullet = new java.awt.Rectangle (bx, by, 3, 5);
                shot = true;
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
         if(keyCode == e.VK_SPACE){
           readyToFire = false;
           if(bullet.x >= 500){
               bullet = new java.awt.Rectangle(0,0,0,0);
               shot = false;
               readyToFire = true;
           }
        }
    }
    public void shoot(){
        if (shot == true){
            bullet.x++;
            
        }
    }    
    @Override
    public void run(){
        try{
            while(true){
                shoot();
                Thread.sleep(3);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}