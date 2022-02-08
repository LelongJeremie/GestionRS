import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class index {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bienvenue");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 41));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(133, 40, 457, 103);
		frame.getContentPane().add(lblNewLabel);

		JButton btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription g=new Inscription();
				g.run();
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub

			}
		});
		btnInscription.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		btnInscription.setBounds(133, 189, 457, 78);
		frame.getContentPane().add(btnInscription);

		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				Connexion g=new Connexion();
				g.run();
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub

			}
		});
		btnConnexion.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		btnConnexion.setBounds(133, 351, 457, 78);
		frame.getContentPane().add(btnConnexion);

		JButton btnmdpoublie = new JButton("mot de passe oubli\u00E9e ?");
		btnmdpoublie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Motdepasse g=new Motdepasse();
				g.run();
				frame.setVisible(false);
				this.dispose();


			}

			private void dispose() {
				// TODO Auto-generated method stub

			}
		});
		btnmdpoublie.setForeground(Color.WHITE);
		btnmdpoublie.setBackground(Color.BLUE);
		btnmdpoublie.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		btnmdpoublie.setBounds(469, 475, 144, 34);
		frame.getContentPane().add(btnmdpoublie);

		JLabel lblmdpoublie = new JLabel("Mot de passe oubli\u00E9? Cliquer ici :");
		lblmdpoublie.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblmdpoublie.setBounds(213, 475, 245, 34);
		frame.getContentPane().add(lblmdpoublie);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(350, 0, 20, 182);
		frame.getContentPane().add(verticalStrut);
	}

	public void run() {
		try {
			index window = new index();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}}
