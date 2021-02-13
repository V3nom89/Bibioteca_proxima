package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegistroLibri {

	 private int id;
	 private int idlibro;
	 private int idcliente;
	 private int matricola;
	 private Date data_prestito;
	 private Date data_scadenza;
	 private Date data_di_rientro;
	
	 public RegistroLibri() {
		 
	 }
	 public RegistroLibri(int id, int idlibro, int idcliente, int matricola, String data_prestito, String data_scadenza, String data_di_rientro) throws ParseException {
		this.setId(id);
		this.setIdlibro(idlibro);
		this.setIdcliente(idcliente);
		this.setMatricola(matricola);
		this.setData_prestito(data_prestito);
		this.setData_scadenza(data_scadenza);
		this.setData_di_rientro(data_di_rientro);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdlibro() {
		return idlibro;
	}
	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public Date getData_prestito() {
		return data_prestito;
	}
	public void setData_prestito(String data_prestito) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1 = sdf.parse(data_prestito);
		java.sql.Date Data = new java.sql.Date(date1.getTime());
		
		this.data_prestito = Data;
	}
	public Date getData_scadenza() {
		return data_scadenza;
	}
	public void setData_scadenza(String data_scadenza) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1 = sdf.parse(data_scadenza);
		java.sql.Date Data = new java.sql.Date(date1.getTime());
		this.data_scadenza = Data;
	}
	public Date getData_di_rientro() {
		return data_di_rientro;
	}
	public void setData_di_rientro(String data_di_rientro) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1 = sdf.parse(data_di_rientro);
		java.sql.Date Data = new java.sql.Date(date1.getTime());
		this.data_di_rientro = Data;
	}
}
