//Brandon Chester
//Version 0.5
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class V05 {

    int nX;
    ImageIcon ball = new ImageIcon("H:/NetBeansProjects/GUI/Images/ball.png");
    JLabel lblBall = new JLabel(ball);
    JLabel lblX = new JLabel("The X coordinate of the ball is " + nX);
    JFrame fraMain = new JFrame();
    JPanel panSouth = new JPanel(new FlowLayout());
    JPanel panCenter = new JPanel(null);
    JPanel panNorth = new JPanel(new FlowLayout());
    JButton btnLeft = new JButton("Move Left");
    JButton btnRight = new JButton("Move Right");

    public static void main(String[] args) {
        V05 v05 = new V05();
    }

    V05() {
        class Left implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Keeps the ball from going out of the panel
                if (nX >= 20) {
                    nX -= 20;
                    lblBall.setBounds(nX, panCenter.getHeight() / 2 - 47, 140, 95);
                    lblX.setText("The X coordinate of the ball is " + nX);
                }
            }
        }
        ActionListener left = new Left();
        btnLeft.addActionListener(left);
        class Right implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                //The minus 160 accounts for the width of the object which is
                //140px, and for how much it moves which is 20px
                if (nX <= panCenter.getWidth() - 160) {
                    nX += 20;
                    lblBall.setBounds(nX, panCenter.getHeight() / 2 - 47, 140, 95);
                    lblX.setText("The X coordinate of the ball is " + nX);
                }
            }
        }
        ActionListener right = new Right();
        btnRight.addActionListener(right);
        panSouth.add(btnLeft);
        panCenter.add(lblBall);
        panCenter.setBackground(new Color(128, 128, 128));
        panNorth.add(lblX);
        panSouth.add(btnRight);
        fraMain.setLayout(new BorderLayout());
        fraMain.add(panCenter, BorderLayout.CENTER);
        fraMain.add(panSouth, BorderLayout.SOUTH);
        fraMain.add(panNorth, BorderLayout.NORTH);
        fraMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fraMain.setSize(1024, 768);
        fraMain.setTitle("Move an object");
        fraMain.setVisible(true);
        fraMain.setResizable(false);
        //Aligns the ball in the center of the panel vertically
        //For some reason the center panel is 10px shorter before a button press
        //So the amount subtracted to center the ball is 42 instead of 47
        lblBall.setBounds(0, panCenter.getHeight() / 2 - 42, 140, 95);
    }
}