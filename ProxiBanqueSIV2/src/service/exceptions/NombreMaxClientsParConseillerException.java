package service.exceptions;

/** 
 * La classe NombreMaxClientsParConseillerException permet de gérer le cas où
 * un conseiller clientèle tente d'ajouter un client alors qu'il en gère déjà 10
 * Cette limite est une demande de ProxiBanque 
 * @author BERNY OTHMANE
 * @version 1.0
 */
public class NombreMaxClientsParConseillerException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public NombreMaxClientsParConseillerException(String message) {
		/**
		 * Appel du constructeur de la classe Exception à qui on passe le message d'erreur
		 */
		super(message);
	}
	
}