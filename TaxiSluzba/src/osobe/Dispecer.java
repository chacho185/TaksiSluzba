package osobe;

import enumeracija.Pol;
import enumeracija.TelOdeljenja;

public class Dispecer extends Korisnik {
	
	private double plata;
	private String brTelLinije;
	private TelOdeljenja telOdeljenja;
	
	public Dispecer() {
		super();
		this.plata = 0;
		this.brTelLinije = "";
		this.telOdeljenja = null;
	}

	public Dispecer(int id, String korIme, String lozinka, String ime, String prezime, String jMBG, String adresa,
			Pol pol, String brTel, double plata, String brTelLinije, TelOdeljenja telOdeljenja) {
		super(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel);
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
		return "Dispecer [id=" + id + ", korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", jMBG=" + jMBG + ", adresa=" + adresa + ", pol=" + pol + ", brTel=" + brTel
				+ ", plata=" + plata + ", brTelLinije=" + brTelLinije + ", telOdeljenja=" + telOdeljenja + "]";
	}
	
}