package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class comandoPrendiTest {
	private Giocatore giocatore;
	private ComandoPrendi prendi;
	private Borsa borsa;
	private Attrezzo granata;
	private Partita partita;
	private Stanza laboratorio;
	private IO io;

	@BeforeEach
	void setUp() {

		io = new IOConsole();

		this.partita = new Partita();
		this.giocatore = new Giocatore();
		this.borsa = new Borsa();
		this.prendi = new ComandoPrendi(this.io);
		this.laboratorio = new Stanza("laboratorio");
		this.granata = new Attrezzo("granata", 1);
		this.partita.setGiocatore(this.giocatore);
		this.giocatore.setBorsa(this.borsa);
		this.partita.setStanzaCorrente(this.laboratorio);
		this.prendi.setParametro("granata");


	}

	@Test
	void testGetNome() {
		assertEquals("prendi",this.prendi.getNome());
	}

	@Test
	void testGetParametro() {
		assertEquals("granata", this.prendi.getParametro());
	}

	@Test
	void testEseguiConAttrezzoPresente() {
		this.partita.getStanzaCorrente().addAttrezzo(this.granata);
		this.prendi.esegui(this.partita);
		assertTrue(this.borsa.hasAttrezzo("granata"));
	}
	
	@Test 
	void testEseguiConAttrezzoNonPresente() {
		this.prendi.setParametro("martello");
		this.partita.getStanzaCorrente().addAttrezzo(granata);
		this.prendi.esegui(partita);
		assertFalse(this.borsa.hasAttrezzo("granata"));
	}

}
