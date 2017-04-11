package metier;

import java.util.Date;

/**
 * La classe CarteBancaire permet de définir une carte bancaire
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public abstract class CarteBancaire {
	
	/**
	 * Le numéro de la carte.
	 */
	private int numeroCarte;
	
	/**
	 * La date d'expiration de la carte.
	 */
	private Date dateExpiration;
	
	/**
	 * Le code de sécurité de la carte.
	 */
	private String codeSecurite;
	
	/**
	 * Le nom du propriétaire de la carte.
	 */
	private String nomCarte;
	
	/**
	 * Le prénom du propriétaire de la carte.
	 */
	private String prenomCarte;

	/** Constructeur de la classe Carte avec arguments
	 * @param numeroCarte numéro de la carte
	 * @param dateExpiration date d'expiration de la carte
	 * @param codeSecurite code de sécurité de la carte
	 */
	public CarteBancaire(int numeroCarte, Date dateExpiration, String codeSecurite) {
		super();
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
		this.codeSecurite = codeSecurite;
	}

	/**
	 * Getter de l'attribut numeroCarte
	 * @return numeroCarte : le numéro de carte
	 */
	public int getNumeroCarte() {
		return numeroCarte;
	}

	/**
	 * Setter de l'attribut numeroCarte
	 * @param numeroCarte : le numéro de carte
	 */
	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	/**
	 * Getter de l'attribut dateExpiration
	 * @return la date d'expiration
	 */
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * Setter de l'attribut dateExpiration
	 * @param dateExpiration : la date d'expiration
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * Getter de l'attribut codeSecurite
	 * @return le code de sécurité
	 */
	public String getCodeSecurite() {
		return codeSecurite;
	}

	/**
	 * Setter de l'attribut codeSecurite
	 * @param codeSecurite : le code de sécurité
	 */
	public void setCodeSecurite(String codeSecurite) {
		this.codeSecurite = codeSecurite;
	}

	/**
	 * Getter de l'attribut nomCarte
	 * @return le nom du propriétaire de la carte
	 */
	public String getNomCarte() {
		return nomCarte;
	}

	/**
	 * Setter de l'attribut nomCarte
	 * @param nomCarte : le pnom du propriétaire de la carte
	 */
	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}

	/**
	 * Getter de l'attribut prenomCarte
	 * @return le prénom du propriétaire de la carte
	 */
	public String getPrenomCarte() {
		return prenomCarte;
	}

	/**
	 * Setter de l'attribut prenomCarte
	 * @param prenomCarte le prénom du propriétaire de la carte
	 */
	public void setPrenomCarte(String prenomCarte) {
		this.prenomCarte = prenomCarte;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarteBancaire [numeroCarte=" + numeroCarte + ", dateExpiration=" + dateExpiration + ", codeSecurite="
				+ codeSecurite + ", nomCarte=" + nomCarte + ", prenomCarte=" + prenomCarte + "]";
	}

}
