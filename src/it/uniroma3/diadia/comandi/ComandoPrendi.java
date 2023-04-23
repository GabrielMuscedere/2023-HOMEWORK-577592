package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {
	private String nome = "prendi";
	private String nomeAttrezzo;
	private IO io;
	
	public ComandoPrendi(IO io) {
		super();
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoDaPrendere = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			if(borsa.addAttrezzo(attrezzoDaPrendere) == true) {
				io.mostraMessaggio("Ho preso l'attrezzo " + nomeAttrezzo + " dalla stanza " + stanzaCorrente.getNome() + " e l'ho messo nella borsa");
				stanzaCorrente.removeAttrezzo(attrezzoDaPrendere);
			}
			else
				io.mostraMessaggio("la borsa va oltre il limite di peso!"); 
		}
		else 
			io.mostraMessaggio("l'attrezzo " + nomeAttrezzo + " non e' nella stanza");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
