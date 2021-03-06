package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import gui.BetygssattningsFrame;
import gui.HuvudFrame;
import gui.InloggningsFrame;
import gui.RegistreringsFrame;

/**
 * Startas av main-metoden. Skapar en kommunikation mellan databasen och
 * användargränssnittet
 * 
 * @author Prince
 *
 */
public class HuvudController {

	private DatabasKomController databasKomController;
	private HuvudFrame huvudFrame;
	private RegistreringsFrame registreringsFrame;
	private InloggningsFrame inloggningsFrame;
	private String varaChosen;

	/**
	 * Konstruktorn som startar databaskommunikationen och användargränssnittet
	 */
	public HuvudController() {
		// Starta Databas kommunikationen
		databasKomController = new DatabasKomController();

		// Kom ihåg första varan
		varaChosen = databasKomController.getVaraNamn(1)[0];

		// Starta GUI-tråden
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Ge HuvudFrame kategorilistan och vara-listan
				// i den valda kategorin vid initialisering
				huvudFrame = new HuvudFrame("Projekt", databasKomController.getKategoriNamn(),
						databasKomController.getVaraNamn(1), databasKomController.getVaraDetaljer(1), new GUIListener(),
						new KategoriChangeListener(), new VaraChangeListener());
			}
		});
	}

	/**
	 * Privat klass som lyssnar på knapptryckningar i programmet
	 * 
	 * @author Prince
	 *
	 */
	private class GUIListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("GUI Action detected: " + ae.getActionCommand());

			switch (ae.getActionCommand()) {
			case "Logga ut": // Logga ut knappen i huvudfönstret
				System.out.println("You clicked the Logga ut button in main window");
				huvudFrame.setLoggedIn(false); // Ändra GUI till "inloggad"
				break;
			case "Registrera": // Registrera knappen i huvudfönstret
				System.out.println("You clicked the Registrera button in main window");
				registreringsFrame = new RegistreringsFrame(this);
				break;
			case "Logga in":// Logga in knappen i huvudfönstret
				System.out.println("You clicked the Logga In button in main window");
				inloggningsFrame = new InloggningsFrame(this);
				break;
			case "Registrera.":// Registrera knappen i registreringsrutan
				System.out.println("You clicked the Registrera. button in Registrera window");
				// Hämta former
				String[] formFieldArray = registreringsFrame.getFormFields();

				// Kolla om informationen är giltig
				// registreringsFrame.getFormFields() returnar 0 i första värdet
				// om fälten inte stämmer
				if (formFieldArray[0] == "1") {
					// Skriv ut informationen i konsolen
					System.out.println("----------------------------");
					System.out.println("Kundinformation:");
					for (int i = 1; i < formFieldArray.length; i++) {
						System.out.println(formFieldArray[i]);
					}
					System.out.println("----------------------------");

					// Lägg till kunden i MySQL databasen, eller ge fel om
					// användaren redan existerar!
					boolean registrerad = databasKomController.registreraKund(formFieldArray);
					if (registrerad) {
						JOptionPane.showMessageDialog(null, "Du är nu registrerad!");
						// Stäng ner registrerings-rutan
						registreringsFrame
								.dispatchEvent(new WindowEvent(registreringsFrame, WindowEvent.WINDOW_CLOSING));
					} else {
						JOptionPane.showMessageDialog(null, "Användaren existerar redan i databasen!");
					}
				} else {
					System.out.println("Fel på informationen skriven!");
				}
				break;
			case "Logga in.": // Logga in knappen i logga in rutan
				System.out.println("You clicked the Logga In button in the login window");
				String[] loginForm = inloggningsFrame.getLoginForm();

				// Kolla om formerna är giltiga
				if (loginForm[0] != "dfg8udfg0duf" && loginForm[0] != "g7df890gh78f") {
					System.out.println("-----------------------");
					System.out.println("Login form:");
					System.out.println(loginForm[0]);
					System.out.println(loginForm[1]);
					System.out.println("-----------------------");
					// Kolla om de stämmer med databasen
					boolean loggaInSuccess = databasKomController.loggaInKund(loginForm[0], loginForm[1]);

					if (loggaInSuccess) {
						JOptionPane.showMessageDialog(null, "Välkommen, " + loginForm[0] + "!");
						System.out.println("Inloggad!");
						// Stäng ner registrerings-rutan
						inloggningsFrame.dispatchEvent(new WindowEvent(inloggningsFrame, WindowEvent.WINDOW_CLOSING));
						huvudFrame.setLoggedIn(true); // Ändra GUI till
						// "inloggad"
					}
				}
				break;
			case "Betygsätt": // Betygsätt knappen i huvudfönstret
				System.out.println("You clicked the Betygsätt button in main window");
				new BetygssattningsFrame(this);
				break;
			case "Gilla": // Betygsättningsknapp Gilla
				System.out.println("You clicked the gilla betygsätt button in main window");
				databasKomController.addBetygsattningToDatabase(databasKomController.getVaraID(varaChosen), true);
				// Uppdatera vara detaljer
				huvudFrame.setVaraDetaljer(databasKomController.getVaraDetaljer(varaChosen));
				break;
			case "Ogilla": // Betygsättningsknapp Ogilla
				System.out.println("You clicked the ogilla betygsätt button in main window");
				databasKomController.addBetygsattningToDatabase(databasKomController.getVaraID(varaChosen), false);
				// Uppdatera vara detaljer
				huvudFrame.setVaraDetaljer(databasKomController.getVaraDetaljer(varaChosen));
				break;
			}
		}
	}

	/**
	 * Lyssnare för ändring av kategorin i listan
	 * 
	 * @author Prince
	 *
	 */
	private class KategoriChangeListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent ie) {
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				String kategoriChosen = ie.getItem().toString();
				System.out.println("Valde Kategori: " + kategoriChosen);
				// Uppdatera vara lista
				String[] varaList = databasKomController.getVaraNamn(kategoriChosen);
				huvudFrame.setVaraLista(varaList);
				// Uppdatera vara detaljer
				huvudFrame.setVaraDetaljer(databasKomController.getVaraDetaljer(varaList[0]));
			}
		}
	}

	/**
	 * Lyssnare för ändring av vara i listan
	 * 
	 * @author Prince
	 *
	 */
	private class VaraChangeListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent ie) {
			System.out.println("Chose a new Vara in list");
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				varaChosen = ie.getItem().toString();
				System.out.println("Valde vara: " + varaChosen);
				// Uppdatera vara detaljer
				huvudFrame.setVaraDetaljer(databasKomController.getVaraDetaljer(varaChosen));
			}
		}
	}
}
