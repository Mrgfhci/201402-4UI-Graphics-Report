//Dave J and Sean H

import java.awt.*;
import javax.swing.*;
public class Version2 extends JFrame {
    
    private JTextField tfInput1;
    private JTextField tfInput2;
    private JTextField tfOutput;
    
    public Version2() {
        
        //The following is a modified section of code originally from
        //http://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
        
        Container cp = this.getContentPane(); //this creates a space to hold
                                              //the visual componets
        
        cp.setLayout(new FlowLayout()); //sets the layout to place new 
                                        //components in consecutive order
                                             //'First Number'
        tfInput1 = new JTextField("", 6); //creates a new text field of width
                                          //6 with no text
        tfInput1.setEditable(true); //allows the user to edit the text
        cp.add(tfInput1); //adds the text field to the container
        
        //Here ends the section of code used from exterior source
        
        tfInput2 = new JTextField("", 6);
        tfInput2.setEditable(true);
        cp.add(tfInput2);
        
        tfOutput = new JTextField("", 6);
        tfOutput.setEditable(false); //user cannot edit the result of operation
        cp.add(tfOutput);
        
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
            new Version2(); //calls the "Version2" class
         }
      });
    }
}