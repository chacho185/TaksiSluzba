package osobe;

import java.util.ArrayList;
import java.util.List;

import enumeracija.Pol;
import taxiSluzba.Voznja;

public class Musterija extends Korisnik {
	
	//public List<Voznja> voznje = new ArrayList<Voznja>();

	public Musterija() {
		super();
		
	}


	public Musterija(int id, String korIme, String lozinka, String ime, String prezime, String jMBG, String adresa,
			Pol pol, String brTel,  boolean obrisan) {
		super(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel, obrisan);
		//this.voznje = voznje;
	}


	

	@Override
	public String toString() {
		return "Musterija [voznje=" + ", id=" + id + ", korIme=" + korIme + ", lozinka=" + lozinka + ", ime="
				+ ime + ", prezime=" + prezime + ", jMBG=" + jMBG + ", adresa=" + adresa + ", pol=" + pol + ", brTel="
				+ brTel + ", obrisan=" + obrisan + "]";
	}


//	public List<Voznja> getVoznje() {
//		return voznje;
//	}
//
//
//	public void setVoznje(List<Voznja> voznje) {
//		this.voznje = voznje;
//	}


	

	
}
