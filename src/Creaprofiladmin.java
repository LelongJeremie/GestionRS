import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class Creaprofiladmin {

	private JFrame frame;
	private JTextField textFieldconfirmation;
	private JTextField textFieldmdp;
	private JLabel lblconfirmation;
	private JLabel lblentrezmdp;
	private JTextField textFieldpseudo;
	private JTextField textFieldmail;
	private JTextField textFieldentreznaissance;
	private JTextField textFieldprenom;
	private Component lblrole;
	private JTextField textFieldentreznom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creaprofiladmin window = new Creaprofiladmin();
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
	public Creaprofiladmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 863, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblcreaadmin = new JLabel("Creer un utilisateur");
		lblcreaadmin.setBounds(250, 40, 367, 95);
		lblcreaadmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblcreaadmin.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		frame.getContentPane().add(lblcreaadmin);

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

		JRadioButton rdbtnadministratif = new JRadioButton("administratif");
		rdbtnadministratif.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnadministratif.setBounds(660, 409, 142, 26);
		frame.getContentPane().add(rdbtnadministratif);

		JRadioButton rdbtnprofesseur = new JRadioButton("Professeur");
		rdbtnprofesseur.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnprofesseur.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnprofesseur.setBounds(475, 409, 142, 26);
		frame.getContentPane().add(rdbtnprofesseur);
		
		textFieldentreznom = new JTextField();
		textFieldentreznom.setBounds(250, 179, 142, 33);
		frame.getContentPane().add(textFieldentreznom);
		textFieldentreznom.setColumns(10);
		
		JRadioButton rdbtnadmin = new JRadioButton("Admin");
		rdbtnadmin.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnadmin.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnadmin.setBounds(478, 363, 111, 23);
		frame.getContentPane().add(rdbtnadmin);
		
		JRadioButton rdbtnprofesseurprincipal = new JRadioButton("Professeur Principal");
		rdbtnprofesseurprincipal.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnprofesseurprincipal.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnprofesseurprincipal.setBounds(660, 363, 149, 25);
		frame.getContentPane().add(rdbtnprofesseurprincipal);
		
		JRadioButton rdbtnetudiant = new JRadioButton("Etudiant");
		rdbtnetudiant.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnetudiant.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnetudiant.setBounds(644, 455, 111, 23);
		frame.getContentPane().add(rdbtnetudiant);
		
		JRadioButton rdbtnparent = new JRadioButton("Parent");
		rdbtnparent.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnparent.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnparent.setBounds(479, 455, 122, 23);
		frame.getContentPane().add(rdbtnparent);
		

		
		JButton btnValidercrea = new JButton("Valider la creation");
		btnValidercrea.addActionListener(new ActionListener() {
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

					if(rdbtnadmin.isSelected()) {
						String role = "1";
						user.setRole(role);
						
					}
					else if(rdbtnprofesseurprincipal.isSelected()) {
						String role = "2";
						user.setRole(role);
					}
					
					else if(rdbtnprofesseur.isSelected()) {
						String role = "3";
						user.setRole(role);
					}
					
					else if(rdbtnadministratif.isSelected()) {
						String role = "4";
						user.setRole(role);
					}
					
					else if(rdbtnparent.isSelected()) {
						String role = "5";
						user.setRole(role);
					}
					
					else if(rdbtnetudiant.isSelected()) {
						String role = "6";
						user.setRole(role);
					}

					

					if(mdp.equals(confirmation)) {
						System.out.println("mdp confirm�");
					 tests = 1;
					}

					System.out.println(tests);
					if(tests == 1) {
					
					res = man.admincreaprofil(user);


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
		btnValidercrea.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnValidercrea.setBounds(547, 506, 189, 33);
		frame.getContentPane().add(btnValidercrea);
		
		
	}

	public void run() {
		try {
			Creaprofiladmin window = new Creaprofiladmin();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
