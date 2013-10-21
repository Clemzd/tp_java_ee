package emn.association.services.impl;

import emn.association.bean.Adherent;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.AdherentPersistence;
import emn.association.services.interfaces.ILoginService;

/**
 * Service pour le LoginController
 * 
 * @author Benjamin
 *
 */
public class LoginService implements ILoginService {

	/**
	 * Recupere l'objet Adherent a partir d'un identifiant
	 */
	@Override
	public Adherent getAdherentFromId(String id) {
		
		AdherentPersistence service = PersistenceServiceProvider.getService(AdherentPersistence.class);
		Adherent adherent = service.load(id);
		
		return adherent;
	}

	/**
	 * Check si les champs sont remplis
	 */
	@Override
	public boolean champsValide(String id, String mdp) {
		return (id != null && !id.isEmpty() && mdp != null && !mdp.isEmpty());
	}

	/**
	 * Check si le mot de passe entré est valide
	 */
	@Override
	public boolean motDePasseOK(Adherent adherent, String mdp) {
		return (adherent != null && mdp != null && mdp.equals(adherent.getMotdepasse()));
	}

}
