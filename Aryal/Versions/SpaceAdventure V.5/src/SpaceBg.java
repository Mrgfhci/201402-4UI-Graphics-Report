
import java.awt.Image;

import javax.swing.ImageIcon;

public class SpaceBg {

    private final String scraft = "Space.png";

    private final int ndx = 1;
    private int nx, nsX;
    private final int ny;
    private final Image imgimage;

    public SpaceBg() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(scraft));
        imgimage = ii.getImage();
        nx = 0;
        nsX = nx + 980;
        ny = 0;
    }

    public void moveX() {
        nx -= ndx;
        nsX -= ndx;
    }

    public void updateX() {
        nx = nsX + 980;
    }

    public void updatesX() {
        nsX = nx + 980;
    }

    public int getX() {
        return nx;
    }

    public int getsX() {
        return nsX;
    }

    public int getY() {
        return ny;
    }

    public Image getImage() {
        return imgimage;
    }

}
