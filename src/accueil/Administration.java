package accueil;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import vueamdinistration.ClasseA;
import vueamdinistration.Fourniture;
import vueamdinistration.gererutil;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administration {

	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					Administration window = new Administration(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void dispose() {
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
	public Administration(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administation");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(242, 127, 184, 39);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
		
		
		
		JButton btnClasse = new JButton("CLASSE");
		btnClasse.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnClasse.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				
				ClasseA v=new ClasseA ();
				v.run();
				frame.setVisible(false);
				this.dispose();
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}

			
		});
		btnClasse.setBounds(178, 177, 309, 57);
		frame.getContentPane().add(btnClasse);
		
		
		
		
		
		
		
		JButton btnEleve = new JButton("ELEVE");
		btnEleve.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnEleve.setBounds(178, 247, 309, 55);
		frame.getContentPane().add(btnEleve);
		btnEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gererutil v=new gererutil ();
				v.run();
				frame.setVisible(false);
				this.dispose();
				
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {index u=new index();
			u.run();
			frame.setVisible(false);
			this.dispose();
		}
		private void dispose() {
			// TODO Auto-generated method stub
		}
		});
		btnDeconnexion.setBounds(490, 465, 160, 52);
		frame.getContentPane().add(btnDeconnexion);
		
		
		
		
		
		
		
		
		
		
		
		JButton btnFourniture = new JButton("FOURNITURE");
		btnFourniture.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnFourniture.setBounds(178, 313, 309, 57);
		frame.getContentPane().add(btnFourniture);
		btnFourniture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Fourniture v=new Fourniture ();
				v.run();
				frame.setVisible(false);
				this.dispose();
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		
<<<<<<< Updated upstream
		btnNewButton_3.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		btnNewButton_3.setBounds(178, 245, 309, 55);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(178, 311, 309, 57);
		frame.getContentPane().add(btnNewButton_2);
=======
>>>>>>> Stashed changes
	}
	
	
	
	
	
	
	
	
	

	public void run(Utilisateur user) {
		try {
			Administration window = new Administration(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
