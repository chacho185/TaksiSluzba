package main;

import java.util.ArrayList;

import enumeracija.ModelAutomobila;
import enumeracija.Pol;
import enumeracija.Proizvodjac;
import enumeracija.VrstaVozila;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Vozac;
import radSaFajlovima.RadSaDatotekama;
import taxiSluzba.Automobil;

public class KolekcijeTest {

	public static void main(String[] args) {
		RadSaDatotekama rsd = new RadSaDatotekama();
		ArrayList<Automobil> aa = new ArrayList<Automobil>();

		Automobil automobil = new Automobil(1, ModelAutomobila.GOLF4, Proizvodjac.VOLKSWAGEN, "2004", "12-12", VrstaVozila.PUTNICKI_AUTOMOBIL);
		aa.add(automobil);
		rsd.upisiAutomobile(aa);
		
		ArrayList<Musterija> musterije = new ArrayList<Musterija>();
		System.out.println("Dodavanje musterije: ");
		Musterija testMusterija = new Musterija(2, "Mare", "mare123", "Marko", "Markovic", "15210521152", "Alekse Santica 5", Pol.MUSKI, "065424141");
		Musterija testMusterija2 = new Musterija(3, "Mare", "ranko123", "Ranko", "Markovic", "15210521152", "Alekse Santica 5", Pol.MUSKI, "065424141");
		musterije.add(testMusterija);
		musterije.add(testMusterija2);
		rsd.upisiMusterije(musterije);
		System.out.println(testMusterija);
		
		ArrayList<Dispecer> ucitaniDispeceri = RadSaDatotekama.ucitajDispecere();
		
		System.out.println("Ucitani dispeceri:");
		for (Dispecer dispecer : ucitaniDispeceri) {
			
			System.out.println(dispecer);
			
		}
		
		ArrayList<Musterija> ucitaneMusterije = RadSaDatotekama.ucitajMusterije();
		
		System.out.println("Ucitane musterije");
		for (Musterija musterija : ucitaneMusterije) {
			
			System.out.println(musterija);
			
		}
		
		ArrayList<Automobil> ucitaniAutomobili = RadSaDatotekama.ucitajAutomobile();
		
		System.out.println("Ucitani automobili");
		for (Automobil automobil2 : ucitaniAutomobili) {
			
			System.out.println(automobil2);
		} 
			
			
			
		
		ArrayList<Vozac> ucitaniVozaci = RadSaDatotekama.ucitajVozace();
		System.out.println("Ucitani vozaci");
		for (Vozac vozac : ucitaniVozaci) {
			System.out.println(vozac);
		
		}
		
	}
	
	
	
	

}
