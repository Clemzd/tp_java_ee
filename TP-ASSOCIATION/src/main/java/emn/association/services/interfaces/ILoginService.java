package emn.association.services.interfaces;

import emn.association.bean.Adherent;

public interface ILoginService {
	
	public Adherent getAdherentFromId(String id);
	public boolean champsValide(String id, String mdp);
	public boolean motDePasseOK(Adherent adherent, String mdp);

}
