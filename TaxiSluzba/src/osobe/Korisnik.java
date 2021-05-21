package osobe;

import enumeracija.Pol;

public abstract class Korisnik {
	
	protected int id;
	protected String korIme;
	protected String lozinka;
	protected String ime;
	protected String prezime;
	protected String jMBG;
	protected String adresa;
	protected Pol pol;
	protected String brTel;
	protected boolean obrisan;
	
	public Korisnik() {
		
		this.id = 0;
		this.korIme = "";
		this.lozinka = "";
		this.ime = "";
		this.prezime = "";
		this.jMBG = "";
		this.adresa = "";
		this.pol = null;
		this.brTel = "";
		this.obrisan = false;
	}

	public Korisnik(int id, String korIme, String lozinka, String ime, String prezime, String jMBG, String adresa,
			Pol pol, String brTel, boolean obrisan) {
		super();
		this.id = id;
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.jMBG = jMBG;
		this.adresa = adresa;
		this.pol = pol;
		this.brTel = brTel;
		this.obrisan = obrisan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getjMBG() {
		return jMBG;
	}

	public void setjMBG(String jMBG) {
		this.jMBG = jMBG;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public String getBrTel() {
		return brTel;
	}

	public void setBrTel(String brTel) {
		this.brTel = brTel;
	}
	
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime="
				+ prezime + ", jMBG=" + jMBG + ", adresa=" + adresa + ", pol=" + pol + ", brTel=" + brTel + ", obrisan=" 
				+ obrisan + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
