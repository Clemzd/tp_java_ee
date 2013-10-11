package emn.association.services.impl;

import javax.servlet.http.HttpServletRequest;

import emn.association.services.interfaces.ICreationCompteService;

public class CreationCompteService implements ICreationCompteService {

	@Override
	public boolean verifierChampRempli(HttpServletRequest request) {
		return (("").equals(request.getParameter("identifiant")) || ("").equals(request.getParameter("mot_de_passe"))
				|| ("").equals(request.getParameter("mot_de_passe_confirmation")) || ("").equals(request.getParameter("nom_famille")) || ("")
					.equals(request.getParameter("prenom")));
	}

	@Override
	public boolean verifierMotDePasseIndentique(HttpServletRequest request) {
		return request.getParameter("mot_de_passe").equals(request.getParameter("mot_de_passe_confirmation"));
	}
	

}
