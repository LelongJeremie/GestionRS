import java.awt.EventQueue;

import javax.swing.JFrame;

public class administrateur {

	private JFrame frame;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administrateur window = new administrateur();
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
	public administrateur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		connexion unid = new connexion();
		id = connexion.envoieid();
		
		System.out.println(id);
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		try {
			administrateur window = new administrateur();
			window.frame.setVisible(true);
		} catch (Exception e) {



		}
	}

}
