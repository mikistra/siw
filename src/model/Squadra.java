package model;

public class Squadra {

	int utente;
	int lega;
	int giocatore;
	String nomesquadra;
	
	public Squadra() {}

	public Squadra(int utente, int lega, int giocatore, String nomesquadra) {
		this.utente = utente;
		this.lega = lega;
		this.giocatore = giocatore;
		this.nomesquadra = nomesquadra;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public int getLega() {
		return lega;
	}

	public void setLega(int lega) {
		this.lega = lega;
	}

	public int getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(int giocatore) {
		this.giocatore = giocatore;
	}

	public String getNomesquadra() {
		return nomesquadra;
	}

	public void setNomesquadra(String nomesquadra) {
		this.nomesquadra = nomesquadra;
	}
	
	
}
