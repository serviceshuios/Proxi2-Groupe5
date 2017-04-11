package metier;

/**
 * La classe Gerant permet de définir un gérant
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class Gerant extends Personne {
	
	/**
	 * L'identifiant du gérant.
	 */
	private int idGerant;
	
	/**
	 * L'agence du gérant.
	 */
	private Agence agence;

	/**
	 * Constructeur de la classe Gerant avec arguments
	 * @param idGerant : l'identification du gérant
	 * @param civiliteGerant : la civilité du gérant
	 * @param nom : le nom du gérant
	 * @param prenom : le prenom du gérant
	 */
	public Gerant(int idGerant, String civiliteGerant, String nomGerant, String prenomGerant) {
		super(civiliteGerant, nomGerant, prenomGerant);
		this.idGerant = idGerant;
	}

	/**
	 * Getter de l'attribut IdGerant
	 * @return l'identifiant du gérant
	 */
	public int getIdGerant() {
		return idGerant;
	}

	/**
	 * Setter de l'attribut IdGerant
	 * @param idGerant : l'identifiant du gérant
	 */
	public void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
	}

	/**
	 * Getter de l'attribut monAgence
	 * @return le nom de l'agence à laquelle est affecté le gérant
	 */
	public Agence getAgence() {
		return this.agence;
	}

	/**
	 * Setter de l'attribut monAgence
	 * @param agence : le nom de l'agence à laquelle est affecté le gérant
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gerant n° " + idGerant + " : " + getCivilite() + " " + getPrenom() + " " + getNom();
	}

}
