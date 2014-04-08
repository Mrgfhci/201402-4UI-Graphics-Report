
import java.awt.Image;
import javax.swing.ImageIcon;

public class SpaceBg {

    private final int nDispX = 1;
    private int nFX, nSX;
    private final int nY;
    private final Image imgSpace;

    public SpaceBg() {
        ImageIcon iiSpace = new ImageIcon(this.getClass().getResource("Assets/Space.png"));
        imgSpace = iiSpace.getImage();
        nFX = 0;
        nSX = nFX + 980;
        nY = 0;
    }

    public void moveX() {
        nFX -= nDispX;
        nSX -= nDispX;
    }

    public void updateX() {
        nFX = nSX + 980;
    }

    public void updatesX() {
        nSX = nFX + 980;
    }

    public int getX() {
        return nFX;
    }

    public int getsX() {
        return nSX;
    }

    public int getY() {
        return nY;
    }

    public Image getImage() {
        return imgSpace;
    }

}
