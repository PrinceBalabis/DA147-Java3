package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * Användargränssnittet för inloggningen
 * 
 * @author Prince
 *
 */
public class InloggningsFrame extends JFrame {
	private JTextField tfAnvandarnamn;
	private JPasswordField pfLosenord;

	public InloggningsFrame(ActionListener al) {
		super("Inloggning");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		add(new InloggningsUppgiftsPanel(), BorderLayout.CENTER); // Lägg till
		// Panelen
		// med
		// textfält

		// Lägg till "Logga in" knappen
		JButton btnLoggaIn = new JButton();
		btnLoggaIn.setText("Logga in.");
		btnLoggaIn.addActionListener(al);
		add(btnLoggaIn, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	/**
	 * Kallas för att hämta användarnamn och lösenord skrivna i
	 * användargränssnittet
	 * 
	 * @return användarnamn och lösenord i en array
	 */
	public String[] getLoginForm() {
		String anvandarnamn = tfAnvandarnamn.getText();
		String losenord = pfLosenord.getText();
		String[] badLoginForm = { "dfg8udfg0duf", "g7df890gh78f" };

		// Kolla om informationen är giltig att skicka vidare
		if (anvandarnamn.length() == 0 || losenord.length() == 0) {
			JOptionPane.showMessageDialog(null, "Ett av fälten är tomma!");
			return badLoginForm;
		}

		String[] loginForm = { anvandarnamn, losenord };
		return loginForm;
	}

	/**
	 * Starta textrutorna för användarnamn och lösenord
	 * 
	 * @author Prince
	 *
	 */
	private class InloggningsUppgiftsPanel extends JPanel {
		public InloggningsUppgiftsPanel() {
			setSize(800, 50);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			// Användarnamn
			JTextPane tpAnvandarnamn = new JTextPane();
			tpAnvandarnamn.setText("Användarnamn");
			textPaneInit(tpAnvandarnamn);
			tfAnvandarnamn = new JTextField();
			textFieldInit(tfAnvandarnamn);

			// Lösenord
			JTextPane tpLosenord = new JTextPane();
			tpLosenord.setText("Lösenord");
			textPaneInit(tpLosenord);
			pfLosenord = new JPasswordField();
			pfLosenord.setEchoChar('*');
			pfLosenord.setPreferredSize(new Dimension(100, 20));
			pfLosenord.setAlignmentX(Component.LEFT_ALIGNMENT);
			add(pfLosenord, this);
		}

		private void textPaneInit(JTextPane tp) {
			tp.setPreferredSize(new Dimension(100, 20));
			tp.setBorder(null);
			tp.setBackground(new Color(0, 0, 0, 0));
			tp.setEditable(false);
			tp.setHighlighter(null);
			tp.setAlignmentX(Component.LEFT_ALIGNMENT);
			add(tp, this);
		}

		private void textFieldInit(JTextField tf) {
			tf.setPreferredSize(new Dimension(100, 20));
			tf.setAlignmentX(Component.LEFT_ALIGNMENT);
			add(tf, this);
		}
	}

}
