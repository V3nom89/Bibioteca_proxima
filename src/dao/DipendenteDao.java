
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Dipendenti;

public class DipendenteDao {

	public void insert(String n, String c, int m, int f) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "INSERT INTO Dipendenti(nome, cognome, matricola, flag_Admin) VALUES(?,?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, n);
			cmd.setString(2, c);
			cmd.setInt(3, m);
			cmd.setInt(4, f);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public void update(String n, String c, int m, int f, int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "UPDATE Dipendenti SET  nome=?, cognome=?, matricola=?, flag_Admin=? WHERE id=?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, n);
			cmd.setString(2, c);
			cmd.setInt(3, m);
			cmd.setInt(4, f);
			cmd.setInt(5, id);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Update avvenuto con successo!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public void remove(int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "DELETE FROM Dipendenti  WHERE id=?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, id);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Riga eliminata con successo");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public Dipendenti findById(int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Dipendenti dipendenti = null;

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM dipendenti WHERE id = ? ";

			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			// stampiamo i risultati
			while (esiste) {
				int idc = res.getInt("id");
				System.out.println(idc);
				System.out.println(res.getString("nome"));
				System.out.println(res.getString("cognome"));
				System.out.println(res.getInt("matricola"));
				System.out.println(res.getInt("flag_Admin"));
				esiste = res.next();
			}

			dipendenti = new Dipendenti(res.getInt("id"),res.getString("nome"), res.getString("cognome"), res.getInt("matricola"),
					res.getInt("flag_Admin"));

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {

				cmd.close();

			}
			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		return dipendenti;

	}

	public List<Dipendenti> findByAll() throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Dipendenti> dipendenti= new ArrayList<>();
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM dipendenti ";

			cmd = dbConnection.prepareStatement(query);
			

			ResultSet res = cmd.executeQuery();

			
			
			while(res.next()) {
			Dipendenti dip= new Dipendenti();
			dip = new Dipendenti(res.getInt("id"), res.getString("nome"), res.getString("cognome"), res.getInt("matricola"),
					res.getInt("flag_Admin"));
			dipendenti.add(dip);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {

				cmd.close();

			}
			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		return dipendenti;

	}

}