package service.exceptions;

/** 
 * La classe ClientNonFortuneException permet de gérer le cas où
 * un conseiller clientèle tente de faire un placement pour un client
 * dont le patrimoine est insuffisant (inférieur ou égal à 500.000 €).
 *  
 * @author BERNY OTHMANE
 * @version 1.0
 */
public class ClientNonFortuneException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public ClientNonFortuneException(String message) {
		/**
		 * Appel du constructeur de la classe Exception à qui on passe le message d'erreur
		 */
		super(message);
	}
	
}