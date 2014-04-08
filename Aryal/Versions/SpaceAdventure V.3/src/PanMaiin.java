
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
    ImageIcon ii = new ImageIcon(this.getClass().getResource("Space.png"));
    Image img = ii.getImage();
    ImageIcon iii = new ImageIcon(this.getClass().getResource("asteroids.png"));
    Image img2 = iii.getImage();
    private int nx = 1001, ny = 100;  // top-left (x, y)
    private int nSize = 250;        // width and height
    private int nSpeed = 3, nYSpeed = 5; // displacement per step in x, y
    private static final int nUPDATE_PERIOD = 50; // milliseconds
    int[] arnImageX = new int[10];

    public PanMaiin() {
        //http://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html#animation
        ActionListener updateTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                update();   // update the (x, y) position
                repaint();  // Refresh the JFrame, callback paintComponent()
            }
        };
        // Allocate a Timer to run updateTask's actionPerformed() after every delay msec
        new Timer(nUPDATE_PERIOD, updateTask).start();
        addKeyListener(new TAdapter());
        setFocusable(true);

        setDoubleBuffered(true);

        craft = new Spacecraft();

        timer = new Timer(5, this);
        timer.start();
    }

    public int randomX() {
        Random rand = new Random();
        int randomNum = rand.nextInt((1300 - 1001) + 1) + 1001;
        return randomNum;
    }

    public void update() {
        nx -= nSpeed;
        System.out.println(nx);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(img2, nx, ny, 50, 75, this);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);

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
