package osobe;

import enumeracija.Pol;
import taxiSluzba.Automobil;

public class Vozac extends Korisnik {
	
	private double plata;
	private String brojClanskeKarte;
	private Automobil automobil;
	private boolean obrisan;
	
	public Vozac() {
		super();
		this.plata = 0;
		this.brojClanskeKarte = "";
		this.automobil = new Automobil();
		this.obrisan = false;
		
	}

	public Vozac(int id, String korIme, String lozinka, String ime, String prezime, String jMBG, String adresa, Pol pol,
			String brTel, double plata, String brojClanskeKarte, Automobil automobil, boolean obrisan) {
		super(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel);
		this.plata = plata;
		this.brojClanskeKarte = brojClanskeKarte;
		this.automobil = automobil;
		this.obrisan = obrisan;
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

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Vozac [plata=" + plata + ", brojClanskeKarte=" + brojClanskeKarte + ", automobil=" + automobil
				+ ", obrisan=" + obrisan + ", id=" + id + ", korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime
				+ ", prezime=" + prezime + ", JMBG=" + jMBG + ", adresa=" + adresa + ", pol=" + pol + ", brTel=" + brTel
				+ "]";
	}
	
	
	
	
	
	

}
