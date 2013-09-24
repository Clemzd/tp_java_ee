package td.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloParam
 */
@WebServlet(urlPatterns = { "/HelloParam/*", "/HelloParam/" }, name = "Bonjour avec le paramètre", 
initParams = @WebInitParam(name = "lang", value = "en"))
public class HelloParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloParam() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(request.getContextPath());
		String nom = request.getParameter("nom");
		String paramNom = request.getParameter("lang")==null ? "" : request.getParameter("lang");
		if (this.getInitParameter("lang").equals("fr") || paramNom.equals("fr")) {
			out.println("<h1>Salut ca va " + nom + " ?</h1>");
		} else {
			out.println("<h1>Hey what's up " + nom + " ?</h1>");
		}
	}

}
