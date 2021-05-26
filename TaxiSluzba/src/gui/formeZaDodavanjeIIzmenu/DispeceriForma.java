package gui.formeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import enumeracija.Pol;
import enumeracija.TelOdeljenja;

import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;
import osobe.Korisnik;
import radSaFajlovima.RadSaDatotekama;

public class DispeceriForma extends JFrame {

	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	private JLabel lblKorIme = new JLabel("Korisnicko Ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lbljMBG = new JLabel("JMBG");
	private JTextField txtjMBG = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa= new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<enumeracija.Pol> cbPol = new JComboBox<enumeracija.Pol>(enumeracija.Pol.values());
	private JLabel lblBrTel = new JLabel("Broj telefona");
	private JTextField txtBrTel = new JTextField(20);
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblBrTelLinije = new JLabel("Broj telefonske linije");
	private JTextField txtBrTelLinije = new JTextField(20);
	private JLabel lblTelOdeljenja = new JLabel("Tel odeljenja");
	private JComboBox<TelOdeljenja> cbTelOdeljenja = new JComboBox<TelOdeljenja>(TelOdeljenja.values());
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Dispecer dispecer;
	
	public DispeceriForma(RadSaDatotekama rsd, Dispecer dispecer) {
		this.rsd = rsd;
		this.dispecer = dispecer;
		if(dispecer == null) {
			setTitle("Dodavanje dispecera");
		}else {
			setTitle("Izmena podataka - " + dispecer.getKorIme());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][][]20[]");
		setLayout(layout);
		
		if(dispecer != null) {
			popuniPolja();
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
		add(lbljMBG);
		add(txtjMBG);
		add(lblAdresa);
		add(txtAdresa);
		add(lblPol);
		add(cbPol);
		add(lblBrTel);
		add(txtBrTel);
		add(lblPlata);
		add(txtPlata);
		add(lblBrTelLinije);
		add(txtBrTelLinije);
		add(lblTelOdeljenja);
		add(cbTelOdeljenja);
		
		
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
					String jmbg = txtjMBG.getText().trim();
					String adresa = txtAdresa.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String brojTelefona = txtBrTel.getText().trim();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					String brojTelefonskeLinije = txtBrTelLinije.getText().trim();
					TelOdeljenja telefonskaOdeljenja = (TelOdeljenja)cbTelOdeljenja.getSelectedItem();
					
					
					if(dispecer == null) { 
						Dispecer novi = new Dispecer(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, plata, brojTelefonskeLinije, telefonskaOdeljenja, false);
						rsd.dodajDispecera(novi);
					
					}else { 
						dispecer.setKorIme(korisnickoIme);
						dispecer.setLozinka(lozinka);
						dispecer.setIme(ime);
						dispecer.setPrezime(prezime);
						dispecer.setjMBG(jmbg);
						dispecer.setAdresa(adresa);
						dispecer.setPol(pol);
						dispecer.setBrTel(brojTelefona);
						dispecer.setPlata(plata);
						dispecer.setBrTelLinije(brojTelefonskeLinije);
						dispecer.setTelOdeljenja(telefonskaOdeljenja);
					}
					rsd.upisiDispecere(RadSaDatotekama.dispeceri);
					DispeceriForma.this.dispose();
					DispeceriForma.this.setVisible(false);
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DispeceriForma.this.dispose();
				DispeceriForma.this.setVisible(false);
				
			}
		});
		
	}
	
	private void popuniPolja() {
		txtId.setText(String.valueOf(dispecer.getId()));
		txtKorIme.setText(dispecer.getKorIme());
		pfLozinka.setText(dispecer.getLozinka());
		txtIme.setText(dispecer.getIme());
		txtPrezime.setText(dispecer.getPrezime());
		txtjMBG.setText(dispecer.getjMBG());
		txtAdresa.setText(dispecer.getAdresa());
		cbPol.setSelectedItem(dispecer.getPol());
		txtBrTel.setText(dispecer.getBrTel());
		txtPlata.setText(String.valueOf(dispecer.getPlata()));
		txtBrTelLinije.setText(dispecer.getBrTelLinije());
		cbTelOdeljenja.setSelectedItem(dispecer.getTelOdeljenja());
			
		
		
	}
	 
private boolean validacija() {
		
		boolean ok = true;
		String poruka = "Popravite  greske u unosu u data polja:\n";
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite Id\n";
			ok = false;
		}else if(dispecer == null) {
			int id = Integer.parseInt(txtId.getText().trim());
			Dispecer pronadjeni = rsd.NadjiDispecera(id);
			if(pronadjeni != null) {
				poruka += "- Dispecer sa ovim id vec postoji\n";
				ok = false;
			}
		}
		
		
		if(txtKorIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime\n";
			ok = false;
		}else if(dispecer == null){
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
		
		
		if(txtjMBG.getText().trim().equals("")) {
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
				poruka += "- Plata mora biti unesena kao numericka vrednost\n";
				ok = false;
				}
		}
		
		if(txtBrTelLinije.getText().trim().equals("")) {
			poruka += "- Unesite broj telefonske linije\n";
			ok = false;
		}
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
	
}