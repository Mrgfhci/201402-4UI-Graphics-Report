//Brandon Chester
//Version 0.1
import java.awt.*;
import javax.swing.*;
 
public class v01 {
 
    public static void main(String[] args) {
        JPanel panCentre = new JPanel();
        JPanel panSouth = new JPanel();
        JPanel panNorth = new JPanel();
        JFrame frame = new JFrame("Version 0.1");
        panCentre.setBackground(new Color(0,255,255));
        frame.add(panNorth, BorderLayout.NORTH);
        frame.add(panCentre, BorderLayout.CENTER);
        frame.add(panSouth, BorderLayout.SOUTH);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }
}