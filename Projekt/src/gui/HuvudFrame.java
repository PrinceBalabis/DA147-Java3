package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class HuvudFrame extends JFrame{

	public HuvudFrame(String title){
		super(title);
		setSize(400, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable(false);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();		

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		c.gridwidth = 2;
		add(new KundPanel(), c);

		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		add(new KategoriPanel(), c);

		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		add(new VaruPanel(), c);

		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.ipady = 40;      //make this component tall
		add(new VaruDetaljPanel(), c);

		setVisible(true);
	}

	private class KundPanel extends JPanel{

		public KundPanel(){
			setSize(400, 50);

			//Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Kund panelen");
			setBorder(title);

			//Buttons
			JButton registreraButton = new JButton("Registrera");
			JButton loggaInButton = new JButton("Logga in");
			add(registreraButton);
			add(loggaInButton);
			registreraButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					//Execute when button is pressed
					System.out.println("You clicked the Registrera button");
					new RegistreringsFrame();
				}

			});
		}
	}

	private class KategoriPanel extends JPanel{

		public KategoriPanel(){
			setSize(400, 50);

			//Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Kategorier");
			setBorder(title);

			//Combobox
			String[] kategoriStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
			JComboBox kategoriList = new JComboBox(kategoriStrings);
			kategoriList.setSelectedIndex(4);
			add(kategoriList);
			//petList.addActionListener(this);
		}
	}

	private class VaruPanel extends JPanel{

		public VaruPanel(){
			setSize(400, 50);

			//Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Varor");
			setBorder(title);

			//Combobox
			String[] VaruStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
			JComboBox VaruList = new JComboBox(VaruStrings);
			VaruList.setSelectedIndex(4);
			add(VaruList);
			//petList.addActionListener(this);
		}
	}

	private class VaruDetaljPanel extends JPanel{

		public VaruDetaljPanel(){
			//Title border
			TitledBorder title;
			title = BorderFactory.createTitledBorder("Varu-detaljer");
			setBorder(title);

			//setSize(400, 10);

			LeftPanel leftPanel = new LeftPanel();

			// Layout
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();		


			// Vara titel
			JTextPane varuTitle = new JTextPane();
			varuTitle.setText("varuTitle");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			c.weightx = 0.0;
			c.gridwidth = 2;
			add(varuTitle, c);

			// Vara pris
			JTextPane varuPris = new JTextPane();
			varuPris.setText("varuPris");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			c.weightx = 0.0;
			c.gridwidth = 1;
			add(varuPris, c);

			// Vara lager antal
			JTextPane varuLager = new JTextPane();
			varuLager.setText("varuLager");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			c.weightx = 0.0;
			c.gridwidth = 1;
			add(varuLager, c);

			// Vara medelbetyg
			JTextPane varuBetyg = new JTextPane();
			varuBetyg.setText("varuBetyg");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 3;
			c.gridy = 0;
			c.weightx = 0.0;
			c.gridwidth = 1;

			add(varuBetyg, c);
		}

		private class LeftPanel extends JPanel{

			public LeftPanel(){
			}

		}

		private class RightPanel extends JPanel{

			public RightPanel(){
			}

		}

	}

}