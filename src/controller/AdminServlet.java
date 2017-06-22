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
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import model.Giocatore;
import model.Lega;
import model.Squadra;
import service.AccountUtility;
import service.LegheUtility;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage=null;
		String action = request.getParameter("action");
		PrintWriter out= response.getWriter();
		
		LegheUtility legheutility= new LegheUtility();
		AccountUtility accountutility= new AccountUtility();

		
		switch(action)
		{
		case "getgiocatori":{
			
			String ruo= request.getParameter("ru");
			int le= Integer.parseInt(request.getParameter("lega"));
			List<Giocatore> gio= legheutility.giocatoriDisponibili(ruo, le);
			
			
			Gson gson=new Gson();
			String lista= gson.toJson(gio);
			response.setContentType("application/json");
			out.println(lista);
						return;
		}
		case "creasquadra":{
		
			response.setContentType("text/html");
			String squadrajson= request.getParameter("newsquadra");
			
			String ouser=request.getParameter("ouser");
			String nomesq=request.getParameter("nomesqua");
			int lega=Integer.parseInt(request.getParameter("legaselez"));
		
						
			TypeToken<List<Giocatore>> token = new TypeToken<List<Giocatore>>(){};
			List<Giocatore> giocatorisquadra = new Gson().fromJson(squadrajson, token.getType());
			
			int usr= accountutility.userId(ouser);

			if(usr==-1)
			{
				out.println(1); //errore user non esistente
				return;
			}
			else if(legheutility.squadraEsistente(nomesq))
			{
				out.println(3);
				return;
			}
			else if(legheutility.partecipante(usr, lega))
			{
				out.println(4);
				return;
			}
			else
			{
				List<Squadra> squadra= new ArrayList<Squadra>();

				for (Giocatore giocatore : giocatorisquadra) {
					squadra.add(new Squadra(usr, lega, giocatore.getCodice(), nomesq));
				}
				
				int res=legheutility.creaSquadra(squadra);
				
				out.println(res);
				return;
			}
		
		}
		
		}//switch
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
