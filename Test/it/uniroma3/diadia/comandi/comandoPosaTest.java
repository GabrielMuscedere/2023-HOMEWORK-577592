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



class comandoPosaTest {
	private Giocatore giocatore;
	private ComandoPosa posa;
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
		this.posa = new ComandoPosa(this.io);
		this.laboratorio = new Stanza("laboratorio");
		this.granata = new Attrezzo("granata", 1);
		this.partita.setGiocatore(this.giocatore);
		this.giocatore.setBorsa(this.borsa);
		this.partita.setStanzaCorrente(this.laboratorio);
		this.posa.setParametro("granata");
		

	}

	@Test
	void testGetNome() {
		assertEquals("posa",this.posa.getNome());
	}

	@Test
	void testGetParametro() {
		assertEquals("granata", this.posa.getParametro());
	}

	@Test
	void testEsegui() {
		this.giocatore.getBorsa().addAttrezzo(this.granata);
		this.posa.esegui(this.partita);
		assertTrue(this.laboratorio.hasAttrezzo("granata"));
	}
	
	@Test 
	void testEseguiConAttrezzoNonPresente() {
		this.posa.setParametro("martello");
		this.giocatore.getBorsa().addAttrezzo(granata);
		this.posa.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("granata"));
	}


}
