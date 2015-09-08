package model;

public class Kategori {
	private int kategoriID;
	private String namn;
	
	public Kategori(int kategoriID, String namn) {
		super();
		this.kategoriID = kategoriID;
		this.namn = namn;
	}

	public int getKategoriID() {
		return kategoriID;
	}

	public void setKategoriID(int kategoriID) {
		this.kategoriID = kategoriID;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}
	
}
