package vueprof;

import java.awt.EventQueue;

import javax.swing.JFrame;

import accueil.Utilisateur;
import javax.swing.JLabel;
import java.awt.Font;

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
		frame.setBounds(100, 100, 685, 726);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblgestionARS = new JLabel("Gestion Absence Retard Sanction");
		lblgestionARS.setFont(new Font("Calibri Light", Font.BOLD, 27));
		lblgestionARS.setBounds(157, 26, 412, 48);
		frame.getContentPane().add(lblgestionARS);
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
