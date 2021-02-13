package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Libro;
import model.Turni;

public class DBdemo {

	public static void main(String[] args) throws SQLException, ParseException {
		JavaDate jv = new JavaDate();
		ClienteDao cd = new ClienteDao();
		DipendenteDao dd = new DipendenteDao();
		LibroDao ld = new LibroDao();
		RegistroLibriDao rld = new RegistroLibriDao();
		TurniDao td = new TurniDao();
		Libro lib;
		Turni tur;
		List<Turni> turni;
		//Inserisci nome, cognome e numero di telefono
		//dd.insert("Giuseppe", "Rossi", 3456, 98);
		//cd.insert("Giuseppe", "Conte", 6576);
		//Inserisci il numero della riga da sostituire 'id' (l'ultimo parametro) e tutti i relativi valori
		//cd.update("Giuseppe", "Conte", 6548, 1);
		//inserisci il numero della riga da eliminare (id)
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//java.util.Date date1 = sdf.parse("31/12/2022");
		//java.sql.Date Data = new java.sql.Date(date1.getTime());
		//ld.remove(1);
	
		//ld.findById(2);
		
		turni=td.findByAll();
		for(int i=0;i<turni.size();i++) {
			tur=turni.get(i);
			System.out.print(tur.getId());
			System.out.print(" ");
			System.out.print(tur.getMatricola());
			System.out.print(" ");
			System.out.print(tur.getData_inizio_turno());
			System.out.print(" ");
			System.out.print(tur.getData_fine_turno());
		
			System.out.println();
			}
		
		/*cd.remove(2);
		cd.remove(4);
		cd.remove(5);
		cd.insert("Giuseppe", "Conte", 6576);
		cd.insert("Mario", "Piccione", 6536);
		cd.insert("Giuseppe", "Fichera", 6572);
		cd.insert("Antonio", "Barrelleis", 6516);
		*/
		
		//ld.insert("il_mat_imp", "saggio", "P_Odifreddi", 256, 7657, Data, "Mondadori", "opigghialu");
		//dd.findById(1);
	}

}
