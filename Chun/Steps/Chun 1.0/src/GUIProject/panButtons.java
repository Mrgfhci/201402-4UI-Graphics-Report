package GUIProject;

import java.awt.Color;
import javax.swing.*;

public class panButtons extends JPanel{
    JRadioButton bBlue = new JRadioButton("Blue");
    JRadioButton bRed = new JRadioButton("Red");
    JRadioButton bYellow = new JRadioButton("Yellow");
    public panButtons(){
        add(bBlue);
        add(bRed);
        add(bYellow);
        setBackground(Color.ORANGE);
    }
}