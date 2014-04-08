
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
    private int nSpeed = 3;
    boolean bRKeyCheck = false;
    private final Image imgCraft, imgCraftFor;
    private final ArrayList arlAste;

    public SpCraft() {
        ImageIcon iiCraftFor = new ImageIcon(this.getClass().getResource("Assets/Spacecraft.png"));
        ImageIcon iiCraft = new ImageIcon(this.getClass().getResource("Assets/Spacecraft2.png"));
        imgCraft = iiCraft.getImage();
        imgCraftFor = iiCraftFor.getImage();
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
        if (bRKeyCheck) {
            return imgCraftFor;
        } else {
            return imgCraft;
        }
    }

    public ArrayList getAsteroids() {
        return arlAste;
    }

    public int getSpeed() {
        return nSpeed;
    }

    public void updateSpeed(int nNum) {
        nSpeed = nNum;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            nDispX = -nSpeed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            nDispX = nSpeed;
            bRKeyCheck = true;
        }

        if (key == KeyEvent.VK_UP) {
            nDispY = -nSpeed;
        }

        if (key == KeyEvent.VK_DOWN) {
            nDispY = nSpeed;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            nDispX = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            nDispX = 0;
            bRKeyCheck = false;
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
        int nRandomY = random.nextInt((600 - (-3)) + 1) + (-3);
        arlAste.add(new Asteriods(1000, nRandomY));//Add X and Y (random y)
    }
}
