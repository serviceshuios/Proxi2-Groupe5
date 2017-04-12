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
 * Test des m�thodes d�biter et cr�diter pour un compte courant
 * @author BERNY LE GAL
 * @version 1.0
 */


	/**
	 * Test de la m�thode d�biter pour un compte courant avec un montant autoris� et pas de d�couvert au final
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
	 * Test de la m�thode d�biter pour un compte courant avec un montant n�gatif
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
	 * Test de la m�thode d�biter pour un compte courant avec solde final �gal au d�couvert autoris�
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
	 * Test de la m�thode d�biter pour un compte courant avec solde final inf�rieur au d�couvert autoris�
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
	 * Test de la m�thode cr�diter pour un compte courant avec un montant positif
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
	 * Test de la m�thode cr�diter pour un compte courant avec un montant n�gatif
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


