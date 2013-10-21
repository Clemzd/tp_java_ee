package emn.association.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import emn.association.utils.ConstantesUtils;

/**
 * Servlet Filter implementation class NonConnecteFilter
 */
@WebFilter(urlPatterns={"/Accueil","/Catalogue","/Commande","/Merci"})
public class InterditFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public InterditFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requete = (HttpServletRequest) request;
		HttpSession session = requete.getSession();
		if (session.getAttribute(ConstantesUtils.ATTRIBUT_ADHERENT) == null) {
			request.getRequestDispatcher(ConstantesUtils.PATH_TO_LOGIN_REDIRECT).forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
