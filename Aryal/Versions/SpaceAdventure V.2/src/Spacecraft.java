
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Spacecraft {

    private final String scraft = "Spacecraft.png";

    private int nx;
    private int ny;
    private final Image image;

    public Spacecraft() {
        //http://zetcode.com/tutorials/javagamestutorial/movingsprites/
        ImageIcon ii = new ImageIcon(this.getClass().getResource(scraft));
        image = ii.getImage();
        nx = 40;
        ny = 60;
    }

    public int getX() {
        return nx;
    }

    public int getY() {
        return ny;
    }

    public Image getImage() {
        return image;
    }

}
