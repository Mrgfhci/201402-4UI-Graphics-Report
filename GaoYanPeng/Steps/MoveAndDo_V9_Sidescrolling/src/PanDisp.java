
import javax.swing.JPanel;
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
import java.awt.BorderLayout;

/**
 *
 * @author YanPeng
 */
public class PanDisp extends JPanel{
   
    private Image dbImage;
    private Graphics dbg;
    static MovingKeys mK = new MovingKeys();
    static MovingRect mR = new MovingRect();
    static MovingCoins mC = new MovingCoins();
    static ShootBullets sB = new ShootBullets();
    static TimerCount tC = new TimerCount();
    static ScrollingBackground scBg = new ScrollingBackground();
    public static int nPoints = 0;

    public PanDisp() {
        //addKeyListener(new AL());
        Thread t1 = new Thread(mK);
        Thread t2 = new Thread(mR);
        Thread t3 = new Thread(mC);
        Thread t4 = new Thread(sB);
        Thread t5 = new Thread(tC);
        Thread t6 = new Thread (scBg);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {

        //g.drawString(Integer.toString(nPoints), 50, 50);
        //g.drawString(Integer.toString(TimerCount.nTime), 400, 50);
        //System.out.println(TimerCount.nTime);
        scBg.draw(g);
        mK.draw(g);
        mR.draw(g);
        mC.draw(g);
        sB.draw(g);
        if (TimerCount.nTime <= 0) {
            nPoints = 0;
            TimerCount.nTime = 10;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Thread.currentThread().interrupt();
//            }

        }
        //tC.draw(g);
        repaint();
    }
}
