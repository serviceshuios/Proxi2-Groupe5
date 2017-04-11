package service;

import java.util.Collection;

import metier.Adresse;
import metier.Client;
import metier.Compte;
import metier.ConseillerClientele;
import metier.Credit;
import metier.PlacementBourse;
import service.exceptions.ClientNonFortuneException;
import service.exceptions.MontantNegatifException;
import service.exceptions.NombreMaxClientsParConseillerException;
import service.exceptions.SoldeInsuffisantException;

/**
 * Interface ConseillerClienteleService faisant appel aux méthodes d'Ajout/Modification/Suppression/Affichage d'un client par un conseiller clientèle
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public interface IConseillerClienteleService {

	/** LISTER CLIENTS */
	public Collection<Client> listerClient (ConseillerClientele conseiller);
	
	/** AJOUTER CLIENT */
	public void ajouterClient(ConseillerClientele conseiller, Client client) throws NombreMaxClientsParConseillerException;
	//public boolean creerClient (Conseiller conseiller, String nom, String prenom, String civilite, String numeroClient, boolean estSociete, String nomSociete);
	//public boolean creerClient (Conseiller conseiller, String nom, String prenom, String civilite, String numeroClient);
	
	/** MODIFIER CLIENT */
	public void modifierClient(ConseillerClientele conseiller, int idClient, String civiliteClient, String nomClient, String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient, String nomEntreprise);
	
	/** RECHERHCER CLIENT */
	public Client chercherClient(int id); // retrouver un client à partir de son id
	public Collection<Client> chercherParMC(String mc); // chercher clients par mot clé (par nom)
	//public SortedSet<Client> chercherParMC(String mc); // chercher clients par mot clé (par nom)
	
	/** SUPPRIMER CLIENT */
	public void supprimerClient(ConseillerClientele conseiller, Client client);
	
	/** GERER COMPTES */
	//public boolean ajouterCompte(Client client, String typeCompte, String numero, float solde, Date dateOuverture);
	//public boolean creerCompteCourant(Client client, String numero, float solde, Date dateOuverture, boolean compteEntreprise);
	//public boolean creerCompteEpargne(Client client, String numero, float soldeDepart, Date dateOuverture, boolean compteEntreprise);
	public void effectuerVirement(Compte compteADebiter, Compte compteACrediter, double montant) throws SoldeInsuffisantException, MontantNegatifException;
	public void effectuerPlacementBourse(Client client, Compte compte, PlacementBourse placement, double montant) throws ClientNonFortuneException, SoldeInsuffisantException, MontantNegatifException;
	//public boolean supprimerCompte(Conseiller conseiller, Client client, String typeCompte);
	
	/** CREDIT */
	public double[] simulerCredit(Credit c) throws MontantNegatifException;
	//public void simulerCreditImmobilier(Client client, CreditImmobilier creditImmo);
	//public void simulerCreditConsommation(Client client, CreditConsommation creditConso);

	
	
	
	
	
	
	
	
}
