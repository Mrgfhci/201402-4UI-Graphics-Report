import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class LayoutViewer {
static int nW = 100,nH = 100;
 public static void main(String[] args) {
       String sImageFile[]=new String[10];
       Image imgZappa[]= new Image[10];
       
       for(int i =0;i<10;i++){
           sImageFile[i]="Zappa"+((i+1))+".jpg";
           imgZappa[i] = Toolkit.getDefaultToolkit().getImage(
           ComDragImage.class.getResource(sImageFile[i]));
           imgZappa[i] = imgZappa[i].getScaledInstance(nW, nH, Image.SCALE_DEFAULT);
       }
       JFrame frame = new JFrame("DragImage");
       frame.getContentPane().add(new ComDragImage(imgZappa[0],imgZappa[1],imgZappa[2],
               imgZappa[3],imgZappa[4],imgZappa[5],imgZappa[6],
               imgZappa[7],imgZappa[8],imgZappa[9]));
       frame.setSize(800, 800);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       }
}
