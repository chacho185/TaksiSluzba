package gui.formeZaDodavanjeIIzmenu;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import enumeracija.Pol;
import net.miginfocom.swing.MigLayout;
import osobe.Korisnik;
import osobe.Vozac;
import radSaFajlovima.RadSaDatotekama;
import taxiSluzba.Automobil;
import taxiSluzba.Voznja;

public class VozaciForma extends JFrame {
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("Jmbg");
	private JTextField txtJmbg = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblBrTel = new JLabel("Broj telefona");
	private JTextField txtBrTel = new JTextField(20);
	private JLabel lblPlata = new  JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblbrojClanskeKarte = new JLabel("Broj clanske karte");
	private JTextField txtbrojClanskeKarte = new JTextField(20);
	private JLabel lblAutomobil = new JLabel("Automobil");
	private JComboBox<Integer> cbAutomobil = new JComboBox<Integer>();
	
	

	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Vozac vozac;
	
	public VozaciForma(RadSaDatotekama rsd, Vozac vozac) {
		this.rsd = rsd;
		this.vozac = vozac;
		if(vozac == null) {
			setTitle("Dodavanje vozaca");
		}else {
			setTitle("Izmena podataka - " + vozac.getKorIme());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][]20[]");
		setLayout(layout);
		
		if(vozac!= null) {
			 popuniPolja();
		
		}
		
		for(Automobil a : RadSaDatotekama.automobili) {
			cbAutomobil.addItem(a.getId());
		}

		
		add(lblId);
		add(txtId);
		add(lblKorIme);
		add(txtKorIme);
		add(lblLozinka);
		add(pfLozinka);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJmbg);
		add(txtJmbg);
		add(lblAdresa);
		add(txtAdresa);
		add(lblPol);
		add(cbPol);
		add(lblBrTel);
		add(txtBrTel);
		add(lblPlata);
		add(txtPlata);
		add(lblbrojClanskeKarte);
		add(txtbrojClanskeKarte);
		add(lblAutomobil);
		add(cbAutomobil);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
	}
	
private void initActions() {
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					if(validacija()) {
						int id = Integer.parseInt(txtId.getText().trim());
						String korisnickoIme = txtKorIme.getText().trim();
						String lozinka = new String(pfLozinka.getPassword()).trim();
						String ime = txtIme.getText().trim();
						String prezime = txtPrezime.getText().trim();
						String jmbg = txtJmbg.getText().trim();
						String adresa = txtAdresa.getText().trim();
						Pol pol = (Pol)cbPol.getSelectedItem();
						String brojTelefona = txtBrTel.getText().trim();
						double plata = Double.parseDouble(txtPlata.getText().trim());
						String brojClanskeKarte = txtbrojClanskeKarte.getText().trim();
						String auto = cbAutomobil.getSelectedItem().toString();
						int IdAuta = Integer.parseInt(auto);
						Automobil automobil = rsd.NadjiAutomobil(IdAuta);
						
						if(vozac == null) { 
							Vozac novi = new Vozac(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, false, plata, brojClanskeKarte, automobil, new ArrayList<Voznja>());
							rsd.dodajVozaca(novi);
						
						}else { 
							vozac.setLozinka(lozinka);
							vozac.setIme(ime);
							vozac.setPrezime(prezime);
							vozac.setjMBG(jmbg);
							vozac.setAdresa(adresa);
							vozac.setPol(pol);
							vozac.setBrTel(brojTelefona);
							vozac.setPlata(plata);
							vozac.setBrojClanskeKarte(brojClanskeKarte);
							vozac.setAutomobil(automobil);
							
						}
						rsd.upisiVozace(RadSaDatotekama.vozaci);
						VozaciForma.this.dispose();
						VozaciForma.this.setVisible(false);
					}
				
			
			}
		}); 
			
		
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VozaciForma.this.dispose();
				VozaciForma.this.setVisible(false);
				
			}
		});
		
}
		private void popuniPolja() {
			txtId.setText(String.valueOf(vozac.getId()));
			txtKorIme.setText(vozac.getKorIme());
			pfLozinka.setText(vozac.getLozinka());
			txtIme.setText(vozac.getIme());
			txtPrezime.setText(vozac.getPrezime());
			txtJmbg.setText(vozac.getjMBG());
			txtAdresa.setText(vozac.getAdresa());
			cbPol.setSelectedItem(vozac.getPol());
			txtBrTel.setText(vozac.getBrTel());
			txtPlata.setText(String.valueOf(vozac.getPlata()));
			txtbrojClanskeKarte.setText(vozac.getBrojClanskeKarte());
			cbAutomobil.setSelectedItem(String.valueOf(vozac.getAutomobil().getId()));
			
			
		}
		
		private boolean validacija() {
			
			boolean ok = true;
			String poruka = "Molimo popravite sledece greske u unosu:\n";
			
			if(txtId.getText().trim().equals("")) {
				poruka += "- Unesite Id\n";
				ok = false;
			}else if(vozac == null) {
				int id = Integer.parseInt(txtId.getText().trim());
				Vozac pronadjeni = rsd.NadjiVozaca(id);
				if(pronadjeni != null && !pronadjeni.isObrisan()) {
					poruka += "- Vozac sa unetim id vec postoji\n";
					ok = false;
				}
			}
			
			if(txtKorIme.getText().trim().equals("")) {
				poruka += "- Unesite korisnicko ime\n";
				ok = false;
			}else if(vozac == null){
				String korIme = txtKorIme.getText().trim();
				Korisnik pronadjeni = rsd.NadjiKorisnikaPoKorisnickomImenu(korIme);
				if(pronadjeni != null && !pronadjeni.isObrisan()) {
					poruka += "- Korisnik sa unetim korisnickim imenom vec postoji\n";
					ok = false;
				}
			}
			
			String lozinka = new String(pfLozinka.getPassword()).trim();
			if(lozinka.equals("")) {
				poruka += "- Unesite lozinku\n";
				ok = false;
			}
			

			if(txtIme.getText().trim().equals("")) {
				poruka += "- Unesite ime\n";
				ok = false;
			}
			
			
			if(txtJmbg.getText().trim().equals("")) {
				poruka += "- Unesite jmbg\n";
				ok = false;
			}
			
			if(txtPrezime.getText().trim().equals("")) {
				poruka += "- Unesite prezime\n";
				ok = false;
			}
			
			if(txtAdresa.getText().trim().equals("")) {
				poruka += "- Unesite adresu\n";
				ok = false;
			}
			
			if(txtBrTel.getText().trim().equals("")) {
				poruka += "- Unesite broj telefona\n";
				ok = false;
			}
			
			if(txtPlata.getText().trim().equals("")) {
				poruka += "- Unesite platu\n";
				ok = false;
			}else {
				try {
				Double.parseDouble(txtPlata.getText().trim());
				}catch (NumberFormatException e) {
					poruka += "- Plata mora biti unesena kao numericka vrijednost\n";
					ok = false;
					}
			}
			
			if(txtbrojClanskeKarte.getText().trim().equals("")) {
				poruka += "- Unesite broj clanske karte\n";
				ok = false;
			}
			
			
			
			
			if(ok == false) {
				JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
			}
			
			return ok;
		}
	
	
	}


