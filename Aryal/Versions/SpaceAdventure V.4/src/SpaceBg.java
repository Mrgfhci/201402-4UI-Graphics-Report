
import java.awt.Image;

import javax.swing.ImageIcon;

public class SpaceBg {

    private final String scraft = "Space.png";

    private final int nx;
    private final int ny;
    private final Image imgimage;

    public SpaceBg() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(scraft));
        imgimage = ii.getImage();
        nx = 0;
        ny = 0;
    }

    public int getX() {
        return nx;
    }


    public int getY() {
        return ny;
    }

    public Image getImage() {
        return imgimage;
    }

}
