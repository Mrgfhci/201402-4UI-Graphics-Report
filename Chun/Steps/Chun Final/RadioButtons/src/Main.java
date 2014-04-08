import javax.swing.SwingUtilities;
 

public class Main {
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(runJFrameLater);
    }
     
    static Runnable runJFrameLater = new Runnable() {
 
        @Override
        public void run() {
            RadioButtonTest jFrameWindow = new RadioButtonTest();
            jFrameWindow.setVisible(true);
        }
    };
}