package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter(urlPatterns = {"/jsp/*"}, description = "Direct access Filter")
public class MyFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		
			HttpServletRequest request = (HttpServletRequest) req;
	       
			HttpServletResponse response = (HttpServletResponse) res;
	   

			response.sendRedirect(request.getContextPath());
		
			chain.doFilter(req, res);
			
	}

	@Override
	public void destroy() {
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
