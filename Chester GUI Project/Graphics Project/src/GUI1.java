//Testbed for learning the basics of setting up a graphical program
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class GUI1 {
 
    public static void main(String[] args) {
        final JPanel panCentre;
        final JPanel panLeft;
        final JPanel panRight;
        final JPanel panBottom;
        final JButton btnNext;
        final JButton btnPrevious;
        final String NEXT = "NEXT";
        final String PREVIOUS = "PREVIOUS";
        ImageIcon icon = new ImageIcon("H:/NetBeansProjects/GUI/Images/kyubey.png");
        Image img = icon.getImage();  
        Image newimg = img.getScaledInstance(960, 540,  java.awt.Image.SCALE_SMOOTH);  
        ImageIcon newIcon = new ImageIcon(newimg);
        JLabel label3 = new JLabel(newIcon);
        //The "frame" or Window
        JFrame frame = new JFrame("Graphics Test");
 
        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1 - Card 1"));
        card1.add(new JButton("Button 2 - Card 1"));
        card1.setBackground(new Color(255,0,0));
        card1.add(label3);
 
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField on Card 2", 20));
        card2.setBackground(new Color(0,255,0));
 
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Card 3"));
        card3.setBackground(new Color(0,0,255));
 
        //Create the panel that contains the "cards".
        panCentre = new JPanel(new CardLayout());
        panCentre.add(card1);
        panCentre.add(card2);
        panCentre.add(card3);
 
        class ControlActionListenter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (panCentre.getLayout());
                String cmd = e.getActionCommand();
                if (cmd.equals(NEXT)) {
                    cl.next(panCentre);
                } else if (cmd.equals(PREVIOUS)) {
                    cl.previous(panCentre);
                }
            }
        }
        ControlActionListenter cal = new ControlActionListenter();
 
        btnNext = new JButton("Next");
        btnNext.setActionCommand(NEXT);
        btnNext.addActionListener(cal);
 
        btnPrevious = new JButton("Previous");
        btnPrevious.setActionCommand(PREVIOUS);
        btnPrevious.addActionListener(cal);
 
        panBottom = new JPanel();
       // panBottom.add(btnNext);
        panBottom.add(btnPrevious);
        
        panLeft = new JPanel();
        panLeft.add(btnNext);
        
        panRight = new JPanel();
     //   panRight.add(label3);
        
        frame.add(panLeft, BorderLayout.WEST);
        frame.add(panRight, BorderLayout.EAST);
        frame.add(panCentre, BorderLayout.CENTER);
        frame.add(panBottom, BorderLayout.SOUTH);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 540);
        frame.setVisible(true);
    }
}

/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class v01 {

    public static void main(String[] args) {
        ResizeImage frame = new ResizeImage();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 270);
        frame.setVisible(true);
    }
}

class ResizeImage extends JFrame {

    JScrollPane scrollPane;
    ImageIcon icon;

    public ResizeImage() {
        icon = new ImageIcon("H:/NetBeansProjects/GUI/Images/kyubey.png");
        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null );
            }
        };
        JButton button = new JButton("button");
        panel.add(button);
        scrollPane = new JScrollPane(panel);
        setContentPane(scrollPane);
    }
}
*/