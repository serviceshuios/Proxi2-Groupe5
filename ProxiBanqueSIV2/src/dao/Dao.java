package dao;

import java.util.Collection;

import metier.Adresse;
import metier.Agence;
import metier.Client;
import metier.ConseillerClientele;

public class Dao implements IDao {

	@Override
	public Collection<Client> listerClientsConseiller(ConseillerClientele conseillerClientele) {
		return null;
	}
	
	@Override
	public Collection<Client> listerClientsAgence(Agence agence) {
		return null;
	}
	
//	public Collection<Client> listerClients() {
//		
//		Collection<Client> cl = new ArrayList<Client>();
//		
//		try {
//			/* 1- charger le pilote + 2- créer la connection */
//			Connection conn = DaoConnection.getConnection();
//			
//			/* 3- créer la requête */
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM client");
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
	public void modifierClient(ConseillerClientele conseiller, int idClient, String civiliteClient, String nomClient,
			String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient,
			String nomEntreprise) {
		
	}
	
//	public void modifierClient(int id, String nom, String prenom, int age, String couleurYeux) {
//		try {
//			/* 1- charger le pilote + 2- créer la connection */
//			Connection conn = DaoConnection.getConnection();
//			
//			/* 3- créer la requête */
//			PreparedStatement ps = conn.prepareStatement("UPDATE Client SET nom = ?, prenom = ?, age = ?, couleurYeux = ? WHERE id = ?");
//			ps.setString(1, nom);
//			ps.setString(2, prenom);
//			ps.setInt(3, age);
//			ps.setString(4, couleurYeux);
//			ps.setInt(5, id);
//			
//			/* 4- exécuter la requête */
//			ps.executeUpdate();
//			
//			/* 5- présenter les résultats */
//			// pas de résultat à présenter dans cette méthode
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {		//	code qui est executé quelque soient les étapes précédentes
//			/* 6 - fermer la connexion */
//			DaoConnection.closeConnection();
//		}
//	}

	@Override
	public Client chercherClient(int id) {
		return null;
	}
	
//	public Client chercherClient(int id) {
//		
//		Client c = new Client();
//		
//		try {
//			/* 1- charger le pilote + 2- créer la connection */
//			Connection conn = DaoConnection.getConnection();
//			
//			/* 3- créer la requête */
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE client.id = ?");
//			ps.setInt(1, id);
//			
//			/* 4- exécuter la requête */
//			ResultSet rs = ps.executeQuery(); // ResultSet est un tableau qui va contenir toutes mes colonnes
//			
//			/* 5- présenter les résultats */
//			rs.next();
//			c.setId(rs.getInt("id"));
//			c.setNom(rs.getString("nom"));
//			c.setPrenom(rs.getString("prenom"));
//			c.setAge(rs.getInt("age"));
//			c.setCouleurYeux(rs.getString("couleurYeux"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {		//	code qui est executé quelque soient les étapes précédentes
//			/* 6 - fermer la connexion */
//			DaoConnection.closeConnection();
//		}
//		
//		return c;
//	}
	
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
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE nom LIKE ?");
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
		
	}
	
//	public void supprimerClient(int id) {
//		try {
//			/* 1- charger le pilote + 2- créer la connection */
//			Connection conn = DaoConnection.getConnection();
//			
//			// 3- créer la requête
//			PreparedStatement ps = conn.prepareStatement("DELETE FROM Client WHERE id = ?");
//			ps.setInt(1, id);
//			
//			// 4- exécuter la requête
//			ps.executeUpdate();
//			
//			// 5- présenter les résultats
//			// pas de résultat à présenter dans cette méthode
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {		//	code qui est executé quelque soient les étapes précédentes
//			/* 6 - fermer la connexion */
//			DaoConnection.closeConnection();
//		}
//	}

}
