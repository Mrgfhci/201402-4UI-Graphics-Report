
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

// V1 progress: keys movement now smooth
// collosion detection with 2 differ shape
// boundaries are set
public class KeysMovement {

    public static void main(String[] args) {
        MovingKeys kmove = new MovingKeys();
        JFrame datFrame = new JFrame();
        //Thread ball = new Thread(b);
        //ball.start();
        datFrame.add(kmove);
        datFrame.setVisible(true);
        datFrame.setSize(500, 500);
        datFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        datFrame.setTitle("Hello");
    }
}

class MovingKeys extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);
    double x = 0, y = 0, velx = 0, vely = 0;
    int nCounter = 0;
    String yousuck = "";

    public MovingKeys() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
        g2.fill(circle);

        Rectangle2D rect = new Rectangle2D.Double(200, 200, 30, 30);
        g2.setPaint(Color.RED);
        g2.fill(rect);
        g2.draw(rect);
        g.drawString(Integer.toString(nCounter), 20, 200);
        if (circle.intersects(rect)) {
            x = 0;
            y = 0;
            stop();
            //g.drawString("YOU SUCK!!", 175, 75);
            yousuck = "yousuck";

        }
        g.drawString(yousuck, 40, 210);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
}
