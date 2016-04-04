/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrija
 *
 */
public class TwitterPorukaTest {
	TwitterPoruka tp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 * Prosledjuje se String koji nije prazan ili null
	 */
	@Test
	public void testSetKorisnikOk() {
		String expected = "Provera Korisnika";
		tp.setKorisnik(expected);
		assertEquals(expected, tp.getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 * Prosledjuje se null
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
		
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 * Prosledjuje se prazan String
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazan() {
		tp.setKorisnik("");
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 * Prosledjuje se poruka koja nije null ili prazan String
	 * Test ne prolazi zbog greske u metodi getPoruka koja vraca String "poruka" umesto vrednosti privatnog
	 * atributa poruka
	 */
	@Test
	public void testSetPorukaOk() {
		String expected = "Provera poruke";
		tp.setPoruka(expected);
		assertEquals(expected, tp.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 * Prosledjuje se bilo koji String razliciti od null i kraci od 140 znakova
	 *  i proverava se da li getPoruka() i dalje vraca String "poruka"
	 */
	@Test
	public void testSetPorukaPoruka() {
		String expected = "Provera poruke koja se ne koristi u assertEquals";
		tp.setPoruka(expected);
		assertFalse("poruka".equals(tp.getPoruka()));
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 * Prosledjuje se null
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 * Prosledjuje se poruka duza od 140 znakova
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPoruka140() {
		tp.setPoruka("Ova poruka je duza od 140 znakova i treba da izazove bacanje izuzetka tipa"
				+ " RuntimeException, u slucaju da ne izazove,"
				+ " znamo da nas test nije prosao i da sa uslovom u metodi nesto nije u redu");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToStringOk() {
		tp.setKorisnik("Andrija");
		tp.setPoruka("Ovo je poruka");
		assertTrue(tp.toString().equals("KORISNIK:" + "Andrija" + " PORUKA:" + "Ovo je poruka"));
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 * Slucaj kada atributima korisnik i poruka nisu dodeljene vrednosti, 
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testToStringNull() {
		tp.toString();
	}
	

}
