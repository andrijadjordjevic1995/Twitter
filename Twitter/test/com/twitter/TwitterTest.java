/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Andrija
 *
 */
public class TwitterTest {
	Twitter t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		//Lista je inicijalizovana pri kreiranju objekta tako da nema potrebe za testiranjem,
		//moze vratiti praznu listu.
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesiOk() {
		String korisnik = "Pera Peric";
		String poruka = "testtesttest";
		t.unesi(korisnik, poruka);
		assertEquals(korisnik, t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals(poruka, t.vratiSvePoruke().getLast().getPoruka());
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikNull() {
		String korisnik = null;
		String poruka = "testtesttest";
		t.unesi(korisnik, poruka);
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaNull() {
		String korisnik = "Korisnik";
		String poruka = null;
		t.unesi(korisnik, poruka);
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikPrazan() {
		String korisnik = "";
		String poruka = "testtesttest";
		t.unesi(korisnik, poruka);
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPoruka140() {
		String korisnik = "Korisnik";
		String poruka = "Ova poruka je duza od 140 znakova i treba da izazove bacanje izuzetka tipa"
				+ " RuntimeException, u slucaju da ne izazove,"
				+ " znamo da nas test nije prosao i da sa uslovom u metodi nesto nije u redu";
		t.unesi(korisnik, poruka);
	}

	/**
	 * Test deluje komplikovanije nego sto jeste jer nije redefinisana equals metoda za klasu TwitterPoruka
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeOk() {
		String korisnik = "Pera";
		String poruka = "tagtagtag";
		String[] provera = new String[50];
		
		for (int i = 0; i < 5; i++) {
			provera[i] = poruka;
			t.unesi(korisnik, poruka);
		}
		TwitterPoruka[] povratna = t.vratiPoruke(50, "tag");
		String[] pov = new String[povratna.length];
		for(int i = 0 ; i < povratna.length ; i++){
			if(povratna[i] == null)
				break;
			pov[i] = povratna[i].getPoruka();
		}
		
		
		
		assertArrayEquals(provera, pov);
		
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		TwitterPoruka[] povratna = t.vratiPoruke(50, null);
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan() {
		TwitterPoruka[] povratna = t.vratiPoruke(50, "");
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeMaxBrNula() {
		String korisnik = "Pera";
		String poruka = "tagtagtag";

		for (int i = 0; i < 100; i++) {
			t.unesi(korisnik, poruka);
		}
		TwitterPoruka[] povratna = t.vratiPoruke(-16, "tag");
		
		
		for(int i = 0 ; i < povratna.length ; i++){
			if(povratna[i] == null)
				break;
			assertEquals(poruka, povratna[i].getPoruka());
		}
	}
	/**
	 * Ako u listi ima dovoljan(maxBroj) broj poruka koje odgovaraju tagu koji se prosledjuje, 
	 * dolazi do prekida programa usled pristupa lokaciji rezultat[maxBroj] buduci da je niz kapaciteta maxBroj
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeBrojacArrayIndex() {
//		String korisnik = "Pera";
//		String poruka = "tagtagtag";
//		for (int i = 0; i < 5; i++) {
//			t.unesi(korisnik, poruka);
//		}
//		TwitterPoruka[] povratna = t.vratiPoruke(50, "tag");
//
//		assertFalse(povratna[0] == null);
		
		String korisnik = "Pera";
		String poruka = "tagtagtag";
		for (int i = 0; i < 5; i++) {
			t.unesi(korisnik, poruka);
		}
		TwitterPoruka[] povratna = t.vratiPoruke(5, "tag");
		//Ispravljena, bez ArrayIndexOutOfBoundsException-a
		
	}

}
