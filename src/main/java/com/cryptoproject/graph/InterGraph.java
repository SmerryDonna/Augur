package com.cryptoproject.graph;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterGraph {

	private JFrame frame;

	private static InterGraph inter;

	private JTextField txtIndirizzoPortafoglio;
	private JTextField txtPrevisione;
	private JTextField txtQuotaBet;

	private JButton btnSubmit;

	private String[] valute = { "Bitcoin", "Ethereum", "litecoin", "Dogecoin" };

	private JComboBox tendinaValuta = new JComboBox(valute);
	private JLabel lblVintoPerso;
	private JLabel lblRisultato;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					inter = new InterGraph();
					inter.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterGraph() {
		initialize();
	}

	// Il metodo inizializza tutti gli elementi della finestra dando loro
	// dimensioni, posizione e contenuto
	private void initialize() {

		frame = new JFrame("Bet-your-best");
		frame.setBounds(100, 100, 653, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblIndirizzoPortafoglio = new JLabel("Indirizzo Portafoglio");
		lblIndirizzoPortafoglio.setBounds(10, 11, 95, 14);
		panel.add(lblIndirizzoPortafoglio);

		txtIndirizzoPortafoglio = new JTextField();
		txtIndirizzoPortafoglio.setBounds(10, 36, 261, 20);
		panel.add(txtIndirizzoPortafoglio);
		txtIndirizzoPortafoglio.setColumns(10);

		JLabel lblSceltaValuta = new JLabel("Scegli Valuta");
		lblSceltaValuta.setBounds(10, 97, 60, 14);
		panel.add(lblSceltaValuta);

		tendinaValuta.setBounds(10, 122, 131, 22);
		panel.add(tendinaValuta);

		JLabel lblInserisciPrevisione = new JLabel("Inserisci Previsione");
		lblInserisciPrevisione.setBounds(442, 11, 91, 14);
		panel.add(lblInserisciPrevisione);

		txtPrevisione = new JTextField();
		txtPrevisione.setBounds(442, 36, 130, 20);
		panel.add(txtPrevisione);
		txtPrevisione.setColumns(10);

		JLabel lblQuotaBet = new JLabel("Inserisci Quota Scommessa");
		lblQuotaBet.setBounds(442, 97, 130, 14);
		panel.add(lblQuotaBet);

		txtQuotaBet = new JTextField();
		txtQuotaBet.setBounds(442, 123, 130, 20);
		panel.add(txtQuotaBet);
		txtQuotaBet.setColumns(10);

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(276, 188, 89, 23);
		panel.add(btnSubmit);

		lblRisultato = new JLabel("Risultato");
		lblRisultato.setBounds(10, 192, 46, 14);
		panel.add(lblRisultato);

		lblVintoPerso = new JLabel("");
		lblVintoPerso.setBounds(77, 192, 46, 14);
		panel.add(lblVintoPerso);

	}

	// serei di metodi get utilizzati dal controller per comunicare con la vista
	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public String getPortafoglio() {
		return txtIndirizzoPortafoglio.getSelectedText();
	}

	public String getPrevisione() {
		return txtPrevisione.getSelectedText();
	}

	public String getScommessa() {
		return txtQuotaBet.getSelectedText();
	}

	public String getValuta() {
		return (String) tendinaValuta.getSelectedItem();
	}

	public void setVintoPerso(String risultato) {
		lblVintoPerso.setText(risultato);
	}
}
