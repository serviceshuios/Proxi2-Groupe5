package service.exceptions;

/** 
 * La classe TailleIdentifiantAgenceException permet de gérer les erreurs de taille
 * de l'identifiant d'une agence bancaire ProxiBanque
 * @author BERNY OTHMANE
 * @version 1.0
 */
public class TailleIdentifiantAgenceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public TailleIdentifiantAgenceException(String message) {
		/**
		 * Appel du constructeur de la classe Exception à qui on passe le message d'erreur
		 */
		super(message);
	}
	
}