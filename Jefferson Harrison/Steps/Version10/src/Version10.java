//Dave J and Sean H

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Version10 extends JFrame {

    public static String sButtonPressed;
    public static String sWorkingNum1;
    public static String sWorkingNum2;
    public static double dButtonPressed;
    public static double dWorkingNum1;
    public static double dWorkingNum2;
 
   public Version10() {
       
       // GUI components set as final because error messages directed me to do so

        final TextField tfMain = new TextField("", 14);
            //new text field
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
        
        final JButton btn0 = new JButton("0");//Zero button
        
        final JButton btnPlus = new JButton("+");
        
        final JButton btnMinus = new JButton("-");
        
        final JButton btnMultiply = new JButton("*");
        
        final JButton btnDivide = new JButton("/");
        
        final JButton btnEquals = new JButton("=");
        
        final JButton btnCE = new JButton("CE");

        
        //this section on GridBagLayout from Grondin's website
       setLayout(new GridBagLayout());
       
       
       GridBagConstraints c1 = new GridBagConstraints();
       c1.fill = GridBagConstraints.HORIZONTAL;
       c1.gridx = 0;
       c1.gridy = 0;
       c1.gridwidth = 6;
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
       c5.fill = GridBagConstraints.HORIZONTAL;
       
       c5.gridx = 4;
       c5.gridy = 1;
       add(btnPlus, c5);
       
       c5.gridx = 4;
       c5.gridy = 2;
       add(btnMinus, c5);
       
       
       GridBagConstraints c6 = new GridBagConstraints();
       c6.fill = GridBagConstraints.HORIZONTAL;
       
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
       c7.gridwidth = 2;
       add(btnEquals, c7);
       
       GridBagConstraints c8 = new GridBagConstraints();
       c8.fill = GridBagConstraints.HORIZONTAL;
       
       c8.gridx = 0;
       c8.gridy = 4;
       c8.gridwidth = 3;
       add(btn0, c8);
       
       c8.gridx = 4;
       c8.gridy = 4;
       c8.gridwidth = 2;
       add(btnCE, c8);
       
       class ClickOutput implements ActionListener {

           @Override //adding this line fixes warning
           public void actionPerformed(ActionEvent event) {
               sButtonPressed = event.getActionCommand();
               //dButtonPressed = Double.parseDouble(sButtonPressed);
               tfMain.setText(tfMain.getText() + sButtonPressed);
           }
       }
       ActionListener clickOutput = new ClickOutput();
       btn1.addActionListener(clickOutput);
       btn2.addActionListener(clickOutput);
       btn3.addActionListener(clickOutput);
       btn4.addActionListener(clickOutput);
       btn5.addActionListener(clickOutput);
       btn6.addActionListener(clickOutput);
       btn7.addActionListener(clickOutput);
       btn8.addActionListener(clickOutput);
       btn9.addActionListener(clickOutput);
       btn0.addActionListener(clickOutput);
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         // Exit the program when the user clicks exit button
      setTitle("Calc - Version10");  //window title
      setSize(250, 250);   //size of window
      setResizable(false); //User cannot change window size
      setVisible(true);    //window is visible
   }
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override //adding this line fixes warning
         public void run() {
            new Version10();  // call "Version10" class
         }
      });
   }
}