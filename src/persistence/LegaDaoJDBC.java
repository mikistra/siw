package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Lega;
import persistenceDAO.LegaDAO;

public class LegaDaoJDBC implements LegaDAO {

	private DataSource datasource;
	
	public LegaDaoJDBC(DataSource datasource) {

		this.datasource=datasource;
	}
	
	
	@Override
	public Lega getLega(int id) {

		Connection connection= datasource.getConnection();
		
		Lega lega= new Lega();
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM lega "
					+ "WHERE idlega=?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		{
			lega.setIdlega(resultset.getInt("idlega"));
			lega.setNomelega(resultset.getString("nomelega"));
			lega.setAmministratore(resultset.getInt("amministratore"));

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
		
		return lega;
		
	}

	@Override
	public int addLega(Lega le) {

		Connection connection = this.datasource.getConnection();
	
	try{
			
			
			String insert ="INSERT INTO lega (nomelega, amministratore) "
						+ " VALUES (?,?)";
			
			PreparedStatement statement =connection.prepareStatement(insert, java.sql.Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, le.getNomelega());
			statement.setInt(2, le.getAmministratore());
			
			statement.executeUpdate();		
			
		   ResultSet result=statement.getGeneratedKeys();
		   result.next();
		   
		return result.getInt(1);
		   
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
	
	public int getLegaByName(String nome) {
		Connection connection= datasource.getConnection();
		
	//	Lega lega= new Lega();
		
		try {
			String query = ""
					+ "SELECT idlega "
					+ "FROM lega "
					+ "WHERE nomelega=? ";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, nome);
		ResultSet resultset = statement.executeQuery();

		if(resultset.next())
		{
		   return resultset.getInt("idlega");
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
		
		return -1;
	}


	@Override
	public List<Lega> getLeghebyUser(int idu) {

		Connection connection = datasource.getConnection();

		List<Lega> leghe = null;
		
try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM lega "
					+ "WHERE amministratore=? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idu);
			ResultSet resultset = statement.executeQuery();
			
			leghe=new ArrayList<Lega>();

			
			if(resultset.next()){
			
				do{
					leghe.add(new Lega(resultset.getInt("idlega"), resultset.getString("nomelega"), resultset.getInt("amministratore")));
									
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
		
		return leghe;
		
	}


	@Override
	public Lega getLegaBySquadra(String s) {

		Connection connection= datasource.getConnection();
		
		Lega lega= new Lega();
		
		try {
			String query = ""
					+ "SELECT l.idlega, l.nomelega, l.amministratore "
					+ "FROM lega as l, squadra as s "
					+ "WHERE  l.idlega = s.lega and s.nomesquadra=? ";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, s);
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		{
			lega.setIdlega(resultset.getInt("idlega"));
			lega.setNomelega(resultset.getString("nomelega"));
			lega.setAmministratore(resultset.getInt("amministratore"));

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
		
		return lega;
		
	}

}
