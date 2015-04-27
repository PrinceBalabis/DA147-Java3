package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*; // ChangeListener

public class ExampleJTabbedPane extends JFrame{
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextArea countTextArea = new JTextArea();
    
    /** Creates a new instance of ExempelJTabbedPane */
    public ExampleJTabbedPane() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel(), BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
    
    private JPanel mainPanel() {
    	JPanel panel = new JPanel(new BorderLayout());
    	panel.setPreferredSize(new Dimension(400,300));
        JLabel txt = new JLabel("På denna sida finns enbart denna text!");
        JButton tillTab1 = new JButton("Klicka för att komma till första sidan");
        tillTab1.addActionListener(new AL());
        tabbedPane.addChangeListener(new CL());
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new BorderLayout());
        panel1.add(txt, BorderLayout.CENTER);
        panel2.add(tillTab1, BorderLayout.SOUTH);
        panel3.add(countTextArea, BorderLayout.CENTER);
        tabbedPane.add("Panel med text", panel1);
        tabbedPane.add("Visa knapp", panel2);
        tabbedPane.add("TextArea-panel", panel3);
        panel.add(tabbedPane, BorderLayout.CENTER);
    	return panel;
    }
    
    private class AL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tabbedPane.setSelectedIndex(0);
        }
    }
    
    private class CL implements ChangeListener {
        private int counter=0;
        public void stateChanged(ChangeEvent e) {
            if(tabbedPane.getSelectedIndex()==2) {
                counter++;
                if(counter==1)
                    countTextArea.append("Tab 3 vald 1 gång\n");
                else
                    countTextArea.append("Tab 3 vald " + counter + " gånger\n");
            }
        }
    }
    
    public static void main(String[] args)  {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExampleJTabbedPane();
            }
        });
    }
}
