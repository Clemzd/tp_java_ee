package td.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forward
 */
@WebServlet("/Forward")
public class Forward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Forward() {
		super();
		// TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		String nom = request.getParameter("page");
		if (nom.equals("1")) {
			rd = getServletContext().getRequestDispatcher("/page1.html");
		} else if (nom.equals("2")) {
			rd = getServletContext().getRequestDispatcher("/page2.html");
		} else if (nom.equals("hello")) {
			rd = getServletContext().getRequestDispatcher("/Hello");
		} else {
			rd = null;
		}
		if (rd != null) {
			rd.forward(request, response);
		}
	}
}
