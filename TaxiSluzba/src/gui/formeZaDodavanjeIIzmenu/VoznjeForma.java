package gui.formeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enumeracija.PorucivanjeVoznje;
import enumeracija.StatusVoznje;
import net.miginfocom.swing.MigLayout;
import osobe.Musterija;
import osobe.Vozac;
import radSaFajlovima.RadSaDatotekama;
import taxiSluzba.Voznja;

public class VoznjeForma extends JFrame {
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	private JLabel lblDatum = new JLabel("Datum");
	private JTextField txtDatum = new JTextField(20);
	private JLabel lblVremePorudzbine = new JLabel("Vreme porudzbine");
	private JTextField txtVremePorudzbine= new JTextField(20);
	private JLabel lblAdresaPolaska = new JLabel("Adresa polaska");
	private JTextField txtAdresaPolaska = new JTextField(20);
	private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije");
	private JTextField txtAdresaDestinacije = new JTextField(20);
	private JLabel lblMusterija = new JLabel("Musterija");
	private JComboBox<String> cbMusterija = new JComboBox<String>();
	private JLabel lblVozac = new JLabel("Vozac");
	private JComboBox<String> cbVozac = new JComboBox<String>();
	private JLabel lblBrojPredjenihKilometara = new JLabel("Broj predjenih kilometara");
	private JTextField txtBrojPredjenihKilometara = new JTextField(20);
	private JLabel lblTrajanjeVoznje = new JLabel("Trajanje voznje");
	private JTextField txtTrajanjeVoznje = new JTextField(20);
	private JLabel lblStatusVoznje = new JLabel("Status voznje");
	private JComboBox<StatusVoznje> cbStatusVoznje = new JComboBox<StatusVoznje>(StatusVoznje.values());
	private JLabel lblPorucivanjeVoznje = new JLabel("Porucivanje voznje");
	private JComboBox<PorucivanjeVoznje> cbPorucivanjeVoznje = new JComboBox<PorucivanjeVoznje>(PorucivanjeVoznje.values());
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Voznja voznja;
	
