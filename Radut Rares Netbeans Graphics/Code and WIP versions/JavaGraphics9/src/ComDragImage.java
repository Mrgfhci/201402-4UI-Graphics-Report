
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComDragImage extends JComponent
        implements MouseMotionListener {

    int nNum;
    int nX, nY;
    Image arimgZappa[] = new Image[10];
    Image imgZappaCurrent;
    JLabel lblName, lblStuff, lblNew;
    String sNum;
    ComDragImage.PanMenu panMenu = new ComDragImage.PanMenu();

    public ComDragImage(Image _imgZappa1, Image _imgZappa2, Image _imgZappa3,
            Image _imgZappa4, Image _imgZappa5, Image _imgZappa6, Image _imgZappa7,
            Image _imgZappa8, Image _imgZappa9, Image _imgZappa10) {
        arimgZappa[0] = _imgZappa1;
        arimgZappa[1] = _imgZappa2;
        arimgZappa[2] = _imgZappa3;
        arimgZappa[3] = _imgZappa4;
        arimgZappa[4] = _imgZappa5;
        arimgZappa[5] = _imgZappa6;
        arimgZappa[6] = _imgZappa7;
        arimgZappa[7] = _imgZappa8;
        arimgZappa[8] = _imgZappa9;
        arimgZappa[9] = _imgZappa10;
        imgZappaCurrent = _imgZappa1;
        addMouseMotionListener(this);
        setLayout(new BorderLayout());
        add(panMenu, BorderLayout.EAST);
    }

    public void mouseDragged(MouseEvent e) {
        nX = e.getX();
        nY = e.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imgZappaCurrent, nX, nY, this);
    }
    public class PanMenu extends JPanel {

        JButton[] btnButtons = new JButton[10];

        public PanMenu() {
            setLayout(new GridLayout(5, 2));
            Pressed pressed = new Pressed();
            for (int i = 0; i < 10; i++) {
                btnButtons[i] = new JButton(Integer.toString(i + 1));
                add(btnButtons[i]);
                btnButtons[i].addActionListener(pressed);
            }

        }
        class Pressed implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                sNum = event.getActionCommand();
                nNum = Integer.parseInt(sNum);
                imgZappaCurrent = arimgZappa[nNum - 1];
                revalidate();
            }
        }
    }
}
