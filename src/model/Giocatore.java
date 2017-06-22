package model;

public class Giocatore {

	int codice;
	String nome;
	char ruolo;
	String club;

	public Giocatore()	{}

	public Giocatore(int codice, String nome, char ruolo, String club) {
		this.codice = codice;
		this.nome = nome;
		this.ruolo = ruolo;
		this.club = club;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getRuolo() {
		return ruolo;
	}

	public void setRuolo(char ruolo) {
		this.ruolo = ruolo;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	
	
	
}
