package osobe;

import enumeracija.Pol;

public class Musterija extends Korisnik {

	public Musterija() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Musterija(int id, String korIme, String lozinka, String ime, String prezime, String jMBG, String adresa,
			Pol pol, String brTel) {
		super(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Musterija [id=" + id + ", korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime="
				+ prezime + ", JMBG=" + jMBG + ", adresa=" + adresa + ", pol=" + pol + ", brTel=" + brTel + "]";
	}
	
	
	
	

}
