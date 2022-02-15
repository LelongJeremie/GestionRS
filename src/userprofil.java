import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
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
		frame.setBounds(100, 100, 625, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblPrenom = new JLabel("Prenom : "+ user.getPrenom());
		lblPrenom.setBounds(20, 58, 165, 14);
		frame.getContentPane().add(lblPrenom);

		fieldprenom = new JTextField();
		fieldprenom.setBounds(20, 85, 158, 20);
		frame.getContentPane().add(fieldprenom);
		fieldprenom.setColumns(10);

		JButton btnPrenom = new JButton("Changer le prenom");
		btnPrenom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prenom = fieldprenom.getText();
				user.setPrenom(prenom);

				man.modificationprofil(user);
			}
		});
		btnPrenom.setBounds(20, 116, 158, 23);
		frame.getContentPane().add(btnPrenom);

		fieldnom = new JTextField();
		fieldnom.setColumns(10);
		fieldnom.setBounds(212, 85, 158, 20);
		frame.getContentPane().add(fieldnom);

		btnChangerLeNom = new JButton("Changer le nom");
		btnChangerLeNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = fieldnom.getText();
				user.setNom(nom);

				man.modificationprofil(user);
			}
		});
		btnChangerLeNom.setBounds(212, 116, 158, 23);
		frame.getContentPane().add(btnChangerLeNom);

		lblNom = new JLabel("Nom :"+user.getNom());
		lblNom.setBounds(212, 56, 148, 14);
		frame.getContentPane().add(lblNom);

		fielddatenaissance = new JTextField();
		fielddatenaissance.setColumns(10);
		fielddatenaissance.setBounds(412, 85, 165, 20);
		frame.getContentPane().add(fielddatenaissance);

		btndatenaissance = new JButton("Changer la date de naissance");
		btndatenaissance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String datenaissance = fielddatenaissance.getText();
				user.setDate_naissance(datenaissance);

				man.modificationprofil(user);
			}
		});
		btndatenaissance.setBounds(412, 116, 165, 23);
		frame.getContentPane().add(btndatenaissance);

		lbldatenaissance = new JLabel("Date de naissance : "+ user.getDate_naissance());
		lbldatenaissance.setBounds(412, 58, 165, 14);
		frame.getContentPane().add(lbldatenaissance);

		fieldmail = new JTextField();
		fieldmail.setColumns(10);
		fieldmail.setBounds(412, 203, 165, 20);
		frame.getContentPane().add(fieldmail);

		btnPrenom_3 = new JButton("Changer le mail");
		btnPrenom_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = fieldmail.getText();
				user.setMail(mail);

				man.modificationprofil(user);
			}
		});
		btnPrenom_3.setBounds(412, 234, 165, 23);
		frame.getContentPane().add(btnPrenom_3);

		lblmail = new JLabel("mail : "+user.getMail());
		lblmail.setBounds(412, 184, 165, 14);
		frame.getContentPane().add(lblmail);

		fieldusername = new JTextField();
		fieldusername.setColumns(10);
		fieldusername.setBounds(20, 203, 158, 20);
		frame.getContentPane().add(fieldusername);

		btnusername = new JButton("Changer le prenom");
		btnusername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = fieldnom.getText();
				user.setNom(nom);

				man.modificationprofil(user);

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

		lblusername = new JLabel("Pseudo : "+user.getPseudo());
		lblusername.setBounds(20, 174, 158, 14);
		frame.getContentPane().add(lblusername);

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
