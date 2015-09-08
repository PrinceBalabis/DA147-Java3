package model;

public class Kund {
	
	private String namn, address, anvandarnamn, losenord;
	private float personnummer, telefonnummer;
	
	public Kund(String namn, String address, String anvandarnamn, String losenord, float personnummer,
			float telefonnummer) {
		super();
		this.namn = namn;
		this.address = address;
		this.anvandarnamn = anvandarnamn;
		this.losenord = losenord;
		this.personnummer = personnummer;
		this.telefonnummer = telefonnummer;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAnvandarnamn() {
		return anvandarnamn;
	}

	public void setAnvandarnamn(String anvandarnamn) {
		this.anvandarnamn = anvandarnamn;
	}

	public String getLosenord() {
		return losenord;
	}

	public void setLosenord(String losenord) {
		this.losenord = losenord;
	}

	public float getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(float personnummer) {
		this.personnummer = personnummer;
	}

	public float getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(float telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	
}
