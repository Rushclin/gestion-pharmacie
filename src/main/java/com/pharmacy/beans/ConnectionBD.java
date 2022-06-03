package com.pharmacy.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	
	public static Connection connexionBD() throws SQLException, Exception{
   	 Class.forName("com.mysql.jdbc.Driver");
   	 Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie", "root", "");
		return connexion;
   	 
    }
}
