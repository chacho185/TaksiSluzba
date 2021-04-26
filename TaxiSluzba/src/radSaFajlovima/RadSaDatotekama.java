package radSaFajlovima;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import enumeracija.ModelAutomobila;
import enumeracija.Pol;
import enumeracija.Proizvodjac;
import enumeracija.TelOdeljenja;
import enumeracija.VrstaVozila;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Vozac;
import taxiSluzba.Automobil;

public class RadSaDatotekama {
	
	private static ArrayList<Automobil> automobil = new ArrayList<Automobil>();
	
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
	
	public static ArrayList<Vozac> ucitajVozace() {
		ArrayList<Vozac> vozaci = new ArrayList<Vozac>();
				
				try {
					
					File file = new File("src/txt/vozaci.txt");
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
						int plata = Integer.parseInt(lineSplit[9]);
						String brojClanskeKarte = lineSplit[10];
						int idd = Integer.parseInt(lineSplit[11]);
						Automobil automobil = nadjiAutomobil(idd);
						Boolean obrisan = Boolean.parseBoolean(lineSplit[12]);
						Vozac vozac = new Vozac(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel, plata, brojClanskeKarte, automobil, obrisan);
						vozaci.add(vozac);
					}
					reader.close();
					
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja musterija");
				}
				
				return vozaci;
	}
	
	public static Automobil nadjiAutomobil(int id) {
        for(Automobil automobil: automobil) {
            if(automobil.getId() == id) {
                return automobil;
            }
        }
        return null;
    }
	
	public static ArrayList<Automobil> ucitajAutomobile() {
		
				
				try {
					
					File file = new File("src/txt/automobili.txt");
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					while((line = reader.readLine()) !=null) {
						String[] lineSplit = line.split("\\|");
						int id = Integer.parseInt(lineSplit[0]);
						String modelString = lineSplit[1];
						ModelAutomobila model = ModelAutomobila.valueOf(modelString);
						
						String proizvodjacString = lineSplit[2];
						Proizvodjac proizvodjac = Proizvodjac.valueOf(proizvodjacString);
						String godinaProizvodnje = lineSplit[3];
						String brRegOznake = lineSplit[4];
						String vrstaVozilaString = lineSplit[5];
						VrstaVozila vrsta = VrstaVozila.valueOf(vrstaVozilaString);
						Automobil a = new Automobil(id, model, proizvodjac, godinaProizvodnje, brRegOznake, vrsta);
						automobil.add(a);
				
					
					}
					reader.close();
					
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja musterija");
				}
				
				return automobil;
	}
	public ArrayList<Automobil> upisiAutomobile(ArrayList<Automobil> automobili) {
		
		
		File file = new File("src/txt/automobili.txt");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Automobil automobil : automobili) {
				sadrzaj += automobil.getId() + "|" + automobil.getModel() + "|" +automobil.getProizvodjac() + "|" + automobil.getGodinaProizvodnje()
				+"|" + automobil.getBrRegOznake() + "|" + automobil.getVrstaVozila() + "\n";
			} 
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa automobila u fajl.");
		}
		
		return automobil;
	}
						
						
	
	
	
	public ArrayList<Musterija> upisiMusterije(ArrayList<Musterija> musterije) {
			
			
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
