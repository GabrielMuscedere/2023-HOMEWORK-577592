package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{

	static final protected String descrizioneStanzaBuia = "qui c'è un buio pesto";

	private String nomeAttrezzoRivelatore;

	public StanzaBuia(String nome, String nomeAttrezzoRivelatore) {
		super(nome);
		this.nomeAttrezzoRivelatore = nomeAttrezzoRivelatore;
	}

	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.nomeAttrezzoRivelatore))
			return super.getDescrizione();
		
		return descrizioneStanzaBuia;
	}

	public String getNomeAttrezzoRivelatore() {
		return nomeAttrezzoRivelatore;
	}

	public void setNomeAttrezzoRivelatore(String nomeAttrezzoRivelatore) {
		this.nomeAttrezzoRivelatore = nomeAttrezzoRivelatore;
	}
	
	

}
