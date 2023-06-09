package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo martello;
	private Attrezzo incudine;
	private Comando comando;
	private IO io;
	private Labirinto labirinto;
	
	@Before
	public void setUp() throws Exception {
		 labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
//				new LabirintoBuilder()
//				.addStanzaIniziale("Atrio")
//				.addAttrezzo("martello", 3)
//				.addStanzaVincente("Biblioteca")
//				.addAdiacenza("Atrio", "Biblioteca", "nord")
//				.getLabirinto();
		partita = new Partita(labirinto);
		martello = new Attrezzo("martello", 2);
		incudine = new Attrezzo("incudine", 11);
		comando = new ComandoPrendi();
		io = new IOConsole(new Scanner(System.in));
		comando.setIo(io);
	}
	
	@Test
	public void testAttrezzoPreso() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(incudine);
		comando.setParametro("incudine");
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("incudine"));
	}
	
}
