
import java.awt.*;
import java.awt.event.*;
import java.awt.Rectangle.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShootBullets implements Runnable {

    int x, y, xDirection;
    int bx, by;
    boolean readyToFire, shot = false;
    Rectangle bullet;

    public ShootBullets() {
//        x = MovingKeys.x;
//        y = MovingKeys.y;
        //System.out.println(x + " " + y );
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (shot == true) {
            g2.setPaint(Color.GREEN);
            g2.fill(bullet);
            g2.draw(bullet);
            if (bullet.intersects(MovingRect.rect)) {
                bullet = new Rectangle(0, 0, 0, 0);
                shot = false;
                MovingRect.isHit = true;
            }
        }

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == e.VK_SPACE) {
            by = MovingKeys.y;
            bx = MovingKeys.x + 30;
            System.out.println(bx + " " + by);
            bullet = new Rectangle(bx, by, 3, 5);
            shot = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_SPACE) {
            if (bullet.x >= 500) {
                bullet = new Rectangle(0, 0, 0, 0);
                shot = false;
            }
        }
    }

    public void shoot() {
        if (shot == true) {
            //bullet.x++;
            if (MovingKeys.x > MovingRect.x){
                bullet.x --;
            }else{
                bullet.x ++;
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                shoot();
                Thread.sleep(3);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class Bullets {

    int x, y;
    Rectangle Bullet;

    public Bullets(int x, int y) {
        this.x = x;
        this.y = y;
    }
}