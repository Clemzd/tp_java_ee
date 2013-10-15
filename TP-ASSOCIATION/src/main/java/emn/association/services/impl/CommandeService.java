package emn.association.services.impl;

import java.util.ArrayList;
import java.util.List;

import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.ArticlePersistence;
import emn.association.services.interfaces.ICommandeService;

public class CommandeService implements ICommandeService {

	private ArticlePersistence serviceArticle;
	
	public CommandeService(){
		serviceArticle = PersistenceServiceProvider.getService(ArticlePersistence.class);
	}
	
	@Override
	public Article getArticleFromCode(String code) {
		
		Article nouvArt = serviceArticle.load(code);

		return nouvArt;
	}

	
	
	@Override
	public void miseAJourPanier(List<ArticlePanier> panier, Article nouvelArticle, int quantite) {		
		boolean existe = false;
		// On recherche si l'article existe
		for (ArticlePanier article : panier) {
			// Si oui on met à jour la quantité
			if (nouvelArticle.equals(article.getArticle())) {
				article.setQuantite(article.getQuantite() + quantite);
				existe = true;
			}
		}
		// Sinon on l'ajoute
		if (!existe) {
			panier.add(new ArticlePanier(nouvelArticle, quantite));
		}		
	}

	public boolean effectuerAchat(List<ArticlePanier> panier) {
		ArticlePersistence serviceArticle = PersistenceServiceProvider.getService(ArticlePersistence.class);
		
		// Premiere loop pour checker si tout le panier est OK
		for (ArticlePanier articlePanier : panier) {
			Article articleAchete = serviceArticle.load(articlePanier.getArticle().getCode());
			// Cas multi-utilisateur : L'article doit avoir les stocks suffisants pour valider la commande
			if ((articleAchete.getStock()-articlePanier.getQuantite()) < 0) {
				return false; 
			}
		}
		
		// Ici le panier est OK
		for (ArticlePanier articlePanier : panier) {
			Article articleAchete = serviceArticle.load(articlePanier.getArticle().getCode());
			articleAchete.setStock(articleAchete.getStock()-articlePanier.getQuantite());
			serviceArticle.save(articleAchete);
		}
		
		return suppressionPanier(panier);
	}
	
	
	@Override
	public boolean suppressionPanier(List<ArticlePanier> panier) {
		panier.clear();
		if(panier.isEmpty()) return true;
		else return false;
	}

}
