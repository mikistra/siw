package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Voto;
import persistenceDAO.VotoDAO;

public class VotoDaoJDBC implements VotoDAO {
	
	private DataSource datasource;
	
	public VotoDaoJDBC(DataSource datasource)
	{
		this.datasource=datasource;       
	}

	@Override
	public void addVoto(Voto v) {

		Connection connection = this.datasource.getConnection();
		
		try{		
			
			
			String verifystring = ""
					+ "SELECT * "
					+ "FROM voto "
					+ "WHERE rifgiocatore=? and giornata=? ";
			
			PreparedStatement verifystate = connection.prepareStatement(verifystring);
			verifystate.setInt(1, v.getRifgiocatore());
			verifystate.setInt(2, v.getGiornata());
			ResultSet resultset = verifystate.executeQuery();
			
			if(resultset.next())
			{ return; }
			
					
			String insert ="INSERT INTO voto (rifgiocatore, giornata, voto, gf, gs, ammonizione, espulsione, autogoal, assist) "
						+ " VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setInt(1, v.getRifgiocatore() );
			statement.setInt(2, v.getGiornata());
			statement.setFloat(3, v.getVoto());
			statement.setInt(4, v.getGf());
			statement.setInt(5, v.getGs());
			statement.setInt(6, v.getAmmonizione());
			statement.setInt(7, v.getEspulsione());
			statement.setInt(8, v.getAutogoal());
			statement.setInt(9, v.getAssist());
			
			
			statement.executeUpdate();		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
	}

	@Override
	public void addVoti(List<Voto> list) {
    Connection connection = this.datasource.getConnection();
		
		try{		
			Voto firstv=list.get(0);
			
			String verifystring = ""
					+ "SELECT * "
					+ "FROM voto "
					+ "WHERE rifgiocatore=? and giornata=? ";
			
			PreparedStatement verifystate = connection.prepareStatement(verifystring);
			verifystate.setInt(1, firstv.getRifgiocatore());
			verifystate.setInt(2, firstv.getGiornata());
			ResultSet resultset = verifystate.executeQuery();
			
			if(resultset.next())
			{ return; }			
			
			
			
			for (Voto v : list) {
				
				
			
			String insert ="INSERT INTO voto (rifgiocatore, giornata, voto, gf, gs, ammonizione, espulsione, autogoal, assist) "
						+ " VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setInt(1, v.getRifgiocatore() );
			statement.setInt(2, v.getGiornata());
			statement.setFloat(3, v.getVoto());
			statement.setInt(4, v.getGf());
			statement.setInt(5, v.getGs());
			statement.setInt(6, v.getAmmonizione());
			statement.setInt(7, v.getEspulsione());
			statement.setInt(8, v.getAutogoal());
			statement.setInt(9, v.getAssist());
			
			
			statement.executeUpdate();	
			
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
	}

	@Override
	public Voto getVoto(int gioc, int giorn) {

  Connection connection= datasource.getConnection();
		
		Voto voto= new Voto();
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM voto "
					+ "WHERE rifgiocatore=? and giornata=? ";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, gioc);
		statement.setInt(2, giorn);
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		{
			voto.setRifgiocatore(resultset.getInt("rifgiocatore"));
			voto.setGiornata(resultset.getInt("giornata"));
			voto.setVoto(resultset.getFloat("voto"));
			voto.setGf(resultset.getInt("gf"));
			voto.setGs(resultset.getInt("gs"));
			voto.setAmmonizione(resultset.getInt("ammonizione"));
			voto.setEspulsione(resultset.getInt("espulsione"));
			voto.setAutogoal(resultset.getInt("autogoal"));
			voto.setAssist(resultset.getInt("assist"));
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
		
		return voto;
		
	}

	@Override
	public List<Voto> getVotibyGiornata(int giornata) {

		Connection connection = datasource.getConnection();

		List<Voto> voti = null;
		
try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM voto  "
					+ "WHERE giornata=? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, giornata);
		
			ResultSet resultset = statement.executeQuery();
			
			voti=new ArrayList<Voto>();

			
			if(resultset.next()){
			
				do{
					voti.add(new Voto(resultset.getInt("rifgiocatore"),resultset.getInt("giornata"),resultset.getFloat("voto"),resultset.getInt("gf"),resultset.getInt("gs"),resultset.getInt("ammonizione"),resultset.getInt("espulsione"),resultset.getInt("autogoal"),resultset.getInt("assist")));
									
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
		
		return voti;
		
		
		
	}

	@Override
	public boolean dispoibile(int giornata) {

		  Connection connection= datasource.getConnection();
			
			
			
			try {
				String query = ""
						+ "SELECT * "
						+ "FROM voto "
						+ "WHERE giornata=? ";
				
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, giornata);
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next())
			{
				return true;
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
			
			return false;
		
	}

}
