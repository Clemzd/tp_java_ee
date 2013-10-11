package emn.association.services.interfaces;

public interface ICreationCompteService {

	/**
	 * Verifie que les champs sont bien remplis.
	 * 
	 * @param identifiant
	 * @param pass
	 * @param passConfiguration
	 * @param nomFamille
	 * @param prenom
	 * @return true si un des champs n'a pas été rempli
	 */
	public boolean verifierChampRempli(String identifiant, String pass, String passConfiguration, String nomFamille, String prenom);

	/**
	 * Verifie que les mots de passes sont identiques
	 * 
	 * @param pass
	 * @param passConfirmation
	 * @return true si les mots de passes sont identiques
	 */
	public boolean verifierMotDePasseIdentique(String pass, String passConfirmation);

}
