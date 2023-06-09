package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {
	
	private String nome = "saluta";

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio() != null)
			this.getIo().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		else
			this.getIo().mostraMessaggio("non c'e' nessun personaggio in quetsa stanza!");
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}

}
