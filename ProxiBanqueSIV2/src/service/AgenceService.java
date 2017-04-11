package service;

import java.util.Date;
import metier.Agence;
import metier.Gerant;
import service.exceptions.TailleIdentifiantAgenceException;

/**
 * La classe service AgenceService est associée à la classe métier Agence.
 * Elle permet d'effectuer des opérations spécifiques sur les agences ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class AgenceService {

	/**
	 * Méthode permettant de créer une nouvelle agence bancaire
	 * @param idAgence : l'identifiant de l'agence bancaire
	 * @param dateCreationAgence : la date de creation de l'agence
	 * @return l'agence créée
	 * @throws TailleIdentifiantAgenceException taille de l'identifiant de l'agence incorrecte
	 */
	public Agence creerAgence(String idAgence, Date dateCreationAgence) throws TailleIdentifiantAgenceException {
		if (idAgence.length() == 5) {
			return new Agence(idAgence, dateCreationAgence);
		} else throw new TailleIdentifiantAgenceException("IDENTIFIANT AGENCE INCORRECT (5 caractères alphanumériques)");
	}
	
	/**
	 * Méthode permettant d'affecter un gérant à une agence bancaire
	 * @param agence : l'agence bancaire à laquelle on veut associer un gérant
	 * @param gerant : le gérant à affecter à une agence bancaire
	 */
	public void affecterGerant(Agence agence, Gerant gerant) {
		agence.setGerantAgence(gerant);
		gerant.setAgence(agence);
	}
	
}
