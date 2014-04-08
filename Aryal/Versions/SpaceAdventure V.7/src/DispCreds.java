
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DispCreds extends JPanel {

    Image imgSpSc;
    //http://stackoverflow.com/questions/10630738/how-to-set-strings-font-size-style-in-java-using-font-class (2nd answer)
    Font myFont = new Font("Serif", Font.BOLD, 30);

    public DispCreds() {
        ImageIcon iiSpSc = new ImageIcon(this.getClass().getResource("Assets/Splash.png"));
        imgSpSc = iiSpSc.getImage();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imgSpSc, 0, 0, null);
        g2d.setColor(Color.cyan);
        g2d.setFont(myFont);
            g2d.drawString("Credits:", 300, 110);
            g2d.drawString("Gaurab Aryal for everything", 300, 150);
            g2d.drawString("Code credits given in the project", 300, 180);
        }
}
