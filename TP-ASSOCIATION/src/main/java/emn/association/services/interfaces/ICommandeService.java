package emn.association.services.interfaces;

import java.util.List;

import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;

public interface ICommandeService {
	
	public Article getArticleFromCode(String code);
	void miseAJourPanier(List<ArticlePanier> panier, Article nouvelArticle);

}
