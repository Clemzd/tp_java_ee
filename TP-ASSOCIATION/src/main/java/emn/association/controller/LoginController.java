package emn.association.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emn.association.bean.Adherent;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.AdherentPersistence;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/jsp/core/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String mdp = request.getParameter("mdp");

		if (id != null && !id.isEmpty() && mdp != null && !mdp.isEmpty()) {
			AdherentPersistence service = PersistenceServiceProvider.getService(AdherentPersistence.class);

			Adherent adherent = service.load(id);

			if (adherent != null && mdp != null && mdp.equals(adherent.getMotdepasse())) {
				// Stockage du nom de l'adherent s'etant connecte
				session.setAttribute("adherent", adherent.getPrenom());

				rd = getServletContext().getRequestDispatcher("/jsp/core/accueil.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("error", "Identifiant et/ou mot de passe incorrect.");
				rd = getServletContext().getRequestDispatcher("/jsp/core/login.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("error", "Veuillez indiquer un identifiant et un mot de passe.");
			rd = getServletContext().getRequestDispatcher("/jsp/core/login.jsp");
			rd.forward(request, response);
		}
	}
}
