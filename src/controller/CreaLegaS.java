package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LegheUtility;

/**
 * Servlet implementation class CreaLegaS
 */
@WebServlet("/CreaLegaS")
public class CreaLegaS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaLegaS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LegheUtility legheutility= new LegheUtility();

		String nomelega1= request.getParameter("nomelega");
		String user= (String)request.getSession().getAttribute("loggeduser");
		
		String nomelega=nomelega1.trim();
		
		if(nomelega.isEmpty())
		{	response.getWriter().print(2);
			return;
		}
		int r = legheutility.creaLega(user, nomelega);
		
		response.setContentType("text/html");
		
		if(r==-1)
		response.getWriter().print(0);
		else
		response.getWriter().println(1);
		
		return;
     	
		
	}

}
