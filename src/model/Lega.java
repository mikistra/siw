package model;

import java.io.Serializable;

public class Lega implements Serializable {

	int idlega;
	String nomelega;
	int amministratore;
	
	public Lega(){}

	public Lega(int idlega, String nomelega, int amministratore) {
		this.idlega = idlega;
		this.nomelega = nomelega;
		this.amministratore = amministratore;
	}

	public int getIdlega() {
		return idlega;
	}

	public void setIdlega(int idlega) {
		this.idlega = idlega;
	}

	public String getNomelega() {
		return nomelega;
	}

	public void setNomelega(String nomelega) {
		this.nomelega = nomelega;
	}

	public int getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(int amministratore) {
		this.amministratore = amministratore;
	}
	
	
	
}
