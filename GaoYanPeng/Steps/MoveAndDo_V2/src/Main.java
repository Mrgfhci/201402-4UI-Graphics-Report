
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

// V1 progress: keys movement now smooth
// collosion detection with 2 differ shape
// boundaries are set
public class Main {

    public static void main(String[] args) {
        JFrame datFrame = new JFrame();
        MovingKeys kMove = new MovingKeys();
        datFrame.add(kMove);
        MovingRect rMove = new MovingRect();
        datFrame.add(rMove);
        datFrame.setVisible(true);
        datFrame.setSize(500, 500);
        datFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        datFrame.setTitle("Hello");

    }
}
