package emn.association.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;

import emn.association.bean.Article;
import emn.association.bean.ArticlePanier;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.ArticlePersistence;
import emn.association.services.impl.CommandeService;
import emn.association.services.interfaces.ICommandeService;
import emn.association.services.interfaces.ICreationCompteService;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticlePersistence serviceArticle = PersistenceServiceProvider.getService(ArticlePersistence.class);
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/jsp/core/liste_commande.jsp");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("article.code");
		if (id != null && !id.isEmpty()) {
			Article nouvArt = serviceArticle.load(request.getParameter("article.code"));

			ArrayList<ArticlePanier> panier = new ArrayList<ArticlePanier>();
			panier = (ArrayList<ArticlePanier>) session.getAttribute("panier");
			if (panier != null) {
				//Si le panier est déjà créé on le met à jour
				serviceCommande.miseAJourPanier(panier, nouvArt);
			} else {
				// On crée le panier en lui ajoutant l'article
				panier = new ArrayList<ArticlePanier>();
				panier.add(new ArticlePanier(nouvArt, 1));
				session.setAttribute("panier", panier);
			}
		}
		rd.forward(request, response);
	}

}
