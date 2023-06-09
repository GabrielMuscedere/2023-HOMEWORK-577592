package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	private String nome = "guarda";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("CFU rimanenti: " + partita.getGiocatore().getCfu());
		this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().toString());
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
