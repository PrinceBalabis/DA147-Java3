package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabasKomController implements Runnable{

	public DatabasKomController(){
		(new Thread(this)).start(); // Starta "run()"-funktionen i ny tråd
	}

	@Override
	public void run() {
		System.out.println("Startade DatabasKomController-tråden");
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://178.62.216.84:3306/da147a_project";
		String user = "da147a_project_u";
		String password = "da147a_project_p";
		
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT VERSION()");

			if (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabasKomController.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
