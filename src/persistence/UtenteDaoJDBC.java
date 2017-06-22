package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Utente;
import persistenceDAO.UtenteDAO;

public class UtenteDaoJDBC implements UtenteDAO {

	private DataSource datasource;
	
	public UtenteDaoJDBC(DataSource datasource) {
	
		this.datasource=datasource;
	}

	@Override
	public int addUtente(Utente u) {

		Connection connection = this.datasource.getConnection();
		
		try{		
			
			String verify = ""
					+ "SELECT * "
					+ "FROM utente "
					+ "WHERE username=? or email=?";
			
			PreparedStatement verifystatement = connection.prepareStatement(verify);
			verifystatement.setString(1, u.getUsername());
			verifystatement.setString(2, u.getEmail());
			ResultSet resultverify = verifystatement.executeQuery();
			
			if(resultverify.next()){
				return -1;
			}
			
			
			String insert ="INSERT INTO utente ( nome, cognome, email, username) "
						+ " VALUES (?,?,?,?)";
			
			PreparedStatement statement =connection.prepareStatement(insert, java.sql.Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, u.getNome());
			statement.setString(2, u.getCognome());
			statement.setString(3, u.getEmail());
			statement.setString(4, u.getUsername());
			
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


	@Override
	public Utente getUtentebyId(int id) {

		Connection connection= datasource.getConnection();
		
		Utente utente= new Utente();
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM utente "
					+ "WHERE idutente=?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		{
			utente.setIdutente(resultset.getInt("idutente"));
			utente.setNome(resultset.getString("nome"));
			utente.setCognome(resultset.getString("cognome"));
			utente.setEmail(resultset.getString("email"));
			utente.setUsername(resultset.getString("username"));
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
		
		return utente;
		
	}

	@Override
	public int getUtentebyUser(String user) {
		Connection connection= datasource.getConnection();
		
	//	Utente utente= new Utente();
		
		try {
			String query = ""
					+ "SELECT idutente "
					+ "FROM utente "
					+ "WHERE username=?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, user);
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		{
		   return resultset.getInt(1);
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
	
	
	
	
}
