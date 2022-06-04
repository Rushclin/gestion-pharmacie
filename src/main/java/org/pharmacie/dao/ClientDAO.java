package org.pharmacie.dao;
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

import org.pharmacie.beans.Client;

/**
 * Servlet implementation class ClientDao
 */
@WebServlet("/ClientDao")
public class ClientDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String jdbcURL = "jdbc:mysql://localhost:3306/pharmacie";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientDAO() {
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
		return connection;
	}

	public static List<Client> findAll() {
		System.out.println("Recherche de tous les fournisseurs");
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Client> clients = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client");
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Client client = new Client();
				int idClient = rs.getInt("idClient");
				String nomClient = rs.getString("nomClient");
				String telephoneClient = rs.getString("telephoneClient");
				String emailClient = rs.getString("emailClient");
				Date dateAjoutClient = rs.getDate("dateAjoutClient");
				client.setIdClient(idClient);
				client.setNomClient(nomClient);
				client.setTelephoneClient(telephoneClient);
				client.setEmailClient(emailClient);
				client.setDateAjoutClient(dateAjoutClient);
				clients.add(client);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());   
		}
		return clients;
	}

	public static void createClient(String nomClient, String telephoneClient, String emailClient) {
		// TODO Auto-generated method stub
		System.out.println("Creation d'un client");
		LocalDate dateEnregistrementClient = LocalDate.now();
		String INSERT_CLIENT_SQL = "INSERT INTO client"
				+ "  (nomClient, telephoneClient, emailClient, dateAjoutClient) VALUES ('" + nomClient + "', '"
				+ telephoneClient + "','" + emailClient + "', '" + dateEnregistrementClient + "');";
		System.out.println(INSERT_CLIENT_SQL);
		// try-with-resource statement will auto close the connection.
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}  
	}
	
	public static void updateClient(String idClient, String nomClient, String telephoneClient, String emailClient) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Modifier un client");
		LocalDate dateEnregistrementClient = LocalDate.now();
		String UPDATE_CLIENT_SQL = "UPDATE client SET nomClient ='" + nomClient
				+ "',telephoneClient= '" + telephoneClient + "', emailClient = '" + emailClient
				+ "' WHERE idClient = " + idClient + ";";
		System.out.println(UPDATE_CLIENT_SQL);
		// try-with-resource statement will auto close the connection.
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_SQL);
			preparedStatement.executeUpdate();
			System.out.println(UPDATE_CLIENT_SQL);
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}
	
	
	public static void deleteClient(String idClient) {
		// TODO Auto-generated method stub
		System.out.println("Suppression d'un client");
		String DELETE_CLIENT_SQL = "DELETE FROM client WHERE idClient =" + idClient + ";";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_SQL)) {
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}
	
	public static Client searchClient(String idClient) {
		// TODO Auto-generated method stub
		//System.out.println("Recherche d'un client");
		String SELECT_CONTACT_BY_ID = "SELECT idClient, nomClient, telephoneClient, emailClient, dateAjoutClient FROM client where idClient = "
				+ idClient + ";";
		Client client = new Client();
		// Step 1: Establishing a Connection
		try { 
			Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_CONTACT_BY_ID);
			// Step 3: Execute the query or update query
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				int idClient1 = rs1.getInt("idClient");
				String nomClient = rs1.getString("nomClient");
				String telephoneClient = rs1.getString("telephoneClient");
				String emailClient = rs1.getString("emailClient");
				Date dateAjoutClient = rs1.getDate("dateAjoutClient"); 
				client = new Client(idClient1, nomClient, telephoneClient, emailClient, dateAjoutClient);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return client;

	}

}
