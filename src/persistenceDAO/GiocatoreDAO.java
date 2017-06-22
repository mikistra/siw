package persistenceDAO;

import java.util.List;

import model.Giocatore;

public interface GiocatoreDAO {


	public Giocatore getGiocatorebyCod(int cod);
	public List<Giocatore> getGiocatoreByRuolo(char r);
	public List<Giocatore> getGiocSvincolatoByRuolo (String r, int lega);
	public List<Giocatore> getGiocatoriSquadra(int u, int l);
 }
