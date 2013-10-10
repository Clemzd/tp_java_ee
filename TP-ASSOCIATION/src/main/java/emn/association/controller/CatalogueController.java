package emn.association.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.ArticlePersistence;

/**
 * Servlet implementation class Catalogue
 */
@WebServlet("/Catalogue")
public class CatalogueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogueController() {
		super();
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
		ArticlePersistence service = PersistenceServiceProvider.getService(ArticlePersistence.class);
		request.setAttribute("articles", service.loadAll());
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/jsp/core/liste_articles.jsp");
		rd.forward(request, response);
	}

}
