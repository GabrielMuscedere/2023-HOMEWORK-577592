package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Attrezzo osso, martello, granata, pistola, fucile;
	private Borsa borsa;

	@BeforeEach
	void setUp() {
		this.borsa = new Borsa();
		this.osso = new Attrezzo("osso", 1);
		this.martello = new Attrezzo("martello", 2);
		this.pistola = new Attrezzo("pistola", 2);
		this.fucile = new Attrezzo("fucile", 4);
		this.granata = new Attrezzo("granata", 1);
		this.borsa.addAttrezzo(osso);
		
		
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(this.martello));
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
	
	@Test
	void testGetContenutoOrdinatoPerPeso(){
		this.borsa.addAttrezzo(granata);
		this.borsa.addAttrezzo(martello);
		this.borsa.addAttrezzo(pistola);
		this.borsa.addAttrezzo(fucile);
		assertEquals("[granata (1kg), osso (1kg), martello (2kg), pistola (2kg), fucile (4kg)]", this.borsa.getContenutoOrdinatoPerPeso().toString());
	}
	
	@Test
	void testGetContenutoOrdinatoPerNome(){
		this.borsa.addAttrezzo(granata);
		this.borsa.addAttrezzo(martello);
		this.borsa.addAttrezzo(pistola);
		this.borsa.addAttrezzo(fucile);
		assertEquals("[fucile (4kg), granata (1kg), martello (2kg), osso (1kg), pistola (2kg)]", this.borsa.getContenutoOrdinatoPerNome().toString());
	}
	
	@Test
	void testGetContenutoRaggruppatoPerPeso() {
		this.borsa.addAttrezzo(granata);
		this.borsa.addAttrezzo(martello);
		this.borsa.addAttrezzo(pistola);
		this.borsa.addAttrezzo(fucile);
		assertEquals("{1=[granata (1kg), osso (1kg)], 2=[martello (2kg), pistola (2kg)], 4=[fucile (4kg)]}", this.borsa.getContenutoRaggruppatoPerPeso().toString());
	}
	
	@Test
	void testGetSortedSetOrdintoPerPeso() {
		this.borsa.addAttrezzo(granata);
		assertEquals("[granata (1kg), osso (1kg)]", this.borsa.getSortedSetOrdinatoPerPeso().toString());
	}

}
