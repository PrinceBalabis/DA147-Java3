package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class HuvudFrame extends JFrame {

	private JButton registreraButton, loggaInButton;
	private JComboBox<String> kategoriList, varaList;
	private VaraDetaljPanel varaDetaljPanel;

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
		add(new KundPanel(al), c);

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
		c.ipady = 40; // make this component tall
		varaDetaljPanel = new VaraDetaljPanel(varaDetaljArray, al);
		add(varaDetaljPanel, c);

		setVisible(true);
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

		public KundPanel(ActionListener l) {
			setSize(400, 50);

			// Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Kund panelen");
			setBorder(title);

			// Buttons
			registreraButton = new JButton("Registrera");
			registreraButton.addActionListener(l);
			loggaInButton = new JButton("Logga in");
			loggaInButton.addActionListener(l);
			add(registreraButton);
			add(loggaInButton);
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
		private float antal, pris, betyg;
		private JTextPane varuTitle, varuPris, varuLager, varuBetyg;
		private JButton betygssatt;
		
		public VaraDetaljPanel(String[] varaDetaljArray, ActionListener al) {
			// Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Vara-detaljer");
			setBorder(title);

			// Layout
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

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
//			betygssatt = new JButton("Logga in för att betygssätta");
//			c.fill = GridBagConstraints.HORIZONTAL;
//			c.gridx = 3;
//			c.gridy = 1;
//			c.weightx = 0.0;
//			c.gridwidth = 1;
//			add(betygssatt, c);

			// Parsa information från arrayen
			setVaraDetaljer(varaDetaljArray);
		}

		public void setVaraDetaljer(String[] varaDetaljArray) {
			varaNamn = varaDetaljArray[0];
			betyg = Float.parseFloat(varaDetaljArray[1]);
			pris = Float.parseFloat(varaDetaljArray[2]);
			antal = Float.parseFloat(varaDetaljArray[3]);
			// Visa alla vara detaljer i GUI
			varuTitle.setText("Namn: " + varaNamn);
			varuPris.setText("Pris: " + String.valueOf(pris) + " kr");
			varuLager.setText("Lager: " + String.valueOf(antal) + " st");
			varuBetyg.setText("Betyg: " + betyg + " av 5");
		}
	}
}