package accueil;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import vueprof.Fourniture;
import vueprof.GestionARS;
import vueprof.absence;
import vueprof.gclasse;
import vueprof.planning;
import vueprof.sanction;

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
		frame.setBounds(100, 100, 692, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPlanning = new JButton("Planning");
		btnPlanning.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 planning v=new planning(user);
					v.run(user);
					frame.setVisible(false);
					this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
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
				absence v=new absence(user);
				v.run(user);
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
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
				sanction v=new sanction(user);
				v.run(user);
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnSanction.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnSanction.setBounds(202, 336, 275, 59);
		frame.getContentPane().add(btnSanction);
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
		btnNewButton_1.setBounds(508, 485, 160, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnFourniture = new JButton("Fourniture");
		btnFourniture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fourniture v=new Fourniture(user);
				v.run(user);
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnFourniture.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnFourniture.setBounds(202, 406, 275, 59);
		frame.getContentPane().add(btnFourniture);
		
		JButton btnGestionARS = new JButton("Gestion A/R/S");
		btnGestionARS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionARS v=new GestionARS(user);
				v.run(user);
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			
			}
		});
		btnGestionARS.setFont(new Font("Calibri Light", Font.BOLD, 22));
		btnGestionARS.setBounds(487, 293, 181, 70);
		frame.getContentPane().add(btnGestionARS);
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
