package radSaFajlovima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import enumeracija.Pol;
import enumeracija.TelOdeljenja;
import osobe.Dispecer;
import osobe.Musterija;

public class RadSaDatotekama {
	
	public static ArrayList<Dispecer> ucitajDispecere() {
		 ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();
		
		
				try {
					File file = new File("src/txt/dispeceri.txt");
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					while((line = reader.readLine()) !=null) {
						String[] lineSplit = line.split("\\|");
						int id = Integer.parseInt(lineSplit[0]);
						String korIme = lineSplit[1];
						String lozinka = lineSplit[2];
						String ime = lineSplit[3];
						String prezime = lineSplit[4];
						String jMBG = lineSplit[5];
						String adresa = lineSplit[6];
						Pol pol = Pol.values()[Integer.parseInt(lineSplit[7])];
						String brTel = lineSplit[8];
						double plata = Double.parseDouble(lineSplit[9]);
						String brTelLinije = lineSplit[10];
						TelOdeljenja telOdeljenja = TelOdeljenja.values()[Integer.parseInt(lineSplit[11])];
						Dispecer dispecer = new Dispecer(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel, plata, brTelLinije, telOdeljenja);
						dispeceri.add(dispecer);
						
					}
					reader.close();	
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja dispecera iz datoteke.");
				}
				
				return dispeceri;
			}
	
	public static ArrayList<Musterija> ucitajMusterije() {
		ArrayList<Musterija> musterije = new ArrayList<Musterija>();
				
				try {
					
					File file = new File("src/txt/musterije.txt");
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					while((line = reader.readLine()) !=null) {
						String[] lineSplit = line.split("\\|");
						int id = Integer.parseInt(lineSplit[0]);
						String korIme = lineSplit[1];
						String lozinka = lineSplit[2];
						String ime = lineSplit[3];
						String prezime = lineSplit[4];
						String jMBG = lineSplit[5];
						String adresa = lineSplit[6];
						Pol pol = Pol.values()[Integer.parseInt(lineSplit[7])];
						String brTel = lineSplit[8];
						Musterija musterija = new Musterija(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel);
						musterije.add(musterija);
					}
					reader.close();
					
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja musterija");
				}
				
				return musterije;
	}
	
	public ArrayList<Musterija> upisiMusterije() {
			ArrayList<Musterija> musterije = new ArrayList<Musterija>();
			
			File file = new File("src/txt/musterije.txt");
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				String sadrzaj = "";
				for (Musterija musterija : musterije) {
					sadrzaj += musterija.getId() + "|" + musterija.getKorIme() + "|" + musterija.getLozinka() + "|" 
							+ musterija.getIme() + "|" + musterija.getPrezime() + "|"
							+ musterija.getjMBG() + "|" + musterija.getAdresa() + "|" 
							+ musterija.getPol().ordinal() + "|" + musterija.getBrTel() + "\n";
				}
				
				writer.write(sadrzaj);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom upisa musterija u fajl.");
			}
			return musterije;
		}
		
	
	

}
