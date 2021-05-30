package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import osobe.Musterija;
import radSaFajlovima.RadSaDatotekama;

public class LoginProzorMusterija extends JFrame {
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu rezervisiVoznju = new JMenu("Rezervisi voznju");
	private JMenuItem TelefonomItem = new JMenuItem("Telefonom");
	private JMenuItem putemAplikacijeItem = new JMenuItem("Putem aplikacije");
	
	private RadSaDatotekama rsd;
	private Musterija prijavljeniKorisnik;
	
	public LoginProzorMusterija(RadSaDatotekama rsd, Musterija prijavljeniKorisnik) {
		this.rsd = rsd;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Musterija: " + prijavljeniKorisnik.getKorIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
		
	}
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(rezervisiVoznju);
		rezervisiVoznju.add(TelefonomItem);
		rezervisiVoznju.add(putemAplikacijeItem);
	}
	
	private void initActions() {
		
	}
	

}
