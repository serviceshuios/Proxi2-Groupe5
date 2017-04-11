package service;

import metier.Client;

/**
 * Interface spécifique aux clients fortunés
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public interface IClientFortuneService extends IClientService {
	
	/**
	 * Méthode qui permet de tester le statut d'un client en fonction de son patrimoine
	 * @param client : le client à tester
	 * @return true si le client est considéré comme fortuné, false sinon
	 */
	public boolean isFortune(Client client);
	
}
