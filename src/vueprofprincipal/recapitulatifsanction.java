package vueprofprincipal;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import accueil.Administrateur;
import accueil.Prof;
import accueil.Profprinc;
import accueil.Utilisateur;
import accueil.manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import javax.swing.SwingConstants;

public class recapitulatifsanction {

	private JFrame frame;
	private ResultSet resultat;
	private int i;
	private Utilisateur Monuser= new Utilisateur();
	private JTextField textFieldsanction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					recapitulatifsanction window = new recapitulatifsanction(user);
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
	 * @param user 
	 */
	public recapitulatifsanction(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Utilisateur user) {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 676, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Profprinc u=new Profprinc(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();
	
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnRetour.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRetour.setBounds(10, 11, 107, 36);
		manager man = new manager();
		JLabel lblSanction = new JLabel("Recapitulatif");
		lblSanction.setOpaque(true);
		lblSanction.setForeground(Color.WHITE);
		lblSanction.setBackground(Color.GRAY);
		lblSanction.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanction.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblSanction.setBounds(0, 0, 663, 64);
		frame.getContentPane().add(lblSanction);
		

		resultat = man.usertouteslessanctions(user);
	
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(51, 124, 578, 32);
		frame.getContentPane().add(comboBox);

		try {
			i=0;
			while(resultat.next()){

				Utilisateur Monuser= new Utilisateur();



				Monuser.setNommodif(resultat.getString("nom"));
				Monuser.setIdmodif(resultat.getString("utilisateur.id"));
				Monuser.setPrenommodif(resultat.getString("prenom"));
				
				

				System.out.println("ID = "+Monuser.getIdmodif()+"i= "+i);
				i=i+1;
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
	
		JButton btnSelect = new JButton("Selectionner");
		btnSelect.addActionListener(new ActionListener() {
			private ResultSet resultat1;

			public void actionPerformed(ActionEvent e) {
				

				Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
				Monuser.setNommodif(((Utilisateur) comboBox.getSelectedItem()).getNommodif());
				Monuser.setPrenommodif(((Utilisateur) comboBox.getSelectedItem()).getPrenommodif());
				
				System.out.println(Monuser.getIdmodif());
				
				resultat1 = man.recapitulatif(Monuser);
				

				JComboBox<Sanction> comboBox_1 = new JComboBox<Sanction>();
				comboBox_1.setBounds(51, 250, 578, 32);
				frame.getContentPane().add(comboBox_1);
				
				
				try {
					while(resultat1.next()){
						Sanction sanc= new Sanction();
						

						sanc.setDuree(resultat1.getString("duree"));
						sanc.setCommentaire(resultat1.getString("commentaire"));
						sanc.setDate(resultat1.getString("date_heure"));
						System.out.println(sanc.getCommentaire());
					
						System.out.println("ID = "+sanc.getCommentaire()+"i= "+i);
						i=i+1;
						
						comboBox_1.addItem(sanc);  
					
						


					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				JButton btnRetour_1 = new JButton("Retour");
				btnRetour_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Profprinc u=new Profprinc(user);
						u.run(user);
						frame.setVisible(false);
						this.dispose();
			
					}

					private void dispose() {
						// TODO Auto-generated method stub
						
					
						
					}
				});
				btnRetour_1.setFont(new Font("Calibri", Font.PLAIN, 12));
				btnRetour_1.setBounds(291, 208, 107, 23);
				frame.getContentPane().add(btnRetour_1);
				
				frame.repaint();
				
				
			
				
					}

					
				});
		
		btnSelect.setBounds(184, 174, 127, 23);
		frame.getContentPane().add(btnSelect);
		
		frame.getContentPane().add(btnRetour);
		JButton btnRefresh = new JButton("Deselectionner");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recapitulatifsanction u=new recapitulatifsanction(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();
				
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
							
			}
		});
		btnRefresh.setBounds(372, 174, 127, 23);
		frame.getContentPane().add(btnRefresh);
		
		
	
		
		

	}
	public void run(Utilisateur user) {
		try {
			recapitulatifsanction window = new recapitulatifsanction(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
