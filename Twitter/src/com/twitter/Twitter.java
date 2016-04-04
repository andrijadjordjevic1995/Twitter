package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;
/**
 * 
 * @author Andrija Djordjevic
 *
 */
public class Twitter {
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vraca sve poruke iz liste
	 * @return povratna vrednost je lista objekata TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda kreira novu poruku na osnovu prosledjenog imena korisnika i poruke i dodaje je na kraj liste
	 * poruke
	 * 
	 * @param korisnik ime korisnika
	 * @param poruka sadrzaj poruke
	 * 
	 * 
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * 
	 * Metoda vraca poruke koje sadrze String tag. Vraca najvise maxBroj poruka.
	 * 
	 * @param maxBroj maksimalni broj poruka koje se vracaju (ujedno i kapacitet niza)
	 * @param tag String na osnovu kojeg se odredjuju poruke koje treba vratiti
	 * @return niz objekata TwitterPoruka ciji privatni atribut poruka sadrzi zadati tag
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
