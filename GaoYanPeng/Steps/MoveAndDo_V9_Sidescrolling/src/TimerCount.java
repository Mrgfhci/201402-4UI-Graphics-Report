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

public class TimerCount extends JPanel implements Runnable {
    public static int nTime = 10;

    public TimerCount() {
        //t1.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    public void move() {
       nTime --;
       //System.out.println(nTime);
        repaint();
    }
    @Override
     public void run(){
        try{
            while(true){
                move();
                Thread.sleep(1000);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}
