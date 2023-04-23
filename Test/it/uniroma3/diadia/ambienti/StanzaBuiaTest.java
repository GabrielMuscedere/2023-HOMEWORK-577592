package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	StanzaBuia stanza;
	Attrezzo granata;
	IO io;

	@BeforeEach
	void setUp() {
		io = new IOConsole();
		this.stanza = new StanzaBuia("labIA", "granata");
		this.granata = new Attrezzo("granata", 1);
	}

	@Test
	void testGetDescrizioneSenzaAttrezzi() {
		io.mostraMessaggio(this.stanza.getDescrizione());
		assertEquals("qui c'è un buio pesto", this.stanza.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneConAttrezzi() {
		this.stanza.addAttrezzo(granata);
		assertNotEquals("qui c'è un buio pesto", this.stanza.getDescrizione());
	}


}
