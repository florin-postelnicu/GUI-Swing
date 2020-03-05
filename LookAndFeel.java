import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*from ww w  . java2 s . co  m*/
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class LookAndFeel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("The Look And Feel ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gui = new JPanel(new BorderLayout(5, 5));

        JPanel plafComponents = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        plafComponents.setBorder(new TitledBorder(
                "FlowLayout(FlowLayout.RIGHT, 3,3)"));

        UIManager.LookAndFeelInfo[] plafInfos = UIManager
                .getInstalledLookAndFeels();
        String[] plafNames = new String[plafInfos.length];
        for (int ii = 0; ii < plafInfos.length; ii++) {
            plafNames[ii] = plafInfos[ii].getName();
        }
        JComboBox plafChooser = new JComboBox(plafNames);
        plafComponents.add(plafChooser);

        JCheckBox pack = new JCheckBox("Pack on PLAF change", true);
        plafComponents.add(pack);

        plafChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int index = plafChooser.getSelectedIndex();
                try {
                    UIManager.setLookAndFeel(plafInfos[index].getClassName());
                    SwingUtilities.updateComponentTreeUI(frame);
                    if (pack.isSelected()) {
                        frame.pack();
                        frame.setMinimumSize(frame.getSize());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        gui.add(plafComponents, BorderLayout.NORTH);

        JPanel dynamicLabels = new JPanel(new BorderLayout(4, 4));
        dynamicLabels.setBorder(new TitledBorder("BorderLayout(4,4)"));
        gui.add(dynamicLabels, BorderLayout.WEST);

        final JPanel labels = new JPanel(new GridLayout(0, 2, 3, 3));
        labels.setBorder(new TitledBorder("GridLayout(0,2,3,3)"));

        JButton addNew = new JButton("Add Another Label");
        dynamicLabels.add(addNew, BorderLayout.NORTH);
        addNew.addActionListener(new ActionListener() {

            private int labelCount = 0;

            public void actionPerformed(ActionEvent ae) {
                labels.add(new JLabel("Label " + ++labelCount));
                frame.validate();
            }
        });

        dynamicLabels.add(new JScrollPane(labels), BorderLayout.CENTER);

        String[] header = { "Name", "Value" };
        String[] a = new String[0];
        String[] names = System.getProperties().stringPropertyNames().toArray(a);
        String[][] data = new String[names.length][2];
        for (int ii = 0; ii < names.length; ii++) {
            data[ii][0] = names[ii];
            data[ii][1] = System.getProperty(names[ii]);
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        JTable table = new JTable(model);

        JScrollPane tableScroll = new JScrollPane(table);
        Dimension tablePreferred = tableScroll.getPreferredSize();
        tableScroll.setPreferredSize(new Dimension(tablePreferred.width,
                tablePreferred.height / 3));

        JPanel imagePanel = new JPanel(new GridBagLayout());
        JLabel imageLabel = new JLabel("test");
        imagePanel.add(imageLabel, null);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                tableScroll, new JScrollPane(imagePanel));
        gui.add(splitPane, BorderLayout.CENTER);

        frame.setContentPane(gui);
        frame.pack();
        frame.setVisible(true);
    }

}
