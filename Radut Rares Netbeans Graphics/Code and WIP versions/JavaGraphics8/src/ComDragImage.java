import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import javax.swing.*;
/*
import java.awt.Color;
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 
import java.awt.geom.Ellipse2D; 
import java.awt.geom.Rectangle2D; 
import javax.swing.*; 
// V1 progress: keys movement now smooth 
// collosion detection with 2 differ shape 
// boundaries are set 
public class KeysMovement { 
public static void main(String[] args) { 
MovingKeys kmove = new MovingKeys(); 
JFrame datFrame = new JFrame(); 
//Thread ball = new Thread(b); 
//ball.start(); 
datFrame.add(kmove); 
datFrame.setVisible(true); 
datFrame.setSize(500, 500); 
datFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
datFrame.setTitle("Hello"); } } 
class MovingKeys extends JPanel implements ActionListener, KeyListener {
Timer t = new Timer(5, this); 
double x = 0, y = 0, velx = 0, vely = 0; int nCounter = 0; 
String yousuck = ""; public MovingKeys() { t.start(); 
addKeyListener(this); setFocusable(true); 
setFocusTraversalKeysEnabled(false); } 
@Override public void paintComponent(Graphics g) { 
super.paintComponent(g); Graphics2D g2 = (Graphics2D) g; 
Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40); 
g2.fill(circle); 
Rectangle2D rect = new Rectangle2D.Double(200, 200, 30, 30); 
g2.setPaint(Color.RED); 
g2.fill(rect); 
g2.draw(rect); 
g.drawString(Integer.toString(nCounter), 20, 200); 
if (circle.intersects(rect)) { x = 0; y = 0; stop(); 
//g.drawString("YOU SUCK!!", 175, 75); yousuck = "yousuck"; } g.drawString(yousuck, 40, 210); }
@Override
public void actionPerformed(ActionEvent e) {
repaint(); 
x += velx; 
y += vely; 
if (x > 450) { 
x = 450; } if (x < 0) { x = 0; } if (y < 0) { y = 0; } if (y > 450) { y = 450; } } 
public void up() { vely = -1; } public void down() { vely = 1; } public void left() { velx = -1; } public void right() { velx = 1; } public void stop() { vely = 0; velx = 0; } @Override public void keyPressed(KeyEvent e) { int nCode = e.getKeyCode(); if (nCode == KeyEvent.VK_UP) { up(); yousuck = ""; } if (nCode == KeyEvent.VK_DOWN) { down(); yousuck = ""; } if (nCode == KeyEvent.VK_LEFT) { left(); yousuck = ""; } if (nCode == KeyEvent.VK_RIGHT) { right(); // } else { // vely = 0; // velx = 0; yousuck = ""; } } @Override public void keyTyped(KeyEvent e) { } @Override public void keyReleased(KeyEvent e) { int nCode = e.getKeyCode(); if (nCode == KeyEvent.VK_UP) { vely = 0; } if (nCode == KeyEvent.VK_DOWN) { vely = 0; } if (nCode == KeyEvent.VK_LEFT) { velx = 0; } if (nCode == KeyEvent.VK_RIGHT) { velx = 0; } } }
*/
public class ComDragImage extends JComponent
       implements MouseMotionListener, KeyListener {
       int nNum;
       int nX, nY;
       Image arimgZappa[]= new Image[10];
       Image imgZappaCurrent;
       JLabel lblName,lblStuff,lblNew;
       
    String sNum;
    ComDragImage.PanDisp panDisp = new ComDragImage.PanDisp();
    ComDragImage.PanMovement panMovement = new ComDragImage.PanMovement();//panDisp);
    ComDragImage.PanMenu panMenu = new ComDragImage.PanMenu();//panDisp);
 public ComDragImage(Image _imgZappa1,Image _imgZappa2,Image _imgZappa3,
         Image _imgZappa4,Image _imgZappa5,Image _imgZappa6,Image _imgZappa7,
         Image _imgZappa8,Image _imgZappa9,Image _imgZappa10){
       arimgZappa[0] = _imgZappa1;
       arimgZappa[1] = _imgZappa2;
       arimgZappa[2] = _imgZappa3;
       arimgZappa[3] = _imgZappa4;
       arimgZappa[4] = _imgZappa5;
       arimgZappa[5] = _imgZappa6;
       arimgZappa[6] = _imgZappa7;
       arimgZappa[7] = _imgZappa8;
       arimgZappa[8] = _imgZappa9;
       arimgZappa[9] = _imgZappa10;
       imgZappaCurrent = _imgZappa1;
       addMouseMotionListener(this);
       addKeyListener(this);
       setLayout(new BorderLayout());
        
        add(panMovement, BorderLayout.SOUTH);
        add(panDisp, BorderLayout.CENTER);
        add(panMenu, BorderLayout.EAST);
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
       g2.drawImage(imgZappaCurrent, nX, nY, this);
       }
 public void keyReleased(KeyEvent e){
     repaint();
 }public void keyTyped(KeyEvent e) {
      
 }public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
            if (keyCode == KeyEvent.VK_UP){
                nY ++;
            }
            else if(keyCode == KeyEvent.VK_DOWN){
                nY --;
            }
            else if (keyCode == KeyEvent.VK_LEFT){
                nX --;}
            
            else if(keyCode == KeyEvent.VK_RIGHT){
                nX ++; 
            }
     repaint();
     System.out.println(nX + " "+ nY);
    }
 
 public class PanDisp extends JPanel{
     public PanDisp(){
         
     }
 }
   public class PanMovement extends JPanel {
        JButton[] btnButtons = new JButton[10];
        public PanMovement(){
            setLayout(new GridLayout(1,4));
            Pressed pressed = new Pressed();
            for(int i=0;i<4;i++){
                btnButtons[i]= new JButton(Integer.toString(i+1));
                add(btnButtons[i]);
                btnButtons[i].addActionListener(pressed);
            }
            
        }public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       g2.drawImage(imgZappaCurrent, nX, nY, this);
       }
       class Pressed implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                nX+=10;
                System.out.println(nX);
                repaint();
            }/*
            public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       g2.drawImage(imgZappaCurrent, nX, nY, this);
       }
            */
        }
    }
    
    public class PanMenu extends JPanel  {
        JButton[] btnButtons = new JButton[10];
        public PanMenu(){
            setLayout(new GridLayout(5,2));
            Pressed pressed = new Pressed();
            for(int i=0;i<10;i++){
                btnButtons[i]= new JButton(Integer.toString(i+1));
                add(btnButtons[i]);
                btnButtons[i].addActionListener(pressed);
            }
            
        }
        class Pressed implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                sNum = event.getActionCommand();
                nNum = Integer.parseInt(sNum);
                imgZappaCurrent = arimgZappa[nNum-1];
                revalidate();
            }
        }
    }
}
