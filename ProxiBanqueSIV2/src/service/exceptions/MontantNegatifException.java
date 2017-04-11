package service.exceptions;

/** 
 * La classe MontantNegatifException permet de gérer les erreurs liées à la saisie d'un montant négatif
 * (par exemple lors d'un retrait sur un compte bancaire)
 * @author BERNY OTHMANE
 * @version 1.0
 */
public class MontantNegatifException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public MontantNegatifException(String message) {
		/**
		 * Appel du constructeur de la classe Exception à qui on passe le message d'erreur
		 */
		super(message);
	}
	
}