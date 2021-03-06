package accueil;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class userprofil {

	private JFrame frame;
	private JTextField fieldprenom;
	private JTextField fieldnom;
	private JButton btnChangerLeNom;
	private JLabel lblNom;
	private JTextField fielddatenaissance;
	private JButton btndatenaissance;
	private JLabel lbldatenaissance;
	private JTextField fieldmail;
	private JButton btnPrenom_3;
	private JLabel lblmail;
	private JTextField fieldusername;
	private JButton btnusername;
	private JLabel lblusername;
	private JTextField textField_5;
	private JButton btnMotdepasse;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private Object a;

			public void run(Utilisateur user) {
				try {
					userprofil window = new userprofil(user);
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


	public userprofil(Utilisateur user) {

		initialize(user);




		System.out.println(user.getPrenom()+user.getNom());


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Utilisateur user) {
		manager man = new manager();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 625, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		

		fieldprenom = new JTextField(user.getPrenom());
		fieldprenom.setBounds(20, 85, 158, 20);
		frame.getContentPane().add(fieldprenom);
		fieldprenom.setColumns(10);

		JButton btnPrenom = new JButton("Changer le prenom");
		btnPrenom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prenom = fieldprenom.getText();
				user.setPrenom(prenom);

			 try {
				man.modificationprofil(user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnPrenom.setBounds(20, 116, 158, 23);
		frame.getContentPane().add(btnPrenom);

		fieldnom = new JTextField(user.getNom());
		fieldnom.setColumns(10);
		fieldnom.setBounds(212, 85, 158, 20);
		frame.getContentPane().add(fieldnom);

		btnChangerLeNom = new JButton("Changer le nom");
		btnChangerLeNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = fieldnom.getText();
				user.setNom(nom);

				try {
					man.modificationprofil(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnChangerLeNom.setBounds(212, 116, 158, 23);
		frame.getContentPane().add(btnChangerLeNom);

		

		fielddatenaissance = new JTextField(user.getDate_naissance());
		fielddatenaissance.setColumns(10);
		fielddatenaissance.setBounds(412, 85, 165, 20);
		frame.getContentPane().add(fielddatenaissance);

		btndatenaissance = new JButton("Changer la date de naissance");
		btndatenaissance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String datenaissance = fielddatenaissance.getText();
				user.setDate_naissance(datenaissance);

				try {
					man.modificationprofil(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btndatenaissance.setBounds(412, 116, 165, 23);
		frame.getContentPane().add(btndatenaissance);

		
		fieldmail = new JTextField(user.getMail());
		fieldmail.setColumns(10);
		fieldmail.setBounds(412, 203, 165, 20);
		frame.getContentPane().add(fieldmail);

		btnPrenom_3 = new JButton("Changer le mail");
		btnPrenom_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = fieldmail.getText();
				user.setMail(mail);

				try {
					man.modificationprofil(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrenom_3.setBounds(412, 234, 165, 23);
		frame.getContentPane().add(btnPrenom_3);

	

		fieldusername = new JTextField(user.getPseudo());
		fieldusername.setColumns(10);
		fieldusername.setBounds(20, 203, 158, 20);
		frame.getContentPane().add(fieldusername);

		btnusername = new JButton("Changer le prenom");
		btnusername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = fieldnom.getText();
				user.setNom(nom);

				try {
					man.modificationprofil(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println(user.getPopup());

				if(user.getPopup()=="modificationprofil") {



					JLabel lblmodificationprofil = new JLabel("Modification effectu\u00E9 sur votre profil!");
					lblmodificationprofil.setForeground(new Color(255, 0, 0));
					lblmodificationprofil.setFont(new Font("Calibri", Font.PLAIN, 16));
					lblmodificationprofil.setBounds(166, 283, 374, 44);
					frame.getContentPane().add(lblmodificationprofil);


				}

				frame.repaint();
			}
		});
		btnusername.setBounds(20, 234, 158, 23);
		frame.getContentPane().add(btnusername);

		

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(212, 203, 158, 20);
		frame.getContentPane().add(textField_5);

		btnMotdepasse = new JButton("Changer le mot de passe");
		btnMotdepasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMotdepasse.setBounds(212, 234, 158, 23);
		frame.getContentPane().add(btnMotdepasse);

		lblPassword = new JLabel("Mot de passe :"+ user.getPassword());
		lblPassword.setBounds(212, 174, 158, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
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
		btnRetour.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRetour.setBounds(10, 11, 107, 36);
		frame.getContentPane().add(btnRetour);


	}

	public void run(Utilisateur user) {
		try {
			userprofil window = new userprofil(user);
			window.frame.setVisible(true);
		} catch (Exception e) {



		}

	}
}
