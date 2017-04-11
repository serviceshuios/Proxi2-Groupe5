package service;

import metier.Client;
import metier.ClientParticulier;
import metier.ConseillerClientele;
import metier.Gerant;

/**
 * La classe service GerantService est associée à la classe métier Gerant.
 * Elle permet d'effectuer des opérations spécifiques à un gérant ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class GerantService implements IGerantService {
	
//	/**
//	 * Méthode permettant d'affecter un conseiller clientèle à une agence bancaire
//	 * @param agence : l'agence bancaire à laquelle on veut associer un conseiller clientèle
//	 * @param conseillerClientele : le conseiller clientèle à affecter à l'agence bancaire
//	 */
//	public void ajouterConseillerClientele(Agence agence, ConseillerClientele conseillerClientele) {
//		// Ajout du conseiller clientèle à la collection de conseillers clientèles de l'agence
//		agence.getConseillersClienteleAgence().add(conseillerClientele);
//		
//		// Valorisation de l'attribut monAgence du conseiller clientèle
//		conseillerClientele.setMonAgence(agence);
//	}
	
	/**
	 * Méthode permettant d'affecter un conseiller clientèle à l'agence bancaire du gérant
	 * @param gerant : le gérant de l'agence bancaire à laquelle on veut associer un conseiller clientèle
	 * @param conseillerClientele : le conseiller clientèle à affecter à l'agence bancaire
	 */
	public void ajouterConseillerClientele(Gerant gerant, ConseillerClientele conseillerClientele) {
		// Ajout du conseiller clientèle à la collection de conseillers clientèles de l'agence
		gerant.getAgence().getConseillersClienteleAgence().add(conseillerClientele);
		
		// Valorisation de l'attribut monAgence du conseiller clientèle
		conseillerClientele.setMonAgence(gerant.getAgence());
	}
	
//	/**
//	 * Méthode permettant de retirer un conseiller clientèle d'une agence bancaire
//	 * @param agence : l'agence bancaire de laquelle on veut retirer un conseiller clientèle
//	 * @param conseillerClientele : le conseiller clientèle à retirer de l'agence bancaire
//	 */
//	public void retirerConseillerClientele(Agence agence, ConseillerClientele conseillerClientele) {
//		agence.getConseillersClienteleAgence().remove(conseillerClientele);
//	}
	
	public void retirerConseillerClientele(Gerant gerant, ConseillerClientele conseillerClientele) {
		// Retrait du conseiller clientèle à la collection de conseillers clientèles de l'agence
		gerant.getAgence().getConseillersClienteleAgence().remove(conseillerClientele);
		
		// Réinitialisation de l'attribut monAgence du conseiller clientèle
		conseillerClientele.setMonAgence(null);
	}
	
//	/**
//	 * Méthode permettant de faire un audit d'une agence bancaire
//	 * @param agence : l'agence bancaire que l'on veut auditer
//	 * @return tableau de 2 entiers [a,b], a : nombre de comptes particuliers débiteurs de plus de 5000 euros
//	 * et b : nombre de comptes entreprises débiteurs de plus de 50000 euros
//     */
//	public int[] auditerAgence (Agence agence) {
//		
//		int nbCompteParticulierDebiteur = 0;
//		int nbCompteEntrepriseDebiteur = 0;
//		int[] t = {0,0};
//		
//		// Pour tous les clients d'une agence
//		for (Client c : agence.getClientsAgence()) {
//			
//			// Si le client est de type ClientParticulier
//			if (c.getClass().isInstance(new ClientParticulier())) {
//				// Si le découvert du compte courant est supérieur à 5000
//				if ((c.getCompteCourant()).getSoldeCompte()<-5000) {
//					nbCompteParticulierDebiteur += 1;
//				}
//			}
//			
//			// Sinon, si le client est de type ClientEntreprise
//			else {
//				
//				// Si le découvert du compte courant est supérieur à 50000
//				if ((c.getCompteCourant()).getSoldeCompte()<-50000) {
//					nbCompteEntrepriseDebiteur += 1;
//				}
//			}
//		}
//			
//		t[0] = nbCompteParticulierDebiteur;
//		t[1] = nbCompteEntrepriseDebiteur;
//		// retourne un tableau contenant le nombre de comptes particuliers débiteurs
//		// de plus de 5000 euros et le nombre de comptes entreprises débiteurs de plus de 50000 euros
//		return t;
//	}

	/**
	 * Méthode permettant à un gérant de procéder à un audit de son agence bancaire
	 * @param gerant : le gérant souhaitant procéder à un audit de son agence bancaire
	 * @return un tableau de 2 entiers [a,b]
	 * a = nombre de comptes particuliers débiteurs de plus de 5000 euros
	 * b = nombre de comptes entreprises débiteurs de plus de 50000 euros
	 */
	public int[] auditerAgence (Gerant gerant) {
		
		int nbCompteParticulierDebiteur = 0;
		int nbCompteEntrepriseDebiteur = 0;
		int[] t = {0,0};
		
		// Pour tous les clients d'une agence
		for (Client c : gerant.getAgence().getClientsAgence()) {
			
			// Si le client est de type ClientParticulier
			if (c.getClass().isInstance(new ClientParticulier())) {
				// Si le découvert du compte courant est supérieur à 5000
				if ((c.getCompteCourant()).getSoldeCompte()<-5000) {
					nbCompteParticulierDebiteur += 1;
				}
			}
			
			// Sinon, si le client est de type ClientEntreprise
			else {
				// Si le découvert du compte courant est supérieur à 50000
				if ((c.getCompteCourant()).getSoldeCompte()<-50000) {
					nbCompteEntrepriseDebiteur += 1;
				}
			}
		}
			
		t[0] = nbCompteParticulierDebiteur;
		t[1] = nbCompteEntrepriseDebiteur;
		// retourne un tableau contenant le nombre de comptes particuliers débiteurs
		// de plus de 5000 euros et le nombre de comptes entreprises débiteurs de plus de 50000 euros
		return t;
	}
}
