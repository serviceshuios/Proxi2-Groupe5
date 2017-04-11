package service;

import java.util.Date;

import metier.Compte;
import service.exceptions.MontantNegatifException;
import service.exceptions.SoldeInsuffisantException;

/**
 * La classe abstraite service CompteService est associée à la classe métier Compte.
 * Elle permet d'effectuer les opérations spécifiques sur les compte ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public abstract class CompteService {

	/**
	 * Méthode abstraite permettant de créer un Compte
	 * Cette méthode sera donc redéfinie dans chaque classe fille
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte: la date d'ouverture du compte
	 * @return le compte créé
	 */
	public abstract Compte creerCompte(int idCompte, double soldeCompte, Date dateOuvertureCompte);
	
	/**
	 * Méthode permettant de créditer un montant sur un compte
	 * @param c : le compte à créditer
	 * @param montant : le montant à créditer
	 * @return le solde du compte
	 * @throws MontantNegatifException
	 */
	public double crediter(Compte c, double montant) throws MontantNegatifException {
		if (montant >= 0) {
			c.setSoldeCompte(c.getSoldeCompte() + montant);
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return c.getSoldeCompte();
	}
	
	/**
	 * Méthode abstraite permettant de débiter un montant sur un compte
	 * Cette méthode sera redéfinie dans chaque classe fille
	 * @param c : le compte à débiter
	 * @param montant : le montant à débiter
	 * @return le solde du compte
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	public abstract double debiter(Compte c, double montant) throws SoldeInsuffisantException, MontantNegatifException;
	
}
