package dao;

import java.util.Collection;

import metier.Agence;
import metier.Client;
import metier.ConseillerClientele;

public interface IDao {

	public ConseillerClientele authentifier(String login, String password);
	
	public Collection<Client> listerClientsConseiller(ConseillerClientele conseillerClientele);
	
	public Collection<Client> listerClientsAgence(Agence agence);
	
	public void ajouterClient(Client c);
	
	public void modifierClient(int id, String civilite, String nom, String prenom, String rue, String codePostal,
			String ville, String telephone, String email, String nomEntreprise);
	
	public Client chercherClient(int id); // retrouver un client à partir de son id
	
	public Collection<Client> chercherClientParMC(String mc); // chercher clients par mot clé (par nom)
	
	public void supprimerClient(int id);
	
}
