package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	
	private Attrezzo granata;
	private StanzaMagica stanza;
	private StringBuilder s;
	
	
	@BeforeEach
	void setUp() {
	
		this.granata = new Attrezzo("granata", 1);
		this.stanza = new StanzaMagica("labIA", 3);
		s = new StringBuilder(this.granata.getNome());
	}
	
	
	@Test
	void testAddAttrezzoNotNull() {
		this.stanza.addAttrezzo(granata);
		assertTrue(this.stanza.hasAttrezzo("granata"));
	}

	@Test
	void testModificaAttrezzo() {
		this.stanza.addAttrezzo(this.granata);
		this.stanza.addAttrezzo(this.granata);
		this.stanza.addAttrezzo(this.granata);
		this.stanza.addAttrezzo(this.granata);
		assertTrue(this.stanza.hasAttrezzo(s.reverse().toString()));
	}

}
