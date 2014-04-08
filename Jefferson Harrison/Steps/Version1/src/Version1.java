//Dave J and Sean H

import java.awt.*;
import javax.swing.*;
public class Version1 extends JFrame {
    
    public Version1() {
        
        String arsOptions[] = {"Addition","Subtraction","Multiplication","Division"};
        
        //The following is a modified section of code originally from
        //http://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
        
        Container cp = this.getContentPane(); //this creates a space to hold
                                              //the visual componets
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         // Exit the program when the close-window button clicked
        setTitle("Main Frame");  //sets the title of the window
        setSize(600, 300);   //sets the size of the window
        
        setResizable(false); //prevents the user from changing window size
            //This line taken from: http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridLayoutDemoProject/src/layout/GridLayoutDemo.java
        
        setVisible(true);    //makes the window visible
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Version1(); //calls the "Version2" class
         }
      });
    }
    //Here ends the section of code used from http://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
}