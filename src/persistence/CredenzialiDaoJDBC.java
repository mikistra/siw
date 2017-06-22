package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Credenziali;
import persistenceDAO.CredenzialiDAO;

public class CredenzialiDaoJDBC implements CredenzialiDAO {

	private DataSource datasource;

	public  CredenzialiDaoJDBC(DataSource datasource) {
		this.datasource=datasource;
		
	}
	
	@Override
	public int login(String user, String pass) {
		
		Connection connection = datasource.getConnection();
		
try{
			
			String query = ""
					+ "SELECT utente "
					+ "FROM credenziali AS cred "
					+ "WHERE cred.username=? AND cred.password=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user);
			statement.setString(2, pass);
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				return resultset.getInt("utente");
			}
			
			return -1;
			
		}  catch (SQLException e) {
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
	public void addCredenziali(Credenziali cred) {
		
			Connection connection = this.datasource.getConnection();
		
		try{		
			
			
			String insert ="INSERT INTO credenziali (utente, username, password) "
						+ " VALUES (?,?,?)";
			
			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setInt(1, cred.getUtente());
			statement.setString(2, cred.getUsername());
			statement.setString(3, cred.getPassword());
			
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

}
