import javax.swing.*;
import java.awt.*;

public class PanMain extends JPanel { // panel definition

    JLabel lblName,lblStuff,lblNew;
    
    PanDisp panDisp = new PanDisp();
    PanMovement panMovement = new PanMovement();//panDisp);
    PanMenu panMenu = new PanMenu();//panDisp);

    public PanMain() {
        // this next line tells PanMain that it has a border layout.
        setLayout(new BorderLayout());
        add(panMovement, BorderLayout.SOUTH);
        add(panDisp, BorderLayout.CENTER);
        add(panMenu, BorderLayout.EAST);
    }

    public class PanDisp extends JPanel {
        public PanDisp(){
            lblNew = new JLabel("Enter a Number");
            add(lblNew); //add it to the Frame
            
            //panMovement.add(lblName);//Uppercase doesn't work
        }
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
}
