package p1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Input implements ActionListener {
	private Controller controller;
	private JTextField titleTF;
	private JTextField authorTF;
	private JTextField isbnTF;
	
	public Input(Controller controller){
		this.controller = controller;
		
		JFrame frame = new JFrame("Ny bok");
		
		JLabel titleL = new JLabel("Titel");
		JLabel authorL = new JLabel("Författare");
		JLabel isbnL = new JLabel("ISBN");
		
		titleTF = new JTextField();
		titleTF.setPreferredSize(new Dimension(200, 20));
		authorTF = new JTextField();
		authorTF.setPreferredSize(new Dimension(200, 20));
		isbnTF = new JTextField();
		isbnTF.setPreferredSize(new Dimension(200, 20));
		
		JButton button = new JButton("Lägg till bok");
        button.addActionListener(this);
        
		GridLayout gridLayout = new GridLayout(4,2);
		frame.setLayout(gridLayout);
		frame.add(titleL);
		frame.add(titleTF);
		
		frame.add(authorL);
		frame.add(authorTF);
		
		frame.add(isbnL);
		frame.add(isbnTF);
		
		frame.add(new JPanel());
		frame.add(button);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
        frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		controller.newBook(titleTF.getText(), authorTF.getText(), isbnTF.getText());
		titleTF.setText("");
		authorTF.setText("");
		isbnTF.setText("");
	}
}
