package metier;

import java.util.Date;

/**
 * La classe CompteCourant permet de définir les comptes bancaires courants.
 * @author BERNY OTHMANE
 * @version v1.0
 */
public class CompteCourant extends Compte {
	/**
	 * Le découvert autorisé.
	 */
	private double decouvert;

	/**
	 * Constructeur de la classe CompteCourant
	 */
	public CompteCourant() {
		super();
	}
	
	/**
	 * Constructeur de la classe CompteCourant
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 */
	public CompteCourant(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		super(idCompte, soldeCompte, dateOuvertureCompte);
	}
	
	/**
	 * Constructeur de la classe CompteCourant permettant de paramétrer le découvert autorisé
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 * @param decouvert : le découvert autorisé
	 */
	public CompteCourant(int idCompte, double soldeCompte, Date dateOuvertureCompte, double decouvert) {
		super(idCompte, soldeCompte, dateOuvertureCompte);
		this.decouvert = decouvert;
	}

	/**
	 * Getter de l'attribut decouvert
	 * @return le découvert autorisé du compte
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * Setter de l'attribut decouvert
	 * @param decouvert : le découvert autorisé sur le compte
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
		
}
