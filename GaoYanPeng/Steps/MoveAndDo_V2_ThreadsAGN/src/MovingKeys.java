
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

public class MovingKeys extends JPanel implements KeyListener, Runnable {

    //Timer t = new Timer(5, this);
    public static double x = 0, y = 0, velx = 0, vely = 0;
    //int nCounter = 0;
    String yousuck = "";
    public static Ellipse2D circle;

    public MovingKeys() {
        x = 0;
        y = 0;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        circle = new Ellipse2D.Double(x, y, 40, 40);
        g2.fill(circle);
    }

    public void move() {
        repaint();
        x += velx;
        y += vely;
        if (x > 450) {
            x = 450;
        }
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (y > 450) {
            y = 450;
        }
    }

    public void up() {
        vely = -1;
    }

    public void down() {
        vely = 1;
    }

    public void left() {
        velx = -1;
    }

    public void right() {
        velx = 1;
    }

    public void stop() {
        vely = 0;
        velx = 0;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int nCode = e.getKeyCode();
        if (nCode == KeyEvent.VK_UP) {
            up();
            yousuck = "";
        }
        if (nCode == KeyEvent.VK_DOWN) {

            down();
            yousuck = "";
        }
        if (nCode == KeyEvent.VK_LEFT) {
            left();
            yousuck = "";
        }
        if (nCode == KeyEvent.VK_RIGHT) {
            right();
//        } else {
//            vely = 0;
//            velx = 0;
            yousuck = "";
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int nCode = e.getKeyCode();
        if (nCode == KeyEvent.VK_UP) {
            vely = 0;
        }
        if (nCode == KeyEvent.VK_DOWN) {
            vely = 0;
        }
        if (nCode == KeyEvent.VK_LEFT) {
            velx = 0;
        }
        if (nCode == KeyEvent.VK_RIGHT) {
            velx = 0;
        }
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
