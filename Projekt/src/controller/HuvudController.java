package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.HuvudFrame;
import gui.InloggningsFrame;
import gui.RegistreringsFrame;
import model.DatabasModell;

public class HuvudController {

	private DatabasKomController databasKomController;
	private HuvudFrame huvudframe;
	
	public HuvudController() {
		// Starta Databas kommunikationen
		databasKomController = new DatabasKomController();
		
		// Starta GUI-tråden
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Ge HuvudFrame kategorilistan och vara-listan 
				//i den valda kategorin vid initialisering
				huvudframe = new HuvudFrame("Projekt", databasKomController.getKategoriNamn(), databasKomController.getVaraNamn(1));
				huvudframe.addGUIListener(new GUIListener());
			}
		});
	}
	
	private class GUIListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			switch(ae.getActionCommand()){
			case "Registrera":
				System.out.println("You clicked the Registrera button");
				new RegistreringsFrame();				
				break;
			case "Logga In":
				System.out.println("You clicked the Logga In button");
				new InloggningsFrame();
				break;
			}
		}
	}
}
