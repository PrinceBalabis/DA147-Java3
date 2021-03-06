package p1;

import javax.swing.*;
import java.awt.*;


public class Viewer {
	private JTextArea textarea = new JTextArea();
	
	public Viewer(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textarea.setPreferredSize(new Dimension(500, 400));
		JScrollPane scroll = new JScrollPane(textarea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scroll, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	// clear-metod och addRow-metod

	public void clear(){
		textarea.setText("");
	}
	
	public void addRow(String rowToAdd){
		textarea.setText(textarea.getText()+"\n"+rowToAdd);
	}
	
	public static void main(String[] args) {
		Viewer viewer = new Viewer("Bokvisare");
		Book b1 = new Book("En oväntad semester", "Keyes", "9176436314");
		Book b2 = new Book("How to Program", "Deitel", "0131290142");
		Book b3 = new Book("Testamentet", "Grisham", "9176437175");
		Book b4 = new Book("Legionärerna", "Enquist", "9174483463");
		viewer.clear();
		viewer.addRow(b1.toString());
		viewer.addRow(b2.toString());
		viewer.addRow(b3.toString());
		viewer.addRow(b4.toString());
	}
}
