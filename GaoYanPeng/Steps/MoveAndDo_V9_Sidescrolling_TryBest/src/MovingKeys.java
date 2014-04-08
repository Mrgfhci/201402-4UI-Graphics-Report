
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingKeys extends JPanel implements KeyListener, Runnable {

    //Timer t = new Timer(5, this);
    public static int x = 0, y = 0, velx = 0, vely = 0;
    public static int turbo = 1;
    public static int nPic = 0;
    
    //int nCounter = 0;
    public static Rectangle2D user;
    public Image img;

    public MovingKeys() {
        addKeyListener(this);
        setFocusable(true);
        //setFocusTraversalKeysEnabled(false);
        x = 0;
        y = 0;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        user = new Rectangle2D.Double(0, y, 40, 40); // x coord doesnt move
        g2.fill(user);
        
    }

    public void move() {
        repaint();
        x += velx * turbo;
        y += vely * turbo;
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
        }
        if (nCode == KeyEvent.VK_DOWN) {

            down();
        }
        if (nCode == KeyEvent.VK_LEFT) {
            left();
        }
        if (nCode == KeyEvent.VK_RIGHT) {
            right();
//        } else {
//            vely = 0;
//            velx = 0;
        }if (nCode == KeyEvent.VK_Z){
            turbo  = 2;
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
        }if (nCode == KeyEvent.VK_Z){
            turbo =1 ;
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
