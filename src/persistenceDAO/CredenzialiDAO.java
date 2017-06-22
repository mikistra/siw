package persistenceDAO;

import model.Credenziali;

public interface CredenzialiDAO {

	
	public int login(String user, String pass);
	public void addCredenziali(Credenziali cred);
	
}
