package metier;

/**
 * La classe ClientEntreprise permet de définir un client de type entreprise
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class ClientEntreprise extends Client {

	/**
	 * Constructeur de la classe ClientEntreprise
	 */
	public ClientEntreprise() {
		super();
	}
	
	/**
	 * Constructeur de la classe ClientEntreprise
	 * @param idClient : l'identifiant du client
	 * @param civilite : la civilité du client
	 * @param nomClient : le nom du client
	 * @param prenomClient : le prénom du client
	 * @param adresseClient : l'adrese du client
	 * @param telephoneClient : le telephone du client
	 * @param emailClient : l'adresse email du client
	 * @param nomEntreprise : le nom de l'entreprise du client
	 */
	public ClientEntreprise(int idClient, String civilite, String nomClient, String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient, String nomEntreprise) {
		super(idClient, civilite, nomClient, prenomClient, adresseClient, telephoneClient, emailClient, nomEntreprise);
		this.setIsEntreprise(true);
	}

}
