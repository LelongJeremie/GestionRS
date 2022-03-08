package vueprof;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import accueil.Administrateur;
import accueil.Prof;
import accueil.Utilisateur;
import accueil.manager;
import vueadmin.adminuserprofil;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class absence {

	private JFrame frame;
	private ResultSet resultat;
	private int i;
	private JTextField textField;
	private Utilisateur Monuser= new Utilisateur();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					absence window = new absence(user);
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
	public absence(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Utilisateur user) {

		manager man = new manager();

		resultat = man.test();

		frame = new JFrame();
		frame.setBounds(100, 100, 677, 684);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Absence et retard");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(223, 11, 239, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(51, 124, 578, 32);
		frame.getContentPane().add(comboBox);

		try {
			i=0;
			while(resultat.next()){

				Utilisateur Monuser= new Utilisateur();


				Monuser.setIdmodif(resultat.getString("id"));
				Monuser.setNommodif(resultat.getString("nom"));
				Monuser.setPrenommodif(resultat.getString("prenom"));
				Monuser.setMailmodif(resultat.getString("mail"));
				Monuser.setPasswordmodif(resultat.getString("password"));
				Monuser.setRolemodif(resultat.getString("role"));
				Monuser.setClassemodif(resultat.getString("classe"));
				Monuser.setDate_naissancemodif(resultat.getString("date_naissance"));
				Monuser.setPseudomodif(resultat.getString("username"));
				Monuser.setValidationmodif(resultat.getString("Validation"));

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
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Prof u=new Prof(user);
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
		frame.getContentPane().add(btnRetour);
		ButtonGroup group = new ButtonGroup();
		
		JButton btnSelect = new JButton("Selectionner");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btnRetard = new JButton("Retard");
				btnRetard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField = new JTextField();
						textField.setBounds(110, 449, 107, 23);
						frame.getContentPane().add(textField);
						textField.setColumns(10);
						
						JLabel lblNewLabel_1 = new JLabel("Duree du retard :");
						lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 16));
						lblNewLabel_1.setBounds(110, 411, 170, 27);
						frame.getContentPane().add(lblNewLabel_1);
						
						JLabel lblmnt = new JLabel("minutes.");
						lblmnt.setFont(new Font("Calibri Light", Font.PLAIN, 14));
						lblmnt.setBounds(231, 451, 80, 23);
						frame.getContentPane().add(lblmnt);
						
						JButton btnConfirmerretard = new JButton("Confirmer");
						btnConfirmerretard.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println(Monuser);
								Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
								Monuser.setDuree(""+textField.getText());
								try {
									man.ajoutretard(Monuser);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						btnConfirmerretard.setFont(new Font("Calibri Light", Font.PLAIN, 16));
						btnConfirmerretard.setBounds(357, 440, 156, 32);
						frame.getContentPane().add(btnConfirmerretard);
						
						frame.repaint();
					}
				});
				btnRetard.setBounds(184, 245, 127, 23);
				frame.getContentPane().add(btnRetard);
				
				JButton btnAbsence = new JButton("Absence");
				btnAbsence.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
					     System.out.println("yyyy/MM/dd hh:mm:ss-> "+dtf5.format(LocalDateTime.now()));
					
						
						JLabel lbldtdujour = new JLabel("Date : "+dtf5.format(LocalDateTime.now()));
						lbldtdujour.setFont(new Font("Calibri Light", Font.PLAIN, 31));
						lbldtdujour.setBounds(188, 391, 318, 47);
						frame.getContentPane().add(lbldtdujour);
						
						JButton btnValiderabsence = new JButton("Valider");
						btnValiderabsence.setFont(new Font("Calibri Light", Font.PLAIN, 18));
						btnValiderabsence.setBounds(264, 475, 152, 36);
						frame.getContentPane().add(btnValiderabsence);
						
						
						frame.repaint();
					}
				});
				btnAbsence.setBounds(373, 245, 126, 23);
				frame.getContentPane().add(btnAbsence);
				frame.repaint();
			}
		});
		btnSelect.setBounds(184, 174, 127, 23);
		frame.getContentPane().add(btnSelect);
		
		JButton btnRefresh = new JButton("Deselectionner");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				absence u=new absence(user);
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
			absence window = new absence(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
