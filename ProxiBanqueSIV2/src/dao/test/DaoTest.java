package dao.test;

<<<<<<< HEAD
import org.junit.Assert;
import org.junit.Test;

import dao.Dao;
import metier.Adresse;
import metier.Client;
import metier.ClientEntreprise;
import metier.ClientParticulier;
import metier.ConseillerClientele;

public class DaoTest {
	
	
	/**
	 * Test de la methode modifierClient dans la couche DAO.
	 * Modification du téléphone et de l'adresse d'un même client.
	 */
	
	@Test
	public void testmodifierClient(){
		
		Dao modif = new Dao();
		
		Client clientVincentL = new ClientEntreprise(1,"M","Le Gal","Vincent", new Adresse("10, Rue de la Gare", "69006", "LYON"),"0645647894","legalvince@aapo.fr","GTM");
		
		modif.ajouterClient(clientVincentL);
		
		Adresse adresse = new Adresse("rue B", "69001", "Villeurbanne");			
		Client client = new ClientEntreprise(1,"M","Le Gal","Vincent", adresse, "0707070707", "legalvince@aapo.fr","GTM");
		modif.modifierClient(client); //Appel la fonction ModifierClient de DAO
=======
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dao.Dao;
import metier.Adresse;
import metier.Agence;
import metier.Client;

import metier.ClientParticulier;
import metier.ConseillerClientele;
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
>>>>>>> branch 'master' of https://github.com/serviceshuios/Proxi2-Groupe5.git
		
		Assert.assertEquals(true,modif.chercherClient(1).getAdresse() !=clientVincentL.getAdresse());
		
	}
	
	
	@Test
	public void testListerClient(){
		
		Dao list = new Dao();
		
		ConseillerClientele cons = new ConseillerClientele(1,"M","JAFFRE","Guy");
		
		Client clientVincentL = new ClientParticulier(1,"M","Le Gal","Vincent", new Adresse("10, Rue de la Gare", "69006", "LYON"),"0645647894","legalvince@aapo.fr");
		Client clientStephane = new ClientParticulier(1,"M","Berny","Stephane", new Adresse("20, Rue de la fontaine", "69011", "LYON"),"123654789","sberny@aapo.fr");
			
		//list.listerClientsConseiller(cons);
		
		
		list.listerClientsConseiller(cons).add(clientStephane);
		list.listerClientsConseiller(cons).add(clientVincentL);
		
		Assert.assertEquals(true,list.listerClientsConseiller(cons).size() == 2);
		
	}
	
	

}
