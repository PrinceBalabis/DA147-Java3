package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.NumberFormatter;

/**
 * Användargränssnittet för registrering
 * 
 * @author Prince
 *
 */
public class RegistreringsFrame extends JFrame {

	JTextField tfNamn, tfAdress, tfAnvandarnamn, tfPersonnummer, tfTelefonnummer;
	JPasswordField pfLosenord;

	/**
	 * Konstruktor som startar användargränssnittet för registrering
	 * 
	 * @param al
	 *            ActionListener för registrera-knappen
	 */
	public RegistreringsFrame(ActionListener al) {
		super("Registrering");
		setSize(400, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		add(new KundRegistreringsPanel(), BorderLayout.CENTER); // Lägg till
		// Panelen med
		// textfält

		// Lägg till "Registrera" knappen
		JButton btnRegistrera = new JButton();
		btnRegistrera.setText("Registrera.");
		btnRegistrera.addActionListener(al);
		add(btnRegistrera, BorderLayout.SOUTH);

		// pack();
		setVisible(true);
	}

	/**
	 * Hämta all information skriven i text-rutorna
	 * 
	 * @return All information skriven i textrutorna
	 */
	public String[] getFormFields() {
		String namn = tfNamn.getText();
		String personnummer = tfPersonnummer.getText();
		String adress = tfAdress.getText();
		String telefonnummer = tfTelefonnummer.getText();
		String anvandarnamn = tfAnvandarnamn.getText();
		String losenord = pfLosenord.getText();
		String[] tempFormFieldArray = { "0" }; // Denna returneras om ett eller
		// flera av fälten är ogiltiga

		Pattern p = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
		// Kolla om personumret stämmer
		Matcher m = p.matcher(personnummer);
		if (!m.find() || (personnummer.length() != 10)) {
			// Stämmer inte personnumret visas ett error dialog
			JOptionPane.showMessageDialog(null, "Personnummer stämmer INTE!");
			return tempFormFieldArray;
		}

		// Kolla om telefonnumret stämmer
		m = p.matcher(telefonnummer);
		if (!m.find()) {
			// Stämmer inte personnumret visas ett error dialog
			JOptionPane.showMessageDialog(null, "Telefonnummret stämmer INTE!");
			return tempFormFieldArray;
		}

		// Kolla så att alla fält är fyllda
		if (namn.length() == 0) {
			JOptionPane.showMessageDialog(null, "Namn fältet är tomt!");
			return tempFormFieldArray;
		} else if (adress.length() == 0) {
			JOptionPane.showMessageDialog(null, "Adress fältet är tomt");
			return tempFormFieldArray;
		} else if (telefonnummer.length() == 0) {
			JOptionPane.showMessageDialog(null, "Telefonnummer fältet är tomt");
			return tempFormFieldArray;
		} else if (anvandarnamn.length() == 0) {
			JOptionPane.showMessageDialog(null, "Anvandarnamn fältet är tomt");
			return tempFormFieldArray;
		} else if (losenord.length() == 0) {
			JOptionPane.showMessageDialog(null, "Lösenord fältet är tomt");
			return tempFormFieldArray;
		}

		// Om alla fält stämmer då skickar vi fälten tillbaka
		String[] tempFinalFormFieldArray = { "1", namn, personnummer, adress, telefonnummer, anvandarnamn, losenord };
		return tempFinalFormFieldArray;
	}

	/**
	 * Användargränssnittet för registreringen
	 * 
	 * @author Prince
	 *
	 */
	private class KundRegistreringsPanel extends JPanel {
		NumberFormatter formatter;

		public KundRegistreringsPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			// Namn
			JTextPane tpNamn = new JTextPane();
			tpNamn.setText("Namn");
			textPaneInit(tpNamn);
			tfNamn = new JTextField(300); // Max 300 characters
			textFieldInit(tfNamn);

			// Personnummer
			JTextPane tpPersonnummer = new JTextPane();
			tpPersonnummer.setText("Personnummer");
			textPaneInit(tpPersonnummer);
			tfPersonnummer = new JTextField();
			textFieldInit(tfPersonnummer);

			// Adress
			JTextPane tpAdress = new JTextPane();
			tpAdress.setText("Adress");
			textPaneInit(tpAdress);
			tfAdress = new JTextField(300); // Max 300 characters
			textFieldInit(tfAdress);

			// Telefonnummer
			JTextPane tpTelefonnummer = new JTextPane();
			tpTelefonnummer.setText("Telefonnummer");
			textPaneInit(tpTelefonnummer);
			tfTelefonnummer = new JTextField();
			textFieldInit(tfTelefonnummer);

			// Användarnamn
			JTextPane tpAnvandarnamn = new JTextPane();
			tpAnvandarnamn.setText("Användarnamn");
			textPaneInit(tpAnvandarnamn);
			tfAnvandarnamn = new JTextField(300); // Max 300 characters
			textFieldInit(tfAnvandarnamn);

			// Lösenord
			JTextPane tpLosenord = new JTextPane();
			tpLosenord.setText("Lösenord");
			textPaneInit(tpLosenord);
			pfLosenord = new JPasswordField(300); // Max 300 characters
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

		private void textFieldInit(JFormattedTextField ftf) {
			ftf.setPreferredSize(new Dimension(100, 20));
			ftf.setAlignmentX(Component.LEFT_ALIGNMENT);
			add(ftf, this);
		}
	}
}
