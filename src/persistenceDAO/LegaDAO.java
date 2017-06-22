package persistenceDAO;

import java.util.List;

import model.Lega;

public interface LegaDAO {

	public Lega getLega(int id);
	public int addLega(Lega le);
	public int getLegaByName(String nome);
	public List<Lega> getLeghebyUser(int idu);
	public Lega getLegaBySquadra(String s);
	
}
