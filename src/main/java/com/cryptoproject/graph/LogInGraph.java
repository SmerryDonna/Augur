package com.cryptoproject.graph;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.coinmarketapi.models.ApiResponse;
import com.cyptoproject.login.GoogleAuthHelper;

public class LogInGraph {

	private JFrame frame;

	LogInGraph login;

	private ImageIcon icon;

	private ImageIcon imageBtn;

	private JLabel myLabel;

	private JButton btnSubmit;

	public LogInGraph() {
		initialize();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

	private void initialize() {

		icon = new ImageIcon(this.getClass().getResource("/Splashpage.png"));

		imageBtn = new ImageIcon(this.getClass().getResource("/loginGoogle.png"));

		Image scaleImage = imageBtn.getImage();
		Image newimage = scaleImage.getScaledInstance(100, 30, Image.SCALE_SMOOTH);

		frame = new JFrame("Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image ic = Toolkit.getDefaultToolkit().getImage("/favicon.png");
		frame.setIconImage(ic);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnSubmit = new JButton();

		btnSubmit.setBounds(140, 211, 172, 31);
		btnSubmit.setIcon(imageBtn);
		panel.add(btnSubmit);
		btnSubmit.setBorder(new RoundedBorder(10));

		myLabel = new JLabel(icon);
		myLabel.setLocation(0, 0);
		panel.add(myLabel);
		myLabel.setSize(450, 300);

		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				ApiResponse<String> responseLogIn = new ApiResponse();
				try {
					GoogleAuthHelper helper = new GoogleAuthHelper();
					d.browse(new URL(helper.buildLoginUrl()).toURI());
				} catch (Exception a) {
					a.printStackTrace();
				}

			}
		});

	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}
}
