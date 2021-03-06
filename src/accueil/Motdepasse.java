package accueil;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Motdepasse {

	private JFrame frame;
	private JTextField textFieldmdpmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Motdepasse window = new Motdepasse();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Motdepasse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 679, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnretour = new JButton("Retour");
		btnretour.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnretour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			index u=new index();
				u.run();
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub

			}


		});
		btnretour.setBounds(10, 11, 113, 38);
		frame.getContentPane().add(btnretour);
		JButton btnNewButton = new JButton("valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilisateur user = new Utilisateur();

				user.setMail(textFieldmdpmail.getText());
				System.out.println(user.getMail());
				manager man = new manager();
				man.envoyermail(user.getMail());
				
				Motdepassevalide g=new Motdepassevalide();
				g.run();
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(283, 350, 120, 35);
		frame.getContentPane().add(btnNewButton);

		textFieldmdpmail = new JTextField();
		textFieldmdpmail.setBounds(110, 239, 466, 35);
		frame.getContentPane().add(textFieldmdpmail);
		textFieldmdpmail.setColumns(10);

		JLabel lblmdpmail = new JLabel("Entrez votre mail pour changer votre mot de passe");
		lblmdpmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblmdpmail.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblmdpmail.setBounds(110, 129, 466, 35);
		frame.getContentPane().add(lblmdpmail);
	}

	public void run() {
		try {
			Motdepasse window = new Motdepasse();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
