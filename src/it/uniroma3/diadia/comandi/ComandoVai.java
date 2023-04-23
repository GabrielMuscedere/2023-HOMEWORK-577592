package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoVai implements Comando {
	private String nome = "vai";
	private String direzione;
	private IO io;
	
	public ComandoVai(IO io) {
		super();
		this.io = io;
	}


	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente =  partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(this.direzione == null) {
			io.mostraMessaggio("dove vuoi andare?\nDevi specificare una direzione");
			direzione = io.leggiRiga();	
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente!");
			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
	}
	
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return this.direzione;
	}
}
