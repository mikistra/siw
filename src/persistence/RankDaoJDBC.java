package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Rank;
import model.Squadra;
import persistenceDAO.RankDAO;

public class RankDaoJDBC  implements RankDAO{

	private DataSource datasource;
	
	public RankDaoJDBC(DataSource datasource) {

		this.datasource=datasource;
	}
	
	
	@Override
	public List<Rank> getClassifica(int l) {

		Connection connection = datasource.getConnection();

		List<Rank> classifica = null;
		
 try{
			
			String query = ""
					+ "SELECT l.nomelega, r.nomesquadra, sum(punteggio) as tot "
					+ "FROM risultato r, lega l "
					+ "WHERE r.Lega=? and r.lega=l.idlega "
					+ "GROUP BY l.nomelega, r.nomesquadra "
					+ "ORDER BY tot DESC ";
	
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, l);
			ResultSet resultset = statement.executeQuery();
			
			classifica=new ArrayList<Rank>();

			
			if(resultset.next()){
			
				do{
					classifica.add(new Rank(resultset.getString("nomesquadra"), resultset.getString("nomelega"), resultset.getFloat("tot")));
									
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
		
		return classifica;
		
	}

	
}
