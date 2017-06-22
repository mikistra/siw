package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Rank;
import model.Risultato;
import service.AccountUtility;
import service.LegheUtility;
import service.ScoreUtility;
import service.SquadraUtility;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
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
		ScoreUtility scoreutility = new ScoreUtility();
		AccountUtility accountutility = new AccountUtility();

		switch(action)
		{
		case "risgiornata":{
			
			String lega=request.getParameter("lega");
			int ngiornata = Integer.parseInt(request.getParameter("giornata"));
			List<Risultato> risultati = scoreutility.risGiornLega(lega, ngiornata);
			
			Gson gson=new Gson();
			String risjson= gson.toJson(risultati);
			response.setContentType("application/json");
			out.println(risjson);
			return;			
		}
		case "getclassifica":{
			
			String lega=request.getParameter("lega");

			List<Rank> classifica = scoreutility.getClassifica(lega);
			
			Gson gson=new Gson();
			
			
			String jsonclass= gson.toJson(classifica);
			
			response.setContentType("application/json");
			out.println(jsonclass);
			return;			
		}
		case "checkv":{
			
			int giornata=Integer.parseInt(request.getParameter("giornata"));
			
			response.setContentType("text/html");
			
			boolean disp = scoreutility.votiDisponibli(giornata);
			if(disp)			
			out.println(1);
			else
			out.println(0);	
			
			return;			
		}
		case "calcolag":{
			
			int idgiornata=Integer.parseInt(request.getParameter("giornata"));
			int idlega=Integer.parseInt(request.getParameter("lega"));
			
			scoreutility.calcolagiornata(idlega, idgiornata);
			response.setContentType("text/html");
		
			out.println(1);	
			
			return;			
		}
		
		
		
		}//switch
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
