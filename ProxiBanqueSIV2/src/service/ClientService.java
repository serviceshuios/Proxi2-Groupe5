package service;

import metier.Client;
import metier.PlacementBourse;
import service.exceptions.MontantNegatifException;
import service.exceptions.SoldeInsuffisantException;

/**
 * La classe service ClientService est associée à la classe métier Client.
 * Elle permet d'effectuer des opérations spécifiques sur les clients ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class ClientService implements IClientService, IClientFortuneService {
	
	/**
	 * Méthode qui permet de tester si client est fortuné ou non
	 * Chez ProxiBanque, la condition pour être considéré comme un client fortuné
	 * est d'avoir un patrimoine (somme des soldes des comptes d'un client) supérieur à 500000 euros
	 * @param client : le client à tester
	 * @return true si le client est fortuné, false sinon
	 */
	@Override
	public boolean isFortune(Client client) {
		if (client.getCompteCourant().getSoldeCompte() + client.getCompteEpargne().getSoldeCompte() > 500000) {
			return true;
		} else return false;
	}
	
	/**
	 * Méthode permettant d'effectuer un placement boursier
	 * @param client : le client concerné par le placement boursier
	 * @param placement : le placement boursier choisi par le client
	 * @param montant : le montant du placement
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	public void effectuerPlacementBourse (Client client, PlacementBourse placement, double montant) throws SoldeInsuffisantException, MontantNegatifException {
		CompteEpargneService cs = new CompteEpargneService();
		cs.debiter(client.getCompteEpargne(), montant);
		placement.setMontantPlacement(montant);
	}
}
