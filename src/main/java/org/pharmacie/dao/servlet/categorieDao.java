package org.pharmacie.dao.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.pharmacie.dao.servlet.Categorie;

/**
 * Servlet implementation class categorieDao
 */
@WebServlet("/categorieDao")
public class categorieDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static String jdbcURL = "jdbc:mysql://localhost:3306/pharmacie";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "";

    public categorieDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.print(connection);
		return connection;
	}
    public static List<Categorie> findAll(){
		//System.out.println("Recherche de toute toute les categories");
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Categorie> categories = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM categorie");
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Categorie categorie = new Categorie ();
				String idCategorie = rs.getString("idCategorie");
				String nomCategorie = rs.getString("nomCategorie");
				String description = rs.getString("description");
				
				categorie.setIdCategorie(idCategorie);
				categorie.setNomCategorie(nomCategorie);
				categorie.setDescription(description);
				
				categories.add(categorie);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			;
		}
		return categories;
	}





	public static void createCategorie(String idCategorie, String nomCategorie) {
		// TODO Auto-generated method stub
		//System.out.println("Creation d'une categorie");
		;
		String INSERT_CATTEGORIE_SQL = "INSERT INTO categorie"
		+ "  (idCategorie, nomCategorie) VALUES "+ " ('" + idCategorie + "', '" + nomCategorie +"')";
		//System.out.println(INSERT_CATTEGORIE_SQL);
		// try-with-resource statement will auto close the connection.
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATTEGORIE_SQL);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}
 
	public static void deleteCategorie(String idCategorie) {
		// TODO Auto-generated method stub
		//System.out.println("Suppression d'une categorie");
		String DELETE_CATEGGORIE_SQL = "DELETE FROM categorie WHERE idCategorie =" + idCategorie + ";";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGGORIE_SQL)) {
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

	public static Categorie searchFournisseur(String idCategorie) {
		// TODO Auto-generated method stub
		//System.out.println("Recherche d'une categorie");
		String SELECT_CONTACT_BY_ID = "SELECT idCategorie, nomCategorie where idFournisseur = "+ idCategorie + ";";
	 Categorie categorie = new  Categorie();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_CONTACT_BY_ID);
			// Step 3: Execute the query or update query
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				int idCategorie1 = rs1.getInt("idCategorie");
				String nomCategorie  = rs1.getString("nomCategorie");
				
				categorie= Categorie(idCategorie,nomCategorie);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return categorie;

	}

	private static Categorie Categorie(String idCategorie, String nomCategorie) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void updateCategorie(String idCategorie, String nomCategorie )throws SQLException {
		System.out.println("Modification d'une categorie");
		String UPDATE_CATEGGORIE_SQL = "UPDATE categorie SET nomCategorie ='" + nomCategorie
				+ "' WHERE idCategorie = " + idCategorie + ";";
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGGORIE_SQL);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage()); 
		}
	}

}
