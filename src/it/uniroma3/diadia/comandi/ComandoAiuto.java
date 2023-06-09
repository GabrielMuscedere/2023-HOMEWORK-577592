package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;


public class ComandoAiuto extends AbstractComando {
	
	public static final String[] ELENCO_COMANDI = {"vai (direzione)", "posa (attrezzo)", "prendi (attrezzo)", "aiuto", "guarda", "fine"};
	
	private String nome = "aiuto";

	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		int numeroComandi = ELENCO_COMANDI.length;
		for(int i=0; i< numeroComandi; i++) 
			this.getIo().mostraMessaggio(ELENCO_COMANDI[i]+" ");
		this.getIo().mostraMessaggio("");

	}

	@Override
	public String getNome() {
		return this.nome;
	}
	

}
