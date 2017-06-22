package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Formazione;
import persistenceDAO.FormazioneDAO;

public class FormazioneDaoJDBC implements FormazioneDAO {

	
	private DataSource datasource;
	
	public FormazioneDaoJDBC(DataSource datasource)
	{
		this.datasource=datasource;
	}

	@Override
	public List<Formazione> getFormazione(int u, int l, int g) {
		
		
		Connection connection = datasource.getConnection();

		List<Formazione> formazione = null;
		
try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM formazione "
					+ "WHERE rifutente=? and riflega=? and giornata=? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, u);
			statement.setInt(2, l);
			statement.setInt(3, g);
			ResultSet resultset = statement.executeQuery();
			
			formazione=new ArrayList<Formazione>();

			
			if(resultset.next()){
			
				do{
					formazione.add(new Formazione(resultset.getInt("rifutente"), resultset.getInt("riflega"),resultset.getString("nomesquadra"), resultset.getInt("rifgiocatore"), resultset.getInt("giornata"), resultset.getInt("riserva")));
									
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
		
		return formazione;
		
	}

	@Override
	public void addFormazioneT(Formazione f) {
		

		Connection connection = this.datasource.getConnection();
		
		try{		
		
		
		String verify = ""
				+ "SELECT * "
				+ "FROM formazione "
				+ "WHERE rifutente=? and riflega=? and rifgiocatore=? and giornata=?";
		
		PreparedStatement verifystatement = connection.prepareStatement(verify);
		verifystatement.setInt(1, f.getUtente());
		verifystatement.setInt(2, f.getLega());
		verifystatement.setInt(3, f.getGiocatore());
		verifystatement.setInt(4, f.getGiornata());
		ResultSet resultverify = verifystatement.executeQuery();
		
		if(resultverify.next()){
			
			PreparedStatement delstate;
			String del = ""
						+ "DELETE FROM formazione WHERE "
						+ " rifutente=? and riflega=? and giornata=? ";
			delstate = connection.prepareStatement(del);

			delstate.setInt(1, f.getUtente());
			delstate.setInt(2, f.getLega());
			delstate.setInt(3, f.getGiornata());
			delstate.executeUpdate();
			
		}
		
		
		
		String insert ="INSERT INTO formazione (rifutente, riflega, nomesquadra, rifgiocatore, giornata, riserva) "
					+ " VALUES (?,?,?,?,?,?)";
		
		PreparedStatement statement =connection.prepareStatement(insert);
		statement.setInt(1, f.getUtente());
		statement.setInt(2, f.getLega());
		statement.setString(3, f.getNomesquadra());
		statement.setInt(4, f.getGiocatore());
		statement.setInt(5, f.getGiornata());
		statement.setInt(6, f.getRiserva());
		
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
	public void addFormazioneFull(List<Formazione> list) {
	
		for (Formazione formazione : list) {
			
			addFormazioneT(formazione);
		}
	}

	@Override
	public List<Formazione> getFormazionebySquadra(String s, int l, int g) {


		Connection connection = datasource.getConnection();

		List<Formazione> formazione = null;
		
try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM formazione "
					+ "WHERE nomesquadra=? and riflega=? and giornata=? ";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, s);
			statement.setInt(2, l);
			statement.setInt(3, g);
			ResultSet resultset = statement.executeQuery();
			
			formazione=new ArrayList<Formazione>();

			
			if(resultset.next()){
			
				do{
					formazione.add(new Formazione(resultset.getInt("rifutente"), resultset.getInt("riflega"),resultset.getString("nomesquadra"), resultset.getInt("rifgiocatore"), resultset.getInt("giornata"), resultset.getInt("riserva")));
									
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
		
		return formazione;

	}
}
