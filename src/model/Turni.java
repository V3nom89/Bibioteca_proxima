package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Turni {
	
	private int id; 
	private int matricola; 
	private Date data_fine_turno; 
	private Date data_inizio_turno;
	public Turni() {
		
	}
	public Turni(int id, int matricola, String data_inizio_turno, String data_fine_turno) throws ParseException {
		this.setId(id);
		this.setMatricola(matricola);
		this.setData_fine_turno(data_fine_turno);
		this.setData_inizio_turno(data_inizio_turno);
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public Date getData_fine_turno() {
		return data_fine_turno;
	}
	public void setData_fine_turno(String data_fine_turno) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1 = sdf.parse(data_fine_turno);
		java.sql.Date Data = new java.sql.Date(date1.getTime());
		
		this.data_fine_turno = Data;
	}
	public Date getData_inizio_turno() {
		return data_inizio_turno;
	}
	public void setData_inizio_turno(String data_inizio_turno) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1 = sdf.parse(data_inizio_turno);
		java.sql.Date Data = new java.sql.Date(date1.getTime());
		
		this.data_inizio_turno = Data;
	} 
	
}
