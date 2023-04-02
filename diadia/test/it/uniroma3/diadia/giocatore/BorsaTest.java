package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo2;

	@Before
	public void setUp() {
		borsa = new Borsa();
		attrezzo = new Attrezzo("attrezzo", 3);	
		this.borsa.addAttrezzo(attrezzo);
		attrezzo2 = new Attrezzo("attrezzo2", 2);

	}

	@Test
	public void testAddAttrezzo() {
		assertEquals(attrezzo, borsa.getAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testSecondoAddAttrezzo() {
		this.borsa.addAttrezzo(attrezzo2);
		assertEquals(this.borsa.getAttrezzo("attrezzo"), attrezzo);
		assertEquals(this.borsa.getAttrezzo("attrezzo2"), attrezzo2);
	}
	
	@Test
	public void testAddAttrezzoOltrePesoLimite() {
		Attrezzo attrezzoPesante = new Attrezzo("attrezzoPesante", 9);
		this.borsa.addAttrezzo(attrezzoPesante);
		assertNull(this.borsa.getAttrezzo(attrezzoPesante.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		this.borsa.removeAttrezzo("attrezzo");
		assertNull(this.borsa.getAttrezzo(attrezzo.getNome()));
	}
	
	@Test 
	public void testSecondoRemoveAttrezzo() {
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.removeAttrezzo(attrezzo2.getNome());
		assertNull(this.borsa.getAttrezzo("attrezzo2"));
	}
	
	@Test
	public void testScalaArrayAttrezziDopoRemoveAttrezzo() {
		this.borsa.addAttrezzo(this.attrezzo2);
		this.borsa.removeAttrezzo(attrezzo.getNome());
		assertEquals(this.borsa.getAttrezzi()[0], attrezzo2);
	}
}
