package metier;

import java.util.Comparator;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe Agence servant à définir une agence bancaire
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class Agence {
	
	/**
	 * L'identifiant de l'agence.
	 */
	private String idAgence;
	
	/**
	 * L'adresse de l'agence
	 */
	//private Adresse adresseAgence;
	
	/**
	 * La date de création de l'agence.
	 */
	private Date dateCreationAgence;

	/**
	 * Le gérant de l'agence
	 */
	private Gerant gerantAgence;
	
	/**
	 * Les clients de l'Agence
	 */
	private SortedSet<Client> clientsAgence;
	
	/**
	 * Les conseillers clientèle de l'Agence
	 */
	private SortedSet<ConseillerClientele> conseillersClienteleAgence;

	/**
	 * Constructeur de la classe Agence sans argument
	 */
	public Agence() {
		// Initialisation de la collection de conseillers clientèle de l'agence
		this.conseillersClienteleAgence = new TreeSet<ConseillerClientele>(
				new Comparator<ConseillerClientele>() {
					
					@Override
					public int compare(ConseillerClientele cc1, ConseillerClientele cc2) {	// tri des conseillers clientèle selon l'ordre alphabétique 
						if (cc1.getNom().equals(cc2.getNom())) {								// si les 2 noms sont égaux
							return cc1.getPrenom().compareTo(cc2.getPrenom());				// comparer les prénoms
						} else {															// sinon
							return cc1.getNom().compareTo(cc2.getNom());						// comparer les noms
							
						}
					}
			}
		);
		
		// Initialisation de la collection de clients de l'agence
		this.clientsAgence = new TreeSet<Client>(
				new Comparator<Client>() {
					
					@Override
					public int compare(Client c1, Client c2) {					// tri des clients selon l'ordre alphabétique 
						if (c1.getNom().equals(c2.getNom())) {					// si les 2 noms sont égaux
							return c1.getPrenom().compareTo(c2.getPrenom());	// comparer les prénoms
						} else {												// sinon
							return c1.getNom().compareTo(c2.getNom());			// comparer les noms
							
						}
					}
			}
		);
	}

	/**
	 * Constructeur de la classe Agence
	 * @param idAgence : l'identifiant de l'agence
	 * @param dateCreationAgence : la date de création de l'agence
	 */
	public Agence(String idAgence, Date dateCreationAgence) {
		this();
		this.idAgence = idAgence;
		this.dateCreationAgence = dateCreationAgence;
	}

	/**
	 * Getter de l'attribut de classe idAgence
	 * @return l'identifiant de l'agence bancaire
	 */
	public String getIdAgence() {
		return idAgence;
	}

	/**
	 * Setter de l'attribut de classe idAgence
	 * @param idAgence : l'identifiant de l'agence bancaire
	 */
	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	/**
	 * Getter de l'attribut de classe dateCreationAgence
	 * @return la date de création de l'agence bancaire
	 */
	public Date getDateCreationAgence() {
		return dateCreationAgence;
	}

	/**
	 * Setter de l'attribut de classe dateCreationAgence
	 * @param dateCreationAgence : la date de création de l'agence bancaire
	 */
	public void setDateCreationAgence(Date dateCreationAgence) {
		this.dateCreationAgence = dateCreationAgence;
	}

	/**
	 * Getter de l'attribut de classe gerantAgence
	 * @return le gérant de l'agence bancaire
	 */
	public Gerant getGerantAgence() {
		return gerantAgence;
	}

	/**
	 * Setter de l'attribut de classe gerantAgence
	 * @param gerantAgence : le gérant de l'agence bancaire
	 */
	public void setGerantAgence(Gerant gerantAgence) {
		this.gerantAgence = gerantAgence;
	}

	/**
	 * Getter de l'attribut de classe clientsAgence
	 * @return les clients de l'agence bancaire
	 */
	public SortedSet<Client> getClientsAgence() {
		return clientsAgence;
	}

	/**
	 * Setter de l'attribut de classe clientsAgence
	 * @param clientsAgence : les clients de l'agence bancaire
	 */
	public void setClientsAgence(SortedSet<Client> clientsAgence) {
		this.clientsAgence = clientsAgence;
	}

	/**
	 * Getter de l'attribut de classe conseillersClientsAgence
	 * @return les conseillers clients de l'agence
	 */
	public SortedSet<ConseillerClientele> getConseillersClienteleAgence() {
		return conseillersClienteleAgence;
	}

	/**
	 * Getter de l'attribut de classe conseillersClientsAgence
	 * @param conseillersClienteleAgence : les conseillers clients de l'agence
	 */
	public void setConseillersClienteleAgence(SortedSet<ConseillerClientele> conseillersClienteleAgence) {
		this.conseillersClienteleAgence = conseillersClienteleAgence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agence [idAgence = " + idAgence + ", DateCreationAgence = " + dateCreationAgence + "]";
	}
	
}
