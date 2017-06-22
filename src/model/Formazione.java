package model;

public class Formazione {
	
	int rifutente;
	int riflega;
	String nomesquadra;
	int rifgiocatore;
	int giornata;
	int riserva;
	
	public Formazione()
	{}
	
	public Formazione(int utente, int lega, String nomesquadra, int giocatore, int giornata, int riserva) {
		this.rifutente = utente;
		this.riflega = lega;
		this.nomesquadra = nomesquadra;
		this.rifgiocatore = giocatore;
		this.giornata = giornata;
		this.riserva = riserva;
	}
	public int getUtente() {
		return rifutente;
	}
	public void setUtente(int utente) {
		this.rifutente = utente;
	}
	public int getLega() {
		return riflega;
	}
	public void setLega(int lega) {
		this.riflega = lega;
	}
	
	public String getNomesquadra(){
		return this.nomesquadra;
	}
	
	public void setNomesquadra(String nomesquadra){
		this.nomesquadra=nomesquadra;
	}
	
	public int getGiocatore() {
		return rifgiocatore;
	}
	public void setGiocatore(int giocatore) {
		this.rifgiocatore = giocatore;
	}
	public int getGiornata() {
		return giornata;
	}
	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}
	public int getRiserva() {
		return riserva;
	}
	public void setRiserva(int riserva) {
		this.riserva = riserva;
	}
	
	

}
