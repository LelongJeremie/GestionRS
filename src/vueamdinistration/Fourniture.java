package vueamdinistration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTree;

public class Fourniture {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fourniture window = new Fourniture();
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
	public Fourniture() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1039, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GERER LES FOURNITURES");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		lblNewLabel.setBounds(367, 11, 297, 41);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(85, 63, 847, 470);
		frame.getContentPane().add(table);
	}
}
