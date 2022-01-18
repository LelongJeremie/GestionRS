import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;

public class inscription {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscription window = new inscription();
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
	public inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setBounds(247, 38, 227, 95);
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		frame.getContentPane().add(lblInscription);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(350, 0, 20, 182);
		frame.getContentPane().add(verticalStrut);
	}

	public void run() {
		try {
			inscription window = new inscription();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
