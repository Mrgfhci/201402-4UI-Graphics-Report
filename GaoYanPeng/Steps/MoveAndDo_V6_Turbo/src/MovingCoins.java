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

/**
 *
 * @author YanPeng
 */
public class MovingCoins extends JPanel implements Runnable{
        //Timer t1 = new Timer(6, this);
    int x, y;
    boolean isHit = false;
    //int nCounter = 0;
    //public Ellipse2D circle;

    public MovingCoins() {
        x = 450;
        y = 400;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D coin =  new Ellipse2D.Double(x, y, 20, 20);
        g2.setPaint(Color.YELLOW);
        g2.fill(coin);
        g2.draw(coin);
        if (coin.intersects(MovingKeys.user)) {
            //Main.nPoints += 1;
            isHit = true;
        }
    }

    public void move() {
        if (isHit == true){
            Main.nPoints += 1;
            x = 19 + (int)(Math.random() * ((460 - 1) + 1));
            y =  19 + (int)(Math.random() * ((460 - 1) + 1));
            isHit = false;
        }
        repaint();
    }
     public void run(){
        try{
            while(true){
                move();
                Thread.sleep(5);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}
