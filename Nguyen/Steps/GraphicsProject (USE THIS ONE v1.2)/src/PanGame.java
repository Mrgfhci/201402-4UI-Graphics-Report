
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanGame extends JPanel {

    Ball ball = new Ball(this);
    ImgSquare imgSquare = new ImgSquare(this);

    public PanGame() {
        setBackground(new Color(150, 150, 255));
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                imgSquare.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                imgSquare.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    // this method is continually called within the main loop.
    public void move() {
        imgSquare.move();
        ball.Spawn();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        ball.paint(g2d);
        g2d.drawImage(imgSquare.getImage(), imgSquare.nX, imgSquare.nY, this);
    }
}
