package vueamdinistration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class classe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					classe window = new classe();
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
	public classe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1039, 678);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION DES CLASSES");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		lblNewLabel.setBounds(378, 11, 260, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 63, 1003, 70);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("supprimer");
		btnNewButton.setBounds(287, 144, 114, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("modifier");
		btnNewButton_1.setBounds(411, 144, 114, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ajouter une classe");
		btnNewButton_2.setBounds(535, 144, 121, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
