package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDao {

	public void insert(String n, String c, int num) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "INSERT INTO cliente(nome, cognome, numero) VALUES(?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, n);
			cmd.setString(2, c);
			cmd.setInt(3, num);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Inserimento avvenuto con successo");

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

	public void update(String n, String c, int num, int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");

			String updateTableSQL = "UPDATE cliente SET  nome = ?, cognome = ?, numero = ?  WHERE idCliente = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, n);
			cmd.setString(2, c);
			cmd.setInt(3, num);
			cmd.setInt(4, id);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Update avvenuto con successo");

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

			String updateTableSQL = "DELETE FROM cliente  WHERE idCliente = ?";

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

	public Cliente findById(int id) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Cliente cliente = null;

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM cliente WHERE idcliente = ? ";

			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			// stampiamo i risultati
			while (esiste) {
				int idc = res.getInt("idcliente");
				System.out.println(idc);
				System.out.println(res.getString("nome"));
				System.out.println(res.getString("cognome"));
				System.out.println(res.getInt("numero"));
				
				cliente = new Cliente(res.getInt("idcliente"), res.getString("nome"), res.getString("cognome"),
						res.getInt("numero"));
				esiste = res.next();
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

		return cliente;

	}

	public List<Cliente> findByAll() throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Cliente> clienti= new ArrayList<>();
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "");
			String query = "SELECT * FROM cliente ";

			cmd = dbConnection.prepareStatement(query);
			

			ResultSet res = cmd.executeQuery();

			
			
			while(res.next()) {
			Cliente cliente= new Cliente();
			cliente = new Cliente(res.getInt("idcliente"), res.getString("nome"), res.getString("cognome"),
					res.getInt("numero"));
			clienti.add(cliente);
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

		return clienti;

	}

}
