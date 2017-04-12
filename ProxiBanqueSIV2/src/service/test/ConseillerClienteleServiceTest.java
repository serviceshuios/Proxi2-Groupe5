package service.test;

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
	public void testAjouterClient() {
		
		
		IConseillerClienteleService ccs = new ConseillerClienteleService();
		
		Client clientVincentL = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("10, Rue de la Gare", "69006", "LYON"),"0645647894","legalvince@aapo.fr");
		
		
		ConseillerClientele cc = new ConseillerClientele(5,"Mme","martin","dupont");
		Agence agence = new Agence();
		cc.setMonAgence(agence);
		
		assertEquals(true,ccs.ajouterClient(cc, clientVincentL);
		
	
	}

}
