package service.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import metier.CompteCourant;
import service.CompteCourantService;
import service.exceptions.MontantNegatifException;
import service.exceptions.SoldeInsuffisantException;

public class CompteCourantServiceTest {


/**
 * Test des méthodes débiter et créditer pour un compte courant
 * @author BERNY LE GAL
 * @version 1.0
 */


	/**
	 * Test de la méthode débiter pour un compte courant avec un montant autorisé et pas de découvert au final
	 * Test method for {@link service.CompteCourantService#debiter(metier.Compte, double)}.
	 */
	@Test
	public void testDebiter() {
		CompteCourantService ccs = new CompteCourantService();
		CompteCourant c = (CompteCourant) ccs.creerCompte(1, 10000.5, new Date());
		try {
			ccs.debiter(c, 1000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 9000,0.001);
	}
	
	/**
	 * Test de la méthode débiter pour un compte courant avec un montant négatif
	 * Test method for {@link service.CompteCourantService#debiter(metier.Compte, double)}.
	 */
	@Test
	public void testDebiter2() {
		CompteCourantService ccs = new CompteCourantService();
		CompteCourant c = (CompteCourant) ccs.creerCompte(1, 10000.5, new Date());
		try {
			ccs.debiter(c,-1000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 10000.5,0.001);
	}
	
	/**
	 * Test de la méthode débiter pour un compte courant avec solde final égal au découvert autorisé
	 * Test method for {@link service.CompteCourantService#debiter(metier.Compte, double)}.
	 */
	@Test
	public void testDebiter3() {
		CompteCourantService ccs = new CompteCourantService();
		CompteCourant c = (CompteCourant) ccs.creerCompte(1, 10000.5, new Date());
		try {
			ccs.debiter(c, 11000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), -1000,0.001);
	}
	
	/**
	 * Test de la méthode débiter pour un compte courant avec solde final inférieur au découvert autorisé
	 * Test method for {@link service.CompteCourantService#debiter(metier.Compte, double)}.
	 */
	@Test
	public void testDebiter4() {
		CompteCourantService ccs = new CompteCourantService();
		CompteCourant c = (CompteCourant) ccs.creerCompte(1, 10000.5, new Date());
		try {
			ccs.debiter(c, 11000.6);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 10000.5,0.001);
	}

	/**
	 * Test de la méthode créditer pour un compte courant avec un montant positif
	 * Test method for {@link service.CompteService#crediter(metier.Compte, double)}.
	 */
	@Test
	public void testCrediter() {
		CompteCourantService ccs = new CompteCourantService();
		CompteCourant c = (CompteCourant) ccs.creerCompte(1, 10000.5, new Date());
		try {
			ccs.crediter(c, 1000.55);
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 11001.05,0.001);
	}
	
	/**
	 * Test de la méthode créditer pour un compte courant avec un montant négatif
	 * Test method for {@link service.CompteService#crediter(metier.Compte, double)}.
	 */
	@Test
	public void testCrediter2() {
		CompteCourantService ccs = new CompteCourantService();
		CompteCourant c = (CompteCourant) ccs.creerCompte(1, 10000.5, new Date());
		try {
			ccs.crediter(c, -1000.55);
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 10000.5,0.0001);
	}

}


