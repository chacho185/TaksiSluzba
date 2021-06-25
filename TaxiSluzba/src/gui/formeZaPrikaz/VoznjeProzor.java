package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import enumeracija.StatusVoznje;
import gui.formeZaDodavanjeIIzmenu.VoznjeForma;
import osobe.Musterija;
import osobe.Vozac;
import radSaFajlovima.RadSaDatotekama;
import taxiSluzba.Voznja;

public class VoznjeProzor extends JFrame {
	

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private JButton btnDodjeliVoznjuVozacu = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable voznjeTabela;
	
	private RadSaDatotekama rsd;
	
	public VoznjeProzor(RadSaDatotekama rsd) {
		this.rsd = rsd;
		setTitle("Voznje");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon removeIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(removeIcon);
		ImageIcon assignIcon = new ImageIcon(getClass().getResource("/slike/assign.png"));
		btnDodjeliVoznjuVozacu.setIcon(assignIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		mainToolbar.add(btnDodjeliVoznjuVozacu);
		add(mainToolbar, BorderLayout.NORTH);
		mainToolbar.setFloatable(false);
		
		String[] zaglavlja = new String[] {"Id", "Datum", "Vreme porudzbine", "Polazak", "Odrediste",
								"Musterija", "Vozac", "Broj predjenih km", "Trajanje voznje", "Status" , "Porucivanje voznje"};
		Object[][] sadrzaj = new Object[rsd.sveNeobrisaneVoznje().size()][zaglavlja.length];
		
		for(int i=0; i< rsd.sveNeobrisaneVoznje().size(); i++) {
			Voznja voznja = rsd.sveNeobrisaneVoznje().get(i);
			Musterija musterija = voznja.getMusterija();
			Vozac vozac = voznja.getVozac();
			sadrzaj[i][0] = voznja.getId();
			sadrzaj[i][1] = voznja.getDatum();
			sadrzaj[i][2] = voznja.getVremePorudzbine();
			sadrzaj[i][3] = voznja.getAdresaPolaska();
			sadrzaj[i][4] = voznja.getAdresaDestinacije();
			sadrzaj[i][5] = musterija.isObrisan() ? "Musterija je obrisana" : musterija.getId();
			sadrzaj[i][6] = vozac.isObrisan() ? "Vozac je obrisan" : vozac.getId();
			sadrzaj[i][7] = voznja.getBrojPredjenihKilometara();
			sadrzaj[i][8] = voznja.getTrajanjeVoznje();
			sadrzaj[i][9] = voznja.getStatus();
			sadrzaj[i][10] = voznja.getPorucivanjeVoznje();
			
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
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 int red = voznjeTabela.getSelectedRow();
				 System.out.println("red " + red);
				 if (red == -1) {
					 JOptionPane.showMessageDialog(null, "Morate izabrati jedan red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
					 
				 }
				 else {
					 String adresaDestinacije = tableModel.getValueAt(red , 4).toString();
					 Voznja voznja = rsd.pronadjiVoznju(adresaDestinacije);
					 System.out.println("Voznja " + adresaDestinacije);
					 int odabir = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete voznju?", adresaDestinacije + "- Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					 if (odabir == JOptionPane.YES_NO_OPTION) {
						 voznja.setObrisan(true);
						 tableModel.removeRow(red);
						 rsd.upisiVoznje(RadSaDatotekama.voznje);
					 }
				 }
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VoznjeForma vf = new VoznjeForma(rsd, null);
				vf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = voznjeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate izabrati jedan red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String adresaDestinacije = tableModel.getValueAt(red, 4).toString();
					Voznja voznja = rsd.pronadjiVoznju(adresaDestinacije);
					if(voznja == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja voznji sa tom adresom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						VoznjeForma voznjef = new VoznjeForma(rsd, voznja);
						voznjef.setVisible(true);
					}
				}
			}
		});
		
		btnDodjeliVoznjuVozacu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int red = voznjeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					int id = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					Voznja voznja = rsd.NadjiVoznju(id);
					if(voznja == null || voznja.getStatus() != StatusVoznje.KREIRANA) {
						JOptionPane.showMessageDialog(null, "Ova voznja je vec zauzeta,odaberi drugu.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						DodjelaVoznjeProzor voznjep = new DodjelaVoznjeProzor(rsd, voznja);
						voznjep.setVisible(true);
					}
				}
				
			}
		});
	
}
		
		
	}


