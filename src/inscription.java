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

public class inscription {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscription window = new inscription();
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
	public inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		JRadioButton rdbtnparent = new JRadioButton("Parent");
		rdbtnparent.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnparent.setBounds(475, 409, 142, 26);
		frame.getContentPane().add(rdbtnparent);
		
		JRadioButton rdbtnProfesseur = new JRadioButton("Professeur");
		rdbtnProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnProfesseur.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		rdbtnProfesseur.setBounds(631, 409, 142, 26);
		frame.getContentPane().add(rdbtnProfesseur);
		
		JButton btnValidezinscription = new JButton("Validez");
		btnValidezinscription.addActionListener(new ActionListener() {
			private int tests;

			public void actionPerformed(ActionEvent e) {
				Connection cnx = null; 
				int id = 0;
				Scanner scan = new Scanner(System.in);
				// On stock dans des variables l'URL de connexion à la base de données avec les identifiants  
				 String url="jdbc:mysql://localhost/siteschuman?serverTimezone=UTC";  
		        String user="root";  
		        String password="";  
		        // Test pour vérifier si nous arrivons à nous connecter
		        try {  
		       	 // On créé une variable cnx de type Connection 
		       	 // cnx contiendra la connextion à la base de données
		        	cnx = DriverManager.getConnection(url,  user, password);  
		            System.out.println("Etat de la connexion :");  
				// Forme ternaire du if. Si la condition à échoué alors on affiche « fermé » sinon on affiche « ouverte » 
		            System.out.println(cnx.isClosed()?"fermée":"ouverte");  
		                 
		        } 
		        // Si on arrive pas à se connetcer on attrape l'erreur pour l'afficher ensuite
					catch (SQLException e2) {  
		            System.out.println("Une erreur est survenue lors de la connexion à la base de données");  
		            e2.printStackTrace();  
		        } 
		        try { 
		        	// Préparation de la requête 
					java.sql.Statement stm = cnx.createStatement(); 
					
					
					ResultSet resultat = stm.executeQuery("SELECT *  FROM utilisateur"); 
					// On parcours toute les lignes de la requête tant qu'il y a des lignes
					while(resultat.next()){ 
					// Affichage des lignes à la colonne "id" 
					id = resultat.getInt("id");
					id++;
				} 
					
					String nom = textFieldentreznom.getText();
					String prenom = textFieldprenom.getText();
					String mail = textFieldmail.getText();
					String mdp = textFieldmdp.getText();
					String date_naissance = textFieldentreznaissance.getText();
					String pseudo = textFieldpseudo.getText();
					String confirmation = textFieldconfirmation.getText();
					
					if(rdbtnparent.isSelected()) {
						String role = "4";
					}
					else if(rdbtnProfesseur.isSelected()) {
						String role = "3";
					}

					System.out.println(mdp);
					System.out.println(confirmation);
					
					if(mdp.equals(confirmation)) {
						System.out.println("mdp confirmé");
					 tests = 1;
					}
					
					System.out.println(tests);
					if(tests == 1) {
					
					int insert = stm.executeUpdate("INSERT INTO utilisateur(id,nom,prenom,date_naissance, role, mail, username, password, validation) VALUES ('" + id +"','" + nom +"','" + prenom +"','" + date_naissance +"','" + 1 +"', '" + mail + "','" + pseudo + "','" + mdp + "','" + "0" + "')");
					
					
					Popup_inscription g=new Popup_inscription();
					g.run();
					frame.setVisible(false);
					this.dispose();
					}
					
					
				} catch (SQLException e2) { 
					// TODO Auto-generated catch block
					e2.printStackTrace(); 
				}	 
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnValidezinscription.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnValidezinscription.setBounds(567, 506, 142, 33);
		frame.getContentPane().add(btnValidezinscription);
	}

	public void run() {
		try {
			inscription window = new inscription();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
