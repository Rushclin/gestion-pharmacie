package org.pharmacie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pharmacie.beans.ClientDAO;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.print(action);
		if (action == null) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/login.jsp");
			rd.forward(request, response);
		} else if (action.equals("dashboard")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(request, response);
		} else if (action.equals("form")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/form.jsp");
			rd.forward(request, response);
		} else if (action.equals("clients")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/client.jsp");
			try {
				request.setAttribute("listClient", ClientDAO.findAll());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			rd.forward(request, response);
		} else if (action.equals("addclient") || action.equals("create")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/addClient.jsp");
			System.out.println(action);
			if (action.equals("create")) {
				String nomClient = (String) request.getParameter("nomClient");
				String telephoneClientr = (String) request.getParameter("telephoneClient");
				String emailClient = (String) request.getParameter("emailClient");
				System.out.println("great");
				ClientDAO.createClient(nomClient, telephoneClientr, emailClient);
				System.out.println("wonderful");
				// rd = sc.getRequestDispatcher("/WEB-INF/fournisseur.jsp");
			}
			rd.forward(request, response);
		} else if (action.equals("updateClient")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateClient.jsp");
			rd.forward(request, response);
		}
		
		else if (action.equals("deleteClient")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/client.jsp");
			String idClient = request.getParameter("idClient");
			try {
				ClientDAO.deleteClient(idClient);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			rd.forward(request, response);
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
