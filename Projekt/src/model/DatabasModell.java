package model;

import java.util.ArrayList;

public class DatabasModell {

	private ArrayList<Kategori> kategoriList = new ArrayList<Kategori>();
	private ArrayList<Kund> kundList = new ArrayList<Kund>();
	private ArrayList<Vara> varaList = new ArrayList<Vara>();

	public DatabasModell() {
		System.out.println("Startade DatabasModell");
	}

	public String[] getKategoriNamn() {
		String tempKategoriNamnArray[] = new String[kategoriList.size()];
		for (int i = 0; i < kategoriList.size(); i++) {
			tempKategoriNamnArray[i] = kategoriList.get(i).getNamn();
		}
		return tempKategoriNamnArray;
	}

	public String[] getVaraNamn(String kategoriNamn) {
		int kategoriID = 0;
		for (int i = 0; i < kategoriList.size(); i++) {
			if (kategoriList.get(i).getNamn().equals(kategoriNamn)) {
				kategoriID = kategoriList.get(i).getKategoriID();
			}
		}
		return getVaraNamn(kategoriID);
	}
	
	public String[] getVaradetaljer(String varaNamn) {
		int varaID = 0;
		for (int i = 0; i < varaList.size(); i++) {
			if (varaList.get(i).getNamn().equals(varaNamn)) {
				varaID = varaList.get(i).getVaruID();
			}
		}
		return getVaradetaljer(varaID);
	}
	
	public String[] getVaradetaljer(int varaID) {
		String[] varaDetaljer = new String[4];
		for (int i = 0; i < varaList.size(); i++) {
			if (varaList.get(i).getVaruID() == varaID) {
				varaDetaljer[0] = varaList.get(i).getNamn();
				varaDetaljer[1] = String.valueOf(varaList.get(i).getBetyg());
				varaDetaljer[2] = String.valueOf(varaList.get(i).getPris());
				varaDetaljer[3] = String.valueOf(varaList.get(i).getAntal());
			}
		}
		return varaDetaljer;
	}

	public String[] getVaraNamn(int kategoriID) {
		ArrayList<String> tempVaraListiKategori = new ArrayList<String>();
		// Stämmer kategoriID med varan så spara det temporärt i Arraylist
		for (int i = 0; i < varaList.size(); i++) {
			if (varaList.get(i).getKategoriID() == kategoriID) {
				tempVaraListiKategori.add(varaList.get(i).getNamn());
			}
		}
		// Convertera ArrayList till array och skicka tillbaka
		return tempVaraListiKategori.toArray(new String[tempVaraListiKategori.size()]);
	}

	public void addKategori(int kategoriID, String namn) {
		kategoriList.add(new Kategori(kategoriID, namn));
	}

	public void addKund(String namn, String address, String anvandarnamn, String losenord, double personnummer,
			double telefonnummer) {
		kundList.add(new Kund(namn, address, anvandarnamn, losenord, personnummer, telefonnummer));
	}

	public void addVara(String namn, int varuID, int kategoriID, float antal, float pris, float betyg) {
		varaList.add(new Vara(namn, varuID, kategoriID, antal, pris, betyg));
	}

}
