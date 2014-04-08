//a lot of the code is from your website(collision), which you got from http://www.edu4java.com/en/game/game6.html
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class FraGame extends JFrame {
    PanGame panGame = new PanGame();
    PanSouth panSouth = new PanSouth();
    
    public FraGame() throws InterruptedException{
        setLayout(new BorderLayout());   
        setTitle("Graphics Game (creative name)");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(panGame, BorderLayout.CENTER);
        panGame.setVisible(true);
        add(panSouth, BorderLayout.SOUTH);
        panSouth.setVisible(true);
        
        while (true) {
            panGame.move();
            panGame.repaint();
            panSouth.update();
            Thread.sleep(10);
        }
    }
    public static void main(String[] args)throws InterruptedException {
        new FraGame();
    }
    
}
