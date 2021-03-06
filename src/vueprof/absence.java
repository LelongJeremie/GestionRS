package vueprof;

import javax.swing.JLabel;
import accueil.Administrateur;
import accueil.Prof;
import accueil.Utilisateur;
import accueil.manager;
import vueadmin.adminuserprofil;

import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class absence {

	private JFrame frame;
	private ResultSet resultat;
	private int i;
	private JTextField textField;
	private Utilisateur Monuser= new Utilisateur();

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

	public absence(Utilisateur user) {
		initialize(user);
	}


	private void initialize(Utilisateur user) {

		manager man = new manager();

		resultat = man.toutlessusers();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 677, 568);
		frame.setBounds(100, 100, 677, 684);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Absence et retard");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(0, 0, 663, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(223, 169, 223, 32);
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
								 DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
							     System.out.println("yyyy/MM/dd hh:mm:ss-> "+dtf5.format(LocalDateTime.now()));
							
								Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
								Monuser.setDuree(""+textField.getText());
								Monuser.setDate(dtf5.format(LocalDateTime.now()));
								System.out.println(Monuser);
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
					private String date;

					public void actionPerformed(ActionEvent e) {
						 DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
					     System.out.println("yyyy/MM/dd hh:mm:ss-> "+dtf5.format(LocalDateTime.now()));
					
						
						JLabel lbldtdujour = new JLabel("Date : "+dtf5.format(LocalDateTime.now()));
						lbldtdujour.setFont(new Font("Calibri Light", Font.PLAIN, 31));
						lbldtdujour.setBounds(188, 391, 318, 47);
						frame.getContentPane().add(lbldtdujour);
						
						JButton btnValiderabsence = new JButton("Valider");
						btnValiderabsence.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
								Monuser.setDate(dtf5.format(LocalDateTime.now()));
								try {
									man.ajoutabsence(Monuser);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
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

