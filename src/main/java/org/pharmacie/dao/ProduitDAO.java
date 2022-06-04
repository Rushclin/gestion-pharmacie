package org.pharmacie.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.pharmacie.beans.Produit;

/*import databaseUtilities.DBFunction;*/

public class ProduitDAO {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/pharmacie";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "";
	private static final String SELECT_ALL_PRODUIT = "SELECT * FROM produit";

	public ProduitDAO() {
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
		System.out.println(connection);
		return connection;
	}

	public static List<Produit> findAll() throws SQLException {
		System.out.println("Recherche de tous les produit");
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Produit> produits = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUIT);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Produit produit = new Produit();
				int idp = rs.getInt("idProduit");
				String nproduit = rs.getString("nomProduit");
				String cproduit = rs.getString("codeProduit");
				String disponibilite = rs.getString("disponibilite");
				Date dateA = rs.getDate("dateAjout");
				int poid = rs.getInt("poids");
				String dproduit = rs.getString("descriptionProduit");
				String oproduit = rs.getString("originProduit");
				int prix = rs.getInt("prix");
				produit.setIdProduit(idp);
				produit.setNomProduit(nproduit);
				produit.setCodeProduit(cproduit);
				produit.setDisponibilite(disponibilite);
				produit.setDateAjout(dateA);
				produit.setPoids(poid);
				produit.setDescriptionProduit(dproduit);
				produit.setOriginProduit(oproduit);
				produit.setPrix(prix);
				produits.add(produit);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		} finally {
			getConnection().close();
		}
		return produits;
	}

	public static void createProduit(String nomproduit, String codeproduit, String poid, String description,
			String origin, String prix) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Creation de un produit");
		LocalDate dateA = LocalDate.now();
		String INSERT_PRODUIT_SQl = "INSERT INTO produit"
				+ "  ( nomProduit, codeProduit,disponibilite, dateAjout , originProduit,poids, descriptionProduit ,prix,idCategorie) VALUES "
				+ " ('" + nomproduit + "'," + codeproduit + ",'" + dateA + "','" + origin + "'," + poid + ",'"
				+ description + "'," + prix +  " );";
		System.out.println(INSERT_PRODUIT_SQl);
		// try-with-resource statement will auto close the connection.
		Connection connection = getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUIT_SQl);
			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		} finally {
			connection.close();
		}
	}

	public static void deleteProduit(String id) {
		// TODO Auto-generated method stub
		System.out.println("Suppression de un produit");

		String DELETE_PRODUIT_SQL = "delete from produit where idProduit =" + id + ";";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUIT_SQL)) {
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

}