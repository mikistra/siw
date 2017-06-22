package service;

import java.util.ArrayList;
import java.util.List;

import model.Formazione;
import model.Giocatore;
import model.Giornata;
import model.Lega;
import model.Squadra;
import persistence.DAOFactory;
import persistenceDAO.FormazioneDAO;
import persistenceDAO.GiocatoreDAO;
import persistenceDAO.GiornataDAO;
import persistenceDAO.LegaDAO;
import persistenceDAO.RisultatoDAO;
import persistenceDAO.SquadraDAO;
import persistenceDAO.UtenteDAO;

public class SquadraUtility {

		private DAOFactory factory;
		private UtenteDAO utentedao;
		private LegaDAO legadao;
		private GiocatoreDAO giocatoredao;
		private SquadraDAO squadradao;
		private RisultatoDAO risultatodao;
		private GiornataDAO giornatadao;
		private FormazioneDAO formazionedao;
		
		public SquadraUtility()
		{
			this.factory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
			this.utentedao = this.factory.getUtenteDAO();
			this.legadao=this.factory.getLegaDAO();
			this.giocatoredao=this.factory.getGiocatoreDAO();
			this.squadradao=this.factory.getSquadraDAO();
			this.risultatodao=this.factory.getRisultatoDAO();
			this.giornatadao=this.factory.getGiornataDAO();
			this.formazionedao=this.factory.getFormazioneDAO();
		}
		
		public int getGiornateGiocate(int l)
		{
			return  risultatodao.giornateLega(l);
		}
		
		public List<Integer> getGiornateNonCalcolate(int l)
		{
			List<Giornata> gnc= giornatadao.getGiornateNC(l);
			List<Integer> lista = new ArrayList<Integer>();
			
			for (Giornata giornata : gnc) {
				lista.add(giornata.getIdgiornata());
			}
			
			return lista;
		}
		
		public Lega legaAppartenente(String s)
		{
			return legadao.getLegaBySquadra(s);
		}
		
		public List<Giocatore> getMySquadra(String lega, String user)
		{
			int idl= legadao.getLegaByName(lega);
			int idu= utentedao.getUtentebyUser(user);
			
			return giocatoredao.getGiocatoriSquadra(idu, idl);
			
		}
		
		public int insFormazione(String user, String lega, String ns, int g, List<Integer> ris)
		{
			
			int u=utentedao.getUtentebyUser(user);
			int l=legadao.getLegaByName(lega);
			
			List<Squadra> squadra= squadradao.getSquadra(u, l);
			List<Formazione> formazione=new ArrayList<Formazione>();
			
			int r=0;
			
			for (Squadra squa : squadra) {
				
			   Formazione f= new Formazione();
			   f.setUtente(u);
			   f.setLega(l);
			   f.setNomesquadra(ns);
			   f.setGiocatore(squa.getGiocatore());
			   f.setGiornata(g);
			   
				if(ris.contains(squa.getGiocatore()))
					{
					f.setRiserva(1);
					 r++;
					}
				else
					f.setRiserva(0);
				
				formazione.add(f);
			}
			
			
			if(r!=5)
		 	 return 1; //formazione errata
				
			formazionedao.addFormazioneFull(formazione);
			return 0;
		}
}
