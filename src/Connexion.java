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


public class Connexion {



	private static int id;
	private static String nom;
	private static String email;
	JFrame frame;
	private JTextField emailField;
	private JTextField mdpField;
	private Throwable e1;
	private JButton btnretour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
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
	public Connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		manager man = new manager();
		
		
		
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
			private String role;
			private String res;
			public void actionPerformed(ActionEvent e) {
				Utilisateur user = new Utilisateur();
				
				user.setMail(emailField.getText());
				user.setPassword(mdpField.getText());
				
				
				manager man = new manager();
				
				res = man.connexion(user);
				
				System.out.println(user);
				System.out.println("aaa");
				System.out.println(res);
				
				if(res.equals("1")) { 
					
					
					
					System.out.println(user.getNom()); 
				
					 Administrateur u=new Administrateur(user);
						u.run(user);
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



			}

			private void dispose() {
				// TODO Auto-generated method stub

			}

		});
		btnSeConnecter.setFont(new Font("Calibri Light", Font.PLAIN, 27));
		btnSeConnecter.setBounds(257, 456, 227, 55);
		frame.getContentPane().add(btnSeConnecter);

		   
	}
	
	public static int envoieid(){
		System.out.println(id);
		return id;
	}
	
	public static String envoiemail(){
		
		return email;
	}
	
	public static String envoinom(){
		System.out.println(nom);
		return nom;
	}
	

	public void run() {
		try {
			Connexion window = new Connexion();
			window.frame.setVisible(true);
		} catch (Exception e) {



		}
	}}
