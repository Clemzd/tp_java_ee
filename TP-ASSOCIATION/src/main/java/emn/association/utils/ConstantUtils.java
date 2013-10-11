package emn.association.utils;

public interface ConstantUtils {
	
	// Constantes pour la servlet Login
	public final static String ATTRIBUT_ERREUR = "erreur";
	public final static String ATTRIBUT_ID = "id";
	public final static String ATTRIBUT_PWD = "mdp";
	
	// Constantes pour la servlet Creation Compte
	public final static String ATTRIBUT_IDENTIFIANT = "identifiant";
	public final static String ATTRIBUT_CODE_POSTAL = "code_postal";
	public final static String ATTRIBUT_NOM_FAMILLE = "nom_famille";
	public final static String ATTRIBUT_PAYS = "pays";
	public final static String ATTRIBUT_PRENOM = "prenom";
	public final static String ATTRIBUT_ADRESSE = "adresse";
	public final static String ATTRIBUT_VILLE = "ville";
	public final static String ATTRIBUT_PASSE = "mot_de_passe";
	public final static String ATTRIBUT_PASSE_CONFIRMATION = "mot_de_passe_confirmation";
	
	// Constantes global
	public final static String ATTRIBUT_ADHERENT = "adherent";
	
	// Chemin vers les jsp
	public final static String PATH_TO_ACCUEIL = "/jsp/core/accueil.jsp";
	public final static String PATH_TO_FORM = "/jsp/core/formulaire_creation_compte.jsp";
	public final static String PATH_TO_ARTICLE = "/jsp/core/liste_articles.jsp";
	public final static String PATH_TO_COMMAND = "/jsp/core/liste_commande.jsp";
	public final static String PATH_TO_LOGIN = "/jsp/core/login.jsp";
	public final static String PATH_TO_LOGIN_REDIRECT = "/Login";
	

}
