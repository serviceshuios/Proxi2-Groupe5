package dao.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dao.Dao;
import metier.Adresse;
import metier.Client;
import metier.ClientParticulier;
import service.ConseillerClienteleService;

public class DaoTest {
	
	
	/**
	 * Test de la methode modifierClient dans la couche DAO.
	 * Modification du téléphone et de l'adresse d'un même client.
	 */
	
	@Test
	public void testmodifierClient(){
		
		Dao modif = new Dao();
		
		Client clientVincentL = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("10, Rue de la Gare", "69006", "LYON"),"0645647894","legalvince@aapo.fr");
		
		modif.ajouterClient(clientVincentL);
					
		
		modif.modifierClient(1,"M","Le Gal","Vincent", "rue B", "69001", "Villeurbanne", "0707070707", "legalvince@aapo.fr", null); //Appel la fonction ModifierClient de DAO
		
		Assert.assertEquals(true,modif.chercherClient(1)!=clientVincentL);
		
	}
	
	
	

}
