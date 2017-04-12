package service.test;

<<<<<<< HEAD
import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import dao.Dao;
import metier.Adresse;
import metier.Agence;
import metier.Client;
import metier.ClientParticulier;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.ConseillerClientele;
import service.CompteCourantService;
import service.CompteEpargneService;
import service.ConseillerClienteleService;
import service.IConseillerClienteleService;
import service.exceptions.MontantNegatifException;
import service.exceptions.NombreMaxClientsParConseillerException;
import service.exceptions.SoldeInsuffisantException;

/**
 * Test des méthodes de la classe ConseillerClienteleService
 * @author BERNY LE GAL
 * @version 1.0
 */
public class ConseillerClienteleServiceTest {
	
	
/**
 * Test de la méthode ajouter client avec un nombre de clients inférieur à 10
 * Test method for {@link service.ConseillerClienteleService#ajouterClient(metier.ConseillerClientele, metier.Client)}.
 */

	@Test
	@Ignore
	public void testAjouterClient() {
		
		
		IConseillerClienteleService ccs = new ConseillerClienteleService();
		
		Client clientVincentL = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("10, Rue de la Gare", "69006", "LYON"),"0645647894","legalvince@aapo.fr");
		
		
		ConseillerClientele cc = new ConseillerClientele(5,"Mme","martin","dupont");
		Agence agence = new Agence();
		cc.setMonAgence(agence);
		
		try {
			ccs.ajouterClient(cc, clientVincentL);
		} catch (NombreMaxClientsParConseillerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test de la méthode modifierclient en modifiant l'adresse et le téléphone d'un même client
	 */
	@Test
	public void testModifierClient() {
		
		//ConseillerClienteleService ccs = new ConseillerClienteleService();
		Dao dao = new Dao();
		
		Client clientVincentL = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("10, Rue de la Gare", "69006", "LYON"),"0645647894","legalvince@aapo.fr");
				
		Client clientVincentL2 = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("rue B","69001","Villeurbanne"),"0707070707","legalvince@aapo.fr");
		
		Adresse adresse = new Adresse("rue B", "69001", "Villeurbanne");			
		Client client = new ClientParticulier(1,"M","Le Gal","Vincent", adresse, "0707070707", "legalvince@aapo.fr");
		
		
		dao.modifierClient(client); //Appel la fonction ModifierClient
=======
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import metier.Adresse;
import metier.Agence;
import metier.Client;
import metier.ClientEntreprise;
import metier.ClientParticulier;
import metier.CompteCourant;
import metier.CompteEpargne;

import metier.ConseillerClientele;
import metier.CreditConsommation;
import service.CompteCourantService;
import service.CompteEpargneService;
import service.ConseillerClienteleService;

import service.IConseillerClienteleService;

import service.exceptions.MontantNegatifException;
import service.exceptions.NombreMaxClientsParConseillerException;
import service.exceptions.SoldeInsuffisantException;

/**
 * Test des méthodes de la classe ConseillerClienteleService
 * @author BERNY LE GAL
 * @version 1.0
 */
public class ConseillerClienteleServiceTest {
	
	
/**
 * Test de la méthode ajouter client avec un nombre de clients inférieur à 10
 * Test method for {@link service.ConseillerClienteleService#ajouterClient(metier.ConseillerClientele, metier.Client)}.
 */

	@Test
	@Ignore
	public void testAjouterClient() {
		
		
		IConseillerClienteleService ccs = new ConseillerClienteleService();
		
		Client clientVincentL = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("10, Rue de la Gare", "69006", "LYON"),"0645647894","legalvince@aapo.fr");
		
		
		ConseillerClientele cc = new ConseillerClientele(5,"Mme","martin","dupont");
		Agence agence = new Agence();
		cc.setMonAgence(agence);
		
		try {
			ccs.ajouterClient(cc, clientVincentL);
		} catch (NombreMaxClientsParConseillerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test de la méthode modifierclient en modifiant l'adresse et le téléphone d'un même client
	 */
	@Test
	public void testModifierClient() {
		
		ConseillerClienteleService ccs = new ConseillerClienteleService();
		
		Client clientVincentL = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("10, Rue de la Gare", "69006", "LYON"),"0645647894","legalvince@aapo.fr");
				
		
		Client clientVincentL2 = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("rue B","69001","Villeurbanne"),"0707070707","legalvince@aapo.fr");
				
		
		ccs.modifierClient(1,"M","Le Gal","Vincent", "rue B", "69001", "Villeurbanne", "0707070707", "legalvince@aapo.fr", null); //Appel la fonction ModifierClient
>>>>>>> branch 'master' of https://github.com/serviceshuios/Proxi2-Groupe5.git
		
		
		Assert.assertEquals(true, (clientVincentL.getAdresse()!=clientVincentL2.getAdresse()));
			
}

	/**
	 * Test de la méthode effectuerVirement avec deux comptes épargnes et un virement autorisé
	 * Test method for {@link service.ConseillerClienteleService#faireVirement(metier.Compte, metier.Compte, double)}.
	 */
	
