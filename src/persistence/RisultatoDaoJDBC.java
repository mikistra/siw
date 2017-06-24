package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Risultato;
import persistenceDAO.RisultatoDAO;

public class RisultatoDaoJDBC implements RisultatoDAO {

	private DataSource datasource;

	public RisultatoDaoJDBC(DataSource datasource)
	{
		this.datasource=datasource;       
	}

	@Override
	public void addRisultato(Risultato r) {

		Connection connection = this.datasource.getConnection();

		try{		


			String verifystring = ""
					+ "SELECT * "
					+ "FROM risultato "
					+ "WHERE lega=? and giornata=? and nomesquadra=? ";

			PreparedStatement verifystate = connection.prepareStatement(verifystring);
			verifystate.setInt(1, r.getLega());
			verifystate.setInt(2, r.getGiornata());
			verifystate.setString(3, r.getNomesquadra());
			ResultSet resultset = verifystate.executeQuery();

			if(resultset.next())
			{ return; }


			String insert ="INSERT INTO risultato (lega, giornata, nomesquadra, punteggio) "
					+ " VALUES (?,?,?,?)";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setInt(1, r.getLega() );
			statement.setInt(2, r.getGiornata());
			statement.setString(3, r.getNomesquadra());
			statement.setFloat(4, r.getPunteggio());


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
	public Risultato getRisultato(int le, int g, String s) {

		Connection connection= datasource.getConnection();

		Risultato risultato= new Risultato();

		try {
			String query = ""
					+ "SELECT * "
					+ "FROM risultato "
					+ "WHERE lega=? and giornata=? and nomesquadra=? ";

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, le);
			statement.setInt(2, g);
			statement.setString(3, s);
			ResultSet resultset = statement.executeQuery();

			if(resultset.next())
			{
				risultato.setLega(resultset.getInt("lega"));
				risultato.setGiornata(resultset.getInt("giornata"));
				risultato.setNomesquadra(resultset.getString("nomesquadra"));
				risultato.setPunteggio(resultset.getFloat("punteggio"));


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

		return risultato;

	}

	@Override
	public int giornateLega(int l) {

		Connection connection= datasource.getConnection();
		int x=0;
	//	List<Integer> risultato= new ArrayList<Integer>() ;

		try {
			String query = ""
					+ "SELECT distinct giornata "
					+ "FROM risultato "
					+ "WHERE lega=? ";

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, l);
			
			ResultSet resultset = statement.executeQuery();

			if(resultset.next()){
				
				do{
					x++;
				}while(resultset.next());
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

		//return risultato.size();
		return x;
	}

	@Override
	public List<Risultato> getRisultatiLega(int l, int g) {

		Connection connection = datasource.getConnection();

		List<Risultato> risultati = null;
		
		try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM risultato "
					+ "WHERE lega=? and giornata=? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, l);
			statement.setInt(2, g);
			ResultSet resultset = statement.executeQuery();
			
			risultati=new ArrayList<Risultato>();

			
			if(resultset.next()){
			
				do{
					risultati.add(new Risultato(resultset.getInt("lega"), resultset.getInt("giornata"), resultset.getString("nomesquadra"), resultset.getInt("punteggio")));
									
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
		
		return risultati;

		
	}



}
