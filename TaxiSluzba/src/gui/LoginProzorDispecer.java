package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.formeZaPrikaz.DispeceriProzor;
import gui.formeZaPrikaz.VoznjeProzor;
import osobe.Dispecer;
import radSaFajlovima.RadSaDatotekama;

public class LoginProzorDispecer extends JFrame {
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu dodjeliVoznju = new JMenu("Dodjeli voznju vozacu");
	
	private JMenu dispeceriMenu = new JMenu("Dispeceri");
	private JMenuItem dispeceriItem = new JMenuItem("Dispeceri");
	private JMenu voznjeMenu = new JMenu("Voznje");
	private JMenuItem voznjeItem = new JMenuItem("Prikazi voznje");
	
	private RadSaDatotekama rsd;
	private Dispecer prijavljeniKorisnik;
	
	public LoginProzorDispecer(RadSaDatotekama rsd, Dispecer prijavljeniKorisnik) {
		this.rsd = rsd;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Dispecer: " + prijavljeniKorisnik.getKorIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
		
	}
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(dodjeliVoznju);
		mainMenu.add(voznjeMenu);
		voznjeMenu.add(voznjeItem);
		mainMenu.add(dispeceriMenu);
		dispeceriMenu.add(dispeceriItem);
	}
	
	private void initActions() {
		
		dispeceriItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DispeceriProzor dp = new DispeceriProzor(rsd);
				dp.setVisible(true);
				
			}
		});
		
		voznjeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VoznjeProzor vp = new VoznjeProzor(rsd);
				vp.setVisible(true);
				
			}
		});
			
			
		}

}
