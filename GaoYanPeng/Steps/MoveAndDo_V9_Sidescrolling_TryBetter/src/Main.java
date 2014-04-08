import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


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
        frame.setResizable(true);
        frame.setVisible(true);
        frame.addKeyListener(new AL());
    }
}
// Below came from the pong game:  https://www.youtube.com/watch?v=E-CJYELJa88&list=PL6E90696571998DC2
// Much easier way to handle keylisteners
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