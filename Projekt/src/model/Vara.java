package model;

public class Vara {
	private String namn;
	private int varuID, kategoriID, gillaBetyg, oGillaBetyg;
	private float antal, pris;
	
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

	public String getNamn() {
		return namn;
	}

	public int getVaruID() {
		return varuID;
	}

	public int getKategoriID() {
		return kategoriID;
	}

	public float getAntal() {
		return antal;
	}

	public float getPris() {
		return pris;
	}

	public int getgillaBetyg() {
		return gillaBetyg;
	}
	
	public int getoGillaBetyg() {
		return oGillaBetyg;
	}
}
