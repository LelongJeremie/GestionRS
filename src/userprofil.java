import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class userprofil {

	private JFrame frame;
	private JTextField fieldprenom;
	private JTextField fieldnom;
	private JButton btnChangerLeNom;
	private JLabel lblNom;
	private JTextField fieldrole;
	private JButton btndatenaissance;
	private JLabel lbldatenaissance;
	private JTextField fieldmail;
	private JButton btnPrenom_3;
	private JLabel lblmail;
	private JTextField fieldusername;
	private JButton btnusername;
	private JLabel lblusername;
	private JTextField textField_5;
	private JButton btnMotdepasse;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private Object a;

			public void run(Utilisateur user) {
				try {
					userprofil window = new userprofil(user);
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
	 * @param a 
	 */
	public userprofil(Utilisateur user) {
		initialize();
		initialize(user);
		
		
		
		
		System.out.println(user.getPrenom()+user.getNom());
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run(Utilisateur user) {
		try {
			userprofil window = new userprofil(user);
			window.frame.setVisible(true);
		} catch (Exception e) {



		}

	}}
