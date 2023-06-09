package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo grimaldello;
	
	@Before
	public void setUp() throws Exception {
		sb = new StanzaBloccata("StanzaBloccata", "ovest", "grimaldello");
		s = new Stanza("Stanzetta");
		grimaldello = new Attrezzo("grimaldello", 1);
		sb.impostaStanzaAdiacente("ovest", s);
		
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb, sb.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(grimaldello);
		assertEquals(s, sb.getStanzaAdiacente("ovest"));
	}

}
