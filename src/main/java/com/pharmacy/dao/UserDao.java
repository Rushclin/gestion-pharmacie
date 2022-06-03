package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pharmacy.beans.ConnectionBD;
import com.pharmacy.beans.User;

public class UserDao {

	public static void registerUser(User user) throws SQLException, Exception {
		try {
			System.out.println("regidterrrrrrrrrrrrrrrrr_____________________________________________________________");
			String request = "INSERT INTO user(nomUser,email,password,telephone,dateAjout) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = ConnectionBD.connexionBD().prepareStatement(request);
			preparedStatement.setString(1, user.getNameUser());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setDate(5, user.getDateAjout());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionBD.connexionBD().close();
		}
	}

	public static User getUser(User user) throws SQLException, Exception {
		ResultSet resultat = null;
		User userAuth = new User();
		System.out.println(user.getEmail() + "  " + user.getPassword());

		try {
			String request = "SELECT * FROM user WHERE email = ? && password = ?";
			PreparedStatement prep = ConnectionBD.connexionBD().prepareStatement(request);
			prep.setString(1, user.getEmail());
			prep.setString(2, user.getPassword());
			resultat = prep.executeQuery();
			while (resultat.next()) {
				userAuth.setIdUser(resultat.getInt("idUser"));
				userAuth.setNameUser(resultat.getString("nomUser"));
				userAuth.setEmail(resultat.getString("email"));
				userAuth.setPhone(resultat.getString("telephone"));
				userAuth.setDateAjout(resultat.getDate("dateAjout"));
				
			}

		} catch (Exception e) {

		} finally {
			ConnectionBD.connexionBD().close();
		}
		
		return userAuth;
	}

	public static void UpdateUser(User user) throws SQLException, Exception {

		try {
			String request = "UPDATE user SET email = ?,nomUser=?,password=?,telephone=?,dateAjout=? WHERE idUser = ?";
			PreparedStatement preparedStatement = ConnectionBD.connexionBD().prepareStatement(request);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getNameUser());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setDate(5, user.getDateAjout());
			preparedStatement.setInt(6, user.getIdUser());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionBD.connexionBD().close();
		}
	}

	public static void deleteUser(int id) throws Exception {
		ResultSet resultat = null;

		try {
			PreparedStatement preparedStatement = ConnectionBD.connexionBD()
					.prepareStatement("DELETE FROM contact WHERE id= ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			ConnectionBD.connexionBD().close();
		}
	}
}
