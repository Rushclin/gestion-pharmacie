package org.pharmacie.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pharmacie.beans.Produit;

import org.pharmacie.beans.ProduitDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.print(action);
		if(action == null) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/login.jsp");
			rd.forward(request, response);
		}else if(action.equals("dashboard")){
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(request, response);
		}else if(action.equals("form")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/form.jsp");
			rd.forward(request, response);
		}else if(action.equals("listeproduit")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/produit.jsp");
			
			try {
				request.setAttribute("listProduit",ProduitDAO.findAll());
				System.out.println(ProduitDAO.findAll() );
			}catch(Exception e) {
				e.printStackTrace();			
				}
			rd.forward(request, response);
		}else if(action.equals("addproduit") || action.equals("create")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/addProduit.jsp");
			if(action.equals("create")) {
				String nomproduit = request.getParameter("nomProduit");
				String codeproduit =  request.getParameter("codeProduit");
				String poid =  request.getParameter("poids");
				String description =  request.getParameter("descriptionProduit");
				String origine =  request.getParameter("originProduit");
				String prix =  request.getParameter("prix");
				System.out.println(nomproduit);
				System.out.println(codeproduit);
				ProduitDAO.createProduit(nomproduit, codeproduit, poid, description, origine, prix );
			}
			rd.forward(request, response);
		}
		else if (action.equals("deleteProduit")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/produit.jsp ");
			String idp = request.getParameter("idProduit");
			System.out.println(idp);
			try {
				ProduitDAO.deleteProduit(idp);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			rd.forward(request, response);
		}else if(action.equals("updateProduit") || action.equals("update")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/update.jsp");
			
			rd.forward(request, response);
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
