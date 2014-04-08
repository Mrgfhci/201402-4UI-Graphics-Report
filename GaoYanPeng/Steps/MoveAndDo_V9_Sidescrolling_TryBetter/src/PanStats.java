
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
public class PanStats extends JPanel {

    private Image dbImage;
    private Graphics dbg;

    public static String sLose = "";
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
        String sFuel = Double.toString(MovingKeys.dFuel);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <3; i++){
            char cLet = sFuel.charAt(i);
            sb.append(cLet);
        }
        sFuel = sb.toString();
        g.drawString(" Points: " + Integer.toString(PanDisp.nPoints), 10, 10);
        g.drawString(" Time LEft " + Integer.toString(TimerCount.nTime), 400, 10);
        g.drawString(sLose, 40,10 );
         g.drawString("Fuel: " + sFuel, 100, 10);
        if (sLose.equals("YouLose")){
                        try {
                Thread.sleep(1000);
                sLose ="";
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        //System.out.println(TimerCount.nTime);
        repaint();
    }
}
