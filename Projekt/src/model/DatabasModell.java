package model;

import java.util.ArrayList;

/**
 * Kommunicerar med DatabasKomController för att loktalt kunna lagra
 * databasinformationen för snabb och enkel åtkomst
 * 
 * @author Prince
 *
 */
public class DatabasModell {

	private ArrayList<Kategori> kategoriList = new ArrayList<Kategori>();
	private ArrayList<Kund> kundList = new ArrayList<Kund>();
	private ArrayList<Vara> varaList = new ArrayList<Vara>();

	/**
	 * Konstruktor för databasmodell
	 */
	public DatabasModell() {
		System.out.println("Startade DatabasModell");
	}

	/**
	 * Hämta listan över namn med kategorier
	 * 
	 * @return namn med kategorier
	 */
	public String[] getKategoriNamn() {
		String tempKategoriNamnArray[] = new String[kategoriList.size()];
		for (int i = 0; i < kategoriList.size(); i++) {
			tempKategoriNamnArray[i] = kategoriList.get(i).getNamn();
		}
		return tempKategoriNamnArray;
	}

	/**
	 * Hämta alla varornas namn inom en kategori
	 * 
	 * @param kategoriNamn
	 *            namnet på kategorin
	 * @return listan över varornas namn i en kategori
	 */
	public String[] getVaraNamn(String kategoriNamn) {
		int kategoriID = 0;
		for (int i = 0; i < kategoriList.size(); i++) {
			if (kategoriList.get(i).getNamn().equals(kategoriNamn)) {
				kategoriID = kategoriList.get(i).getKategoriID();
			}
		}
		return getVaraNamn(kategoriID);
	}

	/**
	 * Hämta en varas ID genom att söka efter namnet
	 * 
	 * @param varaNamn
	 *            varans namn
	 * @return varans ID
	 */
	public int getVaraID(String varaNamn) {
		int varaID = 0;
		for (int i = 0; i < varaList.size(); i++) {
			if (varaList.get(i).getNamn().equals(varaNamn)) {
				varaID = varaList.get(i).getVaruID();
			}
		}
		return varaID;
	}

	/**
	 * Hämta varans detaljer genom att söka efter namn
	 * 
	 * @param varaNamn
	 *            varans namn
	 * @return varans detaljer
	 */
	public String[] getVaradetaljer(String varaNamn) {
		return getVaradetaljer(getVaraID(varaNamn));
	}

	/**
	 * Hämta varans detaljer genom att söka efter varans ID
	 * 
	 * @param varaID
	 *            varans ID
	 * @return varans detaljer
	 */
	public String[] getVaradetaljer(int varaID) {
		String[] varaDetaljer = new String[5];
		for (int i = 0; i < varaList.size(); i++) {
			if (varaList.get(i).getVaruID() == varaID) {
				varaDetaljer[0] = varaList.get(i).getNamn();
				varaDetaljer[1] = String.valueOf(varaList.get(i).getgillaBetyg());
				varaDetaljer[2] = String.valueOf(varaList.get(i).getoGillaBetyg());
				varaDetaljer[3] = String.valueOf(varaList.get(i).getPris());
				varaDetaljer[4] = String.valueOf(varaList.get(i).getAntal());
			}
		}
		return varaDetaljer;
	}

	/**
	 * Hämta lista över varornas namn i en kategori genom att söka efter
	 * kategorins ID
	 * 
	 * @param kategoriID
	 *            kategorins ID
	 * @return lista över varornas namn i en kategori
	 */
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

	/**
	 * Lägg till en ny Kategori-Modell
	 * 
	 * @param kategoriID
	 *            ID för kategorin
	 * @param namn
	 *            namn på kategorin
	 */
	public void addKategori(int kategoriID, String namn) {
		kategoriList.add(new Kategori(kategoriID, namn));
	}

	/**
	 * Lägg till en ny Kund-modell
	 * 
	 * @param namn
	 *            namn på kunden
	 * @param address
	 *            adressen
	 * @param anvandarnamn
	 *            användarnamnet
	 * @param losenord
	 *            lösenordet
	 * @param personnummer
	 *            personnumret
	 * @param telefonnummer
	 *            telefonnumret
	 */
	public void addKund(String namn, String address, String anvandarnamn, String losenord, double personnummer,
			double telefonnummer) {
		kundList.add(new Kund(namn, address, anvandarnamn, losenord, personnummer, telefonnummer));
	}

	/**
	 * Återstället varalist för att kunna uppdatera lokal information
	 */
	public void resetVaraList() {
		varaList.clear();
	}

	/**
	 * Lägger till en ny Vara-modell
	 * 
	 * @param namn
	 *            namn på varans
	 * @param varuID
	 *            varans ID
	 * @param kategoriID
	 *            kategorins ID för varan
	 * @param antal
	 *            antal i lager
	 * @param pris
	 *            priset på varan
	 * @param gillaBetyg
	 *            antal gillanden
	 * @param oGillaBetyg
	 *            antal ogillanden
	 */
	public void addVara(String namn, int varuID, int kategoriID, float antal, float pris, int gillaBetyg,
			int oGillaBetyg) {
		varaList.add(new Vara(namn, varuID, kategoriID, antal, pris, gillaBetyg, oGillaBetyg));
	}

}
