package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	
	private Attrezzo granata, martello, cartello, forbici;
	private StanzaMagica stanzaMagica;
	private StringBuilder s;
	
	
	@BeforeEach
	void setUp() {
		this.forbici = new Attrezzo("forbici", 1);
		this.cartello = new Attrezzo("cartello", 1);
		this.martello = new Attrezzo("martello", 1);
		this.granata = new Attrezzo("granata", 1);
		this.stanzaMagica = new StanzaMagica("labIA");
		s = new StringBuilder(this.granata.getNome());
	}
	
	
	@Test
	void testAddAttrezzoNotNull() {
		this.stanzaMagica.addAttrezzo(granata);
		assertTrue(this.stanzaMagica.hasAttrezzo("granata"));
	}

	@Test
	void testModificaAttrezzo() {
		this.stanzaMagica.addAttrezzo(this.martello);
		this.stanzaMagica.addAttrezzo(this.forbici);
		this.stanzaMagica.addAttrezzo(this.cartello);
		this.stanzaMagica.addAttrezzo(this.granata);
		assertTrue(this.stanzaMagica.hasAttrezzo(s.reverse().toString()));
	}

}
