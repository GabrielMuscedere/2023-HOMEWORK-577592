package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	
	protected String nome;
    protected Set<Attrezzo> attrezzi;
    protected Map<String, Stanza> direzioneStanza;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public StanzaProtected(String nome) {
        this.nome = nome;
        this.direzioneStanza = new HashMap<String, Stanza>();
        this.attrezzi = new HashSet<Attrezzo>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public boolean impostaStanzaAdiacente(String direzione, Stanza stanza) {
        if(!this.direzioneStanza.containsKey(direzione)) {
        	this.direzioneStanza.put(direzione, stanza);
        	return true;
        }
        return false;
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
        if(direzione != null && (direzione.equals("") == false)) {
        	stanza = this.direzioneStanza.get(direzione);
        }
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Set<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        return this.attrezzi.add(attrezzo);
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	
    	risultato.append("\nUscite: ");
    	Set<String> direzione = this.direzioneStanza.keySet();
    	Iterator<String> iterDirezioni = direzione.iterator();
    	while (iterDirezioni.hasNext())
    		risultato.append(" " + iterDirezioni.next());
    	
    	risultato.append("\nAttrezzi nella stanza: ");
    	Iterator<Attrezzo> iterAttrezzi = this.attrezzi.iterator();
    	while (iterAttrezzi.hasNext()) {
    		Attrezzo attrezzo = iterAttrezzi.next();
    		risultato.append(attrezzo.toString() + " ");
    	}
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> iteratore = attrezzi.iterator();
		while (iteratore.hasNext()) {
			if (iteratore.next().getNome().equals(nomeAttrezzo))
				
				return true;
		}
		return false;	
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		Iterator<Attrezzo> iteratore = attrezzi.iterator();
		while (iteratore.hasNext()) {
			attrezzoCercato = iteratore.next();
			if (attrezzoCercato.getNome().equals(nomeAttrezzo))
				return attrezzoCercato;
		}
		return null;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo);
	}
	

	public String[] getDirezioni() {
		Set<String> direzioni;
		direzioni = this.direzioneStanza.keySet();
		return (String[]) direzioni.toArray();
    }
	
	public boolean isEmpty() { 
		return this.attrezzi.isEmpty();
	}

}