package project;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ExampleCardLayout extends JFrame {
    private JTextArea taCount = new JTextArea();
    private CardLayout cardLayout = new CardLayout();     // referens behövs vid sidbyte
    private JPanel pnlCenter = new JPanel(cardLayout);  //    - " -
    
    public ExampleCardLayout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel());
        pack();
        setVisible(true);
    }
    
    private JPanel mainPanel() {
    	JPanel panel = new JPanel(new BorderLayout());
    	panel.setPreferredSize(new Dimension(400,300));
    	
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        JButton btnToText = new JButton("Till text");
        JButton btnToButton = new JButton("Till knappt");
        JButton btnToTextArea = new JButton("Till TextArea");
        btnToText.addActionListener(new Show1());
        btnToButton.addActionListener(new Show2());
        btnToTextArea.addActionListener(new Show3());
        buttonPanel.add(btnToText);
        buttonPanel.add(btnToButton);
        buttonPanel.add(btnToTextArea);
        
        JLabel txt = new JLabel("På denna sida finns enbart denna text!");
        JButton btnReturn = new JButton("Klicka för att komma till första sidan");
        btnReturn.addActionListener(new Show1());
        
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new BorderLayout());
        panel1.add(txt, BorderLayout.CENTER);
        panel2.add(btnReturn, BorderLayout.SOUTH);
        panel3.add(taCount, BorderLayout.CENTER);
        
        pnlCenter.add("TEXTSIDA", panel1);  // översta sidan placeras först
        pnlCenter.add("KNAPPSIDA", panel2); // strängarna identifierar sidan
        pnlCenter.add("TEXTAREASIDA", panel3);  // vid sidbyte
        panel.add(pnlCenter, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    	return panel;
    }
    
    // byta till sidan med JLabel
    private class Show1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(pnlCenter, "TEXTSIDA");  // val av synlig sida
        }
    }
    
    // byta till sidan med JButton
    private class Show2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(pnlCenter, "KNAPPSIDA"); // val av synlig sida
        }
    }
    
    // byta till sidan med JTextArea
    private class Show3 implements ActionListener {
        private int counter=0;
        public void actionPerformed(ActionEvent e) {
            counter++;
            if(counter==1)
                taCount.append("Tab 3 vald 1 gång\n");
            else
                taCount.append("Tab 3 vald " + counter + " gånger\n");
            cardLayout.show(pnlCenter, "TEXTAREASIDA"); // val av synlig sida
        }
    }
    
    public static void main(String[] args)  {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExampleCardLayout();
            }
        });
    }
}
