package persistence;

import persistenceDAO.CredenzialiDAO;
import persistenceDAO.FormazioneDAO;
import persistenceDAO.GiocatoreDAO;
import persistenceDAO.GiornataDAO;
import persistenceDAO.LegaDAO;
import persistenceDAO.RankDAO;
import persistenceDAO.RisultatoDAO;
import persistenceDAO.SquadraDAO;
import persistenceDAO.UtenteDAO;
import persistenceDAO.VotoDAO;

public abstract class DAOFactory {


	
	public static final int SQLSERVER = 1;
	

	public static final int POSTGRESQL = 2;

	public static final int MYSQL = 3;
	
	

	public static DAOFactory getDAOFactory(int which) {
		switch ( which ) {
		
		case SQLSERVER:
			return new SqlServerDAOFactory();
		case POSTGRESQL:
			return null;
		case MYSQL:
		//	return new MySqlDAOFactory();
		default:
			return null;
		}
	}
	
	
	
	// metodi per l'accesso ai DAO
	
	public abstract GiocatoreDAO getGiocatoreDAO();
	public abstract UtenteDAO getUtenteDAO();
	public abstract LegaDAO getLegaDAO();
	public abstract SquadraDAO getSquadraDAO();
	public abstract GiornataDAO getGiornataDAO();
	public abstract FormazioneDAO getFormazioneDAO();	
	public abstract VotoDAO getVotoDAO();
	public abstract CredenzialiDAO getCredenzialiDAO();
	public abstract RisultatoDAO getRisultatoDAO();
	public abstract RankDAO getRankDAO();
}
