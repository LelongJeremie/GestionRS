import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class connexion {



	private JFrame frame;
	private JTextField emailField;
	private JTextField mdpField;
	private Throwable e1;

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
	 * @wbp.parser.entryPoint
	 */
	public connexion() {
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

		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setBounds(247, 38, 227, 95);
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		frame.getContentPane().add(lblConnexion);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(350, 0, 20, 182);
		frame.getContentPane().add(verticalStrut);

		JLabel lblNewLabel = new JLabel("E-Mail : ");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 27));
		lblNewLabel.setBounds(115, 268, 112, 34);
		frame.getContentPane().add(lblNewLabel);

		emailField = new JTextField();
		emailField.setFont(new Font("Calibri Light", Font.PLAIN, 27));
		emailField.setBounds(272, 268, 251, 34);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);

		mdpField = new JTextField();
		mdpField.setFont(new Font("Calibri Light", Font.PLAIN, 27));
		mdpField.setColumns(10);
		mdpField.setBounds(272, 333, 251, 34);
		frame.getContentPane().add(mdpField);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Calibri Light", Font.PLAIN, 27));
		lblMotDePasse.setBounds(37, 333, 160, 34);
		frame.getContentPane().add(lblMotDePasse);

		JButton btnSeConnecter = new JButton("Connexion");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection cnx = null;
				int id = 0;
				String prenom = null;
				String nom = null;
				String age = null;
				String mail = null;
				Scanner scan = new Scanner(System.in);
				// On stock dans des variables l'URL de connexion � la base de donn�es avec les identifiants
				 String url="jdbc:mysql://localhost/siteschuman?serverTimezone=UTC";
		        String user="root";
		        String password="";
		        // Test pour v�rifier si nous arrivons � nous connecter
		        try {
		       	 // On cr�� une variable cnx de type Connection
		       	 // cnx contiendra la connextion � la base de donn�es
		        	cnx = DriverManager.getConnection(url,  user, password);
		            System.out.println("Etat de la connexion :");
				// Forme ternaire du if. Si la condition � �chou� alors on affiche � ferm� � sinon on affiche � ouverte �
		            System.out.println(cnx.isClosed()?"ferm�e":"ouverte");

		        }
		        // Si on arrive pas � se connetcer on attrape l'erreur pour l'afficher ensuite
					catch (SQLException e1) {
		            System.out.println("Une erreur est survenue lors de la connexion � la base de donn�es");
		            e1.printStackTrace();
		        }
		        try {
		        	// Pr�paration de la requ�te
					java.sql.Statement stm = cnx.createStatement();

					String mail1 = emailField.getText();
					String password1 = mdpField.getText();

					ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where mail = '" + mail1 + "' AND password = '" +password1+ "'");
					// On parcours toute les lignes de la requ�te tant qu'il y a des lignes

					  while(resultat.next()){
					         //R�cup�rer par nom de colonne
						  id = resultat.getInt("id");
						  nom = resultat.getString("Nom");
						  prenom = resultat.getString("Prenom");
						  role = resultat.getString("role");



					      }

		if(role.equals("1")) {

			 System.out.print("Bienvenue M/Mme " + nom +" "+ prenom );

			 administrateur g=new administrateur();
				g.run();
				frame.setVisible(false);
				this.dispose();



		}

		else {


			JLabel erreurlabel = new JLabel("Erreur durant la connexion : Mauvais mail ou mot de passe !");
			erreurlabel.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			erreurlabel.setForeground(Color.RED);
			erreurlabel.setBounds(222, 396, 369, 27);
			frame.getContentPane().add(erreurlabel);


			frame.repaint();
		}


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}

			private void dispose() {
				// TODO Auto-generated method stub

			}

		});
		btnSeConnecter.setFont(new Font("Calibri Light", Font.PLAIN, 27));
		btnSeConnecter.setBounds(257, 456, 227, 55);
		frame.getContentPane().add(btnSeConnecter);


	}

	public void run() {
		try {
			connexion window = new connexion();
			window.frame.setVisible(true);
		} catch (Exception e) {



		}
	}}
