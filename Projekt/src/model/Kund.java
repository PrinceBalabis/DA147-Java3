package model;

/**
 * Model för Kunder
 * 
 * @author Prince
 *
 */
public class Kund {

	private String namn, address, anvandarnamn, losenord;
	private double personnummer, telefonnummer;

	/**
	 * Konstruktor som tar emot all information för kunden
	 * 
	 * @param namn
	 *            namnet på kunden
	 * @param address
	 *            adress
	 * @param anvandarnamn
	 *            användarnamn
	 * @param losenord
	 *            lösenord
	 * @param personnummer
	 *            personnummer
	 * @param telefonnummer
	 *            telefonnummer
	 */
	public Kund(String namn, String address, String anvandarnamn, String losenord, double personnummer,
			double telefonnummer) {
		super();
		this.namn = namn;
		this.address = address;
		this.anvandarnamn = anvandarnamn;
		this.losenord = losenord;
		this.personnummer = personnummer;
		this.telefonnummer = telefonnummer;
	}

	/**
	 * Hämta namnet på kunden
	 * 
	 * @return kundens namn
	 */
	public String getNamn() {
		return namn;
	}

	/**
	 * Hämta adressen
	 * 
	 * @return adress
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Hämta användarnamn
	 * 
	 * @return användarnamn
	 */
	public String getAnvandarnamn() {
		return anvandarnamn;
	}

	/**
	 * Hämta lösenord
	 * 
	 * @return lösenord
	 */
	public String getLosenord() {
		return losenord;
	}

	/**
	 * Hämta personnummer
	 * 
	 * @return personnummer
	 */
	public double getPersonnummer() {
		return personnummer;
	}

	/**
	 * Hämta telefonnumer
	 * 
	 * @return telefonnummer
	 */
	public double getTelefonnummer() {
		return telefonnummer;
	}

}
