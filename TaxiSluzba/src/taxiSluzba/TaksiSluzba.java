package taxiSluzba;

public class TaksiSluzba {
	
	private int PIB;
	private String naziv;
	private String adresa;
	private double cenaStartaVoznje;
	private double cenaPoKilometru;
	
	
	private TaksiSluzba() {
		
		this.PIB = 0;
		this.naziv = "";
		this.adresa = "";
		this.cenaStartaVoznje = 0;
		this.cenaPoKilometru = 0;
		
	}


	public TaksiSluzba(int pIB, String naziv, String adresa, double cenaStartaVoznje, double cenaPoKilometru) {
		super();
		PIB = pIB;
		this.naziv = naziv;
		this.adresa = adresa;
		this.cenaStartaVoznje = cenaStartaVoznje;
		this.cenaPoKilometru = cenaPoKilometru;
	}


	public int getPIB() {
		return PIB;
	}


	public void setPIB(int pIB) {
		PIB = pIB;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public double getCenaStartaVoznje() {
		return cenaStartaVoznje;
	}


	public void setCenaStartaVoznje(double cenaStartaVoznje) {
		this.cenaStartaVoznje = cenaStartaVoznje;
	}


	public double getCenaPoKilometru() {
		return cenaPoKilometru;
	}


	public void setCenaPoKilometru(double cenaPoKilometru) {
		this.cenaPoKilometru = cenaPoKilometru;
	}
	
	
	

}


