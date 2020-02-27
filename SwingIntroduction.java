
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SwingIntroduction {

    public static void main(String[] args) {
        JFrame frame=new JFrame("Login Screen"); //Line 1
        final JLabel label = new JLabel();//Line 2
        label.setBounds(20,150, 200,50);  //Line 3
        final JPasswordField value = new JPasswordField();//Line 4
        value.setBounds(100,75,100,30);
        JLabel userNameLabel=new JLabel("User Name:");//Line 5
        userNameLabel.setBounds(20,20, 80,30);
        JLabel paswordLabel=new JLabel("Password:");//Line 6
        paswordLabel.setBounds(20,75, 80,30);
        JButton loginButton = new JButton("Login Here");//Line 7
        loginButton.setBounds(100,120, 80,30);
        final JTextField text = new JTextField();//Line 8
        text.setBounds(100,20, 100,30);
        frame.add(value);   //Line 9
        frame.add(userNameLabel); //Line 9
        frame.add(label); //Line 9
        frame.add(paswordLabel); //Line 9
        frame.add(loginButton); //Line 9
        frame.add(text);  //Line 9
        frame.setSize(300,300);
        frame.setLayout(null);    //Line 10
        frame.setVisible(true);     //Line 11
        loginButton.addActionListener(new ActionListener() {  //Line 12
            public void actionPerformed(ActionEvent e) {
                String userNameDisplay = "You are " + text.getText();//Line 13
                label.setText(userNameDisplay);     //Line 14
            }
        });
    }
}
/*
*Line 1 is used to create a Login frame for include required components within it.
Line 2 is used to create a label in the frame for adding necessary fields like username, password field, etc.
Line 3 is used for set boundaries (length, width, etc.) with appropriate values by using the setBounds method.
Line 4 is used for creating a password field (entered values are hidden if we use the password field).
Line 5 is used for creating the username label.
Line 6 is used for creating a password label.
Line 7 is used for creating a button with the button name ‘Login Here’.
Line 8 is used for creating a text field for adding some text to it.
Line 9 is used for adding all the components like fields, labels, etc.
Line 10 is used for making the frame without any layout by setting the null
Line 11 is used for making the user interface visible by setting the value
Line 12 is used for the login button action method if we click on login here button what will perform, it decides.
It displays entered name from the username text field, once we click on the login here button.
Do We Really Need to Memorize All the Swing Components?



 */