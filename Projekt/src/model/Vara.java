package model;

public class Vara {
	private String namn;
	private int varuID, kategoriID;
	private float antal, pris, betyg;
	
	public Vara(String namn, int varuID, int kategoriID, float antal, float pris, float betyg) {
		super();
		this.namn = namn;
		this.varuID = varuID;
		this.kategoriID = kategoriID;
		this.antal = antal;
		this.pris = pris;
		this.betyg = betyg;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public int getVaruID() {
		return varuID;
	}

	public void setVaruID(int varuID) {
		this.varuID = varuID;
	}

	public int getKategoriID() {
		return kategoriID;
	}

	public void setKategoriID(int kategoriID) {
		this.kategoriID = kategoriID;
	}

	public float getAntal() {
		return antal;
	}

	public void setAntal(float antal) {
		this.antal = antal;
	}

	public float getPris() {
		return pris;
	}

	public void setPris(float pris) {
		this.pris = pris;
	}

	public float getBetyg() {
		return betyg;
	}

	public void setBetyg(float betyg) {
		this.betyg = betyg;
	}
	
}
