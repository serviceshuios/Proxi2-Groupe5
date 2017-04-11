package metier;

/**
 * La classe ClientParticulier permet de définir un client particulier
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class ClientParticulier extends Client {

	/**
	 * Constructeur de la classe ClientParticulier
	 */
	public ClientParticulier() {
		super();
	}
	
	/**
	 * Constructeur de la classe ClientParticulier
	 * @param idClient : l'identifiant du client
	 * @param civilite : la civilité du client
	 * @param nomClient : le nom du client
	 * @param prenomClient : le prénom du client
	 * @param adresseClient : l'adrese du client
	 * @param telephoneClient : le telephone du client
	 * @param emailClient : l'adresse email du client
	 */
	public ClientParticulier(int idClient, String civilite, String nomClient, String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient) {
		super(idClient, civilite, nomClient, prenomClient, adresseClient, telephoneClient, emailClient);
	}
	
}
