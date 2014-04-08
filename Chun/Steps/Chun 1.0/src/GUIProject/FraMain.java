package GUIProject;

import java.awt.*;
import javax.swing.*;

public class FraMain {
    public static void main(String[] args) {
        FraOne MainFrame = new FraOne();
       	MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	MainFrame.setVisible(true);
    }
}
class FraOne extends JFrame{
    public FraOne(){
        setTitle("Buttons, Buttons and Buttons!");
        setSize(600, 600);
        
        panMain panmain = new panMain();
        add(panmain, BorderLayout.CENTER);
        
        panButtons panbuttons = new panButtons();
        add(panbuttons, BorderLayout.SOUTH);
        
        panTop pantop = new panTop();
        add(pantop, BorderLayout.NORTH);
    }
}