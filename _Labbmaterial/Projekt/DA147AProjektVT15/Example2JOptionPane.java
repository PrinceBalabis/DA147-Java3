package project;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Example2JOptionPane extends JFrame {
    private JTextArea textarea = new JTextArea();
    private JButton btnDialog = new JButton("Visa komponent-dialog");
    private ComponentPanel pnlComponents = new ComponentPanel();
    
    public Example2JOptionPane() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel(), BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
    
    private JPanel mainPanel() {
    	JPanel panel = new JPanel(new BorderLayout());
    	panel.setPreferredSize(new Dimension(300,200));
        btnDialog.addActionListener(new AL());
        panel.add(textarea, BorderLayout.CENTER);
        panel.add(btnDialog, BorderLayout.SOUTH);
    	return panel;
    }
    
    private class AL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog(Example2JOptionPane.this, pnlComponents, 
                    "Exempel på komponenter", JOptionPane.OK_CANCEL_OPTION, 
                    JOptionPane.PLAIN_MESSAGE) ==
                    JOptionPane.OK_OPTION) {
                textarea.setText("");
                if(pnlComponents.getCb1())
                    textarea.append("ComboBox 1 vald\n");
                if(pnlComponents.getCb2())
                    textarea.append("ComboBox 2 vald\n");
                if(pnlComponents.getRb1())
                    textarea.append("RadioButton 1 vald\n");
                else
                    textarea.append("RadioButton 2 vald\n");
                textarea.append("ComboBox, valt index: " + pnlComponents.getComboIndex() +
                        ". " + pnlComponents.getComboText()+ "\n");
                int[] listIndices = pnlComponents.getListIndex();
                Object[] listItems = pnlComponents.getListItems();
                textarea.append("Val i JList:\n");
                for(int i=0; i<listIndices.length; i++) {
                    textarea.append(listIndices[i] + ". " + listItems[i].toString() + "\n");
                }
                textarea.append("Inmatat lösenord: " + pnlComponents.getPassword());
            }
            else
                textarea.setText("Cancel klickad!");
        }
    }
    
    public static void main(String[] args)  {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Example2JOptionPane();
            }
        });
    }
}
