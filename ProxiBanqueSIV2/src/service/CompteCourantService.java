package service;

import java.util.Date;
import metier.Compte;
import metier.CompteCourant;
import service.exceptions.MontantNegatifException;
import service.exceptions.SoldeInsuffisantException;

/**
 * La classe CompteCourantService est associée à la classe métier CompteCourant.
 * Elle permet de définir le CompteCourant ProxiBanque.
 * Le Compte courant ProxiBanque est caractérisé par une autorisation de découvert par défaut de 1000 euros.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class CompteCourantService extends CompteService {

	/**
	 * Méthode permettant de créer un Compte de type CompteCourant
	 * avec un découvert autorisé par défaut de 1000 € (demande de ProxiBanque)
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 * @return le compte courant créé
	 */
	public Compte creerCompte(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		return new CompteCourant(idCompte, soldeCompte, dateOuvertureCompte, 1000);
	}
	
	/**
	 * Redéfinition de la méthode débiter de la classe mère CompteService
	 * gérant le découvert autorisé propre à un compte courant
	 * @param c : le compte à débiter
	 * @param montant : le montant à débiter
	 * @return le solde du compte
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	@Override
	public double debiter(Compte c, double montant) throws SoldeInsuffisantException, MontantNegatifException {
		CompteCourant cc = (CompteCourant)c;
		if (montant >= 0) {
			if (montant <= cc.getSoldeCompte() + cc.getDecouvert()) {
				c.setSoldeCompte(c.getSoldeCompte() - montant);
			} else throw new SoldeInsuffisantException("SOLDE INSUFFISANT");
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return cc.getSoldeCompte();
	}
		
}
