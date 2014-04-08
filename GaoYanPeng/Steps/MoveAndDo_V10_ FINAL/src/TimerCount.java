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
    public static int nTime = 60;

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
                move(); // from http://stackoverflow.com/questions/3342651/how-can-i-delay-a-java-program-for-a-few-seconds 
                Thread.sleep(1000);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}
