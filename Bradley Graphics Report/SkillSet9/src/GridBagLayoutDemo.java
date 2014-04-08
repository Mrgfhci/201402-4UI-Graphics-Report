//http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutDemo {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    //ImageIcon image = new ImageIcon("Wire.png");

    public static void addComponentsToPane(Container pane) {
        ImageIcon image = new ImageIcon("Wire.png");
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
            c.fill = GridBagConstraints.VERTICAL;
        }

        button = new JButton("Button 1");
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.fill = GridBagConstraints.VERTICAL;
        c.ipady = 50;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton(new ImageIcon("Wire.png"));
        //Shows as an empty button w/ strange dimentions
        //http://stackoverflow.com/questions/4898584/java-using-an-image
        //-as-a-button
        c.fill = GridBagConstraints.HORIZONTAL;//add it to the layout
        c.weightx = 0.5;//fill the horizontal space
        c.gridx = 1;//where it should be in the grid x
        c.gridy = 0;//where it should be in the grid y
        pane.add(button, c);

        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("Button 6");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("Button 7");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("Button 8");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("Button 9");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(button, c);

        button = new JButton("Button 11");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(button, c);

        button = new JButton("Button 11");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(button, c);

        button = new JButton("Button 12");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 2;
        pane.add(button, c);

        //c.ipady = 0;       //Height
        //c.weighty = 1.0;   //request any extra vertical space   
        //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        //c.insets = new Insets(0,0,0,0);  //top padding
        //c.gridwidth = 2;   //2 columns wide
        //pane.add(button, c);
        //button.addActionListener(this);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}