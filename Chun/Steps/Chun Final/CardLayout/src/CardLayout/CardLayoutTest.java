package CardLayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutTest extends JPanel implements ItemListener{
    
    JPanel panCards;
    final static String sBlue = "Blue";
    final static String sGreen = "Green";
    final static String sPink = "Pink";
    final static String sYellow = "Yellow";
    
    public void addsComponentToPane(Container MainPanel){
        JPanel panComboBox = new JPanel();
        String comboBoxItems[] = { sBlue, sGreen, sPink, sYellow };
        JComboBox combobox = new JComboBox(comboBoxItems);
        combobox.setEditable(false);
        combobox.addItemListener(this);
        panComboBox.add(combobox);
        panComboBox.setBackground(Color.WHITE);
        
        JPanel panBlue = new JPanel();
        panBlue.setBackground(Color.BLUE);
        JPanel panGreen = new JPanel();
        panGreen.setBackground(Color.GREEN);
        JPanel panPink = new JPanel();
        panPink.setBackground(Color.PINK);
        JPanel panYellow = new JPanel();
        panYellow.setBackground(Color.YELLOW);
        
        panCards = new JPanel(new CardLayout());
        panCards.add(panBlue, sBlue);
        panCards.add(panGreen, sGreen);
        panCards.add(panPink, sPink);
        panCards.add(panYellow, sYellow);
        
        MainPanel.add(panComboBox, BorderLayout.PAGE_START);
        MainPanel.add(panCards, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cardlayout = (CardLayout)(panCards.getLayout());
        cardlayout.show(panCards, (String)evt.getItem());
    }
    private static void createAndShowGUI() {
        JFrame fraMain = new JFrame("CardLayoutTest");
        fraMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fraMain.setSize(400,400);
        CardLayoutTest cardlayouttest = new CardLayoutTest();
        cardlayouttest.addsComponentToPane(fraMain.getContentPane());
        fraMain.setVisible(true);
    }
     
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}