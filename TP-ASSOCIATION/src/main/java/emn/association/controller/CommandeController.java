package emn.association.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;

import antlr.StringUtils;
import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.ArticlePersistence;
import emn.association.services.impl.CommandeService;
import emn.association.services.interfaces.ICommandeService;
import emn.association.services.interfaces.ICreationCompteService;
import emn.association.utils.ConstantesUtils;
import emn.association.utils.MessageUtils;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Commande")
public class CommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICommandeService serviceCommande;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandeController() {
		this.serviceCommande = new CommandeService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArticlePersistence serviceArticle = PersistenceServiceProvider
				.getService(ArticlePersistence.class);
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher(
				ConstantesUtils.PATH_TO_COMMAND);
		HttpSession session = request.getSession();

		session.setAttribute(ConstantesUtils.ATTRIBUT_COMMANDE_KO, "");

		// Mise à jour commande
		int quantite = 0;
		if (request.getParameter(ConstantesUtils.ATTRIBUT_QUANTITE) != null
				&& !request.getParameter(ConstantesUtils.ATTRIBUT_QUANTITE)
						.isEmpty()) {
			quantite = Integer.parseInt(request
					.getParameter(ConstantesUtils.ATTRIBUT_QUANTITE));
		}

		if (quantite > 0) {
			// Mise à jour commande
			String id = request
					.getParameter(ConstantesUtils.ATTRIBUT_CODE_ARTICLE);
			if (id != null && !id.isEmpty()) {
				Article nouvArt = serviceArticle.load(request
						.getParameter(ConstantesUtils.ATTRIBUT_CODE_ARTICLE));

				ArrayList<ArticlePanier> panier = new ArrayList<ArticlePanier>();
				panier = (ArrayList<ArticlePanier>) session
						.getAttribute(ConstantesUtils.ATTRIBUT_PANIER);
				if (panier != null) {
					// Si le panier est déjà créé on le met à jour
					serviceCommande.miseAJourPanier(panier, nouvArt, quantite);
				} else {
					// On crée le panier en lui ajoutant l'article
					panier = new ArrayList<ArticlePanier>();
					panier.add(new ArticlePanier(nouvArt, quantite));
					session.setAttribute(ConstantesUtils.ATTRIBUT_PANIER,
							panier);
				}
			}
		}

		// Annulation de commande
		String estAnnuleCommande = request
				.getParameter(ConstantesUtils.ATTRIBUT_ANNULER_COMMANDE);
		if (estAnnuleCommande != null
				&& ConstantesUtils.TRUE.equals(estAnnuleCommande)) {
			ArrayList<ArticlePanier> panier = new ArrayList<ArticlePanier>();
			panier = (ArrayList<ArticlePanier>) session
					.getAttribute(ConstantesUtils.ATTRIBUT_PANIER);
			if (panier != null) {
				// Si le panier existe, on le vide
				serviceCommande.suppressionPanier(panier);
			}
		}

		// Validation de commande
		String estValideCommande = request
				.getParameter(ConstantesUtils.ATTRIBUT_VALIDER);
		if (estValideCommande != null
				&& ConstantesUtils.TRUE.equals(estValideCommande)) {
			ArrayList<ArticlePanier> panier = new ArrayList<ArticlePanier>();
			panier = (ArrayList<ArticlePanier>) session
					.getAttribute(ConstantesUtils.ATTRIBUT_PANIER);
			if (panier != null) {
				// Si le panier existe, on le vide
				if (!serviceCommande.effectuerAchat(panier)) {
					session.setAttribute(ConstantesUtils.ATTRIBUT_COMMANDE_KO,
							MessageUtils.COMMANDE_IMPOSSIBLE);
					rd.forward(request, response);
				} else {
					// Redirection
					response.sendRedirect(getServletContext().getContextPath()
							+ ConstantesUtils.PATH_TO_MERCI_REDIRECT);
					session.setAttribute(ConstantesUtils.ATTRIBUT_COMMANDE_KO,
							"");
				}
			}
		} else {
			rd.forward(request, response);
		}
	}
}
