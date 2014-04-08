
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

// V1 progress: keys movement now smooth
// collosion detection with 2 differ shape
// boundaries are set
public class Main extends JFrame {

    private Image dbImage;
    private Graphics dbg;
    static MovingKeys mK = new MovingKeys();
    static MovingRect mR = new MovingRect();
    static MovingCoins mC = new MovingCoins();
    static ShootBullets sB = new ShootBullets();
    public static int nPoints = 0;

    public Main() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        addKeyListener(new AL());
    }

    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

     public void paintComponent(Graphics g) {
        g.drawString(Integer.toString(nPoints), 50, 50);
        sB.draw(g);
        mK.draw(g);
        mR.draw(g);
        mC.draw(g);
        repaint();
    }
     
        public class AL extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            mK.keyPressed(e);
            sB.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            mK.keyReleased(e);
            sB.keyPressed(e);
        }
    } 
    
    public static void main(String[] args) {
//        JFrame datFrame = new JFrame();
//        MovingKeys kMove = new MovingKeys();
//        datFrame.add(kMove);
//        MovingRect rMove = new MovingRect();
//        datFrame.add(rMove);
//        datFrame.setVisible(true);
//        datFrame.setSize(500, 500);
//        datFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        datFrame.setTitle("Hello");
        Main main = new Main();
        Thread t1 = new Thread(mK);  
        Thread t2 = new Thread (mR);
        Thread t3 = new Thread (mC);
        Thread t4 = new Thread (sB);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
