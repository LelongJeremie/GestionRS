import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class motdepasse {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					motdepasse window = new motdepasse();
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
	public motdepasse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(472, 247, 120, 35);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(38, 247, 436, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnModifierVotreMot = new JTextPane();
		txtpnModifierVotreMot.setFont(new Font("Calibri Light", Font.PLAIN, 30));
		txtpnModifierVotreMot.setText("Modifier votre Mot de passe ");
		txtpnModifierVotreMot.setBounds(155, 165, 362, 58);
		frame.getContentPane().add(txtpnModifierVotreMot);
	}
}
