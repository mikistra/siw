package persistenceDAO;

import model.Utente;

public interface UtenteDAO {

	public int addUtente(Utente u);
	public Utente getUtentebyId(int id);
	public int getUtentebyUser(String user);
	
}
