
import java.awt.BorderLayout;
import java.awt.GridLayout;
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
        panMenu.setLayout(new BorderLayout());
        panSouth.setLayout(new GridLayout(3, 1));
        panSouth.add(btnPlay);
        panSouth.add(btnInstr);
        panSouth.add(btnCreds);
        panMenu.add(panMain, BorderLayout.CENTER);
        panMenu.add(panSouth, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        FraMain fraMain = new FraMain();
        frame.setSize(1000, 600);
        frame.setTitle("Space Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(fraMain.panMenu);
        frame.setVisible(true);
    }
}
