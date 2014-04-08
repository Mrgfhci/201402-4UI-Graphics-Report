import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PanMain extends JPanel { // panel definition

    JLabel lblName,lblStuff,lblNew;
    
    PanMain.PanDisp panDisp = new PanMain.PanDisp();
    PanMain.PanMovement panMovement = new PanMain.PanMovement();//panDisp);
    PanMain.PanMenu panMenu = new PanMain.PanMenu();//panDisp);

    public PanMain() {
        // this next line tells PanMain that it has a border layout.
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
            //panMovement.add(lblName);//Uppercase doesn't work
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
    
    
    public class PanStatus extends JPanel{
        
    }
    public class PanMovement extends JPanel {
        JLabel lblName,lblStuff;
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
}

