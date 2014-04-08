//Dave J and Sean H

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Version6 extends JFrame {

   public Version6() {
       
       //int arnBtn[] = 

        TextField tfMain = new TextField("", 14);
            //new text field, area for user to input number 1 for operation
        tfMain.setEditable(false); //prevent user from editing text field

        final JButton btn1 = new JButton("1");

        final JButton btn2 = new JButton("2");

        final JButton btn3 = new JButton("3");

        final JButton btn4 = new JButton("4");

        final JButton btn5 = new JButton("5");

        final JButton btn6 = new JButton("6");

        final JButton btn7 = new JButton("7");

        final JButton btn8 = new JButton("8");

        final JButton btn9 = new JButton("9");
        
        final JButton btnPlus = new JButton(" + ");
        
        final JButton btnMinus = new JButton(" - ");
        
        final JButton btnMultiply = new JButton(" * ");
        
        final JButton btnDivide = new JButton(" / ");
        
        final JButton btnEquals = new JButton(" = ");

        
        //this section on GridBagLayout from Grondin's website
       setLayout(new GridBagLayout());
       
       
       GridBagConstraints c1 = new GridBagConstraints();
       c1.fill = GridBagConstraints.HORIZONTAL;
       c1.gridx = 0;
       c1.gridy = 0;
       c1.gridwidth = 3;
       add(tfMain, c1);
       
       
       GridBagConstraints c2 = new GridBagConstraints();
       c2.fill = GridBagConstraints.HORIZONTAL;
       
       c2.gridx = 0;
       c2.gridy = 1;
       add(btn7, c2);
       
       c2.gridx = 1;
       c2.gridy = 1;
       add(btn8, c2);
       
       c2.gridx = 2;
       c2.gridy = 1;
       add(btn9, c2);
       
       GridBagConstraints c3 = new GridBagConstraints();
       c3.fill = GridBagConstraints.HORIZONTAL;
       
       c3.gridx = 0;
       c3.gridy = 2;
       add(btn4, c3);
       
       c3.gridx = 1;
       c3.gridy = 2;
       add(btn5, c3);
       
       c3.gridx = 2;
       c3.gridy = 2;
       add(btn6, c3);
       
       GridBagConstraints c4 = new GridBagConstraints();
       c4.fill = GridBagConstraints.HORIZONTAL;
       
       c4.gridx = 0;
       c4.gridy = 3;
       add(btn1, c4);
       
       c4.gridx = 1;
       c4.gridy = 3;
       add(btn2, c4);
       
       c4.gridx = 2;
       c4.gridy = 3;
       add(btn3, c4);
       
       
       GridBagConstraints c5 = new GridBagConstraints();
       c5.fill = GridBagConstraints.VERTICAL;
       
       c5.gridx = 4;
       c5.gridy = 1;
       add(btnPlus, c5);
       
       c5.gridx = 4;
       c5.gridy = 2;
       add(btnMinus, c5);
       
       
       GridBagConstraints c6 = new GridBagConstraints();
       c6.fill = GridBagConstraints.VERTICAL;
       
       c6.gridx = 5;
       c6.gridy = 1;
       add(btnMultiply, c6);
       
       c6.gridx = 5;
       c6.gridy = 2;
       add(btnDivide, c6);
       
       
       GridBagConstraints c7 = new GridBagConstraints();
       c7.fill = GridBagConstraints.HORIZONTAL;
       
       c7.gridx = 4;
       c7.gridy = 3;
       add(btnEquals, c7);
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         // Exit the program when the close-window button clicked
      setTitle("Calc - Version6");  //window title
      setSize(300, 300);   //size of window
      setResizable(false); //User cannot change window size
      setVisible(true);    //window is visible
   }
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override //adding this line fixes warning
         public void run() {
            new Version6();  // call "Version6" class
         }
      });
   }
}