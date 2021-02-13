package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistroLibriDao;
import model.Libro;
import model.RegistroLibri;

/**
 * Servlet implementation class RegistroLibriServ
 */
@WebServlet("/RegistroLibriServ")
public class RegistroLibriServ extends HttpServlet {
	RegistroLibriDao registrolibri = new RegistroLibriDao();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroLibriServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void insert(RegistroLibri rl) throws SQLException {
		registrolibri.insert(rl.getIdlibro(),rl.getIdcliente(),rl.getMatricola(), rl.getData_prestito(),rl.getData_scadenza(), rl.getData_di_rientro());
	}

	private void update(RegistroLibri rl) throws SQLException {
		registrolibri.update(rl.getIdlibro(),rl.getIdcliente(),rl.getMatricola(), rl.getData_prestito(),rl.getData_scadenza(), rl.getData_di_rientro(),rl.getId());
	}

	private void remove(RegistroLibri rl) throws SQLException {
		registrolibri.remove(rl.getId());
	}
	
	private void findById(RegistroLibri rl) throws SQLException {
		registrolibri.findById(rl.getId());
		
	}
	private void findByAll() throws SQLException {
		registrolibri.findByAll();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipoOperzione = request.getParameter("tipo");
		RegistroLibri rl = new RegistroLibri();
		

		switch (tipoOperzione) {

		case "insert":
			
			
			rl.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
			rl.setIdlibro(Integer.parseInt(request.getParameter("idlibro")));
			rl.setMatricola(Integer.parseInt(request.getParameter("matricola")));
			try {
				rl.setData_prestito(request.getParameter("data_prestito"));
				rl.setData_scadenza(request.getParameter("data_scadenza"));
				rl.setData_di_rientro(request.getParameter("data_di_rientro"));
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.insert(rl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "update":

			
			rl.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
			rl.setIdlibro(Integer.parseInt(request.getParameter("idlibro")));
			rl.setMatricola(Integer.parseInt(request.getParameter("matricola")));
			try {
				rl.setData_prestito(request.getParameter("data_prestito"));
				rl.setData_scadenza(request.getParameter("data_scadenza"));
				rl.setData_di_rientro(request.getParameter("data_di_rientro"));
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			rl.setId(Integer.parseInt(request.getParameter("id")));
			try {
				this.update(rl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "remove":
			rl.setId(Integer.parseInt(request.getParameter("id")));
			try {
				this.remove(rl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "findById":
			rl.setId(Integer.parseInt(request.getParameter("id")));
			try {
				this.findById(rl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
