
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
public class ShootBullets extends JPanel implements Runnable {

    int x, y;
    boolean isShooting = false;
    //int nCounter = 0;
    //public Ellipse2D circle;

    public ShootBullets() {
        x = MovingKeys.x - 5;
        y = MovingKeys.y + 10;
    }

    public void draw(Graphics g) {
        Graphics2D g3 = (Graphics2D) g;
        if (isShooting == true) {
            Rectangle bullet = new Rectangle(x, y, 5, 5);
            g3.setPaint(Color.PINK);
            g3.fill(bullet);
            g3.draw(bullet);
        }
//        if (coin.intersects(MovingKeys.user)) {
//            //Main.nPoints += 1;
//            isHit = true;
//        }
    }

    public void move() {
        if (isShooting = true) {
            y--;
            repaint();
        }
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_SPACE) {
            isShooting = true;
            System.out.println("hey");
        }
    }

    public void keyReleased(KeyEvent e) {
        int nCode = e.getKeyCode();
        if (nCode == e.VK_SPACE) {
            isShooting = false;
            System.out.println("bye");
        }
    }

    public void run() {
        try {
            while (true) {
                move();
                Thread.sleep(4);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
