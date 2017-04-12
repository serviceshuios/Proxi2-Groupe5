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
import metier.CompteCourant;
import metier.CompteEpargne;
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
			ps.setInt(1, conseillerClientele.getIdConseiller());
			
			/* 4- exécuter la requête */
			ResultSet rs = ps.executeQuery(); // ResultSet est un tableau qui va contenir toutes mes colonnes
			
			/* 5- présenter les résultats */
			while(rs.next()) {					// tant qu'il y a des enregistrements
				
				Client client;
				
				if(rs.getString("nomEntreprise") != null) {
					client = new ClientEntreprise();
				} else {
					client = new ClientParticulier();
				}
				
				client.setIdClient(rs.getInt("idClient"));
				client.setCivilite(rs.getString("civilite"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				
				Adresse adresse = new Adresse(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));
				client.setAdresse(adresse);
				
				client.setTelephone(rs.getString("telephone"));
				client.setEmail(rs.getString("email"));
				client.setNomEntreprise(rs.getString("nomEntreprise"));
				
				clients.add(client);						// ajouter le client à la collection
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
	public void ajouterClient(Client client) {
		try {
			/* 1- charger le pilote + 2- créer la connection */
			//Connection conn = DaoConnection.getConnection();
			Class.forName("com.mysql.jdbc.Driver"); // driver correpondant à mon type de BDD (voir javadoc)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", "root", ""); // adresse de ma base de données + login + mdp

			/* 3- créer la requête */
			PreparedStatement ps = conn.prepareStatement("INSERT INTO clients(civilite,nom,prenom,rue,codePostal,ville,telephone,email,nomEntreprise) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, client.getCivilite());
			ps.setString(2, client.getNom());
			ps.setString(3, client.getPrenom());
			ps.setString(4, client.getAdresse().getRue());
			ps.setString(5, client.getAdresse().getCodePostal());
			ps.setString(6, client.getAdresse().getVille());
			ps.setString(7, client.getTelephone());
			ps.setString(8, client.getEmail());
			ps.setString(9, client.getNomEntreprise());
			
			/* 4- exécuter la requête */
			ps.executeUpdate();
			
			/* 5- présenter les résultats */
			// pas de résultat à présenter dans cette méthode
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	//	code qui est executé quelque soient les étapes précédentes
			/* 6 - fermer la connexion */
			DaoConnection.closeConnection();
		}
	}

	@Override
	public void modifierClient(Client client) {
			
		try {
			/* 1- charger le pilote + 2- créer la connection */
			//Connection conn = DaoConnection.getConnection();
			Class.forName("com.mysql.jdbc.Driver"); // driver correpondant à mon type de BDD (voir javadoc)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", "root", ""); // adresse de ma base de données + login + mdp
			
			/* 3- créer la requête */
			PreparedStatement ps = conn.prepareStatement("UPDATE clients SET civilite = ?, nom = ?, prenom = ?, rue = ?, codePostal = ?, ville = ?, telephone = ?, email = ?, nomEntreprise = ? WHERE idClient = ?");
			ps.setString(1, client.getCivilite());
			ps.setString(2, client.getNom());
			ps.setString(3, client.getPrenom());
			ps.setString(4, client.getAdresse().getRue());
			ps.setString(5, client.getAdresse().getCodePostal());
			ps.setString(6, client.getAdresse().getVille());
			ps.setString(7, client.getTelephone());
			ps.setString(8, client.getEmail());
			ps.setString(9, client.getNomEntreprise());
			ps.setInt(10, client.getIdClient());
			
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
		
		Client client;
		boolean clientEntreprise;
		
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
			
			if(rs.getString("nomEntreprise") != null) {
				client = new ClientEntreprise();
				clientEntreprise = true;
			} else {
				client = new ClientParticulier();
				clientEntreprise = false;
			}
			
			client.setIdClient(rs.getInt("idClient"));
			client.setCivilite(rs.getString("civilite"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			
			Adresse adresse = new Adresse(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));
			client.setAdresse(adresse);
			
			client.setTelephone(rs.getString("telephone"));
			client.setEmail(rs.getString("email"));
			client.setNomEntreprise(rs.getString("nomEntreprise"));
			
			ps = conn.prepareStatement("SELECT * FROM comptecourant WHERE idClient = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				CompteCourant comptecourant = new CompteCourant();
				comptecourant.setIdCompte(rs.getInt("idCompteCourant"));
				comptecourant.setSoldeCompte(rs.getFloat("solde"));
				comptecourant.setDateOuvertureCompte(rs.getDate("dateOuvertureCompte"));
				comptecourant.setDecouvert(rs.getFloat("decouvert"));
				comptecourant.setClientProprietaire(client);
				comptecourant.setCompteEntreprise(clientEntreprise);
				client.setCompteCourant(comptecourant);
			} else {
				client.setCompteCourant(new CompteCourant());
			}
			
			ps = conn.prepareStatement("SELECT * FROM compteepargne WHERE idClient = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				CompteEpargne compteepargne = new CompteEpargne();
				compteepargne.setIdCompte(rs.getInt("idCompteEpargne"));
				compteepargne.setSoldeCompte(rs.getFloat("solde"));
				compteepargne.setDateOuvertureCompte(rs.getDate("dateOuvertureCompte"));
				compteepargne.setTauxRemuneration(rs.getFloat("tauxRemuneration"));
				compteepargne.setClientProprietaire(client);
				compteepargne.setCompteEntreprise(clientEntreprise);
				client.setCompteEpargne(compteepargne);
			} else {
				client.setCompteEpargne(new CompteEpargne());
			}			
			return client;
			
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
		
		Collection<Client> clients = new ArrayList<Client>();
		
		try {
			/* 1- charger le pilote + 2- créer la connection */
			//Connection conn = DaoConnection.getConnection();
			Class.forName("com.mysql.jdbc.Driver"); // driver correpondant à mon type de BDD (voir javadoc)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", "root", ""); // adresse de ma base de données + login + mdp
			
			/* 3- créer la requête */
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE nom LIKE ?");
			ps.setString(1,"%"+mc+"%");
			
			/* 4- exécuter la requête */
			ResultSet rs = ps.executeQuery(); // ResultSet est un tableau qui va contenir toutes mes colonnes
			
			/* 5- présenter les résultats */
			while(rs.next()) {					// tant qu'il y a des enregistrements
				
				Client client;
				
				if(rs.getString("nomEntreprise") != null) {
					client = new ClientEntreprise();
				} else {
					client = new ClientParticulier();
				}
				
				client.setIdClient(rs.getInt("idClient"));
				client.setCivilite(rs.getString("civilite"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				
				Adresse adresse = new Adresse(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));
				client.setAdresse(adresse);
				
				client.setTelephone(rs.getString("telephone"));
				client.setEmail(rs.getString("email"));
				client.setNomEntreprise(rs.getString("nomEntreprise"));
				
				clients.add(client);						// ajouter le client à la collection
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
	public void supprimerClient(int id) {
		try {
			/* 1- charger le pilote + 2- créer la connection */
			//Connection conn = DaoConnection.getConnection();
			
			Class.forName("com.mysql.jdbc.Driver"); // driver correpondant à mon type de BDD (voir javadoc)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", "root", ""); // adresse de ma base de données + login + mdp
			
			// 3- créer la requête + 4- exécuter la requête
			PreparedStatement ps = conn.prepareStatement("DELETE FROM cartebancaire WHERE idClient = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			// 3- créer la requête + 4- exécuter la requête
			ps = conn.prepareStatement("DELETE FROM comptecourant WHERE idClient = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			// 3- créer la requête + 4- exécuter la requête
			ps = conn.prepareStatement("DELETE FROM compteepargne WHERE idClient = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			// 3- créer la requête + 4- exécuter la requête
			ps = conn.prepareStatement("DELETE FROM clients WHERE idClient = ?");
			ps.setInt(1, id);
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
