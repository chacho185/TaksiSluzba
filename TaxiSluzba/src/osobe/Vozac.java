package osobe;

import enumeracija.Pol;
import taxiSluzba.Automobil;

public class Vozac extends Korisnik {
	
	private double plata;
	private String brojClanskeKarte;
	private Automobil automobil;
	
	
	public Vozac() {
		super();
		this.plata = 0;
		this.brojClanskeKarte = "";
		this.automobil = new Automobil();
		
		
	}

	

	public Vozac(int id, String korIme, String lozinka, String ime, String prezime, String jMBG, String adresa, Pol pol,
			String brTel, double plata, String brojClanskeKarte, Automobil automobil, boolean obrisan) {
		super(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel, obrisan);
		this.plata = plata;
		this.brojClanskeKarte = brojClanskeKarte;
		this.automobil = automobil;
	}



	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}

	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}

	public Automobil getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}



	@Override
	public String toString() {
		return "Vozac [plata=" + plata + ", brojClanskeKarte=" + brojClanskeKarte + ", automobil=" + automobil + ", id="
				+ id + ", korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", jMBG=" + jMBG + ", adresa=" + adresa + ", pol=" + pol + ", brTel=" + brTel + ", obrisan=" + obrisan
				+ "]";
	}


}
