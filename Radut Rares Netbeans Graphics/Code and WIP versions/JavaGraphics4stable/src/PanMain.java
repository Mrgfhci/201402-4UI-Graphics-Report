import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PanMain extends JPanel { // panel definition

    JLabel lblName,lblStuff,lblNew;
    
    PanMain.PanDisp panDisp = new PanMain.PanDisp();
    PanMain.PanMovement panMovement = new PanMain.PanMovement();//panDisp);
    PanMain.PanMenu panMenu = new PanMain.PanMenu();//panDisp);

    public PanMain() {
        setLayout(new BorderLayout());
        
        add(panMovement, BorderLayout.SOUTH);
        add(panDisp, BorderLayout.CENTER);
        add(panMenu, BorderLayout.EAST);
        
    }

    public class PanDisp extends JPanel implements MouseMotionListener {
        int nW=60,nH=60;
        int nX,nY;
        Image imgZappa;
        
        public PanDisp(){
            
            addMouseMotionListener(this);
            String sImageFile = "Zappa1.jpg";
            Image imgZappa = Toolkit.getDefaultToolkit().getImage(
            PanDisp.class.getResource(sImageFile));
            imgZappa = imgZappa.getScaledInstance(nW, nH, Image.SCALE_DEFAULT);
            //frame.getContentPane().add(new PanDisp(imgZappa));
        }
        public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       g2.drawImage(imgZappa, nX, nY, this);
       }
        public void mouseDragged(MouseEvent e) {
       nX = e.getX();
       nY = e.getY();
       repaint();
       }

        public void mouseMoved(MouseEvent e) {
            
       }
    }
    /*
     import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComDragImage extends JComponent
       implements MouseMotionListener {

 static int nW = 60, nH = 60;
       int nGrid = 10;
       int nX, nY;
       Image imgZappa;

 public ComDragImage(Image _imgZappa) {
       imgZappa = _imgZappa;
       addMouseMotionListener(this);
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
       g2.drawImage(imgZappa, nX, nY, this);
       }

 public static void main(String[] args) {
       String sImageFile = "Zappa1.jpg";
       Image imgZappa = Toolkit.getDefaultToolkit().getImage(
       DragImage.class.getResource(sImageFile));
       imgZappa = imgZappa.getScaledInstance(nW, nH, Image.SCALE_DEFAULT);
       JFrame frame = new JFrame("DragImage");
       frame.getContentPane().add(new DragImage(imgZappa));
       frame.setSize(300, 300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       }
       }
     */
    
    public class PanStatus extends JPanel{
        
    }
    public class PanMovement extends JPanel {
        public PanMovement(){
            lblName = new JLabel("Enter a Number");
            add(lblName); //add it to the Frame
            lblStuff = new JLabel("More text to the south");
            add(lblStuff);
            panDisp.add(lblName);
        }
        
    }

    public class PanMenu extends JPanel {
        JButton[] btnButtons = new JButton[10];
        public PanMenu(){
            setLayout(new GridLayout(5,2));
            for(int i=0;i<10;i++){
                btnButtons[i]= new JButton("Button "+(i+1));
                add(btnButtons[i]);
                
            }
            
        }
    }
    

 public static void main(String[] args) {
       JFrame frame = new JFrame();
       PanMain panMain = new PanMain();
       frame.setSize(800, 800);
       frame.setTitle("Graphics is Great");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //frame.getContentPane().add(new PanDisp());
       frame.add(panMain);
       frame.setVisible(true);
       }
}

