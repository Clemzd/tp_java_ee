package emn.association.test.services;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;
import emn.association.mock.ArticleMock;
import emn.association.services.impl.CommandeService;

public class CommandeTest {

	@Test
	public void testCommande() {
		
		System.out.println("Test service Commande : mise à jour Panier " );
		
		CommandeService serviceCommande = new CommandeService();
		
		List<ArticlePanier> panier = new ArrayList<ArticlePanier>();
				
		// Création d'un premier article de panier
		ArticleMock mock1 = new ArticleMock();
		Article article1 = mock1.createInstance();
		
		// Création d'un second article de panier
		Article article2 = mock1.createInstance();
		
		System.out.println("----- "  );
		System.out.println(" panier avant ajout : " );
		affichageContenuPanier(panier);
		
		System.out.println(" \n premier ajout : " );
		serviceCommande.miseAJourPanier(panier, article1, 1);
		affichageContenuPanier(panier);
		for (ArticlePanier articlePanier : panier) {
			if(articlePanier.getArticle().equals(article1)){
				Assert.assertEquals(1,articlePanier.getQuantite());
			}
		}
		
		System.out.println("\n ajout d'un autre article : " );
		serviceCommande.miseAJourPanier(panier, article2, 1);
		affichageContenuPanier(panier);
		for (ArticlePanier articlePanier : panier) {
			if(articlePanier.getArticle().equals(article1)){
				Assert.assertEquals(1,articlePanier.getQuantite());
			}else if(articlePanier.getArticle().equals(article2)){
				Assert.assertEquals(1,articlePanier.getQuantite());
			}
		}
		
		System.out.println("\n ajout d'un article déjà commandé : " );
		serviceCommande.miseAJourPanier(panier, article1, 1);
		affichageContenuPanier(panier);
		for (ArticlePanier articlePanier : panier) {
			if(articlePanier.getArticle().equals(article1)){
				Assert.assertEquals(2,articlePanier.getQuantite());
			}else if(articlePanier.getArticle().equals(article2)){
				Assert.assertEquals(1,articlePanier.getQuantite());
			}
		}
	
	}
	
	@Test
	public void testAnnulerCommande() {
		System.out.println("\n ----- "  );
		System.out.println("Test service Commande : Annuler commande " );
		
		CommandeService serviceCommande = new CommandeService();
		
		List<ArticlePanier> panier = new ArrayList<ArticlePanier>();
				
		// Création d'un premier article de panier
		ArticleMock mock1 = new ArticleMock();
		//Ajout de deux articles
		System.out.println("----- "  );
		
		System.out.println("\n Panier constitué de deux articles : " );
		serviceCommande.miseAJourPanier(panier, mock1.createInstance(), 1);
		serviceCommande.miseAJourPanier(panier, mock1.createInstance(), 1);
		affichageContenuPanier(panier);
		
		//Annulation de commande
		System.out.println("\n On annule la commande "  );
		boolean suppr = serviceCommande.suppressionPanier(panier);
		assertTrue(suppr);
		System.out.println("\n Le panier a été vidé."  );
		affichageContenuPanier(panier);
	}
	
	/*
	@Test
	public void testValiderCommande() {
		System.out.println("\n ----- "  );
		System.out.println("Test service Commande : Valider commande " );
		
		CommandeService serviceCommande = new CommandeService();
		
		List<ArticlePanier> panier = new ArrayList<ArticlePanier>();
				
		// Création d'un premier article de panier
		ArticleMock mock1 = new ArticleMock();
		//Ajout de deux articles
		Article article1 = mock1.createInstance();
		int stockInitialArt1 = article1.getStock();
		Article article2 = mock1.createInstance();
		int stockInitialArt2 = article2.getStock();
		
		System.out.println("----- "  );
		
		System.out.println("\n Panier constitué de deux articles : " );
		serviceCommande.miseAJourPanier(panier, article1 );
		serviceCommande.miseAJourPanier(panier, article2 );
		affichageContenuPanier(panier);
		int qttAcheteArt1 = panier.get(0).getQuantite();
		int qttAcheteArt2 = panier.get(1).getQuantite();
		
		//Validation de commande
		System.out.println("\n On valide la commande "  );
		boolean commandeEffectue = serviceCommande.effectuerAchat(panier);
		assertTrue(commandeEffectue);
		System.out.println("\n Le panier a été vidé."  );
		affichageContenuPanier(panier);
		
		assertEquals(stockInitialArt1-qttAcheteArt1, article1.getStock());
		assertEquals(stockInitialArt2-qttAcheteArt2, article1.getStock());
		System.out.println("\n Le stock a été décrémenté."  );
		
		System.out.println("\n La commande a bien été effectuée."  );
	}
	*/
	
	/**
	 * affiche dans la console le contenu du panier
	 * @param panier
	 */
	private void affichageContenuPanier(List<ArticlePanier> panier) {
		for (ArticlePanier articlePanier : panier) {
			System.out.println(articlePanier.toString());
		}
	}
	 
}
