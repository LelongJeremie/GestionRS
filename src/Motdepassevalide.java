import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Motdepassevalide {

	private JFrame frame;
	private JTextField textFieldValider;
	private JTextField textFieldValidermdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Motdepassevalide window = new Motdepassevalide();
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
	public Motdepassevalide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 738, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntrezcode = new JLabel("Entrez le code obtenu par le mail : ");
		lblEntrezcode.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrezcode.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblEntrezcode.setBounds(207, 23, 291, 117);
		frame.getContentPane().add(lblEntrezcode);
		
		textFieldValider = new JTextField();
		textFieldValider.setBounds(207, 116, 291, 42);
		frame.getContentPane().add(textFieldValider);
		textFieldValider.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilisateur user = new Utilisateur();
				user.setToken(textFieldValider.getText());
				
				manager man = new manager();
				man.validercode(user);
			}
		});
		btnValider.setBounds(301, 413, 113, 42);
		frame.getContentPane().add(btnValider);
		
		textFieldValidermdp = new JTextField();
		textFieldValidermdp.setBounds(207, 301, 291, 42);
		frame.getContentPane().add(textFieldValidermdp);
		textFieldValidermdp.setColumns(10);
		
		JLabel lblValider = new JLabel("Entrez votre nouveau mot de passe :");
		lblValider.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblValider.setHorizontalAlignment(SwingConstants.CENTER);
		lblValider.setBounds(210, 236, 291, 32);
		frame.getContentPane().add(lblValider);
	}

	public void run() {
		try {
			Motdepassevalide window = new Motdepassevalide();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
