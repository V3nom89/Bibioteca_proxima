package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Turni;

public class TurniDao {

	
	public void insert(int mat, Date inizio, Date fine) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "INSERT INTO Turni( matricola, data_inizio_turno, data_fine_turno) VALUES(?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, mat);
			cmd.setDate(2, inizio);
			cmd.setDate(3, fine);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Inserimento avvenuto con successo!");

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
	public void update(int mat, Date inizio, Date fine, int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "UPDATE Turni SET  matricola=?, data_inizio_turno=?, data_fine_turno=? WHERE id=?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, mat);
			
			cmd.setDate(2, inizio);
			cmd.setDate(3, fine);
			cmd.setInt(4, id);

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

			String updateTableSQL = "DELETE FROM turni  WHERE id=?";

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
	public Turni findById(int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Turni turni = null;

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM turni WHERE id = ? ";

			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			// stampiamo i risultati
			while (esiste) {
				int idc = res.getInt("id");
				System.out.println(idc);
				System.out.println(res.getInt("matricola"));
				System.out.println(res.getDate("data_inizio_turno"));
				System.out.println(res.getDate("data_fine_turno"));
				
				esiste = res.next();
			}
			Date dt = res.getDate("data_inizio_turno");
			String datai = dt.toString();
			Date dt2 = res.getDate("data_fine_turno");
			String dataf = dt.toString();
			

			turni = new Turni(res.getInt("id"), res.getInt("matricola"), datai,
					dataf);

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

		return turni;

	}
	
	public List<Turni> findByAll() throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Turni> turni= new ArrayList<>();
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM turni ";

			cmd = dbConnection.prepareStatement(query);
			

			ResultSet res = cmd.executeQuery();

			
			
			while(res.next()) {
			Turni turno= new Turni();
			Date dt = res.getDate("data_inizio_turno");
			String datai = dt.toString();
			java.text.SimpleDateFormat sdfSrc = new java.text.SimpleDateFormat("dd/MM/yyyy");
			java.text.SimpleDateFormat sdfDst = new java.text.SimpleDateFormat("yyyy-MM-dd");
			datai = sdfSrc.format(sdfDst.parse(datai));
			Date dt2 = res.getDate("data_fine_turno");
			String dataf = dt.toString();
			
			dataf = sdfSrc.format(sdfDst.parse(dataf));
			turno = new Turni(res.getInt("id"), res.getInt("matricola"), datai,
					dataf);
			turni.add(turno);
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

		return turni;

	}


}
