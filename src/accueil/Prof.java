package accueil;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import vueprof.gclasse;

import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

public class Prof {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					Prof window = new Prof(user);
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
	public Prof(Utilisateur user) {
		initialize(user);
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPlanning = new JButton("Planning");
		btnPlanning.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlanning.setBounds(202, 115, 275, 59);
		frame.getContentPane().add(btnPlanning);
		
		JLabel lblNewLabel = new JLabel("Professeur");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(265, 51, 142, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAbsence = new JButton("Absence et retard");
		btnAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbsence.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnAbsence.setBounds(202, 255, 275, 70);
		frame.getContentPane().add(btnAbsence);
		
		JButton btnClasse = new JButton("Classe");
		btnClasse.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gclasse v=new gclasse(user);
					v.run(user);
					frame.setVisible(false);
					this.dispose();
		
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnClasse.setBounds(202, 185, 275, 59);
		frame.getContentPane().add(btnClasse);
		
		JButton btnSanction = new JButton("Sanction");
		btnSanction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSanction.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnSanction.setBounds(202, 336, 275, 59);
		frame.getContentPane().add(btnSanction);
		
		JButton btnFourniture = new JButton("Fourniture");
		btnFourniture.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnFourniture.setBounds(202, 406, 275, 59);
		frame.getContentPane().add(btnFourniture);
	}

	public void run(Utilisateur user) {
		try {
			Prof window = new Prof(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
