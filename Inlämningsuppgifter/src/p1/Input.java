package p1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Input {
	private Controller controller;
	
	public Input(Controller controller){
		this.controller = controller;
		
		JFrame frame = new JFrame("Ny bok");
		JTextField titleTF = new JTextField("Titel");
		JTextField authorTF = new JTextField("Författare");
		JTextField isbnTF = new JTextField("ISBN");
		frame.add(titleTF, BorderLayout.WEST);
		frame.add(authorTF, BorderLayout.WEST);
		frame.add(isbnTF, BorderLayout.WEST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
