package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RegistreringsFrame extends JFrame{

	public RegistreringsFrame(){
		super("Registrering");
		setSize(400, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable(false);
		setVisible(true);
	}

	private class KundRegistreringsPanel extends JPanel{

		public KundRegistreringsPanel(){
			setSize(400, 50);
		}
	}
}
