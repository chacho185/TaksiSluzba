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

import enumeracija.TelOdeljenja;

import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;



import radSaFajlovima.RadSaDatotekama;

public class DispeceriForma extends JFrame {

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
	private JButton btnCanel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Dispecer dispecer;
	
	public DispeceriForma(RadSaDatotekama rsd, Dispecer dispecer) {
		this.rsd = rsd;
		this.dispecer = dispecer;
		if(dispecer == null) {
			setTitle("Dodavanje prodavca");
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
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][]20[]");
		setLayout(layout);
		
		if(dispecer != null) {
		//	popuniPolja();
		}
		
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
		add(btnCanel);
	}
	private void initActions() {
		
	}
}