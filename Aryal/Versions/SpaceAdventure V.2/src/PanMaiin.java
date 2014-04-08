
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanMaiin extends JPanel {

    private final Spacecraft craft;
    ImageIcon ii = new ImageIcon(this.getClass().getResource("Space.png"));
    Image img = ii.getImage();
    ImageIcon iii = new ImageIcon(this.getClass().getResource("asteroids.png"));
    Image img2 = iii.getImage();
    private final int nx = 800, ny = 100;

    public PanMaiin() {

        craft = new Spacecraft();
        repaint();
    }
//http://zetcode.com/tutorials/javagamestutorial/movingsprites/
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

}
