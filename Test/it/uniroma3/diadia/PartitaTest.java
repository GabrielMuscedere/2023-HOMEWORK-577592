package it.uniroma3.diadia;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Partita partita;
	private Labirinto labirinto;
	private LabirintoBuilder lb;

	@BeforeEach
	void setUp() {
		lb = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioeca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud");
		this.labirinto = this.lb.getLabirinto();
		this.partita = new Partita(this.labirinto);
	}
	
	@Test
	final void testVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	final void testGetStanzaCorrente() {
		assertNotNull(this.partita.getStanzaCorrente());
	}
	
	@Test
	final void testGetStanzaVincente() {
		assertNotNull(this.partita.getStanzaVincente());
	}

	@Test
	final void testIsFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	final void testGetGiocatore() {
		assertNotNull(this.partita.getGiocatore());
	}
	
	@Test
	final void testGetLabirinto() {
		assertNotNull(this.partita.getLabirinto());
	}
	
	@Test
	final void testFinita() {
		assertFalse(this.partita.isFinita());
	}
	
}
