package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JavaDate {
	

	
	public java.sql.Date test(String anno, String mese, String giorno) {


	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date1=null;
	try {
	date1 = sdf.parse(anno+"-"+mese+"-"+giorno);
	}catch(ParseException e) {
	e.printStackTrace();
	}

	// String dataStr = sdf.format(date1);

	java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
	return sqlDate;

	}
	

}

/* SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1 = sdf.parse("31/12/2022");
		java.sql.Date d1 = new Date(date1.getTime());
		TurniDao td= new TurniDao();
		Turni tur = new Turni(10,100, d1,d1);
		td.aggiornaTurni(tur);

*String updateTableSQL = "UPDATE turni SET data_inizio_turno=?,data_fine_turno=? WHERE matricola=?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(3, tur.getMatricola());
			cmd.setDate(1, tur.getData_inizio_turno());
			cmd.setDate(2, tur.getData_fine_turno());
*
*/



