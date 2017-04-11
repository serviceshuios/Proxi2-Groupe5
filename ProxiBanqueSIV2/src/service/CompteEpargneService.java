package service;

import java.util.Date;
import metier.Compte;
import metier.CompteEpargne;
import service.exceptions.MontantNegatifException;
import service.exceptions.SoldeInsuffisantException;

/**
 * La classe CompteEpargneService est associée à la classe métier CompteEpargne.
 * Elle permet de définir le CompteEpargne ProxiBanque.
 * Le compte épargne est caractérisé par le taux de rémunération, par défaut à 3%.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class CompteEpargneService extends CompteService {

	/**
	 * Méthode permettant de créer un Compte de type CompteEpargne
	 * avec un taux de rémunération par défaut de 3% (demande de ProxiBanque)
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 * @return le compte épargne créé
	 */
	public Compte creerCompte(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		return new CompteEpargne(idCompte, soldeCompte, dateOuvertureCompte, 3);
	}
	
	/**
	 * Redéfinition de la méthode débiter de la classe mère CompteService
	 * @param c : le compte à débiter
	 * @param montant : le montant à débiter
	 * @return le solde du compte
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	@Override
	public double debiter(Compte c, double montant) throws SoldeInsuffisantException, MontantNegatifException {
		if (montant >= 0) {
			if (montant <= c.getSoldeCompte()) {
				c.setSoldeCompte(c.getSoldeCompte() - montant);
			} else throw new SoldeInsuffisantException("SOLDE INSUFFISANT");
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return c.getSoldeCompte();
	}
	
	/**
	 * Méthode spécifique à un compte de type CompteEpargne
	 * permettant de calculer les intêts
	 * @param compte : le compte épargne duquel on veut calculer les interêts
	 * @return les interêts calculés
	 */
	public double calculInterets(CompteEpargne compte) {
		return compte.getSoldeCompte()*(compte.getTauxRemuneration()/100);
	}
	
}
