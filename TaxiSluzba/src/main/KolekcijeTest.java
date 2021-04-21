package main;

import java.util.ArrayList;

import enumeracija.Pol;
import osobe.Dispecer;
import osobe.Musterija;
import radSaFajlovima.RadSaDatotekama;

public class KolekcijeTest {

	public static void main(String[] args) {
		RadSaDatotekama rsd = new RadSaDatotekama();
		System.out.println("Dodavanje musterije: ");
		Musterija testMusterija = new Musterija(2, "Mare", "mare123", "Marko", "Markovic", "15210521152", "Alekse Santica 5", Pol.MUSKI, "065424141");
		
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
	}
	
	
	
	

}
