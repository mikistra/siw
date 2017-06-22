package model;

public class Credenziali {

	int utente;
	String username;
	String password;
	
	public Credenziali(){}

	public Credenziali(int utente, String username, String password) {
		this.utente = utente;
		this.username = username;
		this.password = password;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
