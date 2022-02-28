import java.awt.EventQueue;
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

public class adminuserprofil {

	private JFrame frame;
	private ResultSet resultat;
	private JTextField FieldPrenom;
	private JTextField Fieldprenom;
	private JTextField FieldMail;
	private JTextField fieldDatenaissance;
	private JTextField fieldpassword;
	private JTextField FieldPseudo;

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
		comboBox.setBounds(0, 11, 767, 98);
		frame.getContentPane().add(comboBox);
		
		
		
		
		try {
			while(resultat.next()){
				


				
				user.setIdmodif(resultat.getString("id"));
				user.setNommodif(resultat.getString("nom"));
				user.setPrenommodif(resultat.getString("prenom"));
				user.setMailmodif(resultat.getString("mail"));
				user.setPasswordmodif(resultat.getString("password"));
				user.setRolemodif(resultat.getString("role"));
				user.setDate_naissancemodif(resultat.getString("date_naissance"));
				user.setPseudomodif(resultat.getString("username"));
				
				
				
		       

				comboBox.addItem(user);   
				 
				 comboBox.addActionListener(new ActionListener() {     
				     public void actionPerformed(ActionEvent e) {
				        System.out.println("Valeur: " + comboBox.getSelectedItem().toString());      
				     }
				   });
				  
				 	user.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
					user.setNommodif(((Utilisateur) comboBox.getSelectedItem()).getNommodif());
					user.setPrenommodif(((Utilisateur) comboBox.getSelectedItem()).getPrenommodif());
					user.setMailmodif(((Utilisateur) comboBox.getSelectedItem()).getMailmodif());
					user.setPasswordmodif(((Utilisateur) comboBox.getSelectedItem()).getPasswordmodif());
					user.setRolemodif(((Utilisateur) comboBox.getSelectedItem()).getRolemodif());
					user.setDate_naissancemodif(((Utilisateur) comboBox.getSelectedItem()).getDate_naissancemodif());
					user.setPseudomodif(((Utilisateur) comboBox.getSelectedItem()).getPseudomodif());
			
					
				   frame.getContentPane().add(comboBox); 
				   frame.setSize(250, 250); 
				   frame.show();
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
				JButton btnSelect = new JButton("Selectionner");
				btnSelect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						man.selectmodifprofiladmin(user);
						
						
						
						
						
						
						FieldPrenom = new JTextField(user.getPrenommodif());
						FieldPrenom.setBounds(69, 156, 115, 27);
						frame.getContentPane().add(FieldPrenom);
						FieldPrenom.setColumns(10);
						
						Fieldprenom = new JTextField();
						Fieldprenom.setColumns(10);
						Fieldprenom.setBounds(264, 159, 115, 27);
						frame.getContentPane().add(Fieldprenom);
						
						FieldMail = new JTextField(user.getMail());
						FieldMail.setColumns(10);
						FieldMail.setBounds(445, 159, 115, 27);
						frame.getContentPane().add(FieldMail);
						
						fieldDatenaissance = new JTextField(user.getPrenommodif());
						fieldDatenaissance.setColumns(10);
						fieldDatenaissance.setBounds(69, 234, 115, 27);
						frame.getContentPane().add(fieldDatenaissance);
						
						fieldpassword = new JTextField(user.getPasswordmodif());
						fieldpassword.setColumns(10);
						fieldpassword.setBounds(264, 237, 115, 27);
						frame.getContentPane().add(fieldpassword);
						
						FieldPseudo = new JTextField(user.getPseudomodif());
						FieldPseudo.setColumns(10);
						FieldPseudo.setBounds(445, 237, 115, 27);
						frame.getContentPane().add(FieldPseudo);
						
						frame.repaint();
						
						
						
					}
				});
				btnSelect.setBounds(777, 42, 108, 37);
				frame.getContentPane().add(btnSelect);
				
				
	}

	public void run(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}
}
