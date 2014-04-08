import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComDragImage extends JComponent 
        implements MouseMotionListener {
    JLabel lblName,lblStuff,lblNew;
    
    ComDragImage.PanDisp panDisp = new ComDragImage.PanDisp();
    ComDragImage.PanMovement panMovement = new ComDragImage.PanMovement();//panDisp);
    ComDragImage.PanMenu panMenu = new ComDragImage.PanMenu();//panDisp);
 static int nW = 60, nH = 60;
       int nGrid = 10;
       int nX = 100, nY = 100;
       Image imgZappa;

 public ComDragImage(Image _imgZappa) {
       setLayout(new BorderLayout());
        
       add(panMovement, BorderLayout.SOUTH);
       add(panDisp, BorderLayout.CENTER);
       add(panMenu, BorderLayout.EAST);
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
       public class PanDisp extends JPanel {
        public PanDisp(){
            lblNew = new JLabel("Enter a Number");
            add(lblNew); //add it to the Frame
            
            //panMovement.add(lblName);//Uppercase doesn't work
        }
    }
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
       String sImageFile = "Zappa1.jpg";
       Image imgZappa = Toolkit.getDefaultToolkit().getImage(
       ComDragImage.class.getResource(sImageFile));
       imgZappa = imgZappa.getScaledInstance(nW, nH, Image.SCALE_DEFAULT);
       JFrame frame = new JFrame("DragImage");
       frame.getContentPane().add(new ComDragImage(imgZappa));
       frame.setSize(800, 800);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       }
 }
