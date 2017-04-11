package service;

import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Adresse;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.ConseillerClientele;
import metier.Credit;
import metier.PlacementBourse;
import service.exceptions.ClientNonFortuneException;
import service.exceptions.MontantNegatifException;
import service.exceptions.NombreMaxClientsParConseillerException;
import service.exceptions.SoldeInsuffisantException;

/**
 * La classe service ConseillerClienteleService est associ�e � la classe m�tier ConseillerClientele.
 * Elle permet d'effectuer les op�rations sp�cifiques � un conseiller client�le de ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class ConseillerClienteleService implements IConseillerClienteleService {

	/**
	 * Lien vers la couche Dao
	 */
	private IDao idao = new Dao();
	
	/**
	 * M�thode permettant de lister les clients affect�s � un conseiller clientele
	 * @param conseiller : le conseiller client�le
	 * @return la collection de clients du conseiller
	 */
	@Override
	public Collection<Client> listerClient(ConseillerClientele conseiller) {
		return idao.listerClientsConseiller(conseiller);
	}

	/**
	 * M�thode permettant d'ajouter un client
	 * @param conseiller : le conseiller client�le
	 * @param client : le client � ajouter
	 * @throws NombreMaxClientsParConseillerException 
	 */
	@Override
	public void ajouterClient(ConseillerClientele conseiller, Client client) throws NombreMaxClientsParConseillerException {
		// TODO partie service
		if (conseiller.getMesClients().size() < 10) {
			// Ajout du client � la collection de clients du conseiller client�le
			conseiller.getMesClients().add(client);

			// Ajout du client � la collection de clients de l'agence
			conseiller.getMonAgence().getClientsAgence().add(client);
		} else throw new NombreMaxClientsParConseillerException("VOUS GEREZ DEJA 10 CLIENTS : NOMBRE MAXIMUM DE CLIENTS QUE VOUS POUVEZ GERER ATTEINT");
		
		// TODO partie DAO
	}

	/**
	 * M�thode permettant de modifier un client
	 * @param conseiller : le conseiller client�le
	 * @param idClient : l'identifiant du client � modifier
	 * @param civiliteClient : la civilit� du client � modifier
	 * @param nomClient : le nom du client � modifier
	 * @param prenomClient : le pr�nom du client � modifier
	 * @param adresseClient : l'adresse du client � modifier
	 * @param telephoneClient : le num�ro de t�l�phone du client � modifier
	 * @param emailClient : l'adresse email du client � modifier
	 * @param nomEntreprise : le nom de l'entreprise du client � modifier
	 */
	@Override
	public void modifierClient(ConseillerClientele conseiller, int idClient, String civiliteClient, String nomClient,
			String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient,
			String nomEntreprise) {
		// TODO partie service
		
		// partie DAO
		idao.modifierClient(conseiller, idClient, civiliteClient, nomClient, prenomClient, adresseClient, telephoneClient, emailClient, nomEntreprise);
	}

	/**
	 * M�thode permettant de rechercher un client � partir de son identifiant
	 * @param id : l'identifiant � partir duquel on veut rechercher un client
	 * @return le client trouv� � partir de l'identifiant
	 */
	@Override
	public Client chercherClient(int id) {
		return idao.chercherClient(id);
	}

	/**
	 * M�thode permettant de rechercher un client � partir d'un mot cl�
	 * @param mc : le mot cl� � partir duquel on veut rechercher un client
	 * @return le client trouv� � partir du mot cl�
	 */
	@Override
	public Collection<Client> chercherParMC(String mc) {
		return idao.chercherClientParMC(mc);
	}

	/**
	 * M�thode permettant de supprimer un client et les comptes et cartes bancaires associ�es
	 * @param conseiller : le conseiller client�le
	 * @param client : le client � supprimer 
	 */
	@Override
	public void supprimerClient(ConseillerClientele conseiller, Client client) {
		// TODO partie service
		
		// Suppression des cartes du client
		client.getCompteCourant().setCarteCompte(null);
		client.getCompteEpargne().setCarteCompte(null);
		// Suppression des comptes du client
		client.setCompteCourant(null);
		client.setCompteEpargne(null);
		// Suppression du client de la collection de clients du conseiller client�le
		for (Client c : conseiller.getMesClients()) {
			if (client.equals(c)) {
				c=null;
			}
		}
		// Suppression du client de la collection de clients de l'agence
		for (Client c : conseiller.getMonAgence().getClientsAgence()) {
			if (client.equals(c)) {
				c=null;
			}
		}
		
		// TODO partie DAO
	}

	/**
	 * M�thode permettant de faire un virement entre deux comptes bancaires
	 * @param compteADebiter : le compte � d�biter
	 * @param compteACrediter : le compte � cr�diter
	 * @param montant : le montant du virement
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	@Override
	public void effectuerVirement(Compte compteADebiter, Compte compteACrediter, double montant)
			throws SoldeInsuffisantException, MontantNegatifException {
		if (compteADebiter.getClass().isInstance(new CompteCourant())) { 		// si le compte � d�biter est un CompteCourant
			CompteService compteCourantService = new CompteCourantService();
			compteCourantService.debiter(compteADebiter, montant);				// d�biter le CompteCourant
		} else {																// sinon, le compte courant � d�biter est un CompteEpargne
			CompteService compteEpargneService = new CompteEpargneService();
			compteEpargneService.debiter(compteADebiter, montant);				// d�biter le CompteEpargne
		}

		if (compteACrediter.getClass().isInstance(new CompteCourant())) { 		// si le compte � cr�diter est un CompteCourant
			CompteService compteCourantService = new CompteCourantService();
			compteCourantService.crediter(compteACrediter, montant);			// cr�diter le CompteCourant
		} else {																// sinon, le compte courant � cr�diter est un CompteEpargne
			CompteService compteEpargneService = new CompteEpargneService();
			compteEpargneService.crediter(compteACrediter, montant);			// cr�diter le CompteEpargne
		}
	}

	/**
	 * Methode permettant de faire un placement
	 * @param client : le client
	 * @param placement : le placement
	 * @param montant : le montant du placement
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 * @throws ClientNonFortuneException
	 */
	@Override
	public void effectuerPlacementBourse(Client client, Compte compte, PlacementBourse placement, double montant)
			throws ClientNonFortuneException, SoldeInsuffisantException, MontantNegatifException {
		ClientService cs = new ClientService();
		if (cs.isFortune(client)) {
			if (montant >= 0){
				if (client.getCompteEpargne().getSoldeCompte() >= montant){
					cs.effectuerPlacementBourse(client, placement, montant);
				} else throw new SoldeInsuffisantException("SOLDE INSUFFISANT SUR COMPTE EPARGNE");
			} else throw new MontantNegatifException("MONTANT NEGATIF");
		} else throw new ClientNonFortuneException("IMPOSSIBLE DE PROPOSER UN PLACEMENT A CE CLIENT - PATRIMOINE INSUFFISANT");
	}

	/**
	 * M�thode permettant de simuler un cr�dit consommation ou un cr�dit immobilier
	 * retourne une estimation du co�t total d'un cr�dit
	 * @param c : le cr�dit consommation ou immobilier
	 * @return le co�t du cr�dit + le montant des mensualit�s
	 */
	@Override
	public double[] simulerCredit(Credit c) throws MontantNegatifException {
		double[] t = {0,0};

		if (c.getMontant() >= 0){
			t[0] = ((c.getMontant()*c.getTaux())/100);		// co�t du cr�dit
			t[1] = ((c.getMontant()+t[0])/c.getDuree());	// montant d'une mensualit�
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return t;
	}

}
