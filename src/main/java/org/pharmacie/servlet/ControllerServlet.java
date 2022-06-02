package org.pharmacie.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pharmacie.beans.FournisseurDAO;

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
		} else if (action.equals("fournisseur")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/fournisseur.jsp");
			try {
				request.setAttribute("listFournisseur", FournisseurDAO.findAll());
				System.out.println(FournisseurDAO.findAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
			rd.forward(request, response);
		} else if (action.equals("addFournisseur") || action.equals("create")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/addFournisseur.jsp");
			System.out.println(action);
			if (action.equals("create")) {
				String nomFournisseur = (String) request.getParameter("nomFournisseur");
				String adresseFournisseur = (String) request.getParameter("adresseFournisseur");
				String emailFournisseur = (String) request.getParameter("emailFournisseur");
				FournisseurDAO.createFournisseur(nomFournisseur, adresseFournisseur, emailFournisseur);
				// rd = sc.getRequestDispatcher("/WEB-INF/fournisseur.jsp");
			}
			rd.forward(request, response);
		} else if (action.equals("searchFournisseur") || action.equals("updateFournisseur")) {
			String idFournisseur = request.getParameter("idFournisseur");
			if (action.equals("searchFournisseur")) {
				System.out.println(action);
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateFournisseur.jsp");
				try {
					request.setAttribute("fournisseur", FournisseurDAO.searchFournisseur(idFournisseur));
				} catch (Exception e) {
					e.printStackTrace();
				}
				rd.forward(request, response);
			} else {
				System.out.println(action);
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateFournisseur.jsp");
				try {
					String nomFournisseur = (String) request.getParameter("nomFournisseur");
					String adresseFournisseur = (String) request.getParameter("adresseFournisseur");
					String emailFournisseur = (String) request.getParameter("emailFournisseur");
					FournisseurDAO.updateFournisseur(idFournisseur, nomFournisseur, adresseFournisseur, emailFournisseur);
				} catch (Exception e) {
					e.printStackTrace();
				}
				rd.forward(request, response);
			}
		} else if (action.equals("deleteFournisseur")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/fournisseur.jsp");
			String idFournisseur = request.getParameter("idFournisseur");
			System.out.println(idFournisseur);
			try {
				FournisseurDAO.deleteFournisseur(idFournisseur);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			rd.forward(request, response);
		} // else {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// ServletContext sc = getServletContext();
		// RequestDispatcher rd = sc.getRequestDispatcher("/fournisseur.jsp");
		// rd.forward(request, response);
		// }
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
