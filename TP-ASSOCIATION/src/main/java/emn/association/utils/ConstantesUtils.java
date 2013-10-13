package emn.association.utils;

public interface ConstantesUtils {
	
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
	public static final String ATTRIBUT_PANIER = "panier";
	public static final String ATTRIBUT_CODE_ARTICLE = "article.code";
	public static final String ATTRIBUT_DECONNECTION = "deco";
	public static final String ATTRIBUT_ANNULER_COMMANDE = "annuler";
	public static final String ATTRIBUT_VALIDER = "valider";
	
	// Constantes global
	public final static String ATTRIBUT_ADHERENT = "adherent";
	public static final String TRUE = "true";
	
	// Chemin vers les jsp
	public final static String PATH_TO_ACCUEIL = "/jsp/core/accueil.jsp";
	public final static String PATH_TO_FORM = "/jsp/core/formulaire_creation_compte.jsp";
	public final static String PATH_TO_ARTICLE = "/jsp/core/liste_articles.jsp";
	public final static String PATH_TO_COMMAND = "/jsp/core/liste_commande.jsp";
	public final static String PATH_TO_LOGIN = "/jsp/core/login.jsp";
	public final static String PATH_TO_LOGIN_REDIRECT = "/Login";
	public static final String PATH_TO_MERCI = "/jsp/core/merci.jsp";
	public static final String PATH_TO_MERCI_REDIRECT = "/Merci";


	

}
