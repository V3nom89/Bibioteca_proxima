package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DipendenteDao;

import model.Dipendenti;
import model.Libro;

/**
 * Servlet implementation class DipendentiServ
 */
@WebServlet("/DipendentiServ")
public class DipendentiServ extends HttpServlet {
	DipendenteDao dipendente = new DipendenteDao();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DipendentiServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void insert(Dipendenti d) throws SQLException {
		dipendente.insert(d.getNome(), d.getCognome(), d.getMatricola(), d.getFlag_Admin());
	}

	private void update(Dipendenti d) throws SQLException {
		dipendente.update(d.getNome(), d.getCognome(), d.getMatricola(), d.getFlag_Admin(), d.getId());
	}

	private void remove(Dipendenti d) throws SQLException {
		dipendente.remove(d.getId());
	}
	private void findById(Dipendenti d) throws SQLException {
		dipendente.findById(d.getId());
		
	}
	private List<Dipendenti> findByAll() throws SQLException {
		return dipendente.findByAll();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipoOperzione = request.getParameter("tipo");
		Dipendenti d = new Dipendenti();

		switch (tipoOperzione) {

		case "insert":
			d.setNome(request.getParameter("nome"));
			d.setCognome(request.getParameter("cognome"));
			d.setMatricola(Integer.parseInt(request.getParameter("matricola")));
			d.setFlag_Admin(Integer.parseInt(request.getParameter("flag_admin")));
			try {
				this.insert(d);
				request.getRequestDispatcher("/OperazioneAvvenuta.html").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "update":

			d.setNome(request.getParameter("nome"));
			d.setCognome(request.getParameter("cognome"));
			d.setMatricola(Integer.parseInt(request.getParameter("matricola")));
			d.setFlag_Admin(Integer.parseInt(request.getParameter("flag_admin")));
			d.setId(Integer.parseInt(request.getParameter("id")));
			try {
				this.update(d);
				request.getRequestDispatcher("/OperazioneAvvenuta.html").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "remove":
			d.setId(Integer.parseInt(request.getParameter("id")));
			try {
				this.remove(d);
				request.getRequestDispatcher("/OperazioneAvvenuta.html").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "findById":
			d.setId(Integer.parseInt(request.getParameter("id")));
			try {
				this.findById(d);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "findByAll":
			try {request.getSession().setAttribute("listaDipendenti",this.findByAll());
			request.getRequestDispatcher("/StampaDipendenti.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
