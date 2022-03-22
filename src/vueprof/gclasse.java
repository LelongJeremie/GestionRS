package vueprof;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import accueil.Administrateur;
import accueil.Prof;
import accueil.Utilisateur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gclasse {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					gclasse window = new gclasse(user);
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
	public gclasse(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 672, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Classe");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(0, 0, 658, 59);
		frame.getContentPane().add(lblNewLabel);
		JButton btnRetour = new JButton("Retour");
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
		btnRetour.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRetour.setBounds(10, 11, 107, 36);
		frame.getContentPane().add(btnRetour);

	}

	public void run(Utilisateur user) {
		try {
			gclasse window = new gclasse(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
