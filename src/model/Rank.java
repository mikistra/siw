package model;

public class Rank {
	
	
	String squadra;
	String lega;
	Float punteggio;
	
	public Rank(){}

	public Rank(String squadra, String lega, Float punteggio) {
		this.squadra = squadra;
		this.lega = lega;
		this.punteggio = punteggio;
	}

	public String getSquadra() {
		return squadra;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public String getUtente() {
		return lega;
	}

	public void setUtente(String lega) {
		this.lega = lega;
	}

	public Float getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Float punteggio) {
		this.punteggio = punteggio;
	}
	
	

}
