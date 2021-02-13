package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DipendenteDao;
import dao.JavaDate;
import dao.LibroDao;
import model.Cliente;
import model.Dipendenti;
import model.Libro;
import model.Turni;

/**
 * Servlet implementation class LibroServ
 */
@WebServlet("/LibroServ")
public class LibroServ extends HttpServlet {
	LibroDao libro = new LibroDao();
	JavaDate jv = new JavaDate();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private void insert(Libro l) throws SQLException {
		libro.insert(l.getTitolo(), l.getGenere(), l.getAutore(),l.getNumeroPagine(),l.getISBN(),l.getAnno_stampa(),l.getCasa_editrice(),l.getPosizione());
	}

	private void update(Libro l) throws SQLException {
		libro.update(l.getTitolo(), l.getGenere(), l.getAutore(),l.getNumeroPagine(),l.getISBN(),l.getAnno_stampa(),l.getCasa_editrice(),l.getPosizione(),l.getIdlibro());
	}

	private void remove(Libro l) throws SQLException {
		libro.remove(l.getIdlibro());
	}
	private void findById(Libro l) throws SQLException {
		libro.findById(l.getIdlibro());
		
	}
	private void findByAll() throws SQLException {
		libro.findByAll();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoOperzione = request.getParameter("tipo");
		Libro l = new Libro();
		
		switch (tipoOperzione) {

		case "insert":
			l.setTitolo(request.getParameter("titolo"));
			l.setGenere(request.getParameter("genere"));
			l.setAutore(request.getParameter("autore"));
			l.setNumeroPagine(Integer.parseInt(request.getParameter("numero_pagine")));
			l.setISBN(Integer.parseInt(request.getParameter("ISBN")));
			try {
				l.setAnno_stampa(request.getParameter("anno_stampa"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			l.setCasa_editrice(request.getParameter("casa_editrice"));
			l.setPosizione(request.getParameter("posizione"));
			
			try {
				this.insert(l);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "update":

			l.setTitolo(request.getParameter("titolo"));
			l.setGenere(request.getParameter("genere"));
			l.setAutore(request.getParameter("autore"));
			l.setNumeroPagine(Integer.parseInt(request.getParameter("numero_pagine")));
			l.setISBN(Integer.parseInt(request.getParameter("numero_pagine")));
			l.setISBN(Integer.parseInt(request.getParameter("ISBN")));
			try {
				l.setAnno_stampa(request.getParameter("anno_stampa"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			l.setIdlibro(Integer.parseInt(request.getParameter("idlibro")));
			try {
				this.update(l);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "remove":
			l.setIdlibro(Integer.parseInt(request.getParameter("idlibro")));
			try {
				this.remove(l);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "findById":
			l.setIdlibro(Integer.parseInt(request.getParameter("idlibro")));
			try {
				this.findById(l);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "findByAll":
			try {
				this.findByAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
