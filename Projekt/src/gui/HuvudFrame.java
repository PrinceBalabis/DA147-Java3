package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class HuvudFrame extends JFrame {

	private JButton btnRegistreraButton, btnLoggaInButton, btnBetygsatt;
	private JComboBox<String> kategoriList, varaList;
	private VaraDetaljPanel varaDetaljPanel;
	private KundPanel kundPanel;

	public HuvudFrame(String title, String[] kategoriNamnArray, String[] varaNamnArray, String[] varaDetaljArray,
			ActionListener al, ItemListener kcl, ItemListener vcl) {
		super(title);
		System.out.println("Startade Huvudrutan(GUI)-tråden");
		setSize(400, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		c.gridwidth = 2;
		kundPanel = new KundPanel(al);
		add(kundPanel, c);

		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		add(new KategoriPanel(kategoriNamnArray, kcl), c);

		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		add(new VaraPanel(varaNamnArray, vcl), c);

		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.ipady = 40;
		varaDetaljPanel = new VaraDetaljPanel(varaDetaljArray, al);
		add(varaDetaljPanel, c);
		
		setLoggedIn(false); // Ta bort betygsättningsknapp

		setVisible(true);
	}

	/**
	 * Funktionen kallas för att andra huvudfönstret till ett för inloggade kunder
	 */
	public void setLoggedIn(boolean status){
		if(status){ // Sätt till inloggad
			btnLoggaInButton.setText("Logga ut");
			kundPanel.remove(btnRegistreraButton); // Ta bort regisrera knappen
			btnBetygsatt.setEnabled(true);
		} else { // Set till utloggad
			btnLoggaInButton.setText("Logga in");
			kundPanel.add(btnRegistreraButton); // Lägg till registrera knappen
			btnBetygsatt.setEnabled(false);
		}
	}
	
	
	public void updateVaraDetaljer(String[] varaDetaljArray){
		varaDetaljPanel.setVaraDetaljer(varaDetaljArray);
	}
	
	public void setVaraLista(String[] varaList) {
		DefaultComboBoxModel model = new DefaultComboBoxModel(varaList);
		this.varaList.setModel(model);
	}

	public int getCurrentlySelectedKategori() {
		return kategoriList.getSelectedIndex();
	}

	public int getCurrentlySelectedVara() {
		return varaList.getSelectedIndex();
	}

	private class KundPanel extends JPanel {

		public KundPanel(ActionListener al) {
			setSize(400, 50);

			// Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Kund panelen");
			setBorder(title);
			
			// Logga in button
			btnLoggaInButton = new JButton("Logga in");
			btnLoggaInButton.addActionListener(al);
			add(btnLoggaInButton);

			// Registrera button
			btnRegistreraButton = new JButton("Registrera");
			btnRegistreraButton.addActionListener(al);
			add(btnRegistreraButton);
		}
	}

	private class KategoriPanel extends JPanel {

		public KategoriPanel(String[] kategoriNamnArray, ItemListener il) {
			setSize(400, 50);

			// Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Kategorier");
			setBorder(title);

			// Combobox
			kategoriList = new JComboBox<String>(kategoriNamnArray);
			kategoriList.setSelectedIndex(0); // Välj första kategorin i listan
			// för att synka med vara-listan
			kategoriList.addItemListener(il);
			add(kategoriList);
		}
	}

	private class VaraPanel extends JPanel {

		public VaraPanel(String[] varaNamnArray, ItemListener il) {
			setSize(400, 50);

			// Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Varor");
			setBorder(title);

			// Combobox
			varaList = new JComboBox<String>(varaNamnArray);
			varaList.setSelectedIndex(0);
			varaList.addItemListener(il);
			add(varaList);
		}
	}

	private class VaraDetaljPanel extends JPanel {
		private String varaNamn;
		private float antal, pris;
		private int gillaBetyg, oGillaBetyg;
		private JTextPane varuTitle, varuPris, varuLager, varuBetyg;
		private GridBagConstraints c;
		
		public VaraDetaljPanel(String[] varaDetaljArray, ActionListener al) {
			// Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Vara-detaljer");
			setBorder(title);

			// Layout
			setLayout(new GridBagLayout());
			c = new GridBagConstraints();

			// Vara titel
			varuTitle = new JTextPane();
			varuTitle.setBorder(null);
			varuTitle.setBackground(new Color(0, 0, 0, 0));
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			c.weightx = 0.0;
			c.gridwidth = 2;
			add(varuTitle, c);

			// Vara pris
			varuPris = new JTextPane();
			varuPris.setBorder(null);
			varuPris.setBackground(new Color(0, 0, 0, 0));
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			c.weightx = 0.0;
			c.gridwidth = 1;
			add(varuPris, c);

			// Vara lager antal
			varuLager = new JTextPane();
			varuLager.setBorder(null);
			varuLager.setBackground(new Color(0, 0, 0, 0));
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			c.weightx = 0.0;
			c.gridwidth = 1;
			add(varuLager, c);

			// Vara medelbetyg
			varuBetyg = new JTextPane();
			varuBetyg.setBorder(null);
			varuBetyg.setBackground(new Color(0, 0, 0, 0));
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 3;
			c.gridy = 0;
			c.weightx = 0.0;
			c.gridwidth = 1;
			add(varuBetyg, c);

			// Betygssättningsknapp
			btnBetygsatt = new JButton("Betygsätt");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 3;
			c.gridy = 1;
			c.weightx = 0.0;
			c.gridwidth = 1;
			btnBetygsatt.addActionListener(al);
			add(btnBetygsatt, c);
			btnBetygsatt.setEnabled(false);

			// Parsa information från arrayen
			setVaraDetaljer(varaDetaljArray);
		}
		
		public void setVaraDetaljer(String[] varaDetaljArray) {
			varaNamn = varaDetaljArray[0];
			gillaBetyg = Integer.parseInt(varaDetaljArray[1]);
			oGillaBetyg = Integer.parseInt(varaDetaljArray[2]);
			pris = Float.parseFloat(varaDetaljArray[3]);
			antal = Float.parseFloat(varaDetaljArray[4]);
			// Visa alla vara detaljer i GUI
			varuTitle.setText("Namn: " + varaNamn);
			varuPris.setText("Pris: " + String.valueOf(pris) + " kr");
			varuLager.setText("Lager: " + String.valueOf(antal) + " st");
			DecimalFormat df = new DecimalFormat("0.00");
			df.setMaximumFractionDigits(2);
			varuBetyg.setText("Medelbetyg: " + df.format(((float)gillaBetyg/(float)(gillaBetyg+oGillaBetyg))) + " Gillar: " + gillaBetyg + ", Ogillar: " + oGillaBetyg);
		}
	}
}