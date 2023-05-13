package it.uniroma3.diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Map<String, Stanza> nomeToStanze;
	private Stanza ultimaStanzaAggiunta;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nomeToStanze = new HashMap<String, Stanza>();
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	public Stanza getUltimaStanzaAggiunta() {
		return ultimaStanzaAggiunta;
	}

	public void setUltimaStanzaAggiunta(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
	}

	public Map<String, Stanza> getNomeToStanza() {
		return this.nomeToStanze;
	}

	public void setNomeToStanza(Map<String, Stanza> nomeToStanze) {
		this.nomeToStanze = nomeToStanze;
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
		Stanza stanzaIniziale = new Stanza(nomeStanzaIniziale);
		this.labirinto.setStanzaCorrente(stanzaIniziale);
		this.AggiornaMapDiStanze(stanzaIniziale);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
		Stanza stanzaVincente = new Stanza(nomeStanzaVincente);
		this.labirinto.setStanzaVincente(stanzaVincente);
		this.AggiornaMapDiStanze(stanzaVincente);
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		this.AggiornaMapDiStanze(stanza);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int pesoAttrezzo) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, pesoAttrezzo);
		if(this.ultimaStanzaAggiunta == null)
			return this;
		this.ultimaStanzaAggiunta.addAttrezzo(attrezzo);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String nomeStanzaCorrente, String nomeStanzaAdiacente, String direzione) {
		if(this.nomeToStanze.containsKey(nomeStanzaCorrente) && this.nomeToStanze.containsKey(nomeStanzaAdiacente)) {
			Stanza stanzaCorrente = this.nomeToStanze.get(nomeStanzaCorrente);
			Stanza stanzaAdiacente = this.nomeToStanze.get(nomeStanzaAdiacente);
			stanzaCorrente.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		}
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int sogliaMagica) {
		Stanza stanza = new StanzaMagica(nomeStanza, sogliaMagica);
		this.AggiornaMapDiStanze(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String nomeAttrezzoSbloccante, String direzioneBloccata) {
		Stanza stanza = new StanzaBloccata(nomeStanza, direzioneBloccata, nomeAttrezzoSbloccante);
		this.AggiornaMapDiStanze(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String nomeAttrezzoRivelatore) {
		Stanza stanza = new StanzaBuia(nomeStanza, nomeAttrezzoRivelatore);
		this.AggiornaMapDiStanze(stanza);
		return this;
	}

	public void AggiornaMapDiStanze(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
		this.nomeToStanze.put(stanza.getNome(), stanza);
	}

	public List<Stanza> getListaStanze() {
		return (List<Stanza>)this.nomeToStanze.values();
	}


}
