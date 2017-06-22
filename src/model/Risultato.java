package model;

public class Risultato {

	int lega;
	int giornata;
	String nomesquadra;
	float punteggio;
	
	public Risultato(){}

	public Risultato(int lega, int giornata, String nomesquadra, float punteggio) {
		this.lega = lega;
		this.giornata = giornata;
		this.nomesquadra = nomesquadra;
		this.punteggio = punteggio;
	}

	public int getLega() {
		return lega;
	}

	public void setLega(int lega) {
		this.lega = lega;
	}

	public int getGiornata() {
		return giornata;
	}

	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}

	public String getNomesquadra() {
		return nomesquadra;
	}

	public void setNomesquadra(String nomesquadra) {
		this.nomesquadra = nomesquadra;
	}

	public float getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(float punteggio) {
		this.punteggio = punteggio;
	}
	
	
	
}
