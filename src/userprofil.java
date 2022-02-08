import java.awt.EventQueue;

import javax.swing.JFrame;

public class userprofil {

	private JFrame frame;

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
		
		
		
		
		System.out.println(user.getPrenom()+user.getNom());
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run(Utilisateur user) {
		try {
			userprofil window = new userprofil(user);
			window.frame.setVisible(true);
		} catch (Exception e) {



		}

	}}
