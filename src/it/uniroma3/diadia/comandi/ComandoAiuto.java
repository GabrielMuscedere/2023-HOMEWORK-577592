package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;


public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai (direzione)", "posa (attrezzo)", "prendi (attrezzo)", "aiuto", "guarda", "fine"};
	private String nome = "aiuto";
	private IO io;
	
	public ComandoAiuto(IO io) {
		super();
		this.io = io;
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		int numeroComandi = elencoComandi.length;
		for(int i=0; i< numeroComandi; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");

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
