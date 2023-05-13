package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {
	String s;
	FabbricaDiComandiFisarmonica fabbrica;
	Comando comando;
	IO io;
	
	@BeforeEach
	void setUp() {
		this.io = new IOConsole();
		this.fabbrica = new FabbricaDiComandiFisarmonica(this.io);
	}

	@Test
	void testCostruisciComandoNonValido() {
		this.s = "ciao";
		this.comando = this.fabbrica.costruisciComando(this.s); 
		assertEquals("non valido", this.comando.getNome());
	}
	
	@Test 
	void testCostruisciComandoConParametro() {
		this.s = "prendi lanterna";
		this.comando = this.fabbrica.costruisciComando(this.s);
		assertEquals("prendi", this.comando.getNome());
	}
	
	@Test
	void testCostruisciComandoSenzaParametro() {
		this.s = "fine";
		this.comando = this.fabbrica.costruisciComando(this.s);
		assertEquals("fine", this.comando.getNome());
	}

}
