
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.math.*;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

//http://zetcode.com/tutorials/javagamestutorial/movingsprites/
public class PanMaiin extends JPanel implements ActionListener {

    private final Timer timer;
    private final Spacecraft craft;
    private final Asteriods aste;
    private final SpaceBg space;
    Random r = new Random();
    private static final int nUPDATE_PERIOD = 50; // milliseconds

    public PanMaiin() {
        addKeyListener(new TAdapter());
        setFocusable(true);

        setDoubleBuffered(true);

        craft = new Spacecraft();
        aste = new Asteriods();
        space = new SpaceBg();
        //http://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html#animation
        ActionListener updateTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                collision();
                aste.update();
                repaint();
            }
        };
        // Allocate a Timer to run updateTask's actionPerformed() after every delay msec
        new Timer(nUPDATE_PERIOD, updateTask)
                .start();
        timer = new Timer(5, this);

        timer.start();
    }

    public void collision() {
        Rectangle rect1 = new Rectangle(craft.getX(), craft.getY(),
                50, 75);
        Rectangle rect2 = new Rectangle(aste.getX(), aste.getY(), 75, 50);
        if (rect1.intersects(rect2)) {
            aste.setX(1001);
            aste.setY(craft.getY());
            craft.setX(0);
            craft.setY(0);
        }
    }

    public int randomX() {
        Random rand = new Random();
        int randomNum = rand.nextInt((1300 - 1001) + 1) + 1001;
        return randomNum;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(space.getImage(), space.getX(), space.getY(), getWidth(), getHeight(), this);

        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        if (aste.getX() < -79) {
            aste.setX(1000);
            aste.setY(craft.getY());//randomize? real rand is here...
        }
        g2d.drawImage(aste.getImage(), aste.getX(), aste.getY(), this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        craft.move();
        repaint();

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }

}
