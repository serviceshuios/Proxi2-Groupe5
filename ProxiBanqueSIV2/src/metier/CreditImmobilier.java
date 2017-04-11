/**
 * 
 */
package metier;

/**
 * La classe CreditImmobilier permet de définir un crédit immobilier.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class CreditImmobilier extends Credit {

	/**
	 * Constructeur de la classe CreditImmobilier avec arguments
	 * @param taux taux du crédit
	 * @param duree durée du crédit
	 * @param montant montant du crédit
	 */
	public CreditImmobilier(float taux, int duree, double montant) {
		super(taux, duree, montant);
	}

}
