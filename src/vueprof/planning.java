package vueprof;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import accueil.Administrateur;
import accueil.Prof;
import accueil.Utilisateur;

public class planning {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					planning window = new planning(user);
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
	public planning(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 694, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(10, 11, 116, 36);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Prof u=new Prof(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();
	
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		frame.getContentPane().setLayout(null);
		btnRetour.setFont(new Font("Calibri", Font.PLAIN, 12));
		frame.getContentPane().add(btnRetour);

	}

	public void run(Utilisateur user) {
		try {
			planning window = new planning(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
