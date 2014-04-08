/*Brandon Chester
 * The basic structure of this program was based on the line moving program from
 * section 4 of the below page. While it has been heavily changed and is nearly
 * unrecognizable, it did serve as my framework and deserves citation
 * http://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinalRelease {

    int nX;
    /*
     *Code for grabbing image from class folder to avoid referencing a specific
     *directory taken from the below website
     *http://www.dreamincode.net/forums/topic/109038-swing-imageicon/
     */
    ImageIcon iBall = new ImageIcon(getClass().getResource("Images/ball.png"));
    JLabel lblBall = new JLabel(iBall);
    JLabel lblX = new JLabel("The X coordinate of the ball is " + nX);
    JFrame fraMain = new JFrame();
    JPanel panMove = new JPanel(new FlowLayout());
    JPanel panBall = new JPanel(null);
    JPanel panCoordinate = new JPanel(new FlowLayout());
    JButton btnLeft = new JButton("Move Left");
    JButton btnRight = new JButton("Move Right");

    public static void main(String[] args) {
        FinalRelease finalRelease = new FinalRelease();
    }

    FinalRelease() {
        /*
         * Code for buttons based on button code from the below website
         * http://www.zentut.com/java-swing/java-swing-cardlayout/
         */
        class Move implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String sCommand = e.getActionCommand();
                if (sCommand.equals("Left")) {
                    //Keeps the ball from going out of the panel
                    if (nX >= 20) {
                        nX -= 20;
                    }
                }
                if (sCommand.equals("Right")) {
                    if (nX <= panBall.getWidth() - 64) {
                        nX += 20;
                    }
                }
                lblBall.setBounds(nX, panBall.getHeight() / 2 - 47, 64, 64);
                lblX.setText("The X coordinate of the ball is " + nX);
            }
        }
        ActionListener move = new Move();
        btnLeft.setActionCommand("Left");
        btnLeft.addActionListener(move);
        btnRight.setActionCommand("Right");
        btnRight.addActionListener(move);

        panMove.add(btnLeft);
        panBall.add(lblBall);
        panBall.setBackground(new Color(128, 128, 128));
        panCoordinate.add(lblX);
        panCoordinate.setBackground(new Color(200, 200, 200));
        panMove.add(btnRight);
        panMove.setBackground(new Color(200, 200, 200));
        fraMain.setLayout(new BorderLayout());
        fraMain.add(panBall, BorderLayout.CENTER);
        fraMain.add(panMove, BorderLayout.SOUTH);
        fraMain.add(panCoordinate, BorderLayout.NORTH);
        fraMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fraMain.setSize(1024, 768);
        fraMain.setTitle("Move an object Version 1.0");
        fraMain.setVisible(true);
        fraMain.setResizable(false);
        //Aligns the ball in the center of the panel vertically
        //For some reason the center panel is 10px shorter before a button press
        //So the amount subtracted to center the ball is 42 instead of 47
        lblBall.setBounds(0, panBall.getHeight() / 2 - 42, 64, 64);
    }
}