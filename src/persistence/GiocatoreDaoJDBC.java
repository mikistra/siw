package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Giocatore;
import persistenceDAO.GiocatoreDAO;

public class GiocatoreDaoJDBC implements GiocatoreDAO {

	private DataSource datasource;
	
	public  GiocatoreDaoJDBC(DataSource datasource) {
        
		this.datasource=datasource;
	}
	
	@Override
	public Giocatore getGiocatorebyCod(int cod) {
		
		Connection connection= datasource.getConnection();
		
		Giocatore giocatore= new Giocatore();
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM giocatore "
					+ "WHERE codice=?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, cod);
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		{
			giocatore.setCodice(resultset.getInt("codice"));
			giocatore.setNome(resultset.getString("nome"));
			giocatore.setRuolo((resultset.getString("ruolo").charAt(0)));
			giocatore.setClub(resultset.getString("club"));
		}
		
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return giocatore;
	}

	@Override
	public List<Giocatore> getGiocatoreByRuolo(char r) {
		
		Connection connection = datasource.getConnection();
		
		List<Giocatore> giocatori = null;
		
		try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM giocatore "
					+ "WHERE ruolo=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, Character.toString(r));
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				giocatori=new ArrayList<Giocatore>();
			
				do{
					giocatori.add(new Giocatore(resultset.getInt(1),resultset.getString(2),resultset.getString(3).charAt(0),
							resultset.getString(4)));
									
				}while(resultset.next());
			}		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
		return giocatori;
	}

	@Override
	public List<Giocatore> getGiocSvincolatoByRuolo(String r, int lega) {

Connection connection = datasource.getConnection();
		
		List<Giocatore> giocatori = null;
		
		try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM giocatore G "
					+ "WHERE ruolo=? and "
					+ "NOT EXISTS (SELECT * FROM squadra S "
					+ "WHERE S.giocatore= G.codice and S.lega=? )"
					+ "ORDER BY G.nome ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, r);
			statement.setInt(2, lega);

			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				giocatori=new ArrayList<Giocatore>();
			
				do{
					giocatori.add(new Giocatore(resultset.getInt(1),resultset.getString(2),resultset.getString(3).charAt(0),
							resultset.getString(4)));
									
				}while(resultset.next());
			}		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
		return giocatori;
	}

	@Override
	public List<Giocatore> getGiocatoriSquadra(int u, int l) {
		
		Connection connection = datasource.getConnection();
		
		List<Giocatore> giocatori = null;
		
		try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM giocatore as g "
					+ "WHERE g.codice in ( "
					+ "SELECT giocatore FROM squadra as s "
					+ "WHERE s.utente=? and s.lega=? )";
			
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, u);
			statement.setInt(2, l);
			ResultSet resultset = statement.executeQuery();
			
			giocatori=new ArrayList<Giocatore>();
			if(resultset.next()){
			
				do{
					giocatori.add(new Giocatore(resultset.getInt(1),resultset.getString(2),resultset.getString(3).charAt(0),
							resultset.getString(4)));
									
				}while(resultset.next());
			}		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
		return giocatori;
		
	}



	
}
