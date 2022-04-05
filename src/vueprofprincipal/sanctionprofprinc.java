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

public class sanctionprofprinc {

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
					sanctionprofprinc window = new sanctionprofprinc(user);
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
	public sanctionprofprinc(Utilisateur user) {
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
		manager man = new manager();

		resultat = man.usersanction(user);
	
		
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
				Monuser.setClasselibellemodif(resultat.getString("libelle"));
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
				
				Profprinc u=new Profprinc(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();
	
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnSelect = new JButton("Selectionner");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldsanction = new JTextField();
				textFieldsanction.setBackground(Color.LIGHT_GRAY);
				textFieldsanction.setBounds(51, 314, 570, 64);
				frame.getContentPane().add(textFieldsanction);
				textFieldsanction.setColumns(10);
				JLabel lblNewLabel_1 = new JLabel("D\u00E9crire la sanction : ");
				lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 16));
				lblNewLabel_1.setBounds(194, 213, 309, 50);
				frame.getContentPane().add(lblNewLabel_1);
				
				JButton btnsanctionner = new JButton("Sanctionner");
				btnsanctionner.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sanct = textFieldsanction.getText();
						Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
						Monuser.setSanction(sanct);
						try {
							man.ajoutsanction(Monuser);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						sanctionprofprinc u=new sanctionprofprinc(user);
						u.run(user);
						frame.setVisible(false);
						this.dispose();
					}

					private void dispose() {
						// TODO Auto-generated method stub
						
					}
				});
				btnsanctionner.setBounds(245, 420, 176, 32);
				frame.getContentPane().add(btnsanctionner);
				frame.repaint();
			}
		});
		btnSelect.setBounds(184, 174, 127, 23);
		frame.getContentPane().add(btnSelect);
		btnRetour.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRetour.setBounds(10, 11, 107, 36);
		frame.getContentPane().add(btnRetour);
		JButton btnRefresh = new JButton("Deselectionner");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sanctionprofprinc u=new sanctionprofprinc(user);
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
		
		JLabel lblSanction = new JLabel("Sanctions");
		lblSanction.setOpaque(true);
		lblSanction.setForeground(Color.WHITE);
		lblSanction.setBackground(Color.GRAY);
		lblSanction.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanction.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblSanction.setBounds(0, 0, 663, 64);
		frame.getContentPane().add(lblSanction);
		
		JLabel lblNewLabel = new JLabel("\u00E9l\u00E8ve avec plus de 3 sanctions : ");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 13));
		lblNewLabel.setBounds(51, 89, 260, 39);
		frame.getContentPane().add(lblNewLabel);
		
		
		

	}
	public void run(Utilisateur user) {
		try {
			sanctionprofprinc window = new sanctionprofprinc(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
