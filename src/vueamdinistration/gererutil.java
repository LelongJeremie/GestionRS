package vueamdinistration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class gererutil{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gererutil window = new gererutil();
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
	public gererutil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("gerer les \u00E9l\u00E8ves");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(226, 11, 203, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("modifier");
		btnNewButton.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(148, 129, 105, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("supprimer");
		btnNewButton_1.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(263, 129, 105, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 60, 643, 58);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton_2 = new JButton("affecter a ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(378, 129, 105, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnReturn = new JButton("page pr\u00E9cedente");
		btnReturn.setBounds(10, 480, 129, 38);
		frame.getContentPane().add(btnReturn);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}


}
