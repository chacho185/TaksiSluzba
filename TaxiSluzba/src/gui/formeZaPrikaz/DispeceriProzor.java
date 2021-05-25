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

import gui.formeZaDodavanjeIIzmenu.DispeceriForma;
import main.KolekcijeTest;
import osobe.Dispecer;
import radSaFajlovima.RadSaDatotekama;

public class DispeceriProzor extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable dispeceriTabela;
	
	private RadSaDatotekama rsd;
	
	
	public DispeceriProzor(RadSaDatotekama rsd) {
		this.rsd = rsd;
		setTitle("Dispeceri");
		setSize(700, 500);
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
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		mainToolbar.setFloatable(false);
		
		String[] zaglavlja = new String[] {"id", "korIme" , "lozinka" , "ime" , "prezime" , "jmbg" , "adresa" , "pol",
				"brTel", "plata" , "brTelLinije" , "brOdeljenja"};
		Object[][] sadrzaj = new Object[rsd.sviNeobrisaniDispeceri().size()][zaglavlja.length];
		
		for(int i=0; i< rsd.sviNeobrisaniDispeceri().size(); i++) {
			Dispecer dispecer = rsd.sviNeobrisaniDispeceri().get(i);
			sadrzaj[i][0] = dispecer.getId();
			sadrzaj[i][1] = dispecer.getKorIme();
			sadrzaj[i][2] = dispecer.getLozinka();
			sadrzaj[i][3] = dispecer.getIme();
			sadrzaj[i][4] = dispecer.getPrezime();
			sadrzaj[i][5] = dispecer.getjMBG();
			sadrzaj[i][6] = dispecer.getAdresa();
			sadrzaj[i][7] = dispecer.getPol();
			sadrzaj[i][8] = dispecer.getBrTel();
			sadrzaj[i][9] = dispecer.getPlata();
			sadrzaj[i][10] = dispecer.getBrTelLinije();
			sadrzaj[i][11] = dispecer.getTelOdeljenja();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		dispeceriTabela = new JTable(tableModel);
		
		dispeceriTabela.setRowSelectionAllowed(true);
		dispeceriTabela.setColumnSelectionAllowed(false);
		dispeceriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dispeceriTabela.setDefaultEditor(Object.class, null);
		dispeceriTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(dispeceriTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = dispeceriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli","Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String korisnickoIme = tableModel.getValueAt(red, 1).toString();
					Dispecer dispecer = rsd.NadjiDispeceraPoKorisnickomImenu(korisnickoIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete dispecera?", 
							korisnickoIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						dispecer.setObrisan(true);
						tableModel.removeRow(red);
						rsd.upisiDispecere(RadSaDatotekama.dispeceri);
					
					}
				}
				}
				
			
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DispeceriForma df = new DispeceriForma(rsd, null);
				df.setVisible(true);
			}
		});
		
	}
	
}



