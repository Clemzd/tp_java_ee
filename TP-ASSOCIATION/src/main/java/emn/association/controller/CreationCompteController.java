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

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class CreationCompteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationCompteController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/jsp/core/formulaire_creation_compte.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/jsp/core/formulaire_creation_compte.jsp");
		// Erreur formulaire
		if (verifierChampRempli(request)) {
			request.setAttribute("erreur", "Veuillez remplir tous les champs obligatoires.");
			rd.forward(request, response);
		} else if (verifierMotDePasseIndentique(request)){
			request.setAttribute("erreur", "Les mots de passes doivent être identiques.");
			rd.forward(request, response);
		} else {
			// Ajout en base
			AdherentPersistence serviceAdherent = PersistenceServiceProvider.getService(AdherentPersistence.class);
			Adherent adherent = new Adherent();
			adherent.setIdentifiant(request.getParameter("identifiant"));
			adherent.setCodepostal(request.getParameter("code_postal"));
			adherent.setMotdepasse(request.getParameter("mot_de_passe"));
			adherent.setNomdefamille(request.getParameter("nom_famille"));
			adherent.setPays(request.getParameter("pays"));
			adherent.setPrenom(request.getParameter("prenom"));
			adherent.setRue(request.getParameter("adresse"));
			adherent.setVille(request.getParameter("ville"));
			serviceAdherent.save(adherent);
			
			// Redirection
			rd = getServletContext().getRequestDispatcher("../Login");
			rd.forward(request, response);
		}
	}

	/**
	 * Vérifie que les champs obligatoires ont bien été saisis.
	 * 
	 * @param request
	 * @return
	 */
	private boolean verifierChampRempli(HttpServletRequest request) {
		return (("").equals(request.getParameter("identifiant")) || ("").equals(request.getParameter("mot_de_passe"))
				|| ("").equals(request.getParameter("mot_de_passe_confirmation")) || ("").equals(request.getParameter("nom_famille")) || ("")
					.equals(request.getParameter("prenom")));
	}

	/**
	 * Vérifie que les mots de passes sont identiques.s
	 * 
	 * @param request
	 * @return
	 */
	private boolean verifierMotDePasseIndentique(HttpServletRequest request) {
		return request.getParameter("mot_de_passe").equals(request.getParameter("mot_de_passe_confirmation"));
	}
}
