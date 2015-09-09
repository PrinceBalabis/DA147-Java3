package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.DatabasModell;

public class DatabasKomController {

	private DatabasModell databasModell;

	private String url = "jdbc:mysql://178.62.216.84:3306/da147a_project";
	private String user = "da147a_project_u";
	private String password = "da147a_project_p";

	public DatabasKomController() {
		System.out.println("Startade DatabasKomController");

		// Starta DatabasModell
		databasModell = new DatabasModell();

		// Hämta kategorierna från MySQL databasen
		getKategoriFromDatabase();
		// Hämta kunderna från MySQL databasen
		getKundFromDatabase();
		// Hämta varorna från MySQL databasen
		getVaraFromDatabase();
	}

	public String[] getKategoriNamn() {
		return databasModell.getKategoriNamn();
	}

	public String[] getVaraNamn(int kategoriID) {
		return databasModell.getVaraNamn(kategoriID);
	}

	public String[] getVaraNamn(String kategoriNamn) {
		return databasModell.getVaraNamn(kategoriNamn);
	}

	public String[] getVaraDetaljer(int varaID) {
		return databasModell.getVaradetaljer(varaID);
	}

	public String[] getVaraDetaljer(String varaNamn) {
		return databasModell.getVaradetaljer(varaNamn);
	}

	/**
	 * Kallas för att registrera ny kund kolla om användaren redan existerar
	 * 
	 * @return true om kunden lyckades registrera, false om personnumret eller
	 *         användarnamnet redan existerar!
	 */
	public boolean registreraKund(String[] kundInformation) {

		String namn = kundInformation[1];
		String personnummer = kundInformation[2];
		String adress = kundInformation[3];
		String telefonnummer = kundInformation[4];
		String anvandarnamn = kundInformation[5];
		String losenord = kundInformation[6];

		ResultSet rs = null;
		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();

			// Kolla om peronnumret redan existerar!
			rs = st.executeQuery("SELECT * FROM `Kund` WHERE `personnummer` LIKE '" + personnummer + "'");
			if (rs.next()) {
				System.out.println("Personnummer existerar redan i databasen!");
				return false;
			} else {
				System.out.println("Personnummer finns inte redan med i databasen!!");
			}

			// Lägg till kunden i databasen!
			st.executeUpdate(
					"INSERT INTO `da147a_project`.`Kund` (`namn`, `personnummer`, `address`, `telefonnummer`, `anvandarnamn`, `losenord`) VALUES ('"
							+ namn + "', '" + personnummer + "', '" + adress + "', '" + telefonnummer + "', '"
							+ anvandarnamn + "', '" + losenord + "');");

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}

		return true;
	}

	/**
	 * Hämtar listan med kategorier från MySQl databasen och lagrar lokalt i
	 * DatabasModell
	 */
	private void getKategoriFromDatabase() {
		ResultSet rs = null;
		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Kategori");

			while (rs.next()) {
				int kategoriID = rs.getInt("kategoriID");
				String namn = rs.getString("namn");
				databasModell.addKategori(kategoriID, namn);
				System.out.println("Lade till kategori; ID: " + kategoriID + ", Namn: " + namn);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}

	/**
	 * Hämtar listan med kunder från MySQl databasen och lagrar lokalt i
	 * DatabasModell
	 */
	private void getKundFromDatabase() {
		ResultSet rs = null;
		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Kund");

			while (rs.next()) {
				String namn = rs.getString("namn");
				String address = rs.getString("address");
				String anvandarnamn = rs.getString("anvandarnamn");
				String losenord = rs.getString("losenord");
				double personnummer = rs.getFloat("personnummer");
				double telefonnummer = rs.getFloat("telefonnummer");
				databasModell.addKund(namn, address, anvandarnamn, losenord, personnummer, telefonnummer);
				System.out.println("Lade till kund; " + namn + ", " + address + ", " + anvandarnamn + ", " + losenord
						+ ", " + personnummer + ", " + telefonnummer);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}

	/**
	 * Hämtar listan med varor från MySQl databasen och lagrar lokalt i
	 * DatabasModell
	 */
	private void getVaraFromDatabase() {
		ResultSet rs = null;
		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Vara");

			while (rs.next()) {
				String namn = rs.getString("namn");
				int varuID = rs.getInt("varuID");
				int kategoriID = rs.getInt("kategoriID");
				float antal = rs.getFloat("antal");
				float pris = rs.getFloat("pris");
				float betyg = rs.getFloat("betyg");
				databasModell.addVara(namn, varuID, kategoriID, antal, pris, betyg);
				System.out.println("Lade till vara; " + namn + ", " + varuID + ", " + kategoriID + ", " + antal + ", "
						+ pris + ", " + betyg);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}
}
