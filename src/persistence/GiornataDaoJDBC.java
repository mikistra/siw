package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Giornata;
import persistenceDAO.GiornataDAO;

public class GiornataDaoJDBC implements GiornataDAO {
	
	private DataSource datasource;

	public GiornataDaoJDBC(DataSource datasource) {

		this.datasource=datasource;
	}

	@Override
	public void addGiornata(Giornata g) {


		Connection connection = this.datasource.getConnection();
		
		try{
				
				
				String insert ="INSERT INTO giornata (data) "
							+ " VALUES (?)";
				
				PreparedStatement statement =connection.prepareStatement(insert, java.sql.Statement.RETURN_GENERATED_KEYS);
				statement.setDate(1, g.getData());
				
				statement.executeUpdate();		
				
			   ResultSet result=statement.getGeneratedKeys();
			   result.next();
			   
			   
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
	public List<Giornata> getGiornateNC(int l) {
		
		Connection connection = datasource.getConnection();
		
		List<Giornata> giornate = null;
		
		try{
			
			String query = ""
					+ "SELECT g.idgiornata, g.Data "
					+ "FROM giornata g "
					+ "WHERE NOT EXISTS ( "
					+ " SELECT * FROM risultato r "
					+ " WHERE r.giornata=g.idgiornata and r.lega=? ) ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, l);
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				giornate=new ArrayList<Giornata>();
			
				do{
					giornate.add(new Giornata(resultset.getInt(1),resultset.getDate(2) ) );
									
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
		
		return giornate;
		
	}

	@Override
	public List<Giornata> getGiornate() {
		
		Connection connection = datasource.getConnection();
		
		List<Giornata> giornate = null;
		
		try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM giornata ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				giornate=new ArrayList<Giornata>();
			
				do{
					giornate.add(new Giornata(resultset.getInt(1),resultset.getDate(2) ) );
									
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
		
		return giornate;
	
	}

}
