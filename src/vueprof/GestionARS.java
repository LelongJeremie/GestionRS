package vueprof;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import accueil.Prof;
import accueil.Utilisateur;
import accueil.index;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionARS {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					GestionARS window = new GestionARS(user);
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
	 */
	public GestionARS(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 685, 726);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Gestion Absence Retard Sanction");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(0, 0, 671, 85);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnretour = new JButton("Retour");
		btnretour.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnretour.addActionListener(new ActionListener() {
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
		btnretour.setBounds(10, 11, 113, 38);
		frame.getContentPane().add(btnretour);
		
		JButton btntoabs = new JButton("Absence");
		btntoabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					gestionabs v=new gestionabs(user);
					v.run(user);
					frame.setVisible(false);
					this.dispose();
				}

				private void dispose() {
					// TODO Auto-generated method stub
					
				
				}
			
		});
		btntoabs.setBounds(195, 152, 266, 67);
		frame.getContentPane().add(btntoabs);
		
		JButton btntosanc = new JButton("Sanction");
		btntosanc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Gestionsanc v=new Gestionsanc(user);
				v.run(user);
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			
			
			}
		});
		btntosanc.setBounds(195, 450, 266, 67);
		frame.getContentPane().add(btntosanc);
		
		JButton btntoret_1 = new JButton("Retard");
		btntoret_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Gestionret v=new Gestionret(user);
				v.run(user);
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			
			
			}
		});
		btntoret_1.setBounds(195, 296, 266, 67);
		frame.getContentPane().add(btntoret_1);
		
	}

	public void run(Utilisateur user) {
		try {
			GestionARS window = new GestionARS(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
