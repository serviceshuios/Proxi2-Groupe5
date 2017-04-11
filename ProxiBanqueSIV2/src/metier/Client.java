package metier;

import java.util.Collection;

/**
 * Classe Client permettant de définir les clients 
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public abstract class Client extends Personne {
	
	/**
	 * L'identifiant du client.
	 */
	private int idClient;
	
	/**
	 * Le statut du client (client particulier ou client entreprise)
	 */
	private boolean isEntreprise = false;
	
	/**
	 * Le nom de l'entreprise (le cas échéant)
	 */
	private String nomEntreprise;
	
//	/**
//	 * Les comptes du client.
//	 */
//	private Collection<Compte> mesComptes;
	
	/**
	 * Le compte courant du client
	 */
	private CompteCourant compteCourant;
	
	/**
	 * Le compte épargne du client
	 */
	private CompteEpargne compteEpargne;
	
	/**
	 * Les cartes du client.
	 */
	private Collection<CarteBancaire> mesCartes;
	
	/**
	 * Les placements du client
	 */
	//private List<Placement> listePlacement;
	
	/**
	 * Constructeur de la classe Client
	 */
	public Client() {
		super();
		this.compteCourant = new CompteCourant();
		this.compteEpargne = new CompteEpargne();
		//this.compteCourant = null;
		//this.compteEpargne = null;
		//this.listePlacement = new ArrayList<Placement>();
	}
	
	/** Constructeur de la classe Client avec arguments
	 * @param idClient : l'identifiant du client
	 * @param civilite : la civilité du client
	 * @param nomClient : le nom du client
	 * @param prenomClient : le prenom du client
	 * @param adresseClient : l'adresse du client
	 * @param telephoneClient : le telephone du client
	 * @param emailClient : l'adresse email du client
	 */
	public Client(int idClient, String civilite, String nomClient, String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient) {
		super(civilite, nomClient, prenomClient, adresseClient, telephoneClient, emailClient);
		this.idClient = idClient;
		this.compteCourant = new CompteCourant();
		this.compteEpargne = new CompteEpargne();
		//this.compteCourant = null;
		//this.compteEpargne = null;
		//this.listePlacement = new ArrayList<Placement>();
	}
	
	/** Constructeur de la classe Client avec arguments
	 * @param idClient : l'identifiant du client
	 * @param civilite : la civilité du client
	 * @param nomClient : le nom du client
	 * @param prenomClient : le prenom du client
	 * @param adresseClient : l'adresse du client
	 * @param telephoneClient : le telephone du client
	 * @param emailClient : l'adresse email du client
	 * @param nomEntreprise : le nom de l'entreprise du client
	 */
	public Client(int idClient, String civilite, String nomClient, String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient, String nomEntreprise) {
		super(civilite, nomClient, prenomClient, adresseClient, telephoneClient, emailClient);
		this.idClient = idClient;
		this.isEntreprise = true;
		this.nomEntreprise = nomEntreprise;
		this.compteCourant = new CompteCourant();
		this.compteEpargne = new CompteEpargne();
		//this.compteCourant = null;
		//this.compteEpargne = null;
		//this.listePlacement = new ArrayList<Placement>();
	}
	
	/**
	 * Getter de l'attribut idClient
	 * @return l'identifiant du client
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * Setter de l'attribut idClient
	 * @param idClient : l'identifiant du client
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * Getter de l'attribut isEntreprise
	 * @return true si le client est une entreprise, false sinon
	 */
	public boolean isEntreprise() {
		return isEntreprise;
	}

	/**
	 * Setter de l'attribut isEntreprise
	 * @param isEntreprise : true si le client est une entreprise, false sinon
	 */
	public void setIsEntreprise(boolean isEntreprise) {
		this.isEntreprise = isEntreprise;
	}

	/**
	 * Getter de l'attribut nomEntreprise
	 * @return le nom de l'entreprise
	 */
	public String getNomEntreprise() {
		return nomEntreprise;
	}

	/**
	 * Setter de l'attribut nomEntreprise
	 * @param nomEntreprise : le nom de l'entreprise
	 */
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

//	/** 
//	 * Getter de l'attribut mes Comptes
//	 * @return les comptes du client
//	 */
//	public Collection<Compte> getMesComptes() {
//		return mesComptes;
//	}

//	/**
//	 * Setter de l'attribut mesComptes
//	 * @param mesComptes : les comptes du client
//	 */
//	public void setMesComptes(Collection<Compte> mesComptes) {
//		this.mesComptes = mesComptes;
//	}
	
	/** 
	 * Getter de l'attribut compteCourant
	 * @return le compte courant du client
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * Setter de l'attribut compteCourant
	 * @param compteCourant : le compte courant du client
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	
	/** 
	 * Getter de l'attribut compteEpargne
	 * @return le compte epargne du client
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	/**
	 * Setter de l'attribut compteEpargne
	 * @param compteEpargne : le compte épargne du client
	 */
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	
	/**
	 * Getter de l'attribut mesCartes
	 * @return les cartes du client
	 */
	public Collection<CarteBancaire> getMesCartes() {
		return mesCartes;
	}

	/**
	 * Setter de l'attribut mesCartes
	 * @param mesCartes : les cartes du client
	 */
	public void setMesCartes(Collection<CarteBancaire> mesCartes) {
		this.mesCartes = mesCartes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (isEntreprise) {
			return "Client n° " + idClient + " : " + getCivilite() + " " + getPrenom() + " " + getNom() + " | Entreprise " + nomEntreprise;
		} else {
			return "Client n° " + idClient + " : " + getCivilite() + " " + getPrenom() + " " + getNom();
		}
	}
	
}
