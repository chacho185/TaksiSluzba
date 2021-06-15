package gui.formeZaPrikaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enumeracija.StatusVoznje;
import main.KolekcijeTest;
import net.miginfocom.swing.MigLayout;
import osobe.Musterija;
import taxiSluzba.Voznja;
import radSaFajlovima.RadSaDatotekama;

public class ZavrsiVoznjuProzor extends JFrame {

	private JLabel lblBrojPredjenihKilometara = new JLabel("Broj predjenih kilometara");
	private JTextField txtBrojPredjenihKilometara = new JTextField(20);
	private JLabel lblTrajanjeVoznje = new JLabel("Trajanje voznje");
	private JTextField txtTrajanjeVoznje= new JTextField(20);
	private JButton btnZavrsiVoznju = new JButton("Zavrsi voznju");
	private JButton btnCancel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Voznja voznja;
	
	public ZavrsiVoznjuProzor(RadSaDatotekama rsd, Voznja voznja) {
		this.rsd = rsd;
		this.voznja = voznja;
		setTitle("Zavrsi voznju - " + voznja.getDatum());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(true);
		pack();
		getRootPane().setDefaultButton(btnZavrsiVoznju);
	}
	
	private void initGUI() {
		
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[]10[]10[]");
		setLayout(mig);
		
		add(lblBrojPredjenihKilometara);
		add(txtBrojPredjenihKilometara);
		add(lblTrajanjeVoznje);
		add(txtTrajanjeVoznje);
		add(new JLabel());
		add(btnZavrsiVoznju, "split 2");
		add(btnCancel);
		
		getRootPane().setDefaultButton(btnZavrsiVoznju);
	}
	
	private void initActions() {
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZavrsiVoznjuProzor.this.dispose();
				ZavrsiVoznjuProzor.this.setVisible(false);
				
			}
		});
		
		btnZavrsiVoznju.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				voznja.setBrojPredjenihKilometara(Integer.parseInt(txtBrojPredjenihKilometara.getText().trim()));
				voznja.setTrajanjeVoznje(Integer.parseInt(txtTrajanjeVoznje.getText().trim()));
				
				voznja.setStatus(StatusVoznje.ZAVRSENA);
				voznja.setObrisan(false);
				
				
				rsd.upisiVoznje(RadSaDatotekama.voznje);
				
				ZavrsiVoznjuProzor.this.dispose();
				ZavrsiVoznjuProzor.this.setVisible(false);
				
			}
		});
	}
	
}