package service;

import java.util.ArrayList;
import java.util.List;

import model.Formazione;
import model.Rank;
import model.Risultato;
import model.Voto;
import persistence.DAOFactory;
import persistenceDAO.FormazioneDAO;
import persistenceDAO.GiocatoreDAO;
import persistenceDAO.LegaDAO;
import persistenceDAO.RankDAO;
import persistenceDAO.RisultatoDAO;
import persistenceDAO.SquadraDAO;
import persistenceDAO.VotoDAO;
import sun.net.idn.Punycode;

public class ScoreUtility {
	
	private DAOFactory factory;
	private LegaDAO legadao;
	private GiocatoreDAO giocatoredao;
	private SquadraDAO squadradao;
	private FormazioneDAO formazionedao;
	private RisultatoDAO risultatodao;
	private RankDAO rankdao;
	private VotoDAO votodao;

	
	
	public ScoreUtility()
	{
		this.factory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
		this.formazionedao = this.factory.getFormazioneDAO();
		this.legadao=this.factory.getLegaDAO();
		this.giocatoredao=this.factory.getGiocatoreDAO();
		this.squadradao=this.factory.getSquadraDAO();
		this.risultatodao=this.factory.getRisultatoDAO();
		this.rankdao=this.factory.getRankDAO();
		this.votodao=this.factory.getVotoDAO();
	}
	
	
	public List<Risultato> risGiornLega(String l, int g)
	{
		int lid=legadao.getLegaByName(l);
		
		return risultatodao.getRisultatiLega(lid, g);
	}
	
	public List<Rank> getClassifica(String le)
	{
		int lid=legadao.getLegaByName(le);
		return rankdao.getClassifica(lid);
	}
	
	public boolean votiDisponibli(int g)
	{
		return votodao.dispoibile(g);
		
	}
	
	public float punteggioGiocatoreGiornata(int giocatore, int giornata)
	{
		Voto v= votodao.getVoto(giocatore, giornata);
		float score=0;
		
		score+=v.getVoto();
		score+= (v.getGf()*3);
		score+= (v.getGs()*-1);
		score+= (v.getAutogoal()*-2);
		score+=(v.getAssist());
		score+=(v.getAmmonizione()*-0.5);
		score+=(v.getEspulsione()*-1);
		
		return score;
	}
	
	public void calcolagiornata(int lega, int giornata)
	{
		List<String> squadre = squadradao.getSquadreLega(lega);
		
		for (String squa : squadre) {
					
		    List<Formazione> formazione = formazionedao.getFormazionebySquadra(squa, lega, giornata);
		    	
		    	float tot=0;		    	
		    	float vuoti=0;
		    	List<Float> ris= new ArrayList<Float>();
		    	
		    	
		          for (Formazione f : formazione) {			
		        	  float score=punteggioGiocatoreGiornata(f.getGiocatore(), giornata);
		        	  
		               if(f.getRiserva()==1)	  
		               {
		            	   ris.add(score);
		               }
		               else
		               {
		            	    if(score==0 && vuoti<3)
		            	    	vuoti++;
		            	    
		            	    tot+=score;
		               }		               
		               
		         }//each t formaz
		
		     while(vuoti>0 && !ris.isEmpty())
		      { tot+= ris.remove(0);
		         vuoti--;
		      }
		     
		     Risultato risultato= new Risultato(lega, giornata, squa, tot);
		     risultatodao.addRisultato(risultato);
		}//each squadra
		
	}
	
	
	public void inserisciVoti(List<Voto> voti)
	{
		votodao.addVoti(voti);		
	}
	
}