	@Test
	public void testFaireVirement() {
		
		CompteEpargneService ces = new CompteEpargneService();
		CompteEpargne c1 = (CompteEpargne) ces.creerCompte(1, 10000.5, new Date());
		CompteEpargne c2 = (CompteEpargne) ces.creerCompte(1, 5000.5, new Date());
		ConseillerClienteleService ccs = new ConseillerClienteleService();
		
		try {
			ccs.effectuerVirement(c1, c2, 1000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c1.getSoldeCompte(), 9000, 0.001);
		Assert.assertEquals(c2.getSoldeCompte(), 6001, 0.001);
	}
	
	/**
	 * Test de la méthode effectuerVirement avec deux comptes épargnes et un montant négatif
	 * Test method for {@link service.ConseillerClienteleService#faireVirement(metier.Compte, metier.Compte, double)}.
	 */

	@Test
	public void testFaireVirement2() {
		
		CompteEpargneService ces = new CompteEpargneService();
		CompteEpargne c1 = (CompteEpargne) ces.creerCompte(1, 10000.5, new Date());
		CompteEpargne c2 = (CompteEpargne) ces.creerCompte(1, 5000.5, new Date());
		ConseillerClienteleService ccs = new ConseillerClienteleService();
		
		try {
			ccs.effectuerVirement(c1, c2, -1000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c1.getSoldeCompte(), 10000.5,0.001);
		Assert.assertEquals(c2.getSoldeCompte(), 5000.5,0.001);
	}
	
	/**
	 * Test de la méthode effectuerVirement avec deux comptes épargnes et un montant supérieur au solde du compte débiteur
	 * Test method for {@link service.ConseillerClienteleService#faireVirement(metier.Compte, metier.Compte, double)}.
	 */
	
	@Test
	public void testFaireVirement3() {
		
		CompteEpargneService ces = new CompteEpargneService();
		CompteEpargne c1 = (CompteEpargne) ces.creerCompte(1, 10000.5, new Date());
		CompteEpargne c2 = (CompteEpargne) ces.creerCompte(1, 5000.5, new Date());
		ConseillerClienteleService ccs = new ConseillerClienteleService();
		
		try {
			ccs.effectuerVirement(c1, c2, 10000.6);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(c1.getSoldeCompte(), 10000.5,0.001);
		Assert.assertEquals(c2.getSoldeCompte(), 5000.5,0.001);
	}
	
	/**
	 * Test de la méthode effectuerVirement avec deux comptes courants et un montant inférieur au découvert du solde créditeur
	 * Test method for {@link service.ConseillerClienteleService#faireVirement(metier.Compte, metier.Compte, double)}.
	 */
	
	@Test
	public void testFaireVirement4() {
		
		CompteCourantService ccos = new CompteCourantService();
		CompteCourant c1 = (CompteCourant) ccos.creerCompte(1, 10000.5, new Date());
		CompteCourant c2 = (CompteCourant) ccos.creerCompte(1, 5000.5, new Date());
		ConseillerClienteleService ccs = new ConseillerClienteleService();
		
		try {
			ccs.effectuerVirement(c1, c2, 1000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		};
		Assert.assertEquals(c1.getSoldeCompte(), 9000,0.001);
		Assert.assertEquals(c2.getSoldeCompte(), 6001,0.001);
	}

	/**
	 * Test de la méthode effectuerVirement avec deux comptes courants et un virement négatif
	 * Test method for {@link service.ConseillerClienteleService#faireVirement(metier.Compte, metier.Compte, double)}.
	 */
	
	@Test
	public void testFaireVirement5() {
		
		CompteCourantService ccos = new CompteCourantService();
		CompteCourant c1 = (CompteCourant) ccos.creerCompte(1, 10000.5, new Date());
		CompteCourant c2 = (CompteCourant) ccos.creerCompte(1, 5000.5, new Date());
		ConseillerClienteleService ccs = new ConseillerClienteleService();
		
		try {
			ccs.effectuerVirement(c1, c2, -1000.5);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		};
		Assert.assertEquals(c1.getSoldeCompte(), 10000.5,0.001);
		Assert.assertEquals(c2.getSoldeCompte(), 5000.5,0.001);
	}
	
	/**
	 * Test de la méthode effectuerVirement avec deux comptes courants et un montant supérieur au découvert du compte débiteur 
	 * Test method for {@link service.ConseillerClienteleService#faireVirement(metier.Compte, metier.Compte, double)}.
	 */
	
	@Test
	public void testFaireVirement6() {
		
		CompteCourantService ccos = new CompteCourantService();
		CompteCourant c1 = (CompteCourant) ccos.creerCompte(1, 10000.5, new Date());
		CompteCourant c2 = (CompteCourant) ccos.creerCompte(1, 5000.5, new Date());
		ConseillerClienteleService ccs = new ConseillerClienteleService();
		
		try {
			ccs.effectuerVirement(c1, c2, 11000.6);
		} catch (SoldeInsuffisantException e) {
			System.out.println(e.getMessage());
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		};
		Assert.assertEquals(c1.getSoldeCompte(), 10000.5,0.001);
		Assert.assertEquals(c2.getSoldeCompte(), 5000.5,0.001);
	}
		
}
