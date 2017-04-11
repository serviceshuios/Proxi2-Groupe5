package metier;

/**
 * La classe Personne permet de définir une personne.
 * Classe abstraite.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public abstract class Personne {
	
	/**
	 * La civilité de la personne (M. Mme. Melle. etc...)
	 */
	private String civilite;
	
	/**
	 * Le nom de la personne.
	 */
	private String nom;
	
	/**
	 * Le prénom de la personne.
	 */
	private String prenom;
	
	/**
	 * L'adresse de la personne
	 */
	private Adresse adresse;
	
	/**
	 * Le numéro de téléphone de la personne.
	 */
	private String telephone;
	
	/**
	 * L'adresse mail de la personne.
	 */
	private String email;

	/**
	 * Constructeur de la classe Personne sans arguments
	 */
	public Personne() {
		super();
	}

	/**
	 * Constructeur de la classe Personne avec arguments
	 * @param civilite civilite de la personne
	 * @param nom nom de la personne
	 * @param prenom prénom de la personne
	 */
	public Personne(String civilite, String nom, String prenom) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * Constructeur de la classe Personne avec arguments
	 * @param civilite civilite de la personne
	 * @param nom nom de la personne
	 * @param prenom prénom de la personne
	 * @param adresse adresse de la personne
	 * @param telephone téléphone de la personne
	 */
	public Personne(String civilite, String nom, String prenom, Adresse adresse, String telephone) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	/**
	 * Constructeur de la classe Personne avec arguments
	 * @param civilite civilite de la personne
	 * @param nom nom de la personne
	 * @param prenom prénom de la personne
	 * @param adresse adresse de la personne
	 * @param telephone téléphone de la personne
	 * @param email email de la personne
	 */
	public Personne(String civilite, String nom, String prenom, Adresse adresse, String telephone, String email) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}
	
	/**
	 * Getter de l'attribut civilité
	 * @return la civilité de la personne
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * Setter de l'attribut civilite
	 * @param nom : la civilité de la personne
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	/**
	 * Getter de l'attribut nom
	 * @return le nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter de l'attribut nom
	 * @param nom : le nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de l'attribut prenom
	 * @return le prenom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter de l'attribut prenom
	 * @param prenom : le prenom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de l'attribut adresse
	 * @return l'adresse de la personne
	 */
	public Adresse getAdresse() {
		return this.adresse;
	}

	/**
	 * Setter de l'attribut adresse
	 * @param adresse : l'adresse de la personne
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Getter de l'attribut telephone
	 * @return le téléphone de la personne
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Setter de l'attribut telephone
	 * @param telephone : le téléphone de la personne
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter de l'attribut email
	 * @return l'adresse email de la personne
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de l'attribut email
	 * @param email : l'adresse email de la personne
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personne [NOM = " + nom + ", PRENOM = " + prenom + ", ADRESSE = " + adresse + ", TELEPHONE = " + telephone + ", EMAIL = " + email + "]";
	}	

}
