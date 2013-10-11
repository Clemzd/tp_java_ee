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

	public ArticlePanier() {
		super();
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
	
	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(article.toString()); 
        sb.append("||"); 
        sb.append(quantite);
        return sb.toString(); 
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + quantite;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticlePanier other = (ArticlePanier) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (quantite != other.quantite)
			return false;
		return true;
	}

	
}
