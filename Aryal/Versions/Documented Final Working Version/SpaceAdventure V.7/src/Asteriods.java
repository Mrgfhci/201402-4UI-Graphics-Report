
import java.awt.Image;

import javax.swing.ImageIcon;

public class Asteriods {

    boolean bVisible;
    private final Image imgAste;
    private int nX, nY;  // top-left (x, y)
    private final int nSpeed = 3;

    //Below constructor gets both x and y from 2D array list
    public Asteriods(int nXupdate, int nYupdate) {
        ImageIcon iiAste = new ImageIcon(this.getClass().getResource("Assets/asteroids.png"));
        imgAste = iiAste.getImage();
        bVisible = true;
        this.nX = nXupdate;
        this.nY = nYupdate;
    }

    public void update() {
        nX -= nSpeed;
        if (nX < -79) {
            bVisible = false;
        }
    }

    public int getX() {
        return nX;
    }

    public int getY() {
        return nY;
    }

    public void setY(int nNum) {
        nY = nNum;
    }

    public void setX(int nNum) {
        nX = nNum;
    }

    public boolean isVisible() {
        return bVisible;
    }

    public Image getImage() {
        return imgAste;
    }

}
