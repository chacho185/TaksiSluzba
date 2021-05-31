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
import taxiSluzba.TaksiSluzba;
import taxiSluzba.Voznja;

public class RadSaDatotekama {
	
	public static ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();
	public static ArrayList<Automobil> automobili = new ArrayList<Automobil>();
	public static ArrayList<Musterija> musterije = new ArrayList<Musterija>();
	public static ArrayList<Vozac> vozaci = new ArrayList<Vozac>();
	public static ArrayList<Voznja> voznje = new ArrayList<Voznja>();
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	public static ArrayList<TaksiSluzba> taksiSluzbe = new ArrayList<TaksiSluzba>();
	
	public void dodajDispecera(Dispecer dispecer) {
		RadSaDatotekama.dispeceri.add(dispecer);
	}
	public void dodajVozaca(Vozac vozac) {
		RadSaDatotekama.vozaci.add(vozac);
	}
	
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
						double plata = Double.parseDouble(lineSplit[9]);
						String brojClanskeKarte = lineSplit[10];
						int idd = Integer.parseInt(lineSplit[11]);
						Automobil automobil = nadjiAutomobil(idd);
						Boolean obrisan = Boolean.parseBoolean(lineSplit[12]);
						ArrayList<Voznja> voznje = new ArrayList<Voznja>();
						Vozac vozac = new Vozac(id, korIme, lozinka, ime, prezime, jMBG, adresa, pol, brTel, obrisan, plata, brojClanskeKarte, automobil, voznje);
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
						ModelAutomobila model = ModelAutomobila.values()[Integer.parseInt(lineSplit[1])];
						Proizvodjac proizvodjac = Proizvodjac.values()[Integer.parseInt(lineSplit[2])];
						String godinaProizvodnje = lineSplit[3];
						String brRegOznake = lineSplit[4];
						VrstaVozila vrsta = VrstaVozila.values()[Integer.parseInt(lineSplit[5])];
						Boolean obrisan = Boolean.parseBoolean(lineSplit[6]);
						Automobil a = new Automobil(id, model, proizvodjac, godinaProizvodnje, brRegOznake, vrsta, obrisan);
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
				sadrzaj += automobil.getId() + "|" + automobil.getModel().ordinal() + "|" + automobil.getProizvodjac().ordinal() + "|" + automobil.getGodinaProizvodnje()
				+"|" + automobil.getBrRegOznake() + "|" + automobil.getVrstaVozila().ordinal() + "|" + automobil.isObrisan() + "\n";	
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
	
