package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi extends AbstractComando {
	
	private String nome = "prendi";

	@Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.getParametro());
        if(a==null) {
            this.getIo().mostraMessaggio("Attrezzo non presente nella stanza!");
        } 
        else {
        	int pesoRimanente = partita.getGiocatore().getBorsa().getPesoMax() - partita.getGiocatore().getBorsa().getPeso();
            if(pesoRimanente >= a.getPeso()) {
                partita.getGiocatore().getBorsa().addAttrezzo(a);
                partita.getStanzaCorrente().removeAttrezzo(a);
            } 
            else
                this.getIo().mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
            }
    }

	@Override
	public String getNome() {
		return this.nome;
	}

}
