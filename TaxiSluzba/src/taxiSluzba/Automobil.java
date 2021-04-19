package taxiSluzba;

import enumeracija.ModelAutomobila;
import enumeracija.Proizvodjac;
import enumeracija.VrstaVozila;

public class Automobil {
	
	private int id;
	private ModelAutomobila model;
	private Proizvodjac proizvodjac;
	private String godinaProizvodnje;
	private String brRegOznake;
	private VrstaVozila vrstaVozila;
	
	public Automobil() {
		this.id = 0;
		this.model = null;
		this.proizvodjac = null;
		this.godinaProizvodnje = "";
		this.brRegOznake = "";
		this.vrstaVozila= null;
	}

	public Automobil(int id, ModelAutomobila model, Proizvodjac proizvodjac, String godinaProizvodnje,
			String brRegOznake, VrstaVozila vrstaVozila) {
		super();
		this.id = id;
		this.model = model;
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.brRegOznake = brRegOznake;
		this.vrstaVozila = vrstaVozila;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ModelAutomobila getModel() {
		return model;
	}

	public void setModel(ModelAutomobila model) {
		this.model = model;
	}

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public String getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(String godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getBrRegOznake() {
		return brRegOznake;
	}

	public void setBrRegOznake(String brRegOznake) {
		this.brRegOznake = brRegOznake;
	}

	public VrstaVozila getVrstaVozila() {
		return vrstaVozila;
	}

	public void setVrstaVozila(VrstaVozila vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}

	@Override
	public String toString() {
		return "Automobil [id=" + id + ", model=" + model + ", proizvodjac=" + proizvodjac + ", godinaProizvodnje="
				+ godinaProizvodnje + ", brRegOznake=" + brRegOznake + ", vrstaVozila=" + vrstaVozila + "]";
	}
	
	

}
