//Brandon Chester
//Version 0.3
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class v03 extends JFrame {

    private JLabel lblName1;
    private JLabel lblName2;
    private JButton btnClick1;
    private JButton btnClick2;

    v03() { // constructor
        setLayout(new FlowLayout());
        lblName1 = new JLabel("old");
        add(lblName1);
        btnClick1 = new JButton("New and Improved");
        add(btnClick1);
        btnClick2 = new JButton("New and Improved Also");
        add(btnClick2);
        lblName2 = new JLabel("old also");
        add(lblName2);
        event1 e1 = new event1(); // the event class will be defined later
        btnClick1.addActionListener(e1);
        event2 e2 = new event2(); // the event class will be defined later
        btnClick2.addActionListener(e2);
    }

    public class event1 implements ActionListener { // must override the ActionPerformed method

        @Override
        public void actionPerformed(ActionEvent e) {
            lblName1.setText("New and Improved");
        }
    }

    public class event2 implements ActionListener { // must override the ActionPerformed method

        @Override
        public void actionPerformed(ActionEvent e) {
            lblName2.setText("New and Improved2");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        v03 fraEvents = new v03();
        fraEvents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fraEvents.setSize(400, 600);
        fraEvents.setVisible(true);
    }
}
