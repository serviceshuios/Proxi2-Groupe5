package service;

import java.util.Date;
import metier.Agence;
import metier.Gerant;
import service.exceptions.TailleIdentifiantAgenceException;

/**
 * La classe service AgenceService est associ�e � la classe m�tier Agence.
 * Elle permet d'effectuer des op�rations sp�cifiques sur les agences ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class AgenceService {

	/**
	 * M�thode permettant de cr�er une nouvelle agence bancaire
	 * @param idAgence : l'identifiant de l'agence bancaire
	 * @param dateCreationAgence : la date de creation de l'agence
	 * @return l'agence cr��e
	 * @throws TailleIdentifiantAgenceException taille de l'identifiant de l'agence incorrecte
	 */
	public Agence creerAgence(String idAgence, Date dateCreationAgence) throws TailleIdentifiantAgenceException {
		if (idAgence.length() == 5) {
			return new Agence(idAgence, dateCreationAgence);
		} else throw new TailleIdentifiantAgenceException("IDENTIFIANT AGENCE INCORRECT (5 caract�res alphanum�riques)");
	}
	
	/**
	 * M�thode permettant d'affecter un g�rant � une agence bancaire
	 * @param agence : l'agence bancaire � laquelle on veut associer un g�rant
	 * @param gerant : le g�rant � affecter � une agence bancaire
	 */
	public void affecterGerant(Agence agence, Gerant gerant) {
		agence.setGerantAgence(gerant);
		gerant.setAgence(agence);
	}
	
}
