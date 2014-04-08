
import java.awt.*;
import javax.swing.*;

public class PanSouth extends JPanel {

    private JLabel lblScore;
    private String imgLeft = "leftkey.jpg";
    private String imgRight = "rightkey.jpg";
    private String imgDown = "downkey.jpg";
    private String imgUp = "upkey.jpg";
    static JLabel lblLeft;
    static JLabel lblRight;
    static JLabel lblDown;
    static JLabel lblUp;

    public PanSouth() {

        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(getWidth(), 100));
        setLayout(new GridBagLayout());
        ImageIcon imgLeftKey = new ImageIcon(this.getClass().getResource(imgLeft));
        ImageIcon imgRightKey = new ImageIcon(this.getClass().getResource(imgRight));
        ImageIcon imgDownKey = new ImageIcon(this.getClass().getResource(imgDown));
        ImageIcon imgUpKey = new ImageIcon(this.getClass().getResource(imgUp));
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        lblScore = new JLabel("Score : " + Ball.getScore());
        add(lblScore, c);
        c.weightx = 0.01;
        c.weighty = 0.01;

        lblLeft = new JLabel(imgLeftKey);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        add(lblLeft, c);
        lblLeft.setVisible(false);

        lblUp = new JLabel(imgUpKey);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        add(lblUp, c);
        lblUp.setVisible(false);

        lblDown = new JLabel(imgDownKey);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        add(lblDown, c);
        lblDown.setVisible(false);

        lblRight = new JLabel(imgRightKey);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        add(lblRight, c);
        lblRight.setVisible(false);

    }
//allows ImgSquare.java to use the labels and set the visibility of the images
    public static JLabel getLeft() {
        return lblLeft;
    }

    public static JLabel getRight() {
        return lblRight;
    }

    public static JLabel getUp() {
        return lblUp;
    }

    public static JLabel getDown() {
        return lblDown;
    }

    public void update() {
        lblScore.setText("Score : " + Ball.getScore());
    }
}
