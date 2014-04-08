import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YanPeng
 */
public class PanStats extends JPanel{
        private Image dbImage;
    private Graphics dbg;
    public PanStats() {
        //addKeyListener(new AL());
        
        
    }

    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
        
    }

        @Override
    public void paintComponent(Graphics g) {

        g.drawString(Integer.toString(PanDisp.nPoints), 10, 10);
        g.drawString(Integer.toString(TimerCount.nTime), 400, 10);
        //System.out.println(TimerCount.nTime);
        repaint();
    }
}

