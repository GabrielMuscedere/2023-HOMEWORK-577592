package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Attrezzo osso;
	private Borsa borsa;

	@BeforeEach
	void setUp() {
		this.borsa = new Borsa();
		this.osso = new Attrezzo("osso", 1);
		this.borsa.addAttrezzo(osso);
		
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(osso));
	}
	
	@Test 
	void testHasAttrezzo() {
		assertTrue(this.borsa.hasAttrezzo("osso"));
	}
	
	@Test
	void testGetAttrezzo() {
		assertTrue(this.borsa.getAttrezzo("osso") != null);
	}
	
	@Test
	void testGetPeso() {
		assertFalse(this.borsa.getPeso() == 0);
		assertTrue (this.borsa.getPeso() == 1);
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertTrue(this.borsa.removeAttrezzo("osso") != null);
	}
	
	@Test
	void testIsEmpty() {
		assertFalse(this.borsa.isEmpty());
	}

}
