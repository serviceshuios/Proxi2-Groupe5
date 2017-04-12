package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection {
	
	private static final String PILOTE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/proxibanquev2";
	private static final String USER = "root";
	private static final String PWD = "";
	private static Connection connection = null;
	
	// Connection
	public static Connection getConnection() {
		
		if (connection == null) {
			try {	
				// charger le pilote
				Class.forName(PILOTE);				// driver correpondant � mon type de BDD (voir javadoc)
				// cr�er la connexion
				connection = DriverManager.getConnection(URL, USER, PWD); // adresse de ma base de donn�es + login + mdp
			} catch (Exception e) {
				e.printStackTrace();
			}		
			
		} 
		
		return connection;

	}
	
	// D�connection
	public static void closeConnection() {
		if (connection != null) {
			
			try {
				// fermer la connexion
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
