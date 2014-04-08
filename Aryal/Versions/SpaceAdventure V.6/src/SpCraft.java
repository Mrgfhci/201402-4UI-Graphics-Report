
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class SpCraft {

    private int nDispX;
    private int nDispY;
    private int nX;
    private int nY;
    private final Image imgCraft;
    private final ArrayList arlAste;

    public SpCraft() {
        ImageIcon iiCraft = new ImageIcon(this.getClass().getResource("Assets/Spacecraft.png"));
        imgCraft = iiCraft.getImage();
        arlAste = new ArrayList();
    }

    public void move() {
        nX += nDispX;
        nY += nDispY;
    }

    public int getX() {
        return nX;
    }

    public int getY() {
        return nY;
    }

    public void setX(int nNum) {
        nX = nNum;
    }

    public void setY(int nNum) {
        nY = nNum;
    }

    public Image getImage() {
        return imgCraft;
    }

    public ArrayList getAsteroids() {
        return arlAste;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            nDispX = -3;
        }

        if (key == KeyEvent.VK_RIGHT) {
            nDispX = 3;
        }

        if (key == KeyEvent.VK_UP) {
            nDispY = -3;
        }

        if (key == KeyEvent.VK_DOWN) {
            nDispY = 3;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            nDispX = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            nDispX = 0;
        }

        if (key == KeyEvent.VK_UP) {
            nDispY = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            nDispY = 0;
        }
    }
//Have to put addAste here since I'd have to put in X and Y if I want to call this from Asteroids class

    public void addAste() {
        Random random = new Random();
        int nRandomY = random.nextInt((500 - 0) + 1) + 0;
        arlAste.add(new Asteriods(1000, nRandomY));//Add X and Y (random y)
    }
}
