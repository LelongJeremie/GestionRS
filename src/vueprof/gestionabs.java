package vueprof;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import accueil.Prof;
import accueil.Utilisateur;
import accueil.manager;
import vueadmin.classe;

public class gestionabs {

	private JFrame frame;
	private ResultSet resultat;
	private Utilisateur Monuser= new Utilisateur();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					gestionabs window = new gestionabs(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gestionabs(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 785, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Gestion Absences");
		lblNewLabel.setBounds(0, 0, 995, 65);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		frame.getContentPane().add(lblNewLabel);
		JButton btnretour = new JButton("Retour");
		btnretour.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnretour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			GestionARS u=new GestionARS(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub

			}


		});
		btnretour.setBounds(10, 11, 113, 38);
		frame.getContentPane().add(btnretour);


		
		manager man = new manager();

		resultat = man.toutlessusers();
		
		JComboBox<Utilisateur> comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 95, 975, 54);
		frame.getContentPane().add(comboBox);



		try {
			
			while(resultat.next()){

				Utilisateur Monuser= new Utilisateur();


				Monuser.setIdmodif(resultat.getString("utilisateur.id"));
				Monuser.setNommodif(resultat.getString("nom"));
				Monuser.setPrenommodif(resultat.getString("prenom"));
				Monuser.setMailmodif(resultat.getString("mail"));
				Monuser.setPasswordmodif(resultat.getString("password"));
				Monuser.setRolemodif(resultat.getString("role"));
				Monuser.setClassemodif(resultat.getString("libelle"));
				Monuser.setDate_naissancemodif(resultat.getString("date_naissance"));
				Monuser.setPseudomodif(resultat.getString("username"));
				Monuser.setValidationmodif(resultat.getString("Validation"));

				
				comboBox.addItem(Monuser);  



			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBox.addActionListener(new ActionListener() {     
			public void actionPerformed(ActionEvent e) {

				System.out.println("Valeur: " + comboBox.getSelectedItem().toString());      
			}
		});


		frame.getContentPane().add(comboBox); 
		frame.setSize(1009, 591); 
		frame.show();
		
		

		JButton btnRefresh = new JButton("Deselectionner");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionabs u=new gestionabs(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();
				
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
							
			}
		});
		btnRefresh.setBounds(536, 160, 127, 23);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnNewButton = new JButton("Selectionner");
		btnNewButton.addActionListener(new ActionListener() {
			private ResultSet resultat2;

			public void actionPerformed(ActionEvent e) {


				JLabel lblNewLabel_1 = new JLabel("Supprimer l'absence :");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(366, 261, 299, 13);
				frame.getContentPane().add(lblNewLabel_1);
				
				

				Utilisateur Monuser= new Utilisateur();
				Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
				resultat2 = man.touteslesabsences(Monuser);
				System.out.println(Monuser.getIdmodif()+"deijfz");
				JComboBox<Utilisateur> comboBox2 = new JComboBox();
				comboBox2.setBackground(Color.WHITE);
				comboBox2.setBounds(10, 200, 975, 54);
				frame.getContentPane().add(comboBox2);
				try {
					
					while(resultat2.next()){

						Utilisateur Monuser2= new Utilisateur();
						Monuser2.setIdmodif(resultat2.getString("id"));
						Monuser2.setSanction(resultat2.getString("ars"));
						Monuser2.setDate(resultat2.getString("date_heure"));
						Monuser2.setDuree(resultat2.getString("duree"));
						Monuser2.setCommentaire(resultat2.getString("commentaire"));

						
						comboBox2.addItem(Monuser2);  



					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					resultat2.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				comboBox2.addActionListener(new ActionListener() {     
					public void actionPerformed(ActionEvent e) {

						System.out.println("Valeur: " + comboBox2.getSelectedItem().toString());      
					}
				});


				frame.getContentPane().add(comboBox2); 
				frame.setSize(1009, 450); 
				frame.show();
				
				JButton btnNewButton_1 = new JButton("Supprimer");
				btnNewButton_1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
						Monuser.setDate(((Utilisateur) comboBox2.getSelectedItem()).getDate());
						man.supplesabsences(Monuser);
						GestionARS u=new GestionARS(user);
						u.run(user);
						frame.setVisible(false);
						this.dispose();
					}

					private void dispose() {
						// TODO Auto-generated method stub
						
					}
				});
				btnNewButton_1.setBounds(404, 454, 251, 21);
				frame.getContentPane().add(btnNewButton_1);
				
			
				
			}
		});
		btnNewButton.setBounds(365, 160, 127, 23);
		frame.getContentPane().add(btnNewButton);
		


	}

	public void run(Utilisateur user) {
		try {
			gestionabs window = new gestionabs(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
