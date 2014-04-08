
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Asteriods {

    private final String asteriod = "asteroids.png";
    private final Spacecraft craft = new Spacecraft();
    private final Image image;
    private int x, y;  // top-left (x, y)
    private int size = 250;        // width and height
    private int xSpeed = 3; // displacement per step in x, y

    public Asteriods() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(asteriod));
        image = ii.getImage();
        x = 1001;
        y = 100;

    }

    public void update() {
        x -= xSpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int nNum) {
        y = nNum;
    }

    public void setX(int nNum) {
        x = nNum;
    }

    public Image getImage() {
        return image;
    }
}
