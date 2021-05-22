package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.KolekcijeTest;
import net.miginfocom.swing.MigLayout;
import osobe.Musterija;
import radSaFajlovima.RadSaDatotekama;

public class LoginProzor extends JFrame {
	
	private JLabel lblPozdrav;
	private JLabel lblKorisnickoIme;
	private JTextField txtKorisnickoIme;
	private JLabel lblSifra;
	private JPasswordField txtSifra;
	private JButton btnPrijava;
	private JButton btnOtkazi;
	private RadSaDatotekama radSaDatotekama;
	
	public LoginProzor(RadSaDatotekama radSaDatotekama) {
		this.radSaDatotekama = radSaDatotekama;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initListeners();
		pack();
	}
	
	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
		
		this.lblPozdrav = new JLabel("Dobrodosli. Molimo da se prijavite.");
		this.lblKorisnickoIme = new JLabel("Korisnicko ime");
		this.txtKorisnickoIme = new JTextField(20);
		this.lblSifra = new JLabel("Sifra");
		this.txtSifra = new JPasswordField(20);
		this.btnPrijava = new JButton("Prijava");
		this.btnOtkazi = new JButton("Otkazi");
		
		this.getRootPane().setDefaultButton(btnPrijava);
		
		add(lblPozdrav , "span 2");
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblSifra);
		add(txtSifra);
		add(new JLabel());
		add(btnPrijava, "split 2");
		add(btnOtkazi);
	}
	
	private void initListeners() {
		btnOtkazi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
				
				
			}
		});
		
		btnPrijava.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(txtSifra.getPassword()).trim();
				
				if(korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke" , "Greska" , JOptionPane.WARNING_MESSAGE);
				}else {
					Musterija prijavljeni = radSaDatotekama.login(korisnickoIme, sifra);
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						LoginProzor.this.dispose();
						LoginProzor.this.setVisible(false);
						LoginProzorMusterija lpm = new LoginProzorMusterija(radSaDatotekama, prijavljeni);
						lpm.setVisible(true);
						
					}
				}
				
				
				
					
				
			}
		});
		
	}  }