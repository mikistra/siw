package service;

import java.util.List;

import javafx.util.Pair;
import model.Giocatore;
import model.Lega;
import model.Squadra;
import persistence.DAOFactory;
import persistenceDAO.GiocatoreDAO;
import persistenceDAO.LegaDAO;
import persistenceDAO.SquadraDAO;
import persistenceDAO.UtenteDAO;

public class LegheUtility {

	private DAOFactory factory;
	private UtenteDAO utentedao;
	private LegaDAO legadao;
	private GiocatoreDAO giocatoredao;
	private SquadraDAO squadradao;
	
	public LegheUtility()
	{
		this.factory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
		this.utentedao = this.factory.getUtenteDAO();
		this.legadao=this.factory.getLegaDAO();
		this.giocatoredao=this.factory.getGiocatoreDAO();
		this.squadradao=this.factory.getSquadraDAO();
	}
	
	public int creaLega(String user, String lega)
	{
		if( legadao.getLegaByName(lega) !=-1 )
			return -1;    //lega esistente
		
		int utente= utentedao.getUtentebyUser(user);
		
		Lega l= new Lega(0, lega, utente);
		
		return legadao.addLega(l);
	}
	
	
	public List<Lega> legheAmministrate(String user)
	{
		int u=utentedao.getUtentebyUser(user);
		
		return legadao.getLeghebyUser(u);
	}
	
	
	public List<Pair<String,String> > leghePartecip(String user)
	{
		int u=utentedao.getUtentebyUser(user);
		return squadradao.getPorprieSquadre(u);
	}
	
	public List<Giocatore> giocatoriDisponibili(String r, int lega)
	{
		return giocatoredao.getGiocSvincolatoByRuolo(r, lega);
	}
	
	public int creaSquadra(List<Squadra> squadra)
	{
		if(squadra.isEmpty() || squadra.size()!=16)
			return 2;
		
		squadradao.addSquadraFull(squadra);
		return 0;
	}
	
	public boolean squadraEsistente(String s)
	{
		if(squadradao.getSquadraByNome(s).isEmpty())
			return false;
		
		return true;
	}
	
	public boolean partecipante(int u, int l)
	{
		if(squadradao.getSquadra(u, l).isEmpty())
			return false;
		
		return true;
	}
	
	public int getIdLega(String l)
	{
		return legadao.getLegaByName(l);
		
	}
}
