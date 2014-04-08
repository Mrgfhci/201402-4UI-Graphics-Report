
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Spacecraft {

    private final String scraft = "Spacecraft.png";

    private int ndx;
    private int ndy;
    private int nx;
    private int ny;
    private final Image image;

    public Spacecraft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(scraft));
        image = ii.getImage();
        nx = 40;
        ny = 60;
    }


    public void move() {
        nx += ndx;
        ny += ndy;
    }

    public int getX() {
        return nx;
    }

    public int getY() {
        return ny;
    }
    public void setX(int nNum) {
        nx = nNum;
    }

    public void setY(int nNum) {
        ny = nNum;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            ndx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            ndx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            ndy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            ndy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            ndx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            ndx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            ndy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            ndy = 0;
        }
    }
}