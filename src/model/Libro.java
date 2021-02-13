package model;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Libro {

	private int idlibro;
	private String titolo;
	private String genere;
	private String autore;
	private int numeroPagine;
	private int ISBN; 
	private Date anno_stampa; 
	private String casa_editrice; 
	private String posizione;
	
	public Libro() {
		
	}
	
	public Libro(int idLibro, String titolo, String genere, String autore, int numeroPagine, int ISBN, String anno_stampa, String casa_editrice,
			String posizione) throws ParseException {
		this.setIdlibro(idLibro);
		this.setTitolo(titolo);
		this.setGenere(genere);
		this.setAutore(autore);
		this.setNumeroPagine(numeroPagine);
		this.setISBN(ISBN);
		this.setAnno_stampa(anno_stampa);
		this.setCasa_editrice(casa_editrice);
		this.setPosizione(posizione);
		
		
		
	}
	
	
	public int getIdlibro() {
		return idlibro;
	}
	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public int getNumeroPagine() {
		return numeroPagine;
	}
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public Date getAnno_stampa() {
		return anno_stampa;
	}
	public void setAnno_stampa(String anno_stampa) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1 = sdf.parse(anno_stampa);
		java.sql.Date Data = new java.sql.Date(date1.getTime());
		this.anno_stampa = Data;
	}
	public String getCasa_editrice() {
		return casa_editrice;
	}
	public void setCasa_editrice(String casa_editrice) {
		this.casa_editrice = casa_editrice;
	}
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	
}
