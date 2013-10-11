package emn.association.services.interfaces;

import java.util.List;

import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;

public interface ICommandeService {
	
	public Article getArticleFromCode(String code);
	public void updateBasket(List<ArticlePanier> panier, Article nouvArt);

}