	public static ArrayList<Voznja> ucitajVoznje() {
		
		
		try {
			
			File file = new File("src/txt/voznje.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) !=null) {
				String[] lineSplit = line.split("\\|");
				if(Integer.parseInt(lineSplit[9]) == 3) {
					
					
				int id = Integer.parseInt(lineSplit[0]);
				String datum = lineSplit[1];
				String vremePorudzbine = lineSplit[2];
				String adresaPolaska = lineSplit[3];
				String adresaDestinacije = lineSplit[4];
				Musterija musterija = nadjiMusteriju(Integer.parseInt(lineSplit[5]));
				Vozac vozac = nadjiVozaca(Integer.parseInt(lineSplit[6]));
				
				int brPredjenihKilometara = Integer.parseInt(lineSplit[7]);
				int trajanjeVoznje = Integer.parseInt(lineSplit[8]);
				StatusVoznje status = StatusVoznje.values()[Integer.parseInt(lineSplit[9])];

				PorucivanjeVoznje porucivanjeVoznje = PorucivanjeVoznje.values()[Integer.parseInt(lineSplit[10])];
				Boolean obrisan = Boolean.parseBoolean(lineSplit[11]);
				Voznja voznja = new Voznja(id, datum, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brPredjenihKilometara, trajanjeVoznje, status, porucivanjeVoznje,obrisan);
				vozac.getVoznje().add(voznja);
				voznje.add(voznja);
				
				
				
			} 
				else if(Integer.parseInt(lineSplit[9]) == 0) {
					int id = Integer.parseInt(lineSplit[0]);
					String datum = lineSplit[1];
					String vremePorudzbine = lineSplit[2];
					String adresaPolaska = lineSplit[3];
					String adresaDestinacije = lineSplit[4];
					Musterija musterija = nadjiMusteriju(Integer.parseInt(lineSplit[5]));
					StatusVoznje status = StatusVoznje.values()[Integer.parseInt(lineSplit[9])];
					Boolean obrisan = Boolean.parseBoolean(lineSplit[11]);
					Voznja voznja = new Voznja();
					voznja.setId(id);
					voznja.setDatum(datum);
					voznja.setVremePorudzbine(vremePorudzbine);
					voznja.setAdresaPolaska(adresaPolaska);
					voznja.setAdresaDestinacije(adresaDestinacije);
					voznja.setMusterija(musterija);
					voznja.setStatus(status);
					voznja.setObrisan(obrisan);
					

					voznje.add(voznja);
				}else if (Integer.parseInt(lineSplit[9]) == 1) {
					int id = Integer.parseInt(lineSplit[0]);
					String datum = lineSplit[1];
					String vremePorudzbine = lineSplit[2];
					String adresaPolaska = lineSplit[3];
					String adresaDestinacije = lineSplit[4];
					Musterija musterija = nadjiMusteriju(Integer.parseInt(lineSplit[5]));
					Vozac vozac = nadjiVozaca(Integer.parseInt(lineSplit[6]));
					StatusVoznje status = StatusVoznje.values()[Integer.parseInt(lineSplit[9])];
					Boolean obrisan = Boolean.parseBoolean(lineSplit[11]);
					
					Voznja voznja = new Voznja();
					voznja.setId(id);
					voznja.setDatum(datum);
					voznja.setVremePorudzbine(vremePorudzbine);
					voznja.setAdresaPolaska(adresaPolaska);
					voznja.setAdresaDestinacije(adresaDestinacije);
					voznja.setMusterija(musterija);
					voznja.setVozac(vozac);
					voznja.setStatus(status);
					voznja.setObrisan(obrisan);
					

					voznje.add(voznja);
				}else if(Integer.parseInt(lineSplit[9]) == 2) {
					int id = Integer.parseInt(lineSplit[0]);
					String datum = lineSplit[1];
					String vremePorudzbine = lineSplit[2];
					String adresaPolaska = lineSplit[3];
					String adresaDestinacije = lineSplit[4];
					Musterija musterija = nadjiMusteriju(Integer.parseInt(lineSplit[5]));
					Vozac vozac = nadjiVozaca(Integer.parseInt(lineSplit[6]));
					StatusVoznje status = StatusVoznje.values()[Integer.parseInt(lineSplit[9])];
					Boolean obrisan = Boolean.parseBoolean(lineSplit[11]);
					
					Voznja voznja = new Voznja();
					voznja.setId(id);
					voznja.setDatum(datum);
					voznja.setVremePorudzbine(vremePorudzbine);
					voznja.setAdresaPolaska(adresaPolaska);
					voznja.setAdresaDestinacije(adresaDestinacije);
					voznja.setMusterija(musterija);
					voznja.setVozac(vozac);
					voznja.setStatus(status);
					voznja.setObrisan(obrisan);
					

					voznje.add(voznja);
				}else if(Integer.parseInt(lineSplit[9]) == 4) {
					int id = Integer.parseInt(lineSplit[0]);
					String datum = lineSplit[1];
					String vremePorudzbine = lineSplit[2];
					String adresaPolaska = lineSplit[3];
					String adresaDestinacije = lineSplit[4];
					Musterija musterija = nadjiMusteriju(Integer.parseInt(lineSplit[5]));
					Vozac vozac = nadjiVozaca(Integer.parseInt(lineSplit[6]));
					String brojPredjenihKilometara = lineSplit[7];
					String trajanjeVoznje = lineSplit[8];
					StatusVoznje status = StatusVoznje.values()[Integer.parseInt(lineSplit[9])];
					PorucivanjeVoznje porucivanjeVoznje = PorucivanjeVoznje.values()[Integer.parseInt(lineSplit[10])];
					
					
					Boolean obrisan = Boolean.parseBoolean(lineSplit[11]);
					
					Voznja voznja = new Voznja();
					voznja.setId(id);
					voznja.setDatum(datum);
					voznja.setVremePorudzbine(vremePorudzbine);
					voznja.setAdresaPolaska(adresaPolaska);
					voznja.setAdresaDestinacije(adresaDestinacije);
					voznja.setMusterija(musterija);
					voznja.setVozac(vozac);
					voznja.setBrojPredjenihKilometara(Integer.parseInt(brojPredjenihKilometara));
					voznja.setTrajanjeVoznje(Integer.parseInt(trajanjeVoznje));
					voznja.setStatus(status);
					voznja.setPorucivanjeVoznje(porucivanjeVoznje);
					voznja.setObrisan(obrisan);
					

					voznje.add(voznja);
				}
				
			}	
			
			reader.close();
			
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja voznji");
		}
		
		return voznje;
}
	public ArrayList<Voznja> upisiVoznje(ArrayList<Voznja> voznje) {
		
		
		File file = new File("src/txt/voznje.txt");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Voznja voznja : voznje) {
				if(voznja.getStatus() == StatusVoznje.ZAVRSENA) {
					sadrzaj += voznja.getId() + "|" + voznja.getDatum() + "|" + voznja.getVremePorudzbine() + "|" 
							+ voznja.getAdresaPolaska() + "|" + voznja.getAdresaDestinacije() + "|" + voznja.getMusterija().getId() + "|" 
							+ voznja.getVozac().getId() + "|" + voznja.getBrojPredjenihKilometara() + "|" + voznja.getTrajanjeVoznje() + "|" 
							+ voznja.getStatus() + "|" + voznja.getPorucivanjeVoznje() + "|" + voznja.isObrisan() + "\n";
				}
				else if(voznja.getStatus() == StatusVoznje.KREIRANA) {
					sadrzaj += voznja.getId() + "|" + voznja.getDatum() + "|" 
							+ voznja.getVremePorudzbine() + "|" 
							+ voznja.getAdresaPolaska() + "|" + voznja.getAdresaDestinacije() + "|"
							+ String.valueOf(voznja.getMusterija().getId()) + "|" 
							+ "--" + "|" 
							+ "--" + "|" + "--" + "|" 
							+ voznja.getStatus().ordinal() + "|" + voznja.getPorucivanjeVoznje() + "|" + voznja.isObrisan() + "\n";
				} 
				else if(voznja.getStatus() == StatusVoznje.DODIJELJENA) {
					sadrzaj += voznja.getId() + "|" + voznja.getDatum() + "|" 
							+ voznja.getVremePorudzbine() + "|" 
							+ voznja.getAdresaPolaska() + "|" + voznja.getAdresaDestinacije() + "|"
							+ String.valueOf(voznja.getMusterija().getId()) + "|" 
							+ String.valueOf(voznja.getVozac().getId()) + "|" 
							+ "--" + "|" + "--" + "|" 
							+ voznja.getStatus().ordinal() + "|" + voznja.getPorucivanjeVoznje() + "|" + voznja.isObrisan() + "\n";
				}
				else if(voznja.getStatus() == StatusVoznje.ODBIJENA) {
					sadrzaj += voznja.getId() + "|" + voznja.getDatum() + "|" 
							+ voznja.getVremePorudzbine() + "|" 
							+ voznja.getAdresaPolaska() + "|" + voznja.getAdresaDestinacije() + "|"
							+ String.valueOf(voznja.getMusterija().getId()) + "|" 
							+ String.valueOf(voznja.getVozac().getId()) + "|" 
							+ "--" + "|" + "--" + "|" 
							+ voznja.getStatus().ordinal() + "|" + voznja.getPorucivanjeVoznje() + "|" + voznja.isObrisan() + "\n";
					
				}
				
		
				
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa voznji u fajl.");
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
	public Dispecer NadjiDispeceraPoKorisnickomImenu(String korisnickoIme) {
		for(Dispecer a : this.dispeceri) {
			if (a.getKorIme() == korisnickoIme) {
				return a;
			}
		}
		return null;
	}
	
	
public ArrayList<Vozac> upisiVozace(ArrayList<Vozac> vozaci) {
		
		try {
			File file = new File("src/txt/vozaci.txt");
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

		public static ArrayList<TaksiSluzba> ucitajTaksiSluzbe(){
			
			try {
				File file = new File("src/txt/taksiSluzbe.txt");
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String linija = null;
				while((linija = reader.readLine()) != null) {
					String[] lineSplit = linija.split("\\|");
					int PIB = Integer.parseInt(lineSplit[0]);
					String naziv = lineSplit[1];
					String adresa = lineSplit[2];
					Double cenaStartaVoznje = Double.parseDouble(lineSplit[3]);
					Double cenaPoKilometru = Double.parseDouble(lineSplit[4]);
					TaksiSluzba taksiSluzba = new TaksiSluzba(PIB, naziv, adresa, cenaStartaVoznje, cenaPoKilometru);
					taksiSluzbe.add(taksiSluzba);
				} 
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom citanja taksiSluzbe iz datoteke");
			}
			return taksiSluzbe;
		}
		
		public ArrayList<TaksiSluzba>  upisiTaksiSluzbe (ArrayList<TaksiSluzba> taksiSluzbe) {
			
			try {
				File file = new File("src/files/taksiSluzbe.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				String sadrzaj = "";
				for (TaksiSluzba taksiSluzba : taksiSluzbe) {
					sadrzaj += taksiSluzba.getPIB() + "|" + taksiSluzba.getNaziv() + "|" + taksiSluzba.getAdresa() + "|" 
							+ taksiSluzba.getCenaStartaVoznje() + "|" + taksiSluzba.getCenaPoKilometru() + "\n";
				}
				
				writer.write(sadrzaj);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom upisa taksiSluzbe u fajl.");
			}
			
			return taksiSluzbe;
		}
	
	public Korisnik login(String korisnickoIme, String lozinka) {
		for (Korisnik korisnik : korisnici) {
			if(korisnik.getKorIme().equalsIgnoreCase(korisnickoIme) && 
					korisnik.getLozinka().equals(lozinka) && !korisnik.isObrisan()) {
				return korisnik;
			}
		}
		return null;
	}
	
	public ArrayList<Dispecer> sviNeobrisaniDispeceri() {
		ArrayList<Dispecer> neobrisani = new ArrayList<Dispecer>();
		for (Dispecer dispecer : dispeceri) {
			if(!dispecer.isObrisan()) {
				neobrisani.add(dispecer);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Vozac> sviNeobrisaniVozaci() {
		ArrayList<Vozac> neobrisani = new ArrayList<Vozac>();
		for (Vozac vozac : vozaci) {
			if(!vozac.isObrisan()) {
				neobrisani.add(vozac);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Automobil> sviNeobrisaniAutomobili() {
		ArrayList<Automobil> neobrisani = new ArrayList<Automobil>();
		for (Automobil automobil : automobili) {
			if(!automobil.isObrisan()) {
				neobrisani.add(automobil);
			}
		}
		return neobrisani;
	}
	
	public Dispecer NadjiDispecera(int id) {
		for(Dispecer d : this.dispeceri) {
			if (d.getId() == id) {
				return d;
			}
		}
		return null;
	}
	public Korisnik NadjiKorisnikaPoKorisnickomImenu(String korisnickoIme) {
		for(Korisnik a : this.korisnici) {
			if (a.getKorIme().equalsIgnoreCase(korisnickoIme)) {
				return a;
			}
		}
		return null;
	}
	
	public Vozac NadjiVozacaPoKorisnickomImenu(String korisnickoIme) {
		for(Vozac a : this.vozaci) {
			if (a.getKorIme().equalsIgnoreCase(korisnickoIme)) {
				return a;
			}
		}
		return null;
	}
	public Automobil NadjiAutomobil(int id) {
		for(Automobil a : this.automobili) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	public Vozac NadjiVozaca(int id) {
		for(Vozac v : this.vozaci) {
			if (v.getId() == id) {
				return v;
			}
		}
		return null;
	}
	
	public Musterija NadjiMusteriju(int id) {
		for(Musterija m : this.musterije) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	public Musterija NadjiMusterijuPoKorisnickomImenu(String korisnickoIme) {
		for(Musterija m : this.musterije) {
			if (m.getKorIme().equalsIgnoreCase(korisnickoIme)) {
				return m;
			}
		}
		return null;
	}
	public ArrayList<Musterija> getMusterije() {
		return musterije;
	}
	public ArrayList<Vozac> getVozaci() {
		return vozaci;
	}
	public ArrayList<Voznja> getVoznje() {
		return voznje;
	}

	
	public ArrayList<Voznja> sveNeobrisaneVoznje() {
		ArrayList<Voznja> neobrisane = new ArrayList<Voznja>();
		for (Voznja voznja : voznje) {
			if(!voznja.isObrisan()) {
				neobrisane.add(voznja);
			}
		}
		return neobrisane;
	}
	
	public Voznja pronadjiVoznju(String adresaDestinacije) {
			for(Voznja voznja : voznje) {
				//System.out.println("rodjo" + voznja);
				if(voznja.getAdresaDestinacije().equalsIgnoreCase(adresaDestinacije)) {
					return voznja;
				}
			}
		
		return null;
	}
	public void dodajVoznju(Voznja voznja) {
		this.voznje.add(voznja);
	}
	
	public Voznja NadjiVoznju(int id) {
		for(Voznja a : this.voznje) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}	

}
