package service;

import model.Credenziali;
import model.Utente;
import persistence.DAOFactory;
import persistenceDAO.CredenzialiDAO;
import persistenceDAO.UtenteDAO;

public class AccountUtility {
	
	private DAOFactory factory;
	private UtenteDAO utentedao;
	private CredenzialiDAO credenzialidao;

	
	public AccountUtility(){
		
		this.factory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
		this.utentedao = this.factory.getUtenteDAO();
		this.credenzialidao = this.factory.getCredenzialiDAO();

	}
	
	public Utente login(String user, String pass)
	{
		Utente u=null;
		int id=credenzialidao.login(user, pass);
		
		if(id!=-1)
		{
			u= utentedao.getUtentebyId(id);
		}	
		
		return u;
	}
	
	public boolean validaDati(Utente utente) 
	{
		if(utente.getNome().isEmpty()||utente.getCognome().isEmpty()||utente.getUsername().isEmpty()||utente.getEmail().isEmpty())
			return false;
		
		if(utente.getEmail().chars().filter(num -> num == '@').count()!=1)
				return false;
				
		return true;
	}
	
	public boolean registra(Utente u, Credenziali cred)
	{
		int i= utentedao.addUtente(u);
		
		if(i==-1)
			return false;
		
		cred.setUtente(i);
		
		credenzialidao.addCredenziali(cred);
		
		return true;
	}
	
	public boolean validaCredenziali(Credenziali cred, String pswrep)
	{
		if(cred.getPassword().isEmpty())
			return false;
		
		if(!cred.getPassword().equals(pswrep))
			return false;
		
		
		return true;
	}
	
	public boolean userDisponibile(String user)
	{
		int res=utentedao.getUtentebyUser(user);
		
		if(res==-1)
			return true;
		
		return false;
	}
	
	
	public int userId(String user)
	{
		return utentedao.getUtentebyUser(user);
	
	}
	
}
