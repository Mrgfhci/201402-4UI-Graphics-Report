package gui;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GraphicsProject extends JFrame {

    private JButton btnLeft = new JButton("Left");
    private JButton btnRight = new JButton("Right");
    private JButton btnUp = new JButton("Up");
    private JButton btnDown = new JButton("Down");
    private JButton btnReset = new JButton("Reset");
    private JButton btnBackground = new JButton("Change Background");
    private PanCenter panCenter = new PanCenter();

    public GraphicsProject() {
        this.panCenter = new PanCenter();
        JPanel panSouth = new JPanel();
        JPanel panNorth = new JPanel();
        JPanel panEast = new JPanel();
        JPanel panWest = new JPanel();

        panWest.add(btnLeft);
        panEast.add(btnRight);
        panNorth.add(btnUp);
        panSouth.add(btnDown);
        panSouth.add(btnReset);
        panSouth.add(btnBackground);

        this.add(panCenter);
        this.add(panSouth, BorderLayout.SOUTH);
        this.add(panNorth, BorderLayout.NORTH);
        this.add(panEast, BorderLayout.EAST);
        this.add(panWest, BorderLayout.WEST);
        btnLeft.addActionListener(new ButtonListener());
        btnRight.addActionListener(new ButtonListener());
        btnUp.addActionListener(new ButtonListener());
        btnDown.addActionListener(new ButtonListener());
        btnReset.addActionListener(new ButtonListener());
        btnBackground.addActionListener(new ButtonListener());
    }

    public static void main(String[] args) {
        GraphicsProject mainWondow = new GraphicsProject();
        mainWondow.setTitle("Moving a ball");
        mainWondow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWondow.pack();
        mainWondow.setVisible(true);
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent buttonPressed) {
            if (buttonPressed.getSource() == btnLeft) {
                panCenter.left();
            } else if (buttonPressed.getSource() == btnRight) {
                panCenter.right();
            } else if (buttonPressed.getSource() == btnUp) {
                panCenter.up();
            } else if (buttonPressed.getSource() == btnDown) {
                panCenter.down();
            } else if (buttonPressed.getSource() == btnReset) {
                panCenter.reset();
            } else if (buttonPressed.getSource() == btnBackground) {
                panCenter.changeBackground();
            }
        }
    }

    class PanCenter extends JPanel {

        public PanCenter() {
            setBackground(Color.WHITE);
        }
        private int xCoord = -1;
        private int yCoord = -1;
        Random rand = new Random();

        private Dimension preferredSize = new Dimension(300, 200);

        public void left() {
            xCoord -= 5;
            repaint();
        }

        public void right() {
            xCoord += 5;
            repaint();
        }

        public void up() {
            yCoord -= 5;
            repaint();
        }

        public void down() {
            yCoord += 5;
            repaint();
        }

        public void reset() {
            yCoord = -1;
            xCoord = -1;
            repaint();
        }

        public void changeBackground() {
            float dr = rand.nextFloat();
            float dg = rand.nextFloat();
            float db = rand.nextFloat();
            Color randomColor = new Color(dr, dg, db);
            setBackground(randomColor);
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return preferredSize;
        }

        @Override
        protected void paintComponent(Graphics aBall) {
            super.paintComponent(aBall);
            if (xCoord < 0 || yCoord < 0) {
                xCoord = getWidth() / 2;
                yCoord = getHeight() / 2;
            }
            aBall.drawOval(xCoord, yCoord, 10, 10);
        }
    }
}
