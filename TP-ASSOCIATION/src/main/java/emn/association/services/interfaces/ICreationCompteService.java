package emn.association.services.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface ICreationCompteService {
	
	public boolean verifierChampRempli(HttpServletRequest request);
	public boolean verifierMotDePasseIndentique(HttpServletRequest request);


}
