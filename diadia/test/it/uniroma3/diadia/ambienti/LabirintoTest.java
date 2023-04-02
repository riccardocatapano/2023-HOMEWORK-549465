package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza StanzaTest;

	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.StanzaTest = new Stanza("StanzaTest");
	}

	@Test
	public void testGetStanzaCorrente() {
		this.labirinto.setStanzaCorrente(StanzaTest);
		assertEquals(this.StanzaTest,this.labirinto.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaVincente() {
		this.labirinto.setStanzaVincente(StanzaTest);
		assertEquals(this.StanzaTest,this.labirinto.getStanzaVincente());
	}

}
