import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;


/**
 *
 * @author YanPeng
 */
public class MovingCoins extends JPanel implements Runnable{
    int x, y;
    boolean isHit = false;
    
    public MovingCoins() {
        x = 19 + (int)(Math.random() * ((460 - 1) + 1));
        y = 19 + (int)(Math.random() * ((460 - 1) + 1));
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D coin =  new Ellipse2D.Double(x, y, 20, 20);
        g2.setPaint(Color.YELLOW);
        g2.fill(coin);
        g2.draw(coin);
        if (coin.intersects(MovingKeys.user)) {
            isHit = true;
        }
    }

    public void move() {
        x --;
        if (x < 0){
            x = 19 + (int)(Math.random() * ((460 - 1) + 1));
            y =  19 + (int)(Math.random() * ((460 - 1) + 1));
        }
        if (isHit == true){
            PanDisp.nPoints += 1;
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
