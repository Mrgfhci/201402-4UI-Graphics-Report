
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

//http://zetcode.com/tutorials/javagamestutorial/movingsprites/
public class PanMaiin extends JPanel implements ActionListener {

    private final Timer timerKey, timerSpace, timerAste;
    boolean bShow = true;
    int nHealth = 100, nTimeCt = 0, nDispTime = 0;
    Font myFont = new Font("Serif", Font.BOLD, 16);
    private final SpCraft spCraft;
    private final SpaceBg spaceBg;
    private static final int nUpdateSpace = 50, nUpdateAste = 300; // milliseconds
    ImageIcon iiFail = new ImageIcon(this.getClass().getResource("Assets/fail.png"));
    Image imgFail = iiFail.getImage();

    public PanMaiin() {
        addKeyListener(new TAdapter());
        setFocusable(true);

        setDoubleBuffered(true);

        spCraft = new SpCraft();
        spaceBg = new SpaceBg();
        //http://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html#animation
        timerSpace = new Timer(nUpdateSpace, updateSpace);
        timerAste = new Timer(nUpdateAste, upAste);
        timerKey = new Timer(5, this);
        timerSpace.start();
        timerAste.start();
        timerKey.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (bShow) {
            g2d.drawImage(spaceBg.getImage(), spaceBg.getX(), spaceBg.getY(),
                    getWidth(), getHeight(), this);
            g2d.drawImage(spaceBg.getImage(), spaceBg.getsX(), spaceBg.getY(),
                    getWidth(), getHeight(), this);
            if (spaceBg.getX() == - 980) {
                spaceBg.updateX();
            } else if (spaceBg.getsX() == -980) {
                spaceBg.updatesX();
            }
            if (spCraft.getX() < (-63)) {
                spCraft.setX(927);
            } else if (spCraft.getX() > 990) {
                spCraft.setX(-3);
            }
            if (spCraft.getY() < (-25)) {
                spCraft.setY(519);
            } else if (spCraft.getY() > 530) {
                spCraft.setY(-14);
            }
            g2d.drawImage(spCraft.getImage(), spCraft.getX(), spCraft.getY(), this);
            ArrayList arlAste = spCraft.getAsteroids();

            for (int i = 0; i < arlAste.size(); i++) {
                Asteriods asteroids = (Asteriods) arlAste.get(i);
                g2d.drawImage(asteroids.getImage(), asteroids.getX(), asteroids.getY(), this);
            }
            //http://way2java.com/awt-graphics/4891/
            g2d.setColor(Color.red);
            g2d.fill3DRect(880, 5, 100, 10, true);
            g2d.setColor(Color.GREEN);
            g2d.fill3DRect(880, 5, nHealth, 10, true);
            g2d.setColor(Color.black);
            g2d.drawString("Health", 913, 14);
            g2d.setColor(Color.blue);
            g2d.fill3DRect(880, 20, 100, 10, true);
            g2d.setColor(Color.cyan);
            g2d.fill3DRect(880, 20, 100 - nHealth, 10, true);
            g2d.setColor(Color.yellow);
            g2d.drawString("Asteroids", 913, 29);
            g2d.setColor(Color.cyan);
            g2d.setFont(myFont);
            g2d.drawString("Time Survived: " + nDispTime + "s", 450, 15);
        } else {
            g2d.drawImage(imgFail, 0, 0, getWidth(), getHeight(), this);
            g2d.setColor(Color.cyan);
            g2d.setFont(myFont);
            g2d.drawString("Total Time Survived: " + nDispTime + "s", 450, 250);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //http://zetcode.com/tutorials/javagamestutorial/movingsprites/ (Missile shooting)
        ArrayList arlAste = spCraft.getAsteroids();
        for (int i = 0; i < arlAste.size(); i++) {
            Asteriods asteroid = (Asteriods) arlAste.get(i);
            // http://stackoverflow.com/questions/335600/collision-detection-between-two-images-in-java (First Answer)
            Rectangle rctCraft = new Rectangle(spCraft.getX(), spCraft.getY(),
                    50, 30);
            Rectangle rctAste = new Rectangle(asteroid.getX(), asteroid.getY(), 50, 30);
            if (rctCraft.intersects(rctAste)) {
                spCraft.setX(0);
                spCraft.setY(0);
                if ((nHealth - 20) < 0) {
                    timerSpace.stop();
                    timerAste.stop();
                    bShow = false;
                }
                nHealth -= 20;//6 lives
                if (nHealth == 60 || nHealth == 20) {
                    spCraft.updateSpeed((int) (spCraft.getSpeed())+1);
                }
                arlAste.clear();//clear all asteroids
                if ((timerAste.getDelay() - 100) > 0) {
                    timerAste.setDelay(timerAste.getDelay() - 25);

                }
            }
            if (asteroid.isVisible()) {
                asteroid.update();
            } else {
                arlAste.remove(i);
            }
        }
        spCraft.move();
        repaint();

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spCraft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spCraft.keyPressed(e);
        }
    }
    ActionListener upAste = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            spCraft.addAste();
            repaint();
        }
    };
    ActionListener updateSpace = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            nTimeCt += 50;
            if ((nTimeCt / 50) == 20) {// if 1 sec
                nTimeCt = 0;
                nDispTime += 1;
            }
            spaceBg.moveX();
            repaint();
        }
    };

}
