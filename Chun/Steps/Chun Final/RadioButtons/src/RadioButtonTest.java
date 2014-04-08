import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 

public class RadioButtonTest extends JFrame{
    JPanel panCards;
    final static String sBlue = "Blue";
    final static String sGreen = "Green";
    final static String sPink= "Pink";
    final static String sYellow = "Yellow";
     
    public RadioButtonTest(){
         
        final JPanel panRadioButtons = new JPanel();
        final JPanel panReadButton = new JPanel();
        this.setTitle("Radio Buttons Tester");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JRadioButton btnRadioA = new JRadioButton("Baby Blue");
        final JRadioButton btnRadioB = new JRadioButton("Garny Green");
        final JRadioButton btnRadioC = new JRadioButton("Princess Pink");
        final JRadioButton btnRadioD = new JRadioButton("Yucky Yellow");
        
        btnRadioA.setBackground(Color.WHITE);
        btnRadioB.setBackground(Color.WHITE);
        btnRadioC.setBackground(Color.WHITE);
        btnRadioD.setBackground(Color.WHITE);
        
        ButtonGroup grpRadioButtons = new ButtonGroup();
        grpRadioButtons.add(btnRadioA);
        grpRadioButtons.add(btnRadioB);
        grpRadioButtons.add(btnRadioC);
        grpRadioButtons.add(btnRadioD);
        
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
        
        JButton btnReadRadios = new JButton("Read Radio Buttons");
        btnReadRadios.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cardlayout = (CardLayout)(panCards.getLayout());
                String radioSetting = "";
                 
                if (btnRadioA.isSelected()){
                    cardlayout.show(panCards, "Blue");
                    radioSetting = "Radio Button A is selected.\n";
                }
                else if (btnRadioB.isSelected()){
                    cardlayout.show(panCards, "Green");
                    radioSetting = "Radio Button B is selected.\n";
                }
                else if (btnRadioC.isSelected()){
                    cardlayout.show(panCards, "Pink");
                    radioSetting = "Radio Button C is selected.\n";
                }
                else if (btnRadioD.isSelected()){
                    cardlayout.show(panCards, "Yellow");
                    radioSetting = "Radio Button D is selected.\n";
                }
                else {
                    radioSetting = "Press a Button First you Dinosaur.\n";
                }
                 
                JOptionPane.showMessageDialog(RadioButtonTest.this, radioSetting);
            }
        });
         
        panRadioButtons.add(btnRadioA);
        panRadioButtons.add(btnRadioB);
        panRadioButtons.add(btnRadioC);
        panRadioButtons.add(btnRadioD);
        panRadioButtons.setBackground(Color.WHITE);
        
        panReadButton.add(btnReadRadios);
        panReadButton.setBackground(Color.WHITE);
        
        this.add(panCards, BorderLayout.CENTER);
        this.add(panRadioButtons, BorderLayout.NORTH);
        this.add(panReadButton, BorderLayout.SOUTH);
    }
}