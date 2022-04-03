package vueprofprincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import accueil.Administrateur;
import accueil.Utilisateur;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PopupProfprinc {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					PopupProfprinc window = new PopupProfprinc(user);
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
	public PopupProfprinc(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rendez vous pris !");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblNewLabel.setBounds(121, 46, 186, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdvprofprincipal u=new rdvprofprincipal(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnNewButton.setBounds(143, 105, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	public void run(Utilisateur user) {
		try {
			PopupProfprinc window = new PopupProfprinc(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
