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
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPrenom = new JLabel("Prenom : "+ user.getPrenom());
		lblPrenom.setBounds(89, 58, 49, 14);
		frame.getContentPane().add(lblPrenom);
		
		fieldprenom = new JTextField();
		fieldprenom.setBounds(89, 85, 96, 20);
		frame.getContentPane().add(fieldprenom);
		fieldprenom.setColumns(10);
		
		JButton btnPrenom = new JButton("Changer le prenom");
		btnPrenom.setBounds(89, 116, 89, 23);
		frame.getContentPane().add(btnPrenom);
		
		fieldnom = new JTextField();
		fieldnom.setColumns(10);
		fieldnom.setBounds(212, 85, 96, 20);
		frame.getContentPane().add(fieldnom);
		
		btnChangerLeNom = new JButton("Changer le nom");
		btnChangerLeNom.setBounds(212, 116, 89, 23);
		frame.getContentPane().add(btnChangerLeNom);
		
		lblNom = new JLabel("Nom :");
		lblNom.setBounds(212, 56, 49, 14);
		frame.getContentPane().add(lblNom);
		
		fieldrole = new JTextField();
		fieldrole.setColumns(10);
		fieldrole.setBounds(329, 85, 96, 20);
		frame.getContentPane().add(fieldrole);
		
		btndatenaissance = new JButton("Changer la date de naissance");
		btndatenaissance.setBounds(329, 116, 89, 23);
		frame.getContentPane().add(btndatenaissance);
		
		lbldatenaissance = new JLabel("Date de naissance : ");
		lbldatenaissance.setBounds(329, 56, 49, 14);
		frame.getContentPane().add(lbldatenaissance);
		
		fieldmail = new JTextField();
		fieldmail.setColumns(10);
		fieldmail.setBounds(329, 203, 96, 20);
		frame.getContentPane().add(fieldmail);
		
		btnPrenom_3 = new JButton("Changer le mail");
		btnPrenom_3.setBounds(329, 234, 89, 23);
		frame.getContentPane().add(btnPrenom_3);
		
		lblmail = new JLabel("mail : ");
		lblmail.setBounds(329, 174, 63, 14);
		frame.getContentPane().add(lblmail);
		
		fieldusername = new JTextField();
		fieldusername.setColumns(10);
		fieldusername.setBounds(89, 203, 96, 20);
		frame.getContentPane().add(fieldusername);
		
		btnusername = new JButton("Changer le prenom");
		btnusername.setBounds(89, 234, 89, 23);
		frame.getContentPane().add(btnusername);
		
		lblusername = new JLabel("Pseudo : ");
		lblusername.setBounds(89, 174, 49, 14);
		frame.getContentPane().add(lblusername);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(212, 203, 96, 20);
		frame.getContentPane().add(textField_5);
		
		btnMotdepasse = new JButton("Changer le mot de passe");
		btnMotdepasse.setBounds(212, 234, 89, 23);
		frame.getContentPane().add(btnMotdepasse);
		
		lblPassword = new JLabel("Mot de passe : ");
		lblPassword.setBounds(212, 174, 49, 14);
		frame.getContentPane().add(lblPassword);
	}

	public void run(Utilisateur user) {
		try {
			userprofil window = new userprofil(user);
			window.frame.setVisible(true);
		} catch (Exception e) {



		}

	}	
}
