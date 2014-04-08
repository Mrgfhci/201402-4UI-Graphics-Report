
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanSplashSc extends JPanel {
    Image imgSpSc;

    public PanSplashSc() {
        ImageIcon iiSpSc = new ImageIcon(this.getClass().getResource("Assets/Splash.png"));
        imgSpSc = iiSpSc.getImage();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imgSpSc, 0, 0, null); 
    }
}
