package org.pharmacie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pharmacie.beans.Stock;
import org.pharmacie.dao.StockDao;

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
			
			// Relatif au stock
			
		}else if(action.equals("stock")) {
			getIndexStock(request, response);
		}else if(action.equals("stock-new")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/nouveauStock.jsp");
			rd.forward(request, response);
		}else if(action.equals("stock-update")) {
			String id = request.getParameter("id");
			try {
				Stock st = StockDao.getOneStock(id);
				request.setAttribute("stock", st);
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateStock.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				//ServletContext sc = getServletContext();
				//RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateStock.jsp");
				//rd.forward(request, response);
				System.out.print("Error de update");
			}
		}else if(action.equals("stock-delete")) {
			String id = request.getParameter("id");
			try {
				StockDao.deleteStock(id);
			}catch(Exception e) {
				
			}
			getIndexStock(request, response);
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
	
	
	// Cette fonction a pour vocation a eviter son ecriture plusieurs fois
	
	protected void getIndexStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean error;
		try {
			error = false;
			request.setAttribute("error", error);
			request.setAttribute("stocks", StockDao.getAllStock());
			//System.out.print(StockDao.getAllStock());
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/indexStock.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			error = true;
			request.setAttribute("error", error);
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/indexStock.jsp");
			rd.forward(request, response);
		}
	}

}
