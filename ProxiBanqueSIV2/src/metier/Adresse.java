package metier;

/**
 * La classe Adresse permet de définir une adresse.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class Adresse {
		
	/**
	 * Le nom de la rue.
	 */
	private String rue;
	
	/**
	 * Le code postal.
	 */
	private String codePostal;
	
	/**
	 * Le nom de la ville.
	 */
	private String ville;

	/** Constructeur de la classe Adresse avec arguments.
	 * @param rue numero et nom de la rue
	 * @param ville nom de la ville
	 * @param codePostal code postal
	 */
	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * Getter de l'attribut rue
	 * @return la rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter de l'attribut rue
	 * @param rue : la rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Getter de l'attribut codePostal
	 * @return le code postal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter de l'attribut codePostal
	 * @param codePostal : le code postal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter de l'attribut ville
	 * @return la ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter de l'attribut ville
	 * @param ville : la ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

}
