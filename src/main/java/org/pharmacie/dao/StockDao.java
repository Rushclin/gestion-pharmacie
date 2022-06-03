package org.pharmacie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pharmacie.beans.Stock;

public class StockDao {
	public static Statement connexion() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie", "root", "");
		java.sql.Statement statement = connection.createStatement();
		return statement;
	}

	public static List<Stock> getAllStock() throws Exception {
		List<Stock> listeStock = new ArrayList<Stock>();
		ResultSet resultat = null;
		Statement statement = null;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			statement = connexion();
			resultat = statement.executeQuery("SELECT * FROM stock");
			while (resultat.next()) {
				Stock st = new Stock();
				st.setIdStock(resultat.getString("idStock"));
				st.setQuantiteStock(resultat.getString("quantite"));
				st.setDateAjout(resultat.getString("dateAjout"));
				st.setIdFournisseur(resultat.getString("idFournisseur"));
				st.setIdProduit(resultat.getString("idProduit"));
				listeStock.add(st);
				// System.out.print(listeStock);
			}
			statement.close();
		} catch (Exception e) {

		} finally {
			connexion().close();
			statement.close();
		}
		return listeStock;
	}

	// Fonction de suppression

	public static void deleteStock(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie", "root", "");
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM stock WHERE idStock= ?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			connection.close();
			System.out.print("Pocessus de suppression " + id);
		} catch (Exception e) {
			// On veux on gere l'exception
			System.out.print("Errur Pocessus de suppression");
		} finally {

		}

	}

	// Recuperer un stock avec l'identifiant
	public static Stock getOneStock(String id) throws ClassNotFoundException {
		ResultSet resultat = null;
		Statement statement = null;
		Stock st = new Stock();
		Class.forName("com.mysql.jdbc.Driver");
		try {
			statement = connexion();
			resultat = statement.executeQuery("SELECT * FROM stock");
			while (resultat.next()) {
				if (resultat.getString("idStock").equals(id)) {
					st.setIdStock(resultat.getString("idStock"));
					st.setQuantiteStock(resultat.getString("quantite"));
					st.setDateAjout(resultat.getString("dateAjout"));
					st.setIdFournisseur(resultat.getString("idFournisseur"));
					st.setIdProduit(resultat.getString("idProduit"));
				}
			}
			statement.close();
		} catch (Exception e) {
			// On gere l'exception
		}
		return st;
	}
	// On recupere la liste des fournisseurs

	// Ici, on doit faire l'ajout

	// Mise a jour du stock
	public static void updateStock(String id) throws Exception {

	}

}
