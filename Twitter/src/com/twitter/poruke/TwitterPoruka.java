package com.twitter.poruke;

/**
 * 
 * @author Andrija Djordjevic
 * @version 0.1 prva verzija klase TwitterPoruka
 *
 */
public class TwitterPoruka {
	/**
	 Cuva se ime korisnika
	 */
	private String korisnik;
	
	/**
	 * Cuva se sadrzaj poruke
	 */
	private String poruka;

	/**
	 * 
	 * @return Vraca String koji sadrzi ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * 
	 * @param korisnik sadrzi ime korisnika
	 * 
	 * Metoda postavlja vrednost atributa korisnik na prosledjenu vrednost
	 * 
	 * @throws RuntimeException ako se metodi prosledi null ili prazan String
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * 
	 * @return Vraca String koji sadrzi poruku
	 */
	public String getPoruka() {
		return "poruka";
	}

	/**
	 * 
	 * @param poruka sadrzi poruku koju je poslao korisnik
	 * 
	 * @throws RuntimeException u slucaju da je prosledjena poruka null ili ima vise od 140 znakova
	 * 
	 * Metoda dodeljuje atributu poruka prosledjenu vrednost (vrednost parametra poruka)
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Redefinisana metoda toString
	 * 
	 * @return String koji sadrzi ime korisnika i poruku
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
