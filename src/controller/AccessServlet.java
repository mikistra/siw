package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Credenziali;
import model.Utente;
import service.AccountUtility;

/**
 * Servlet implementation class AccessServlet
 */
@WebServlet("/AccessServlet")
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("action").equals("logout"))
			{
				request.getSession().invalidate();
				//nextPage = "/index.jsp";
				response.sendRedirect(request.getContextPath());
				return;
			}
		 else if(request.getParameter("action").equals("loginpage"))
		 {
			 String nextPage="/jsp/login.jsp";

			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			 dispatcher.forward(request, response);
			 return;

		 }
		 else if(request.getParameter("action").equals("adminvoti"))
		 {
			 String nextPage="/jsp/adminVoti.jsp";

			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			 dispatcher.forward(request, response);
			 return;

		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage=null;
		
		AccountUtility accountutility= new AccountUtility();
	
		PrintWriter write= response.getWriter();

		
		if(request.getParameter("action").equals("login"))
		{
		Utente utente= accountutility.login(request.getParameter("uname"), request.getParameter("psw"));
		
		
		if(utente!=null)
		 {
		 	HttpSession session= request.getSession(true);
			session.setAttribute("loggeduser", utente.getUsername());
			session.setMaxInactiveInterval(-1);
			nextPage="/jsp/loggedHome.jsp";

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			return;
	    	}
		else
		 {
			nextPage="/jsp/login.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			
			request.setAttribute("wronglog", "wrong");
			
			dispatcher.forward(request, response);
			return;
		 }
		}
		else if(request.getParameter("action").equals("register"))
		{
			Utente utente= new Utente();			
			
			utente.setNome(request.getParameter("name"));
			utente.setCognome(request.getParameter("surname"));
			utente.setUsername(request.getParameter("usr"));
			utente.setEmail(request.getParameter("mail"));
			
				
			if(!accountutility.validaDati(utente))
				{
				nextPage="/jsp/login.jsp"; 
				
				request.setAttribute("wrongreg", "controlla i dati inseriti");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
				dispatcher.forward(request, response);
				return;
				}
			
	    	Credenziali credenziali=new Credenziali();
	
	    	credenziali.setUsername(utente.getUsername());
			credenziali.setPassword(request.getParameter("psw"));
	
			if(!accountutility.validaCredenziali(credenziali, request.getParameter("pswrepeat"))) 
				{
				nextPage="/jsp/login.jsp"; 
				
				request.setAttribute("wrongreg", "errore campi password");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
				dispatcher.forward(request, response);
				return;
				}
				
			boolean done=accountutility.registra(utente, credenziali);
			
			if(!done)
				{
				nextPage="/jsp/login.jsp";  
				
				request.setAttribute("wrongreg", "utente gia' registrato");

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
				dispatcher.forward(request, response);
				return;
				}
			else
				{
				HttpSession session= request.getSession(true);
				session.setAttribute("loggeduser", utente.getUsername());
				session.setMaxInactiveInterval(-1);
				
				nextPage="/jsp/loggedHome.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
				dispatcher.forward(request, response);
				return;
				}
			
		}//fine register
		else if(request.getParameter("action").equals("logout"))
		{
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath());
			return;
		}
		else if(request.getParameter("action").equals("checkusername"))
		{
			String pacchetto = request.getParameter("datapkt");
			
			if (pacchetto != null) {

				JsonObject jsonobject= new Gson().fromJson(pacchetto, JsonObject.class);
				String usern=jsonobject.get("useridea").getAsString(); 
				
				response.setContentType("text/html");
				
				if(accountutility.userDisponibile(usern))
				{
					response.getWriter().print(1);
					return;
				}
				else	
				{
					response.getWriter().print(0);
					return;
				}

			}
			
			
		}//checkuser
		else if(request.getParameter("action").equals("adminlogin"))
		{
	
			String usr =request.getParameter("usr");
			String psw = request.getParameter("psw");
			
			if(usr.equals("admin") && psw.equals("admin"))
			   nextPage="/jsp/adminVoti.jsp";
			else
			{
				nextPage="/jsp/home.jsp";
			request.setAttribute("wronglogin", "wrong");
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			
			return;
			
		}

	}
	
}
