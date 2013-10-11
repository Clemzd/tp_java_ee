package emn.association.services.impl;

import java.util.List;

import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.ArticlePersistence;
import emn.association.services.interfaces.ICommandeService;

public class CommandeService implements ICommandeService {

	@Override
	public Article getArticleFromCode(String code) {
		
		ArticlePersistence serviceArticle = PersistenceServiceProvider.getService(ArticlePersistence.class);
		Article nouvArt = serviceArticle.load(code);

		return nouvArt;
	}

	@Override
	public void updateBasket(List<ArticlePanier> panier, Article nouvArt) {
		boolean existe = false;
		// On recherche si l'article existe
		for (ArticlePanier article : panier) {
			// Si oui on met à jour la quantité
			if (nouvArt.equals(article.getArticle())) {
				article.setQuantite(article.getQuantite() + 1);
				existe = true;
			}
		}
		// Sinon on l'ajoute
		if (!existe) {
			panier.add(new ArticlePanier(nouvArt, 1));
		}		
	}

}
