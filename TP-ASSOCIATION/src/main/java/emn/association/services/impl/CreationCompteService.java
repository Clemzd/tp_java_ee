package emn.association.services.impl;

import emn.association.services.interfaces.ICreationCompteService;

public class CreationCompteService implements ICreationCompteService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verifierChampRempli(String identifiant, String pass, String passConfirmation, String nomFamille, String prenom) {
		return (!identifiant.isEmpty() && !pass.isEmpty() && !passConfirmation.isEmpty() && !nomFamille.isEmpty() && !prenom.isEmpty());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verifierMotDePasseIdentique(String pass, String passConfirmation) {
		return pass.equals(passConfirmation);
	}

}
