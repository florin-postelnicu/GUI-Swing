//w  ww. ja  v a  2s  .c o m
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DisplayModes{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        device.setFullScreenWindow(frame);
        device.setDisplayMode(new DisplayMode(800, 600, 32, 60));
        frame.setVisible(true);

        JButton btn = new JButton();
        btn.setText("Button");
        JPanel panel = new JPanel();

        panel.add(btn);
        frame.add(panel);

        btn.addActionListener(e->{
            JOptionPane.showMessageDialog(frame.getContentPane(), "JOptionPane");
        });
    }
}