
/*
*The main difference between Panel and Frame in Java is that the Panel is an internal region to a frame
*  or another panel that helps to group multiple components together while a Frame is a resizable,
* movable independent window with a title bar which contains all other components.
* Panel uses FlowLayout as default layout manager while Frame uses BorderLayout as default layout manager.
* This is another difference between Panel and Frame in Java.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PanewithinFrame {

    public static void main(String[] args) {
        Frame frame = new Frame("Using Panel inside a Frame");

        Panel panel1 = new Panel();
        panel1.setBounds(40, 80, 200, 200);
        panel1.setBackground(Color.CYAN);
        // After defining a Panel, this can be loaded with stuff : buttons, text Areas

        //Button

        Button b1_p1 = new Button("B1_P1");
        b1_p1.setBounds(50, 100, 20, 20);
        b1_p1.setBackground(Color.ORANGE);
        ActionListener actionListener = null;
        b1_p1.addActionListener(actionListener);
        panel1.add(b1_p1);

        // TextField

        JTextField jtext = new JTextField();
        jtext.setBackground(Color.WHITE);
        jtext.setBounds(80,140, 100, 20);
       frame.add(jtext);




        Panel panel2 = new Panel();
        panel2.setBounds(520, 80, 200, 200);
        panel2.setBackground(Color.GREEN);

        Panel panel3 = new Panel();
        panel3.setBounds(280, 80, 200, 200);
        panel3.setBackground(Color.MAGENTA);





        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);


        frame.setSize(800, 700);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
