package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Giocatore;
import model.Lega;
import service.LegheUtility;
import service.SquadraUtility;

/**
 * Servlet implementation class SquadraServlet
 */
@WebServlet("/SquadraServlet")
public class SquadraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SquadraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String nextPage = null;
		PrintWriter out= response.getWriter();
		LegheUtility legheutility= new LegheUtility();
		SquadraUtility squadrautility = new SquadraUtility();
		

		switch(action)
		{
		case "getgiornate":{
			
			 String lega= request.getParameter("lega");
			 
			 int lid= legheutility.getIdLega(lega);
			 
			int ng=squadrautility.getGiornateGiocate(lid);
						
			response.setContentType("text/html");
			out.println(ng);
		   return;
		}//getgiornate
		case "pagsquadra":{
						
			nextPage="/jsp/squadra.jsp";
			
			String nsquadra = request.getParameter("nsquadra");
			
			Lega lega= squadrautility.legaAppartenente(nsquadra);
			
			request.setAttribute("nsquadra", nsquadra);
			request.setAttribute("nlega", lega.getNomelega());
			//controllare user app
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			return;
		}
		case "getgiornatenc":{
			
			 String lega= request.getParameter("lega");
			 int lid= legheutility.getIdLega(lega);
			 
			 List<Integer> listagiornate = squadrautility.getGiornateNonCalcolate(lid);
			 Gson gson=new Gson();
			 String listjson= gson.toJson(listagiornate);
			response.setContentType("application/json");

			out.println(listjson);
		   return;
		}//getgiornate senza formazione
		case "getmysquadra":{
			
			 String lega= request.getParameter("lega");
			 String user=(String)request.getSession().getAttribute("loggeduser");
			
			 List<Giocatore> lista = squadrautility.getMySquadra(lega, user);
			 
			 	Gson gson=new Gson();
				String listajson= gson.toJson(lista);
				response.setContentType("application/json");
				out.println(listajson);
			 
		   return;
		}//getmyteam
		case "insformazione":{
			
			 String lega= request.getParameter("lega");
			 String user=(String)request.getSession().getAttribute("loggeduser");
			 String squadra=request.getParameter("squadra");
			 int g= Integer.parseInt(request.getParameter("giornata"));
			 
			 String ris=request.getParameter("riserve");
			 
			 Type list= new TypeToken<List<Integer> >(){}.getType();
			 List<Integer> riserve = new Gson().fromJson(ris, list );
			 
			response.setContentType("text/html");

			int result=squadrautility.insFormazione(user, lega, squadra, g, riserve);
			
			 out.println(result);
			///////////////
			 
		   return;
		}//getmyteam
		
		}//switch
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
