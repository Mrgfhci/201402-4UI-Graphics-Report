
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
    double y = 200, yVel= 1;
    //int nCounter = 0;
    //public Ellipse2D circle;

    public MovingRect() {
        //t1.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(200, y, 30, 30);
        g2.setPaint(Color.RED);
        g2.fill(rect);
        g2.draw(rect);
        if ((MovingKeys.circle).intersects(rect)) {
            MovingKeys.x = 0; 
            MovingKeys.y = 0;
          g.drawString("YOU SUCK!!", 175, 75);

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
                Thread.sleep(2);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}
