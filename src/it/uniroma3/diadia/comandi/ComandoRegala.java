package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{
	
	private String nome = "regala";

	@Override
	public void esegui(Partita partita) {
		if(partita.getGiocatore().getBorsa().isEmpty())
			this.getIo().mostraMessaggio("non hai attrezzi da regalare!");
		else {
			Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
			if(a==null) 
				this.getIo().mostraMessaggio("l'attrezzo non e' presente nella tua borsa!");
			else {
				partita.getStanzaCorrente().getPersonaggio().riceviRegalo(a, partita);
				partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
			}
		}
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
