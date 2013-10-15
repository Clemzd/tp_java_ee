package emn.association.utils;

public interface MessageUtils {
	
	// Message pour le servlet Login
	public static String NO_ID_OR_PWD = "Veuillez indiquer un identifiant et un mot de passe.";
	public static String WRONG_ID_OR_PWD = "Identifiant et/ou mot de passe incorrect.";
	
	// Message pour le sevlet de creation de compte
	public final static String CHAMP_OBLIGATOIRES = "Veuillez remplir tous les champs obligatoires.";
	public final static String MOTS_DE_PASSE_DIFFERENT = "Les mots de passes doivent être identiques.";
	
	// Message pour le servlet de commande
	public final static String COMMANDE_IMPOSSIBLE = "Impossible de valider la commande, il manque des stocks pour un article.";

}
