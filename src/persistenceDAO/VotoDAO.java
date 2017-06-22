package persistenceDAO;

import java.util.List;

import model.Voto;

public interface VotoDAO {

	public void addVoto(Voto v);
	public void addVoti(List<Voto> list);
	public Voto getVoto(int gioc, int giorn);
	public List<Voto> getVotibyGiornata(int giornata);
	public boolean dispoibile(int giornata);
}
