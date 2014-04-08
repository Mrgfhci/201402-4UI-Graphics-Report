import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class ImgSquare {
    private String imgSquare = "sqY.jpg";
    private int nVelocityX;
    private int nVelocityY;
    private int nX;
    private int nY;
    private Image imgChar;
    static Rectangle hitBox;

    public ImgSquare() {
        ImageIcon pic = new ImageIcon(this.getClass().getResource(imgSquare));
        imgChar = pic.getImage();       
        nX = 40;
        nY = 60;
    }

    public void move() {
        if(nX + nVelocityX > 0 && nX+nVelocityX < 745) {
        nX += nVelocityX;
        }
        if(nY + nVelocityY > 0 && nY + nVelocityY < 420) {
        nY += nVelocityY;
        }
    }

    public int getX() {
        return nX;
    }

    public int getY() {
        return nY;
    }

    public Image getImage() {
        return imgChar;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                nVelocityX = -1;
                //System.out.println(nX);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                nVelocityX = 1;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
                nVelocityY = -1;     
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {       
                nVelocityY = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            nVelocityX = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            nVelocityX = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            nVelocityY = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            nVelocityY = 0;
        }
    }
}