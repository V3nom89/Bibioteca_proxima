package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Dipendenti;
import model.Libro;

public class LibroDao {

	public void insert(String titolo, String genere, String autore , int numeroPagine, int ISBN, Date annoStampa, String casaEditrice, String posizione) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "INSERT INTO Libro(titolo, genere, autore, numeroPagine, ISBN, anno_stampa, casa_editrice, posizione) VALUES(?,?,?,?,?,?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			
			
			cmd.setString(1, titolo);
			cmd.setString(2, genere);
			cmd.setString(3,autore);
			cmd.setInt(4, numeroPagine);
			cmd.setInt(5, ISBN);
			cmd.setDate(6, annoStampa);
			cmd.setString(7, casaEditrice);
			cmd.setString(8,posizione);
			
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
	public void update(String titolo, String genere, String autore , int numeroPagine, int ISBN, Date annoStampa, String casaEditrice, String posizione, int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "UPDATE Libro SET  titolo=?, genere=?, autore=?, numeroPagine=?, ISBN=?, anno_stampa=?, casa_editrice=?, posizione=? WHERE idLibro=?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, titolo);
			cmd.setString(2, genere);
			cmd.setString(3,autore);
			cmd.setInt(4, numeroPagine);
			cmd.setInt(5, ISBN);
			cmd.setDate(6, annoStampa);
			cmd.setString(7, casaEditrice);
			cmd.setString(8,posizione);
			cmd.setInt(9, id);
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

			String updateTableSQL = "DELETE FROM libro  WHERE idLibro = ?";

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
	public Libro findById(int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Libro libro = null;

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM libro WHERE idLibro = ? ";

			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			// stampiamo i risultati
			while (esiste) {
				int idc = res.getInt("idLibro");
				System.out.println(idc);
				System.out.println(res.getString("titolo"));
				System.out.println(res.getString("genere"));
				System.out.println(res.getString("autore"));
				System.out.println(res.getInt("numeroPagine"));
				System.out.println(res.getInt("ISBN"));
				System.out.println(res.getDate("anno_stampa"));
				System.out.println(res.getString("casa_editrice"));
				System.out.println(res.getString("posizione"));
				esiste = res.next();
			}
			Date dt = res.getDate("anno_stampa");
			String data = dt.toString();
			libro = new Libro(res.getInt("idLibro"), res.getString("titolo"),res.getString("genere"),res.getString("autore"),res.getInt("numeroPagine"),res.getInt("ISBN"),data,res.getString("casa_editrice"),res.getString("posizione"));

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

		return libro;

	}

	public List<Libro> findByAll() throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Libro> libro= new ArrayList<>();
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM libro ";

			cmd = dbConnection.prepareStatement(query);
			

			ResultSet res = cmd.executeQuery();

			
			
			while(res.next()) {
			Libro lib= new Libro();
			Date dt = res.getDate("anno_stampa");
			String data = dt.toString();
			java.text.SimpleDateFormat sdfSrc = new java.text.SimpleDateFormat("dd/MM/yyyy");
			java.text.SimpleDateFormat sdfDst = new java.text.SimpleDateFormat("yyyy-MM-dd");
			data = sdfSrc.format(sdfDst.parse(data));
			lib = new Libro(res.getInt("idLibro"), res.getString("titolo"),res.getString("genere"),res.getString("autore"),res.getInt("numeroPagine"),res.getInt("ISBN"),data,res.getString("casa_editrice"),res.getString("posizione"));
			libro.add(lib);
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

		return libro;

	}

}

