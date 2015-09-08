package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class InloggningsFrame extends JFrame {

	public InloggningsFrame(){
		super("Inloggning");
		setSize(400, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setResizable(false);
		
		add(new InloggningsUppgiftsPanel(), BorderLayout.CENTER); // Lägg till Panelen med textfält
		
		//Lägg till "Logga in" knappen
		JButton btnLoggaIn = new JButton();
		btnLoggaIn.setText("Logga in");
		add(btnLoggaIn, BorderLayout.SOUTH);
		
        pack();
		setVisible(true);
	}
	
	private class InloggningsUppgiftsPanel extends JPanel{
		public InloggningsUppgiftsPanel(){
			setSize(800, 50);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
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
