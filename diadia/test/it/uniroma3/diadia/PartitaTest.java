package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	
	@Before
	public void setUp() {
		stanzaVincente = new Stanza("Stanza Vincente");
		stanzaCorrente = new Stanza("Stanza Corrente");
		partita = new Partita();
		partita.getLabirinto().setStanzaCorrente(stanzaCorrente);
		partita.getLabirinto().setStanzaVincente(stanzaVincente);
	}

	@Test
	public void testVinta() {
		partita.getLabirinto().setStanzaVincente(stanzaCorrente);
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testNonVinta() {
		assertFalse(partita.vinta());
	}
	
	@Test
	public void testIsFinitaTrue() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaVinta() {
		partita.getLabirinto().setStanzaCorrente(stanzaVincente);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaZeroCfu() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testNotIsFinita() {
		assertFalse(partita.isFinita());
	}
}
