package model;

import java.sql.Date;

public class Giornata {

	int idgiornata;
	Date data;
	
	public Giornata(){}

	public Giornata(int idgiornata, Date data) {
		this.idgiornata = idgiornata;
		this.data = data;
	}

	public int getIdgiornata() {
		return idgiornata;
	}

	public void setIdgiornata(int idgiornata) {
		this.idgiornata = idgiornata;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
