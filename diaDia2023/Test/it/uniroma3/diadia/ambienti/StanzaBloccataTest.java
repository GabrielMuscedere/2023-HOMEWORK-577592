package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	StanzaBloccata stanza;
	Attrezzo granata;
	Stanza stAdicente;
	
	@BeforeEach
	void setUp()  {
		this.stanza = new StanzaBloccata("laboratorio", "sud", "granata");
		this.granata = new Attrezzo("granata", 1);
		this.stAdicente = new Stanza("labIA");
		this.stanza.impostaStanzaAdiacente("sud", stAdicente);
	}

	@Test
	void testStanzaBloccataConAttrezzoSbloccante() {
		this.stanza.addAttrezzo(this.granata);
		assertEquals(this.stAdicente, this.stanza.getStanzaAdiacente("sud"));							
	}
	
	@Test
	void testStanzaBloccataSenzaAttrezzoSbloccante() {
		assertNotEquals(this.stAdicente, this.stanza.getStanzaAdiacente("sud"));							
	}

}
