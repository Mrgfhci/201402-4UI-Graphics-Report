
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Asteriods {

    private final String sasteriod = "asteroids.png";
    private final Image imgimage;
    private int nx, ny;  // top-left (x, y)
    private int nsize = 250;        // width and height
    private int nxSpeed = 3; // displacement per step in x, y

    public Asteriods() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(sasteriod));
        imgimage = ii.getImage();
        nx = 1001;
        ny = 100;

    }

    public void update() {
        nx -= nxSpeed;
    }

    public int getX() {
        return nx;
    }

    public int getY() {
        return ny;
    }

    public void setY(int nNum) {
        ny = nNum;
    }

    public void setX(int nNum) {
        nx = nNum;
    }

    public Image getImage() {
        return imgimage;
    }
}
