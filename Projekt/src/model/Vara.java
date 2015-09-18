package model;

/**
 * Model för Varor
 * 
 * @author Prince
 *
 */
public class Vara {
	private String namn;
	private int varuID, kategoriID, gillaBetyg, oGillaBetyg;
	private float antal, pris;

	/**
	 * Konstruktor för varan
	 * 
	 * @param namn
	 *            namn
	 * @param varuID
	 *            varans ID
	 * @param kategoriID
	 *            kategorins ID
	 * @param antal
	 *            antal i lager
	 * @param pris
	 *            priset på varan
	 * @param gillaBetyg
	 *            antal gillanden
	 * @param oGillaBetyg
	 *            antal ogillanden
	 */
	public Vara(String namn, int varuID, int kategoriID, float antal, float pris, int gillaBetyg, int oGillaBetyg) {
		super();
		this.namn = namn;
		this.varuID = varuID;
		this.kategoriID = kategoriID;
		this.antal = antal;
		this.pris = pris;
		this.gillaBetyg = gillaBetyg;
		this.oGillaBetyg = oGillaBetyg;
	}

	/**
	 * Hämta varans namn
	 * 
	 * @return namn
	 */
	public String getNamn() {
		return namn;
	}

	/**
	 * Hämta varans ID
	 * 
	 * @return varans ID
	 */
	public int getVaruID() {
		return varuID;
	}

	/**
	 * Hämta kategorins ID
	 * 
	 * @return kategorins ID
	 */
	public int getKategoriID() {
		return kategoriID;
	}

	/**
	 * Hämta antal i lager
	 * 
	 * @return antal i lager
	 */
	public float getAntal() {
		return antal;
	}

	/**
	 * Hämta priset
	 * 
	 * @return priset
	 */
	public float getPris() {
		return pris;
	}

	/**
	 * Hämta antal gillanden
	 * 
	 * @return antal gillanden
	 */
	public int getgillaBetyg() {
		return gillaBetyg;
	}

	/**
	 * Hämta antal ogillanden
	 * 
	 * @return antal ogillanden
	 */
	public int getoGillaBetyg() {
		return oGillaBetyg;
	}
}
