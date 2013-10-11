package emn.association.test.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;
import emn.association.mock.ArticleMock;
import emn.association.mock.ArticlePanierMock;
import emn.association.services.impl.CommandeService;

public class CommandeTest {

	@Test
	public void test1() {
		
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
		for (ArticlePanier articlePanier : panier) {
			System.out.println(articlePanier.toString());
		}
		
		System.out.println(" \n premier ajout : " );
		serviceCommande.miseAJourPanier(panier, article1);
		for (ArticlePanier articlePanier : panier) {
			if(articlePanier.getArticle().equals(article1)){
				Assert.assertEquals(1,articlePanier.getQuantite());
			}
			System.out.println(articlePanier.toString());
		}
		
		System.out.println("\n ajout d'un autre article : " );
		serviceCommande.miseAJourPanier(panier, article2);
		for (ArticlePanier articlePanier : panier) {
			if(articlePanier.getArticle().equals(article1)){
				Assert.assertEquals(1,articlePanier.getQuantite());
			}else if(articlePanier.getArticle().equals(article2)){
				Assert.assertEquals(1,articlePanier.getQuantite());
			}
			System.out.println(articlePanier.toString());
		}
		
		System.out.println("\n ajout d'un article déjà commandé : " );
		serviceCommande.miseAJourPanier(panier, article1);
		for (ArticlePanier articlePanier : panier) {
			if(articlePanier.getArticle().equals(article1)){
				Assert.assertEquals(2,articlePanier.getQuantite());
			}else if(articlePanier.getArticle().equals(article2)){
				Assert.assertEquals(1,articlePanier.getQuantite());
			}
			System.out.println(articlePanier.toString());
		}
	
	}
		// TODO : set primary key values here 
		//process( service, mock, "A"  );
	
}
