package GUIProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class panButtons extends JPanel implements ActionListener{
    static String blueString = "Blue";
    static String redString = "Red";
    static String yellowString = "Yellow";
    static String mamaString = "CLICK ME";
    
    JPanel picture;
    
    public panButtons(){
        
        JRadioButton bBlue = new JRadioButton(blueString);
        bBlue.setActionCommand(blueString);
        bBlue.setSelected(true);
        
        JRadioButton bRed = new JRadioButton(redString);
        bRed.setActionCommand(redString);
        
        JRadioButton bYellow = new JRadioButton(yellowString);
        bYellow.setActionCommand(yellowString);
        
        JButton bMAMA = new JButton(mamaString);
        bMAMA.setActionCommand(mamaString);
        
        ButtonGroup group = new ButtonGroup();
        group.add(bBlue);
        group.add(bRed);
        group.add(bYellow);
        
        bBlue.addActionListener(this);
        bRed.addActionListener(this);
        bYellow.addActionListener(this);
        

        JPanel RadioPanel = new JPanel();
        RadioPanel.add(bBlue);
        RadioPanel.add(bRed);
        RadioPanel.add(bYellow);
        
        add(RadioPanel);
        setBackground(Color.ORANGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}