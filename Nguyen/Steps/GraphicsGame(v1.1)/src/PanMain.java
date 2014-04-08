import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanMain extends JPanel implements ActionListener {   
    private Timer timer;
    private ImgSquare imgSquare;
    Rectangle hitBox;
    Rectangle pointBox;

    public PanMain() {
        Color lightBlue = new Color(150,150,255);
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(lightBlue);
        setDoubleBuffered(true);
        imgSquare = new ImgSquare();

        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {       
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(imgSquare.getImage(), imgSquare.getX(), imgSquare.getY(), this);
        g.setColor(Color.RED);
        //pointBox = new Rectangle(300, 300, 25, 25);
        g.fillOval(300,300,25,25);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void actionPerformed(ActionEvent e) {
        imgSquare.move();
        hitBox = new Rectangle(imgSquare.getX(),imgSquare.getY(),50,50);
        System.out.println(hitBox.y);
        repaint();  
    }
    
    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            imgSquare.keyReleased(e);
        }
        
        public void keyPressed(KeyEvent e) {
            imgSquare.keyPressed(e);
        }
    }

}