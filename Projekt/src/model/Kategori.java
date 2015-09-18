package model;

/**
 * Model för Kategorier
 * 
 * @author Prince
 *
 */
public class Kategori {
	private int kategoriID;
	private String namn;

	/**
	 * Konstruktor för kategorin
	 * 
	 * @param kategoriID
	 *            kategorins ID
	 * @param namn
	 *            namnet på kategorin
	 */
	public Kategori(int kategoriID, String namn) {
		super();
		this.kategoriID = kategoriID;
		this.namn = namn;
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
	 * Hämta namnet på kategorin
	 * 
	 * @return kategorins namn
	 */
	public String getNamn() {
		return namn;
	}
}
