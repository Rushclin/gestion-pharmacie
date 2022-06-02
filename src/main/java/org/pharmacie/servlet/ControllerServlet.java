package org.pharmacie.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacy.beans.User;
import com.pharmacy.dao.UserDao;

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
		HttpSession session = request.getSession();
		session.getAttribute("email");
		if (session.getAttribute("email") == null) {
			if (action == null) {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
			} else if (action.equals("signup")) {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/signup.jsp");
				rd.forward(request, response);
			} else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);

			}
		} else {
			if (action == null) {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/index.jsp");
				rd.forward(request, response);
			} else if (action.equals("form")) {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/form.jsp");
				rd.forward(request, response);
			} else if (action.equals("deconnexion")) {
				session.invalidate();
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
			}
			else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);

			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");

		if (action == null) {
			User user = new User();
			user.setEmail(email);
			user.setPassword(request.getParameter("password"));
			try {
				User userAuth = UserDao.getUser(user);
				if (userAuth.getEmail() != null) {
					HttpSession session = request.getSession();
					session.setAttribute("email", userAuth.getEmail());
					session.setAttribute("nom", userAuth.getNameUser());
					session.setAttribute("telephone", userAuth.getPhone());
					session.setAttribute("iduser",userAuth.getIdUser());
					this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
				} else {
					request.setAttribute("erreur", "cet utilisateur n'existe pas");
					this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("erreur", e.getMessage());
				this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} else if (action.equals("signup")) {
			Date date = new Date(0);
			User user = new User();
			user.setNameUser(request.getParameter("nom"));
			user.setEmail(email);
			user.setPassword(request.getParameter("password"));
			user.setPhone(request.getParameter("telephone"));
			user.setDateAjout(date);
			if (password.equals(confirmPassword)) {
				try {
					request.setAttribute("message", "Compte cree");
					UserDao.registerUser(user);
					this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("erreur", e.getMessage());
					this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("erreur", "confirmation mot de passe differente");
				this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
			}

		}

	}

}
