package accueil;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import vueprofprincipal.rdvprofprincipal;

public class Profprinc {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				// TODO Auto-generated method stub
				
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
	public Profprinc(Utilisateur user) {
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
		btnNewButton_1.setBounds(476, 455, 160, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Planning");
		btnNewButton.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(236, 197, 206, 59);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Professeur Principal");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(265, 51, 142, 35);
		frame.getContentPane().add(lblNewLabel);
		
		
		JButton btnNewButton_11 = new JButton("Rendez-vous");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				rdvprofprincipal v=new rdvprofprincipal(user);
				v.run(user);
				frame.setVisible(false);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_11.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnNewButton_11.setBounds(201, 116, 275, 70);
		frame.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_2 = new JButton("Classee");
		btnNewButton_2.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(255, 267, 170, 59);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sanction ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnNewButton_3.setBounds(265, 337, 153, 59);
		frame.getContentPane().add(btnNewButton_3);
		
	}
	

	public void run(Utilisateur user) {
		try {
			Profprinc window = new Profprinc(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
