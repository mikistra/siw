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

public class SqlServerDAOFactory extends DAOFactory {
	
	private static DataSource datasource;
	
	static{
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			datasource= new DataSource("jdbc:sqlserver://localhost:1433;databaseName=fanta", "sa", "sa");
			
		} catch (Exception e) {
			System.err.println("SqlServerDAOFactory.class: failed to load sql server JDBC driver\n"+e);
			e.printStackTrace();
		}
	}

	@Override
	public GiocatoreDAO getGiocatoreDAO() {
      return new GiocatoreDaoJDBC(datasource);
		
	}

	@Override
	public UtenteDAO getUtenteDAO() {
		return new UtenteDaoJDBC(datasource);
	}

	@Override
	public LegaDAO getLegaDAO() {
		return  new LegaDaoJDBC(datasource);
	}

	@Override
	public SquadraDAO getSquadraDAO() {
		return new SquadraDaoJDBC(datasource);
	}

	@Override
	public GiornataDAO getGiornataDAO() {
		return new GiornataDaoJDBC(datasource);
	}

	@Override
	public FormazioneDAO getFormazioneDAO() {
		return new FormazioneDaoJDBC(datasource);
	}

	@Override
	public VotoDAO getVotoDAO() {
		return new VotoDaoJDBC(datasource);
	}

	@Override
	public CredenzialiDAO getCredenzialiDAO() {
		return new CredenzialiDaoJDBC(datasource);
	}

	@Override
	public RisultatoDAO getRisultatoDAO() {
		return new RisultatoDaoJDBC(datasource);
	}

	@Override
	public RankDAO getRankDAO() {
		return new RankDaoJDBC(datasource);
	}

}
