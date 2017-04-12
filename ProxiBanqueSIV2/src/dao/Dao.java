package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import metier.Adresse;
import metier.Agence;
import metier.Client;
import metier.ClientEntreprise;
import metier.ClientParticulier;
import metier.ConseillerClientele;

public class Dao implements IDao {

	@Override
	public ConseillerClientele authentifier(String login, String password) {
		try {
			/* 1- charger le pilote + 2- créer la connection */
			//Connection conn = DaoConnection.getConnection();
			
			Class.forName("com.mysql.jdbc.Driver"); // driver correpondant à mon type de BDD (voir javadoc)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", "root", ""); // adresse de ma base de données + login + mdp
			
			/* 3- créer la requête */
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM conseillers");
			
			/* 4- exécuter la requête */
			ResultSet rs = ps.executeQuery(); // ResultSet est un tableau qui va contenir toutes mes colonnes
			
			/* 5- présenter les résultats */
			while(rs.next()) {					// tant qu'il y a des enregistrements
				if (rs.getString("email").equals(login) && rs.getString("password").equals(password)) {
					return new ConseillerClientele(rs.getInt("idConseiller"), rs.getString("civilite"), rs.getString("nom"), rs.getString("prenom"));
				}
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		//	code qui est executé quelque soient les étapes précédentes
			/* 6 - fermer la connexion */
			DaoConnection.closeConnection();
		}
		return null;
	}
	
	@Override
	public Collection<Client> listerClientsConseiller(ConseillerClientele conseillerClientele) {
		Collection<Client> clients = new ArrayList<Client>();
		
		try {
			/* 1- charger le pilote + 2- créer la connection */
			//Connection conn = DaoConnection.getConnection();
			
			Class.forName("com.mysql.jdbc.Driver"); // driver correpondant à mon type de BDD (voir javadoc)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", "root", ""); // adresse de ma base de données + login + mdp
			
			/* 3- créer la requête */
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE idConseiller = ?");
			//ps.setString(1, String.valueOf(conseillerClientele.getIdConseiller()));
			ps.setInt(1, conseillerClientele.getIdConseiller());
			
			/* 4- exécuter la requête */
			ResultSet rs = ps.executeQuery(); // ResultSet est un tableau qui va contenir toutes mes colonnes
			
			/* 5- présenter les résultats */
			while(rs.next()) {					// tant qu'il y a des enregistrements
				Adresse adresse = new Adresse(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));
				
				Client c;
				
				if(rs.getString("nomEntreprise") != null) {
					c = new ClientEntreprise();		// créer un client avec les informations retournées par la BDD
				} else {
					c = new ClientParticulier();	// créer un client avec les informations retournées par la BDD
				}
				
				c.setIdClient(rs.getInt("idClient"));
				c.setCivilite(rs.getString("civilite"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setAdresse(adresse);
				c.setTelephone(rs.getString("telephone"));
				c.setEmail(rs.getString("email"));
				c.setNomEntreprise(rs.getString("nomEntreprise"));
				
				clients.add(c);						// ajouter le client à la collection
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		//	code qui est executé quelque soient les étapes précédentes
			/* 6 - fermer la connexion */
			DaoConnection.closeConnection();
		}
		
		return clients;
	}
	
	@Override
	public Collection<Client> listerClientsAgence(Agence agence) {
		return null;
	}
	
	@Override
	public void ajouterClient(Client c) {
		
	}
//	public void ajouterClient(Client c) {
//		try {
//			/* 1- charger le pilote + 2- créer la connection */
//			Connection conn = DaoConnection.getConnection();
//			
//			/* 3- créer la requête */
//			// on précise les champs à renseigner (nom et prenom) sachant que l'id sera autoincrémenté par la BDD
//			// 1ère méthode
//			//PreparedStatement ps = conn.prepareStatement("INSERT INTO Client(nom,prenom) VALUES ('" + c.getNom() + "','" + c.getPrenom() + "')");
//			// 2ème méthode
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO Client(nom,prenom,age,couleurYeux) VALUES (?,?,?,?)");
//			ps.setString(1, c.getNom());
//			ps.setString(2, c.getPrenom());
//			ps.setInt(3, c.getAge());
//			ps.setString(4, c.getCouleurYeux());
//			
//			/* 4- exécuter la requête */
//			ps.executeUpdate();
//			
//			/* 5- présenter les résultats */
//			// pas de résultat à présenter dans cette méthode
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {	//	code qui est executé quelque soient les étapes précédentes
//			/* 6 - fermer la connexion */
//			DaoConnection.closeConnection();
//		}
//	}

	@Override
	public void modifierClient(int id, String civilite, String nom,	String prenom, String rue,
			String codePostal, String ville, String telephone, String email, String nomEntreprise) {
			
		try {
			/* 1- charger le pilote + 2- créer la connection */
			//Connection conn = DaoConnection.getConnection();
			
			Class.forName("com.mysql.jdbc.Driver"); // driver correpondant à mon type de BDD (voir javadoc)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", "root", ""); // adresse de ma base de données + login + mdp
			
			/* 3- créer la requête */
			PreparedStatement ps = conn.prepareStatement("UPDATE clients SET civilite = ?, nom = ?, prenom = ?, rue = ?, codePostal = ?, ville = ?, telephone = ?, email = ?, nomEntreprise = ? WHERE idClient = ?");
			ps.setString(1, civilite);
			ps.setString(2, nom);
			ps.setString(3, prenom);
			ps.setString(4, rue);
			ps.setString(5, codePostal);
			ps.setString(6, ville);
			ps.setString(7, telephone);
			ps.setString(8, email);
			ps.setString(9, nomEntreprise);
			ps.setInt(10, id);
			
			/* 4- exécuter la requête */
			ps.executeUpdate();
			
			/* 5- présenter les résultats */
			// pas de résultat à présenter dans cette méthode
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		//	code qui est executé quelque soient les étapes précédentes
			/* 6 - fermer la connexion */
			DaoConnection.closeConnection();
		}
	}

	
	@Override
	public Client chercherClient(int id) {
		Client c;
		
		try {
			/* 1- charger le pilote + 2- créer la connection */
			//Connection conn = DaoConnection.getConnection();
			
			Class.forName("com.mysql.jdbc.Driver"); // driver correpondant à mon type de BDD (voir javadoc)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", "root", ""); // adresse de ma base de données + login + mdp
			
			/* 3- créer la requête */
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE idClient = ?");
			ps.setInt(1, id);
			
			/* 4- exécuter la requête */
			ResultSet rs = ps.executeQuery(); // ResultSet est un tableau qui va contenir toutes mes colonnes
			
			/* 5- présenter les résultats */
			rs.next();
			
			Adresse adresse = new Adresse(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));
			
			if(rs.getString("nomEntreprise") != null) {
				c = new ClientEntreprise();		// créer un client avec les informations retournées par la BDD
			} else {
				c = new ClientParticulier();	// créer un client avec les informations retournées par la BDD
			}
			
			c.setIdClient(rs.getInt("idClient"));
			c.setCivilite(rs.getString("civilite"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));
			c.setAdresse(adresse);
			c.setTelephone(rs.getString("telephone"));
			c.setEmail(rs.getString("email"));
			c.setNomEntreprise(rs.getString("nomEntreprise"));
			
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		//	code qui est executé quelque soient les étapes précédentes
			/* 6 - fermer la connexion */
			DaoConnection.closeConnection();
		}
		return null;
	}
	
	@Override
	public Collection<Client> chercherClientParMC(String mc) {
		return null;
	}
//	public Collection<Client> chercherParMC(String mc) {
//	
//		Collection<Client> cl = new ArrayList<Client>();
//		
//		try {
//			/* 1- charger le pilote + 2- créer la connection */
//			Connection conn = DaoConnection.getConnection();
//			
//			/* 3- créer la requête */
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE nom LIKE ?");
//			ps.setString(1,"%"+mc+"%");
//			
//			/* 4- exécuter la requête */
//			ResultSet rs = ps.executeQuery(); // ResultSet est un tableau qui va contenir toutes mes colonnes
//			
//			/* 5- présenter les résultats */
//			while(rs.next()) {					// tant qu'il y a des enregistrements
//				Client c = new Client();		// créer un client avec les informations retournées par la BDD
//				c.setId(rs.getInt("id"));
//				c.setNom(rs.getString("nom"));
//				c.setPrenom(rs.getString("prenom"));
//				c.setAge(rs.getInt("age"));
//				c.setCouleurYeux(rs.getString("couleurYeux"));
//				cl.add(c);						// ajouter le client à la collection
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {		//	code qui est executé quelque soient les étapes précédentes
//			/* 6 - fermer la connexion */
//			DaoConnection.closeConnection();
//		}
//		
//		return cl;
//		
//	}

	@Override
	public void supprimerClient(int id) {
		try {
			/* 1- charger le pilote + 2- créer la connection */
			Connection conn = DaoConnection.getConnection();
			
			// 3- créer la requête
			PreparedStatement ps = conn.prepareStatement("DELETE FROM clients WHERE idClient = ?");
			ps.setInt(1, id);
			
			// 4- exécuter la requête
			ps.executeUpdate();
			
			// 5- présenter les résultats
			// pas de résultat à présenter dans cette méthode
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		//	code qui est executé quelque soient les étapes précédentes
			/* 6 - fermer la connexion */
			DaoConnection.closeConnection();
		}
	}

}
