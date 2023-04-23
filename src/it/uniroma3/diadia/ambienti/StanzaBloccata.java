package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoSbloccatore;

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccatore) {
		super(nome);
		this.attrezzoSbloccatore = attrezzoSbloccatore;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
        if(!this.hasAttrezzo(this.attrezzoSbloccatore))
        	stanza = this;
        else {
        	stanza = super.getStanzaAdiacente(direzione);
        }
        return stanza;
	}
	
	@Override
	public String getDescrizione() {
		return "Stanza bloccata in direzione: " + this.getDirezioneBloccata() + ", attrezzo sbloccante:" + this.getAttrezzoSbloccatore() + "\n" + super.getDescrizione();
	}

	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	public String getAttrezzoSbloccatore() {
		return attrezzoSbloccatore;
	}

	public void setAttrezzoSbloccatore(String attrezzoSbloccatore) {
		this.attrezzoSbloccatore = attrezzoSbloccatore;
	}
	
	

}
