package vueprof;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import accueil.Administrateur;
import accueil.Prof;
import accueil.Utilisateur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class absence {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					absence window = new absence(user);
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
	public absence(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Absence et retard");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(223, 11, 239, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(223, 169, 223, 32);
		frame.getContentPane().add(comboBox);
		JRadioButton rdbtnAbsence = new JRadioButton("Absence");
		JRadioButton rdbtnRetard = new JRadioButton("Retard");
		
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
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAbsence);
		group.add(rdbtnRetard);

		rdbtnAbsence.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		rdbtnAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAbsence.setBounds(139, 99, 111, 23);
		frame.getContentPane().add(rdbtnAbsence);

		rdbtnRetard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRetard.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		rdbtnRetard.setBounds(407, 99, 111, 23);
		frame.getContentPane().add(rdbtnRetard);

	}

	public void run(Utilisateur user) {
		try {
			absence window = new absence(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
