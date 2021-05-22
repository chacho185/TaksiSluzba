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
import enumeracija.PorucivanjeVoznje;
import enumeracija.Proizvodjac;
import enumeracija.StatusVoznje;
import enumeracija.TelOdeljenja;
import enumeracija.VrstaVozila;
import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;
import osobe.Korisnik;
import osobe.Musterija;
import osobe.Vozac;
import taxiSluzba.Automobil;
import taxiSluzba.Voznja;

public class RadSaDatotekama {
	
	public static ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();
	public static ArrayList<Automobil> automobili = new ArrayList<Automobil>();
	public static ArrayList<Musterija> musterije = new ArrayList<Musterija>();

	public static ArrayList<Vozac> vozaci = new ArrayList<Vozac>();
	public static ArrayList<Voznja> voznje = new ArrayList<Voznja>();
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	
	public static ArrayList<Dispecer> ucitajDispecere() {
		
		
		
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
						Boolean obrisan = Boolean.parseBoolean(lineSplit[12]);
						Dispecer dispecer = new Dispecer(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel, plata, brTelLinije, telOdeljenja,obrisan);
						dispeceri.add(dispecer);
						korisnici.add(dispecer);
					}
					reader.close();	
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja dispecera iz datoteke.");
				}
				
				return dispeceri;
			}
	
	public static ArrayList<Musterija> ucitajMusterije() {
	
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
						Boolean obrisan = Boolean.parseBoolean(lineSplit[9]);
						Musterija musterija = new Musterija(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel , obrisan); 
						musterije.add(musterija);
						korisnici.add(musterija);
					}
					reader.close();
					
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja musterija");
				}
				
				return musterije;
	}
	
	public static ArrayList<Vozac> ucitajVozace() {
		
				
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
						korisnici.add(vozac);
					}
					reader.close();
					
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja vozaca");
				}
				
				return vozaci;
	}
	
	public static Automobil nadjiAutomobil(int id) {
        for(Automobil automobil: automobili) {
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
						automobili.add(a);
				
					
					}
					reader.close();
					
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja musterija");
				}
				
				return automobili;
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
		
		return automobili;
	}
	
	
	
	public ArrayList<Dispecer> upisiDispecere(ArrayList<Dispecer> dispeceri) {
			
			
			File file = new File("src/txt/dispeceri.txt");
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				String sadrzaj = "";
				for (Dispecer dispecer : dispeceri) {
					sadrzaj += dispecer.getId() + "|" + dispecer.getKorIme() + "|" + dispecer.getLozinka() + "|" 
							+ dispecer.getIme() + "|" + dispecer.getPrezime() + "|"
							+ dispecer.getjMBG() + "|" + dispecer.getAdresa() + "|" 
							+ dispecer.getPol().ordinal() + "|" + dispecer.getBrTel() + "|" + dispecer.getPlata() + "|" +
							dispecer.getBrTelLinije() + "|" + dispecer.getTelOdeljenja().ordinal() + "|" + dispecer.isObrisan() + "\n";	
				}
				
				writer.write(sadrzaj);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom upisa dispecera u fajl.");
			}
			
			return dispeceri;
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
							+ musterija.getPol().ordinal() + "|" + musterija.getBrTel() + "|" + musterija.isObrisan() + "\n";	
				}
				
				writer.write(sadrzaj);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom upisa musterija u fajl.");
			}
			
			return musterije;
		}
	public ArrayList<Voznja> upisiVoznje(ArrayList<Voznja> voznje) {
		
		
		File file = new File("src/txt/voznje.txt");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Voznja voznja : voznje) {
				sadrzaj += voznja.getId() + "|" + voznja.getDatum() + "|" + voznja.getVremePorudzbine() + "|" 
						+ voznja.getAdresaPolaska() + "|" + voznja.getAdresaDestinacije() + "|" + voznja.getMusterija().getId() + "|" 
						+ voznja.getVozac().getId() + "|" + voznja.getBrojPredjenihKilometara() + "|" + voznja.getTrajanjeVoznje() + "|" 
						+ voznja.getStatus() + "|" + voznja.getPorucivanjeVoznje() + "\n";
				
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa voznji u fajl.");
		}
		
		return voznje;
	}
	public static ArrayList<Voznja> ucitajVoznje() {
		
				
				try {
					
					File file = new File("src/txt/voznje.txt");
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					while((line = reader.readLine()) !=null) {
						String[] lineSplit = line.split("\\|");
						int id = Integer.parseInt(lineSplit[0]);
						String datum = lineSplit[1];
						String vremePorudzbine = lineSplit[2];
						String adresaPolaska = lineSplit[3];
						String adresaDestinacije = lineSplit[4];
						int musterijaint = Integer.parseInt(lineSplit[5]);
						Musterija musterija = nadjiMusteriju(musterijaint);
						int vozacint = Integer.parseInt(lineSplit[6]);
						Vozac vozac = nadjiVozaca(vozacint);
						
						int brPredjenihKilometara = Integer.parseInt(lineSplit[7]);
						int trajanjeVoznje = Integer.parseInt(lineSplit[8]);
						String statusVoznje = lineSplit[9];
						StatusVoznje status = StatusVoznje.valueOf(statusVoznje);
						String porucivanjeVoznjestr = lineSplit[10];
						PorucivanjeVoznje porucivanjeVoznje = PorucivanjeVoznje.valueOf(porucivanjeVoznjestr);
						Voznja voznja = new Voznja(id, datum, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brPredjenihKilometara, trajanjeVoznje, status, porucivanjeVoznje);
						voznje.add(voznja);
						
					}
					reader.close();
					
				} catch (IOException e) {
					System.out.println("Greska prilikom citanja voznji");
				}
				
				return voznje;
	}
	
	public static Musterija nadjiMusteriju(int id) {
        for(Musterija musterija: musterije) {
            if(musterija.getId() == id) {
                return musterija;
            }
        }
        return null;
    }
	
	public static Vozac nadjiVozaca(int id) {
        for(Vozac vozac: vozaci) {
            if(vozac.getId() == id) {
                return vozac;
            }
        }
        return null;
    }
	
public ArrayList<Vozac> upisiVozace(ArrayList<Vozac> vozaci) {
		
		try {
			File file = new File("src/files/vozaci.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Vozac vozac : vozaci) {
				sadrzaj += vozac.getId() + "|" + vozac.getKorIme() + "|" + vozac.getLozinka() + "|" 
						+ vozac.getIme() + "|" + vozac.getPrezime() + "|"
						+ vozac.getjMBG() + "|" + vozac.getAdresa() + "|" 
						+ vozac.getPol().ordinal() + "|" + vozac.getBrTel() + "|" + vozac.getPlata() + "|" 
						+ vozac.getBrojClanskeKarte() + "|" + String.valueOf(vozac.getAutomobil().getId()) + "|"
						+ vozac.isObrisan() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa vozaca u fajl.");
		}
		
		return vozaci;
	}
	
	public Korisnik login(String korisnickoIme, String lozinka) {
		for (Korisnik musterija : korisnici) {
			if(musterija.getKorIme().equalsIgnoreCase(korisnickoIme) && 
					musterija.getLozinka().equals(lozinka) && !musterija.isObrisan()) {
				return musterija;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	

}
