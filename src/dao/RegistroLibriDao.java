package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Libro;
import model.RegistroLibri;

public class RegistroLibriDao {

	public void insert(int idLibro, int idCliente, int mat, Date prestito, Date scadenza, Date rientro) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "INSERT INTO RegistroLibri(matricola,idlibro,idcliente, data_prestito, data_scadenza, data_di_rientro) VALUES(?,?,?,?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, mat);
			cmd.setInt(2,idLibro);
			cmd.setInt(3, idCliente);
			cmd.setDate(4, prestito);
			cmd.setDate(5, scadenza);
			cmd.setDate(6, rientro);
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
	public void update(int idLibro, int idCliente,int mat, Date prestito, Date scadenza, Date rientro, int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "UPDATE RegistroLibri SET idlibro=?,idcliente=?, matricola=?,  data_prestito=?, data_scadenza=?, data_di_rientro=? WHERE id=";

			cmd = dbConnection.prepareStatement(updateTableSQL);


			cmd.setInt(1, mat);
			cmd.setInt(2,idLibro);
			cmd.setInt(3, idCliente);
			cmd.setDate(4, prestito);
			cmd.setDate(5, scadenza);
			cmd.setDate(6, rientro);
			cmd.setInt(7,id);
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

			String updateTableSQL = "DELETE FROM registrolibri  WHERE id=?";

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
	public RegistroLibri findById(int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		RegistroLibri rlibri = null;

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM registrolibri WHERE id = ? ";

			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			// stampiamo i risultati
			while (esiste) {
				int idc = res.getInt("id");
				System.out.println(idc);
				System.out.println(res.getInt("id"));
				System.out.println(res.getInt("idlibro"));
				System.out.println(res.getInt("idcliente"));
				System.out.println(res.getInt("matricola"));
				System.out.println(res.getDate("data_prestito"));
				System.out.println(res.getDate("data_scadenza"));
				System.out.println(res.getDate("data_di_rientro"));
			}
			Date dt = res.getDate("data_prestito");
			String datap = dt.toString();
			Date dt2 = res.getDate("data_scadenza");
			String datas = dt2.toString();
			Date dt3 = res.getDate("data_di_rientro");
			String datar = dt3.toString();
			

			rlibri = new RegistroLibri(res.getInt("id"),res.getInt("idlibro"),res.getInt("idcliente"),res.getInt("matricola"),datap,datas,datar);

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

		return rlibri;

	}
	public List<RegistroLibri> findByAll() throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<RegistroLibri> registrolibri= new ArrayList<>();
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM registrolibri ";

			cmd = dbConnection.prepareStatement(query);
			

			ResultSet res = cmd.executeQuery();

			
			
			while(res.next()) {
				RegistroLibri rl= new RegistroLibri();
				Date dt = res.getDate("data_prestito");
				String datap = dt.toString();
				java.text.SimpleDateFormat sdfSrc = new java.text.SimpleDateFormat("dd/MM/yyyy");
				java.text.SimpleDateFormat sdfDst = new java.text.SimpleDateFormat("yyyy-MM-dd");
				datap = sdfSrc.format(sdfDst.parse(datap));
				Date dt2 = res.getDate("data_scadenza");
				String datas = dt2.toString();
				
				datas = sdfSrc.format(sdfDst.parse(datas));
				Date dt3 = res.getDate("data_di_rientro");
				String datar = dt3.toString();
				datar = sdfSrc.format(sdfDst.parse(datar));
			rl = new RegistroLibri(res.getInt("id"),res.getInt("idlibro"),res.getInt("idcliente"),res.getInt("matricola"),datap,datas,datar);
			registrolibri.add(rl);
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

		return registrolibri;

	}

}


