package dao;

import java.util.Collection;

import metier.Adresse;
import metier.Agence;
import metier.Client;
import metier.ConseillerClientele;

public interface IDao {

	public Collection<Client> listerClientsConseiller(ConseillerClientele conseillerClientele);
	
	public Collection<Client> listerClientsAgence(Agence agence);
	
	public void ajouterClient(Client c);
	
	public void modifierClient(ConseillerClientele conseiller, int idClient, String civiliteClient, String nomClient,
			String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient,
			String nomEntreprise);
	
	public Client chercherClient(int id); // retrouver un client à partir de son id
	
	public Collection<Client> chercherClientParMC(String mc); // chercher clients par mot clé (par nom)
	
	public void supprimerClient(int id);
	
}
