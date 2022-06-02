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

/**
 * Servlet implementation class ClientDao
 */
@WebServlet("/ClientDao")
public class ClientDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String jdbcURL = "jdbc:mysql://localhost:3306/gestion_pharmacie";
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

}
