
/*
* Add Background image to JPanel
 */
import java.awt.*;

import javax.swing.*;

public class AddBackground {
    public static void main(String[] args) {
        ImagePanel panel = new ImagePanel(
                new ImageIcon("//ahs-wl//Staff//postelnicu//My Pictures//Rainforest.jpg").getImage());

        JFrame frame = new JFrame("Image as a background");
        JButton rain = new JButton("Rain");
        JTextField textField =  new JTextField();
        textField.setBounds(0,40,100,100);

        rain.setBackground(Color.WHITE);

        Font font =Font.getFont("NewTimeRoman");
        rain.setFont(font);
        Dimension bsize = new Dimension(100, 20);
        rain.setSize(bsize);
        rain.setForeground(Color.MAGENTA);
        rain.setBorderPainted(true);
        rain.setFont(font);


        Dimension txtsize = new Dimension(100, 20);
        textField.setSize(txtsize);
        textField.setForeground(Color.MAGENTA);
        textField.setBackground(Color.CYAN);
        panel.add(rain);
        panel.add(textField);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);



    }
}

class ImagePanel extends JPanel {
    private Image img;
    public ImagePanel(String img){
        this(new ImageIcon(img).getImage());
    }
    public ImagePanel(Image img){
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    public void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, null);
    }
}
