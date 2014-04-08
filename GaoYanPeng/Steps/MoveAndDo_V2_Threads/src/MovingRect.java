
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingRect extends JPanel implements ActionListener {
    Timer t1 = new Timer(6, this);
    double y = 200, yVel= 1;
    //int nCounter = 0;
    //public Ellipse2D circle;

    public MovingRect() {
        t1.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(200, y, 30, 30);
        g2.setPaint(Color.RED);
        g2.fill(rect);
        g2.draw(rect);
//        if ((MovingKeys.circle).intersects(rect)) {
//            MovingKeys.x = 0; 
//            MovingKeys.y = 0;
//          //g.drawString("YOU SUCK!!", 175, 75);

//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if ( y<= 0)
            yVel *= -1;
        if (y >= getHeight() - 30)
            yVel *= -1;
        y += yVel;
        repaint();
    }
}
