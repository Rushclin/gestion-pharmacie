package org.pharmacie.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pharmacie.dao.servlet.CategorieDao;
 

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
		}
		//ma gestion des categories
		if(action.equals("categorie")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/categorie.jsp");
			try {
				request.setAttribute("ListCategorie",CategorieDao.findAll());
				//System.out.println(categorieDAO.findAll());
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			rd.forward(request, response);
		}else if (action.equals("addCategorie")|| action.equals("create")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/addCategorie.jsp");
			// System.out.println(action);
			if(action.equals("create")) {
				String nomCategorie = (String) request.getParameter("nomCategorie");
				String description = (String) request.getParameter("description");
				
				if(nomCategorie!=null && description!=null) {
					rd = sc.getRequestDispatcher("/WEB-INF/categorie.jsp");
					CategorieDao.createCategorie(nomCategorie,description);
				}
				// rd = sc.getRequestDispatcher("/WEB-INF/categorie.jsp");
			}
			rd.forward(request, response);
		}else if (action.equals("searchCategorie")) {
			String idCategorie = request.getParameter("idCategorie");
			// System.out.println(action);
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateCategorie.jsp");
			try {
				request.setAttribute("categorie", CategorieDao.searchCategorie(idCategorie));
			} catch (Exception e) {
				e.printStackTrace();
			}
			rd.forward(request, response);
		 
		}else if(action.equals("updateCategorie")|| action.equals("update")) {
			String idCategorie = request.getParameter("idCategorie");
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/categorie.jsp");
			// System.out.println(action);
			if (action.equals("update")) {
				
				String nomCategorie = (String) request.getParameter("nomCategorie");
				String description = (String) request.getParameter("description");
				
				try {
					CategorieDao.updateCategorie( idCategorie, nomCategorie, description);
					this.getServletContext().getRequestDispatcher("/WEB-INF/categorie.jsp").forward(request, response);
					request.setAttribute("ListCategorie",CategorieDao.findAll());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// rd = sc.getRequestDispatcher("/WEB-INF/categorie.jsp");
 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			rd.forward(request, response);
		}else if (action.equals("deleteCategorie")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/categorie.jsp");
			String idCategorie = request.getParameter("idCategorie");
			System.out.println(idCategorie);
			try {
				CategorieDao.deleteCategorie(idCategorie);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
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
