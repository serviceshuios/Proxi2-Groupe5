package service.test;

<<<<<<< HEAD
=======
import static org.junit.Assert.*;

>>>>>>> branch 'master' of https://github.com/serviceshuios/Proxi2-Groupe5.git
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import metier.CompteEpargne;
import service.CompteEpargneService;
import service.exceptions.MontantNegatifException;
import service.exceptions.SoldeInsuffisantException;

public class CompteEpargneServiceTest {


/**
 * Test des méthodes de la classe CompteEpargneService
 * @author BERNY LE GAL
 * @version 1.0
 */


	/**
	 * Test de la méthode débiter pour un compte épargne avec un montant autorisé
	 * Test method for {@link service.CompteEpargneService#debiter(metier.Compte, double)}.
	 */
	@Test
	public void testDebiter() {
		CompteEpargneService ces = new CompteEpargneService();
		CompteEpargne c = (CompteEpargne) ces.creerCompte(1, 10000.5, new Date());
		try {
			ces.debiter(c, 1000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 9000,0.001);
	}
	
	/**
	 * Test de la méthode débiter pour un compte épargne avec un montant négatif
	 * Test method for {@link service.CompteEpargneService#debiter(metier.Compte, double)}.
	 */
	@Test
	public void testDebiter2() {
		CompteEpargneService ces = new CompteEpargneService();
		CompteEpargne c = (CompteEpargne) ces.creerCompte(1, 10000.5, new Date());
		try {
			ces.debiter(c, -1000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 10000.5,0.001);
	}
	
	/**
	 * Test de la méthode débiter pour un compte épargne avec un montant égal au solde
	 * Test method for {@link service.CompteEpargneService#debiter(metier.Compte, double)}.
	 */
	@Test
	public void testDebiter3() {
		CompteEpargneService ces = new CompteEpargneService();
		CompteEpargne c = (CompteEpargne) ces.creerCompte(1, 10000.5, new Date());
		try {
			ces.debiter(c, 10000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 0,0.001);
	}
	
	/**
	 * Test de la méthode débiter pour un compte épargne avec un montant supérieur au solde
	 * Test method for {@link service.CompteEpargneService#debiter(metier.Compte, double)}.
	 */
	@Test
	public void testDebiter4() {
		CompteEpargneService ces = new CompteEpargneService();
		CompteEpargne c = (CompteEpargne) ces.creerCompte(1, 10000.5, new Date());
		try {
			ces.debiter(c, 10000.6);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c.getSoldeCompte(), 10000.5,0.001);
	}
}





