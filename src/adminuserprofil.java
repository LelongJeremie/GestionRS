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
		frame.setBounds(100, 100, 683, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 11, 176, 98);
		frame.getContentPane().add(comboBox);
		
		JButton btnSelect = new JButton("Selectionner");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				FieldPrenom = new JTextField();
				FieldPrenom.setBounds(69, 156, 115, 27);
				frame.getContentPane().add(FieldPrenom);
				FieldPrenom.setColumns(10);
				
				Fieldprenom = new JTextField();
				Fieldprenom.setColumns(10);
				Fieldprenom.setBounds(264, 159, 115, 27);
				frame.getContentPane().add(Fieldprenom);
				
				FieldMail = new JTextField();
				FieldMail.setColumns(10);
				FieldMail.setBounds(445, 159, 115, 27);
				frame.getContentPane().add(FieldMail);
				
				fieldDatenaissance = new JTextField();
				fieldDatenaissance.setColumns(10);
				fieldDatenaissance.setBounds(69, 234, 115, 27);
				frame.getContentPane().add(fieldDatenaissance);
				
				fieldpassword = new JTextField();
				fieldpassword.setColumns(10);
				fieldpassword.setBounds(264, 237, 115, 27);
				frame.getContentPane().add(fieldpassword);
				
				FieldPseudo = new JTextField();
				FieldPseudo.setColumns(10);
				FieldPseudo.setBounds(445, 237, 115, 27);
				frame.getContentPane().add(FieldPseudo);
				
				frame.repaint();
				
				
				
			}
		});
		btnSelect.setBounds(326, 42, 108, 37);
		frame.getContentPane().add(btnSelect);
		
		
		
		
		try {
			while(resultat.next()){
				System.out.println(resultat.getString("id"));
				 comboBox.addItem("ID = "+resultat.getString(1)+" // Nom = "+resultat.getString(2)+" Prenom = "+resultat.getString(3));   
				 
				 comboBox.addActionListener(new ActionListener() {     
				     public void actionPerformed(ActionEvent e) {
				        System.out.println("Valeur: " + comboBox.getSelectedItem().toString());      
				     }
				   });
				  
				 
				user.setIdmodif(resultat.getString(1));
				System.out.println(user.getIdmodif());
				
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
		
	}

	public void run(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}
}
