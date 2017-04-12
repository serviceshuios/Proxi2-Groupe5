package metier;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe ConseillerClientele servant à définir les conseillers clientèle des agences bancaires
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class ConseillerClientele extends Personne {

	/**
	 * L'identifiant du conseiller
	 */
	private int idConseiller;
	
	/**
	 * Le password d'authentification du conseiller
	 */
	private String password;
	
	/**
	 * L'agence à laquelle est affectée le conseiller
	 */
	private Agence monAgence;
	
	/**
	 * Le gérant responsable du conseiller clientèle
	 */
	private Gerant monGerant;
	
	/**
	 * Les clients affectés à un conseiller clientèle
	 */
	private SortedSet<Client> mesClients;
	
	/**
	 * Constructeur de la classe ConseillerClientele avec arguments
	 * @param idConseiller : l'identifiant du conseiller clientèle
	 * @param civiliteConseiller : la civilité du conseiller clientèle
	 * @param nomConseiller : le nom du conseiller clientèle
	 * @param prenomConseiller : le prenom du conseiller clientèle
	 */
	public ConseillerClientele(int idConseiller, String civiliteConseiller, String nomConseiller, String prenomConseiller) {
		super(civiliteConseiller, nomConseiller, prenomConseiller);
		this.idConseiller = idConseiller;
		
		// Initialisation de la collection de clients du conseillers clientèle
		this.mesClients = new TreeSet<Client>(
				new Comparator<Client>() {
					
					@Override
					//public int compare(Client c1, Client c2) {				// tri des clients selon l'ordre alphabétique 
					//	if (c1.getNom().equals(c2.getNom())) {					// si les 2 noms sont égaux
					//		return c1.getPrenom().compareTo(c2.getPrenom());	// comparer les prénoms
					//	} else {												// sinon
					//		return c1.getNom().compareTo(c2.getNom());			// comparer les noms
					//		
					//	}
					//}
					
					public int compare(Client c1, Client c2) {					// tri des clients selon l'identifiant 
						return ((Integer)c1.getIdClient()).compareTo(c2.getIdClient());
					}
			}
		);
	}

	/**
	 * Getter de l'attribut de classe idConseiller
	 * @return l'identifiant du conseiller
	 */
	public int getIdConseiller() {
		return this.idConseiller;
	}

	/**
	 * Setter de l'attribut de classe idConseiller
	 * @param idConseiller : l'identifiant du conseiller
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	/**
	 * Getter de l'attribut de classe password
	 * @return le mot de passe du conseiller
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter de l'attribut de classe password
	 * @param password : le mot de passe du conseiller
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter de l'attribut de classe monAgence
	 * @return l'agence à laquelle est affecté le conseiller clientèle
	 */
	public Agence getMonAgence() {
		return this.monAgence;
	}

	/**
	 * Setter de l'attribut de classe monAgence
	 * @param monAgence : l'agence à laquelle est affecté le conseiller clientèle
	 */
	public void setMonAgence(Agence monAgence) {
		this.monAgence = monAgence;
	}
	
	/**
	 * Getter de l'attribut de classe monGerant
	 * @return le gérant responsable du conseiller clientèle
	 */
	public Gerant getMonGerant() {
		return this.monGerant;
	}

	/**
	 * Setter de l'attribut de classe monGerant
	 * @param monGerant : le gérant responsable du conseiller clientèle
	 */
	public void setMonGerant(Gerant monGerant) {
		this.monGerant = monGerant;
	}

	/**
	 * Getter de l'attribut de classe mesClients
	 * @return les clients gérés par le conseiller clientèle
	 */
	public SortedSet<Client> getMesClients() {
		return mesClients;
	}

	/**
	 * Setter de l'attribut de classe mesClients
	 * @param mesClients : les clients gérés par le conseiller clientèle
	 */
	public void setMesClients(SortedSet<Client> mesClients) {
		this.mesClients = mesClients;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conseiller Clientèle n° " + idConseiller + " : " + getCivilite() + " " + getPrenom() + " " + getNom();
	}
	
}
