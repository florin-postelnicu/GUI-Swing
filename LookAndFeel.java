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
/*
*The Display is :
* frame  :
*        gui:
*            - plafComponents
*                  - plafChooser
*                  - pack button
*            - dynamicLabels
*                  - addNew button
*                  - JScrollPanel(labels)
*            - splitPane
*                  - tableScroll( table)
*                  - imagePanel
*                       - imageLabel
*
*
*
 */
public class LookAndFeel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("The Look And Feel ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gui = new JPanel(new BorderLayout(5, 5));
        /*
        *The BorderLayout is used to arrange the components in five regions: north, south, east, west and center.
        *  Each region (area) may contain one component only.
        *  It is the default layout of frame or window. The BorderLayout provides five constants for each region:N,S,W,E,C.
        *
        * BorderLayout(): creates a border layout but with no gaps between the components.
        * JBorderLayout(int hgap, int vgap): creates a border layout with the given horizontal and vertical gaps
        * between the components.
         */

        JPanel plafComponents = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        plafComponents.setBorder(new TitledBorder(
                "FlowLayout(FlowLayout.RIGHT, 3,3)"));
        /*
        *The FlowLayout class puts components in a row, sized at their preferred size.
        *  If the horizontal space in the container is too small to put all the components in one row,
        *  the FlowLayout class uses multiple rows. If the container is wider than necessary for a row of components,
        *  the row is, by default, centered horizontally within the container.
        *  To specify that the row is to aligned either to the left or right,
        *  use a FlowLayout constructor that takes an alignment argument.
        *  Another constructor of the FlowLayout class specifies how much vertical or horizontal padding is put around the components.
         */

        UIManager.LookAndFeelInfo[] plafInfos = UIManager
                .getInstalledLookAndFeels();
        /*
        *Returns an array of LookAndFeelInfos representing the LookAndFeel implementations currently available.
        *  The LookAndFeelInfo objects can be used by an application to construct a menu of look and feel options
        * for the user, or to determine which look and feel to set at startup time.
        * To avoid the penalty of creating numerous LookAndFeel objects, LookAndFeelInfo maintains
        * the class name of the LookAndFeel class, not the actual LookAndFeel instance.
        *
        *The following example illustrates setting the current look and feel from an instance of LookAndFeelInfo:

        * UIManager.setLookAndFeel(info.getClassName());

         */
        String[] plafNames = new String[plafInfos.length];
        for (int ii = 0; ii < plafInfos.length; ii++) {
            plafNames[ii] = plafInfos[ii].getName();
        }
        JComboBox<String> plafChooser = new JComboBox<>(plafNames);
        plafComponents.add(plafChooser);

        /*
        *A JComboBox, which lets the user choose one of several choices, can have two very different forms.
        * The default form is the uneditable combo box, which features a button and a drop-down list of values.
        *  The second form, called the editable combo box, features a text field with a small button abutting it.
        *  The user can type a value in the text field or click the button to display a drop-down list.
         */

        JCheckBox pack = new JCheckBox("Pack on PLAF change", true);
        plafComponents.add(pack);

        /*
        * The JCheckBox class is used to create a checkbox. It is used to turn an option on (true) or off (false).
        *  Clicking on a CheckBox changes its state from "on" to "off" or from "off" to "on ".
        * It inherits JToggleButton class.
         */

        plafChooser.addActionListener(ae -> {
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
        });


        // Now it is (JPanel)plafComponents added to (JPanel)gui
        gui.add(plafComponents, BorderLayout.NORTH);

        JPanel dynamicLabels = new JPanel(new BorderLayout(4, 4));
        dynamicLabels.setBorder(new TitledBorder("BorderLayout(4,4)"));
        gui.add(dynamicLabels, BorderLayout.WEST);

        // gui adds a new JPanel component; dynamicLabels

        final JPanel labels = new JPanel(new GridLayout(0, 2, 3, 3));
        labels.setBorder(new TitledBorder("GridLayout(0,2,3,3)"));
        /*
        * The GridLayout is used to arrange the components in rectangular grid.
        * One component is displayed in each rectangle.
        * GridLayout(): creates a grid layout with one column per component in a row.
        * GridLayout(int rows, int columns): creates a grid layout with the given rows and columns but no gaps between the components.
        * GridLayout(int rows, int columns, int hgap, int vgap): creates a grid layout with the given rows and columns
        * along with given horizontal and vertical gaps.
         */

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
