package vueamdinistration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class administration {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administration window = new administration();
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
	public administration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1022, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(367, 11, 251, 77);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CLASSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(367, 91, 251, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ELEVE");
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton_1.setBounds(367, 174, 251, 60);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("FOURNITURE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton_2.setBounds(367, 258, 251, 60);
		frame.getContentPane().add(btnNewButton_2);
	}
}