	public VoznjeForma(RadSaDatotekama rsd, Voznja voznja) {
		this.rsd = rsd;
		this.voznja = voznja;
		if(voznja == null) {
			setTitle("Dodavanje voznje");
		}else {
			setTitle("Izmena podataka - " + voznja.getDatum());
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
		
		if(voznja!= null) {
			popuniPolja();
		}

		for(Musterija m: this.rsd.getMusterije()) {
			cbMusterija.addItem(m.getKorIme());
		}
		
		for(Vozac v: this.rsd.getVozaci()) {
			cbVozac.addItem(v.getKorIme());
		}
		

		add(lblId);
		add(txtId);
		add(lblDatum);
		add(txtDatum);
		add(lblVremePorudzbine);
		add(txtVremePorudzbine);
		add(lblAdresaPolaska);
		add(txtAdresaPolaska);
		add(lblAdresaDestinacije);
		add(txtAdresaDestinacije);
		add(lblMusterija);
		add(cbMusterija);
		add(lblVozac);
		add(cbVozac);
		add(lblBrojPredjenihKilometara);
		add(txtBrojPredjenihKilometara);
		add(lblTrajanjeVoznje);
		add(txtTrajanjeVoznje);
		add(lblStatusVoznje);
		add(cbStatusVoznje);
		add(lblPorucivanjeVoznje);
		add(cbPorucivanjeVoznje);

		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
	}
	
	
	private void initActions() {
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());
					String datum = txtDatum.getText().trim();
					String vremePorudzbine = txtVremePorudzbine.getText().trim();
					String adresaPolaska = txtAdresaPolaska.getText().trim();
					String adresaDestinacije = txtAdresaDestinacije.getText().trim();
					String musterijaa = cbMusterija.getSelectedItem().toString();
					String vozacc = cbVozac.getSelectedItem().toString();
					int brojPredjenihKilometara = Integer.parseInt(txtBrojPredjenihKilometara.getText().trim());
					int trajanjeVoznje = Integer.parseInt(txtTrajanjeVoznje.getText().trim());
					StatusVoznje status = (StatusVoznje)cbStatusVoznje.getSelectedItem();
					PorucivanjeVoznje porucivanjeVoznje = (PorucivanjeVoznje)cbPorucivanjeVoznje.getSelectedItem();
					
					Musterija musterija = rsd.NadjiMusterijuPoKorisnickomImenu(musterijaa);
					Vozac vozac = rsd.NadjiVozacaPoKorisnickomImenu(vozacc);
					
					if(voznja == null) {
						Voznja novo = new Voznja(id, datum, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojPredjenihKilometara, trajanjeVoznje, status, porucivanjeVoznje, false);
						rsd.dodajVoznju(novo);
					}else {
						voznja.setDatum(datum);
						voznja.setVremePorudzbine(vremePorudzbine);
						voznja.setAdresaPolaska(adresaPolaska);
						voznja.setAdresaDestinacije(adresaDestinacije);
						voznja.setMusterija(musterija);
						voznja.setVozac(vozac);
						voznja.setBrojPredjenihKilometara(brojPredjenihKilometara);
						voznja.setTrajanjeVoznje(trajanjeVoznje);
						voznja.setStatus(status);
						voznja.setPorucivanjeVoznje(porucivanjeVoznje);
					}
					rsd.upisiVoznje(RadSaDatotekama.voznje);
					VoznjeForma.this.dispose();
					VoznjeForma.this.setVisible(false);
				}
				
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						VoznjeForma.this.dispose();
						VoznjeForma.this.setVisible(false);
						
					}
				});
				
			}
		private void popuniPolja() {
			txtId.setText(String.valueOf(voznja.getId()));
			txtDatum.setText(voznja.getDatum());
			txtVremePorudzbine.setText(voznja.getVremePorudzbine());
			txtAdresaPolaska.setText(voznja.getAdresaPolaska());
			txtAdresaDestinacije.setText(voznja.getAdresaDestinacije());
			cbMusterija.setSelectedItem(String.valueOf(voznja.getMusterija().getKorIme()));
			cbVozac.setSelectedItem(String.valueOf(voznja.getVozac().getKorIme()));
			txtBrojPredjenihKilometara.setText(String.valueOf(voznja.getBrojPredjenihKilometara()));
			txtTrajanjeVoznje.setText(String.valueOf(voznja.getTrajanjeVoznje()));
			cbStatusVoznje.setSelectedItem(voznja.getStatus());
			cbPorucivanjeVoznje.setSelectedItem(voznja.getPorucivanjeVoznje());
		}
	
		private boolean validacija() {
				
				boolean ok = true;
				String poruka = "Molimo obratite paznju na sljedece greske u unosu:\n";
				
				if(txtId.getText().trim().equals("")) {
					poruka += "- Unesite Id\n";
					ok = false;
				}else if(voznja == null) {
					int id = Integer.parseInt(txtId.getText().trim());
					Voznja pronadjena = rsd.NadjiVoznju(id);
					if(pronadjena != null && !pronadjena.isObrisan()) {
						poruka += "- Voznja sa unetim id vec postoji\n";
						ok = false;
					}
				}
				
		
				if(txtDatum.getText().trim().equals("")) {
					poruka += "- Unesite datum\n";
					ok = false;
				}
				
				
				if(txtVremePorudzbine.getText().trim().equals("")) {
					poruka += "- Unesite vreme porudzbine\n";
					ok = false;
				}
				
				if(txtAdresaPolaska.getText().trim().equals("")) {
					poruka += "- Unesite adresu polaska\n";
					ok = false;
				}
				
				if(txtAdresaDestinacije.getText().trim().equals("")) {
					poruka += "- Unesite adresu destinacije\n";
					ok = false;
				}
				
				if(txtBrojPredjenihKilometara.getText().trim().equals("")) {
					poruka += "- Unesite broj predjenih kilometara\n";
					ok = false;
				}
				
				
				if(txtTrajanjeVoznje.getText().trim().equals("")) {
					poruka += "- Unesite trajanje voznje\n";
					ok = false;
				}
				
				
				
				
				
				
				if(ok == false) {
					JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
				}
				
				return ok;
			}
	}
		



