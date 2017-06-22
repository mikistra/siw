package model;

public class Voto {
	
	int rifgiocatore;
	int giornata;
	float voto;
	int gf;
	int gs;
	int ammonizione;
	int espulsione;
	int autogoal;
	int assist;
	
	public Voto() {}

	public Voto(int rifgiocatore, int giornata, float voto, int gf, int gs, int ammonizione, int espulsione,
			int autogoal, int assist) {
		this.rifgiocatore = rifgiocatore;
		this.giornata = giornata;
		this.voto = voto;
		this.gf = gf;
		this.gs = gs;
		this.ammonizione = ammonizione;
		this.espulsione = espulsione;
		this.autogoal = autogoal;
		this.assist = assist;
	}

	public int getRifgiocatore() {
		return rifgiocatore;
	}

	public void setRifgiocatore(int rifgiocatore) {
		this.rifgiocatore = rifgiocatore;
	}

	public int getGiornata() {
		return giornata;
	}

	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}

	public float getVoto() {
		return voto;
	}

	public void setVoto(float voto) {
		this.voto = voto;
	}

	public int getGf() {
		return gf;
	}

	public void setGf(int gf) {
		this.gf = gf;
	}

	public int getGs() {
		return gs;
	}

	public void setGs(int gs) {
		this.gs = gs;
	}

	public int getAmmonizione() {
		return ammonizione;
	}

	public void setAmmonizione(int ammonizione) {
		this.ammonizione = ammonizione;
	}

	public int getEspulsione() {
		return espulsione;
	}

	public void setEspulsione(int espulsione) {
		this.espulsione = espulsione;
	}

	public int getAutogoal() {
		return autogoal;
	}

	public void setAutogoal(int autogoal) {
		this.autogoal = autogoal;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}
	
	
@Override
public String toString() {
	
	String s= "giocatore: "+rifgiocatore+" giornata: "+giornata+" voto: "+voto+" gf: "+gf+" gs: "+gs+" ammo: "+ammonizione+" esp: "+espulsione+" autogoal: "+autogoal+" assist: "+assist;

return s;
}
}
