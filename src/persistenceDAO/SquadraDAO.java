package persistenceDAO;

import java.util.List;

import javafx.util.Pair;
import model.Squadra;

public interface SquadraDAO {

	public List<Squadra> getSquadra(int u, int l);
	public List<Squadra> getSquadraByNome(String ns);
	public void addSquadraT(Squadra s);
	public void addSquadraFull(List<Squadra> list);
	public List<Pair<String,String>> getPorprieSquadre(int u);
	public List<String> getSquadreLega(int idl);
	
}
