package service;

import java.util.Collection;
import java.util.Iterator;

import dao.Dao;
import dao.IDao;
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
 * La classe service ConseillerClienteleService est associée à la classe métier ConseillerClientele.
 * Elle permet d'effectuer les opérations spécifiques à un conseiller clientèle de ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class ConseillerClienteleService implements IConseillerClienteleService {

	/**
	 * Lien vers la couche Dao
	 */
	private IDao idao = new Dao();
	
	/**
	 * Méthode permettant à un conseiller clientele de s'authentifier
	 */
	public ConseillerClientele authentifier(String login, String password) {
		return idao.authentifier(login, password);
	}
	
	/**
	 * Méthode permettant de lister les clients affectés à un conseiller clientele
	 * @param conseiller : le conseiller clientèle
	 * @return la collection de clients du conseiller
	 */
	@Override
	public Collection<Client> listerClient(ConseillerClientele conseiller) {
		return idao.listerClientsConseiller(conseiller);
	}

	/**
	 * Méthode permettant d'ajouter un client
	 * @param conseiller : le conseiller clientèle
	 * @param client : le client à ajouter
	 * @throws NombreMaxClientsParConseillerException 
	 */
	@Override
	public void ajouterClient(ConseillerClientele conseiller, Client client) throws NombreMaxClientsParConseillerException {
		if (conseiller.getMesClients().size() < 10) {
			// Ajout du client à la collection de clients du conseiller clientèle
			conseiller.getMesClients().add(client);

			// Ajout du client à la collection de clients de l'agence
			//conseiller.getMonAgence().getClientsAgence().add(client);
		} else throw new NombreMaxClientsParConseillerException("VOUS GEREZ DEJA 10 CLIENTS : NOMBRE MAXIMUM DE CLIENTS QUE VOUS POUVEZ GERER ATTEINT");
		
		// Ajout du client en base de donnée
		idao.ajouterClient(client);
	}

	/**
	 * Méthode permettant de modifier un client
	 * @param idt : l'identifiant du client à modifier
	 * @param civilite : la civilité du client à modifier
	 * @param nom : le nom du client à modifier
	 * @param prenom : le prénom du client à modifier
	 * @param rue : la rue du client à modifier
	 * @param codePostal : le code postal du client à modifier
	 * @param ville : la ville du client à modifier
	 * @param telephone : le numéro de téléphone du client à modifier
	 * @param email : l'adresse email du client à modifier
	 * @param nomEntreprise : le nom de l'entreprise du client à modifier
	 */
	@Override
	public void modifierClient(ConseillerClientele conseiller, Client client //int id, String civilite, String nom,
		//	String prenom, String rue, String codePostal, String ville, String telephone, String email,
			//String nomEntreprise
			) {
		// TODO partie service
		Collection<Client> collectionClientsConseiller = conseiller.getMesClients();
		
		Iterator<Client> it=collectionClientsConseiller.iterator();
		while (it.hasNext()) {
			Client c = (Client) it.next();
			if (c.getIdClient() == client.getIdClient()) {
				collectionClientsConseiller.remove(c);
			}
		}
		collectionClientsConseiller.add(client);
		
		// Ajout du client en base de donnée
		idao.modifierClient(client);
	}

	/**
	 * Méthode permettant de rechercher un client à partir de son identifiant
	 * @param id : l'identifiant à partir duquel on veut rechercher un client
	 * @return le client trouvé à partir de l'identifiant
	 */
	@Override
	public Client chercherClient(int id) {
		return idao.chercherClient(id);
	}

	/**
	 * Méthode permettant de rechercher un client à partir d'un mot clé
	 * @param mc : le mot clé à partir duquel on veut rechercher un client
	 * @return le client trouvé à partir du mot clé
	 */
	@Override
	public Collection<Client> chercherParMC(String mc) {
		return idao.chercherClientParMC(mc);
	}

	/**
	 * Méthode permettant de supprimer un client et les comptes et cartes bancaires associées
	 * @param conseiller : le conseiller clientèle
	 * @param client : le client à supprimer 
	 */
	@Override
	public void supprimerClient(ConseillerClientele conseiller, Client client) {
		// Suppression du compte courant du client et de sa carte associée
		if (client.getCompteCourant() != null) {
			if (client.getCompteCourant().getCarteCompte() != null) {
				client.getCompteCourant().setCarteCompte(null);
			}
			client.setCompteCourant(null);
		}
		
		// Suppression du compte epargne du client et de sa carte associée
		if (client.getCompteEpargne() != null) {
			if (client.getCompteEpargne().getCarteCompte() != null) {
				client.getCompteEpargne().setCarteCompte(null);
			}
			client.setCompteEpargne(null);
		}
		
		// Suppression du client de la collection de clients du conseiller clientèle
		Collection<Client> collectionClientsConseiller = conseiller.getMesClients();
		collectionClientsConseiller.remove(client);
		conseiller.setMesClients(collectionClientsConseiller);
		
		// Suppression du client de la collection de clients de l'agence
	//	Agence agence = conseiller.getMonAgence();
	//	Collection<Client> collectionClientsAgence = agence.getClientsAgence();
	//	collectionClientsAgence.remove(client);
	//	agence.setClientsAgence(collectionClientsConseiller);
		
		// Suppression du client en base de donnée
		idao.supprimerClient(client.getIdClient());
	}
	

	/**
	 * Méthode permettant de faire un virement entre deux comptes bancaires
	 * @param compteADebiter : le compte à débiter
	 * @param compteACrediter : le compte à créditer
	 * @param montant : le montant du virement
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	@Override
	public void effectuerVirement(Compte compteADebiter, Compte compteACrediter, double montant)
			throws SoldeInsuffisantException, MontantNegatifException {
		if (compteADebiter.getClass().isInstance(new CompteCourant())) { 		// si le compte à débiter est un CompteCourant
			CompteService compteCourantService = new CompteCourantService();
			compteCourantService.debiter(compteADebiter, montant);				// débiter le CompteCourant
		} else {																// sinon, le compte courant à débiter est un CompteEpargne
			CompteService compteEpargneService = new CompteEpargneService();
			compteEpargneService.debiter(compteADebiter, montant);				// débiter le CompteEpargne
		}

		if (compteACrediter.getClass().isInstance(new CompteCourant())) { 		// si le compte à créditer est un CompteCourant
			CompteService compteCourantService = new CompteCourantService();
			compteCourantService.crediter(compteACrediter, montant);			// créditer le CompteCourant
		} else {																// sinon, le compte courant à créditer est un CompteEpargne
			CompteService compteEpargneService = new CompteEpargneService();
			compteEpargneService.crediter(compteACrediter, montant);			// créditer le CompteEpargne
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
	 * Méthode permettant de simuler un crédit consommation ou un crédit immobilier
	 * retourne une estimation du coût total d'un crédit
	 * @param c : le crédit consommation ou immobilier
	 * @return le coût du crédit + le montant des mensualités
	 */
	@Override
	public double[] simulerCredit(Credit c) throws MontantNegatifException {
		double[] t = {0,0};

		if (c.getMontant() >= 0){
			t[0] = ((c.getMontant()*c.getTaux())/100);		// coût du crédit
			t[1] = ((c.getMontant()+t[0])/c.getDuree());	// montant d'une mensualité
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return t;
	}

}
