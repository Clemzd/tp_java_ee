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
import emn.association.services.impl.LoginService;
import emn.association.services.interfaces.ILoginService;
import emn.association.utils.ConstantesUtils;
import emn.association.utils.MessageUtils;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = {"/"})
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
		rd = getServletContext().getRequestDispatcher(ConstantesUtils.PATH_TO_LOGIN);
		rd.forward(request, response);

		HttpSession session = request.getSession();
		String deco = request.getParameter(ConstantesUtils.ATTRIBUT_DECONNECTION);
		if(deco!= null && ConstantesUtils.TRUE.equals(deco)){
			session.invalidate();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		ILoginService loginService = new LoginService();		
		HttpSession session = request.getSession();

		String id = request.getParameter(ConstantesUtils.ATTRIBUT_ID);
		String mdp = request.getParameter(ConstantesUtils.ATTRIBUT_PWD);
		String deco = request.getParameter(ConstantesUtils.ATTRIBUT_DECONNECTION);

		if(deco!= null && ConstantesUtils.TRUE.equals(deco)){
			session.removeAttribute(ConstantesUtils.ATTRIBUT_ADHERENT);
		}
		
		if (loginService.champsValide(id, mdp)) {
			
			Adherent adherent = loginService.getAdherentFromId(id);
			
			if (loginService.motDePasseOK(adherent, mdp)) {
				// Stockage du nom de l'adherent s'etant connecte
				session.setAttribute(ConstantesUtils.ATTRIBUT_ADHERENT, adherent.getIdentifiant());

				rd = getServletContext().getRequestDispatcher(ConstantesUtils.PATH_TO_ACCUEIL);
				rd.forward(request, response);
			} else {
				request.setAttribute(ConstantesUtils.ATTRIBUT_ERREUR, MessageUtils.WRONG_ID_OR_PWD);
				rd = getServletContext().getRequestDispatcher(ConstantesUtils.PATH_TO_LOGIN);
				rd.forward(request, response);
			}
		} else {
			request.setAttribute(ConstantesUtils.ATTRIBUT_ERREUR, MessageUtils.NO_ID_OR_PWD);
			rd = getServletContext().getRequestDispatcher(ConstantesUtils.PATH_TO_LOGIN);
			rd.forward(request, response);
		}
	}
}
