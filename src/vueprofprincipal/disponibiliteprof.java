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

public class disponibiliteprof {

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
					disponibiliteprof window = new disponibiliteprof(user);
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
	public disponibiliteprof(Utilisateur user) {
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

		resultat = man.userprof(user);
	
		
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
				Monuser.setDisponibilite(resultat.getString("Disponible"));

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
		
	
		btnRetour.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRetour.setBounds(10, 11, 107, 36);
		frame.getContentPane().add(btnRetour);
		JButton btnRefresh = new JButton("Deselectionner");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disponibiliteprof u=new disponibiliteprof(user);
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
		
		JLabel lblSanction = new JLabel("Disponibilit? Professseur");
		lblSanction.setOpaque(true);
		lblSanction.setForeground(Color.WHITE);
		lblSanction.setBackground(Color.GRAY);
		lblSanction.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanction.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblSanction.setBounds(0, 0, 663, 64);
		frame.getContentPane().add(lblSanction);
		
	
		
		
		

	}
	public void run(Utilisateur user) {
		try {
			disponibiliteprof window = new disponibiliteprof(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
