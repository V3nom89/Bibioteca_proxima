package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;

/**
 * Servlet implementation class ClientServ
 */
@WebServlet("/ClientServ")
public class ClientServ extends HttpServlet {
	ClienteDao cliente = new ClienteDao();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws SQLException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void insert(Cliente c) throws SQLException {
		cliente.insert(c.getNome(), c.getCognome(), c.getNumero());
	}
	private void update(Cliente c) throws SQLException {
		cliente.update(c.getNome(), c.getCognome(), c.getNumero(),c.getIdcliente());
	}
	private void remove(Cliente c) throws SQLException {
		cliente.remove(c.getIdcliente());
	}
	private Cliente findById(Cliente c) throws SQLException {
		return cliente.findById(c.getIdcliente());
		
	}
	private List<Cliente>  findByAll() throws SQLException {
		
		return cliente.findByAll();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipoOperzione = request.getParameter("tipo");
		Cliente c = new Cliente();

		switch (tipoOperzione) {

		case "insert":
				c.setNome(request.getParameter("nome"));
				c.setCognome(request.getParameter("cognome"));
				c.setNumero(Integer.parseInt(request.getParameter("numero")));
				
			try {
				
				this.insert(c);
				request.getRequestDispatcher("/OperazioneAvvenuta.html").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "update":
			c.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
			c.setNome(request.getParameter("nome"));
			c.setCognome(request.getParameter("cognome"));
			c.setNumero(Integer.parseInt(request.getParameter("numero")));
			try {
				this.update(c);
				request.getRequestDispatcher("/OperazioneAvvenuta.html").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "remove":
			c.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
			try {
				this.remove(c);
				request.getRequestDispatcher("/OperazioneAvvenuta.html").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "findbyid":
			c.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
			
			//istruzione per collegarsi dalla servlet alla jsp
			try {
				request.getSession().setAttribute("listaClienti",this.findById(c));
				request.getRequestDispatcher("/ClienteUpdate.html").forward(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
		case "findByAll":
			try {
				request.getSession().setAttribute("listaClienti",this.findByAll());
				request.getRequestDispatcher("/StampaClienti.jsp").forward(request, response);
				
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
