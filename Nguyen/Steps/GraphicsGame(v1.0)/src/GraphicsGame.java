/*Peter Nguyen*/
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.event.*;

public class GraphicsGame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(700, 500);
        frame.setTitle("Testing game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ComMovement comMovement = new ComMovement();
        frame.add(comMovement);
        frame.setVisible(true);
        comMovement.requestFocus();
    }
}

class ComMovement extends JComponent {
    int dX = (int)Math.random() * 625;
    int dY = (int)Math.random() * 450;
    
    public ComMovement() {
        guy = new Rectangle(dX,dY,75,25);
    }
    public void paintComponent(Graphics g) {
        // Recover Graphics2D 
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        g2.draw(guy);
        Ellipse2D point = new Ellipse2D.Double(Math.random()*690, Math.random()*490, 10, 10);
        g2.setColor(Color.RED);
        g2.fill(point);
        g2.fill(guy);
 
    }
    
    public void moveIt(int dx, int dy) {
        guy.translate(dx,dy);
        repaint();
        
    }
    private Rectangle guy;
}
