package metier;

import java.util.Date;

/**
 * La classe Compte permet de définir les comptes bancaires.
 * Classe abstraite n'ayant pas d'existence logique .
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public abstract class Compte {
	/**
	 * Attribut static commun à toutes les instances de Compte
	 * permettant de comptabiliser le nombre de compte bancaires.
	 */
	private static int nbComptes;
	
	/**
	 * L'identifiant du compte.
	 */
	private int idCompte=0;
	
	/**
	 * Le solde du compte
	 */
	private double soldeCompte;
	
	/**
	 * La date d'ouverture du compte
	 */
	private Date dateOuvertureCompte;
	
	/**
	 * Le statut du compte (compte particulier ou compte entreprise)
	 */
	private boolean isCompteEntreprise = false;
	
	/**
	 * Le Client propriétaire du compte
	 */
	private Client clientProprietaire;
	
	/**
	 * La carte associée au compte
	 */
	private CarteBancaire carteCompte;
	
	/**
	 * Constructeur de la classe Compte sans argument
	 */
	public Compte() {
		super();
		// incrémentation du nombre de comptes
		setNbComptes(getNbComptes() + 1);
	}

	/**
	 * Constructeur de la classe Compte avec arguments
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 */
	public Compte(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		super();
		this.idCompte = idCompte;
		this.soldeCompte = soldeCompte;
		this.dateOuvertureCompte = dateOuvertureCompte;
		// incrémentation du nombre de comptes
		setNbComptes(getNbComptes() + 1);
	}
	
	/**
	 * Getter de l'attribut static nbComptes
	 * @return le nombre de comptes
	 */
	public static int getNbComptes() {
		return nbComptes;
	}

	/**
	 * Setter de l'attribut static nbComptes
	 * @param nbComptes : le nombre de comptes
	 */
	public static void setNbComptes(int nbComptes) {
		Compte.nbComptes = nbComptes;
	}

	/**
	 * Getter de l'attribut de classe idCompte
	 * @return l'identifiant du compte
	 */
	public int getIdCompte() {
		return idCompte;
	}

	/**
	 * Setter de l'attribut de classe idCompte
	 * @param idCompte : l'identifiant du compte
	 */
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * Getter de l'attribut de classe soldeCompte
	 * @return le solde du compte
	 */
	public double getSoldeCompte() {
		return soldeCompte;
	}

	/**
	 * Setter de l'attribut de classe soldeCompte
	 * @param soldeCompte : le solde du compte
	 */
	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	/**
	 * Getter de l'attribut de classe dateOuvertureCompte
	 * @return la date d'ouverture du compte
	 */
	public Date getDateOuvertureCompte() {
		return dateOuvertureCompte;
	}

	/**
	 * Setter de l'attribut de classe dateOuvertureCompte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 */
	public void setDateOuvertureCompte(Date dateOuvertureCompte) {
		this.dateOuvertureCompte = dateOuvertureCompte;
	}

	/**
	 * Getter de l'attribut isEntreprise
	 * @return true si le compte est un compte entreprise, false sinon
	 */
	public boolean isCompteEntreprise() {
		return isCompteEntreprise;
	}
	
	/**
	 * Setter de l'attribut isEntreprise
	 * @param isEntreprise : true si le client est une entreprise, false sinon
	 */
	public void setCompteEntreprise(boolean isCompteEntreprise) {
		this.isCompteEntreprise = isCompteEntreprise;
	}
	
	/**
	 * Getter de l'attribut de classe clientProprietaire
	 * @return le Client propriétaire du compte
	 */
	public Client getClientProprietaire() {
		return clientProprietaire;
	}

	/**
	 * Getter de l'attribut de classe clientProprietaire
	 * @param clientProprietaire : le Client propriétaire du compte
	 */
	public void setClientProprietaire(Client clientProprietaire) {
		this.clientProprietaire = clientProprietaire;
	}
	
	/**
	 * Getter de l'attribut carteCompte
	 * @return la carte du compte
	 */
	public CarteBancaire getCarteCompte() {
		return carteCompte;
	}

	/**
	 * Setter de l'attribut carteCompte
	 * @param carteCompte : la carte du compte
	 */
	public void setCarteCompte(CarteBancaire carteCompte) {
		this.carteCompte = carteCompte;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte n° " + idCompte + " : Solde = " + soldeCompte + ", dateOuvertureCompte="
				+ dateOuvertureCompte;
	}
	
}
