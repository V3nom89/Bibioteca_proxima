package model;

public class Cliente {

	private int idcliente;
	private String nome;
	private String cognome;
	private int numero;
	public Cliente() {
		
	}
	public Cliente(int id, String nome, String cognome, int numero) {
		this.setCognome(cognome);
		this.setIdcliente(id);
		this.setNome(nome);
		this.setNumero(numero);
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
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
}
