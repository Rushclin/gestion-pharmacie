package org.pharmacie.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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

import org.pharmacie.beans.Stock;
import org.pharmacie.dao.FournisseurDAO;
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
			} else if (action.equals("stock")) {
				getIndexStock(request, response);
			} else if (action.equals("stock-new")) {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/nouveauStock.jsp");
				rd.forward(request, response);
			} else if (action.equals("stock-update")) {
				String id = request.getParameter("id");
				try {
					Stock st = StockDao.getOneStock(id);
					request.setAttribute("stock", st);
					ServletContext sc = getServletContext();
					RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateStock.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					// ServletContext sc = getServletContext();
					// RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateStock.jsp");
					// rd.forward(request, response);
					System.out.print("Error de update");
				}
			} else if (action.equals("stock-delete")) {
				String id = request.getParameter("id");
				try {
					StockDao.deleteStock(id);
				} catch (Exception e) {

				}
				getIndexStock(request, response);
			}  else if (action.equals("fournisseur")) {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/fournisseur.jsp");
				try {
					request.setAttribute("listFournisseur", FournisseurDAO.findAll());
					//System.out.println(FournisseurDAO.findAll());
				} catch (Exception e) {
					e.printStackTrace();
				}
				rd.forward(request, response);
			} else if (action.equals("addFournisseur") || action.equals("create")) {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/addFournisseur.jsp");
				// System.out.println(action);
				if (action.equals("create")) {
					String nomFournisseur = (String) request.getParameter("nomFournisseur");
					String adresseFournisseur = (String) request.getParameter("adresseFournisseur");
					String emailFournisseur = (String) request.getParameter("emailFournisseur");
					if(nomFournisseur != null && adresseFournisseur != null && emailFournisseur != null) {
						rd = sc.getRequestDispatcher("/WEB-INF/fournisseur.jsp");
						try {
							FournisseurDAO.createFournisseur(nomFournisseur, adresseFournisseur, emailFournisseur);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// rd = sc.getRequestDispatcher("/WEB-INF/fournisseur.jsp");
				}
				rd.forward(request, response);
			} else if (action.equals("searchFournisseur")) {
				String idFournisseur = request.getParameter("idFournisseur");
				// System.out.println(action);
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateFournisseur.jsp");
				try {
					request.setAttribute("fournisseur", FournisseurDAO.searchFournisseur(idFournisseur));
				} catch (Exception e) {
					e.printStackTrace();
				}
				rd.forward(request, response);
			} else if (action.equals("updateFournisseur") || action.equals("update")) {
				String idFournisseur = request.getParameter("idFournisseur");
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/updateFournisseur.jsp");
				// System.out.println(action);
				if (action.equals("update")) {
					String nomFournisseur = (String) request.getParameter("nomFournisseur");
					String adresseFournisseur = (String) request.getParameter("adresseFournisseur");
					String emailFournisseur = (String) request.getParameter("emailFournisseur");
					try {
						FournisseurDAO.updateFournisseur(idFournisseur, nomFournisseur, adresseFournisseur, emailFournisseur);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// rd = sc.getRequestDispatcher("/WEB-INF/fournisseur.jsp");
				}
				rd.forward(request, response);
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
			}
			else if (action.equals("deconnexion")) {
				session.invalidate();
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
			} else {
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
	
	
	// Cette fonction a pour vocation a eviter son ecriture plusieurs fois
	
	protected void getIndexStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean error;
		try {
			error = false;
			String id = request.getParameter("id");
			request.setAttribute("error", error);
			request.setAttribute("stocks", StockDao.getAllStock());
			request.setAttribute("fournisseur", FournisseurDAO.searchFournisseur(id));
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
 

	

	
			   