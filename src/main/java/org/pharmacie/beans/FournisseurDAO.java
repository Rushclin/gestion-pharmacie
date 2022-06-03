package org.pharmacie.beans;

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

import org.pharmacie.beans.Fournisseur;

/**
 * Servlet implementation class FournisseurDAO
 */
@WebServlet("/FournisseurDAO")
public class FournisseurDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String jdbcURL = "jdbc:mysql://localhost:3306/gestion_pharmacie";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FournisseurDAO() {
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

	public static List<Fournisseur> findAll() {
		//System.out.println("Recherche de tous les fournisseurs");
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Fournisseur> founisseurs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM fournisseur");
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Fournisseur founisseur = new Fournisseur();
				int idFournisseur = rs.getInt("idFournisseur");
				String nomFournisseur = rs.getString("nomFournisseur");
				String adresseFournisseur = rs.getString("adresseFournisseur");
				String emailFournisseur = rs.getString("emailFournisseur");
				Date dateEnregistrementFournisseur = rs.getDate("dateEnregistrementFournisseur");
				founisseur.setIdFournisseur(idFournisseur);
				founisseur.setNomFournisseur(nomFournisseur);
				founisseur.setAdresseFournisseur(adresseFournisseur);
				founisseur.setEmailFournisseur(emailFournisseur);
				founisseur.setDateEnregistrementFournisseur(dateEnregistrementFournisseur);
				//System.out.println(founisseur.getDateEnregistrementFournisseur());
				founisseurs.add(founisseur);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			;
		}
		return founisseurs;
	}

	public static void createFournisseur(String nomFournisseur, String adresseFournisseur, String emailFournisseur) {
		// TODO Auto-generated method stub
		//System.out.println("Creation d'un fournisseur");
		LocalDate dateEnregistrementFournisseur = LocalDate.now();
		String INSERT_FOURRNISSEUR_SQL = "INSERT INTO fournisseur"
				+ "  (nomFournisseur, adresseFournisseur, emailFournisseur, dateEnregistrementFournisseur) VALUES "
				+ " ('" + nomFournisseur + "', '" + adresseFournisseur + "','" + emailFournisseur + "', '"
				+ dateEnregistrementFournisseur + "');";
		//System.out.println(INSERT_FOURRNISSEUR_SQL);
		// try-with-resource statement will auto close the connection.
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FOURRNISSEUR_SQL);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

	public static void deleteFournisseur(String idFournisseur) {
		// TODO Auto-generated method stub
		//System.out.println("Suppression d'un fournisseur");
		String DELETE_FOURNISSEUR_SQL = "DELETE FROM fournisseur WHERE idFournisseur =" + idFournisseur + ";";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FOURNISSEUR_SQL)) {
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

	public static Fournisseur searchFournisseur(String idFournisseur) {
		// TODO Auto-generated method stub
		//System.out.println("Recherche d'un fournisseur");
		String SELECT_CONTACT_BY_ID = "SELECT idFournisseur, nomFournisseur, adresseFournisseur, emailFournisseur, dateEnregistrementFournisseur FROM fournisseur where idFournisseur = "
				+ idFournisseur + ";";
		Fournisseur fournisseur = new Fournisseur();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_CONTACT_BY_ID);
			// Step 3: Execute the query or update query
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				int idFournisseur1 = rs1.getInt("idFournisseur");
				String nomFournisseur = rs1.getString("nomFournisseur");
				String adresseFournisseur = rs1.getString("adresseFournisseur");
				String emailFournisseur = rs1.getString("emailFournisseur");
				String dateEnregistrementFournisseur = rs1.getString("dateEnregistrementFournisseur");
				fournisseur = new Fournisseur(idFournisseur1, nomFournisseur, adresseFournisseur, emailFournisseur,
						dateEnregistrementFournisseur);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return fournisseur;

	}

	public static void updateFournisseur(String idFournisseur, String nomFournisseur, String adresseFournisseur,
			String emailFournisseur) throws SQLException {
		System.out.println("Modification d'un fournisseur");
		String UPDATE_FOURNISSEUR_SQL = "UPDATE fournisseur SET nomFournisseur ='" + nomFournisseur
				+ "',adresseFournisseur= '" + adresseFournisseur + "', emailFournisseur = '" + emailFournisseur
				+ "' WHERE idFournisseur = " + idFournisseur + ";";
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FOURNISSEUR_SQL);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

}
