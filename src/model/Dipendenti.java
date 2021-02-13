package model;

public class Dipendenti {

	private int matricola; 
	private String nome; 
	private String cognome;
	private int flag_Admin;
	private int id;
	public Dipendenti() {
		
	}
	public Dipendenti(int id,String nome, String cognome, int matricola, int flag_Admin) {
		this.id=id;
		this.nome=nome;
		this.cognome=cognome;
		this.matricola=matricola;
		this.flag_Admin=flag_Admin;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getFlag_Admin() {
		return flag_Admin;
	}
	public void setFlag_Admin(int flag_Admin) {
		this.flag_Admin = flag_Admin;
	}
}
