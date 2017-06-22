package persistenceDAO;

import java.util.List;

import model.Formazione;

public interface FormazioneDAO {


	public List<Formazione> getFormazione(int u, int l, int g);
	public List<Formazione> getFormazionebySquadra(String s, int l, int g);
	public void addFormazioneT(Formazione f);
	public void addFormazioneFull(List<Formazione> list);
	
}
