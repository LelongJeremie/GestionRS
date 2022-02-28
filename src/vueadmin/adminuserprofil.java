package vueadmin;
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

import accueil.Utilisateur;
import accueil.manager;


public class adminuserprofil {

	private JFrame frame;
	private ResultSet resultat;
	private ResultSet resultatclasse;
	private JTextField FieldPrenom;
	private JTextField Fieldprenom;
	private JTextField FieldMail;
	private JTextField fieldDatenaissance;
	private JTextField fieldpassword;
	private JTextField FieldPseudo;
	private int i;
	private Utilisateur Monuser= new Utilisateur();
	private classe Userclasse = new classe(); 
	private JComboBox comboboxvalidation;
	private JComboBox comboBox_1;
	private JLabel lblRole;
	private JTextField Fieldnom;

	/**
	 * Launch the application.
	 */

	public void run1(Utilisateur user) {
		try {
			adminuserprofil window = new adminuserprofil(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub

	}



	/**
	 * Create the application.
	 * @param user 
	 */
	public adminuserprofil(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {

		manager man = new manager();

		resultat = man.test();









		frame = new JFrame();
		frame.setBounds(100, 100, 909, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox<Utilisateur> comboBox = new JComboBox();
		comboBox.setBounds(10, 25, 975, 78);
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
				Monuser.setDate_naissancemodif(resultat.getString("date_naissance"));
				Monuser.setPseudomodif(resultat.getString("username"));
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
				comboboxvalidation.setModel(new DefaultComboBoxModel(new String[] {"D\u00E9savtiv\u00E9", "En cours d'activation", "Activ\u00E9"}));
				comboboxvalidation.setBounds(662, 281, 115, 22);
				frame.getContentPane().add(comboboxvalidation);

				JLabel lblValidation = new JLabel("Validation : ");
				lblValidation.setBounds(661, 259, 93, 14);
				frame.getContentPane().add(lblValidation);

				comboBox_1 = new JComboBox();
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Prof. Principal", "Prof.", "Administration", "Parent", "Eleve"}));
				comboBox_1.setBounds(241, 281, 160, 22);
				frame.getContentPane().add(comboBox_1);

				lblRole = new JLabel("Role :");
				lblRole.setBounds(241, 259, 49, 14);
				frame.getContentPane().add(lblRole);

				JButton btnModificationadmin = new JButton("Modification");
				btnModificationadmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					Monuser.setNommodif(""+Fieldnom);
					Monuser.setPrenommodif(""+FieldPrenom);
					Monuser.setMailmodif(""+FieldMail);
					Monuser.setDate_naissance(""+fieldDatenaissance);
					Monuser.setPseudomodif(""+FieldPseudo);
					Monuser.setPasswordmodif(""+fieldpassword);
					Monuser.setRole(((Utilisateur) comboBoxclasse.getSelectedItem()).getPasswordmodif());
					
					
					
					
					
					
						
						




					}
				});
				btnModificationadmin.setBounds(488, 337, 108, 37);
				frame.getContentPane().add(btnModificationadmin);

				frame.repaint();

			}
		});
		btnSelect.setBounds(488, 114, 108, 37);
		frame.getContentPane().add(btnSelect);





	}

	public void run(Utilisateur user) {
		try {
			adminuserprofil window = new adminuserprofil(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
