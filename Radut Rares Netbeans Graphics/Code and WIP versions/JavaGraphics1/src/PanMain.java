import javax.swing.*;
import java.awt.*;

public class PanMain extends JPanel { // panel definition

    JLabel lblName,lblStuff;
    
    PanDisp panDisp = new PanDisp();
    PanLabelChange panLabelChange = new PanLabelChange();//panDisp);
    PanMenu panMenu = new PanMenu();//panDisp);

    public PanMain() {
        // this next line tells PanMain that it has a border layout.
        setLayout(new BorderLayout());
        add(panLabelChange, BorderLayout.SOUTH);
        add(panDisp, BorderLayout.CENTER);
        add(panMenu, BorderLayout.WEST);
    }

    public class PanDisp extends JPanel {
        
    }

    public class PanLabelChange extends JPanel {
        public PanLabelChange(){
            lblName = new JLabel("Enter a Number");
            add(lblName); //add it to the Frame
            lblStuff = new JLabel("More text to the south");
            add(lblStuff);
        }
        
    }

    public class PanMenu extends JPanel {
        
    }
}
