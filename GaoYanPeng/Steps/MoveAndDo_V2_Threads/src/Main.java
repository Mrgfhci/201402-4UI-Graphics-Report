
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

// V1 progress: keys movement now smooth
// collosion detection with 2 differ shape
// boundaries are set
public class Main extends JFrame {

    Image dbImage;
    Graphics dbg;
    
    int
    GWIDTH = 500,
    GHEIGHT = 500;
    static MovingKeys kMove = new MovingKeys();
    //Dimension of GWIDTH*GHEIGHT
    Dimension screenSize = new Dimension(GWIDTH, GHEIGHT);
    
        public Main(){
        this.setTitle("Game");
        this.setSize(screenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        //this.addKeyListener(new AL());
    }
    
    public static void main(String[] args) {
        Main m = new Main();
//        //Create and start threads
//        Thread ball = new Thread(b);
//        ball.start();
//        Thread p1 = new Thread(b.p1);
//        Thread p2 = new Thread(b.p2);
//        p1.start();
//        p2.start();
        Thread circle  = new Thread(kMove);
        circle.start();
    }  @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        draw(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void draw(Graphics g){
        kMove.draw(g);
//        b.p1.draw(g);
//        b.p2.draw(g);
//        
        g.setColor(Color.WHITE);
//        g.drawString(""+b.p1Score, 15, 50);
//        g.drawString(""+b.p2Score, 370, 50);
        
        repaint();
    }
    
    ////////EVENT LISTENER CLASS/////////
//    public class AL extends KeyAdapter {
//        @Override
//        public void keyPressed(KeyEvent e){
//            b.p1.keyPressed(e);
//            b.p2.keyPressed(e);
//        }
//        @Override
//        public void keyReleased(KeyEvent e){
//            b.p1.keyReleased(e);
//            b.p2.keyReleased(e);
//        }
//    }
}
