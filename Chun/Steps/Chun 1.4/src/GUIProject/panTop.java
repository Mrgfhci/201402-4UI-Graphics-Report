package GUIProject;

import java.awt.Color;
import javax.swing.*;

class panTop extends JPanel{
    JLabel Title = new JLabel("Press any button you want!");
    public panTop(){
        setBackground(Color.WHITE);
        add(Title);
    }
}