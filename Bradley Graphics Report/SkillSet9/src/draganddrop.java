//http://stackoverflow.com/questions/1879214/dragging-a-circle-on-a-jframe
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class draganddrop extends JFrame {

    private static final long serialVersionUID = 1L;
    public static int nsize = 400;
    public static int nRad = 10;
    private int nx;
    private int ny;
    private int nX1;
    private int nY1;
    private int nX2;
    private int nY2;
    private MouseHandler mh;
    boolean bisCircleClicked = false;

    public static void main(String[] args) {
        draganddrop panel = new draganddrop();
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button;
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        button = new JButton("It's A Button Yo");
        c.ipady = 50;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        panel.add(button, c);
        //circle.setColor(Color.BLUE);
        //for(int i=0;i<=0;i++){
        //circle.fillOval(nX1 - nRad * 2, nY1 - nRad * 2, nRad * 3, nRad * 3);
        //}

    }

    public draganddrop() {
        super("Drag n Drop");
        nX1 = nRad + 100;//Set the position
        nY1 = nRad + 100;
        mh = new MouseHandler();
        addMouseListener(mh);
        addMouseMotionListener(mh);
        setSize(nsize, nsize);
        setVisible(true);

    }

    public void paint(Graphics circle) {


        super.paint(circle);
        //super.paint(circle);
        circle.setColor(Color.BLUE);
        //for(int i=0;i<=0;i++){
        circle.fillOval(nX1 - nRad * 2, nY1 - nRad * 2, nRad * 3, nRad * 3);
        //}

    }

    private class MouseHandler extends MouseAdapter implements
            MouseMotionListener {

        public void mousePressed(MouseEvent me) {
            if ((nX1 - me.getX()) * (nX1 - me.getX()) + (nY1 - me.getY())
                    * (nY1 - me.getY()) < nRad * nRad) {
                bisCircleClicked = true;
            }
        }

        public void mouseDragged(MouseEvent me) {
            if (bisCircleClicked) {
                nx = me.getX() - nX2;
                ny = me.getY() - nY2;
                nX1 = nx + nRad;
                nY1 = ny + nRad;
                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            bisCircleClicked = false;


        }
    }
}