package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import enumeracija.Pol;
import enumeracija.StatusVoznje;
import gui.formeZaDodavanjeIIzmenu.VozaciForma;
import gui.formeZaDodavanjeIIzmenu.VoznjeForma;
import main.KolekcijeTest;
import taxiSluzba.Automobil;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Vozac;
import taxiSluzba.Voznja;
import radSaFajlovima.RadSaDatotekama;

public class VoznjeZaVozaceProzor extends JFrame {
	

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnPotvrdiVoznju = new JButton();
	private JButton btnOdbijVoznju = new JButton();
	private JButton btnZavrsiVoznju = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable voznjeTabela;
	
	private RadSaDatotekama rsd;
	private Vozac vozac;
	private Musterija musterija;
	private ArrayList<Voznja> VozaceveVoznje = new ArrayList<Voznja>();
	
	public VoznjeZaVozaceProzor(RadSaDatotekama rsd, Vozac vozac) {
		this.rsd = rsd;
		this.vozac = vozac;
		setTitle("Voznje za vozaca");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		ImageIcon prihvatiIcon = new ImageIcon(getClass().getResource("/slike/icons8-approve-24.png"));
		btnPotvrdiVoznju.setIcon(prihvatiIcon);
		ImageIcon odbijIcon = new ImageIcon(getClass().getResource("/slike/icons8-decline-24.png"));
		btnOdbijVoznju.setIcon(odbijIcon);
		ImageIcon zavrsiIcon = new ImageIcon(getClass().getResource("/slike/icons8-finish-flag-24.png"));
		btnZavrsiVoznju.setIcon(zavrsiIcon);
		
		mainToolbar.add(btnPotvrdiVoznju);
		mainToolbar.add(btnOdbijVoznju);
		mainToolbar.add(btnZavrsiVoznju);

		add(mainToolbar, BorderLayout.NORTH);
		mainToolbar.setFloatable(false);
		
		for(Voznja voznja:rsd.getVoznje()) {
			if(voznja.getVozac().getIme().equalsIgnoreCase(vozac.getIme())) {
				VozaceveVoznje.add(voznja);
			}
		}
		
		String[] zaglavlja = new String[] {"Id", "Datum", "Vreme porudzbine", "Polazak", "Odrediste",
								"Musterija", "Vozac", "Broj predjenih km", "Trajanje voznje", "Status"};
		Object[][] sadrzaj = new Object[this.VozaceveVoznje.size()][zaglavlja.length];
		
		for(int i=0; i< this.VozaceveVoznje.size(); i++) {
			Voznja voznja = this.VozaceveVoznje.get(i);
			Musterija musterija = voznja.getMusterija();
			Vozac vozac = voznja.getVozac();
			sadrzaj[i][0] = voznja.getId();
			sadrzaj[i][1] = voznja.getDatum();
			sadrzaj[i][2] = voznja.getVremePorudzbine();
			sadrzaj[i][3] = voznja.getAdresaPolaska();
			sadrzaj[i][4] = voznja.getAdresaDestinacije();
			sadrzaj[i][5] = musterija.isObrisan() ? "Obrisana musterija" : musterija.getIme() + " " + musterija.getPrezime();
			sadrzaj[i][6] = vozac.isObrisan() ? "Obrisan vozac" : vozac.getIme() + " " + vozac.getPrezime();
			sadrzaj[i][7] = voznja.getBrojPredjenihKilometara();
			sadrzaj[i][8] = voznja.getTrajanjeVoznje();
			sadrzaj[i][9] = voznja.getStatus();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		voznjeTabela = new JTable(tableModel);
		
		voznjeTabela.setRowSelectionAllowed(true);
		voznjeTabela.setColumnSelectionAllowed(false);
		voznjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		voznjeTabela.setDefaultEditor(Object.class, null);
		voznjeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(voznjeTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
		btnOdbijVoznju.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = voznjeTabela.getSelectedRow();
			
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} 
				else if(StatusVoznje.DODIJELJENA == StatusVoznje.valueOf(tableModel.getValueAt(red, 9).toString())){
					
					int id = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					Voznja voznja = rsd.NadjiVoznju(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da odbijete voznju?", 
							id + " - Potvrda odbijanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						
						voznja.setStatus(StatusVoznje.ODBIJENA);
						
					
						rsd.upisiVoznje(RadSaDatotekama.voznje);
					}
				}
				
			}
				
		});
		
		btnPotvrdiVoznju.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = voznjeTabela.getSelectedRow();
				
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} 
				else if (StatusVoznje.DODIJELJENA == StatusVoznje.valueOf(tableModel.getValueAt(red, 9).toString())){
					int id = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					Voznja voznja = rsd.NadjiVoznju(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da prihvatite voznju?", 
							id + " - Potvrda prihvatanja voznje", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						voznja.setStatus(StatusVoznje.PRIHVACENA);
			
						
						rsd.upisiVoznje(RadSaDatotekama.voznje);
					}
				}
				
			}
		});
		
		btnZavrsiVoznju.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = voznjeTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else if(StatusVoznje.ODBIJENA == StatusVoznje.valueOf(tableModel.getValueAt(red, 9).toString()) || 
							StatusVoznje.DODIJELJENA == StatusVoznje.valueOf(tableModel.getValueAt(red, 9).toString())){
						JOptionPane.showMessageDialog(null, "Voznja nije prihvacena, radnja ne moze biti izvrsena. Voznja mora biti prihvacena da bi mogla da se zavrsi.", "Greska", JOptionPane.WARNING_MESSAGE);

					}else if(StatusVoznje.ZAVRSENA == StatusVoznje.valueOf(tableModel.getValueAt(red, 9).toString()) ) {
						JOptionPane.showMessageDialog(null, "Voznja je vec zavrsena. Molimo odaberite drugu voznju.", "Greska", JOptionPane.WARNING_MESSAGE);
					} else if(StatusVoznje.PRIHVACENA == StatusVoznje.valueOf(tableModel.getValueAt(red, 9).toString())) {
						int id = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
						Voznja voznja = rsd.NadjiVoznju(id);
						if(voznja == null) {
							JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja voznje po id-u.\n              Osvezite prozor kako bi se ucitali izmenjeni podaci.", "Greska", JOptionPane.WARNING_MESSAGE);
						}else {
							ZavrsiVoznjuProzor zvp = new ZavrsiVoznjuProzor(rsd, voznja);
							zvp.setVisible(true);
						}
					}
				}
			});
	}

}