package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import model.Squadra;
import persistenceDAO.SquadraDAO;

public class SquadraDaoJDBC implements SquadraDAO {

	private DataSource datasource;
	
	public SquadraDaoJDBC(DataSource datasource)
	{
		this.datasource=datasource;
	}

	@Override
	public List<Squadra> getSquadra(int u, int l) {
		
		Connection connection = datasource.getConnection();

		List<Squadra> squadra = null;
		
try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM squadra "
					+ "WHERE utente=? and lega=? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, u);
			statement.setInt(2, l);
			ResultSet resultset = statement.executeQuery();
			
			squadra=new ArrayList<Squadra>();

			
			if(resultset.next()){
			
				do{
					squadra.add(new Squadra(resultset.getInt("utente"), resultset.getInt("lega"), resultset.getInt("giocatore"), resultset.getString("nomesquadra")));
									
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
		
		return squadra;
		
		
	}

	@Override
	public void addSquadraT(Squadra s) {
		
		Connection connection = this.datasource.getConnection();
		
	try{		
		
		String verify = ""
				+ "SELECT * "
				+ "FROM squadra "
				+ "WHERE utente=? and lega=? and giocatore=? and nomesquadra=? ";
		
		PreparedStatement verifystatement = connection.prepareStatement(verify);
		verifystatement.setInt(1, s.getUtente());
		verifystatement.setInt(2, s.getLega());
		verifystatement.setInt(3, s.getGiocatore());
		verifystatement.setString(4, s.getNomesquadra());
		ResultSet resultverify = verifystatement.executeQuery();
		
		if(resultverify.next())
			return;
       
		
		String insert ="INSERT INTO squadra (utente, lega, giocatore, nomesquadra) "
					+ " VALUES (?,?,?,?)";
		
		PreparedStatement statement =connection.prepareStatement(insert);
		statement.setInt(1, s.getUtente());
		statement.setInt(2, s.getLega());
		statement.setInt(3, s.getGiocatore());
		statement.setString(4, s.getNomesquadra());
		
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
	public void addSquadraFull(List<Squadra> list) {
		
		for (Squadra squadra : list) {
			
			addSquadraT(squadra);
		}
		
	}

	@Override
	public List<Squadra> getSquadraByNome(String ns) {

		Connection connection = datasource.getConnection();

		List<Squadra> squadra = null;
		
try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM squadra "
					+ "WHERE nomesquadra=? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ns);
			ResultSet resultset = statement.executeQuery();
			
			squadra=new ArrayList<Squadra>();

			
			if(resultset.next()){
			
				do{
					squadra.add(new Squadra(resultset.getInt("utente"), resultset.getInt("lega"), resultset.getInt("giocatore"), resultset.getString("nomesquadra")));
									
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
		
		return squadra;

	}

	@Override
	public List< Pair<String,String> > getPorprieSquadre(int u) {
		
		Connection connection = datasource.getConnection();

		List< Pair<String,String> > squadre = null;
		
try{
			
			String query = ""
					+ "SELECT DISTINCT l.nomelega, s.nomesquadra "
					+ "FROM squadra as s, lega as l "
					+ "WHERE l.idlega = s.lega "
					+ "and s.utente=? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, u);
			ResultSet resultset = statement.executeQuery();
			
			squadre=new ArrayList< Pair<String,String> >();

			
			if(resultset.next()){
			
				do{
					squadre.add(new Pair<String,String>(resultset.getString("nomelega"), resultset.getString("nomesquadra")));
									
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
		
		return squadre;
	}

	@Override
	public List<String> getSquadreLega(int idl) {

		Connection connection = datasource.getConnection();

		List<String> squadre = null;
		
try{
			
			String query = ""
					+ "SELECT DISTINCT nomesquadra "
					+ "FROM squadra "
					+ "WHERE lega = ? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idl);
			ResultSet resultset = statement.executeQuery();
			
			squadre=new ArrayList<String>();

			
			if(resultset.next()){
			
				do{
					squadre.add(resultset.getString("nomesquadra"));
									
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
		
		return squadre;
		
		
	}
	
	
	
	
}
