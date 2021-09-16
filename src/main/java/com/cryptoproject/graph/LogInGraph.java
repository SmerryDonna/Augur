package com.cryptoproject.graph;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInGraph {
	
	private JFrame frame;
	
	LogInGraph login;
	private JTextField txtNomeUtente;
	private JTextField txtPswUtente;
	
	private JButton btnSubmit = new JButton("Submit");
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LogInGraph login = new LogInGraph();
					login.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LogInGraph() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nomeUtente = new JLabel("Nome Utente");
		nomeUtente.setBounds(90, 75, 63, 14);
		panel.add(nomeUtente);
		
		JLabel pswUtente = new JLabel("Password Utente");
		pswUtente.setBounds(90, 125, 82, 14);
		panel.add(pswUtente);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(335, 227, 89, 23);
		panel.add(btnSubmit);
		
		txtNomeUtente = new JTextField();
		txtNomeUtente.setBounds(205, 72, 170, 20);
		panel.add(txtNomeUtente);
		txtNomeUtente.setColumns(10);
		
		txtPswUtente = new JTextField();
		txtPswUtente.setBounds(205, 122, 170, 20);
		panel.add(txtPswUtente);
		txtPswUtente.setColumns(10);
		
	}

	public String getUsername() {
		return txtNomeUtente.getText();
	}

	public String getPsw() {
		return txtPswUtente.getText();
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}
}
