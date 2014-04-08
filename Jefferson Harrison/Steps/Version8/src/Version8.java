//Dave J and Sean H


//THIS VERSION:  TWO NUMBERS INPUT ONLY

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Version8 extends JFrame {

    public static String sButtonPressed = "";
    public static String sWorkingNum1 = "";
    public static double dButtonPressed = 0;
    public static double dWorkingNum1 = 0;
    public static double dWorkingNum2 = 0;
    public static double dWorkingNum3 = 0;
    
    public static int nAction = 0;
        //if == 0, clear everything, if == 1, addition, if == 2, subtraction, if == 3, multiplication, if == 4, division

   public Version8() {

        final TextField tfMain = new TextField("", 14);
            //new text field to display calculations
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
        
        final JButton btnPlus = new JButton("+");
        
        final JButton btnMinus = new JButton("-");
        
        final JButton btnMultiply = new JButton("*");
        
        final JButton btnDivide = new JButton("/");
        
        final JButton btnEquals = new JButton("=");
        
        final JButton btnClear = new JButton("CE");

        
        //this section on GridBagLayout from Grondin's website
       setLayout(new GridBagLayout());
       
       
       GridBagConstraints c1 = new GridBagConstraints();
       c1.fill = GridBagConstraints.HORIZONTAL;
       
       //relative coordinates of components, (0,0) being top left
       c1.gridx = 0;
       c1.gridy = 0;
       
       c1.gridwidth = 3;
       
       //adds component to the frame in the GridBagLayout
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
       
       c7.gridx = 5;
       c7.gridy = 3;
       add(btnClear, c7);
       
       /*
    public static String sButtonPressed;
    public static String sWorkingNum1;
    public static String sWorkingNum2;
    public static double dButtonPressed;
    public static double dWorkingNum1;
    public static double dWorkingNum2;
    public static double dWorkingNum3;
    public static int nAction = 0;
        //if == 0, clear everything, if == 1, addition, if == 2, subtraction, if == 3, multiplication, if == 4, division
        */
       
       class Nums implements ActionListener {

           @Override //adding this line fixes warning
           public void actionPerformed(ActionEvent event) {
               sButtonPressed = event.getActionCommand();//gets label of the button that was pressed (They are all numerical, can be converted to int/double)
               sWorkingNum1 += sButtonPressed;//accumulates digits entered into number
               dWorkingNum1 = Double.parseDouble(sWorkingNum1); //ERROR: 'Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: For input string: "null4"' points to this line of code
                                                                //as well as 35 others in Java's pre-existing methods
               tfMain.setText(tfMain.getText() + sButtonPressed);
                    //accumulates numbers being input in text field
           }
       }
       //assigns action listener "Nums" to buttons
       ActionListener nums = new Nums();
       btn1.addActionListener(nums);
       btn2.addActionListener(nums);
       btn3.addActionListener(nums);
       btn4.addActionListener(nums);
       btn5.addActionListener(nums);
       btn6.addActionListener(nums);
       btn7.addActionListener(nums);
       btn8.addActionListener(nums);
       btn9.addActionListener(nums);
       
       class Calc implements ActionListener {

           @Override //adding this line fixes warning
           public void actionPerformed(ActionEvent event) {
               sButtonPressed = event.getActionCommand();
               if (sButtonPressed.equals("+")){
                   dWorkingNum2 = dWorkingNum1;
                   dWorkingNum1 = 0;//sets dWorkingNum2 to the first number inputted so that dWorkingNum1 can be reused for the second number
                   nAction = 1;//signifies that addition will take place when "equals" button is pressed
                   tfMain.setText(tfMain.getText() + " + ");
               }
               else if (sButtonPressed.equals("-")){
                   dWorkingNum2 = dWorkingNum1;
                   dWorkingNum1 = 0;
                   nAction = 2;//signifies that subtraction will take place when "equals" button is pressed
                   tfMain.setText(tfMain.getText() + " - ");
               }
               else if (sButtonPressed.equals("*")){
                   dWorkingNum2 = dWorkingNum1;
                   dWorkingNum1 = 0;
                   nAction = 3;//signifies that multiplication will take place when "equals" button is pressed
                   tfMain.setText(tfMain.getText() + " * ");
               }
               else if (sButtonPressed.equals("/")){
                   dWorkingNum2 = dWorkingNum1;
                   dWorkingNum1 = 0;
                   nAction = 4;//signifies that division will take place when "equals" button is pressed
                   tfMain.setText(tfMain.getText() + " / ");
               }
               else if (sButtonPressed.equals("CE")){
                   sWorkingNum1 = "";
                   dWorkingNum1 = 0;
                   dWorkingNum2 = 0;
                   dWorkingNum3 = 0;
                   nAction = 0;
                   tfMain.setText("");
                        //clears everything
               }
               else if (sButtonPressed.equals("=")){
                   if (nAction == 1){
                       dWorkingNum2 = dWorkingNum1 + dWorkingNum2;
                       tfMain.setText(tfMain.getText() + " = " + dWorkingNum3);
                            //adds numbers and displays to text field
                   }
                   else if (nAction == 2){
                       dWorkingNum2 = dWorkingNum1 - dWorkingNum2;
                       tfMain.setText(tfMain.getText() + " = " + dWorkingNum3);
                       //subtracts numbers and displays to text field
                   }
                   else if (nAction == 3){
                       dWorkingNum2 = dWorkingNum1 * dWorkingNum2;
                       tfMain.setText(tfMain.getText() + " = " + dWorkingNum3);
                       //multiplies numbers and displays to text field
                   }
                   else if (nAction == 4){
                       dWorkingNum2 = dWorkingNum1 / dWorkingNum2;
                       tfMain.setText(tfMain.getText() + " = " + dWorkingNum3);
                       //divides numbers and displays to text field
                   }
               }
           }
       }
       //assigns action listener "Calc" to buttons
       ActionListener calc = new Calc();
       btnPlus.addActionListener(calc);
       btnMinus.addActionListener(calc);
       btnMultiply.addActionListener(calc);
       btnDivide.addActionListener(calc);
       btnEquals.addActionListener(calc);
       btnClear.addActionListener(calc);
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         // Exit the program when the close-window button clicked
      setTitle("Calc - Version8");  //window title
      setSize(300, 300);   //size of window
      setResizable(false); //User cannot change window size
      setVisible(true);    //window is visible
   }
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override //adding this line fixes warning
         public void run() {
            new Version8();  // call "Version8" class
         }
      });
   }
}