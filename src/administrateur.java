import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrateur {

	private JFrame frame;
	private int id;
	private String nom;
	private String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrateur window = new Administrateur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Administrateur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
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
				Creaprofiladmin g=new Creaprofiladmin();
				g.run();
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
		btnNewButton_3.setBounds(26, 47, 160, 52);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Deconnexion");
		btnNewButton_1.setBounds(586, 526, 160, 52);
		frame.getContentPane().add(btnNewButton_1);
	}

	public void run() {
		try {
			Administrateur window = new Administrateur();
			window.frame.setVisible(true);
		} catch (Exception e) {



		}
	}
}
