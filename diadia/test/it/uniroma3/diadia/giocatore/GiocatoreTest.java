package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	
	private Giocatore giocatore;

	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testCFUNonFinitiInzioPartita() {
		assertNotEquals(0,this.giocatore.getCfu());
	}
	@Test
	public void testCFUIniziali() {
		assertEquals(Giocatore.CFU_INIZIALI,this.giocatore.getCfu());
	}

}
