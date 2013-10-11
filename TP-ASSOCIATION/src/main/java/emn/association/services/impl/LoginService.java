package emn.association.services.impl;

import emn.association.bean.Adherent;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.AdherentPersistence;
import emn.association.services.interfaces.ILoginService;

public class LoginService implements ILoginService {

	@Override
	public Adherent getAdherentFromId(String id) {
		
		AdherentPersistence service = PersistenceServiceProvider.getService(AdherentPersistence.class);
		Adherent adherent = service.load(id);
		
		return adherent;
	}

}
