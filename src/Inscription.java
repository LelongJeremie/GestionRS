import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Inscription {

	private JFrame frame;
	private JTextField textFieldentreznom;
	private JTextField textFieldprenom;
	private JTextField textFieldentreznaissance;
	private JTextField textFieldmail;
	private JTextField textFieldpseudo;
	private JLabel lblentrezmdp;
	private JTextField textFieldmdp;
	private JTextField textFieldconfirmation;
	private JLabel lblconfirmation;
	private JLabel lblrole;
	private JButton btnretour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription window = new Inscription();
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
	public Inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		frame.setBounds(100, 100, 850, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setBounds(325, 40, 227, 95);
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		frame.getContentPane().add(lblInscription);

		textFieldentreznom = new JTextField();
		textFieldentreznom.setBounds(250, 180, 142, 33);
		frame.getContentPane().add(textFieldentreznom);
		textFieldentreznom.setColumns(10);

		textFieldprenom = new JTextField();
		textFieldprenom.setBounds(250, 250, 142, 33);
		frame.getContentPane().add(textFieldprenom);
		textFieldprenom.setColumns(10);

		JLabel lblentreznom = new JLabel("Entrez votre nom :");
		lblentreznom.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblentreznom.setBounds(40, 185, 140, 25);
		frame.getContentPane().add(lblentreznom);

		JLabel lblentrezprenom = new JLabel("Entrez votre prenom :");
		lblentrezprenom.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblentrezprenom.setBounds(40, 256, 140, 25);
		frame.getContentPane().add(lblentrezprenom);

		JLabel lbldatenaissance = new JLabel("Entrez votre date de naissance : ");
		lbldatenaissance.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lbldatenaissance.setBounds(40, 331, 202, 25);
		frame.getContentPane().add(lbldatenaissance);

		textFieldentreznaissance = new JTextField();
		textFieldentreznaissance.setBounds(250, 325, 142, 33);
		frame.getContentPane().add(textFieldentreznaissance);
		textFieldentreznaissance.setColumns(10);

		JLabel lblentrezmail = new JLabel("Entrez votre mail :");
		lblentrezmail.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblentrezmail.setBounds(40, 410, 189, 25);
		frame.getContentPane().add(lblentrezmail);

		textFieldmail = new JTextField();
		textFieldmail.setBounds(250, 410, 142, 33);
		frame.getContentPane().add(textFieldmail);
		textFieldmail.setColumns(10);

		JLabel lblentrezpseudo = new JLabel("Entrez votre pseudo :");
		lblentrezpseudo.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblentrezpseudo.setBounds(40, 490, 189, 25);
		frame.getContentPane().add(lblentrezpseudo);

		textFieldpseudo = new JTextField();
		textFieldpseudo.setBounds(250, 490, 142, 33);
		frame.getContentPane().add(textFieldpseudo);
		textFieldpseudo.setColumns(10);

		lblentrezmdp = new JLabel("Entrez votre mot de passe : ");
		lblentrezmdp.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblentrezmdp.setBounds(475, 185, 175, 25);
		frame.getContentPane().add(lblentrezmdp);

		textFieldmdp = new JTextField();
		textFieldmdp.setBounds(660, 180, 142, 33);
		frame.getContentPane().add(textFieldmdp);
		textFieldmdp.setColumns(10);

		textFieldconfirmation = new JTextField();
		textFieldconfirmation.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		textFieldconfirmation.setBounds(660, 250, 142, 33);
		frame.getContentPane().add(textFieldconfirmation);
		textFieldconfirmation.setColumns(10);

		lblconfirmation = new JLabel("Confirmer le mot de passe : ");
		lblconfirmation.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblconfirmation.setBounds(475, 256, 175, 25);
		frame.getContentPane().add(lblconfirmation);

		lblrole = new JLabel("Choisissez votre role : ");
		lblrole.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblrole.setBounds(567, 331, 142, 25);
		frame.getContentPane().add(lblrole);

		JRadioButton rdbtnadministratif = new JRadioButton("Administratif");
		rdbtnadministratif.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnadministratif.setBounds(475, 409, 142, 26);
		frame.getContentPane().add(rdbtnadministratif);

		JRadioButton rdbtnProfesseur = new JRadioButton("Professeur");
		rdbtnProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnProfesseur.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnProfesseur.setBounds(631, 409, 142, 26);
		frame.getContentPane().add(rdbtnProfesseur);

		JButton btnValidezinscription = new JButton("Validez");
		btnValidezinscription.addActionListener(new ActionListener() {
			private int tests;
			private String res;
			public void actionPerformed(ActionEvent e) {
				Utilisateur user = new Utilisateur();
				
				
				manager man = new manager();
				int id = 0;
				
		        

					String nom = textFieldentreznom.getText();
					String prenom = textFieldprenom.getText();
					String mail = textFieldmail.getText();
					String mdp = textFieldmdp.getText();
					String date_naissance = textFieldentreznaissance.getText();
					String pseudo = textFieldpseudo.getText();
					String confirmation = textFieldconfirmation.getText();
					
					user.setMail(mail);
					user.setPassword(mdp);
					user.setNom(nom);
					user.setPrenom(prenom);
					user.setDate_naissance(date_naissance);
					user.setPseudo(pseudo);

					if(rdbtnadministratif.isSelected()) {
						String role = "4";
						user.setRole(role);
						
					}
					else if(rdbtnProfesseur.isSelected()) {
						String role = "3";
						user.setRole(role);
					}

					

					if(mdp.equals(confirmation)) {
						System.out.println("mdp confirm�");
					 tests = 1;
					}

					System.out.println(tests);
					if(tests == 1) {
					
					res = man.inscription(user);


					Popup_inscription g=new Popup_inscription();
					g.run();
					frame.setVisible(false);
					this.dispose();
					}


				
			}

			private void dispose() {
				// TODO Auto-generated method stub

			}
		});
		btnValidezinscription.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnValidezinscription.setBounds(567, 506, 142, 33);
		frame.getContentPane().add(btnValidezinscription);
		
		btnretour = new JButton("Retour");
		btnretour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			index u=new index();
				u.run();
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
				
			
		});
		btnretour.setBounds(10, 11, 113, 38);
		frame.getContentPane().add(btnretour);
	}

	public void run() {
		try {
			Inscription window = new Inscription();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
