package metier;

import java.util.Date;

/**
 * La classe CarteVisaPremier permet de définir les cartes visa premier.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class CarteVisaPremier extends CarteBancaire {

	/** Constructeur de la classe CarteVisaPremier avec arguments
	 * @param numeroCarte numéro de la carte
	 * @param dateExpiration date d'expiration de la carte
	 * @param codeSecurite code de sécurité de la carte
	 */
	public CarteVisaPremier(int numeroCarte, Date dateExpiration, String codeSecurite) {
		super(numeroCarte, dateExpiration, codeSecurite);
	}

}
