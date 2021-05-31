package gui.formeZaPrikaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enumeracija.StatusVoznje;
import net.miginfocom.swing.MigLayout;
import osobe.Musterija;
import radSaFajlovima.RadSaDatotekama;
import taxiSluzba.Voznja;

public class RezervisiVoznjuProzor extends JFrame {
	
	private JLabel lblNazivTaksiSluzbe = new JLabel("Red taXi");
	private JLabel lbladresaTaksiSluzbe = new JLabel("Ljubinje,Svetosavska 22");
	private JLabel lblcenaVoznjePoKilometru = new JLabel("Cena voznje po kilometru: 1 KM");
	private JLabel lblcenaStartaVoznje = new JLabel("Cena starta voznje: 1.2 KM");
	private JLabel lblAdresaPolaska = new JLabel("Adresa polaska");
	private JTextField txtAdresaPolaska = new JTextField(20);
	private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije");
	private JTextField txtAdresaDestinacije = new JTextField(20);
	private JButton btnRezervisiVoznju = new JButton("Rezervisi voznju");
	private JButton btnOtkazi = new JButton("Otkazi");
	
	private RadSaDatotekama rsd;
	private Musterija musterija;
	
	public RezervisiVoznjuProzor(RadSaDatotekama rsd, Musterija musterija) {
		this.musterija = musterija;
		this.rsd = rsd;
		setTitle("Red taxi sluzba - " + " postovani/a " + musterija.getIme());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(true);
		pack();
		getRootPane().setDefaultButton(btnRezervisiVoznju);
	}
	
	private void initGUI() {
			
			MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[]10[]10[]");
			setLayout(mig);
			
			add(lblNazivTaksiSluzbe);
			add(new JLabel());
			add(lbladresaTaksiSluzbe);
			add(new JLabel());
			add(lblcenaVoznjePoKilometru);
			add(new JLabel());
			add(lblcenaStartaVoznje);
			add(new JLabel());
			add(lblAdresaPolaska);
			add(txtAdresaPolaska);
			add(lblAdresaDestinacije);
			add(txtAdresaDestinacije);
			add(new JLabel());
			add(btnRezervisiVoznju, "split 2");
			add(btnOtkazi);
			
			getRootPane().setDefaultButton(btnRezervisiVoznju);
		}
	
	private void initActions() {
		
		btnRezervisiVoznju.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Voznja v = new Voznja();
				v.setId(rsd.getVoznje().get(rsd.getVoznje().size() - 1).getId() + 1);
				v.setMusterija(musterija);
				v.setDatum("15-08-2020");
				v.setVremePorudzbine("13:52:26");
				String polazak = txtAdresaPolaska.getText().trim();
				String dolazak = txtAdresaDestinacije.getText().trim();
				v.setAdresaPolaska(polazak);
				v.setAdresaDestinacije(dolazak);
				v.setStatus(StatusVoznje.KREIRANA);
				v.setObrisan(false);
				
				rsd.getVoznje().add(v);
				rsd.upisiVoznje(RadSaDatotekama.voznje);
				
				RezervisiVoznjuProzor.this.dispose();
				RezervisiVoznjuProzor.this.setVisible(false);
			}
		});
		btnOtkazi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RezervisiVoznjuProzor.this.dispose();
				RezervisiVoznjuProzor.this.setVisible(false);
				
			}
		});
	}
	
	

}
