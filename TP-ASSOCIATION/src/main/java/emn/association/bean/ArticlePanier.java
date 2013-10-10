package emn.association.bean;


/**
 * Classe des articles contenus dans le panier (avec leur quantité)
 * @author Guillaume
 *
 */
public class ArticlePanier {

	/**
	 * Le type d'article
	 */
	private Article article;
	
	/**
	 * la quantité d'article à commander
	 */
	private int quantite;

	/**
	 * @param article
	 * @param quantite
	 */
	public ArticlePanier(Article article, int quantite) {
		super();
		this.article = article;
		this.quantite = quantite;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
