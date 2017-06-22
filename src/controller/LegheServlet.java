package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.util.Pair;
import model.Lega;
import service.LegheUtility;

/**
 * Servlet implementation class LegheServlet
 */
@WebServlet("/LegheServlet")
public class LegheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LegheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		String nextPage = null;
		LegheUtility legheutility= new LegheUtility();
		

		switch(action)
		{
		case "gocrealega":{
			
			nextPage="/jsp/creaLega.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			return;
			
		   }//crea
		case "goamministra":{
			
			List<Lega> lista= legheutility.legheAmministrate((String) request.getSession().getAttribute("loggeduser"));
			request.getSession().setAttribute("listaleghe", lista);
			
			nextPage="/jsp/amministraLeghe.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			return;
			
		   }//amministra
		case "govisualizza":{
			
			List< Pair <String, String> > lista= legheutility.leghePartecip((String) request.getSession().getAttribute("loggeduser"));
			request.getSession().setAttribute("myleghe", lista);
			
			nextPage="/jsp/visualizzaLeghe.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			return;
			
		   }//visualizza
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
}
