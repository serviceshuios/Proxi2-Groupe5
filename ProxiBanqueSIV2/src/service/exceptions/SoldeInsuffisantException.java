package service.exceptions;

/** 
 * La classe SoldeInsuffisantException permet de gérer les erreurs liées aux opérations sur un compte bancaire débiteur
 * @author BERNY OTHMANE
 * @version 1.0
 */
public class SoldeInsuffisantException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public SoldeInsuffisantException(String message) {
		/**
		 * Appel du constructeur de la classe Exception à qui on passe le message d'erreur
		 */
		super(message);
	}
	
}