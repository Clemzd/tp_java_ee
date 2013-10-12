package emn.association.services.interfaces;

import java.util.ArrayList;
import java.util.List;

import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;

public interface ICommandeService {
	
	public Article getArticleFromCode(String code);
	public void miseAJourPanier(List<ArticlePanier> panier, Article nouvelArticle);
	public boolean suppressionPanier(List<ArticlePanier> panier);
	public boolean effectuerAchat(List<ArticlePanier> panier);

}
