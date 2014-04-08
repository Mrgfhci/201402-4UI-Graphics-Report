
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

public class ScrollingBackground extends JPanel implements Runnable {


    public static int nPic = 0, nPic2 = 1480;
    public static boolean bs = false;
    public Image img, img2;

    public ScrollingBackground() {
        ImageIcon i = new ImageIcon("sky.jpg");
	img = i.getImage();
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawImage(img, nPic, 0, null);
        g2.drawImage(img, nPic2, 0, null);
        
        if (bs == true){
            g2.drawImage(img, nPic2, 0, null);
            g2.drawImage(img, nPic, 0, null);
        
        }
        
    }

    public void move() {
        nPic -=(1 * MovingKeys.turbo);
        nPic2 -=(1 * MovingKeys.turbo);

        
        if (nPic <= -1480){
            nPic = 1480;
            bs = true;
        }if (nPic2 <= -1480){
            nPic2= 1480;
            bs = false;
        }
    }

   
    public void run(){
        try{
            while(true){
                move();
                Thread.sleep(5);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}
