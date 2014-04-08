
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;

// V1 progress: keys movement now smooth
// collosion detection with 2 differ shape
// boundaries are set
public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PanMain panMain = new PanMain();
        frame.setSize(500, 500);
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panMain);
        panMain.requestFocusInWindow();
        frame.setResizable(false);
        frame.setVisible(true);
        //frame.setFocusable(true);
        frame.addKeyListener(new AL());
    }
}
class AL extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            PanDisp.mK.keyPressed(e);
            PanDisp.sB.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            PanDisp.mK.keyReleased(e);
            PanDisp.sB.keyReleased(e);
        }
    }