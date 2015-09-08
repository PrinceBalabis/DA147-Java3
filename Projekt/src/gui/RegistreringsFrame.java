package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class RegistreringsFrame extends JFrame{

	public RegistreringsFrame(){
		super("Registrering");
		setSize(400, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setResizable(false);
		
		add(new KundRegistreringsPanel(), BorderLayout.CENTER); // Lägg till Panelen med textfält
		
		//Lägg till "Registrera" knappen
		JButton btnRegistrera = new JButton();
		btnRegistrera.setText("Registrera");
		add(btnRegistrera, BorderLayout.SOUTH);
		
        //pack();
		setVisible(true);
	}

	private class KundRegistreringsPanel extends JPanel{

		public KundRegistreringsPanel(){
			setSize(800, 600);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			//Namn
			JTextPane tpNamn = new JTextPane();
			tpNamn.setText("Namn");
			textPaneInit(tpNamn);
			JTextField tfNamn = new JTextField();
			textFieldInit(tfNamn);
			
			//Personnummer
			JTextPane tpPersonnummer = new JTextPane();
			tpPersonnummer.setText("Personnummer");
			textPaneInit(tpPersonnummer);
			JTextField tfPersonnummer = new JTextField();
			textFieldInit(tfPersonnummer);
			
			//Adress
			JTextPane tpAdress = new JTextPane();
			tpAdress.setText("Adress");
			textPaneInit(tpAdress);
			JTextField tfAdress = new JTextField();
			textFieldInit(tfAdress);
			
			//Telefonnummer
			JTextPane tpTelefonnummer = new JTextPane();
			tpTelefonnummer.setText("Telefonnummer");
			textPaneInit(tpTelefonnummer);
			JTextField tfTelefonnummer = new JTextField();
			textFieldInit(tfTelefonnummer);
			
			//Användarnamn
			JTextPane tpAnvandarnamn = new JTextPane();
			tpAnvandarnamn.setText("Användarnamn");
			textPaneInit(tpAnvandarnamn);
			JTextField tfAnvandarnamn = new JTextField();
			textFieldInit(tfAnvandarnamn);
			
			//Lösenord
			JTextPane tpLosenord = new JTextPane();
			tpLosenord.setText("Lösenord");
			textPaneInit(tpLosenord);
			JPasswordField pfLosenord = new JPasswordField();
			pfLosenord.setEchoChar('*') ;
			pfLosenord.setPreferredSize(new Dimension(100, 20));
			pfLosenord.setAlignmentX(Component.LEFT_ALIGNMENT);
			add(pfLosenord, this);
		}
		
		private void textPaneInit(JTextPane tp){
			tp.setPreferredSize(new Dimension(100, 20));
			tp.setBorder(null);
			tp.setBackground(new Color(0, 0, 0, 0));
			tp.setEditable(false);
			tp.setHighlighter(null);
			tp.setAlignmentX(Component.LEFT_ALIGNMENT);
			add(tp, this);
		}
		
		private void textFieldInit(JTextField tf){
			tf.setPreferredSize(new Dimension(100, 20));
			tf.setAlignmentX(Component.LEFT_ALIGNMENT);
			add(tf, this);
		}
	}
}
