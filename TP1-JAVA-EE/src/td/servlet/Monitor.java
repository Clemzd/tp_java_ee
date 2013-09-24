package td.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/*")
public class Monitor implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException, ServletException {
		long depart = System.currentTimeMillis();
		// execution de la requête
		filterChain.doFilter(arg0, arg1);
		System.out.println("Temps d'éxécution de la requête = " + (System.currentTimeMillis() - depart) + " ms");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// nothing to do
	}
}	
