package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanzaTest;
	private Stanza stanzaAdiacenteTest;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	
	@Before
	public void setUp() {
		this.stanzaTest = new Stanza("Stanza Test");
		this.stanzaAdiacenteTest = new Stanza("Stanza Adiacente");
		this.attrezzo1 = new Attrezzo("attrezzo1", 2);
		this.attrezzo2 = new Attrezzo("attrezzo2", 3);
		this.stanzaTest.addAttrezzo(attrezzo1);
	}
	
	@Test
	public void testAddAttrezzo() {
		assertEquals(this.stanzaTest.getAttrezzo("attrezzo1"),this.attrezzo1);
	}
	
	@Test
	public void testAggiungiSecondoAttrezzoAddAttrezzo() {
		this.stanzaTest.addAttrezzo(attrezzo2);
		assertNotNull(this.stanzaTest.getAttrezzo("attrezzo1"));
		assertNotNull(this.stanzaTest.getAttrezzo("attrezzo2"));
	}
	
	@Test
	public void testOltreNumeroMassimoAttrezziAddAttrezzo() {
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 1);
		Attrezzo attrezzo4 = new Attrezzo("attrezzo4", 1);
		Attrezzo attrezzo5 = new Attrezzo("attrezzo5", 1);
		Attrezzo attrezzo6 = new Attrezzo("attrezzo6", 1);
		Attrezzo attrezzo7 = new Attrezzo("attrezzo7", 1);
		Attrezzo attrezzo8 = new Attrezzo("attrezzo8", 1);
		Attrezzo attrezzo9 = new Attrezzo("attrezzo9", 1);
		Attrezzo attrezzo0 = new Attrezzo("attrezzo0", 1);
		Attrezzo attrezzoNonAggiunto = new Attrezzo("attrezzoNonAggiunto", 1);

		this.stanzaTest.addAttrezzo(this.attrezzo2);
		this.stanzaTest.addAttrezzo(attrezzo3);
		this.stanzaTest.addAttrezzo(attrezzo4);
		this.stanzaTest.addAttrezzo(attrezzo5);
		this.stanzaTest.addAttrezzo(attrezzo6);
		this.stanzaTest.addAttrezzo(attrezzo7);
		this.stanzaTest.addAttrezzo(attrezzo8);
		this.stanzaTest.addAttrezzo(attrezzo9);
		this.stanzaTest.addAttrezzo(attrezzo0);
		this.stanzaTest.addAttrezzo(attrezzoNonAggiunto);
		assertNull(this.stanzaTest.getAttrezzo("attrezzoNonAggiunto"));
	}
	
	@Test
	public void testGetStanzaAdiacente () {
		stanzaTest.impostaStanzaAdiacente("nord", this.stanzaAdiacenteTest);
		assertEquals(this.stanzaAdiacenteTest, this.stanzaTest.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteIsNull() {
		assertNull(this.stanzaTest.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		this.stanzaTest.impostaStanzaAdiacente("ovest", stanzaAdiacenteTest);
		assertEquals(stanzaAdiacenteTest, this.stanzaTest.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testSovrascriviImpostaStanzaAdiacente() {
		Stanza stanzaTestSovrascritta = new Stanza("stanza-sovrascritta");
		this.stanzaTest.impostaStanzaAdiacente("nord", stanzaTestSovrascritta);
		assertEquals(stanzaTestSovrascritta, this.stanzaTest.getStanzaAdiacente("nord"));
		this.stanzaTest.impostaStanzaAdiacente("nord", this.stanzaAdiacenteTest);
		assertEquals(this.stanzaAdiacenteTest, this.stanzaTest.getStanzaAdiacente("nord"));
		
	}
	
	@Test 
	public void testNumeroStanzeAdiacentiImpostaStanzaAdiacente() {
		this.stanzaTest.impostaStanzaAdiacente("nord", stanzaAdiacenteTest);
		assertEquals(this.stanzaTest.getNumeroStanzeAdiacenti(), 1);
	}
	
	@Test
	public void testRemovePrimoAttrezzo() {
		this.stanzaTest.removeAttrezzo(this.attrezzo1.getNome());
		assertFalse(this.stanzaTest.hasAttrezzo(this.attrezzo1.getNome()));
		
	}
	
	@Test
	public void testRemoveSecondoAttrezzo() {
		this.stanzaTest.addAttrezzo(this.attrezzo2);
		this.stanzaTest.removeAttrezzo(this.attrezzo2.getNome());
		assertFalse(this.stanzaTest.hasAttrezzo(this.attrezzo2.getNome()));
	}
	
	@Test 
	public void nonRimuoveRemoveAttrezzo() {
		assertFalse(this.stanzaTest.removeAttrezzo("attrezzoInesistente"));
	}
	
	
	
	

}
