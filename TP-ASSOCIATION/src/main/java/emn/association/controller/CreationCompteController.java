package emn.association.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emn.association.bean.Adherent;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.AdherentPersistence;
import emn.association.services.impl.CreationCompteService;
import emn.association.services.interfaces.ICreationCompteService;
import emn.association.utils.ConstantUtils;
import emn.association.utils.MessageUtils;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class CreationCompteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICreationCompteService serviceCreationCompte;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationCompteController() {
		this.serviceCreationCompte = new CreationCompteService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher(ConstantUtils.PATH_TO_FORM);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher(ConstantUtils.PATH_TO_FORM);
		// Erreur formulaire
		if (!verifierChampRempli(request)) {
			request.setAttribute(ConstantUtils.ATTRIBUT_ERREUR, MessageUtils.CHAMP_OBLIGATOIRES);
			rd.forward(request, response);
		} else if (!verifierMotDePasseIndentique(request)) {
			request.setAttribute(ConstantUtils.ATTRIBUT_ERREUR, MessageUtils.MOTS_DE_PASSE_DIFFERENT);
			rd.forward(request, response);
		} else {
			// Ajout en base
			AdherentPersistence serviceAdherent = PersistenceServiceProvider.getService(AdherentPersistence.class);
			Adherent adherent = new Adherent();
			adherent.setIdentifiant(request.getParameter(ConstantUtils.ATTRIBUT_IDENTIFIANT));
			adherent.setCodepostal(request.getParameter(ConstantUtils.ATTRIBUT_CODE_POSTAL));
			adherent.setMotdepasse(request.getParameter(ConstantUtils.ATTRIBUT_PASSE));
			adherent.setNomdefamille(request.getParameter(ConstantUtils.ATTRIBUT_NOM_FAMILLE));
			adherent.setPays(request.getParameter(ConstantUtils.ATTRIBUT_PAYS));
			adherent.setPrenom(request.getParameter(ConstantUtils.ATTRIBUT_PRENOM));
			adherent.setRue(request.getParameter(ConstantUtils.ATTRIBUT_ADRESSE));
			adherent.setVille(request.getParameter(ConstantUtils.ATTRIBUT_VILLE));
			serviceAdherent.save(adherent);

			// Redirection
			response.sendRedirect(getServletContext().getContextPath() + ConstantUtils.PATH_TO_LOGIN_REDIRECT);

		}
	}

	/**
	 * Vérifie que les champs obligatoires ont bien été saisis.
	 * 
	 * @param request
	 * @return
	 */
	private boolean verifierChampRempli(HttpServletRequest request) {
		return this.serviceCreationCompte.verifierChampRempli(request.getParameter(ConstantUtils.ATTRIBUT_IDENTIFIANT),
				request.getParameter(ConstantUtils.ATTRIBUT_PASSE), request.getParameter(ConstantUtils.ATTRIBUT_PASSE_CONFIRMATION),
				request.getParameter(ConstantUtils.ATTRIBUT_NOM_FAMILLE), request.getParameter(ConstantUtils.ATTRIBUT_PRENOM));
	}

	/**
	 * Vérifie que les mots de passes sont identiquess
	 * 
	 * @param request
	 * @return
	 */
	private boolean verifierMotDePasseIndentique(HttpServletRequest request) {
		return this.serviceCreationCompte.verifierMotDePasseIdentique(request.getParameter(ConstantUtils.ATTRIBUT_PASSE),
				request.getParameter(ConstantUtils.ATTRIBUT_PASSE_CONFIRMATION));
	}
}
