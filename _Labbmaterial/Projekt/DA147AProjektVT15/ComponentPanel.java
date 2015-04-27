package project;
import javax.swing.*;
import java.awt.*;

public class ComponentPanel extends JPanel {
    private String[] comboBoxItems = {"Tiger", "Lejon", "Leopard", "Puma", "Bondkatt"};
    private JCheckBox cb1 = new JCheckBox("En JCheckBox",true);
    private JCheckBox cb2 = new JCheckBox("abcdefg",false);
    private JRadioButton rb1 = new JRadioButton("En JRadioButton",true);
    private JRadioButton rb2 = new JRadioButton("dddddd",false);
    private JPasswordField pf = new JPasswordField();
    private JComboBox<String> combo = new JComboBox<String>(comboBoxItems);
    private JList<String> list = new JList<String>(new String[]{"Tennis","Fotboll","Ishockey","Golf","Bowling","Handboll"});
    
    public ComponentPanel() {
        setLayout(new BorderLayout());
        JPanel southPanel = new JPanel(new GridLayout(1,2));
        southPanel.add(pf);
        southPanel.add(combo);
        
        add(getCheckBoxRadioButtonPanel(), BorderLayout.WEST);
        add(southPanel, BorderLayout.SOUTH);
        add(list,BorderLayout.CENTER);
    }
    
    private JPanel getCheckBoxRadioButtonPanel() {
        JPanel checkBoxRadioButtonPanel = new JPanel(new GridLayout(4,1));
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        checkBoxRadioButtonPanel.add(cb1);
        checkBoxRadioButtonPanel.add(cb2);
        checkBoxRadioButtonPanel.add(rb1);
        checkBoxRadioButtonPanel.add(rb2);
        return checkBoxRadioButtonPanel;
    }
    
    public boolean getCb1() {
        return cb1.isSelected();
    }
    
    public boolean getCb2() {
        return cb2.isSelected();
    }
    
    public boolean getRb1() {
        return rb1.isSelected();
    }
    
    public boolean getRb2() {
        return rb2.isSelected();
    }
    
    public int getComboIndex() {
        return combo.getSelectedIndex();
    }
    
    public String getComboText() {
        return combo.getSelectedItem().toString();
    }
    
    public int[] getListIndex() {
        return list.getSelectedIndices();
    }
    
    public Object[] getListItems() {
        return list.getSelectedValuesList().toArray();
    }
    
    public String getPassword() {
        return new String(pf.getPassword());
    }
}
