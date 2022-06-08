
package org.pharmacie.dao;

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

//import org.pharmacie.beans.;
//import org.pharmacie.beans.Client;
import org.pharmacie.beans.Commande;
import org.pharmacie.beans.Fournisseur;

/**
 * Servlet implementation class FournisseurDAO
 */
@WebServlet("/CommandeDAO")
public class CommandeDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String jdbcURL = "jdbc:mysql://localhost:3306/gestion_pharmacie";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "";
	
	public static int numcmd=0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandeDAO() {
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
		System.out.println("connection");
		return connection;
	}

	public static List<Commande> findAll() throws Exception {
		// System.out.println("Recherche de tous les commande");
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Commande> commandes = new ArrayList<>();
		// Step 1: Establishing a Connection
		Connection connection = getConnection();
		try {

			System.out.println("connection");
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM commande");
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Commande commande = new Commande();
				int idCommande = rs.getInt("idCommande");
				int quantiteCommande = rs.getInt("quantiteCommande");
				int prixCommande = rs.getInt("prixCommande");
				int idClient = rs.getInt("idClient");
				//Client client = searchClient(idClient);
				Date dateCommande = rs.getDate("dateCommande");
				
				commande.setIdCommande(idCommande);
				commande.setQuantiteCommande(quantiteCommande);
				commande.setPrixCommande(prixCommande);
				commande.setDateCommande(dateCommande);
				commande.setIdClient(idClient);
				//commande.setClient(client);
				commandes.add(commande);
			}

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			;
		} finally {
			connection.close();
		}
		System.out.println("tout vos commandes sont afficher");
		return commandes;
	}

	public static void createCommande(String quantiteCommande, String prixCommande, String idClient) throws Exception {
		// TODO Auto-generated method stub
		LocalDate dateEnregistrementCommande = LocalDate.now();
		String INSERT_COMMANDE_SQL = "INSERT INTO commande"
				+ "  (quantiteCommande, prixCommande, dateCommande, idClient) VALUES " + " ('" + quantiteCommande
				+ "', '" + prixCommande + "','" + dateEnregistrementCommande + "', '" + idClient + "');";

		Connection connection = getConnection();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMANDE_SQL);
			preparedStatement.executeUpdate();
			System.out.println("Votre commande a été bien ajouter");
			numcmd = numcmd+1;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		} finally {
			connection.close();
		}
	}
	
	public static void deleteCommande(String idCommande) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("Suppression d'une commande");
		String DELETE_OMMANDE_SQL = "DELETE FROM commande WHERE idCommande =" + idCommande + ";";
		Connection connection = getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_OMMANDE_SQL)) {
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		} finally {
			connection.close();
		}
	}
	
	public static Commande searchCommande(String idCommande) throws SQLException {
		// TODO Auto-generated method stub
		 System.out.println("Recherche d'une commande");
		String SELECT_CONTACT_BY_ID = "SELECT idCommande, quantiteCommande, prixCommande, dateCommande, idClient FROM commande where idCommande = "
				+ idCommande + ";";
		Commande commande = new Commande();
		
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_CONTACT_BY_ID);
			// Step 3: Execute the query or update query
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				int idCommande1 = rs1.getInt("idCommande");
				int quantiteCommande = rs1.getInt("quantiteCommande");
				int prixCommande = rs1.getInt("prixCommande");
				Date dateCommande = rs1.getDate("dateCommande");
				int idClient = rs1.getInt("idClient");
				commande = new Commande(idCommande1, quantiteCommande, prixCommande, dateCommande, idClient);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return commande;
	}


	public static void updateCommande(String idCommande, String quantiteCommande, String prixCommande, String idClient) throws SQLException {
		System.out.println("Modification d'un fournisseur");
		String UPDATE_COMMANDE_SQL = "UPDATE commande SET quantiteCommande ='" + quantiteCommande
				+ "',prixCommande= '" + prixCommande + "', idClient = '" + idClient
				+ "' WHERE idCommande = " + idCommande + ";";
		Connection connection = getConnection();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMMANDE_SQL);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		} finally {
			connection.close();
		}
	}

//	public static Client searchClient(int idClient) throws SQLException {
//	// TODO Auto-generated method stub
//	// System.out.println("Recherche d'un client");
//	String SELECT_CLIENT_BY_ID = "SELECT idClient, nomClient, telephoneClient, emailClient, dateAjoutClient FROM client where idClient = "
//			+ idClient + ";";
//	Client client = new Client();
//	Connection connection = getConnection();
//	// Step 1: Establishing a Connection
//	try {
//
//		// Step 2:Create a statement using connection object
//		PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_CLIENT_BY_ID);
//		// Step 3: Execute the query or update query
//		ResultSet rs1 = preparedStatement1.executeQuery();
//		while (rs1.next()) {
//			int idClient1 = rs1.getInt("idClient");
//			String nomClient = rs1.getString("nomClient");
//			int telephoneClient = rs1.getInt("telephoneClient");
//			String emailClient = rs1.getString("emailClient");
//			String dateAjoutClient = rs1.getString("dateAjoutClient");
//			client = new Client(idClient1,nomClient,telephoneClient,emailClient);
//		}
//	} catch (SQLException e) {
//		System.out.print(e.getMessage());
//	} finally {
//		connection.close();
//	}
//	return client;
//
//}

}
