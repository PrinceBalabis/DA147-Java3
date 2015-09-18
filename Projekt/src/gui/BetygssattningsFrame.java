package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Användargränssnittet för betygsättning för en vara
 * 
 * @author Prince
 *
 */
public class BetygssattningsFrame extends JFrame {

	private JButton btnGilla, btnOgilla;

	/**
	 * Konstruktorn initialiserar alla komponenter i gränssnittet
	 * 
	 * @param al
	 *            ActionListener-object för knapparna i gränssnittet
	 */
	public BetygssattningsFrame(ActionListener al) {
		super("Betygsätt");
		setSize(400, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout());

		// Buttons
		JButton btnGilla = new JButton("Gilla");
		JButton btnOgilla = new JButton("Ogilla");

		btnGilla.addActionListener(al);
		btnOgilla.addActionListener(al);

		add(btnGilla);
		add(btnOgilla);

		pack();
		setVisible(true);
	}
}
