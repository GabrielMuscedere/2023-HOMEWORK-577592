package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	
	public static final String MESSAGGIO_FINE = "Grazie di aver giocato!";
	private String nome = "fine";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(MESSAGGIO_FINE);
		partita.setFinita();
	}

	@Override
	public String getNome() {
		return this.nome;
	}
	
}