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
@WebFilter(urlPatterns = {"/jsp/*"}, description = "Session Checker Filter")  //("/MyFilter")
public class MyFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {


	//	HttpServletResponse response = (HttpServletResponse) res;

		//	response.sendRedirect("index.jsp");
		
			HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;

	//	if(request.getSession().getAttribute("loggeduser") == null)
	//		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
			chain.doFilter(req, res);
			
	}

	@Override
	public void destroy() {
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
