package osobe;

import enumeracija.TelOdeljenja;

public class Dispecer extends Korisnik {
	
	private double plata;
	private String brTelLinije;
	private TelOdeljenja telOdeljenja;
	
	public Dispecer() {
		this.plata = 0;
		this.brTelLinije = "";
		this.telOdeljenja = null;
	}

	public Dispecer(double plata, String brTelLinije, TelOdeljenja telOdeljenja) {
		super();
		this.plata = plata;
		this.brTelLinije = brTelLinije;
		this.telOdeljenja = telOdeljenja;
	}
	
	

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getBrTelLinije() {
		return brTelLinije;
	}

	public void setBrTelLinije(String brTelLinije) {
		this.brTelLinije = brTelLinije;
	}

	public TelOdeljenja getTelOdeljenja() {
		return telOdeljenja;
	}

	public void setTelOdeljenja(TelOdeljenja telOdeljenja) {
		this.telOdeljenja = telOdeljenja;
	}

	@Override
	public String toString() {
		return "Dispecer [plata=" + plata + ", brTelLinije=" + brTelLinije + ", telOdeljenja=" + telOdeljenja + ", id="
				+ id + ", korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol=" + pol + ", brTel=" + brTel + "]";
	}
	
	

}
