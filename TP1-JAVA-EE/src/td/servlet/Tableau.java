package td.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tableau
 */
@WebServlet(urlPatterns="/Tableau")
public class Tableau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tableau() {
        super();
        // TODO Auto-generated constructor stub
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
		String type = request.getParameter("type");
		PrintWriter out = response.getWriter();
		if(type != null){
			if("html".equals(type)){
				response.setContentType("text/html");
				out.println("<table><tr><td>l1c1</td><td>l1c2</td><tr><td>l2c1</td><td>l2c2</td></tr></table>");
			}else if("csv".equals(type)){
				response.setContentType("application/vnd.ms-excel");
				out.println("l1c1;l1c2;");
				out.println("l2c1;l2c2;");
			}else{
				out.println("Ce type n'existe pas !");
			}
		}else{
			out.println("Vous devez renseigner le type !");
		}
	}
}

