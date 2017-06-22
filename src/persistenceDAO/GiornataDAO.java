package persistenceDAO;

import java.util.List;

import model.Giornata;

public interface GiornataDAO {

	public void addGiornata(Giornata g);
	public List<Giornata> getGiornate();
	public List<Giornata> getGiornateNC(int l);
	
}
