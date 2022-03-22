package accueil;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import vueadmin.Creaprofiladmin;
import vueadmin.adminuserprofil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 770, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrateur");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 756, 110);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Gerer utilisateurs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminuserprofil g=new adminuserprofil(user);
				g.run1(user);
				frame.setVisible(false);
				this.dispose();
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
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
			public void actionPerformed(ActionEvent e) {index u=new index();
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setBounds(0, 495, 756, 108);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void run(Utilisateur user) {
		try {
			Administrateur window = new Administrateur(user);
			window.frame.setVisible(true);
		} catch (Exception e) {



		}
	}
}
