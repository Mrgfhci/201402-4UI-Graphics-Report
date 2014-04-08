//most of the code is from http://zetcode.com/tutorials/javagamestutorial/movingsprites/
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FraGame extends JFrame {
    public FraGame() {    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        add(new PanMain(),BorderLayout.CENTER);
        add(new PanDown(),BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
        setTitle("Move Your Square!");
        setResizable(false);
        setVisible(true);
    }
    

    public static void main(String[] args) {
        new FraGame();
        
    }
}