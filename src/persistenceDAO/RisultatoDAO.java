package persistenceDAO;

import java.util.List;

import model.Risultato;

public interface RisultatoDAO {

	
	public void addRisultato(Risultato r);
	public Risultato getRisultato(int le, int g, String s);
	public int giornateLega(int l);
	public List<Risultato> getRisultatiLega(int l, int g);
	
	
}
