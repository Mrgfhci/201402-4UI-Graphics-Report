//Most structure and syntax came 
//from ics3ui.sgrondin.ca
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class graphicsP {

    private static int FRAME_HEIGHT = 500;
    private static int FRAME_WIDTH = 500;

    public static void main(String[] args) {

        JFrame fraFrame = new JFrame();
        fraFrame.setSize(FRAME_HEIGHT, FRAME_WIDTH);
        fraFrame.setTitle("Calculator!");
        fraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fraFrame.setVisible(true);
        PanMain panMain = new PanMain();
        fraFrame.add(panMain);
    }
}

class PanMain extends JPanel {

    PanDisp panDisp = new PanDisp();
    PanMath panMath = new PanMath();
    PadNums padNums = new PadNums();
    JLabel lblNums = new JLabel();
    String sDig, sNum = "", sNum2 = "", sSign = "", sSign2 = "", sAns;
    double dAns, dNum, dNum2;

    public PanMain() {
        setLayout(new BorderLayout());
        add(panMath, BorderLayout.SOUTH);
        add(panDisp, BorderLayout.CENTER);
        add(padNums, BorderLayout.WEST);
    }

    public class PanDisp extends JPanel {

        public PanDisp() {
        }
    }

    public class PadNums extends JPanel {

        JButton[] btnNums = new JButton[10];

        public PadNums() {
            setLayout(new GridLayout(4, 3));
            Numbers1 numbers1 = new Numbers1();
            for (int i = 0; i < 10; i++) {
                btnNums[i] = new JButton(String.valueOf(i));
                add(btnNums[i]);
                btnNums[i].addActionListener(numbers1);
            }
            /* How to do an array of buttons came from stack overflow:
             * http://stackoverflow.com/questions/9814566/array-that-holds-jbutton-objects
             */
        }

        class Numbers1 implements ActionListener {

            public void actionPerformed(ActionEvent event) {

                sDig = event.getActionCommand();
                if (sSign.equals("")) {
                    sNum += sDig.charAt(0);
                    lblNums.setText(sNum);
                } else {
                    sNum2 += sDig.charAt(0);
                    lblNums.setText(sNum2);
                }
                panDisp.add(lblNums);
                revalidate();
            }
        }
    }

    public class PanMath extends JPanel {

        JButton btnA = new JButton("+");
        JButton btnS = new JButton("-");
        JButton btnM = new JButton("x");
        JButton btnD = new JButton("/");
        JButton btnE = new JButton("=");
        JButton btnCE = new JButton("CE");

        public PanMath() {
            MathStuffListener mathStuffListener = new MathStuffListener();
            add(btnA);
            btnA.addActionListener(mathStuffListener);
            add(btnS);
            btnS.addActionListener(mathStuffListener);
            add(btnM);
            btnM.addActionListener(mathStuffListener);
            add(btnD);
            btnD.addActionListener(mathStuffListener);
            add(btnE);
            btnE.addActionListener(mathStuffListener);
            add(btnCE);
            btnCE.addActionListener(mathStuffListener);
        }

        class MathStuffListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                sSign = event.getActionCommand();
                if (sSign.equals("=")) {
                    dNum = Integer.parseInt(sNum);
                    dNum2 = Integer.parseInt(sNum2);
                    if (sSign2.equals("x")) {
                        dAns = dNum * dNum2;
                    }
                    if (sSign2.equals("/")) {
                        dAns = dNum / dNum2;
                    }
                    if (sSign2.equals("+")) {
                        dAns = dNum + dNum2;
                    }
                    if (sSign2.equals("-")) {
                        dAns = dNum - dNum2;
                    }
                    sAns = Double.toString(dAns);
                    lblNums.setText(sAns);
                    panDisp.add(lblNums);
                    sNum = sAns;
                    sNum2 = "";
             //       sSign = "";
                }
                sSign2 = event.getActionCommand();
                if (sSign2.equals("CE")) {
                    sNum = "";
                    sNum2 = "";
                    sSign = "";
                    sSign2 = "";
                    lblNums.setText("0");
                    panDisp.add(lblNums);
                }
                revalidate();
            }
        }
    }
}