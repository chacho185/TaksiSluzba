package main;

import java.util.ArrayList;

import enumeracija.ModelAutomobila;
import enumeracija.Pol;
import enumeracija.PorucivanjeVoznje;
import enumeracija.Proizvodjac;
import enumeracija.StatusVoznje;
import enumeracija.TelOdeljenja;
import enumeracija.VrstaVozila;
import gui.LoginProzor;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Vozac;
import radSaFajlovima.RadSaDatotekama;
import taxiSluzba.Automobil;
import taxiSluzba.TaksiSluzba;
import taxiSluzba.Voznja;

public class KolekcijeTest {
	

	public static void main(String[] args) {
		
		RadSaDatotekama rsd = new RadSaDatotekama();
		rsd.ucitajAutomobile();	
		rsd.ucitajDispecere();
		rsd.ucitajMusterije();
		rsd.ucitajTaksiSluzbe();
		rsd.ucitajVozace();
		rsd.ucitajVoznje();
		
//		ArrayList<Automobil> aa = new ArrayList<Automobil>();
//		System.out.println("Dodavanjw automobila");
//		Automobil automobil = new Automobil(1, ModelAutomobila.GOLF4, Proizvodjac.VOLKSWAGEN, "2004", "12-12", VrstaVozila.PUTNICKI_AUTOMOBIL);
//		aa.add(automobil);
//		rsd.upisiAutomobile(aa);
//		System.out.println(automobil);
//		
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
//		
//		ArrayList<Musterija> musterije = new ArrayList<Musterija>();
//		System.out.println("Dodavanje musterije: ");
//		Musterija testMusterija = new Musterija(2, "Mare", "mare123", "Marko", "Markovic", "15210521152", "Alekse Santica 5", Pol.MUSKI, "065424141" , false);
//		Musterija testMusterija2 = new Musterija(3, "Mare", "ranko123", "Ranko", "Markovic", "15210521152", "Alekse Santica 5", Pol.MUSKI, "065424141" , false);
//		musterije.add(testMusterija);
//		musterije.add(testMusterija2);
//		rsd.upisiMusterije(musterije);
//		System.out.println(testMusterija);
//		
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//		
//		ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();
//		System.out.println("Dodavanje dispecera");
//		Dispecer testDispecer = new Dispecer(3,"Njego123","jego222", "Njegos", "Sikimic", "123333" , "Kneza Miroslava" , Pol.MUSKI , "321567" , 100000.0 , "321312" , TelOdeljenja.ODELJENJE_ZA_PRIJEM_VOZNJI,false );
//		dispeceri.add(testDispecer);
//		rsd.upisiDispecere(dispeceri);
//		System.out.println(testDispecer);
//		
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//		ArrayList<Dispecer> ucitaniDispeceri = RadSaDatotekama.ucitajDispecere();
//		
//		System.out.println("Ucitani dispeceri:");
//		for (Dispecer dispecer : ucitaniDispeceri) {
//			
//			System.out.println(dispecer);
//			
//		}
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//		ArrayList<TaksiSluzba> ucitaneTaksiSluzbe = RadSaDatotekama.ucitajTaksiSluzbe();
//		
//		System.out.println("Ucitane taksi sluzbe");
//		for (TaksiSluzba taksiSluzba : ucitaneTaksiSluzbe) {
//			
//			System.out.println(taksiSluzba);
//			
//		}
//		
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

//		
//		ArrayList<Automobil> ucitaniAutomobili = RadSaDatotekama.ucitajAutomobile();
//		
//		System.out.println("Ucitani automobili");
//		for (Automobil automobil2 : ucitaniAutomobili) {
//			
//			System.out.println(automobil2);
//		} 
//			
//			
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
//	
//		
//		ArrayList<Vozac> ucitaniVozaci = RadSaDatotekama.ucitajVozace();
//		System.out.println("Ucitani vozaci");
//		for (Vozac vozac : ucitaniVozaci) {
//			System.out.println(vozac);
//		
//		}
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//		System.out.println("Dodavanje vozaca");
//		Vozac vozac = new Vozac(1, "caco", "truck", "cacoo", "sike", "jmbg", "adresa", Pol.MUSKI, "tel", 1520.00, "clanska karta", automobil, false);
//		RadSaDatotekama.vozaci.add(vozac);
//		rsd.upisiVozace(rsd.vozaci);
//		System.out.println(vozac);
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//		System.out.println("Dodavanje voznje");
//		Voznja voznnja = new Voznja(1, "datum", "vrijeme", "adresa", "destinacija", testMusterija, vozac, 155000, 150, StatusVoznje.KREIRANA, PorucivanjeVoznje.TELEFON);
//		RadSaDatotekama.voznje.add(voznnja);
//		rsd.upisiVoznje(rsd.voznje);
//		System.out.println(voznnja);
//		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
//
////		ArrayList<Voznja> voznje2 = rsd.ucitajVoznje();
//		System.out.println("Ucitane voznje");
//		for (Voznja voznja : rsd.voznje) {
//			System.out.println(voznja);
//		}
		
		LoginProzor lp = new LoginProzor(rsd);
		lp.setVisible(true);
	}
	
	
	
	
	
	
	

}
