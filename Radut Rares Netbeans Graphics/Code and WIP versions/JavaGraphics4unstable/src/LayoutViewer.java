import java.awt.BorderLayout;
import javax.swing.JFrame;

public class LayoutViewer {

public static void main(String[] args) {
       JFrame frame = new JFrame();
       PanMain panMain = new PanMain();
       frame.setSize(800, 800);
       frame.setTitle("Graphics is Great");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().add(new PanDisp(ImgZappa));
       frame.add(panMain);
       frame.setVisible(true);
       }
}
