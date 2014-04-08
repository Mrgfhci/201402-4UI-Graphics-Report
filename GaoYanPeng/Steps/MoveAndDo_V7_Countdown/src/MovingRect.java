
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingRect extends JPanel implements Runnable {
    //Timer t1 = new Timer(6, this);
    public static int y = 200, x= 200, yVel= 3;
    public static Rectangle2D rect;
    //int nCounter = 0;
    //public Ellipse2D circle;
    public static boolean isHit = false;

    public MovingRect() {
        //t1.start();
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
            Main.nPoints = 0;
          g.drawString("YOU SUCK!!", 175, 75);

        }if (isHit == true){
            x = 19 + (int)(Math.random() * ((460 - 1) + 1));
            //y =  19 + (int)(Math.random() * ((460 - 1) + 1));
            isHit = false;

        }
    }

    public void move() {
        
        if ( y<= 0)
            yVel *= -1;
        if (y >= 450)
            yVel *= -1;
        y += yVel;
        repaint();
    }
    @Override
     public void run(){
        try{
            while(true){
                move();
                Thread.sleep(5);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}
