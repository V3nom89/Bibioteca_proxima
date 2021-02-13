package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TurniDao;
import model.Cliente;
import model.Turni;

/**
 * Servlet implementation class TurniServ
 */
@WebServlet("/TurniServ")
public class TurniServ extends HttpServlet {
	TurniDao turni= new TurniDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TurniServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws SQLException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void insert(Turni t) throws SQLException {
    	turni.insert(t.getMatricola(), t.getData_inizio_turno(),t.getData_fine_turno());
    }
    private void update(Turni t) throws SQLException {
    	turni.update(t.getMatricola(), t.getData_inizio_turno(),t.getData_fine_turno(),t.getId());
    }
    private void remove(Turni t) throws SQLException {
    	turni.remove(t.getId());
    }
    
   
	private void findById(Turni t )throws SQLException {
		turni.findById(t.getId());
		
	}
	private void findByAll() throws SQLException {
		turni.findByAll();
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoOperzione= request.getParameter("tipo");
		Turni t =new Turni();
		switch(tipoOperzione) {
		
		case "insert":
			t.setMatricola(Integer.parseInt(request.getParameter("matricola")));
			try {
				t.setData_inizio_turno(request.getParameter("data_inizio_turno"));
				t.setData_fine_turno(request.getParameter("data_fine_turno"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				this.insert(t);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "update":
			t.setMatricola(Integer.parseInt(request.getParameter("matricola")));
			try {
				t.setData_inizio_turno(request.getParameter("data_inizio_turno"));
				t.setData_fine_turno(request.getParameter("data_fine_turno"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			t.setId(Integer.parseInt(request.getParameter("id")));	
			try {
				this.update(t);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "remove":
			t.setId(Integer.parseInt(request.getParameter("id")));
			try {
				this.remove(t);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "findById":
			t.setId(Integer.parseInt(request.getParameter("id")));	
			try {
				this.findById(t);
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
