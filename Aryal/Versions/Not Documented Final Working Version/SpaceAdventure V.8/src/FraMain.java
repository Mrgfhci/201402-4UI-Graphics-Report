
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FraMain {

    JPanel panMenu = new JPanel();
    JPanel panSouth = new JPanel();
    JButton btnPlay = new JButton("Play");
    JLabel lblCred = new JLabel("HIIsakdjasjkdhaskjdhjaskdhsakjdhskajh");
    JButton btnInstr = new JButton("How To Play");
    JButton btnCreds = new JButton("Credits");
    PanSplashSc panSplashSc = new PanSplashSc();
    DispCreds dispCredits = new DispCreds();
    DispInstr dispInstr = new DispInstr();

    public FraMain() {
        panMenu.setLayout(new BorderLayout());
        panSouth.setLayout(new GridLayout(3, 1));
        panSouth.add(btnPlay);
        panSouth.add(btnInstr);
        panSouth.add(btnCreds);
        class StartGame implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                PanMaiin panMain = new PanMaiin();
                panMenu.add(panMain, BorderLayout.CENTER);
                panSouth.setVisible(false);
            }
        }
        class dispCreds implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                panMenu.remove(panSplashSc);
                panMenu.remove(dispInstr);
                panMenu.add(dispCredits, BorderLayout.CENTER);
                panMenu.revalidate();
                panMenu.repaint();
            }
        }
        class DispHow2Pl implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                panMenu.remove(panSplashSc);
                panMenu.remove(dispCredits);
                panMenu.add(dispInstr, BorderLayout.CENTER);
                panMenu.revalidate();
                panMenu.repaint();
            }
        }
        ActionListener startGame = new StartGame();
        ActionListener Creds = new dispCreds();
        ActionListener dispHow2Pl = new DispHow2Pl();
        btnPlay.addActionListener(startGame);
        btnCreds.addActionListener(Creds);
        btnInstr.addActionListener(dispHow2Pl);
        panMenu.add(panSplashSc, BorderLayout.CENTER);
        panMenu.add(panSouth, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        FraMain fraMain = new FraMain();
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setTitle("Space Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(fraMain.panMenu);
        frame.setVisible(true);
    }
}
