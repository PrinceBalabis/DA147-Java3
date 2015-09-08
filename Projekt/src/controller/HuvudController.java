package controller;

import gui.HuvudFrame;

public class HuvudController {

	public HuvudController(){
		// Starta GUI-tråden
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new HuvudFrame("Projekt");
			}
		});
	}
	
	// Starta Databas kommunikation-tråden
	DatabasKomController databasKomController = new DatabasKomController();
}
