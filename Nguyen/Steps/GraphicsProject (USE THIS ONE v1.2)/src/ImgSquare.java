
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class ImgSquare {

    private String imgSquare = "sqY.jpg";
    private static final int nWidth = 50;
    private static final int nHeight = 50;
    int nX = 0;
    int nY = 0;
    int nVX = 0;
    int nVY = 0;
    private PanGame panGame;
    private Image imgChar;

    public ImgSquare(PanGame panGame) {
        this.panGame = panGame;
        ImageIcon imgCharacter = new ImageIcon(this.getClass().getResource(imgSquare));
        imgChar = imgCharacter.getImage();
    }

    public Image getImage() {
        return imgChar;
    }

    // this method is called from PanGame. Movement with bounds checking.
    public void move() {
        if (nX + nVX > 0 && nX + nVX < panGame.getWidth() - nWidth) {
            nX += nVX;
        }
        if (nY + nVY > 0 && nY + nVY < panGame.getHeight() - nHeight) {
            nY += nVY;
        }
    }
    // both the keyReleased and keyPressed methods are defined here, but then are called from PanGame
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            nVX = 0;
            PanSouth.lblLeft.setVisible(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            nVX = 0;
            PanSouth.lblRight.setVisible(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            nVY = 0;
            PanSouth.lblUp.setVisible(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            nVY = 0;
            PanSouth.lblDown.setVisible(false);
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            nVX = -1;
            PanSouth.lblLeft.setVisible(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            nVX = 1;
            PanSouth.lblRight.setVisible(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            nVY = -1;
            PanSouth.lblUp.setVisible(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            nVY = 1;
            PanSouth.lblDown.setVisible(true);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(nX, nY, nWidth, nHeight);
    }

}
