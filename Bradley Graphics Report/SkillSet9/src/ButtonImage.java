
//import static GridBagLayoutDemo.RIGHT_TO_LEFT;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonImage {
    //BufferedImage buttonIcon = ImageIO.read(new File("buttonIconPath"));
    //button = new JButton(new ImageIcon(buttonIcon));

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
        c.fill = GridBagConstraints.VERTICAL;
        c.ipady = 50;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton(image);
        //button.setIcon(new javax.swing.ImageIcon(getClass().getResource("Wire.png")));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        c.fill = GridBagConstraints.HORIZONTAL;//add it to the layout
        c.weightx = 0.5;//fill the horizontal space
        c.gridx = 1;//where it should be in the grid x
        c.gridy = 0;//where it should be in the grid y
        pane.add(button, c);
//I

    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ButtonImage");
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