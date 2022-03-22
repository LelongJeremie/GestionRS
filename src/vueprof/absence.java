package vueprof;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import accueil.Administrateur;
import accueil.Utilisateur;
import accueil.manager;
import vueadmin.PopupAdmin;
import vueadmin.classe;

import java.awt.Color;


public class absence {

	private JFrame frame;
	private ResultSet resultat;
	private ResultSet resultatclasse;
	private JTextField FieldPrenom;
	private JTextField FieldMail;
	private JTextField fieldDatenaissance;
	private JTextField fieldpassword;
	private JTextField FieldPseudo;
	private int i;
	private Utilisateur Monuser= new Utilisateur();
	private classe Userclasse = new classe(); 
	private JComboBox comboboxvalidation;
	private JComboBox comboBoxrole;
	private JLabel lblRole;
	private JTextField Fieldnom;

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
		});}



	/**
	 * Create the application.
	 * @param user 
	 */
	public absence(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {

		manager man = new manager();

		resultat = man.toutlessusers();

		frame = new JFrame();
		frame.setBounds(100, 100, 909, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox<Utilisateur> comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 49, 975, 54);
		frame.getContentPane().add(comboBox);

		JComboBox<classe> comboBoxclasse = new JComboBox();


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
		frame.setSize(1009, 450); 
		frame.show();


		JButton btnSelect = new JButton("Selectionner");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultatclasse = man.afficherclasse();

				man.selectmodifprofiladmin(Monuser);

				Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
				Monuser.setNommodif(((Utilisateur) comboBox.getSelectedItem()).getNommodif());
				Monuser.setPrenommodif(((Utilisateur) comboBox.getSelectedItem()).getPrenommodif());
				Monuser.setMailmodif(((Utilisateur) comboBox.getSelectedItem()).getMailmodif());
				Monuser.setPasswordmodif(((Utilisateur) comboBox.getSelectedItem()).getPasswordmodif());
				Monuser.setRolemodif(((Utilisateur) comboBox.getSelectedItem()).getRolemodif());
				Monuser.setDate_naissancemodif(((Utilisateur) comboBox.getSelectedItem()).getDate_naissancemodif());
				Monuser.setPseudomodif(((Utilisateur) comboBox.getSelectedItem()).getPseudomodif());




				JComboBox<classe> comboBoxclasse = new JComboBox();
				comboBoxclasse.setBounds(453, 280, 177, 25);
				frame.getContentPane().add(comboBoxclasse);


				try {

					while(resultatclasse.next()){ 
						classe Userclasse = new classe(); 

						Userclasse.setIdclasse(resultatclasse.getString("id"));
						Userclasse.setClasse(resultatclasse.getString("libelle"));
						comboBoxclasse.addItem(Userclasse);


					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 




				FieldPrenom = new JTextField(Monuser.getPrenommodif());
				FieldPrenom.setBounds(286, 165, 115, 27);
				frame.getContentPane().add(FieldPrenom);
				FieldPrenom.setColumns(10);

				Fieldnom = new JTextField(Monuser.getNommodif());
				Fieldnom.setColumns(10);
				Fieldnom.setBounds(481, 168, 115, 27);
				frame.getContentPane().add(Fieldnom);

				FieldMail = new JTextField(Monuser.getMailmodif());
				FieldMail.setColumns(10);
				FieldMail.setBounds(662, 168, 115, 27);
				frame.getContentPane().add(FieldMail);

				fieldDatenaissance = new JTextField(Monuser.getPrenommodif());
				fieldDatenaissance.setColumns(10);
				fieldDatenaissance.setBounds(286, 221, 115, 27);
				frame.getContentPane().add(fieldDatenaissance);

				fieldpassword = new JTextField(Monuser.getPasswordmodif());
				fieldpassword.setColumns(10);
				fieldpassword.setBounds(481, 221, 115, 27);
				frame.getContentPane().add(fieldpassword);

				FieldPseudo = new JTextField(Monuser.getPseudomodif());
				FieldPseudo.setColumns(10);
				FieldPseudo.setBounds(662, 221, 115, 27);
				frame.getContentPane().add(FieldPseudo);

				comboboxvalidation = new JComboBox();
				comboboxvalidation.setModel(new DefaultComboBoxModel(new String[] {"Desactive", "En cours d'activation", "Active"}));
				comboboxvalidation.setBounds(662, 281, 115, 22);
				frame.getContentPane().add(comboboxvalidation);

				JLabel lblValidation = new JLabel("Validation: "+((Utilisateur) comboBox.getSelectedItem()).getValidationmodif());
				lblValidation.setBounds(661, 259, 93, 14);
				frame.getContentPane().add(lblValidation);

				comboBoxrole = new JComboBox();
				comboBoxrole.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Prof. Principal", "Prof.", "Administration", "Parent", "Eleve"}));
				comboBoxrole.setBounds(241, 281, 160, 22);
				frame.getContentPane().add(comboBoxrole);

				lblRole = new JLabel("Role: "+((Utilisateur) comboBox.getSelectedItem()).getRolemodif());
				lblRole.setBounds(241, 259, 147, 14);
				frame.getContentPane().add(lblRole);

				JButton btnModificationadmin = new JButton("Modification");
				btnModificationadmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Monuser.setNommodif(""+Fieldnom.getText());
						Monuser.setPrenommodif(""+FieldPrenom.getText());
						Monuser.setMailmodif(""+FieldMail.getText());
						Monuser.setDate_naissance(""+fieldDatenaissance.getText());
						Monuser.setPseudomodif(""+FieldPseudo.getText());
						Monuser.setPasswordmodif(""+fieldpassword.getText());
						Monuser.setClassemodif(((classe) comboBoxclasse.getSelectedItem()).getIdclasse());
						Monuser.setRolemodif(comboBoxrole.getSelectedItem().toString());
						Monuser.setValidationmodif(comboboxvalidation.getSelectedItem().toString());

						man.selectmodifprofiladmin(Monuser);





						PopupAdmin u=new PopupAdmin(user);
						u.run(user);
						frame.setVisible(false);
						this.dispose();

					}

					private void dispose() {
						// TODO Auto-generated method stub

					}






				});
				btnModificationadmin.setBounds(488, 337, 108, 37);
				frame.getContentPane().add(btnModificationadmin);

				JLabel lblclasse = new JLabel("Classe : "+((Utilisateur) comboBox.getSelectedItem()).getClassemodif());
				lblclasse.setBounds(453, 259, 160, 14);
				frame.getContentPane().add(lblclasse);

				frame.repaint();

			}
		});
		btnSelect.setBounds(488, 114, 147, 37);
		frame.getContentPane().add(btnSelect);

		JButton btnretour = new JButton("retour");
		btnretour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrateur u=new Administrateur(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub

			}

		});
		btnretour.setBounds(0, 0, 89, 38);
		frame.getContentPane().add(btnretour);
		
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
		btnRefresh.setBounds(331, 114, 147, 38);
		frame.getContentPane().add(btnRefresh);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(0, 0, 995, 43);
		frame.getContentPane().add(lblNewLabel);





	}

	public void run(Utilisateur user) {
		try {
			absence window = new absence(user);
			window.frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
