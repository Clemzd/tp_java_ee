package td.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cadre
 */
@WebServlet("/Cadre")
public class Cadre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadre() {
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
		Random r = new Random();
		int random = 0 + r.nextInt(10 - 0);
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("random", random);
		
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		String paramContenu = request.getParameter("contenu");
		if("1".equals(paramContenu)){
			rd = getServletContext().getNamedDispatcher("Contenu");
		}else if("2".equals(paramContenu)){
			rd = getServletContext().getNamedDispatcher("Contenu");
		}else{
			rd = null;
		}
		if ( rd != null ) {      
			rd.include(request, response);
		}
		out.println("</body></html>");
		
	}

}
