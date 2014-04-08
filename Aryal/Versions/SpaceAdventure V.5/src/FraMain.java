
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FraMain {

    JPanel panMenu = new JPanel();
    JPanel panSouth = new JPanel();
    JButton btnPlay = new JButton("Play");
    JButton btnInstr = new JButton("How To Play");
    JButton btnCreds = new JButton("Credits");
    PanMaiin panMain = new PanMaiin();

    public FraMain() {
        // this next line tells PanMain that it has a border layout.\
        panMenu.setLayout(new BorderLayout());
        panSouth.setLayout(new GridLayout(3, 1));
        panSouth.add(btnPlay);
        panSouth.add(btnInstr);
        panSouth.add(btnCreds);
        class StartGame implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                panSouth.setVisible(false);
            }
        }
        ActionListener startGame = new StartGame();
        btnPlay.addActionListener(startGame);
        //panMenu.add(panSouth, BorderLayout.SOUTH);
        panMenu.add(panMain, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        FraMain initialize = new FraMain();
        frame.setSize(1000, 600);
        frame.setTitle("Space Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(initialize.panMenu);
        frame.setVisible(true);
    }


}
