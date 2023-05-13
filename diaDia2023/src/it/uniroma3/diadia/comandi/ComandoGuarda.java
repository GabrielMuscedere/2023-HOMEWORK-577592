package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private String nome = "guarda";
	private IO io;
	
	public ComandoGuarda(IO io) {
		super();
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("CFU rimanenti: " + partita.getGiocatore().getCfu());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio(partita.getStanzaCorrente().toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return null;
	}

}
