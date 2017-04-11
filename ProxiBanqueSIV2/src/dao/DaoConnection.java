package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection {
	
	private static final String PILOTE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bddclients";
	private static final String USER = "root";
	private static final String PWD = "";
	private static Connection conn = null;
	
	// Connection
	public static Connection getConnection() {
		if (conn == null) {
			try {	
				// charger le pilote
				Class.forName(PILOTE);				// driver correpondant à mon type de BDD (voir javadoc)
				// créer la connexion
				Connection conn = DriverManager.getConnection(URL, USER, PWD); // adresse de ma base de données + login + mdp
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return conn;
		} else {
			return conn;
		}
	}
	
	// Déconnection
	public static void closeConnection() {
		if (conn != null) {
			
			try {
				// fermer la connexion
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
