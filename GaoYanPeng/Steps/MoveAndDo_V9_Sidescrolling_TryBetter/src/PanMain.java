
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
// Almost directly from http://ics3ui.sgrondin.ca/ss15/Many%20Panels.html 
public class PanMain extends JPanel {
    PanDisp panDisp = new PanDisp();
    //panDisp.requestFocusInWindow();
    PanStats panStats = new PanStats();

    public PanMain() {
        // this next line tells PanMain that it has a border layout.
        setLayout(new BorderLayout());
        add(panDisp, BorderLayout.CENTER);
        panDisp.requestFocusInWindow();
        add(panStats, BorderLayout.NORTH);
    }
}