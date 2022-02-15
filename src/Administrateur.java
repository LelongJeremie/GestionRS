import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrateur {

	JFrame frame;
	private int id;
	private String nom;
	private String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					Administrateur window = new Administrateur(user);
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
	public Administrateur(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {
		
		Connexion unid = new Connexion();
		id = Connexion.envoieid();
		nom = Connexion.envoinom();
		email = Connexion.envoiemail();
		
		System.out.println(id);
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 770, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrateur");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 24));
		lblNewLabel.setBounds(216, 31, 303, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Gerer utilisateurs");
		btnNewButton.setBounds(216, 356, 303, 69);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Creation profil");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creaprofiladmin g=new Creaprofiladmin(user);
				g.run(user);
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_2.setBounds(216, 185, 303, 69);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mon profil");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				
				userprofil g=new userprofil(user);
				g.run(user);
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub

			
				
			}
		});
		btnNewButton_3.setBounds(26, 47, 160, 52);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Deconnexion");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {Connexion u=new Connexion();
			u.run();
			frame.setVisible(false);
			this.dispose();

		}

		private void dispose() {
			// TODO Auto-generated method stub
			
		}
			
		});
		btnNewButton_1.setBounds(586, 526, 160, 52);
		frame.getContentPane().add(btnNewButton_1);
	}

	public void run(Utilisateur user) {
		try {
			Administrateur window = new Administrateur(user);
			window.frame.setVisible(true);
		} catch (Exception e) {



		}
	}
}
