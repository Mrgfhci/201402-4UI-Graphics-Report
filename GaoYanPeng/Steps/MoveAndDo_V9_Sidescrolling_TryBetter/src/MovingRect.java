
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingRect extends JPanel implements Runnable {
    public static int y = 200, x= 200, yVel= 3;
    public static Rectangle2D rect;
    public static boolean isHit = false;

    public MovingRect() {
        x = 19 + (int)(Math.random() * ((460 - 1) + 1));
        y = 19 + (int)(Math.random() * ((460 - 1) + 1));
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        rect = new Rectangle2D.Double(x, y, 30, 30);
        g2.setPaint(Color.RED);
        g2.fill(rect);
        g2.draw(rect);
        if ((MovingKeys.user).intersects(rect)) {
            MovingKeys.x = 0; 
            MovingKeys.y = 0;
            PanDisp.nPoints = 0;
            PanStats.sLose = "YouLose";

        }if (isHit == true){
            x = 19 + (int)(Math.random() * ((460 - 1) + 1));
            isHit = false;

        } if (x <= 20){
            x = 50+ (int)(Math.random() * ((460 - 1) + 1));
        }
    }

    public void move() {
        x -=(3 * MovingKeys.turbo);
        
        if ( y<= 0)
            yVel *= -1;
        if (y >= 450)
            yVel *= -1;
        y += yVel *3;
        repaint();
    }
    @Override
     public void run(){
        try{
            while(true){
                move();
                Thread.sleep(20);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}
